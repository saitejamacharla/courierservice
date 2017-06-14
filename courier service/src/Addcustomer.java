import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Addcustomer extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public Addcustomer() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Customer");
		lblNewLabel.setBounds(37, 45, 87, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name                       :");
		lblNewLabel_1.setBounds(60, 80, 128, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Customer no           :");
		lblNewLabel_2.setBounds(60, 116, 146, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Customer Address  :");
		lblNewLabel_3.setBounds(60, 150, 194, 14);
		add(lblNewLabel_3);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number       :");
		lblPhoneNumber.setBounds(62, 188, 162, 14);
		add(lblPhoneNumber);
		
		textField = new JTextField();
		textField.setBounds(168, 77, 139, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(168, 113, 139, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(168, 147, 139, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(168, 185, 139, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(145, 230, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(274, 230, 89, 23);
		add(btnNewButton_1);

	}

}
