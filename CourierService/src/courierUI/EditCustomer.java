package courierUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import courierDAO.CustomerDAO;
import courierentity.Customer;

public class EditCustomer extends JPanel {
	private JTextField name_textField;
	private JTextField textField_1;
	private JTextField custAdrs_textField;
	private JTextField custEmail_textField;
	private JTextField custPh_textField;
	
	CustomerDAO customerDAO = null;

	/**
	 * Create the panel.
	 * @param selectedCust 
	 * @param currentFrame 
	 */
	public EditCustomer(JFrame currentFrame, Customer selectedCust) {
		setLayout(null);
		customerDAO = new CustomerDAO();
		
		JLabel lblNewLabel = new JLabel("Edit Customer");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(229, 26, 125, 27);
		add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(41, 99, 56, 16);
		add(lblName);
		
		JLabel lblNewLabel_2 = new JLabel("Customer no:");
		lblNewLabel_2.setBounds(41, 143, 90, 16);
		add(lblNewLabel_2);
		
		name_textField = new JTextField();
		name_textField.setBounds(280, 96, 116, 22);
		add(name_textField);
		name_textField.setColumns(10);
		name_textField.setText(selectedCust.getName());
		
		JLabel lblNewLabel_1 = new JLabel(selectedCust.getCustomerNo());
		lblNewLabel_1.setBounds(208, 143, 56, 16);
		add(lblNewLabel_1);
		
		JLabel lblCustomerAddress = new JLabel("Customer Address:");
		lblCustomerAddress.setBounds(41, 194, 116, 16);
		add(lblCustomerAddress);
		
		custAdrs_textField = new JTextField();
		custAdrs_textField.setBounds(280, 191, 116, 22);
		add(custAdrs_textField);
		custAdrs_textField.setColumns(10);
		custAdrs_textField.setText(selectedCust.getCustAddress());
		
		JLabel lblStandardDelivery = new JLabel("Standard delivery Pickup Address:");
		lblStandardDelivery.setBounds(41, 232, 195, 54);
		add(lblStandardDelivery);
		
		JLabel lbl_custAddrs = new JLabel(selectedCust.getCustAddress());
		lbl_custAddrs.setBounds(280, 248, 205, 22);
		add(lbl_custAddrs);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(41, 299, 56, 16);
		add(lblEmail);
		
		JLabel lblPhoneNo = new JLabel("phone no:");
		lblPhoneNo.setBounds(41, 345, 78, 16);
		add(lblPhoneNo);
		
		custEmail_textField = new JTextField();
		custEmail_textField.setBounds(280, 296, 205, 22);
		add(custEmail_textField);
		custEmail_textField.setColumns(10);
		custEmail_textField.setText(selectedCust.getCustEmail());
		
		custPh_textField = new JTextField();
		custPh_textField.setBounds(280, 342, 172, 22);
		add(custPh_textField);
		custPh_textField.setColumns(10);
		custPh_textField.setText(selectedCust.getPhoneno());
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(128, 435, 97, 25);
		add(btnSave);
		btnSave.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Customer customer = new Customer();
				customer.setName(name_textField.getText());
				customer.setPhoneno(custPh_textField.getText());
				customer.setCustAddress(custAdrs_textField.getText());
				customer.setCustEmail(custEmail_textField.getText());
				customer.setPhoneno(custPh_textField.getText());
				customer.setCustomerNo(selectedCust.getCustomerNo());
				customerDAO.updateCustomer(customer);
				JOptionPane.showMessageDialog(currentFrame, "Customer Details Updated");
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(336, 435, 97, 25);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CustomerList(currentFrame, null));
				currentFrame.getContentPane().revalidate();
			}
		});
		add(btnCancel);

	}
}
