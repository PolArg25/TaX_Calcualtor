package manageData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReceiptsFile {
	private String nameFile;
	private PrintWriter outputWriter = null;
	
	public ReceiptsFile(String nameFile){
		this.nameFile = nameFile;
	}

	public void addReceiptInFile(String newReceipt[]){
		try{
			outputWriter = new PrintWriter(new FileOutputStream(nameFile, true));
		}
		catch(FileNotFoundException e){
			System.err.print("error opening file");
		}
		if(nameFile.contains("txt")){
			AddInTxtFile(newReceipt);
		}
		else{
			AddInXmlFile(newReceipt);
		}
		outputWriter.close();
	}
	
	private void AddInTxtFile(String newReceipt[]){
		outputWriter.println("\n");
		outputWriter.println("ReceiptID: "+newReceipt[0]); 
		outputWriter.println("Date: "+newReceipt[1]); 
		outputWriter.println("Kind: " +newReceipt[2]); 
		outputWriter.println("Amount: "+newReceipt[3]); 
		outputWriter.println("Company: "+newReceipt[4]); 
		outputWriter.println("Country: "+newReceipt[5]); 
		outputWriter.println("City: "+newReceipt[6]); 
		outputWriter.println("Street: "+newReceipt[7]);
		outputWriter.println("Number: "+newReceipt[8]);
		outputWriter.flush();
	}
	
	private void AddInXmlFile(String newReceipt[]){
		outputWriter.println("\n");
		outputWriter.println("<ReceiptID> "+newReceipt[0]+" </ReceiptID>"); 
		outputWriter.println("<Date> "+newReceipt[1]+" </Date>"); 
		outputWriter.println("<Kind> " +newReceipt[2]+ " </Kind>"); 
		outputWriter.println("<Amount> "+newReceipt[3]+" </Amount>"); 
		outputWriter.println("<Company> "+newReceipt[4]+" </Company>"); 
		outputWriter.println("<Country> "+newReceipt[5]+" </Country>"); 
		outputWriter.println("<City> "+newReceipt[6]+" </City>"); 
		outputWriter.println("<Street> "+newReceipt[7]+" </Street>");
		outputWriter.println("<Number> "+newReceipt[8]+" </Number>");
		outputWriter.flush();
	}
	
	public void deleteReceiptInFile(String receiptId[]){
		try {
            File inFile = new File(nameFile);
            if (!inFile.isFile()){
                System.out.println("Parameter is not an existing file");
                return;
            }
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");// Construct the new file that will later be renamed to the original
            BufferedReader reader = new BufferedReader(new FileReader(nameFile));
            PrintWriter writer = new PrintWriter(new FileWriter(tempFile));
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (!line.contains("ID") || !line.contains(receiptId[0])) {
                    writer.println(line);
                    writer.flush();
                }
                else{
                	for(int i=0;i<8;i++){
                		line = reader.readLine();
                	}
                }
            }
            writer.close();
            reader.close();

            // Delete the original file
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            // Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile))
                System.out.println("Could not rename file");

        } 
		catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
		catch (IOException ex) {
            ex.printStackTrace();
        }
    }


	
	
}
