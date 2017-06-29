package courierUI;

import java.awt.BorderLayout;
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import courierDAO.CustomerDAO;
import courierentity.CourierPerfDetails;
import courierentity.DeliveryTicketDetails;

public class Clientbill extends JPanel {
	private JTextField custName;
	private JTextField startDate_textField;
	private JTextField endDate_textField;
	CustomerDAO customerDAO = null;

	/**
	 * Create the panel.
	 * 
	 * @param currentFrame
	 */
	public Clientbill(JFrame currentFrame) {
		setLayout(null);
		customerDAO = new CustomerDAO();

		JLabel lblClientBill = new JLabel("Client Bill");
		lblClientBill.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClientBill.setBounds(251, 13, 133, 22);
		add(lblClientBill);

		JLabel lblCustomerName = new JLabel("Customer Name:");
		lblCustomerName.setBounds(32, 75, 107, 16);
		add(lblCustomerName);

		custName = new JTextField();
		custName.setBounds(144, 72, 116, 22);
		add(custName);
		custName.setColumns(10);

		JLabel lblStartDate = new JLabel("Start Date (yyyy-MM-dd):");
		lblStartDate.setBounds(32, 131, 75, 16);
		add(lblStartDate);

		startDate_textField = new JTextField();
		startDate_textField.setBounds(144, 128, 116, 22);
		add(startDate_textField);
		startDate_textField.setColumns(10);

		JLabel lblEndDate = new JLabel("End Date (yyyy-MM-dd):");
		lblEndDate.setBounds(366, 131, 56, 16);
		add(lblEndDate);

		endDate_textField = new JTextField();
		endDate_textField.setBounds(449, 128, 116, 22);
		add(endDate_textField);
		endDate_textField.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBounds(46, 212, 554, 290);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Customer name:");
		lblNewLabel.setBounds(12, 13, 102, 16);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("----------");
		lblNewLabel_1.setBounds(154, 13, 120, 16);
		panel.add(lblNewLabel_1);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(311, 206, 56, 16);
		panel.add(lblTotal);

		JLabel lblNewLabel_8 = new JLabel("-------");
		lblNewLabel_8.setBounds(416, 206, 56, 16);
		panel.add(lblNewLabel_8);

		String col[] = { "No", "PackageId", "Date", "deliveredDate", "Bill" };
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(col);
		JTable table = new JTable();
		table.setModel(tableModel);
		table.getColumn("No").setMaxWidth(30);
		table.getColumn("PackageId").setMaxWidth(100);
		table.getColumn("Date").setMaxWidth(170);
		table.getColumn("deliveredDate").setMaxWidth(170);
		table.getColumn("Bill").setMaxWidth(80);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 61, 700, 140);
		scrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane);

		JButton btnPrint = new JButton("Print");
		btnPrint.setBounds(251, 548, 97, 25);
		add(btnPrint);

		JButton btnNewButton = new JButton("Generate");
		btnNewButton.setBounds(402, 548, 97, 25);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<DeliveryTicketDetails> details = customerDAO
						.getCustomerBill(custName.getText(),
								startDate_textField.getText(),
								endDate_textField.getText());
				// removing exisitng rows if any

				if (tableModel.getRowCount() > 0) {
					for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
						tableModel.removeRow(i);
					}
				}

				double totalBill = 0.0;
				int i = 1;
				for (DeliveryTicketDetails deliDetails : details) {
					String year = deliDetails.getActualDeliveryDate() != null ? deliDetails
							.getActualDeliveryDate().toString()
							.substring(24, 28)
							: deliDetails.getEstimatedDeliveryDate().toString()
									.substring(24, 28);
					String deliveredDate = deliDetails.getActualDeliveryDate() != null ? deliDetails
							.getActualDeliveryDate().toString()
							.substring(0, 11)
							+ year + "(AD)"
							: deliDetails.getEstimatedDeliveryDate().toString()
									.substring(0, 11)
									+ year + "(ED)";
					String createdYear = deliDetails.getCreatedDate()
							.toString().substring(24, 28);
					Object[] objs = {
							i,
							deliDetails.getPackageId(),
							deliDetails.getCreatedDate().toString()
									.substring(0, 11)
									+ createdYear, deliveredDate,
							deliDetails.getQuotedPrice() };
					i++;
					totalBill = totalBill + deliDetails.getQuotedPrice();
					tableModel.addRow(objs);
				}
				lblNewLabel_8.setText(String.valueOf(totalBill));
				lblNewLabel_1.setText(custName.getText());
			}
		});

		// Add the button's action
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<DeliveryTicketDetails> details = customerDAO
						.getCustomerBill(custName.getText(),
								startDate_textField.getText(),
								endDate_textField.getText());
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
						g2.drawString("Client Bill", 50, 20);
						double totalBill = 0.0;
						g2.drawString("Customer Name: ", 20, 60);
						g2.drawString(custName.getText(), 160, 60);
						int y= 100;
						for (DeliveryTicketDetails deliDetails : details) {
							String year = deliDetails.getActualDeliveryDate() != null ? deliDetails
									.getActualDeliveryDate().toString()
									.substring(24, 28)
									: deliDetails.getEstimatedDeliveryDate().toString()
											.substring(24, 28);
							String deliveredDate = deliDetails.getActualDeliveryDate() != null ? deliDetails
									.getActualDeliveryDate().toString()
									.substring(0, 11)
									+ year + "(AD)"
									: deliDetails.getEstimatedDeliveryDate().toString()
											.substring(0, 11)
											+ year + "(ED)";
							String createdYear = deliDetails.getCreatedDate()
									.toString().substring(24, 28);
							
							totalBill = totalBill
									+ deliDetails.getQuotedPrice();
							g2.drawString("PackageId: ", 20, y);
							g2.drawString(deliDetails.getPackageId(),
									160, y);
							g2.drawString("Date: ", 20, y+40);
							g2.drawString(deliDetails.getCreatedDate().toString()
									.substring(0, 11)+createdYear,
									160, y+40);
							g2.drawString("Delivery Date: ", 20, y+80);
							g2.drawString(
									deliveredDate,
									160, y+80);
							g2.drawString("Bill: ", 20, y+120);
							g2.drawString(String.valueOf(deliDetails.getQuotedPrice()), 160,
									y+120);
							g2.drawString("------------- ", 20, y+150);
							y = y+150+40;
						}
						g2.drawString("Total Bill: ", 20, y);
						g2.drawString(String.valueOf(totalBill), 160, y);
						
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
		 * JButton btnClose = new JButton("Close"); btnClose.setBounds(559, 548,
		 * 97, 25); add(btnClose);
		 */

	}
}
