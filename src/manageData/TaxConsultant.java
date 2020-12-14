package manageData;

import ImportFile.ParserTxt;
import ImportFile.ParserXml;
import java.util.*;
import exportData.ExportData;


public class TaxConsultant {
	private ArrayList<String[]> nameAfmStatusIncomeForAll = new ArrayList<String[]>();  
	private ArrayList<ArrayList<String[]>> receiptsForAll = new ArrayList<ArrayList<String[]>>();
	private ArrayList<String[]> informationForTaxPayer;
	private String statusForTaxPayer = new String();
	private int counterFindTaxPayer;
	private ArrayList<String> nameFiles = new ArrayList<String>();
	private ReceiptsFile receiptsFile;
	private ParserTxt parserTxt;
	private ParserXml parserXml;
	
	public void loadFile(String nameFile){
		if(nameFile.contains("txt")){
			 parserTxt = new ParserTxt(nameFile);
			 nameFiles.add(nameFile);
			 nameAfmStatusIncomeForAll.add(parserTxt.readNameAfmStatusIncome());
			 receiptsForAll.add(parserTxt.readReceipts());
		}
		else{
			parserXml = new ParserXml(nameFile);
			nameFiles.add(nameFile);
			nameAfmStatusIncomeForAll.add(parserXml.readNameAfmStatusIncome());
			receiptsForAll.add(parserXml.readReceipts());
		}
	}
	
	public ArrayList<String[]> chooseTaxPayer(String AfmForTaxPayer){
		informationForTaxPayer = new ArrayList<String[]>();
		counterFindTaxPayer = 0;
		for(String[] k: nameAfmStatusIncomeForAll){
			if(k[1].contains(AfmForTaxPayer)){
				statusForTaxPayer = k[2];
				informationForTaxPayer.add(k);
				informationForTaxPayer.addAll(receiptsForAll.get(counterFindTaxPayer));
				receiptsFile = new ReceiptsFile(nameFiles.get(counterFindTaxPayer));
				break;
			}
			else{
				counterFindTaxPayer += 1;
			}
		}
		return informationForTaxPayer;
	}
	
	public void processingTaxPayer(String choice, String elementsToProcessing[]){
		switch(choice){
		case "a" :
			addReceiptInList(elementsToProcessing);
			receiptsFile.addReceiptInFile(elementsToProcessing);
			break;
		case "b" :
			removeReceiptInList(elementsToProcessing);
			receiptsFile.deleteReceiptInFile(elementsToProcessing);
			break;
		case "c" :
			ExportData exportData = new ExportData(returnTaxPayer());
			if(elementsToProcessing != null){
				String filePathForLogFile[] = getFilePath().split("_");
				exportData.createLogFile(filePathForLogFile[0]+"_LOG."+elementsToProcessing[0]);
			}
			break;
		}
	}
	
	private void addReceiptInList(String[] element){
		int counter=0;
		for(ArrayList<String[]> k: receiptsForAll){
			if(counter == counterFindTaxPayer){
				k.add(element);
			}
				counter++;
			}
		informationForTaxPayer.add(element);
	}	
	
	private void removeReceiptInList(String[] element){	
			int counter = 0;
			for(ArrayList<String[]> k: receiptsForAll){
				if(counter == counterFindTaxPayer){
					for(String[] l: k){
						if(l[0].contains(element[0])){
							k.remove(l);
							break;
						}
					}
					break;
				}
				counter++;
			}
			for(String[] m: informationForTaxPayer){
				if(m[0].contains(element[0])){
					informationForTaxPayer.remove(m);
					break;
				}
			}
	}
	
	private TaxPayer returnTaxPayer(){
		if(statusForTaxPayer.contains("HeadïfHousehold")){
			HeadïfHousehold client = new HeadïfHousehold(informationForTaxPayer);
			return client;
		}
		else if(statusForTaxPayer.contains("Jointly")){
			MarriedFilingJointly client = new MarriedFilingJointly(informationForTaxPayer);
			return client;
		}
		else if(statusForTaxPayer.contains("Separately")){
			MarriedFilingSeparately client = new MarriedFilingSeparately(informationForTaxPayer);
			return client;
		}
		else{
			Single client = new Single(informationForTaxPayer);
			return client;
		}
		
	}
	
	public void removeTaxPayer(String AfmForTaxPayer){
		int counterDeleteTaxPayer = 0;
		for(String[] k: nameAfmStatusIncomeForAll){
			if(k[1].contains(AfmForTaxPayer)){
				nameAfmStatusIncomeForAll.remove(k);
				nameFiles.remove(counterDeleteTaxPayer);
				receiptsForAll.remove(receiptsForAll.get(counterDeleteTaxPayer));
				break;
			}
			counterDeleteTaxPayer += 1;
		}
	}
	
	public String getFilePath(){
		return(nameFiles.get(counterFindTaxPayer));
	}
}

