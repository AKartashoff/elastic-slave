package controllers;

import play.Play;

public enum UtilityTransformations implements UtilityTransformation {
	
	accountKeysDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from accountkeys table";
		}

		@Override
		public int getId() {
			return 0;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"accountkeys",UtETLspath+"/AccountKeys_Delete.ktr"};
			return s;
		}		
	},
	dimAccountDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from dimaccount table";
		}

		@Override
		public int getId() {
			return 1;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"dimaccount",UtETLspath+"/DimAccount_Delete.ktr"};
			return s;
		}		
	},
	customerKeysDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from customerkeys table";
		}

		@Override
		public int getId() {
			return 2;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"customerkeys",UtETLspath+"/CustomerKeys_Delete.ktr"};
			return s;
		}		
	},
	dimCustomerDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from dimcustomer table";
		}

		@Override
		public int getId() {
			return 3;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"dimcustomer",UtETLspath+"/DimCustomer_Delete.ktr"};
			return s;
		}		
	},
	brokerKeysDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from brokerkeys table";
		}

		@Override
		public int getId() {
			return 4;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"brokerkeys",UtETLspath+"/BrokerKeys_Delete.ktr"};
			return s;
		}		
	},
	dimBrokerDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from dimbroker table";
		}

		@Override
		public int getId() {
			return 5;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"dimbroker",UtETLspath+"/DimBroker_Delete.ktr"};
			return s;
		}		
	},
	companyKeysDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from companykeys table";
		}

		@Override
		public int getId() {
			return 6;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"companykeys",UtETLspath+"/CompanyKeys_Delete.ktr"};
			return s;
		}		
	},
	dimCompanyDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from dimcompany table";
		}

		@Override
		public int getId() {
			return 7;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"dimcompany",UtETLspath+"/DimCompany_Delete.ktr"};
			return s;
		}		
	},
	securityKeysDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from securitykeys table";
		}

		@Override
		public int getId() {
			return 8;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"securitykeys",UtETLspath+"/SecurityKeys_Delete.ktr"};
			return s;
		}		
	},
	dimSecurityDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from dimsecurity table";
		}

		@Override
		public int getId() {
			return 9;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"dimsecurity",UtETLspath+"/DimSecurity_Delete.ktr"};
			return s;
		}		
	},
	dimDateDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from dimdate table";
		}

		@Override
		public int getId() {
			return 10;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"dimdate",UtETLspath+"/DimDate_Delete.ktr"};
			return s;
		}		
	},
	dimTimeDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from dimtime table";
		}

		@Override
		public int getId() {
			return 11;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"dimtime",UtETLspath+"/DimTime_Delete.ktr"};
			return s;
		}		
	},
	dimTradeDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from dimtrade table";
		}

		@Override
		public int getId() {
			return 12;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"dimtrade",UtETLspath+"/DimTrade_Delete.ktr"};
			return s;
		}		
	},
	factCashBalancesDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from factcashbalances table";
		}

		@Override
		public int getId() {
			return 13;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"factcashbalances",UtETLspath+"/FactCashBalances_Delete.ktr"};
			return s;
		}		
	},
	factHoldingsDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from factholdings table";
		}

		@Override
		public int getId() {
			return 14;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"factholdings",UtETLspath+"/FactHoldings_Delete.ktr"};
			return s;
		}		
	},
	financialDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from financial table";
		}

		@Override
		public int getId() {
			return 15;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[]s = {"financial",UtETLspath+"/Financial_Delete.ktr"};
			return s;
		}		
	},
	prospectDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from prospect table";
		}

		@Override
		public int getId() {
			return 16;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"prospect",UtETLspath+"/Prospect_Delete.ktr"};
			return s;
		}		
	},
	
	statusTypeDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from statustype table";
		}

		@Override
		public int getId() {
			return 17;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"statustype",UtETLspath+"/StatusType_Delete.ktr"};
			return s;
		}		
	},
	taxRateDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from taxrate table";
		}

		@Override
		public int getId() {
			return 18;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"taxrate",UtETLspath+"/TaxRate_Delete.ktr"};
			return s;
		}		
	},
	tradeTypeDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from tradetype table";
		}

		@Override
		public int getId() {
			return 19;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"tradetype",UtETLspath+"/TradeType_Delete.ktr"};
			return s;
		}		
	},
	industryDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from industry table";
		}

		@Override
		public int getId() {
			return 20;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"industry",UtETLspath+"/Industry_Delete.ktr"};
			return s;
		}		
	},
	dimCustomer(){

		@Override
		public String getDescription() {	
			return "Populate dimcustomer and customerkeys tables";
		}

		@Override
		public int getId() {
			return 21;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"dimcustomer",UtETLspath+"/DimCustomer.ktr"};
			return s;
		}		
	},
	dimAccount(){

		@Override
		public String getDescription() {	
			return "Populate dimaccount and accountkeys tables";
		}

		@Override
		public int getId() {
			return 22;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"dimaccount",UtETLspath+"/DimAccount.ktr"};
			return s;
		}		
	},
	dimBroker(){

		@Override
		public String getDescription() {	
			return "Populate dimbroker and brokerkeys tables";
		}

		@Override
		public int getId() {
			return 23;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"dimbroker",UtETLspath+"/DimBroker.ktr"};
			return s;
		}		
	},
	taxRate(){

		@Override
		public String getDescription() {	
			return "Populate taxrate table";
		}

		@Override
		public int getId() {
			return 24;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"taxrate",UtETLspath+"/TaxRate.ktr"};
			return s;
		}		
	},
	dimDate(){

		@Override
		public String getDescription() {	
			return "Populate dimDate table";
		}

		@Override
		public int getId() {
			return 25;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"dimdate",UtETLspath+"/DimDate.ktr"};
			return s;
		}		
	},
	dimCompany(){

		@Override
		public String getDescription() {	
			return "Populate dimCompany table";
		}

		@Override
		public int getId() {
			return 26;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"dimcompany",UtETLspath+"/DimCompany.ktr"};
			return s;
		}		
	},
	statusType(){

		@Override
		public String getDescription() {	
			return "Populate statustype table";
		}

		@Override
		public int getId() {
			return 27;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"statustype",UtETLspath+"/StatusType.ktr"};
			return s;
		}		
	},
	factCashBalances(){

		@Override
		public String getDescription() {	
			return "Populate statustype table";
		}

		@Override
		public int getId() {
			return 28;
		}

		@Override
		public String[] getFile() {
			String UtETLspath = Play.application().configuration()
					.getString("UtETLspath");
			String[] s = {"factcashbalances",UtETLspath+"/FactCashBalances.ktr"};
			return s;
		}		
	}	

}
