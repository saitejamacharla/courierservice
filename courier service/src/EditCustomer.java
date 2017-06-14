import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditCustomer extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public EditCustomer() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Customer");
		lblNewLabel.setBounds(36, 33, 124, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name                    :");
		lblNewLabel_1.setBounds(46, 67, 114, 14);
		add(lblNewLabel_1);
		
		JLabel lblCustomerNo = new JLabel("Customer no         : ");
		lblCustomerNo.setBounds(45, 92, 135, 14);
		add(lblCustomerNo);
		
		JLabel lblNewLabel_2 = new JLabel("Customer Address:");
		lblNewLabel_2.setBounds(46, 117, 105, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Standard Delivery\r\n");
		lblNewLabel_3.setBounds(45, 142, 183, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Pick up Address    :");
		lblNewLabel_4.setBounds(46, 156, 96, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email                     :");
		lblNewLabel_5.setBounds(46, 183, 96, 14);
		add(lblNewLabel_5);
		
		JLabel lblPhoneNo = new JLabel("Phone no              :");
		lblPhoneNo.setBounds(46, 208, 105, 14);
		add(lblPhoneNo);
		
		textField = new JTextField();
		textField.setBounds(142, 64, 124, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(142, 92, 124, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(142, 117, 124, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(142, 153, 124, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(142, 180, 124, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(142, 208, 124, 20);
		add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(125, 248, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(235, 248, 89, 23);
		add(btnNewButton_1);

	}

}
