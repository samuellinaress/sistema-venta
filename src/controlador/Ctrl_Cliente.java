package controlador;

import java.sql.CallableStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.conexion;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Cliente;

/**
 *
 * @author Samuel Linares
 */
public class Ctrl_Cliente {
    
    //Metodo para agregar clientes
    
    public boolean agregarCliente(Cliente cliente){
        
        boolean respuesta = false;
        
        String sql = "insert into cliente(nombre, apellido, cedula, telefono, direccion, estado) values (?, ?, ?, ?, ?, ?);";
        CallableStatement cs;
        
        try {
            cs = conexion.conectar().prepareCall(sql);
            cs.setString(1, cliente.getNombre());
            cs.setString(2, cliente.getApellido());
            cs.setString(3, cliente.getCedula());
            cs.setString(4, cliente.getTelefono());
            cs.setString(5, cliente.getDireccion());
            cs.setInt(6, cliente.getEstado());
            
            if(cs.executeUpdate() > 0){
                respuesta = true;
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "ERROR AL AGREGAR CLIENTE", JOptionPane.ERROR_MESSAGE);
        }
        
        return respuesta;
    }
    
    public boolean clienteExistente(JTextField cedulaCliente){
        
        boolean respuesta = false;
        String sql = "select * from cliente where cedula = '"+ cedulaCliente.getText().trim() +"';";
        
        Statement st;
        try {
            st = conexion.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                respuesta = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "ERROR AL BUSCAR CLIENTE", JOptionPane.ERROR_MESSAGE);
        }
        return respuesta;
    }
}
