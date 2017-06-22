package courierUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import courierDAO.UserDAO;
import courierentity.Users;

public class AddOrdertaker extends JPanel {
	private JTextField name_textField;
	private JTextField id_textField;
	private JTextField position_textField;
	private JTextField phno_textField;
	UserDAO userDAO = null;

	/**
	 * Create the panel.
	 * 
	 * @param userInfo
	 * @param currentFrame
	 */
	public AddOrdertaker(JFrame currentFrame, TreeMap<String, Users> userInfo) {
		setLayout(null);
		userDAO = new UserDAO();

		JLabel lblNewLabel = new JLabel("Add Order Taker");
		lblNewLabel.setBounds(12, 38, 116, 16);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(66, 96, 56, 16);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Id:");
		lblNewLabel_2.setBounds(66, 155, 56, 16);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Position:");
		lblNewLabel_3.setBounds(66, 199, 56, 16);
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Phone no:");
		lblNewLabel_4.setBounds(66, 245, 83, 16);
		add(lblNewLabel_4);

		name_textField = new JTextField();
		name_textField.setBounds(176, 93, 116, 22);
		add(name_textField);
		name_textField.setColumns(10);

		id_textField = new JTextField();
		id_textField.setBounds(176, 152, 116, 22);
		add(id_textField);
		id_textField.setColumns(10);

		position_textField = new JTextField();
		position_textField.setBounds(176, 196, 116, 22);
		add(position_textField);
		position_textField.setColumns(10);

		phno_textField = new JTextField();
		phno_textField.setBounds(176, 242, 116, 22);
		add(phno_textField);
		phno_textField.setColumns(10);

		JButton btnNewButton = new JButton("create");
		btnNewButton.setBounds(52, 310, 97, 25);
		add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Users users = new Users();
				users.setName(name_textField.getText());
				users.setPassword("123456");
				users.setPhoneno(phno_textField.getText());
				users.setRole(position_textField.getText());
				users.setUsername(id_textField.getText());
				userDAO.insertOrderTaker(users);
				JOptionPane.showMessageDialog(currentFrame,
						"Order Taker Persisted");
			}
		});

		JButton btnCancel = new JButton("cancel");
		btnCancel.setBounds(241, 310, 97, 25);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name_textField.setText("");
				phno_textField.setText("");
				position_textField.setText("");
				id_textField.setText("");
			}
		});
		add(btnCancel);
	}
}
