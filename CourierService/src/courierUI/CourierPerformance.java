package courierUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JButton;

public class CourierPerformance extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public CourierPerformance() {
		setLayout(null);
		
		JLabel lblCourierPerformance = new JLabel("Courier Performance");
		lblCourierPerformance.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCourierPerformance.setBounds(238, 13, 190, 35);
		add(lblCourierPerformance);
		
		JLabel lblStartDate = new JLabel("Start Date:");
		lblStartDate.setBounds(24, 87, 77, 16);
		add(lblStartDate);
		
		textField = new JTextField();
		textField.setBounds(115, 84, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("End Date:");
		lblNewLabel.setBounds(302, 87, 56, 16);
		add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(370, 84, 116, 22);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCourierName = new JLabel("Courier Name:");
		lblCourierName.setBounds(585, 87, 97, 16);
		add(lblCourierName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(694, 84, 182, 22);
		add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(24, 178, 334, 344);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblCourierList = new JLabel("Courier List");
		lblCourierList.setBounds(137, 24, 65, 16);
		panel.add(lblCourierList);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 66, 285, 265);
		panel.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setRowHeaderView(scrollBar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(418, 178, 458, 335);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCourierName_1 = new JLabel("Courier name:");
		lblCourierName_1.setBounds(12, 13, 83, 16);
		panel_1.add(lblCourierName_1);
		
		JLabel lblNewLabel_1 = new JLabel("---------");
		lblNewLabel_1.setBounds(126, 13, 121, 16);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNo = new JLabel("No");
		lblNo.setBounds(12, 82, 35, 16);
		panel_1.add(lblNo);
		
		JLabel lblNewLabel_2 = new JLabel("--");
		lblNewLabel_2.setBounds(12, 127, 35, 26);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblPackageid = new JLabel("CourierNo");
		lblPackageid.setBounds(69, 82, 66, 16);
		panel_1.add(lblPackageid);
		
		JLabel label = new JLabel("------");
		label.setBounds(69, 137, 56, 16);
		panel_1.add(label);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(165, 82, 56, 16);
		panel_1.add(lblDate);
		
		JLabel label_1 = new JLabel("--------");
		label_1.setBounds(165, 132, 56, 16);
		panel_1.add(label_1);
		
		JLabel lblNoofDeliveries = new JLabel("No.of Deliveries");
		lblNoofDeliveries.setBounds(296, 82, 121, 16);
		panel_1.add(lblNoofDeliveries);
		
		JLabel label_2 = new JLabel("--------");
		label_2.setBounds(320, 132, 56, 16);
		panel_1.add(label_2);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setBounds(273, 543, 97, 25);
		add(btnPrint);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(418, 543, 97, 25);
		add(btnGenerate);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(602, 543, 97, 25);
		add(btnClose);

	}
}
