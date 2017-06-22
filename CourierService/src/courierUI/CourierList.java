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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import courierDAO.CourierDAO;
import courierentity.Courier;
import courierentity.Users;


public class CourierList extends JPanel {
	
	CourierDAO courierDAO = new CourierDAO();
	

	/**
	 * Create the panel.
	 * @param userInfo 
	 * @param currentFrame 
	 */
	public CourierList(JFrame currentFrame, TreeMap<String, Users> userInfo) {
		setLayout(null);
		List<Courier> couriers = courierDAO.getAllCouriers();
		
		JLabel lblNewLabel = new JLabel("Courier List");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(217, 25, 205, 43);
		add(lblNewLabel);
		
		JLabel lblSelectCourier = new JLabel("Select Courier:");
		lblSelectCourier.setBounds(30, 98, 105, 16);
		add(lblSelectCourier);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(130, 141, 292, 219);
		add(scrollPane);
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		for(int i=0; i<couriers.size(); i++) {
			model.addElement(couriers.get(i).getCourierName());
			
		}
		JList list = new JList(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(82, 426, 97, 25);
		add(btnEdit);
		
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Courier selectedCourier = new Courier();
				String selectedValue = (String)list.getSelectedValue();
				for(int i=0;i<couriers.size(); i++) {
		        	if(couriers.get(i).getCourierName().equalsIgnoreCase(selectedValue)) {
		        		selectedCourier = (Courier) couriers.get(i);
		        	}
		        }
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new EditCourier(currentFrame, selectedCourier));
				currentFrame.getContentPane().revalidate();
				
			}
		});
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(245, 426, 97, 25);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new Addcourier(currentFrame, null));
				currentFrame.getContentPane().revalidate();
			}
		});
		add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(397, 426, 97, 25);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Courier selectedCourier = new Courier();
				String selectedValue = (String)list.getSelectedValue();
				for(int i=0;i<couriers.size(); i++) {
		        	if(couriers.get(i).getCourierName().equalsIgnoreCase(selectedValue)) {
		        		selectedCourier = (Courier) couriers.get(i);
		        	}
		        }
				courierDAO.deleteCourier(selectedCourier);
				JOptionPane.showMessageDialog(currentFrame, "Courier Deleted");
			}
		});
		add(btnDelete);

	}
}
