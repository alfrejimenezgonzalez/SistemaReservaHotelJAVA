package alfredo_javierpoyectofinal.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbConnection {   
	static String bd = "bd_samplelogin";   
	static String login = "root";   
	static String password = "";   
	static String url = "jdbc:mysql://172.32.4.99/" + bd;   
	//String url = "jdbc:mysql://172.32.4.99:3306/bd_samplelogin?user=root";

	Connection conn = null;   
	public DbConnection() {      
		try {        
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, login, password);
		}
		catch(SQLException e){
			System.out.println(e);
		}
		catch(ClassNotFoundException e){
			System.out.println(e);
		}
	}
	public Connection getConnection(){
		return conn;
	}
	public void desconectar(){
		conn = null;
	}
}
