package manageData;

import java.util.ArrayList;

public class HeadïfHousehold extends TaxPayer {
	private double basicTax;
	private double income;
	
	public HeadïfHousehold(ArrayList<String[]> informationOfTaxPayer) {
		super(informationOfTaxPayer);
		String nameAfmStatusIncome[] = super.getNameAfmStatusIncome();
		income = Double.parseDouble(nameAfmStatusIncome[3].trim());
		calculateBasicTax();
	}

	public double calculateBasicTax(){
		if(income <= 30390){
			basicTax = 0.0535*income;
			System.out.println(basicTax);
		}
		else if(income <= 90000){
			basicTax = 1625.87 + 0.0705*(income - 30390);
		}
		else if(income <= 122110){
			basicTax = 5828.38 + 0.0705*(income - 90000);
		}
		else if(income <= 203390){
			basicTax = 8092.13 + 0.0785*(income - 122110);
		}
		else{
			basicTax = 14472.61 + 0.0985*(income - 203390);
		}
		super.calculateTotalTax(basicTax);
		return basicTax;
	}
}


