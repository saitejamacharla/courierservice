package courierUI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateClosedIntersections extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public UpdateClosedIntersections() {
		setLayout(null);
		
		JLabel lblUpdateClosedIntersection = new JLabel("Update Closed Intersection");
		lblUpdateClosedIntersection.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUpdateClosedIntersection.setBounds(187, 29, 272, 48);
		add(lblUpdateClosedIntersection);
		
		JLabel lblCrossingStreets = new JLabel("Crossing Streets");
		lblCrossingStreets.setBounds(46, 107, 103, 16);
		add(lblCrossingStreets);
		
		JLabel lblStreet = new JLabel("Street 1:");
		lblStreet.setBounds(75, 152, 56, 16);
		add(lblStreet);
		
		JLabel lblStreet_1 = new JLabel("Street 2:");
		lblStreet_1.setBounds(75, 207, 56, 16);
		add(lblStreet_1);
		
		JLabel lblClosingDates = new JLabel("Closing Dates");
		lblClosingDates.setBounds(46, 287, 103, 16);
		add(lblClosingDates);
		
		JLabel lblNewLabel = new JLabel("Starting Date:");
		lblNewLabel.setBounds(75, 343, 92, 16);
		add(lblNewLabel);
		
		JLabel lblEndingDate = new JLabel("Ending Date:");
		lblEndingDate.setBounds(75, 391, 74, 16);
		add(lblEndingDate);
		
		textField = new JTextField();
		textField.setBounds(162, 149, 342, 22);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(162, 204, 307, 22);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(187, 340, 200, 22);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(185, 388, 202, 22);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lbloptional = new JLabel("(optional)");
		lbloptional.setBounds(413, 343, 56, 16);
		add(lbloptional);
		
		JLabel lbloptional_1 = new JLabel("(optional)");
		lbloptional_1.setBounds(413, 391, 56, 16);
		add(lbloptional_1);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(185, 467, 97, 25);
		add(btnUpdate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(370, 467, 97, 25);
		add(btnCancel);

	}

}
