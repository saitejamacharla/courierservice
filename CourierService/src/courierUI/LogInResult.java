package courierUI;

import java.awt.Font;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import courierDAO.LoginDAO;
import courierentity.Users;

public class LogInResult extends JPanel {

	LoginDAO loginDAO;

	/**
	 * Create the panel.
	 * @param currentFrame 
	 * @param userInfo 
	 * @param string 
	 * @param username 
	 */
	public LogInResult(JFrame currentFrame, TreeMap<String, Users> userInfo, String result) {
		setLayout(null);
		if(result.equalsIgnoreCase("success")) {
		JLabel lblUserId = new JLabel("Login Success.. Welcome to ACME COURIER SERVICE");
		lblUserId.setFont(new Font("Snap ITC", Font.BOLD, 20));
		lblUserId.setBounds(63, 100, 1000, 500);
		add(lblUserId);
		} else{
				JLabel lblUserId = new JLabel("Login Failed.. try again");
				lblUserId.setFont(new Font("Snap ITC", Font.BOLD, 20));
				lblUserId.setBounds(63, 100, 1000, 500);
				add(lblUserId);
		}

	}

}
