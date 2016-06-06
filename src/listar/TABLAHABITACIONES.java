package listar;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import isma.gui.frmMain;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class TABLAHABITACIONES extends JFrame{
    /**
     * 
     */
    private static final long serialVersionUID = 210601883990408438L;
    private Connection conexion = null;
    private Statement comando = null;
    private ResultSet resultados = null;
    private JTable TABLAHABITACION = null;
    DefaultTableModel modelo = null;
    JScrollPane desplazamiento = null;
    

    private void leerDatos() throws ClassNotFoundException, SQLException {
   
     
       // String instruccion = " select *";
        String instruccion = " select * from habitacion ";

        Class.forName("com.mysql.jdbc.Driver");
        conexion = DriverManager.getConnection("jdbc:mysql://172.32.4.99/bd_samplelogin", "root", "");
        comando = conexion.createStatement();
        resultados = comando.executeQuery(instruccion);
    }
    

    private void cerrar() throws SQLException {
        conexion.close();        
    }    


public TABLAHABITACIONES() {
    String[] columnas = {"estado","idhabitacion", "numero", "piso", "precio"
    		};
    TABLAHABITACION = new JTable();
    modelo = new DefaultTableModel();
    desplazamiento = new JScrollPane(TABLAHABITACION);
    String estado;
	String idhabitacion;
	String numero;
	String piso;
	String precio;

	
    // Parametros de la ventana
    this.setTitle("Clientes");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(new BorderLayout()); 
    
    // Modelo de la TABLAHABITACION
    modelo.setColumnIdentifiers(columnas);
    
    // Barras de desplazamiento
    desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
    // Propiedades de la TABLAHABITACION
    TABLAHABITACION.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    TABLAHABITACION.setFillsViewportHeight(true);        
    
    TABLAHABITACION.setModel(modelo);
    
    // Agregando elementos a la ventana
    this.getContentPane().add(desplazamiento, BorderLayout.NORTH);    
    
    JLabel lblNewLabel = new JLabel("");
    lblNewLabel.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent arg0) {
    		frmMain holi = new frmMain();
			holi.setVisible(true);
			dispose();
    	}
    });
    lblNewLabel.setBackground(SystemColor.inactiveCaption);
    lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/img/sas1 - copia.png")));

    desplazamiento.setRowHeaderView(lblNewLabel);
    
    JLabel label = new JLabel("New label");
    desplazamiento.setColumnHeaderView(label);
    this.pack();
    
    // Ponemos los datos en la TABLAHABITACION
    
    try {
        // Obtener datos de la TABLAHABITACION
        this.leerDatos();
        
        while(resultados.next() == true) {
            
        estado = resultados.getString("estado");

        	idhabitacion = resultados.getString("idhabitacion");

        	numero = resultados.getString("numero");
        	piso = resultados.getString("piso");
        	precio = resultados.getString("precio");
        


            modelo.addRow( new Object[] {estado, idhabitacion, numero, piso,precio} );                
        }
        
        this.cerrar();
        
    } catch (SQLException | ClassNotFoundException e) {
        System.out.println("Error de lectura de BD\n\n");
        
        e.printStackTrace();
    } 
}
}


