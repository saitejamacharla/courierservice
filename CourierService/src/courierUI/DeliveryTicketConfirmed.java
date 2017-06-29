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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import courierentity.CompanyPerfDetails;
import courierentity.CreateDeliveryTicket;
import courierentity.Customer;

public class DeliveryTicketConfirmed extends JPanel {

	/**
	 * Create the panel.
	 * 
	 * @param deliveryTicket
	 * @param currentFrame
	 * @param customer
	 * @param selectedCourier
	 */
	public DeliveryTicketConfirmed(JFrame currentFrame,
			CreateDeliveryTicket deliveryTicket, Customer customer,
			String selectedCourier) {
		setLayout(null);

		JLabel lblDeliveryTicketConfirmed = new JLabel(
				"Delivery Ticket Confirmed");
		lblDeliveryTicketConfirmed.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDeliveryTicketConfirmed.setBounds(233, 30, 295, 46);
		add(lblDeliveryTicketConfirmed);

		JButton btnPrintDeliveryTicket = new JButton("Print Delivery Ticket");
		btnPrintDeliveryTicket.setBounds(752, 625, 154, 25);
		add(btnPrintDeliveryTicket);

		JLabel lblNewLabel = new JLabel("PackageID:");
		lblNewLabel.setBounds(555, 89, 85, 16);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(deliveryTicket.getPackageId());
		lblNewLabel_1.setBounds(640, 89, 106, 16);
		add(lblNewLabel_1);

		JLabel lblCu = new JLabel("Customer name:");
		lblCu.setBounds(43, 153, 117, 16);
		add(lblCu);

		JLabel lblAssignedCourier = new JLabel("Assigned Courier:");
		lblAssignedCourier.setBounds(505, 207, 106, 16);
		add(lblAssignedCourier);

		JLabel lblNewLabel_2 = new JLabel("Pickup Address:");
		lblNewLabel_2.setBounds(43, 207, 99, 16);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel(customer.getName());
		lblNewLabel_3.setBounds(172, 153, 99, 16);
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel(String.valueOf(deliveryTicket
				.getFromAddress()));
		lblNewLabel_4.setBounds(162, 207, 154, 16);
		add(lblNewLabel_4);

		JLabel lblDeliveryCustomerName = new JLabel("Delivery customer name:");
		lblDeliveryCustomerName.setBounds(43, 280, 148, 16);
		add(lblDeliveryCustomerName);

		JLabel lblNewLabel_5 = new JLabel("Delivery address:");
		lblNewLabel_5.setBounds(43, 329, 99, 16);
		add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel(deliveryTicket.getDeliveryCustName());
		lblNewLabel_6.setBounds(213, 280, 117, 16);
		add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel(String.valueOf(deliveryTicket
				.getToAddress()));
		lblNewLabel_7.setBounds(213, 329, 56, 16);
		add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel(selectedCourier);
		lblNewLabel_8.setBounds(640, 207, 106, 16);
		add(lblNewLabel_8);

		JLabel lblAssignedTime = new JLabel("Assigned Time:");
		lblAssignedTime.setBounds(505, 261, 106, 16);
		add(lblAssignedTime);

		JLabel lblPickupTime = new JLabel("Pickup Time:");
		lblPickupTime.setBounds(505, 311, 93, 16);
		add(lblPickupTime);

		JLabel lblNewLabel_9 = new JLabel(deliveryTicket.getCreatedDate()
				.toString());
		lblNewLabel_9.setBounds(637, 261, 56, 16);
		add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel(deliveryTicket.getPickUpTime()
				.toString());
		lblNewLabel_10.setBounds(637, 311, 56, 16);
		add(lblNewLabel_10);

		JLabel lblInstruction = new JLabel("Instructions:");
		lblInstruction.setBounds(12, 397, 93, 16);
		add(lblInstruction);

		JLabel lblPickedTime = new JLabel("Picked Time:");
		lblPickedTime.setBounds(555, 436, 85, 16);
		add(lblPickedTime);

		JLabel lblNewLabel_12 = new JLabel(deliveryTicket.getPickUpTime()
				.toString());
		lblNewLabel_12.setBounds(683, 436, 197, 16);
		add(lblNewLabel_12);

		JLabel lblDeliveredTime = new JLabel("Delivery Time:");
		lblDeliveredTime.setBounds(555, 490, 99, 16);
		add(lblDeliveredTime);

		JLabel lblNewLabel_13 = new JLabel(deliveryTicket
				.getEstimatedDeliveryDate().toString());
		lblNewLabel_13.setBounds(683, 490, 248, 16);
		add(lblNewLabel_13);

		JLabel lblBlocks = new JLabel("Blocks:");
		lblBlocks.setBounds(555, 539, 56, 16);
		add(lblBlocks);

		JLabel lblNewLabel_14 = new JLabel(String.valueOf(deliveryTicket
				.getEstimatedBlocks()));
		lblNewLabel_14.setBounds(690, 539, 106, 16);
		add(lblNewLabel_14);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 436, 446, 220);
		add(scrollPane);

		JTextArea textArea = new JTextArea(16, 58);
		textArea.setEditable(false);
		textArea.setText(deliveryTicket.getInstructions());
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(textArea);
		// JList list = new JList();
		// scrollPane.setViewportView(list);

		// Add the button's action
		btnPrintDeliveryTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
						g2.drawString("Delivery Ticket Details ", 50, 20);
						g2.drawString("Package ID: ", 20, 60);
						g2.drawString(deliveryTicket.getPackageId(), 160, 60);
						g2.drawString("Customer Name: ", 20, 100);
						g2.drawString(customer.getName(), 160, 100);
						g2.drawString("Assgined Courier: ", 20, 140);
						g2.drawString(selectedCourier,
								160, 140);
						g2.drawString("PickUp Address ", 20, 180);
						g2.drawString(
								String.valueOf(deliveryTicket.getFromAddress()),
								160, 180);
						g2.drawString("PickUp Date: ", 20, 220);
						g2.drawString(
								deliveryTicket.getPickUpTime().toString(), 160,
								220);
						g2.drawString("Delivery Date: ", 20, 260);
						g2.drawString(deliveryTicket.getEstimatedDeliveryDate()
								.toString(), 160, 260);
						g2.drawString("Instructions: ", 20, 300);
						g2.drawString(deliveryTicket.getInstructions().substring(0, 59), 160,
								300);
						g2.drawString(deliveryTicket.getInstructions().substring(59, deliveryTicket.getInstructions().length()), 160,
								320);
						g2.drawString("Delivery To: ", 20, 380);
						g2.drawString("Name: ", 20, 420);
						g2.drawString(deliveryTicket.getDeliveryCustName(), 160,
								420);
						g2.drawString("Phone: ", 20, 460);
						g2.drawString(deliveryTicket.getDeliveryCustPhone(), 160,
								460);
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
