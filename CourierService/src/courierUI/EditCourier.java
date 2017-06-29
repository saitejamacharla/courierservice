package courierUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import courierDAO.CourierDAO;
import courierentity.Courier;

public class EditCourier extends JPanel {
	private JTextField courName_textField;
	private JTextField courPhNo_textField;
	CourierDAO courierDAO = null;

	/**
	 * Create the panel.
	 * @param selectedCourier 
	 * @param currentFrame 
	 */
	public EditCourier(JFrame currentFrame, Courier selectedCourier) {
		setLayout(null);
		courierDAO = new CourierDAO();
		
		JLabel lblNewLabel = new JLabel("Edit Courier");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(176, 13, 148, 61);
		add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(43, 115, 56, 16);
		add(lblName);
		
		JLabel lblNewLabel_1 = new JLabel("Courier no:");
		lblNewLabel_1.setBounds(43, 192, 94, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("phone no:");
		lblNewLabel_2.setBounds(43, 287, 74, 16);
		add(lblNewLabel_2);
		
		courName_textField = new JTextField();
		courName_textField.setBounds(176, 112, 232, 22);
		add(courName_textField);
		courName_textField.setColumns(10);
		courName_textField.setText(selectedCourier.getCourierName());
		
		JLabel label = new JLabel(String.valueOf(selectedCourier.getCourierNo()));
		label.setBounds(176, 192, 158, 16);
		add(label);
		
		courPhNo_textField = new JTextField();
		courPhNo_textField.setBounds(177, 284, 231, 22);
		add(courPhNo_textField);
		courPhNo_textField.setColumns(10);
		courPhNo_textField.setText(selectedCourier.getCourierPhoneNo());
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(92, 390, 97, 25);
		add(btnSave);
		
		btnSave.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Courier courier = new Courier();
				courier.setCourierName(courName_textField.getText());
				courier.setCourierPhoneNo(courPhNo_textField.getText());
				courier.setCourierNo(selectedCourier.getCourierNo());
				courier.setCourierBonus(selectedCourier.getCourierBonus());
				courierDAO.updateCourier(courier);
				JOptionPane.showMessageDialog(currentFrame, "Courier Details Updated");
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CourierList(currentFrame, null));
				currentFrame.getContentPane().revalidate();
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(297, 390, 97, 25);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CourierList(currentFrame, null));
				currentFrame.getContentPane().revalidate();
			}
		});
		add(btnCancel);

	}

}
