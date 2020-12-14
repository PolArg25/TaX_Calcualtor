package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import manageData.TaxConsultant;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MoreReceipts extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JButton btnSave;
	String thenewreceipt[] = new String[9];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	moreReceipts frame = new moreReceipts();
				//	frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MoreReceipts(TaxConsultant consultant, TaxPayerSelection myselection ) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 439, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblId = new JLabel("Id");
		contentPane.add(lblId, "2, 2, right, default");
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 thenewreceipt[0]=textField.getText();
			}
		});
		contentPane.add(textField, "4, 2, fill, default");
		textField.setColumns(10);
		
		JLabel lblDdate = new JLabel("Date");
		contentPane.add(lblDdate, "2, 6, right, default");
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				thenewreceipt[1]=textField_1.getText();
			}
		});
		contentPane.add(textField_1, "4, 6, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblCountry = new JLabel("Country");
		contentPane.add(lblCountry, "10, 6, right, default");
		
		textField_5 = new JTextField();
		textField_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thenewreceipt[5]=textField_5.getText();
			}
		});
		contentPane.add(textField_5, "12, 6, fill, default");
		textField_5.setColumns(10);
		
		JLabel lblKind = new JLabel("Kind");
		contentPane.add(lblKind, "2, 10, right, default");
		
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thenewreceipt[2]=textField_2.getText();
			}
		});
		contentPane.add(textField_2, "4, 10, fill, default");
		textField_2.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		contentPane.add(lblCity, "10, 10, right, default");
		
		textField_6 = new JTextField();
		textField_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thenewreceipt[6]=textField_6.getText();
			}
		});
		contentPane.add(textField_6, "12, 10, fill, default");
		textField_6.setColumns(10);
		
		JLabel lblAmmound = new JLabel("Ammount");
		contentPane.add(lblAmmound, "2, 14, right, default");
		
		textField_3 = new JTextField();
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thenewreceipt[3]=textField_3.getText();
			}
		});
		contentPane.add(textField_3, "4, 14, fill, default");
		textField_3.setColumns(10);
		
		JLabel lblStreet = new JLabel("Street");
		contentPane.add(lblStreet, "10, 14, right, default");
		
		textField_7 = new JTextField();
		textField_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thenewreceipt[7]=textField_7.getText();
			}
		});
		contentPane.add(textField_7, "12, 14, fill, default");
		textField_7.setColumns(10);
		
		JLabel lblCompany = new JLabel("Company");
		contentPane.add(lblCompany, "2, 18, right, default");
		
		textField_4 = new JTextField();
		textField_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thenewreceipt[4]=textField_4.getText();
			}
		});
		contentPane.add(textField_4, "4, 18, fill, default");
		textField_4.setColumns(10);
		
		JLabel lblNumber = new JLabel("Number");
		contentPane.add(lblNumber, "10, 18, right, default");
		
		textField_8 = new JTextField();
		textField_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thenewreceipt[8]=textField_8.getText();
			}
		});
		contentPane.add(textField_8, "12, 18, fill, default");
		textField_8.setColumns(10);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultant.processingTaxPayer("a",thenewreceipt);
				String File=consultant.getFilePath();
				myselection.readAndDisplayFile(File);
			}
		});
	//	btnSave.addActionListener(arg0);
		contentPane.add(btnSave, "14, 20");
	}

}
