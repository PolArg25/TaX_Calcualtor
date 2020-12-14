package manageData;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		ArrayList<String[]> pol = new ArrayList<String[]>();
		TaxConsultant consultant = new TaxConsultant();
		String file[] = {"txt"};
		String namefile = "giorgos.xml";
		String delete[] = {"18"};  
		String receipt[] = {"80","pol","pol","pol","pol","pol","pol","pol","pol"};
		consultant.loadFile("zarras.xml");
		consultant.loadFile("130456099_INFO.txt");
		consultant.loadFile("kostas.xml");
		consultant.loadFile("stav.xml");
		consultant.loadFile(namefile);
		pol = consultant.chooseTaxPayer("130456099");
		//if(pol==null){
			//System.out.println("o forologoumenos DEN uparxei sthn lista");
		//}
		//else{
			//System.out.println("o forologoumenos uparxei sthn lista");
		//}
		//consultant.removeTaxPayer("130456095"); //stav
		//consultant.removeTaxPayer("130456093"); //zarras //otan kanei delete den ginetai na aposurthei to findtaxPayer kai etsi kai tropoipoihsoyme to arxeio eite eisagwntas eite eksagwntas tha tropopoihthei to arxeio
		//System.out.println(consultant.removeTaxPayer("130456099")); //pol
		
		//consultant.processingTaxPayer("a", receipt);
		//consultant.processingTaxPayer("b", delete);
		consultant.processingTaxPayer("c", file);
	}

}
