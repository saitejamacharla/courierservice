package courierUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import courierDAO.CourierDAO;
import courierDAO.CustomerDAO;
import courierMap.DijkstraFind;
import courierMap.WeighedDigraph;
import courierentity.Courier;
import courierentity.CreateDeliveryTicket;
import courierentity.Customer;
import courierentity.Users;

public class DeliveryTicket extends JPanel {
	private JTextField custName_textField;
	private JTextField pickUpAddrss_textField;
	private JTextField pickUpTime_textField;
	private JTextField custName_to_deliver_textField;
	private JTextField delivery_address_textField;
	private JTextField packId_textField;
	private JTextField delivery_phno_textField;
	CourierDAO courierDAO = new CourierDAO();
	CustomerDAO customerDAO = new CustomerDAO();
	/**
	 * Create the panel.
	 * 
	 * @param userInfo
	 * @param currentFrame
	 */
	public DeliveryTicket(JFrame currentFrame, TreeMap<String, Users> userInfo) {
		setLayout(null);
		List<Courier> couriers = courierDAO.getAllCouriers();
		List<Customer> customers = customerDAO.getAllCustomers();
		String packageID = courierDAO.getPackageId();
		WeighedDigraph graph = null;
		try {
			graph = new WeighedDigraph("C:/Users/theza/git/courierservice/CourierService/src/courierMap/courier_map.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		final WeighedDigraph graph1 = graph;
		
		DijkstraFind finder = new DijkstraFind(graph);

		JLabel lblNewLabel = new JLabel("Delivery Ticket");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(232, 5, 128, 57);
		add(lblNewLabel);

		LocalDate localDate = LocalDate.now();
		System.out.println();

		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(45, 90, 56, 16);
		add(lblDate);

		JLabel label = new JLabel(DateTimeFormatter.ofPattern("yyyy-MM-dd")
				.format(localDate));
		label.setBounds(108, 90, 74, 16);
		add(label);

		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(232, 90, 56, 16);
		add(lblTime);

		JLabel lblNewLabel_1 = new JLabel(LocalDateTime.now().getHour() + ":"
				+ LocalDateTime.now().getMinute());
		lblNewLabel_1.setBounds(300, 90, 56, 16);
		add(lblNewLabel_1);
		
		JLabel lblPackageid = new JLabel("PackageID:");
		lblPackageid.setBounds(389, 90, 71, 16);
		add(lblPackageid);

		packId_textField = new JTextField();
		packId_textField.setBounds(473, 87, 116, 22);
		add(packId_textField);
		packId_textField.setColumns(10);
		packId_textField.setText(packageID);

		JLabel lblPickup = new JLabel("Pickup");
		lblPickup.setBounds(45, 145, 56, 16);
		add(lblPickup);

		JLabel lblCustomer = new JLabel("Customer name:");
		lblCustomer.setBounds(79, 190, 103, 16);
		add(lblCustomer);

		JLabel lblCustomerNo = new JLabel("Pickup Address:");
		lblCustomerNo.setBounds(79, 238, 103, 16);
		add(lblCustomerNo);

		JLabel lblPickupTime = new JLabel("Pickup Time (yyyy-MM-dd):");
		lblPickupTime.setBounds(82, 294, 194, 16);
		add(lblPickupTime);

		pickUpAddrss_textField = new JTextField();
		pickUpAddrss_textField.setBounds(288, 235, 172, 22);
		add(pickUpAddrss_textField);
		pickUpAddrss_textField.setColumns(10);

		pickUpTime_textField = new JTextField();
		pickUpTime_textField.setBounds(288, 291, 172, 22);
		add(pickUpTime_textField);
		pickUpTime_textField.setColumns(10);

		JLabel lblDelivery = new JLabel("Delivery");
		lblDelivery.setBounds(45, 362, 56, 16);
		add(lblDelivery);

		JLabel lblNewLabel_2 = new JLabel("Customer name:");
		lblNewLabel_2.setBounds(79, 413, 103, 16);
		add(lblNewLabel_2);
		
		custName_textField = new JTextField();
		custName_textField.setBounds(288, 187, 172, 22);
		add(custName_textField);
		custName_textField.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(79, 461, 116, 16);
		add(lblPhone);

		JLabel lblCustomerNo_1 = new JLabel("Delivery Address:");
		lblCustomerNo_1.setBounds(79, 513, 116, 16);
		add(lblCustomerNo_1);

		custName_to_deliver_textField = new JTextField();
		custName_to_deliver_textField.setBounds(288, 396, 184, 22);
		add(custName_to_deliver_textField);
		custName_to_deliver_textField.setColumns(10);
		
		delivery_phno_textField = new JTextField();
		delivery_phno_textField.setBounds(288, 455, 172, 22);
		add(delivery_phno_textField);
		delivery_phno_textField.setColumns(10);

		delivery_address_textField = new JTextField();
		delivery_address_textField.setBounds(288, 507, 172, 22);
		add(delivery_address_textField);
		delivery_address_textField.setColumns(10);
		
		JLabel lblAssignDeliveryTo = new JLabel("Assign delivery to Courier:");
		lblAssignDeliveryTo.setBounds(61, 568, 178, 16);
		add(lblAssignDeliveryTo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(244, 534, 263, 68);
		add(scrollPane);
		DefaultListModel<String> model = new DefaultListModel<String>();
		for(int i=0; i<couriers.size(); i++) {
			model.addElement(couriers.get(i).getCourierName());
			
		}
		JList list = new JList(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);

		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setRowHeaderView(scrollBar);

		JButton btnContinue = new JButton("Continue");
		btnContinue.setBounds(345, 652, 97, 25);
		add(btnContinue);
		
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateDeliveryTicket deliveryTicket = new CreateDeliveryTicket();
				String selectedCourier = (String)list.getSelectedValue();
				for(int i=0;i<couriers.size(); i++) {
		        	if(couriers.get(i).getCourierName().equalsIgnoreCase(selectedCourier)) {
		        		deliveryTicket.setAssignedCourierNo(couriers.get(i).getCourierNo());
		        		deliveryTicket.setDeliveryStatus("Assigned");
		        	}
		        }
				
				String pickUpCustNo = null;
				Customer customer = null;
				for(int i=0;i<customers.size(); i++) {
		        	if(customers.get(i).getName().equalsIgnoreCase(custName_textField.getText())) {
		        		pickUpCustNo = customers.get(i).getCustomerNo();
		        		customer = customers.get(i);
		        	}
		        }
				deliveryTicket.setCreatedTime(lblNewLabel_1.getText());
				deliveryTicket.setPackageId(packId_textField.getText());
				deliveryTicket.setCreatedCutomerNo(pickUpCustNo);
				deliveryTicket.setDeliveryCustName(custName_to_deliver_textField.getText());
				deliveryTicket.setDeliveryCustPhone(delivery_phno_textField.getText());
				deliveryTicket.setFromAddress(Integer.parseInt(pickUpAddrss_textField.getText()));
				deliveryTicket.setToAddress(Integer.parseInt(delivery_address_textField.getText()));
				ArrayList<Integer> paths = finder.shortestPath(deliveryTicket.getFromAddress(), deliveryTicket.getToAddress());
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date pickUpDate;
				try {
					deliveryTicket.setCreatedDate(formatter.parse(label.getText()));
					pickUpDate = formatter.parse(pickUpTime_textField.getText());
					deliveryTicket.setPickUpTime(pickUpDate);
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(pickUpDate);
					calendar.add(Calendar.DATE, paths.size()/2);  // number of days to add
					deliveryTicket.setEstimatedDeliveryDate(calendar.getTime());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				if(paths != null && paths.size() > 1) {
				deliveryTicket.setDeliveryPath(paths.toString());
				deliveryTicket.setEstimatedBlocks(paths.size());
				deliveryTicket.setBillToDelivery(courierDAO.getBill(deliveryTicket, graph1, paths));
				// deliveryTicket.setBillToPickUP(7.00);
				ArrayList<Integer> pickUpPaths = finder.shortestPath(1, deliveryTicket.getToAddress());
				deliveryTicket.setBillToPickUP(courierDAO.getBillToPickUp(graph1, pickUpPaths, 1, deliveryTicket.getFromAddress()));
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new EstimatedTimeandBill(currentFrame, deliveryTicket, customer, selectedCourier));
				currentFrame.getContentPane().revalidate();
				} else {
					JOptionPane.showMessageDialog(currentFrame, "Currently we are not supporting this route..");
				}
				
			}
		});

	}
}
