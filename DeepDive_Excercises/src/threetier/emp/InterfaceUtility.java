package threetier.emp;

import javax.swing.JOptionPane;

public class InterfaceUtility {
	public static String getString(String messageToDisplay) {
		// TODO Auto-generated method stub
		return JOptionPane.showInputDialog(messageToDisplay);
	}

	public static int getNumber(String hello) {
		// TODO Auto-generated method stub
		return Integer.parseInt(getString(hello));
	}

	public static void display(String string) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, string);
		
	}

}
