package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import manageData.TaxConsultant;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.stream.Stream;
import java.io.*;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.TextArea;

public class TaxPayerSelection {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private TextArea textArea;
	private TaxConsultant myclient;
	private String nameLogFile[] = new String[1];
//	private String theChosenFile;
	/**
	 * Launch the application.
	*/ 
	
	/*public static void main(String[] args) {
		try {
			//taxPayerSelection dialog = new taxPayerSelection();
			//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			//dialog.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the application.
	 */
	public TaxPayerSelection(TaxConsultant myclient) {
		this.myclient=myclient;
	//	theChosenFile=file;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 689, 556);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
		 		FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JButton btnAddReceipts = new JButton("Add Receipts");
		frame.getContentPane().add(btnAddReceipts, "2, 2");
		TaxPayerSelection atemporary=this;
		btnAddReceipts.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				MoreReceipts formwindow =new MoreReceipts(myclient,atemporary );
				boolean flg = true;
				formwindow.setVisible(flg);
			}
		});
		String file;
		JButton btnReport = new JButton("Calculate");
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nameLogFile[0] == null){
					myclient.processingTaxPayer("c", null);
				}
				else{
					myclient.processingTaxPayer("c", nameLogFile);
				}
				
				
			}
		});
		
		JLabel lblEnterTheId = new JLabel("      Remove the receipt ");
		frame.getContentPane().add(lblEnterTheId, "2, 6");
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String removereceipt[] = {null,null,null,null,null,null,null,null,null};
				removereceipt[0]= textField_1.getText();
				myclient.processingTaxPayer("b", removereceipt);
				String File=myclient.getFilePath();
				readAndDisplayFile(File);
				
				
			}
		});
		frame.getContentPane().add(textField_1, "4, 6, 11, 1, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblEnterTheReceipt = new JLabel("Enter the receipt id");
		frame.getContentPane().add(lblEnterTheReceipt, "16, 6");
		frame.getContentPane().add(btnReport, "2, 10");
		
		textField = new JTextField();
		textField.setEditable(false);
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Make Report");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setEditable(true);
				textField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						nameLogFile[0] = textField.getText();
						///write an ml or txt file
					}
				});
			}
		});
		frame.getContentPane().add(chckbxNewCheckBox, "2, 14");
		
		JLabel lblNewLabel = new JLabel("Please, type the kind of report you want to create ");
		frame.getContentPane().add(lblNewLabel, "2, 16");
		frame.getContentPane().add(textField, "4, 16, 11, 1, fill, default");
		textField.setColumns(10);
		
		textArea = new TextArea();
		frame.getContentPane().add(textArea, "2, 20, 15, 2");
		textArea.setEditable(false);
		file = myclient.getFilePath();
		readAndDisplayFile(file);
	//	frame.setVisible(true);
	}
	
	public void readAndDisplayFile(String file){
		 Scanner user_input = new Scanner(System.in);
		try{
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			String allLines = null;
			String line = br.readLine();
			while(line != null){ 
				allLines += "\n"+line;
				line = br.readLine();
			}
			textArea.setText(allLines);
			br.close();
			reader.close();
			}catch(Exception e){
				System.out.println("Error in reading File");
			}
	}
		
	

}
