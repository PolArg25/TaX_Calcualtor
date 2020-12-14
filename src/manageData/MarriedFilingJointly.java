package manageData;

import java.util.ArrayList;

public class MarriedFilingJointly extends TaxPayer{
	private double basicTax;
	private double income;
	
	public MarriedFilingJointly(ArrayList<String[]> informationOfTaxPayer) {
		super(informationOfTaxPayer);
		String nameAfmStatusIncome[] = super.getNameAfmStatusIncome();
		income = Double.parseDouble(nameAfmStatusIncome[3].trim());
		calculateBasicTax();
		
	}

	private double calculateBasicTax(){
		if(income <= 36080){
			basicTax = 0.03680*income;
		}
		else if(income <= 90000){
			basicTax = 1930.28 + 0.0705*(income - 36080);
		}
		else if(income <= 143350){
			basicTax = 5731.64 + 0.0705*(income - 90000);
		}
		else if(income <= 254240){
			basicTax = 9492.82 + 0.0785*(income - 143350);
		}
		else{
			basicTax = 18197.69 + 0.0985*(income - 254240);
		}
		super.calculateTotalTax(basicTax);
		return basicTax;
	}
}
