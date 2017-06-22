package courierUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import courierentity.Users;

public class Main extends JFrame {

	private JPanel contentPane;
	private static final String FILE_PATH = "C:/Users/theza/git/courierservice/CourierService/src/courierUI/Map.jpg";
	
	private TreeMap<String, Users> userInfo = new TreeMap<String, Users>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		JFrame currentFrame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 558);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnHome = new JMenu("Home");
		menuBar.add(mnHome);
		
		JMenuItem mntmLogin = new JMenuItem("Login");
		mnHome.add(mntmLogin);
		
		JMenu mnNewMenu = new JMenu("Maintainance");
		mnNewMenu.setVisible(false);
		menuBar.add(mnNewMenu);
		
		JMenu mnCompanyInformation = new JMenu("Company Information");
		mnNewMenu.add(mnCompanyInformation);
		

		JMenuItem mntmViewComapnyInfo = new JMenuItem("View Comapny Info");
		mnCompanyInformation.add(mntmViewComapnyInfo);
		mntmViewComapnyInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new ViewCompanyInformation(currentFrame));
				getContentPane().revalidate();
			}
		});
		
		JMenuItem mntmUpdateCompanyInfo = new JMenuItem("Update Company Info");
		mnCompanyInformation.add(mntmUpdateCompanyInfo);
		mntmUpdateCompanyInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new UpdateCompanyInformation(currentFrame));
				getContentPane().revalidate();
			}
		});
		
		JMenu mnOrderTakerSelection = new JMenu("Order Taker Selection");
		mnNewMenu.add(mnOrderTakerSelection);
		
		JMenuItem mntmOrderTakerList = new JMenuItem("Order Taker List");
		mnOrderTakerSelection.add(mntmOrderTakerList);
		
		mntmOrderTakerList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new Ordertakerlist(currentFrame, userInfo));
				getContentPane().revalidate();
			}
		});
		
		JMenuItem mntmAddOrderTaker = new JMenuItem("Add Order Taker");
		mnOrderTakerSelection.add(mntmAddOrderTaker);
		mntmAddOrderTaker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new AddOrdertaker(currentFrame, userInfo));
				getContentPane().revalidate();
			}
		});
		
		/*JMenuItem mntmEditOrderTaker = new JMenuItem("Edit Order Taker");
		mnOrderTakerSelection.add(mntmEditOrderTaker);*/
		
		JMenu mnCustomerSelection = new JMenu("Customer Selection");
		mnNewMenu.add(mnCustomerSelection);
		
		JMenuItem mntmCustomerList = new JMenuItem("Customer List");
		mnCustomerSelection.add(mntmCustomerList);
		
		mntmCustomerList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new CustomerList(currentFrame, userInfo));
				getContentPane().revalidate();
			}
		});
		
		JMenuItem mntmAddCustomer = new JMenuItem("Add Customer");
		mnCustomerSelection.add(mntmAddCustomer);
		
		mntmAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new AddCustomer(currentFrame, userInfo));
				getContentPane().revalidate();
			}
		});
		
		/*JMenuItem mntmEditCustomer = new JMenuItem("Edit Customer");
		mnCustomerSelection.add(mntmEditCustomer);*/
		
		JMenu mnMap = new JMenu("Map");
		mnNewMenu.add(mnMap);
		
		JMenuItem mntmCityMap = new JMenuItem("City Map");
		mnMap.add(mntmCityMap);
		mntmCityMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			getContentPane().removeAll();
			try {
			BufferedImage img = ImageIO.read(new File(FILE_PATH));
			        ImageIcon icon = new ImageIcon(img);
			        JLabel label = new JLabel(icon);
			        getContentPane().add(label);
			} catch (Exception e1) {
			e1.printStackTrace();
			}
			getContentPane().revalidate();
			}
			});
		
		JMenuItem mntmClosedIntersection = new JMenuItem("Closed Intersection");
		mnMap.add(mntmClosedIntersection);
		
		JMenu mnCourierSelection = new JMenu("Courier Selection");
		mnNewMenu.add(mnCourierSelection);
		
		JMenuItem mntmCourierList = new JMenuItem("Courier List");
		mnCourierSelection.add(mntmCourierList);
		
		mntmCourierList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new CourierList(currentFrame, userInfo));
				getContentPane().revalidate();
			}
		});
		
		JMenuItem mntmAddCourier = new JMenuItem("Add Courier");
		mnCourierSelection.add(mntmAddCourier);
		
		mntmAddCourier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new Addcourier(currentFrame, userInfo));
				getContentPane().revalidate();
			}
		});
		
		/*JMenuItem mntmEditCourier = new JMenuItem("Edit Courier");
		mnCourierSelection.add(mntmEditCourier);*/
		
		JMenu mnNewMenu_1 = new JMenu("DeliveryTicket");
		mnNewMenu_1.setVisible(false);
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmCreate = new JMenuItem("Create");
		mnNewMenu_1.add(mntmCreate);
		
		
		JMenuItem mntmDeliveredTicket = new JMenuItem("Delivered Ticket");
		mnNewMenu_1.add(mntmDeliveredTicket);
		
		JMenuItem mntmDeliveryTicketList = new JMenuItem("Delivery Ticket List");
		mnNewMenu_1.add(mntmDeliveryTicketList);
		
		JMenu mnNewMenu_2 = new JMenu("Report");
		mnNewMenu_2.setVisible(false);
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmClientBill = new JMenuItem("Client Bill");
		mnNewMenu_2.add(mntmClientBill);
		
		JMenuItem mntmCourierPerformance = new JMenuItem("Courier Performance");
		mnNewMenu_2.add(mntmCourierPerformance);
		
		JMenuItem mntmCompanyPerformance = new JMenuItem("Company Performance");
		mnNewMenu_2.add(mntmCompanyPerformance);
		
		JMenu mnAccount = new JMenu("Account");
		mnAccount.setVisible(false);
		menuBar.add(mnAccount);
		
		JMenuItem mntmAcctProfile = new JMenuItem("Profile");
		mnAccount.add(mntmAcctProfile);
		
		mntmAcctProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new userprofilepage(currentFrame, userInfo));
				getContentPane().revalidate();
			}
		});
		
		JMenuItem mntmChangePassword = new JMenuItem("Change Password");
		mnAccount.add(mntmChangePassword);
		mntmChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new ChangePassword(currentFrame));
				getContentPane().revalidate();
			}
		});
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mnAccount.add(mntmLogout);
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userInfo.remove(userInfo.firstKey());
				getContentPane().removeAll();
				List<JMenu> jMenus= new ArrayList<JMenu>();
				jMenus.add(mnNewMenu);
				jMenus.add(mnNewMenu_1);
				jMenus.add(mnNewMenu_2);
				jMenus.add(mnAccount);
				for(int i=0;i<jMenus.size(); i++) {
					jMenus.get(i).setVisible(false);
				}
				getContentPane().add(new LogIn(currentFrame, userInfo, jMenus));
				getContentPane().revalidate();
			}
		});
		
		mntmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				List<JMenu> jMenus= new ArrayList<JMenu>();
				jMenus.add(mnNewMenu);
				jMenus.add(mnNewMenu_1);
				jMenus.add(mnNewMenu_2);
				jMenus.add(mnAccount);
				getContentPane().add(new LogIn(currentFrame, userInfo, jMenus));
				getContentPane().revalidate();
			}
		});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblAcmeCourierService = new JLabel("ACME COURIER SERVICE");
		lblAcmeCourierService.setFont(new Font("Snap ITC", Font.BOLD, 30));
		contentPane.add(lblAcmeCourierService, BorderLayout.CENTER);
	}

}
