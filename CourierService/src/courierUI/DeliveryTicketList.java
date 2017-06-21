package courierUI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DeliveryTicketList extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public DeliveryTicketList() {
		setLayout(null);
		
		JLabel lblDeliveryTicketList = new JLabel("Delivery Ticket List");
		lblDeliveryTicketList.setBounds(189, 24, 159, 22);
		lblDeliveryTicketList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblDeliveryTicketList);
		
		JLabel lblSelectPackageid = new JLabel("Select PackageID");
		lblSelectPackageid.setBounds(34, 104, 109, 16);
		add(lblSelectPackageid);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(277, 104, 56, 16);
		add(lblDate);
		
		textField = new JTextField();
		textField.setBounds(318, 101, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 174, 338, 220);
		add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setRowHeaderView(scrollBar);
		
		JButton btnView = new JButton("View");
		btnView.setBounds(171, 458, 97, 25);
		add(btnView);
		
		JButton btnNewButton = new JButton("Cancel Delivery Ticket");
		btnNewButton.setBounds(343, 447, 159, 46);
		add(btnNewButton);

	}
}
