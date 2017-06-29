package courierUI;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
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

import courierDAO.CourierDAO;
import courierentity.Courier;
import courierentity.CourierPerfDetails;
import courierentity.Users;

public class CourierPerformance extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	CourierDAO courierDAO = null;

	/**
	 * Create the panel.
	 * 
	 * @param userInfo
	 * @param currentFrame
	 */
	public CourierPerformance(JFrame currentFrame,
			TreeMap<String, Users> userInfo) {
		setLayout(null);
		courierDAO = new CourierDAO();
		List<Courier> couriers = courierDAO.getAllCouriers();

		JLabel lblCourierPerformance = new JLabel("Courier Performance");
		lblCourierPerformance.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCourierPerformance.setBounds(238, 13, 190, 35);
		add(lblCourierPerformance);

		JLabel lblStartDate = new JLabel("Start Date (yyyy-MM-dd):");
		lblStartDate.setBounds(24, 87, 77, 16);
		add(lblStartDate);

		textField = new JTextField();
		textField.setBounds(115, 84, 116, 22);
		add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("End Date (yyyy-MM-dd):");
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

		DefaultListModel<String> model = new DefaultListModel<String>();
		for (int i = 0; i < couriers.size(); i++) {
			model.addElement(couriers.get(i).getCourierName());

		}

		JList list = new JList(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(126, 13, 121, 16);
		panel_1.add(lblNewLabel_1);

		JLabel lblNo = new JLabel("No");
		lblNo.setBounds(12, 82, 35, 16);
		panel_1.add(lblNo);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(12, 127, 35, 26);
		panel_1.add(lblNewLabel_2);

		JLabel lblPackageid = new JLabel("CourierNo");
		lblPackageid.setBounds(42, 82, 93, 16);
		panel_1.add(lblPackageid);

		JLabel label = new JLabel("");
		label.setBounds(52, 127, 83, 16);
		panel_1.add(label);

		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(165, 82, 56, 16);
		panel_1.add(lblDate);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(153, 127, 78, 16);
		panel_1.add(label_1);

		JLabel lblNoofDeliveries = new JLabel("No.of Deliveries");
		lblNoofDeliveries.setBounds(233, 82, 121, 16);
		panel_1.add(lblNoofDeliveries);

		JLabel label_2 = new JLabel("-");
		label_2.setBounds(243, 127, 56, 16);
		panel_1.add(label_2);

		JLabel lblBonus = new JLabel("Bonus");
		lblBonus.setBounds(372, 82, 66, 16);
		panel_1.add(lblBonus);

		JLabel label_3 = new JLabel("-");
		label_3.setBounds(372, 120, 56, 16);
		panel_1.add(label_3);

		JButton btnPrint = new JButton("Print");
		btnPrint.setBounds(273, 543, 97, 25);
		add(btnPrint);

		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(418, 543, 97, 25);
		add(btnGenerate);
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourierPerfDetails courierPerfDetails = courierDAO
						.getCourierPerformance(textField_2.getText(),
								textField.getText(), textField_1.getText());
				if (courierPerfDetails != null) {
					lblNewLabel_1.setText(courierPerfDetails.getCourierName());
					lblNewLabel_2.setText("1");
					label.setText(courierPerfDetails.getCourrierNo());
					label_1.setText(textField_1.getText());
					label_2.setText(courierPerfDetails.getNoOfDeliveries());
					label_3.setText(courierPerfDetails.getBonus());				
				} else {
					lblNewLabel_1.setText("");
					lblNewLabel_2.setText("");
					label.setText("");
					label_1.setText("");
					label_2.setText("");
					label_3.setText("");
				}
			}
		});

		// Add the button's action
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourierPerfDetails courierPerfDetails = courierDAO
						.getCourierPerformance(textField_2.getText(),
								textField.getText(), textField_1.getText());
				PrinterJob pj = PrinterJob.getPrinterJob();
				pj.setJobName(" Print Component ");
				pj.setPrintable(new Printable() {
					public int print(Graphics pg, PageFormat pf, int pageNum) {
						if (pageNum > 0) {
							return Printable.NO_SUCH_PAGE;
						}

						Graphics2D g2 = (Graphics2D) pg;
						g2.translate(pf.getImageableX(), pf.getImageableY());
						g2.translate(pf.getImageableX(), pf.getImageableY());
						g2.drawString("Courier Perfomance ", 50, 20);
						g2.drawString("CourierNo: ", 20, 60);
						g2.drawString(courierPerfDetails.getCourrierNo(), 160,
								60);
						g2.drawString("CourierName: ", 20, 100);
						g2.drawString(courierPerfDetails.getCourierName(), 160,
								100);
						g2.drawString("No.of Deliveries: ", 20, 140);
						g2.drawString(courierPerfDetails.getNoOfDeliveries(),
								160, 140);
						g2.drawString("Bonus: ", 20, 180);
						g2.drawString(courierPerfDetails.getBonus(), 160, 180);
						return Printable.PAGE_EXISTS;

					}
				});

				if (pj.printDialog() == false)
					return;

				try {
					pj.print();
				} catch (PrinterException ex) {
					// handle exception
				}

				/*
				 * JButton btnClose = new JButton("Close");
				 * btnClose.setBounds(602, 543, 97, 25); add(btnClose);
				 */

			}
		});
	}
}
