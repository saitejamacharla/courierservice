package courierUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import courierDAO.CustomerDAO;
import courierentity.Customer;
import courierentity.Users;

public class AddCustomer extends JPanel {
	private JTextField name_textField;
	private JTextField custNo_textField;
	private JTextField custAddrss_textField;
	private JTextField custEmail_textField;
	private JTextField phoneno_textField;
	
	CustomerDAO customerDAO = null;

	/**
	 * Create the panel.
	 * @param userInfo 
	 * @param currentFrame 
	 */
	public AddCustomer(JFrame currentFrame, TreeMap<String, Users> userInfo) {
		setLayout(null);
		customerDAO = new CustomerDAO();
		
		JLabel lblAddCustomer = new JLabel("Add Customer");
		lblAddCustomer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddCustomer.setBounds(206, 28, 172, 35);
		add(lblAddCustomer);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(47, 105, 56, 16);
		add(lblNewLabel);
		
		JLabel lblCustomerNo = new JLabel("Customer no:");
		lblCustomerNo.setBounds(47, 170, 96, 16);
		add(lblCustomerNo);
		
		JLabel lblCustomerAddress = new JLabel("Customer Address:");
		lblCustomerAddress.setBounds(47, 250, 117, 16);
		add(lblCustomerAddress);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(47, 301, 56, 16);
		add(lblEmail);
		
		JLabel lblPhoneNo = new JLabel("Phone no:");
		lblPhoneNo.setBounds(47, 366, 96, 16);
		add(lblPhoneNo);
		
		name_textField = new JTextField();
		name_textField.setBounds(204, 102, 145, 22);
		add(name_textField);
		name_textField.setColumns(10);
		
		custNo_textField = new JTextField();
		custNo_textField.setBounds(206, 167, 143, 22);
		add(custNo_textField);
		custNo_textField.setColumns(10);
		
		custAddrss_textField = new JTextField();
		custAddrss_textField.setBounds(206, 229, 281, 22);
		add(custAddrss_textField);
		custAddrss_textField.setColumns(10);
		
		custEmail_textField = new JTextField();
		custEmail_textField.setBounds(203, 298, 299, 22);
		add(custEmail_textField);
		custEmail_textField.setColumns(10);
		
		phoneno_textField = new JTextField();
		phoneno_textField.setBounds(199, 363, 225, 22);
		add(phoneno_textField);
		phoneno_textField.setColumns(10);
		
		JButton btnCreate = new JButton("Create ");
		btnCreate.setBounds(108, 453, 97, 25);
		add(btnCreate);
		btnCreate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Customer customer = new Customer();
				customer.setName(name_textField.getText());
				customer.setPhoneno(phoneno_textField.getText());
				customer.setCustomerNo(custNo_textField.getText());
				customer.setCustAddress(custAddrss_textField.getText());
				customer.setCustEmail(custEmail_textField.getText());
				customerDAO.saveCustomer(customer);
				JOptionPane.showMessageDialog(currentFrame, "Customer Persisted");
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(310, 453, 97, 25);
		btnCancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				name_textField.setText("");
				phoneno_textField.setText("");
				custNo_textField.setText("");
				custAddrss_textField.setText("");
				custEmail_textField.setText("");
			}
		});
		add(btnCancel);

	}

}
