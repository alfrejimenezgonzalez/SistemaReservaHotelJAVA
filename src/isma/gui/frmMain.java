
package isma.gui;

import java.awt.event.*;
import javax.swing.*;

import Metodos.Registro;
import Metodos.Registroreserva;
import Metodos.insertador;
import listar.*;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Font;


public class frmMain extends JFrame {
	private static final long serialVersionUID = 1L;
	private JMenuBar barramenu;
	private final JButton añadirlciente = new JButton("    A\u00F1adir Cliente");
	public frmMain()
	{
		super("Proyecto Programacion 2015-2016");
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setSelectedIcon(new ImageIcon(this.getClass().getResource("/img/placa2.png")));

		btnNewButton.setBackground(SystemColor.info);
		btnNewButton.setIcon(new ImageIcon(this.getClass().getResource("/img/pene.png")));

		;

		btnNewButton.setBounds(0, -140, 430, 974);
		getContentPane().add(btnNewButton);
		
		JButton fotoañadircliente = new JButton("");
		fotoañadircliente.setBackground(SystemColor.window);
		fotoañadircliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Registro holi = new Registro();
				holi.setVisible(true);
				dispose();
			}
		});
		fotoañadircliente.setIcon(new ImageIcon(this.getClass().getResource("/img/add_male_user_128.png")));
		fotoañadircliente.setBounds(502, 11, 106, 112);
		getContentPane().add(fotoañadircliente);
		añadirlciente.setFont(new Font("Tahoma", Font.BOLD, 21));
		añadirlciente.setBackground(SystemColor.activeCaption);
		añadirlciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		añadirlciente.setBounds(425, 0, 499, 131);
		getContentPane().add(añadirlciente);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
					Tabla holi = new Tabla();
					holi.setVisible(true);
					dispose();
				}
			
		});
		btnNewButton_1.setIcon(new ImageIcon(this.getClass().getResource("/img/232.png")));

		btnNewButton_1.setBounds(425, 271, 158, 208);
		getContentPane().add(btnNewButton_1);
		
		JButton btnListarClientesY = new JButton("Listar Clientes y su Estado");
		btnListarClientesY.setForeground(Color.BLUE);
		btnListarClientesY.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnListarClientesY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnListarClientesY.setBackground(SystemColor.activeCaption);
		btnListarClientesY.setBounds(494, 271, 430, 208);
		getContentPane().add(btnListarClientesY);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registroreserva holi = new Registroreserva();
				holi.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.setIcon(new ImageIcon(this.getClass().getResource("/img/boton-reservar-habitacion.png")));

		btnNewButton_2.setBounds(346, 129, 650, 144);
		getContentPane().add(btnNewButton_2);
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReservar.setEnabled(false);
		btnReservar.setBackground(SystemColor.activeCaption);
		btnReservar.setBounds(375, 142, 576, 131);
		getContentPane().add(btnReservar);
		
		JButton HABITACFIONES = new JButton("");
		HABITACFIONES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TABLAHABITACIONES holi = new TABLAHABITACIONES();
				holi.setVisible(true);
				dispose();
			
				
				
			}
		});
		HABITACFIONES.setBackground(SystemColor.activeCaption);
		HABITACFIONES.setIcon(new ImageIcon(this.getClass().getResource("/img/xasa.png")));

		HABITACFIONES.setBounds(425, 404, 451, 327);
		getContentPane().add(HABITACFIONES);
	}
	
	public void mostrarForm(boolean mostrar){
		if (mostrar == true){
			barramenu = new JMenuBar(); 
			JMenu menuArchivo = new JMenu("HOTEL");
			menuArchivo.setMnemonic('C');
						
			JMenuItem itemAcerca = new JMenuItem("Acerca de...");
			itemAcerca.setMnemonic('A');
			menuArchivo.add(itemAcerca);
			itemAcerca.addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent evento)
						{
							JOptionPane.showMessageDialog(frmMain.this,
									"Hecho por Alfredo Javier Jimenez Gonzalez",
									"Acerca de", JOptionPane.INFORMATION_MESSAGE);
						}
					} 
			);
			JMenuItem itemSalir = new JMenuItem("Salir");
			itemSalir.setMnemonic('S');
			menuArchivo.add(itemSalir);
			itemSalir.addActionListener(
					new ActionListener(){
						public void actionPerformed(ActionEvent evento)
						{
							System.exit(0);
						}
					}
			);
			barramenu.add(menuArchivo);  
			setJMenuBar(barramenu);
			setSize(867, 700);
			setLocationRelativeTo(this.getParent());
			setVisible(mostrar);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	}
}
