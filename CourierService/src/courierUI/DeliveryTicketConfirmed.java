package courierUI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class DeliveryTicketConfirmed extends JPanel {

	/**
	 * Create the panel.
	 */
	public DeliveryTicketConfirmed() {
		setLayout(null);
		
		JLabel lblDeliveryTicketConfirmed = new JLabel("Delivery Ticket Confirmed");
		lblDeliveryTicketConfirmed.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDeliveryTicketConfirmed.setBounds(233, 30, 295, 46);
		add(lblDeliveryTicketConfirmed);
		
		JButton btnPrintDeliveryTicket = new JButton("Print Delivery Ticket");
		btnPrintDeliveryTicket.setBounds(752, 625, 154, 25);
		add(btnPrintDeliveryTicket);
		
		JLabel lblNewLabel = new JLabel("PackageID:");
		lblNewLabel.setBounds(555, 89, 85, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("------------");
		lblNewLabel_1.setBounds(640, 89, 106, 16);
		add(lblNewLabel_1);
		
		JLabel lblCu = new JLabel("Customer name:");
		lblCu.setBounds(43, 153, 117, 16);
		add(lblCu);
		
		JLabel lblAssignedCourier = new JLabel("Assigned Courier:");
		lblAssignedCourier.setBounds(505, 207, 106, 16);
		add(lblAssignedCourier);
		
		JLabel lblNewLabel_2 = new JLabel("Pickup Address:");
		lblNewLabel_2.setBounds(43, 207, 99, 16);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(172, 153, 99, 16);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(162, 207, 154, 16);
		add(lblNewLabel_4);
		
		JLabel lblDeliveryCustomerName = new JLabel("Delivery customer name:");
		lblDeliveryCustomerName.setBounds(43, 280, 148, 16);
		add(lblDeliveryCustomerName);
		
		JLabel lblNewLabel_5 = new JLabel("Delivery address:");
		lblNewLabel_5.setBounds(43, 329, 99, 16);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(213, 280, 117, 16);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(213, 329, 56, 16);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(640, 207, 106, 16);
		add(lblNewLabel_8);
		
		JLabel lblAssignedTime = new JLabel("Assigned Time:");
		lblAssignedTime.setBounds(505, 261, 106, 16);
		add(lblAssignedTime);
		
		JLabel lblPickupTime = new JLabel("Pickup Time:");
		lblPickupTime.setBounds(505, 311, 93, 16);
		add(lblPickupTime);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(637, 261, 56, 16);
		add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(637, 311, 56, 16);
		add(lblNewLabel_10);
		
		JLabel lblInstruction = new JLabel("Instructions:");
		lblInstruction.setBounds(12, 397, 93, 16);
		add(lblInstruction);
		
		JLabel lblPickedTime = new JLabel("Picked Time:");
		lblPickedTime.setBounds(555, 436, 85, 16);
		add(lblPickedTime);
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setBounds(683, 436, 197, 16);
		add(lblNewLabel_12);
		
		JLabel lblDeliveredTime = new JLabel("Delivered Time:");
		lblDeliveredTime.setBounds(555, 490, 99, 16);
		add(lblDeliveredTime);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setBounds(683, 490, 248, 16);
		add(lblNewLabel_13);
		
		JLabel lblBlocks = new JLabel("Blocks:");
		lblBlocks.setBounds(555, 539, 56, 16);
		add(lblBlocks);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setBounds(690, 539, 106, 16);
		add(lblNewLabel_14);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 436, 446, 220);
		add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);

	}
}
