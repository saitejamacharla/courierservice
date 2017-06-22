package courierUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
import javax.swing.ListSelectionModel;

import courierDAO.CustomerDAO;
import courierentity.Customer;
import courierentity.Users;

public class CustomerList extends JPanel {
	
	CustomerDAO customerDAO = null;

	/**
	 * Create the panel.
	 * @param userInfo 
	 * @param currentFrame 
	 */
	public CustomerList(JFrame currentFrame, TreeMap<String, Users> userInfo) {
		setLayout(null);
		customerDAO = new CustomerDAO();
		List<Customer> customers = customerDAO.getAllCustomers();
		List<String> usernames = new ArrayList<String>();
		
		JLabel lblNewLabel = new JLabel("Customer List");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(218, 5, 159, 46);
		add(lblNewLabel);
		
		JLabel lblSelectCustomer = new JLabel("Select Customer");
		lblSelectCustomer.setBounds(38, 83, 105, 16);
		add(lblSelectCustomer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(105, 132, 352, 176);
		add(scrollPane);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setRowHeaderView(scrollBar);
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		for(int i=0; i<customers.size(); i++) {
			model.addElement(customers.get(i).getName());
			
		}
		JList list = new JList(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(83, 366, 97, 25);
		add(btnEdit);
		
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer selectedCust = new Customer();
				String selectedValue = (String)list.getSelectedValue();
				for(int i=0;i<customers.size(); i++) {
		        	if(customers.get(i).getName().equalsIgnoreCase(selectedValue)) {
		        		selectedCust = (Customer) customers.get(i);
		        	}
		        }
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new EditCustomer(currentFrame, selectedCust));
				currentFrame.getContentPane().revalidate();
				
			}
		});
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(280, 366, 97, 25);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new AddCustomer(currentFrame, userInfo));
				currentFrame.getContentPane().revalidate();
			}
		});
		add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(445, 366, 97, 25);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer selectedCust = new Customer();
				String selectedValue = (String)list.getSelectedValue();
				for(int i=0;i<customers.size(); i++) {
		        	if(customers.get(i).getName().equalsIgnoreCase(selectedValue)) {
		        		selectedCust = (Customer) customers.get(i);
		        	}
		        }
				customerDAO.deletCustomer(selectedCust);
				JOptionPane.showMessageDialog(currentFrame, "Customer Deleted");
			}
		});
		add(btnDelete);

	}
}
