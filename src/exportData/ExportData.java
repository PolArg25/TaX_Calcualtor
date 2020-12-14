package exportData;

import manageData.TaxPayer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.jfree.chart.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class ExportData {
	private String nameAfmStatusIncome[] = new String[4];
	private double basicTaxAndTotalTax[];
	private double totalReceiptsGathered;
	private double totalReceipts[];
	private Double taxIncrease;
	private PrintWriter outputWriter = null;
	
	public ExportData(TaxPayer taxPayer){
		this.nameAfmStatusIncome = taxPayer.getNameAfmStatusIncome();
		this.totalReceipts = taxPayer.getReceipts();
		this.totalReceiptsGathered = taxPayer.calculateTotalReceiptsGathered();
		this.basicTaxAndTotalTax = taxPayer.returnBasicTaxAndTotalTax();
		displayReseiptsDataSet();
		displayTaxChartDataSet();
	}
	
	private void displayReseiptsDataSet(){
		DefaultPieDataset reseiptsDataSet = new DefaultPieDataset();
		reseiptsDataSet.setValue("Entertainment",totalReceipts[0]);
		reseiptsDataSet.setValue("Basic",totalReceipts[1]);
		reseiptsDataSet.setValue("Travel",totalReceipts[2]);
		reseiptsDataSet.setValue("Health",totalReceipts[3]);
		reseiptsDataSet.setValue("Other",totalReceipts[4]);
		JFreeChart pieChart = ChartFactory.createPieChart (
			    "Receipts",   //Chart title
			    reseiptsDataSet,          //Chart Data 
			    true,               // include legend?
			    true,               // include tooltips?
			    false               // include URLs?
			    );
		ChartFrame frame = new ChartFrame("PieChart", pieChart);
		frame.pack();
		frame.setVisible(true);
	}
	
	private void displayTaxChartDataSet(){
		taxIncrease = basicTaxAndTotalTax[1] - basicTaxAndTotalTax[0];
		DefaultCategoryDataset objTaxDataSet = new DefaultCategoryDataset();
		objTaxDataSet.setValue(basicTaxAndTotalTax[0],"Q1","BasicTax");
		objTaxDataSet.setValue(taxIncrease,"Q2","TaxIncrease");
		objTaxDataSet.setValue(basicTaxAndTotalTax[1],"Q3","TotalTax");
		
		JFreeChart barChart = ChartFactory.createBarChart(
			       "Demo Bar Chart",     //Chart title
			    "Tax Elements",     //Domain axis label
			    "Values",         //Range axis label
			    objTaxDataSet,         //Chart Data 
			    PlotOrientation.VERTICAL, // orientation
			    true,             // include legend?
			    true,             // include tooltips?
			    false             // include URLs?
			);
		ChartFrame frame = new ChartFrame("Demo", barChart);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void createLogFile(String nameFile){
		try{
			outputWriter = new PrintWriter(new FileOutputStream(nameFile, true));
		}
		catch(FileNotFoundException e){
			System.err.print("error opening file");
		}
		if(nameFile.contains("txt")){
			createTxtLogFile();
		}
		else{
			createXmlTaxFile();
		}
		closeFile();
	}
	
	public void createTxtLogFile(){
		outputWriter.println("Name: "+nameAfmStatusIncome[0]+"\n"+"AFM: "+nameAfmStatusIncome[1]+"\n"+"Income: " +nameAfmStatusIncome[3]); 
		outputWriter.println("Basic Tax: "+ basicTaxAndTotalTax[0]+"\n"+"Tax Increase: "+taxIncrease+"\n"+"Total Tax: "+basicTaxAndTotalTax[1]); 
		outputWriter.println("Total Receipts Gathered: "+totalReceiptsGathered); 
		outputWriter.println("Entertainment: "+totalReceipts[0]);
		outputWriter.println("Basic: "+totalReceipts[1]);
		outputWriter.println("Travel: "+totalReceipts[2]);
		outputWriter.println("Health: "+totalReceipts[3]);
		outputWriter.println("Other: "+totalReceipts[4]);
		outputWriter.flush();
	}
	
	public void createXmlTaxFile(){
		outputWriter.println("<Name> "+nameAfmStatusIncome[0]+" </Name>"+"\n"+"<AFM> "+nameAfmStatusIncome[1]+" </AFM>"+"\n"+
								"<Income> " +nameAfmStatusIncome[3]+ " </Income>"); 
		outputWriter.println("<BasicTax> "+basicTaxAndTotalTax[0]+" </BasicTax>"+"\n"+"<TaxIncrease> "+taxIncrease+" </TaxIncrease>"+"\n"+
								"<TotalTax> "+basicTaxAndTotalTax[1]+" </TotalTax>"); 
		outputWriter.println("<TotalReceiptsGathered> "+totalReceiptsGathered+" </TotalReceiptsGathered>"); 
		outputWriter.println("<Entertainment> "+totalReceipts[0]+" </Entertainment>"+"\n"+"<Basic> "+totalReceipts[1]+" </Basic>"+"\n"+
								"<Travel> "+totalReceipts[2]+" </Travel>"); 
		outputWriter.println("<Health> "+totalReceipts[1]+" </Health>"+"\n"+"<Other> "+totalReceipts[2]+" </Other>");
		outputWriter.flush();
	}
	
	public void closeFile(){
		outputWriter.close();
	}
}
