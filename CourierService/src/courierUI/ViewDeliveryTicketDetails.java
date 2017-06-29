package courierUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import courierDAO.DeliveryTicketDAO;
import courierUtil.DateAndTimeUtil;
import courierentity.DeliveryTicketDetails;

public class ViewDeliveryTicketDetails extends JPanel {
	private JTextField textField_4;
	DeliveryTicketDAO deliveryTicketDAO;

	/**
	 * Create the panel.
	 * @param deliTicketDetails 
	 * @param currentFrame 
	 */
	public ViewDeliveryTicketDetails(JFrame currentFrame, DeliveryTicketDetails deliTicketDetails) {
		setLayout(null);
		deliveryTicketDAO = new DeliveryTicketDAO(); 
		
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
		
		JLabel lblDeliveredTime = new JLabel("Delivered Time (MM/dd/yyyy):");
		lblDeliveredTime.setBounds(53, 363, 91, 16);
		add(lblDeliveredTime);
		
		textField_4 = new JTextField();
		textField_4.setBounds(206, 360, 210, 22);
		add(textField_4);
		textField_4.setColumns(10);
		textField_4.setText(deliTicketDetails.getActualDeliveryDate() != null ? deliTicketDetails.getActualDeliveryDate().toString() : "");
		
		JLabel lblNewLabel_2 = new JLabel(deliTicketDetails.getPackageId());
		lblNewLabel_2.setBounds(205, 114, 211, 16);
		add(lblNewLabel_2);
		
		JLabel label = new JLabel(deliTicketDetails.getAssignedCourierName());
		label.setBounds(206, 185, 210, 16);
		add(label);
		
		JLabel label_1 = new JLabel(deliTicketDetails.getCreatedDate().toString());
		label_1.setBounds(206, 249, 210, 16);
		add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel(deliTicketDetails.getPickUpTime().toString());
		lblNewLabel_1.setBounds(213, 305, 203, 16);
		add(lblNewLabel_1);

		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(101, 466, 97, 25);
		if(deliTicketDetails.getActualDeliveryDate() != null) {
			btnSave.setEnabled(false);
		}
		add(btnSave);
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					deliTicketDetails.setActualDeliveryDate(DateAndTimeUtil.getFormatedDate(textField_4.getText()));
					deliveryTicketDAO.updateDeliveredStatus(deliTicketDetails);
					JOptionPane.showMessageDialog(currentFrame, "Delivery Tickets were updated");
					currentFrame.getContentPane().removeAll();
					currentFrame.getContentPane().add(
							new DeliveryTicketList(currentFrame, null, null));
					currentFrame.getContentPane().revalidate();
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(342, 466, 97, 25);
		add(btnCancel);
		if(deliTicketDetails.getActualDeliveryDate() != null) {
			btnCancel.setEnabled(false);
		}
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_4.setText("");
			}
		});
	}
}

