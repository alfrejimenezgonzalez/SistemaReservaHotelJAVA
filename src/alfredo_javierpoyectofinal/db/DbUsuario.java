

package alfredo_javierpoyectofinal.db;
import java.sql.*;

public class DbUsuario {
	DbConnection cn;
	public DbUsuario() {
		cn = new DbConnection();
	}
	public Object[][] UsuarioAcceder(String login, String password){
		int registros = 0;
		try {
			PreparedStatement pstm = cn.getConnection().prepareStatement("SELECT count(1) as cont" +
			" FROM tm_usuario");
			ResultSet res = pstm.executeQuery();
			res.next();
			registros = res.getInt("cont");
			res.close();
		}
		catch(SQLException e){
			System.out.println(e);
		}
		Object [][] data = new Object[registros][3];
		if (login.length() != 0 && password.length() != 0){
			int usu_id;
			String usu_login = "";
			String usu_password = "";
			try {
				String strsql = "";
				strsql = "SELECT * FROM tm_usuario WHERE tm_login = '" + login + "' AND tm_password = '" + password + "'";
				PreparedStatement pstm = cn.getConnection().prepareStatement(strsql);
				ResultSet res = pstm.executeQuery();
				int i = 0;
				while(res.next()){
					usu_id = res.getInt("tm_idusuario");
					usu_login = res.getString("tm_login");
					usu_password = res.getString("tm_password");
					data[i][0] = usu_id;
					data[i][1] = usu_login;
					data[i][2] = usu_password;
					i++;
				}
				res.close();
			}
			catch(SQLException e){
				System.out.println(e);
			}
		}
		return data;
	}
}
