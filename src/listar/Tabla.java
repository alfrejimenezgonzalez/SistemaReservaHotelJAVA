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

public class Tabla extends JFrame{
    /**
     * 
     */
    private static final long serialVersionUID = 210601883990408438L;
    private Connection conexion = null;
    private Statement comando = null;
    private ResultSet resultados = null;
    private JTable tabla = null;
    DefaultTableModel modelo = null;
    JScrollPane desplazamiento = null;
    

    private void leerDatos() throws ClassNotFoundException, SQLException {
   
     
       // String instruccion = " select 	idclientenombre primer_apellido segundo_nombre tipo_documento num_documento direccion telefono tipo_reserva fecha_reserva fecha_ingresa fecha_salida costo_alojamiento fecha_pago from reserva, persona,pago";
        String instruccion = " select * from persona,reserva,pago";

        Class.forName("com.mysql.jdbc.Driver");
        conexion = DriverManager.getConnection("jdbc:mysql://172.32.4.99/bd_samplelogin", "root", "");
        comando = conexion.createStatement();
        resultados = comando.executeQuery(instruccion);
    }
    

    private void cerrar() throws SQLException {
        conexion.close();        
    }    


public Tabla() {
    String[] columnas = {"Estado","Nombre", "idpersona", " Apellido", "Tipo" , "Num", "Direcc", "TFN","Reserva Fecha"
    		,"Fecha Ingresa", "Fecha Salida"
    		};
    tabla = new JTable();
    modelo = new DefaultTableModel();
    desplazamiento = new JScrollPane(tabla);
    String nombre;
    String idpersona;

	String primer_apellido;
	String tipo_documento;
	String num_documento;
	String direccion;
	String telefono;
	String estado;
	//String tipo_reserva;

	String fecha_reserva;//RESERVA
	String fecha_ingresa;//RESERVA
	String fecha_salida;//RESERVA
	
    // Parametros de la ventana
    this.setTitle("Clientes");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(new BorderLayout()); 
    
    // Modelo de la tabla
    modelo.setColumnIdentifiers(columnas);
    
    // Barras de desplazamiento
    desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
    // Propiedades de la tabla
    tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    tabla.setFillsViewportHeight(true);        
    
    tabla.setModel(modelo);
    
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
    
    // Ponemos los datos en la tabla
    
    try {
        // Obtener datos de la tabla
        this.leerDatos();
        
        while(resultados.next() == true) {
            
        //	nombre = resultados.getString("nombre");
        	estado=resultados.getString("Estado");

        	nombre=resultados.getString("nombre");
        	idpersona = resultados.getString("idpersona");

        	primer_apellido = resultados.getString("primer_apellido");
        	tipo_documento = resultados.getString("tipo_documento");
        	num_documento = resultados.getString("num_documento");
        	direccion = resultados.getString("direccion");
        	telefono = resultados.getString("telefono");
        	fecha_reserva = resultados.getString("fecha_reserva");
        	fecha_ingresa = resultados.getString("fecha_ingresa");
        	fecha_salida = resultados.getString("fecha_salida");


            modelo.addRow( new Object[] {estado, nombre, idpersona, primer_apellido, tipo_documento,num_documento,direccion
            		,telefono,fecha_reserva,fecha_ingresa,fecha_salida} );                
        }
        
        this.cerrar();
        
    } catch (SQLException | ClassNotFoundException e) {
        System.out.println("Error de lectura de BD\n\n");
        
        e.printStackTrace();
    } 
}
}


