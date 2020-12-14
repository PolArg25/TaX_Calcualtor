package ImportFile;

import java.io.*;
import java.util.*;

public class test {

	public static void main(String[] args) throws IOException {
		ParserXml parserXml = new ParserXml("pol.xml");
		ArrayList<String[]> receipts = new ArrayList<String[]>();
		String test[] = parserXml.readNameAfmStatusIncome();
		for(int i=0;i<4;i++){
			System.out.println(test[i]);
		}
		receipts = parserXml.readReceipts();
		for(String[] t: receipts){
			System.out.println("\n\narraylist:");
			for(int i=0;i<9;i++){
				System.out.println(t[i]);
			}
		}
	}

}
