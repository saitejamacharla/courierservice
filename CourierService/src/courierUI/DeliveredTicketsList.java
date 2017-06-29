package courierUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.TreeMap;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import courierDAO.DeliveryTicketDAO;
import courierentity.DeliveryTicketDetails;
import courierentity.Users;

public class DeliveredTicketsList extends JPanel {
	private JTextField textField;

	DeliveryTicketDAO deliveryTicketDAO = null;

	/**
	 * Create the panel.
	 * 
	 * @param userInfo
	 * @param currentFrame
	 */
	public DeliveredTicketsList(JFrame currentFrame,
			TreeMap<String, Users> userInfo, String date) {
		setLayout(null);
		deliveryTicketDAO = new DeliveryTicketDAO();
		List<DeliveryTicketDetails> deliveryTicketDetails = deliveryTicketDAO
				.getDeliveredTickets(date);

		JLabel lblDeliveryTicketList = new JLabel("Delivered Ticket List");
		lblDeliveryTicketList.setBounds(189, 24, 159, 22);
		lblDeliveryTicketList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblDeliveryTicketList);

		JLabel lblSelectPackageid = new JLabel("Select PackageID");
		lblSelectPackageid.setBounds(34, 104, 109, 16);
		add(lblSelectPackageid);

		JLabel lblDate = new JLabel("Date  (yyyy-MM-dd):");
		lblDate.setBounds(240, 104, 134, 16);
		add(lblDate);

		textField = new JTextField();
		textField.setBounds(386, 101, 139, 22);
		add(textField);
		textField.setColumns(10);
		textField.setText("");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 174, 338, 220);
		add(scrollPane);

		DefaultListModel<String> model = new DefaultListModel<String>();
		for (int i = 0; i < deliveryTicketDetails.size(); i++) {
			model.addElement(deliveryTicketDetails.get(i).getPackageId());
		}

		JList list = new JList(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);

		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setRowHeaderView(scrollBar);

		JButton btnView = new JButton("View");
		btnView.setBounds(171, 458, 97, 25);
		add(btnView);
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText() != null && textField.getText().length()>0) {
					currentFrame.getContentPane().removeAll();
					currentFrame.getContentPane().add(
							new DeliveredTicketsList(currentFrame,
									null, textField.getText()));
					currentFrame.getContentPane().revalidate();

				} else {
				String selectedValue = (String)list.getSelectedValue();
				DeliveryTicketDetails deliTicketDetails = null;
				for(int i=0;i<deliveryTicketDetails.size(); i++) {
		        	if(deliveryTicketDetails.get(i).getPackageId().equalsIgnoreCase(selectedValue)) {
		        		deliTicketDetails = deliveryTicketDetails.get(i);
		        		break;
		        	}
		        }
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ViewDeliveryTicketDetails(currentFrame, deliTicketDetails));
				currentFrame.getContentPane().revalidate();
			}
			}
		});

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(343, 447, 159, 46);
		add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new DeliveredTicketsList(currentFrame, null, null));
				currentFrame.getContentPane().revalidate();
			}
		});

	}
}
