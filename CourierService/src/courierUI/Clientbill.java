package courierUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.TextArea;
import java.awt.Label;
import java.awt.Color;
import java.awt.ScrollPane;
import javax.swing.JButton;

public class Clientbill extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public Clientbill() {
		setLayout(null);
		
		JLabel lblClientBill = new JLabel("Client Bill");
		lblClientBill.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClientBill.setBounds(251, 13, 133, 22);
		add(lblClientBill);
		
		JLabel lblCustomerName = new JLabel("Customer Name:");
		lblCustomerName.setBounds(32, 75, 107, 16);
		add(lblCustomerName);
		
		textField = new JTextField();
		textField.setBounds(144, 72, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblStartDate = new JLabel("Start Date:");
		lblStartDate.setBounds(32, 131, 75, 16);
		add(lblStartDate);
		
		textField_1 = new JTextField();
		textField_1.setBounds(144, 128, 116, 22);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEndDate = new JLabel("End Date:");
		lblEndDate.setBounds(366, 131, 56, 16);
		add(lblEndDate);
		
		textField_2 = new JTextField();
		textField_2.setBounds(449, 128, 116, 22);
		add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(46, 212, 554, 290);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer name:");
		lblNewLabel.setBounds(12, 13, 102, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("----------");
		lblNewLabel_1.setBounds(154, 13, 120, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNo = new JLabel("No");
		lblNo.setBounds(12, 63, 56, 16);
		panel.add(lblNo);
		
		JLabel lblPackageid = new JLabel("PackageID");
		lblPackageid.setBounds(85, 63, 69, 16);
		panel.add(lblPackageid);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(189, 63, 85, 16);
		panel.add(lblDate);
		
		JLabel lblNewLabel_2 = new JLabel("Time");
		lblNewLabel_2.setBounds(311, 63, 56, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblBill = new JLabel("Bill");
		lblBill.setBounds(434, 63, 56, 16);
		panel.add(lblBill);
		
		JLabel lblNewLabel_3 = new JLabel("--");
		lblNewLabel_3.setBounds(12, 115, 30, 16);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("-------");
		lblNewLabel_4.setBounds(85, 115, 56, 16);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("-------");
		lblNewLabel_5.setBounds(177, 115, 56, 16);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("-------");
		lblNewLabel_6.setBounds(283, 115, 56, 16);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("----------");
		lblNewLabel_7.setBounds(416, 115, 56, 16);
		panel.add(lblNewLabel_7);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(311, 206, 56, 16);
		panel.add(lblTotal);
		
		JLabel lblNewLabel_8 = new JLabel("-------");
		lblNewLabel_8.setBounds(416, 206, 56, 16);
		panel.add(lblNewLabel_8);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setBounds(251, 548, 97, 25);
		add(btnPrint);
		
		JButton btnNewButton = new JButton("Generate");
		btnNewButton.setBounds(402, 548, 97, 25);
		add(btnNewButton);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(559, 548, 97, 25);
		add(btnClose);

	}
}
