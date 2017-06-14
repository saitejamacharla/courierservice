import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateCompanyInformation extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public UpdateCompanyInformation() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Company Information");
		lblNewLabel.setBounds(40, 44, 188, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BillRate                   :");
		lblNewLabel_1.setBounds(69, 82, 139, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(213, 79, 102, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Bonus                     :");
		lblNewLabel_2.setBounds(69, 107, 139, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number       :");
		lblNewLabel_3.setBounds(69, 132, 139, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Base Bill Amount    :");
		lblNewLabel_4.setBounds(69, 157, 139, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Address                 :");
		lblNewLabel_5.setToolTipText("");
		lblNewLabel_5.setBounds(69, 182, 111, 14);
		add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(238, 255, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(351, 255, 89, 23);
		add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(213, 104, 102, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(213, 129, 102, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(213, 154, 102, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(213, 179, 102, 65);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("/block");
		lblNewLabel_6.setBounds(319, 82, 46, 14);
		add(lblNewLabel_6);

	}

}
