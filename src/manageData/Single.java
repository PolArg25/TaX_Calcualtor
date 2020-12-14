package manageData;

import java.util.ArrayList;

public class Single extends TaxPayer {
	private double basicTax;
	private double income;
	
	public Single(ArrayList<String[]> informationOfTaxPayer) {
		super(informationOfTaxPayer);
		String nameAfmStatusIncome[] = super.getNameAfmStatusIncome();
		income = Double.parseDouble(nameAfmStatusIncome[3].trim());
		calculateBasicTax();
	}

	public double calculateBasicTax(){
		if(income <= 24680){
			basicTax = 0.0535*income;
		}
		else if(income <= 81080){
			basicTax = 1320.38 + 0.0705*(income - 24680);
		}
		else if(income <= 90000){
			basicTax = 5296.58 + 0.0785*(income - 81080);
		}
		else if(income <= 152540){
			basicTax = 5996.8 + 0.0785*(income - 90000);
		}
		else{
			basicTax = 10906.19 + 0.0985*(income - 152540);
		}
		super.calculateTotalTax(basicTax);
		return basicTax;
	}
	
	

}


