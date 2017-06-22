package courierUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import courierDAO.UserDAO;
import courierentity.Users;

public class Editordertaker extends JPanel {
	private JTextField name_textField;
	private JTextField id_textField;
	private JTextField position_textField;
	private JTextField phone_textField;
	UserDAO userDAO = null;

	/**
	 * Create the panel.
	 * @param selOT 
	 * @param currentFrame 
	 */
	public Editordertaker(JFrame currentFrame, Users selOT) {
		setLayout(null);
		userDAO = new UserDAO();
		
		JLabel lblEditOrderTaker = new JLabel("Edit Order Taker");
		lblEditOrderTaker.setBounds(12, 26, 123, 16);
		add(lblEditOrderTaker);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(59, 70, 56, 16);
		add(lblNewLabel);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(59, 113, 56, 16);
		add(lblId);
		
		JLabel lblNewLabel_1 = new JLabel("Position:");
		lblNewLabel_1.setBounds(59, 161, 56, 16);
		add(lblNewLabel_1);
		
		JLabel lblPhoneNo = new JLabel("Phone no:");
		lblPhoneNo.setBounds(59, 219, 76, 16);
		add(lblPhoneNo);
		
		name_textField = new JTextField();
		name_textField.setBounds(137, 67, 116, 22);
		add(name_textField);
		name_textField.setColumns(10);
		name_textField.setText(selOT.getName());
		
		
		JLabel lblUserIdText = new JLabel(selOT.getUsername());
		lblUserIdText.setBounds(135, 113, 56, 16);
		add(lblUserIdText);
		
		//id_textField = new JTextField();
		//id_textField.setBounds(137, 158, 116, 22);
		//add(id_textField);
		//id_textField.setColumns(10);
		//id_textField.setText(selOT.getUsername());
		
		position_textField = new JTextField();
		position_textField.setBounds(137, 158, 116, 22);
		add(position_textField);
		position_textField.setColumns(10);
		position_textField.setText(selOT.getRole());
		
		phone_textField = new JTextField();
		phone_textField.setBounds(137, 216, 116, 22);
		add(phone_textField);
		phone_textField.setColumns(10);
		phone_textField.setText(selOT.getPhoneno());
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Users users = new Users();
				users.setName(name_textField.getText());
				users.setPhoneno(phone_textField.getText());
				users.setRole(position_textField.getText());
				users.setUsername(selOT.getUsername());
				users.setPassword(selOT.getPassword());
				userDAO.updateOrderTaker(users);
				JOptionPane.showMessageDialog(currentFrame, "Order Taker Updated");
			}
		});
		btnNewButton.setBounds(59, 281, 97, 25);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(238, 281, 97, 25);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new Ordertakerlist(currentFrame, null));
				currentFrame.getContentPane().revalidate();
			}
		});
		add(btnNewButton_1);

	}

}
