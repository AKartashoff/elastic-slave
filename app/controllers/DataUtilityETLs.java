package controllers;

import play.Play;

public enum DataUtilityETLs implements DataUtilityETL {

	dimAccountInput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "trans";
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public String[] getFile() {
			String dataUtilETLpath = Play.application().configuration()
					.getString("dataUtilETLpath");
			String[] s = {"dimAccountInput",dataUtilETLpath+"/dimAccountInput.ktr"};
			return s;
		}		
	},

	dimBrokerInput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "trans";
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 1;
		}

		@Override
		public String[] getFile() {
			String dataUtilETLpath = Play.application().configuration()
					.getString("dataUtilETLpath");
			String[] s = {"dimBrokerInput",dataUtilETLpath+"/dimBrokerInput.ktr"};
			return s;
		}		
	},

	dimCompanyInput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "trans";
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 2;
		}

		@Override
		public String[] getFile() {
			String dataUtilETLpath = Play.application().configuration()
					.getString("dataUtilETLpath");
			String[] s = {"dimCompanyInput",dataUtilETLpath+"/dimCompanyInput.ktr"};
			return s;
		}
	},

	dimDateInput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "trans";
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 3;
		}

		@Override
		public String[] getFile() {
			String dataUtilETLpath = Play.application().configuration()
					.getString("dataUtilETLpath");
			String[] s = {"dimDateInput",dataUtilETLpath+"/dimDateInput.ktr"};
			return s;
		}
	},

	dimSecurityInput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "trans";
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 4;
		}

		@Override
		public String[] getFile() {
			String dataUtilETLpath = Play.application().configuration()
					.getString("dataUtilETLpath");
			String[] s = {"dimSecurityInput",dataUtilETLpath+"/dimSecurityInput.ktr"};
			return s;
		}
	},

	dimTimeInput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "trans";
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 5;
		}

		@Override
		public String[] getFile() {
			String dataUtilETLpath = Play.application().configuration()
					.getString("dataUtilETLpath");
			String[] s = {"dimTimeInput",dataUtilETLpath+"/dimTimeInput.ktr"};
			return s;
		}
	},

	factCashBalancesInput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "trans";
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 6;
		}

		@Override
		public String[] getFile() {
			String dataUtilETLpath = Play.application().configuration()
					.getString("dataUtilETLpath");
			String[] s = {"factCashBalancesInput",dataUtilETLpath+"/factCashBalancesInput.ktr"};
			return s;
		}
	},

	FinancialInput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "trans";
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 7;
		}

		@Override
		public String[] getFile() {
			String dataUtilETLpath = Play.application().configuration()
					.getString("dataUtilETLpath");
			String[] s = {"FinancialInput",dataUtilETLpath+"/FinancialInput.ktr"};
			return s;
		}
	},
	IndustryInput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "trans";
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 8;
		}

		@Override
		public String[] getFile() {
			String dataUtilETLpath = Play.application().configuration()
					.getString("dataUtilETLpath");
			String[] s = {"IndustryInput",dataUtilETLpath+"/IndustryInput.ktr"};
			return s;
		}
	},

	jobDimAccountOutput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "job";
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 9;
		}

		@Override
		public String[] getFile() {
			String dataUtilETLpath = Play.application().configuration()
					.getString("dataUtilETLpath");
			String[] s = {"jobDimAccountOutput",dataUtilETLpath+"/jobDimAccountOutput.kjb"};
			return s;
		}
	},

	jobDimBrokerOutput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "job";
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 10;
		}

		@Override
		public String[] getFile() {
			String dataUtilETLpath = Play.application().configuration()
					.getString("dataUtilETLpath");
			String[] s = {"jobDimBrokerOutput",dataUtilETLpath+"/jobDimBrokerOutput.kjb"};
			return s;
		}
	},

	jobDimCompanyOutput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "job";
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 11;
		}

		@Override
		public String[] getFile() {
			String dataUtilETLpath = Play.application().configuration()
					.getString("dataUtilETLpath");
			String[] s = {"jobDimCompanyOutput",dataUtilETLpath+"/jobDimCompanyOutput.kjb"};
			return s;
		}
	},

	jobDimCustomerOutput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "job";
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 12;
		}

		@Override
		public String[] getFile() {
			String dataUtilETLpath = Play.application().configuration()
					.getString("dataUtilETLpath");
			String[] s = {"jobDimCustomerOutput",dataUtilETLpath+"/jobDimCustomerOutput.kjb"};
			return s;
		}
	},

	jobDimDateOutput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "job";
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 13;
		}

		@Override
		public String[] getFile() {
			String dataUtilETLpath = Play.application().configuration()
					.getString("dataUtilETLpath");
			String[] s = {"jobDimDateOutput",dataUtilETLpath+"/jobDimDateOutput.kjb"};
			return s;
		}
	},

	jobDimSecurityOutput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "job";
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 14;
		}

		@Override
		public String[] getFile() {
			String dataUtilETLpath = Play.application().configuration()
					.getString("dataUtilETLpath");
			String[] s = {"jobDimSecurityOutput",dataUtilETLpath+"/jobDimSecurityOutput.kjb"};
			return s;
		}
	},

	jobDimTimeOutput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "job";
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 15;
		}

		@Override
		public String[] getFile() {
			String dataUtilETLpath = Play.application().configuration()
					.getString("dataUtilETLpath");
			String[] s = {"jobDimTimeOutput",dataUtilETLpath+"/jobDimTimeOutput.kjb"};
			return s;
		}
	},

	jobFactCashBalancesOutput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "job";
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 16;
		}

		@Override
		public String[] getFile() {
			String dataUtilETLpath = Play.application().configuration()
					.getString("dataUtilETLpath");
			String[] s = {"jobFactCashBalancesOutput",dataUtilETLpath+"/jobFactCashBalancesOutput.kjb"};
			return s;
		}
	},

	jobStatusTypeOutput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "job";
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 17;
		}

		@Override
		public String[] getFile() {
			String dataUtilETLpath = Play.application().configuration()
					.getString("dataUtilETLpath");
			String[] s = {"jobStatusTypeOutput",dataUtilETLpath+"/jobStatusTypeOutput.kjb"};
			return s;
		}
	},

	jobTaxRateOutput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "job";
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 18;
		}

		@Override
		public String[] getFile() {
			String dataUtilETLpath = Play.application().configuration()
					.getString("dataUtilETLpath");
			String[] s = {"jobTaxRateOutput",dataUtilETLpath+"/jobTaxRateOutput.kjb"};
			return s;
		}
	},

	jobTradeTypeOutput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "job";
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 19;
		}

		@Override
		public String[] getFile() {
			String dataUtilETLpath = Play.application().configuration()
					.getString("dataUtilETLpath");
			String[] s = {"jobTradeTypeOutput",dataUtilETLpath+"/jobTradeTypeOutput.kjb"};
			return s;
		}
	},

	ProspectInput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "trans";
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 20;
		}

		@Override
		public String[] getFile() {
			String dataUtilETLpath = Play.application().configuration()
					.getString("dataUtilETLpath");
			String[] s = {"prospectInput",dataUtilETLpath+"/ProspectInput.ktr"};
			return s;
		}
	},

	StatusTypeInput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "trans";
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 21;
		}

		@Override
		public String[] getFile() {
			String dataUtilETLpath = Play.application().configuration()
					.getString("dataUtilETLpath");
			String[] s = {"statusTypeInput",dataUtilETLpath+"/StatusTypeInput.ktr"};
			return s;
		}	
	},

	TaxRateInput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "trans";
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 22;
		}

		@Override
		public String[] getFile() {
			String dataUtilETLpath = Play.application().configuration()
					.getString("dataUtilETLpath");
			String[] s = {"taxRateInput",dataUtilETLpath+"/TaxRateInput.ktr"};
			return s;
		}
	},

	TradeTypeInput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "trans";
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 23;
		}

		@Override
		public String[] getFile() {
			String dataUtilETLpath = Play.application().configuration()
					.getString("dataUtilETLpath");
			String[] s = {"tradeTypeInput",dataUtilETLpath+"/TradeTypeInput.ktr"};
			return s;
		}
	}
}
