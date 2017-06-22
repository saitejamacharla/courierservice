package courierUI;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class CityMap extends JPanel {

	/**
	 * Create the panel.
	 */
	public CityMap() {
		setLayout(null);
		
		JLabel lblCityMap = new JLabel("City Map");
		lblCityMap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCityMap.setBounds(24, 13, 74, 25);
		add(lblCityMap);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(759, 592, 97, 25);
		add(btnClose);

	}
}
