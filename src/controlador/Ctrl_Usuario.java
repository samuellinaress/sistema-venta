package controlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import conexion.conexion;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author Samuel Linares
 */
public class Ctrl_Usuario {
    
    //Metodo para iniciar seccion
    public boolean Login(Usuario usuario){
        
        boolean respuesta = false;
        Connection cn = conexion.conectar();
        String sql = "select usuario, password from usuario where usuario = '" + usuario.getUsuario() + "' and password = '" + usuario.getPassword() + "';";
        Statement st;
        
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                respuesta = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "ERROR INICIO DE SECCION", JOptionPane.ERROR_MESSAGE);
        }
        
         return respuesta;
    }
    
}
