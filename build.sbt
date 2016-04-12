name := "elastic-slave"

version := "1.0-SNAPSHOT"

resolvers += "Pentaho Maven2 Repository" at "http://repository.pentaho.org/artifactory/repo"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "org.postgresql" % "postgresql" % "9.3-1100-jdbc41",
  "pentaho-kettle" % "kettle-core" % "5.3.0.0-200",
  "pentaho-kettle" % "kettle-dbdialog" % "5.3.0.0-180",
  "pentaho-kettle" % "kettle-engine" % "5.3.0.0-200",
  "pentaho-kettle" % "kettle5-log4j-plugin" % "5.2.1.0-148"
)     

play.Project.playJavaSettings
