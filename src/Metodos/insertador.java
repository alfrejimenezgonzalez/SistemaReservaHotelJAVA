package Metodos;


import java.sql.*; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import java.sql.DriverManager;
import java.sql.SQLException;


public class insertador {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
	
	private java.sql.PreparedStatement DATEAR;
	private java.sql.Statement stmmt;
	private java.sql.Connection cn;
	
	public void datear (String nombre, String primer_apellido, String segundo_nombre, String tipo_documento, String num_documento
			,String direccion,String telefono,String email) throws SQLException {
		
	
		String url = "jdbc:mysql://172.32.4.99:3306/bd_samplelogin?user=root";
		cn = DriverManager.getConnection(url);
		stmmt = cn.createStatement();
		DATEAR = cn.prepareStatement("INSERT INTO persona (nombre, primer_apellido, segundo_nombre, tipo_documento, num_documento, direccion, telefono, email)" + " VALUES (?,?,?,?,?,?,?,?)");

		
		DATEAR.setString(1, nombre);
		DATEAR.setString(2, primer_apellido);
		DATEAR.setString(3, segundo_nombre);
		DATEAR.setString(4, tipo_documento);
		DATEAR.setString(5, num_documento);
		DATEAR.setString(6, direccion);
		DATEAR.setString(7, telefono);
		DATEAR.setString(8, email);
		DATEAR.executeUpdate();
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}


	}
	
	
	
	
	

