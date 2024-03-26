package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel Linares
 */
public class conexion {
    
    public static Connection conectar(){
        
        Connection conexion = null;
        
        try {
             conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_sistema_ventas", "root", "Slinares#660");
             //JOptionPane.showMessageDialog(null, "Conexion exitosa a la base de datos");
             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "ERROR CONEXION", JOptionPane.ERROR_MESSAGE);
        }
        
        return conexion;
       
    }
}
