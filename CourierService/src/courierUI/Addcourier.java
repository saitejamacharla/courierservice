package courierUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import courierDAO.CourierDAO;
import courierentity.Courier;
import courierentity.Users;
public class Addcourier extends JPanel {
	private JTextField name_textField;
	private JTextField courNo_textField;
	private JTextField courPhone_textField;
	
	private CourierDAO courierDAO;

	/**
	 * Create the panel.
	 * @param userInfo 
	 * @param currentFrame 
	 */
	public Addcourier(JFrame currentFrame, TreeMap<String, Users> userInfo) {
		setLayout(null);
		courierDAO = new CourierDAO();
		
		JLabel lblAddCourier = new JLabel("Add Courier");
		lblAddCourier.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddCourier.setBounds(198, 33, 196, 27);
		add(lblAddCourier);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(51, 133, 56, 16);
		add(lblName);
		
		JLabel lblCourierNo = new JLabel("Courier no:");
		lblCourierNo.setBounds(51, 225, 82, 16);
		add(lblCourierNo);
		
		JLabel lblPhoneNo = new JLabel("phone no:");
		lblPhoneNo.setBounds(51, 302, 82, 16);
		add(lblPhoneNo);
		
		name_textField = new JTextField();
		name_textField.setBounds(215, 130, 167, 22);
		add(name_textField);
		name_textField.setColumns(10);
		
		courNo_textField = new JTextField();
		courNo_textField.setBounds(212, 222, 182, 22);
		add(courNo_textField);
		courNo_textField.setColumns(10);
		
		courPhone_textField = new JTextField();
		courPhone_textField.setBounds(212, 299, 196, 22);
		add(courPhone_textField);
		courPhone_textField.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(90, 420, 97, 25);
		btnCreate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Courier courier = new Courier();
				courier.setCourierName(name_textField.getText());
				courier.setCourierPhoneNo(courPhone_textField.getText());
				courier.setCourierNo(Integer.parseInt(courNo_textField.getText()));
				courierDAO.saveCourier(courier);
				JOptionPane.showMessageDialog(currentFrame, "Courier Persisted");
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CourierList(currentFrame, null));
				currentFrame.getContentPane().revalidate();
			}
		});
		add(btnCreate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(297, 420, 97, 25);
		btnCancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				name_textField.setText("");
				courPhone_textField.setText("");
				courNo_textField.setText("");
			}
		});
		add(btnCancel);

	}

}
