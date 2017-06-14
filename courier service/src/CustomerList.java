import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;

public class CustomerList extends JPanel {

	/**
	 * Create the panel.
	 */
	public CustomerList() {
		setLayout(null);
		
		JLabel lblCustomerList = new JLabel("Customer List");
		lblCustomerList.setBounds(159, 25, 81, 14);
		add(lblCustomerList);
		
		JLabel lblNewLabel = new JLabel("Select Customer");
		lblNewLabel.setBounds(55, 62, 92, 14);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(58, 217, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setBounds(165, 217, 89, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setBounds(274, 217, 89, 23);
		add(btnNewButton_2);

	}
}
