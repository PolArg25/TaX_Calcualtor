package manageData;

import java.util.ArrayList;

public class MarriedFilingSeparately extends TaxPayer {
	private double basicTax;
	private double income;
	
	public MarriedFilingSeparately(ArrayList<String[]> informationOfTaxPayer) {
		super(informationOfTaxPayer);
		String nameAfmStatusIncome[] = super.getNameAfmStatusIncome();
		income = Double.parseDouble(nameAfmStatusIncome[3].trim());
		calculateBasicTax();
	}

	public double calculateBasicTax(){
		if(income <= 18040){
			basicTax = 0.0535*income;
			System.out.println(basicTax);
		}
		else if(income <= 71680){
			basicTax = 965.14 + 0.0705*(income - 18040);
		}
		else if(income <= 90000){
			basicTax = 4746.76 + 0.0785*(income - 71680);
		}
		else if(income <= 127120){
			basicTax = 6184.88 + 0.0785*(income - 90000);
		}
		else{
			basicTax = 9098.80 + 0.0985*(income - 127120);
		}
		super.calculateTotalTax(basicTax);
		return basicTax;
	}
}
