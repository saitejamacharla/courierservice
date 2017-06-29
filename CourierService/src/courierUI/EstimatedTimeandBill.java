package courierUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import courierDAO.DeliveryTicketDAO;
import courierentity.CreateDeliveryTicket;
import courierentity.Customer;

public class EstimatedTimeandBill extends JPanel {

	/**
	 * Create the panel.
	 * 
	 * @param deliveryTicket
	 * @param currentFrame
	 * @param customer
	 * @param selectedCourier
	 */
	public EstimatedTimeandBill(JFrame currentFrame,
			CreateDeliveryTicket deliveryTicket, Customer customer,
			String selectedCourier) {
		setLayout(null);
		DeliveryTicketDAO deliveryTicketDAO = new DeliveryTicketDAO();

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

		JLabel lblNewLabel_2 = new JLabel(deliveryTicket
				.getEstimatedDeliveryDate().toString());
		lblNewLabel_2.setBounds(223, 154, 239, 16);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel(String.valueOf(deliveryTicket
				.getEstimatedBlocks()));
		lblNewLabel_3.setBounds(223, 197, 56, 16);
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel(String.valueOf(deliveryTicket
				.getBillToPickUP()));
		lblNewLabel_4.setBounds(268, 327, 56, 16);
		add(lblNewLabel_4);
		deliveryTicket.setBillToPickUP(0.0);

		JLabel lblNewLabel_5 = new JLabel(String.valueOf(deliveryTicket
				.getBillToDelivery()));
		lblNewLabel_5.setBounds(268, 362, 56, 16);
		add(lblNewLabel_5);
		deliveryTicket.setBillToDelivery(0.0);

		JCheckBox chckbxNewCheckBox = new JCheckBox();
		chckbxNewCheckBox.setBounds(224, 323, 25, 25);
		add(chckbxNewCheckBox);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox();
		chckbxNewCheckBox_1.setBounds(223, 353, 26, 25);
		add(chckbxNewCheckBox_1);

		JLabel lblNewLabel_6 = new JLabel(String.valueOf(0.0));
		lblNewLabel_6.setBounds(258, 399, 56, 16);
		add(lblNewLabel_6);

		chckbxNewCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				double quotedPrice = Double.parseDouble(lblNewLabel_6.getText());
				double pickUpPrice = Double.parseDouble(lblNewLabel_4.getText());
				if (chckbxNewCheckBox.isSelected()) {
					lblNewLabel_6.setText(String.valueOf(quotedPrice
							+ pickUpPrice));
					deliveryTicket.setBillToPickUP(pickUpPrice);
				} else {
					lblNewLabel_6.setText(String.valueOf(quotedPrice
							- pickUpPrice));
				}
			}
		});

		chckbxNewCheckBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				double quotedPrice = Double.parseDouble(lblNewLabel_6.getText());
				double deliveryPrice = Double.parseDouble(lblNewLabel_5
						.getText());
				if (chckbxNewCheckBox_1.isSelected()) {
					lblNewLabel_6.setText(String.valueOf(quotedPrice
							+ deliveryPrice));
					deliveryTicket.setBillToDelivery(deliveryPrice);
				} else {
					lblNewLabel_6.setText(String.valueOf(quotedPrice
							- deliveryPrice));
				}
			}
		});

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(285, 466, 97, 25);
		add(btnConfirm);

		btnConfirm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				deliveryTicket.setQuotedPrice(Double.parseDouble(lblNewLabel_6
						.getText()));
				deliveryTicket.setInstructions("Esitimated Blockes: "
						+ deliveryTicket.getEstimatedBlocks()
						+ " . Delivery Date: "
						+ deliveryTicket.getEstimatedDeliveryDate()
						+ ". path: "
						+ deliveryTicket.getDeliveryPath());
				deliveryTicketDAO.saveDeliveryDetails(deliveryTicket);
				JOptionPane.showMessageDialog(currentFrame,
						"Delivery Ticket Details Saved");
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(
						new DeliveryTicketConfirmed(currentFrame,
								deliveryTicket, customer, selectedCourier));
				currentFrame.getContentPane().revalidate();
			}
		});

	}
}
