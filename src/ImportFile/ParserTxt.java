package ImportFile;

import java.io.*;
import java.util.*;

public class ParserTxt {
	private String NameAfmStatusIncome[] = new String[4];
	private ArrayList<String[]> Receipts = new ArrayList<String[]>();
	private File file;
	private String fileName;
	private BufferedReader reader = null;
	String line;
	public ParserTxt(String fileName){
		this.fileName = fileName;
		file=new File(this.fileName);
		try{
			reader=new BufferedReader(new FileReader(file));
		}
		catch(FileNotFoundException e){
            System.err.print("error opening file");
        }
	}
	
	public String[] readNameAfmStatusIncome(){
		String tokens[];
		for(int i=0;i<4;i++){
			try {
				line=reader.readLine();
				tokens=line.split(":");
				NameAfmStatusIncome[i] =  tokens[1];
			} 
			catch(IOException e){
				System.out.println("Error readline");
			}
			
		}
		return NameAfmStatusIncome;
		
		
	}
	
	public ArrayList<String[]> readReceipts(){
		String tokens[];
		String receiptsHelp[] = new String[9];
		int counter = 0;
		try{
			line=reader.readLine();
			while(line != null){
				if(line.isEmpty() || line.equals("Receipts:")){
					receiptsHelp = new String[9];
					counter = 0;
					line=reader.readLine();
				}
				else{
					tokens = line.split(":");
					line=reader.readLine();
					receiptsHelp[counter] = tokens[1];
					counter++;
				}
				if(counter==9){
					Receipts.add(receiptsHelp);
				}
			}
		}
		catch (IOException e) {
			System.out.println("Error readline");
		}
		closeFile();
		return Receipts;
	}
	
	public void closeFile(){
		try {
			reader.close();
		}
		catch(IOException e){
			System.out.println("Error close file");
		}
	}
	
	
}
