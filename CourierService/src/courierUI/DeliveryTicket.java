package courierUI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JScrollBar;

public class DeliveryTicket extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public DeliveryTicket() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delivery Ticket");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(232, 5, 128, 57);
		add(lblNewLabel);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(45, 90, 56, 16);
		add(lblDate);
		
		JLabel label = new JLabel("--/--/----");
		label.setBounds(108, 90, 56, 16);
		add(label);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(232, 90, 56, 16);
		add(lblTime);
		
		JLabel lblNewLabel_1 = new JLabel("--:-- ");
		lblNewLabel_1.setBounds(300, 90, 56, 16);
		add(lblNewLabel_1);
		
		JLabel lblPickup = new JLabel("Pickup");
		lblPickup.setBounds(45, 145, 56, 16);
		add(lblPickup);
		
		JLabel lblCustomer = new JLabel("Customer name:");
		lblCustomer.setBounds(79, 190, 103, 16);
		add(lblCustomer);
		
		JLabel lblCustomerNo = new JLabel("Pickup Address:");
		lblCustomerNo.setBounds(79, 238, 103, 16);
		add(lblCustomerNo);
		
		JLabel lblPickupTime = new JLabel("Pickup Time:");
		lblPickupTime.setBounds(82, 294, 82, 16);
		add(lblPickupTime);
		
		textField = new JTextField();
		textField.setBounds(244, 187, 172, 22);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(244, 235, 172, 22);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(244, 291, 172, 22);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDelivery = new JLabel("Delivery");
		lblDelivery.setBounds(45, 362, 56, 16);
		add(lblDelivery);
		
		JLabel lblNewLabel_2 = new JLabel("Customer name:");
		lblNewLabel_2.setBounds(79, 413, 103, 16);
		add(lblNewLabel_2);
		
		JLabel lblCustomerNo_1 = new JLabel("Delivery Address:");
		lblCustomerNo_1.setBounds(79, 461, 116, 16);
		add(lblCustomerNo_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(232, 407, 184, 22);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(244, 458, 172, 22);
		add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setBounds(345, 652, 97, 25);
		add(btnContinue);
		
		JLabel lblPackageid = new JLabel("PackageID:");
		lblPackageid.setBounds(389, 90, 71, 16);
		add(lblPackageid);
		
		textField_5 = new JTextField();
		textField_5.setBounds(473, 87, 116, 22);
		add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblAssignDeliveryTo = new JLabel("Assign delivery to Courier:");
		lblAssignDeliveryTo.setBounds(61, 568, 178, 16);
		add(lblAssignDeliveryTo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(244, 534, 263, 68);
		add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setRowHeaderView(scrollBar);

	}
}
