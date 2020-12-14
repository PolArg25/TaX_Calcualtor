package manageData;

import java.util.ArrayList;

public class TaxPayer {
	private String nameAfmStatusIncome[] = new String[4];
	private double[] entertainmentBasicTravelHealthOtherReceipts = new double[5];
	private ArrayList<String[]> informationForTaxPayer;
	private double totalReceiptsGathered;
	private double income;
	private double basicTaxAndTotalTax[] = new double[2];
	
	public TaxPayer(ArrayList<String[]> informationOfTaxPayer){
		this.informationForTaxPayer = informationOfTaxPayer;
		getReceipts();
	}

	public String[] getNameAfmStatusIncome(){
		for(String[] k: informationForTaxPayer){
			for(int i=0;i<4;i++){
				nameAfmStatusIncome[i] = k[i];
			}
			break;
		}
		income = Double.parseDouble(nameAfmStatusIncome[3].trim());
		return nameAfmStatusIncome;
	}
	
	public double[] getReceipts(){
		int counter = 0;
		String trimString = null;
		for(int i=0;i<5;i++){
			entertainmentBasicTravelHealthOtherReceipts[i] = 0;
		}
		for(String[] k: informationForTaxPayer){
			if (counter == 0){
				counter = 1;
				continue;
			}
			trimString=k[3].trim();
			if(k[2].contains("Entertainment")){
				entertainmentBasicTravelHealthOtherReceipts[0] += Double.parseDouble(trimString);
			}
			else if(k[2].contains("Basic")){
				entertainmentBasicTravelHealthOtherReceipts[1] += Double.parseDouble(trimString);
			}
			else if(k[2].contains("Travel")){
			entertainmentBasicTravelHealthOtherReceipts[2] += Double.parseDouble(trimString);
			}
			else if(k[2].contains("Health")){
				entertainmentBasicTravelHealthOtherReceipts[3] += Double.parseDouble(trimString);
			}
			else{
				entertainmentBasicTravelHealthOtherReceipts[4] += Double.parseDouble(trimString);
			}
		}
		return entertainmentBasicTravelHealthOtherReceipts;
	}
	
	public double calculateTotalReceiptsGathered(){
		totalReceiptsGathered = 0;
		for(int i=0;i<5;i++){
			totalReceiptsGathered += entertainmentBasicTravelHealthOtherReceipts[i];
		}
		return totalReceiptsGathered;
	}
	
	public void calculateTotalTax(double basicTax){
		this.basicTaxAndTotalTax[0] = basicTax;
		if(totalReceiptsGathered <= 0.2*income){
			basicTaxAndTotalTax[1] = basicTax + 0.08*basicTax;
		}
		else if(totalReceiptsGathered <= 0.4*income){
			basicTaxAndTotalTax[1] = basicTax + 0.04*basicTax;
		}
		else if(totalReceiptsGathered <= 0.6*income){
			basicTaxAndTotalTax[1] = basicTax - 0.15*basicTax;
		}
		else{
			basicTaxAndTotalTax[1] = basicTax - 0.30*basicTax;
		}
		
	}
	
	public double[] returnBasicTaxAndTotalTax(){
		return basicTaxAndTotalTax;
	}
}
