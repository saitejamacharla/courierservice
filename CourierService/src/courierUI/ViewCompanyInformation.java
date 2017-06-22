package courierUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import courierDAO.CompanyInfoDAO;
import courierentity.CompanyInfo;

public class ViewCompanyInformation extends JPanel {
	
	CompanyInfoDAO companyInfoDAO = null;

	/**
	 * Create the panel.
	 * @param currentFrame 
	 */
	public ViewCompanyInformation(JFrame currentFrame) {
		setLayout(null);
		companyInfoDAO = new CompanyInfoDAO();
		
		JLabel lblViewCompanyInformation = new JLabel("View Company Information");
		lblViewCompanyInformation.setBounds(207, 5, 155, 16);
		add(lblViewCompanyInformation);
		CompanyInfo companyInfo  =companyInfoDAO.getCompanyInfo();
		
		JLabel lblNewLabel = new JLabel("Bill rate:");
		lblNewLabel.setBounds(74, 80, 56, 16);
		add(lblNewLabel);
		
		JLabel lblBonus = new JLabel("Bonus:");
		lblBonus.setBounds(74, 129, 56, 16);
		add(lblBonus);
		
		JLabel lblPhoneNo = new JLabel("Phone no:");
		lblPhoneNo.setBounds(74, 174, 75, 16);
		add(lblPhoneNo);
		
		JLabel lblBaseBillAmount = new JLabel("Base Bill Amount:");
		lblBaseBillAmount.setBounds(74, 221, 114, 16);
		add(lblBaseBillAmount);
		
		/*JLabel lblNewLabel_1 = new JLabel("Bonus Total Amount:");
		lblNewLabel_1.setBounds(74, 271, 129, 16);
		add(lblNewLabel_1);*/
		
		JLabel lblNewLabel_2 = new JLabel("$"+companyInfo.getBillRate());
		lblNewLabel_2.setBounds(225, 80, 87, 16);
		add(lblNewLabel_2);
		
		JLabel label = new JLabel("$"+ companyInfo.getBonus());
		label.setBounds(225, 129, 56, 16);
		add(label);
		
		JLabel label_1 = new JLabel(companyInfo.getPhoneno());
		label_1.setBounds(225, 174, 85, 16);
		add(label_1);
		
		JLabel label_2 = new JLabel("$"+companyInfo.getBaseBillAmount());
		label_2.setBounds(225, 221, 56, 16);
		add(label_2);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(74, 334, 56, 16);
		add(lblAddress);
		
		JLabel label_4 = new JLabel(companyInfo.getAddress());
		label_4.setBounds(225, 334, 80, 16);
		add(label_4);
		
		/*JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(312, 407, 97, 25);
		add(btnUpdate);*/

	}
}
