
package isma.gui;
import javax.swing.*;

public class EjemploLogin {
	public static void main( String args[] )
	{
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    try {
	    	UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Exception e){   
			System.out.println(e);
		}
		frmLogin aplicacion = new frmLogin();
		aplicacion.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		aplicacion.getContentPane().setLayout(null);
	} 
}