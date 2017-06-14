import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;


public class viewcompany extends JPanel {

	/**
	 * Create the panel.
	 */
	public viewcompany() {
		setLayout(null);
		
		JButton btnConfirm = new JButton("  Update");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfirm.setBounds(243, 248, 89, 23);
		add(btnConfirm);
		
		JLabel lblView = new JLabel("View Company Information");
		lblView.setBounds(36, 35, 198, 14);
		add(lblView);
		
		JLabel lblNewLabel = new JLabel("BillRate       :        $10-$2 /block");
		lblNewLabel.setBounds(-169, 56, 218, 14);
		add(lblNewLabel);
		
		JLabel lblBillrate = new JLabel("BillRate                :            $10-$2 /block        ");
		lblBillrate.setBounds(53, 76, 238, 14);
		add(lblBillrate);
		
		JLabel lblNewLabel_1 = new JLabel("Bonus                  :           $2");
		lblNewLabel_1.setBounds(53, 101, 181, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone Number    :           405-777-9131");
		lblNewLabel_2.setBounds(53, 127, 198, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Base Bill Amount :          $10");
		lblNewLabel_3.setBounds(53, 152, 209, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Bonus Total Time:          10:10");
		lblNewLabel_4.setBounds(53, 177, 198, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Address              :         4th Ave dr");
		lblNewLabel_5.setBounds(53, 202, 198, 14);
		add(lblNewLabel_5);

	}
}
