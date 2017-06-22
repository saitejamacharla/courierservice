package courierUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import courierDAO.LoginDAO;
import courierentity.Users;

public class LogIn extends JPanel {
	private JTextField usernameTextField;
	private JPasswordField passwordField;

	LoginDAO loginDAO;

	/**
	 * Create the panel.
	 * @param currentFrame 
	 * @param userInfo 
	 * @param jMenus 
	 * @param username 
	 */
	public LogIn(JFrame currentFrame, TreeMap<String, Users> userInfo, List<JMenu> jMenus) {
		setLayout(null);
		loginDAO = new LoginDAO();
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(171, 13, 75, 29);
		add(lblNewLabel);

		JLabel lblUserId = new JLabel("User ID:");
		lblUserId.setBounds(63, 84, 56, 16);
		add(lblUserId);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(63, 148, 68, 16);
		add(lblPassword);

		usernameTextField = new JTextField();
		usernameTextField.setBounds(171, 81, 116, 22);
		add(usernameTextField);
		usernameTextField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(171, 145, 116, 22);
		add(passwordField);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(65, 200, 100, 30);

		JButton btnCacnel = new JButton("Cancel");
		btnCacnel.setBounds(230, 200, 100, 30);
		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Users users = loginDAO.isAuthenticate(
						usernameTextField.getText(), passwordField.getText());
				if (users != null) {
					//usernameTextField.setText("Success");
					userInfo.put(users.getUsername(), users);
					for(int i=0;i<jMenus.size(); i++) {
						if(users.getRole().equalsIgnoreCase("admin")) {
						jMenus.get(i).setVisible(true);
						currentFrame.getContentPane().removeAll();
						currentFrame.getContentPane().add(new LogInResult(currentFrame, userInfo, "success"));
						currentFrame.getContentPane().revalidate();
						}
						else{
							if(jMenus.get(i).getText().equalsIgnoreCase("Maintainance"))
								jMenus.get(i).setVisible(false);
							else
								jMenus.get(i).setVisible(true);
							
							currentFrame.getContentPane().removeAll();
							currentFrame.getContentPane().add(new LogInResult(currentFrame, userInfo, "success"));
							currentFrame.getContentPane().revalidate();
						}
					}
				} else {
					//usernameTextField.setText("Failed");
					currentFrame.getContentPane().removeAll();
					currentFrame.getContentPane().add(new LogInResult(currentFrame, userInfo, "failed"));
					currentFrame.getContentPane().revalidate();

				}
			}
		});

		btnCacnel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				usernameTextField.setText("");
				passwordField.setText("");
			}
		});

		add(btnLogin);
		add(btnCacnel);

	}

}
