package courierUI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EstimatedTimeandBill extends JPanel {

	/**
	 * Create the panel.
	 */
	public EstimatedTimeandBill() {
		setLayout(null);
		
		JLabel lblEstimatedTimeAnd = new JLabel("Estimated Time and Bill");
		lblEstimatedTimeAnd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEstimatedTimeAnd.setBounds(141, 5, 212, 58);
		add(lblEstimatedTimeAnd);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(49, 94, 56, 16);
		add(lblTime);
		
		JLabel lblEstimated = new JLabel("Estimated Delivery Time:");
		lblEstimated.setBounds(49, 154, 152, 16);
		add(lblEstimated);
		
		JLabel lblNewLabel = new JLabel("Estimated Blocks:");
		lblNewLabel.setBounds(49, 197, 115, 16);
		add(lblNewLabel);
		
		JLabel lblBill = new JLabel("Bill");
		lblBill.setBounds(49, 267, 56, 16);
		add(lblBill);
		
		JLabel lblNewLabel_1 = new JLabel("Bill To Pickup:");
		lblNewLabel_1.setBounds(49, 327, 95, 16);
		add(lblNewLabel_1);
		
		JLabel lblBillToDelivery = new JLabel("Bill to Delivery:");
		lblBillToDelivery.setBounds(49, 362, 95, 16);
		add(lblBillToDelivery);
		
		JLabel lblQuotedPrice = new JLabel("Quoted Price:");
		lblQuotedPrice.setBounds(49, 399, 95, 16);
		add(lblQuotedPrice);
		
		JLabel lblNewLabel_2 = new JLabel("--/--/----,  --:--");
		lblNewLabel_2.setBounds(223, 154, 239, 16);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("--");
		lblNewLabel_3.setBounds(223, 197, 56, 16);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("----");
		lblNewLabel_4.setBounds(258, 327, 56, 16);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("----");
		lblNewLabel_5.setBounds(258, 362, 56, 16);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("------");
		lblNewLabel_6.setBounds(258, 399, 56, 16);
		add(lblNewLabel_6);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(225, 318, 25, 25);
		add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
		chckbxNewCheckBox_1.setBounds(226, 353, 113, 25);
		add(chckbxNewCheckBox_1);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(285, 466, 97, 25);
		add(btnConfirm);

	}
}
