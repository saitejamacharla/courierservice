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
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import courierDAO.CourierDAO;
import courierentity.CompanyPerfDetails;
import courierentity.CourierPerfDetails;
import courierentity.Users;

public class CompanyPerformance extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	CourierDAO courierDAO = null;

	/**
	 * Create the panel.
	 * 
	 * @param userInfo
	 * @param currentFrame
	 */
	public CompanyPerformance(JFrame currentFrame,
			TreeMap<String, Users> userInfo) {
		setLayout(null);
		courierDAO = new CourierDAO();

		JLabel lblCompanyPerformance = new JLabel("Company Performance");
		lblCompanyPerformance.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCompanyPerformance.setBounds(295, 13, 207, 57);
		add(lblCompanyPerformance);

		JLabel lblMonth = new JLabel("Month:");
		lblMonth.setBounds(30, 103, 56, 16);
		add(lblMonth);

		textField = new JTextField();
		textField.setBounds(128, 100, 116, 22);
		add(textField);
		textField.setColumns(10);

		JLabel lblYear = new JLabel("Year:");
		lblYear.setBounds(408, 103, 56, 16);
		add(lblYear);

		textField_1 = new JTextField();
		textField_1.setBounds(473, 100, 116, 22);
		add(textField_1);
		textField_1.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBounds(45, 173, 648, 196);
		add(panel);
		panel.setLayout(null);

		JLabel lblNoOfCustomers = new JLabel("No. of customers");
		lblNoOfCustomers.setBounds(12, 25, 117, 28);
		panel.add(lblNoOfCustomers);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(12, 80, 56, 16);
		panel.add(lblNewLabel);

		JLabel lblNoofDeliveries = new JLabel("No.of Deliveries");
		lblNoofDeliveries.setBounds(155, 31, 102, 22);
		panel.add(lblNoofDeliveries);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(170, 80, 56, 16);
		panel.add(lblNewLabel_1);

		JLabel lblMonthPerformance = new JLabel("Month Performance (50/Month)");
		lblMonthPerformance.setBounds(322, 34, 132, 16);
		panel.add(lblMonthPerformance);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(348, 80, 56, 16);
		panel.add(lblNewLabel_2);

		JLabel lblSales = new JLabel("Sales");
		lblSales.setBounds(554, 31, 56, 16);
		panel.add(lblSales);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(538, 80, 56, 16);
		panel.add(lblNewLabel_3);

		JButton btnPrint = new JButton("Print");
		btnPrint.setBounds(215, 440, 97, 25);
		add(btnPrint);

		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(367, 440, 97, 25);
		add(btnGenerate);

		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String month = textField.getText();
				String year = textField_1.getText();
				CompanyPerfDetails companyPerfDetails = courierDAO
						.getCompanyPerformance(month, year);
				if (companyPerfDetails != null) {
					lblNewLabel.setText(companyPerfDetails.getCustomerCount());
					lblNewLabel_1.setText(companyPerfDetails
							.getDeliveriesCount());
					lblNewLabel_2.setText(companyPerfDetails
							.getMonthPerformance());
					lblNewLabel_3.setText(companyPerfDetails.getSales());
				}
			}
		});
		
		// Add the button's action
				btnPrint.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String month = textField.getText();
						String year = textField_1.getText();
						CompanyPerfDetails companyPerfDetails = courierDAO
								.getCompanyPerformance(month, year);
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
								g2.drawString("Company Perfomance ", 50, 20);
								g2.drawString("No.Of Customers: ", 20, 60);
								g2.drawString(companyPerfDetails.getCustomerCount(), 160,
										60);
								g2.drawString("No.Of Deliveries: ", 20, 100);
								g2.drawString(companyPerfDetails.getDeliveriesCount(), 160,
										100);
								g2.drawString("Month Performance: ", 20, 140);
								g2.drawString(companyPerfDetails.getMonthPerformance(),
										160, 140);
								g2.drawString("Sales: ", 20, 180);
								g2.drawString(companyPerfDetails.getSales(), 160, 180);
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

		/*
		 * JButton btnCancel = new JButton("Cancel"); btnCancel.setBounds(530,
		 * 440, 97, 25); add(btnCancel);
		 */

	}
}
