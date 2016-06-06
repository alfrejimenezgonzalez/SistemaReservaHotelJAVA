package Metodos;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.security.sasl.SaslException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import org.xml.sax.SAXException;

import isma.gui.*;
import listar.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import com.mysql.*;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import Metodos.insertador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import Metodos.Registroreserva;
import Metodos.insertador;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import java.awt.Toolkit;
public class Registroreserva extends JFrame {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 

	private JPanel contentPane;
	private JTextField idcliente;
	private JTextField tipo_reserva;
	private JTextField costo_alojamiento;
	private JTextField fecha_reserva;
	private JTextField fecha_salida;
	private JTextField fecha_ingresa;
	private JLabel idclienteTEXTO;
	private JLabel fecha_reservaTEX;
	private JLabel fecha_ingresaTEX;
	private JLabel TEXTfecha_salida;
	private JLabel botoncompra;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registroreserva frame = new Registroreserva();
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
	public Registroreserva() {
		setTitle("Sistema Hotel Clientes Infromatic 2016 Copiright | Alfredo Javier Jimenez Gonzalez");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 572);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JButton comprar = new JButton("A\u00F1adir Cliente");
			comprar.setIcon(new ImageIcon(this.getClass().getResource("/img/payp2.png")));

			comprar.setBounds(256, 361, 222, 102);
			comprar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
						
						insertador2 insert = new insertador2();
						
						try {
							insert.datear(idcliente.getText(),fecha_reserva.getText(),fecha_ingresa.getText(),fecha_salida.getText());
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
						
					
					
				
				
			});
			
			fecha_salida = new JTextField();
			fecha_salida.setBounds(450, 222, 174, 27);
			fecha_salida.setForeground(Color.BLUE);
			fecha_salida.setBackground(Color.WHITE);
			fecha_salida.setFont(new Font("Verdana", Font.PLAIN, 15));
			fecha_salida.setColumns(10);
			contentPane.add(fecha_salida);
			//2APELLIDO
			fecha_ingresa = new JTextField();
			fecha_ingresa.setBounds(59, 298, 184, 27);
			fecha_ingresa.setForeground(Color.BLUE);
			fecha_ingresa.setToolTipText("");
			fecha_ingresa.setHorizontalAlignment(SwingConstants.LEFT);
			contentPane.add(fecha_ingresa);
			comprar.setForeground(Color.BLUE);
			comprar.setFont(new Font("Verdana", Font.PLAIN, 15));
			comprar.setBackground(Color.WHITE);
			contentPane.add(comprar);
			
			botoncompra = new JLabel("New label");
			botoncompra.setIcon(new ImageIcon(this.getClass().getResource("/img/com.png")));

			botoncompra.setBounds(341, 218, 373, 245);
			contentPane.add(botoncompra);
		
		
	
		
		fecha_ingresaTEX = new JLabel("Fecha del comienzo de la estancia");
		fecha_ingresaTEX.setBounds(10, 260, 307, 27);
		fecha_ingresaTEX.setForeground(Color.BLUE);
		fecha_ingresaTEX.setHorizontalAlignment(SwingConstants.LEFT);
		fecha_ingresaTEX.setFont(new Font("Tahoma", Font.BOLD, 17));
		fecha_ingresaTEX.setBackground(Color.WHITE);
		contentPane.add(fecha_ingresaTEX);
		idcliente = new JTextField();
		idcliente.setBounds(85, 83, 539, 74);
		idcliente.setForeground(Color.BLUE);
		idcliente.setBackground(Color.WHITE);
		idcliente.setFont(new Font("Verdana", Font.PLAIN, 15));
		contentPane.add(idcliente);
		idcliente.setColumns(10);
		
		fecha_reservaTEX = new JLabel("Ingrese el dia de hoy");
		fecha_reservaTEX.setBounds(35, 184, 232, 27);
		fecha_reservaTEX.setForeground(Color.BLUE);
		fecha_reservaTEX.setHorizontalAlignment(SwingConstants.LEFT);
		fecha_reservaTEX.setFont(new Font("Tahoma", Font.BOLD, 17));
		fecha_reservaTEX.setBackground(Color.WHITE);
		contentPane.add(fecha_reservaTEX);
		
		JLabel ADVERTENCIA = new JLabel("Debe registrarse como cliente , para saber el ID que le he proporcionado");
		ADVERTENCIA.setBounds(85, 36, 592, 49);
		ADVERTENCIA.setFont(new Font("Constantia", Font.BOLD, 16));
		ADVERTENCIA.setForeground(Color.GREEN);
		ADVERTENCIA.setBackground(Color.WHITE);
		contentPane.add(ADVERTENCIA);
		
		fecha_reserva = new JTextField();
		fecha_reserva.setBounds(35, 222, 208, 27);
		fecha_reserva.setForeground(Color.BLUE);
		fecha_reserva.setBackground(Color.WHITE);
		fecha_reserva.setFont(new Font("Verdana", Font.PLAIN, 15));
		fecha_reserva.setColumns(10);
		contentPane.add(fecha_reserva);
		
		
		JButton button = new JButton("Volver");
		button.setBounds(34, 490, 123, 27);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMain holi = new frmMain();
				holi.setVisible(true);
				dispose();
			
		}	
			
		});
		button.setIcon(new ImageIcon(this.getClass().getResource("/img/boton_atras.png")));

		button.setMnemonic('C');
		button.setForeground(Color.BLUE);
		button.setFont(new Font("Verdana", Font.PLAIN, 15));
		button.setBackground(Color.WHITE);
		contentPane.add(button);
		//NOMBRE  

		
		
		//PRIMERAPELLIDO
		TEXTfecha_salida = new JLabel("Fecha fin de la estancia");
		TEXTfecha_salida.setBounds(435, 184, 201, 27);
		TEXTfecha_salida.setForeground(Color.BLUE);
		TEXTfecha_salida.setHorizontalAlignment(SwingConstants.LEFT);
		TEXTfecha_salida.setFont(new Font("Tahoma", Font.BOLD, 17));
		TEXTfecha_salida.setBackground(Color.WHITE);
		contentPane.add(TEXTfecha_salida);
		
		//NOMBRE  
		idclienteTEXTO = new JLabel("Ingrese su ID de Cliente");
		idclienteTEXTO.setBounds(235, 11, 599, 27);
		idclienteTEXTO.setForeground(Color.RED);
		idclienteTEXTO.setHorizontalAlignment(SwingConstants.LEFT);
		idclienteTEXTO.setFont(new Font("Tahoma", Font.BOLD, 17));
		idclienteTEXTO.setBackground(Color.WHITE);
		contentPane.add(idclienteTEXTO);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(166, 155, 4, 22);
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/img/fondo.jpg")));

		lblNewLabel.setBounds(-57, -49, 771, 572);
		contentPane.add(lblNewLabel);
	}
}
