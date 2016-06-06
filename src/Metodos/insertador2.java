package Metodos;


import java.sql.*; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import java.sql.DriverManager;
import java.sql.SQLException;


public class insertador2 {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
	
	private java.sql.PreparedStatement DATEAR;
	private java.sql.Statement stmmt;
	private java.sql.Connection cn;
	public void datear (String idcliente,String fecha_reserva, String fecha_ingresa, String fecha_salida) throws SQLException {
		//fecha_ingresa =null;
		//fecha_salida =null;
		//fecha_reserva =null;

	
		String url = "jdbc:mysql://172.32.4.99:3306/bd_samplelogin?user=root";
		cn = DriverManager.getConnection(url);
		stmmt = cn.createStatement();
		DATEAR = cn.prepareStatement("INSERT INTO reserva (idcliente,fecha_reserva, fecha_ingresa, fecha_salida)" + " VALUES (?,?,?,?)");

		DATEAR.setString(1, idcliente);
		DATEAR.setString(2, fecha_reserva);
		DATEAR.setString(3, fecha_ingresa);
		DATEAR.setString(4, fecha_salida);

		DATEAR.executeUpdate();
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}


	}
	
	
	
	
	

