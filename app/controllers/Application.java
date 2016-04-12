package controllers;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.logging.KettleLogStore;
import org.pentaho.di.core.logging.LogLevel;
import org.pentaho.di.core.logging.LoggingBuffer;
import org.pentaho.di.job.Job;
import org.pentaho.di.job.JobMeta;
import org.pentaho.di.job.entries.trans.JobEntryTrans;
import org.pentaho.di.job.entry.JobEntryCopy;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransListener;
import org.pentaho.di.trans.TransMeta;
import org.pentaho.di.trans.step.StepMetaDataCombi;

import com.fasterxml.jackson.databind.ObjectMapper;

import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class Application extends Controller {

	public static Hashtable<Integer, UtilityTransformation> utilityHash = new Hashtable<Integer, UtilityTransformation>();

	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

	public static void populateHashUtils(){
		for (UtilityTransformation ut:UtilityTransformations.values()){
			utilityHash.put(Integer.valueOf(ut.getId()), ut);
		}
	}
	/**
	 * receiving xml file content
	 * @return the pentaho result
	 */
	public static Result getAndRunXMLContent() {

		// body = received file
		//String body = request().body().asFormUrlEncoded().get("data")[0];
		String body = request().body().asJson().get("data").toString();
		body = body.substring(1, body.length()-1);
		System.out.println("body= "+body);
		// fileName = received fine name
		//String fileName = request().body().asFormUrlEncoded().get("FName")[0];
		String fileName = request().body().asJson().get("FName").toString();
		fileName = fileName.substring(1, fileName.length()-1);
		System.out.println("filename= "+fileName);
		// confirmedFileName variable to confirm that received file is one among tpcdi ETLs
		String confirmedFileName = "";              
		String res = "";

		// Open database connection
		Connection c = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://"+Play.application().configuration()
							.getString("mydb.ip")+":"+Play.application().configuration()
							.getString("mydb.port")+"/"+Play.application().configuration()
							.getString("mydb.name"),
							Play.application().configuration()
							.getString("mydb.user"), Play.application().configuration()
							.getString("mydb.pass"));
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");


			// RUN PreUtility ETLs
			//int preInitUtilArrayLength = Integer.parseInt(request().body().asFormUrlEncoded().get("preInitUtilArrayLength")[0]);
			int preInitUtilArrayLength = request().body().asJson().get("preInitUtilArrayLength").asInt();
			System.out.println("preInitUtilArrayLength= "+preInitUtilArrayLength);
			for (int i = 0; i < preInitUtilArrayLength; i++) {
				//variable for SQL statement
				Statement stmt = null;

				//int utilityETLId = Integer.valueOf(request().body().asFormUrlEncoded().get("preInitUtilArray[]")[i]);
				int utilityETLId = request().body().asJson().get("preInitUtilArray["+i+"]").asInt();

				System.out.println("Utility ETL array element for PreUtil = "+utilityETLId);

				//UtilityTransformation ut = utilityHash.get(utilityETLId);
				for (UtilityTransformation ut:UtilityTransformations.values()){
					if (ut.getId() == utilityETLId) {
						System.out.println("Utility ETL filepath = " + ut.getFile()[1]);
						stmt = c.createStatement();		
						// executing SQL query
						ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS rowcount FROM "+ut.getFile()[0]);
						rs.next();           
						if (rs.getInt("rowcount") > 0) {	
							System.out.println("I am executing PreInitUtility Transformation");
							runBasicTransformation(ut.getFile(), "0,0");			
							confirmedFileName = fileName;
						}						
						rs.close();
					}
				}
				stmt.close();
			}

			// RUN Utility ETLs
			//int initUtilArrayLength = Integer.parseInt(request().body().asFormUrlEncoded().get("initUtilArrayLength")[0]);

			int initUtilArrayLength = request().body().asJson().get("initUtilArrayLength").asInt();
			System.out.println("initUtilArrayLength= "+initUtilArrayLength);
			for (int i = 0; i < initUtilArrayLength; i++) {
				//variable for SQL statement
				Statement stmt = null;

				//int utilityETLId = Integer.valueOf(request().body().asFormUrlEncoded().get("initUtilArray[]")[i]);
				int utilityETLId = request().body().asJson().get("initUtilArray["+i+"]").asInt();

				System.out.println("Utility ETL array element for Util = "+utilityETLId);

				for (UtilityTransformation ut:UtilityTransformations.values()){
					if (ut.getId() == utilityETLId) {
						System.out.println("Utility ETL filepath = " + ut.getFile()[1]);
						stmt = c.createStatement();		
						// executing SQL query
						ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS rowcount FROM "+ut.getFile()[0]);
						rs.next();   
						System.out.println("rowcount"+rs.getInt("rowcount"));
						if (rs.getInt("rowcount") == 0) {	
							System.out.println("I am executing InitUtility Transformation");				
							runBasicTransformation(ut.getFile(), "0.0");			
							//confirmedFileName = fileName;
						}						
						rs.close();
					}
				}	
				stmt.close();
			}

			// Executing ETLs to make specific data dirty
			//dataUtilArray.get(key).get(0) = null values percentage
			//dataUtilArray.get(key).get(1) = scale factor
			ObjectMapper mapper = new ObjectMapper();
			Map<String, ArrayList<Double>> dataUtilArray = mapper.convertValue(request().body().asJson().get("DataUtils"), Map.class);	
			for (String key : dataUtilArray.keySet()){
				for (DataUtilityETL du:DataUtilityETLs.values()){
					if (du.getId() == Integer.parseInt(key)) {	
						if (du.getDescription().equals("trans")){
							runBasicTransformation(du.getFile(), String.valueOf(dataUtilArray.get(key).get(0)));
						}else if(du.getDescription().equals("job")){
							runBasicJob(du.getFile(), String.valueOf(dataUtilArray.get(key).get(0)));
						}
					}
				}
			}


			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}         
		confirmedFileName = fileName;
		// checking if a file is a job or a transformation
		if (confirmedFileName.substring(confirmedFileName.length()-3).equals("ktr")){
			System.out.println("I am running a transformation");
			res = runTransformation(body);
		} else if (confirmedFileName.substring(confirmedFileName.length()-3).equals("kjb")){
			System.out.println("I am running a job");
			res = runJobFromFileSystem(body);
		}else {
			flash("error", "Wrong file format");
		}

		// checking for body existence
		if (body != null) {
			System.out.println("getAndRunXMLContent(): "+ "I am printing the body: " + body);
		} else {
			flash("error", "Missing file");
			return ok("Missing file");
		}

		return ok(res);

	}


	public static void runBasicTransformation(String[] file, String param) {
		try {
			// initialize kettle environment
			KettleEnvironment.init();
			TransMeta metadata = new TransMeta(file[1]);
			Trans trans = new Trans(metadata);
			trans.setLogLevel(LogLevel.MINIMAL);

			trans.setParameterValue("dirty_per", param);
			// Execute the transformation
			trans.execute(null);

			trans.waitUntilFinished();   
		} catch (KettleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void runBasicJob(String[] file, String param){
		try {
			JobMeta jobMeta = new JobMeta(file[1], null);
			jobMeta.setParameterValue("dirty_per", param);
			Job job = new Job(null, jobMeta);
			job.setLogLevel(LogLevel.DETAILED);
			job.setInteractive(true);
			job.start();
			job.waitUntilFinished();
		} catch (Exception e) {
			// something went wrong, just log and return 
			e.printStackTrace();
		} 
	}

	/** 
	 * This method executes a job defined in a kjb file
	 * 
	 * It demonstrates the following:
	 * 
	 * - Loading a job definition from a kjb file
	 * - Setting named parameters for the job
	 * - Setting the log level of the job
	 * - Executing the job, waiting for it to finish
	 * - Examining the result of the job
	 * 
	 * @param filename the file containing the job to execute (kjb file)
	 * @return the job that was executed, or null if there was an error
	 */
	public static String runJobFromFileSystem(String filename) {

		try {

			StringBuffer sb = new StringBuffer();
			// Loading the job file from file system into the JobMeta object.
			// The JobMeta object is the programmatic representation of a job definition.
			JobMeta jobMeta = new JobMeta(filename, null);

			/*
			// The next section reports on the declared parameters and sets them to arbitrary values
			// for demonstration purposes
			System.out.println("Attempting to read and set named parameters");
			String[] declaredParameters = jobMeta.listParameters();
			for (int i = 0; i < declaredParameters.length; i++) {
				String parameterName = declaredParameters[i];

				// determine the parameter description and default values for display purposes
				String description = jobMeta.getParameterDescription(parameterName);
				String defaultValue = jobMeta.getParameterDefault(parameterName);
				// set the parameter value to an arbitrary string
				String parameterValue =  RandomStringUtils.randomAlphanumeric(10);

				String output = "Setting parameter "+parameterName+" to \""+parameterValue+"\" [description: \""+description+"\", default: \""+defaultValue+"\"]";
				System.out.println(output);

				// assign the value to the parameter on the job
				jobMeta.setParameterValue(parameterName, parameterValue);

			}*/

			// Creating a Job object which is the programmatic representation of a job 
			// A Job object can be executed, report success, etc.
			Job job = new Job(null, jobMeta);

			// adjust the log level
			job.setLogLevel(LogLevel.DETAILED);

			job.setInteractive(true);

			System.out.println("\nStarting job");

			// starting the job, which will execute asynchronously
			job.start();

			TransListener listen;
			Map<JobEntryCopy,JobEntryTrans> transFromJob = job.getActiveJobEntryTransformations();

			// waiting for the job to finish
			job.waitUntilFinished();

			String read = job.getResult().getXML();
			// retrieve the result object, which captures the success of the job
			//Result result = job.getResult();

			//final List<RowMetaAndData> read;
			//read = job.getResult().getRows();

			// report on the outcome of the job
			String outcome = "\nJob ,"+ filename+",executed with result:,";
			//System.out.println(outcome);
			//System.out.println("!!!!!***** Results *****!!!!! "+read);

			return outcome;

		} catch (Exception e) {

			// something went wrong, just log and return 
			e.printStackTrace();
			return null;
		} 

	}


	/**
	 * running pentaho kettle transformation
	 * @param file (ktr) in a string format
	 * @return execution time
	 */
	public static String runTransformation(String file) {

		/*Connection c = null;
		Statement stmt = null;
		try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://"+Play.application().configuration()
                            .getString("mydb.ip")+":"+Play.application().configuration()
                            .getString("mydb.port")+"/"+Play.application().configuration()
                            .getString("mydb.name"),
                            Play.application().configuration()
                            .getString("mydb.user"), Play.application().configuration()
                            .getString("mydb.pass"));
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();

            // выполняем запрос delete SQL
            //stmt.execute("DELETE FROM dw_supplier");
            //System.out.println("Record is deleted from dw_supplier table!");

            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }*/


		try {
			System.out.println("runTransformation(): " + "I enter the method");
			StringBuffer sb = new StringBuffer();

			//stringbuffer for null rows counting sql query
			//StringBuffer sb1 = new StringBuffer();

			// initializing kettle environment
			KettleEnvironment.init();

			TransMeta metadata = new TransMeta(file);
			Trans trans = new Trans(metadata);

			//trans.setParameterValue("dirty_per", "0.15");


			trans.setLogLevel(LogLevel.DETAILED);
			// Execute the transformation
			trans.execute(null);

			trans.waitUntilFinished();

			LoggingBuffer appender = KettleLogStore.getAppender();
			// retrieve logging lines for transformation
			String logText = appender.getBuffer(trans.getLogChannelId(), false).toString();
			// checking for errors
			if (trans.getErrors() > 0) {
				return  "Erroruting Transformation";
			}
			//writing each step metrics to the stringbuffer
			sb.append("Step_name,").append("Copy_nr,").append("Read,").append("Written,").append("Input,").append("Output,").append("Updated,").append("Rejected,").append("Errors,").append("Status,").append("Runtime").append("\t");
			for (StepMetaDataCombi combi : trans.getSteps()) {
				sb.append(combi.stepname).append(',').append(combi.step.getCopy()).append(',').append(combi.step.getLinesRead()).append(',').append(combi.step.getLinesWritten()).append(',').append(combi.step.getLinesInput()).append(',').append(combi.step.getLinesOutput()).append(',').append(combi.step.getLinesUpdated()).append(',').append(combi.step.getLinesRejected()).append(',').append(combi.step.getErrors()).append(',').append(combi.step.getStatus()).append(',').append(combi.step.getRuntime()).append("\t");
			}

			/*try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://52.28.66.240:5432/tpch",
                                "tpch", "pentaho");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT COUNT (*) AS totalNullValues FROM dw_supplier WHERE s_suppkey IS NULL OR s_name IS NULL OR s_address is NULL OR s_nationkey IS NULL OR s_phone IS NULL OR s_comment IS NULL OR s_acctbal IS NULL ");
                while ( rs.next() ) {
                    int totalNullValues = rs.getInt("totalNullValues");
                    sb1.append(totalNullValues);
                }
                ResultSet rs1 = stmt.executeQuery("SELECT * FROM dw_supplier");
                int counterNullValues = 0;
                while ( rs1.next() ) {
                    if (rs1.wasNull()) counterNullValues++;
                }
                sb.append("Number of Null values in the OUTPUT table: ").append(counterNullValues).append(" + ").append(sb1).append("\n");
                rs.close();
                stmt.close();
                c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName()+": "+ e.getMessage() );
                System.exit(0);
            }*/
			return (sb.toString());

		} catch (KettleException ex) {
			return ex.getMessage();
		}
	}


}
