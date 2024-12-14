package cConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class CConection {

	  /*  public static Connection getConexion() {
	        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	    }*/
	
    public static Connection estableceConexion(){

	    String usuario="root";
	    String contraseña="Onedirection5.";
	    String bd ="ReservadeCine";
	    String ip = "localhost";
	    String puerto="3306";
	    
	    Connection connection = null;
	    
	    String cadena="jdbc:mysql://"+ip+":"+puerto+"/"+bd;
	    
	        try{
	           Class.forName("com.mysql.cj.jdbc.Driver");//debe de tener manejo de excepcion, de lo contrario bota error.
	     
	            connection = DriverManager.getConnection(cadena, usuario, contraseña);
	            
	  JOptionPane.showMessageDialog(null,"Conexion correcta"); //Solo es para comprobar la conexion

	        }catch(ClassNotFoundException e){
	        	e.printStackTrace();
	        	JOptionPane.showMessageDialog(null, "Error al cargar el driver: " + e.toString());
                        System.out.println("Error al cargar el driver");
	            
	        }catch(SQLException e){
	        	e.printStackTrace();
	        	JOptionPane.showMessageDialog(null,"Problemas en la conexión"+ e.toString());//Se importa
	        }
	        return connection;
	    }
}
