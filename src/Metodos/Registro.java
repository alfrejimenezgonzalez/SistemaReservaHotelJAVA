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
import Metodos.Registro;
import Metodos.insertador;
import java.awt.Toolkit;
public class Registro extends JFrame {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField primer_apellido;
	private JTextField email;
	private JTextField telefono;
	private JTextField direccion;
	private JTextField segundo_nombre;
	private JLabel textoNOMBRE;
	private JLabel txtsegundoapellido;
	private JLabel txttipo_documento;
	private JLabel txtemail;
	private JLabel txtnum_documento;
	private JTextField num_documento;
	private JTextField tipo_documento;
	private JLabel txtprimerapellido;
	private JLabel txtdireccion;
	private JLabel txttelefono;
	private JButton btnCerrar;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setTitle("Sistema Hotel Clientes Infromatic 2016 Copiright | Alfredo Javier Jimenez Gonzalez");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 572);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//NOMBRE  
		textoNOMBRE = new JLabel("Nombre");
		textoNOMBRE.setForeground(Color.BLUE);
		textoNOMBRE.setBounds(10, 11, 599, 27);
		textoNOMBRE.setHorizontalAlignment(SwingConstants.LEFT);
		textoNOMBRE.setFont(new Font("Tahoma", Font.BOLD, 17));
		textoNOMBRE.setBackground(Color.WHITE);
		contentPane.add(textoNOMBRE);
		nombre = new JTextField();
		nombre.setBounds(10, 49, 110, 27);
		nombre.setForeground(Color.BLUE);
		nombre.setBackground(Color.WHITE);
		nombre.setFont(new Font("Verdana", Font.PLAIN, 15));
		contentPane.add(nombre);
		nombre.setColumns(10);
		//NOMBRE  

		
		
		//PRIMERAPELLIDO
		txtprimerapellido = new JLabel("Primer Apellido");
		txtprimerapellido.setForeground(Color.BLUE);
		txtprimerapellido.setBounds(10, 102, 146, 27);
		txtprimerapellido.setHorizontalAlignment(SwingConstants.LEFT);
		txtprimerapellido.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtprimerapellido.setBackground(Color.WHITE);
		contentPane.add(txtprimerapellido);
		
		primer_apellido = new JTextField();
		primer_apellido.setBounds(10, 137, 128, 27);
		primer_apellido.setForeground(Color.BLUE);
		primer_apellido.setBackground(Color.WHITE);
		primer_apellido.setFont(new Font("Verdana", Font.PLAIN, 15));
		primer_apellido.setColumns(10);
		contentPane.add(primer_apellido);
		//PRIMERAPELLIDO

		
		//EMAIL
		email = new JTextField();
		email.setBounds(328, 355, 302, 60);
		
		email.setForeground(Color.BLUE);
		email.setBackground(Color.WHITE);
		email.setHorizontalAlignment(SwingConstants.LEFT);
		email.setFont(new Font("Verdana", Font.PLAIN, 15));
		email.setColumns(10);
		contentPane.add(email);
		
		txtemail = new JLabel("Email");
		txtemail.setForeground(Color.WHITE);
		txtemail.setBounds(387, 233, 264, 73);
		txtemail.setHorizontalAlignment(SwingConstants.LEFT);
		txtemail.setFont(new Font("Tahoma", Font.BOLD, 58));
		txtemail.setBackground(Color.WHITE);
		contentPane.add(txtemail);
		
		
		
		
		
		
		//TELEFONO
		
		
		telefono = new JTextField();
		telefono.setBounds(419, 195, 160, 27);
		telefono.setForeground(Color.BLUE);
		telefono.setBackground(Color.WHITE);
		telefono.setFont(new Font("Verdana", Font.PLAIN, 15));
		telefono.setColumns(10);
		contentPane.add(telefono);
		
		direccion = new JTextField();
		direccion.setBounds(419, 0, 160, 27);
		direccion.setForeground(Color.BLUE);
		direccion.setBackground(Color.WHITE);
		direccion.setFont(new Font("Verdana", Font.PLAIN, 15));
		direccion.setColumns(10);
		contentPane.add(direccion);
		//2APELLIDO
		segundo_nombre = new JTextField();
		segundo_nombre.setBounds(134, 211, 117, 27);
		segundo_nombre.setForeground(Color.BLUE);
		segundo_nombre.setToolTipText("");
		segundo_nombre.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(segundo_nombre);
		
		txtsegundoapellido = new JLabel("Segundo Apellido");
		txtsegundoapellido.setForeground(Color.BLUE);
		txtsegundoapellido.setBounds(134, 173, 232, 27);
		txtsegundoapellido.setHorizontalAlignment(SwingConstants.LEFT);
		txtsegundoapellido.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtsegundoapellido.setBackground(Color.WHITE);
		contentPane.add(txtsegundoapellido);
		//2APELLIDO

		
		
		tipo_documento = new JTextField();
		tipo_documento.setBounds(82, 296, 160, 27);
		tipo_documento.setForeground(Color.BLUE);
		tipo_documento.setToolTipText("");
		tipo_documento.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(tipo_documento);
		
		
	
		
		txttipo_documento = new JLabel("Tipo de Documento");
		txttipo_documento.setForeground(Color.BLUE);
		txttipo_documento.setBounds(91, 249, 181, 27);
		txttipo_documento.setHorizontalAlignment(SwingConstants.LEFT);
		txttipo_documento.setFont(new Font("Tahoma", Font.BOLD, 17));
		txttipo_documento.setBackground(Color.WHITE);
		contentPane.add(txttipo_documento);
	
		
		txtnum_documento = new JLabel("Numero de Documento");
		txtnum_documento.setForeground(Color.BLUE);
		txtnum_documento.setBounds(34, 355, 217, 27);
		txtnum_documento.setHorizontalAlignment(SwingConstants.LEFT);
		txtnum_documento.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtnum_documento.setBackground(Color.WHITE);
		contentPane.add(txtnum_documento);
		
		num_documento = new JTextField();
		num_documento.setBounds(58, 405, 160, 27);
		num_documento.setForeground(Color.BLUE);
		num_documento.setFont(new Font("Verdana", Font.PLAIN, 15));
		num_documento.setColumns(10);
		num_documento.setBackground(Color.WHITE);
		contentPane.add(num_documento);
		
		
		JButton button = new JButton("Volver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMain holi = new frmMain();
				holi.setVisible(true);
				dispose();
			
		}	
			
		});
		//button.setIcon(new ImageIcon(this.getClass().getResource("/img/boton_atras.png")));
		button.setIcon(new ImageIcon(this.getClass().getResource("/img/boton_atras.png")));

		button.setBounds(601, 11, 123, 27);
		button.setMnemonic('C');
		button.setForeground(Color.BLUE);
		button.setFont(new Font("Verdana", Font.PLAIN, 15));
		button.setBackground(Color.WHITE);
		contentPane.add(button);
		
		JButton btnAadirCliente = new JButton("A\u00F1adir Cliente");
		btnAadirCliente.setBounds(512, 490, 170, 27);
		btnAadirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					
					insertador insert = new insertador();
					
					try {
						insert.datear(nombre.getText(), primer_apellido.getText(), segundo_nombre.getText(), tipo_documento.getText(), num_documento.getText(),direccion.getText(), telefono.getText(), email.getText());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					
					}
					
				}
					
				
				
			
			
		});
		btnAadirCliente.setForeground(Color.BLUE);
		btnAadirCliente.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnAadirCliente.setBackground(Color.WHITE);
		contentPane.add(btnAadirCliente);
		
		txtdireccion = new JLabel("Direcci\u00F3n");
		txtdireccion.setHorizontalAlignment(SwingConstants.LEFT);
		txtdireccion.setForeground(Color.BLUE);
		txtdireccion.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtdireccion.setBackground(Color.WHITE);
		txtdireccion.setBounds(290, 0, 146, 27);
		contentPane.add(txtdireccion);
		
		txttelefono = new JLabel("Telefono");
		txttelefono.setHorizontalAlignment(SwingConstants.LEFT);
		txttelefono.setForeground(Color.RED);
		txttelefono.setFont(new Font("Tahoma", Font.BOLD, 58));
		txttelefono.setBackground(Color.WHITE);
		txttelefono.setBounds(375, 97, 264, 73);
		contentPane.add(txttelefono);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmLogin holi = new frmLogin();
				holi.setVisible(true);
				dispose();
			
		}	
		});
		btnCerrar.setIcon(new ImageIcon(this.getClass().getResource("/img/Cerrar Sesión iOS.png")));

		
		btnCerrar.setBounds(10, 469, 405, 73);
		contentPane.add(btnCerrar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/img/hotel.PNG")));

		lblNewLabel.setBounds(10, 0, 940, 534);
		contentPane.add(lblNewLabel);
	}
}
