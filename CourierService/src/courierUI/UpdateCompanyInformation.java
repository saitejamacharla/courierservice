package courierUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import courierDAO.CompanyInfoDAO;
import courierentity.CompanyInfo;

public class UpdateCompanyInformation extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private CompanyInfoDAO companyInfoDAO;

	/**
	 * Create the panel.
	 * 
	 * @param currentFrame
	 */
	public UpdateCompanyInformation(JFrame currentFrame) {
		setLayout(null);
		companyInfoDAO = new CompanyInfoDAO();

		JLabel lblNewLabel = new JLabel("Update Company Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(140, 5, 283, 47);
		add(lblNewLabel);

		JLabel lblBillRate = new JLabel("Bill Rate:");
		lblBillRate.setBounds(64, 110, 56, 16);
		add(lblBillRate);

		textField = new JTextField();
		textField.setBounds(176, 107, 116, 22);
		add(textField);
		textField.setColumns(10);

		JLabel lblblock = new JLabel("/Block");
		lblblock.setBounds(302, 110, 56, 16);
		add(lblblock);

		JLabel lblBonus = new JLabel("Bonus:");
		lblBonus.setBounds(64, 172, 56, 16);
		add(lblBonus);

		textField_1 = new JTextField();
		textField_1.setBounds(176, 169, 116, 22);
		add(textField_1);
		textField_1.setColumns(10);

		JLabel lblPhoneNo = new JLabel("Phone no:");
		lblPhoneNo.setBounds(64, 246, 71, 16);
		add(lblPhoneNo);

		textField_2 = new JTextField();
		textField_2.setBounds(176, 243, 116, 22);
		add(textField_2);
		textField_2.setColumns(10);

		JLabel lblBaseBill = new JLabel("Base Bill:");
		lblBaseBill.setBounds(64, 318, 56, 16);
		add(lblBaseBill);

		textField_3 = new JTextField();
		textField_3.setBounds(176, 315, 116, 22);
		add(textField_3);
		textField_3.setColumns(10);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(64, 401, 56, 16);
		add(lblAddress);

		textField_4 = new JTextField();
		textField_4.setBounds(176, 398, 303, 79);
		add(textField_4);
		textField_4.setColumns(10);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(126, 546, 85, 25);
		btnUpdate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				CompanyInfo companyInfo = new CompanyInfo();
				companyInfo.setAddress(textField_4.getText());
				companyInfo.setBillRate(Integer.parseInt(textField.getText()));
				companyInfo.setBonus(Integer.parseInt(textField_1.getText()));
				companyInfo.setPhoneno(textField_2.getText());
				companyInfo.setBaseBillAmount(Integer.parseInt(textField_3
						.getText()));

				companyInfoDAO.updateCompanyInfo(companyInfo);
				JOptionPane.showMessageDialog(currentFrame, "Details Updated");
			}
		});

		add(btnUpdate);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(352, 546, 85, 25);
		add(btnCancel);

	}

}
