package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
  //Metodo para guardar cliente
    public void guardar(javax.swing.JTable table, javax.swing.JTextField textNombre, javax.swing.JTextField textApellido, javax.swing.JTextField textCedula, javax.swing.JTextField textTelefono, javax.swing.JTextField textDireccion) {
    	if(textNombre.getText().isEmpty()|| textApellido.getText().isEmpty()|| textTelefono.getText().isEmpty()||
				textCedula.getText().isEmpty()|| textDireccion.getText().isEmpty()){
			
			JOptionPane.showMessageDialog(null, "Complete todos los campos");
			
		}else {
                            Ctrl_Cliente controlCliente = new Ctrl_Cliente();
                            
                                if(!controlCliente.clienteExistente(textCedula)){
                                    
                                    Cliente nuevoCliente = new Cliente();
                                    nuevoCliente.setNombre(textNombre.getText().trim());
                                    nuevoCliente.setApellido(textApellido.getText().trim());
                                    nuevoCliente.setCedula(textCedula.getText().trim());
                                    nuevoCliente.setTelefono(textTelefono.getText().trim());
                                    nuevoCliente.setDireccion(textDireccion.getText().trim());
                                    nuevoCliente.setEstado(1);
                                
                                    if(controlCliente.agregarCliente(nuevoCliente)){
                                    
                                        JOptionPane.showMessageDialog(null, "Cliente guardado");
                                        textNombre.setText("");
                                        textApellido.setText("");
                                        textTelefono.setText("");
                                        textCedula.setText("");
                                        textDireccion.setText("");
                                    }
			
                                }else{
                                    
                                    JOptionPane.showMessageDialog(null, "Este cliente ya existe");
                                }
                          
		}
    }
    
    /*
     * @author Angel Miguel de la Rosa
    
   	 **********************************
   	 * Metodo para actualizar cliente *
   	 **********************************
   	 */
       public void actualizar(javax.swing.JTable table, javax.swing.JTextField textNombre, javax.swing.JTextField textApellido, javax.swing.JTextField textCedula, javax.swing.JTextField textTelefono, javax.swing.JTextField textDireccion) {
           try {
               Connection con = conexion.conectar();
               int filaSeleccionada = table.getSelectedRow();

               if (filaSeleccionada >= 0) {
                   String nombre = textNombre.getText();
                   String apellido = textApellido.getText();
                   String cedula = textCedula.getText();
                   String telefono = textTelefono.getText();
                   String direccion = textDireccion.getText();

                   String query = "UPDATE cliente SET nombre=?, apellido=?, cedula=?, telefono=?, direccion=? WHERE idCliente=?";
                   PreparedStatement preparedStatement = con.prepareStatement(query);
                   preparedStatement.setString(1, nombre);
                   preparedStatement.setString(2, apellido);
                   preparedStatement.setString(3, cedula);
                   preparedStatement.setString(4, telefono);
                   preparedStatement.setString(5, direccion);
                   preparedStatement.setInt(6, (int) table.getValueAt(filaSeleccionada, 0)); 
                   preparedStatement.executeUpdate();

                   JOptionPane.showMessageDialog(null, "Cliente editado.");

                   con.close();
               } else {
                   JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
               }
           } catch (SQLException e1) {
               System.out.println("Error al actualizar cliente: " + e1);
               JOptionPane.showMessageDialog(null, "Error al actualizar cliente: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
           }
       }
       
       /*
   	 ********************************
   	 * Metodo para eliminar cliente *
   	 ********************************
   	 */
       public void eliminar(javax.swing.JTable table) {
           try {
               Connection con = conexion.conectar();
               int filaSeleccionada = table.getSelectedRow();

               if (filaSeleccionada >= 0) {

                   int idCliente = (int) table.getValueAt(filaSeleccionada, 0);

                   String query = "DELETE FROM cliente WHERE idCliente=?";
                   PreparedStatement preparedStatement = con.prepareStatement(query);
                   preparedStatement.setInt(1, idCliente);
                   preparedStatement.executeUpdate();

                   JOptionPane.showMessageDialog(null, "Cliente eliminado.");

                   con.close();
               } else {
                   JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
               }
           } catch (SQLException e1) {
               System.out.println("Error al eliminar cliente: " + e1);
               JOptionPane.showMessageDialog(null, "Error al eliminar cliente: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
           }
       }
}