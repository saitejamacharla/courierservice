package courierUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import courierDAO.UserDAO;
import courierentity.Users;

public class ChangePassword extends JPanel {
	private JTextField userid_textField;
	private JPasswordField current_passwordField;
	private JPasswordField new_passwordField;
	UserDAO userDAO = null;

	/**
	 * Create the panel.
	 * @param currentFrame 
	 */
	public ChangePassword(JFrame currentFrame) {
		setLayout(null);
		userDAO = new UserDAO();
		
		JLabel lblNewLabel = new JLabel("Change Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(105, 30, 169, 27);
		add(lblNewLabel);
		
		JLabel lblUserId = new JLabel("User ID:");
		lblUserId.setBounds(53, 105, 56, 16);
		add(lblUserId);
		
		JLabel lblCurrentPassword = new JLabel("Current Password:");
		lblCurrentPassword.setBounds(53, 170, 107, 16);
		add(lblCurrentPassword);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setBounds(53, 217, 107, 16);
		add(lblNewPassword);
		
		userid_textField = new JTextField();
		userid_textField.setBounds(199, 102, 116, 22);
		add(userid_textField);
		userid_textField.setColumns(10);
		
		current_passwordField = new JPasswordField();
		current_passwordField.setBounds(199, 154, 116, 22);
		add(current_passwordField);
		
		new_passwordField = new JPasswordField();
		new_passwordField.setBounds(199, 214, 116, 22);
		add(new_passwordField);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Users users = new Users();
				users.setUsername(userid_textField.getText());
				users.setPassword(current_passwordField.getText());
				userDAO.updatePassword(users, new_passwordField.getText());
				JOptionPane.showMessageDialog(currentFrame, "Password Updated");
			}
		});
		btnNewButton.setBounds(59, 281, 97, 25);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(238, 281, 97, 25);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userid_textField.setText("");
				current_passwordField.setText("");
				new_passwordField.setText("");	
			}
		});
		add(btnNewButton_1);

	}

}
