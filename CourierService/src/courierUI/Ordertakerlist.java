package courierUI;
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
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import courierDAO.UserDAO;
import courierentity.Users;

public class Ordertakerlist extends JPanel {

	/**
	 * Create the panel.
	 * @param userInfo 
	 * @param currentFrame 
	 */
	public Ordertakerlist(JFrame currentFrame, TreeMap<String, Users> userInfo) {
		setLayout(null);
		UserDAO userDao = new UserDAO();
		
		List<Users> users = userDao.getAllOrderTakers();
		List<String> usernames = new ArrayList<String>();
		
		JLabel lblOrder = new JLabel("Order Taker List");
		lblOrder.setBounds(178, 5, 93, 16);
		add(lblOrder);
		
		JLabel lblNewLabel = new JLabel("Select Order Taker");
		lblNewLabel.setBounds(32, 42, 126, 16);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(115, 71, 200, 150);
		add(scrollPane);
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		for(int i=0; i<users.size(); i++) {
			model.addElement(users.get(i).getUsername());	
		}
		JList list = new JList(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(32, 245, 97, 25);
		add(btnEdit);
		
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Users selectedUser = new Users();
				String selectedValue = (String)list.getSelectedValue();
				for(int i=0;i<users.size(); i++) {
		        	if(users.get(i).getUsername().equalsIgnoreCase(selectedValue)) {
		        		selectedUser = (Users) users.get(i);
		        	}
		        }
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new Editordertaker(currentFrame, selectedUser));
				currentFrame.getContentPane().revalidate();
				
			}
		});
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(164, 245, 97, 25);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new AddOrdertaker(currentFrame, userInfo));
				currentFrame.getContentPane().revalidate();
			}
		});
		add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(308, 245, 97, 25);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedValue = (String)list.getSelectedValue();
				userDao.deleteOrderTaker(selectedValue);
				JOptionPane.showMessageDialog(currentFrame, "Order Taker Deleted");
			}
		});
		add(btnDelete);
		
	}
}
