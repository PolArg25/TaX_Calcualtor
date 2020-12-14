package gui;



import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JToggleButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import manageData.TaxConsultant;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Choice;
import java.awt.Component;
import java.awt.TextField;
import javax.swing.JTextPane;
import javax.swing.JFileChooser;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
//import gui.taxPayerSelection;
 

public class TaxConsultantGui {


	private TaxConsultant consult;
	private JFrame frame;

	private JTextField textField;

	private JTextField textField_1;



	/**

	 * Launch the application.

	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					TaxConsultantGui window = new TaxConsultantGui();

					window.frame.setVisible(true);
					

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}



	/**

	 * Create the application.

	 */

	public TaxConsultantGui() {
		consult = new TaxConsultant();
		initialize();

	}



	/**

	 * Initialize the contents of the frame.

	 */

	private void initialize() {

		frame = new JFrame();

		frame.setBounds(100, 100, 450, 300);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setLayout(new MigLayout("", "[123px,grow][grow][][][]", "[23px][23px,grow][][][][][]"));

		

		JLabel lblFindClient = new JLabel("find client");

		frame.getContentPane().add(lblFindClient, "cell 0 2,alignx trailing");

		

		textField_1 = new JTextField();
		
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text1 = textField_1.getText();
				System.out.println(text1);
				ArrayList<String[]> informationOfMyClient=new ArrayList<String[]>();
				informationOfMyClient=consult.chooseTaxPayer(text1);
				TaxPayerSelection myclient =new TaxPayerSelection(consult);
				myclient.frame.setVisible(true);
			/*for(String[] k: informationOfMyClient){
					for(int i=0;i<4;i++){
						System.out.println(k[i]);
					}
					break;
			}*/

			}
		});


		frame.getContentPane().add(textField_1, "cell 1 2,growx");

		textField_1.setColumns(10);

		

		JLabel lblGindClientTo = new JLabel("find client to remove");

		frame.getContentPane().add(lblGindClientTo, "cell 0 4,alignx trailing");

		

		textField = new JTextField();

		textField.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String clienttoremove = textField.getText();
				System.out.println(clienttoremove);
				consult.removeTaxPayer(clienttoremove);

			}

		});

		frame.getContentPane().add(textField, "cell 1 4,growx");

		textField.setColumns(10);

	

		JMenuBar menuBar = new JMenuBar();

		frame.setJMenuBar(menuBar);

		

		JMenu mnFile = new JMenu("File");

		menuBar.add(mnFile);

		

		JMenuItem mntmLoadNewfile = new JMenuItem("Load new file");

		mnFile.add(mntmLoadNewfile);

		

		mntmLoadNewfile.addActionListener(new ActionListener(){



			@Override

			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub

				JFileChooser myfile= new JFileChooser();

				myfile.setCurrentDirectory(new java.io.File("C:/Users/deli3/Desktop"));

				myfile.setDialogTitle("File Selection");

				myfile.setFileSelectionMode(JFileChooser.FILES_ONLY);

				Component open = null;

				String filename;

				

				if(myfile.showOpenDialog(open)==JFileChooser.APPROVE_OPTION){

					File file=myfile.getSelectedFile();

					filename=file.getAbsolutePath();

					System.out.println(filename);

					consult.loadFile(filename);
				
				}

			}
	
		});

		JMenu mnHelp = new JMenu("Help");

		menuBar.add(mnHelp);

	}



}