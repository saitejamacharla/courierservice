package courierUI;

import java.util.Date;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import courierentity.Users;

public class userprofilepage extends JPanel {

	/**
	 * Create the panel.
	 * @param currentFrame 
	 * @param userInfo 
	 */
	public userprofilepage(JFrame currentFrame, TreeMap<String, Users> userInfo) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Profile");
		lblNewLabel.setBounds(182, 39, 72, 16);
		add(lblNewLabel);
		
		JLabel lblRahul = new JLabel(userInfo.firstEntry().getValue().getName());
		lblRahul.setBounds(40, 94, 78, 16);
		add(lblRahul);
		
		JLabel lblNewLabel_1 = new JLabel(userInfo.firstEntry().getValue().getRole());
		lblNewLabel_1.setBounds(40, 127, 78, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(userInfo.firstEntry().getValue().getPhoneno());
		lblNewLabel_2.setBounds(40, 156, 90, 16);
		add(lblNewLabel_2);
		
		JLabel lblRahul_1 = new JLabel(userInfo.firstEntry().getValue().getUsername());
		lblRahul_1.setBounds(40, 187, 78, 16);
		add(lblRahul_1);

		Date date = new Date();
		JLabel lblNewLabel_3 = new JLabel(date.toString());
		lblNewLabel_3.setBounds(288, 271, 207, 16);
		add(lblNewLabel_3);

	}
}
