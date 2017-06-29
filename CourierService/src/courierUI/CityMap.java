package courierUI;

import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import courierentity.Users;

public class CityMap extends JPanel {

	public CityMap(JFrame currentFrame, TreeMap<String, Users> userInfo) {
		setLayout(null);

		
		/*try {
		BufferedImage img = ImageIO.read(new File("/Users/vsuramsetti/Documents/workspace/CourierService/src/courierUI/mapupdate.jpg"));
        ImageIcon icon = new ImageIcon(img);
        JLabel label = new JLabel(icon);
        //JOptionPane.showMessageDialog(null, label);
        currentFrame.getContentPane().add(label);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

}
