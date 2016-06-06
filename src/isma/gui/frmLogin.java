
package isma.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import alfredo_javierpoyectofinal.db.DbUsuario;
import alfredo_javierpoyectofinal.db.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class frmLogin extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField usuario1;
	private JPasswordField contrasena;
	private JButton boton_aceptar, boton_cancelar;
	private JLabel label1, label2;
	private Container caja_prinippppl;
	public frmLogin()
	{
		super("Acceso al Sistema Hotel 2015-2016");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alfre\\workspace\\ProyectoJavier\\imagenes\\hotel (2).png"));

		
		label1 = new JLabel("Usuario:");
		label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD | Font.ITALIC));
		label1.setForeground(Color.RED);
		label1.setBounds(20, 0, 155, 34);
		label2 = new JLabel("Clave:");
		label2.setForeground(Color.RED);
		label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD | Font.ITALIC));
		label2.setBounds(20, 29, 142, 34);
		
		usuario1 = new JTextField(10);
		usuario1.setBounds(152, 0, 142, 34);
		contrasena = new JPasswordField(10);
		contrasena.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent contrasena) {
				if(contrasena.getKeyCode()==KeyEvent.VK_ENTER)        {

					boton_aceptar.doClick();

				}	}
			
			}	);
		
		contrasena.setBounds(152, 44, 142, 34);
		
		boton_aceptar = new JButton("Aceptar");
		boton_aceptar.setForeground(Color.WHITE);
		boton_aceptar.setBackground(Color.BLUE);
		boton_aceptar.setBounds(0, 88, 142, 34);
		boton_aceptar.setMnemonic('A');
		ImageIcon imgAceptar = new ImageIcon("img/user_go.png");
		boton_aceptar.setIcon(imgAceptar);
		
		boton_cancelar = new JButton("Cancelar");
		boton_cancelar.setBackground(Color.BLUE);
		boton_cancelar.setForeground(Color.WHITE);
		boton_cancelar.setBounds(152, 88, 142, 34);
		boton_cancelar.setMnemonic('C');
		ImageIcon imgCancelar = new ImageIcon("img/sign_cancel.gif");

		boton_cancelar.setIcon(imgCancelar);
		
		caja_prinippppl = getContentPane();
		getContentPane().setLayout(null);
		caja_prinippppl.add(label1);
		caja_prinippppl.add(usuario1);
		caja_prinippppl.add(label2);
		caja_prinippppl.add(contrasena);
		caja_prinippppl.add(boton_aceptar);
		caja_prinippppl.add(boton_cancelar);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(this.getClass().getResource("/img/candado.png")));

		lblImagen.setBounds(51, 0, 294, 94);
		getContentPane().add(lblImagen);
		
		boton_aceptar.addActionListener( 
			new ActionListener()
			{
				
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent evento)
				{
					DbUsuario user = new DbUsuario();
					frmMain principal = new frmMain();
					
					String usuario;
					String clave;
					
					usuario = usuario1.getText();
					clave = contrasena.getText();
					
					try {
						Object[][] itemUsuario = user.UsuarioAcceder(usuario, clave);
						String x_iduser = itemUsuario[0][0].toString();
						String x_user = itemUsuario[0][1].toString();
						String x_pass = itemUsuario[0][2].toString();
						if ((x_user != "") && (x_pass != ""))
						{
							JOptionPane.showMessageDialog( frmLogin.this,
									"Bienvenido : " + x_user + ", con id: " + x_iduser,
									"Acerca de", JOptionPane.INFORMATION_MESSAGE );
						
								        
							principal.mostrarForm(true);
							principal.setLocationRelativeTo(principal.getParent());
							dispose();
						}
					}
					catch(Exception e){
						JOptionPane.showMessageDialog( frmLogin.this,
								"Usuario o contraseña incorrecto",
								"Acerca de", JOptionPane.ERROR_MESSAGE );
					}
				}
			}
		);
		
		boton_cancelar.addActionListener(
			new ActionListener() {
				public void actionPerformed( ActionEvent evento )
				{
					System.exit(0);
				}
			}
		);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(300, 150);
		setVisible(true);
		setLocationRelativeTo(this.getParent());
	}
}
