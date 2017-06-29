package courierUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DeliveredTicket extends JPanel {
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public DeliveredTicket() {
		setLayout(null);
		
		JLabel lblCourierDeliveredTicket = new JLabel("Delivered Ticket");
		lblCourierDeliveredTicket.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCourierDeliveredTicket.setBounds(197, 13, 219, 57);
		add(lblCourierDeliveredTicket);
		
		JLabel lblPackageid = new JLabel("PackageID:");
		lblPackageid.setBounds(53, 114, 71, 16);
		add(lblPackageid);
		
		JLabel lblAssignedCourier = new JLabel("Assigned Courier:");
		lblAssignedCourier.setBounds(53, 185, 102, 16);
		add(lblAssignedCourier);
		
		JLabel lblAssignedTime = new JLabel("Assigned Time:");
		lblAssignedTime.setBounds(53, 249, 102, 16);
		add(lblAssignedTime);
		
		JLabel lblNewLabel = new JLabel("Pickup Time:");
		lblNewLabel.setBounds(53, 305, 102, 16);
		add(lblNewLabel);
		
		JLabel lblDeliveredTime = new JLabel("Delivered Time:");
		lblDeliveredTime.setBounds(53, 363, 91, 16);
		add(lblDeliveredTime);
		
		textField_4 = new JTextField();
		textField_4.setBounds(206, 360, 210, 22);
		add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(101, 466, 97, 25);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(342, 466, 97, 25);
		add(btnCancel);
		
		JLabel lblNewLabel_2 = new JLabel("--------------");
		lblNewLabel_2.setBounds(205, 114, 211, 16);
		add(lblNewLabel_2);
		
		JLabel label = new JLabel("------------");
		label.setBounds(206, 185, 210, 16);
		add(label);
		
		JLabel label_1 = new JLabel("-----------------");
		label_1.setBounds(206, 249, 210, 16);
		add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("------------");
		lblNewLabel_1.setBounds(213, 305, 203, 16);
		add(lblNewLabel_1);

	}
}

