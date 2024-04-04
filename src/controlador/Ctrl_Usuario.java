package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import conexion.conexion;
import javax.swing.JOptionPane;

import Interfaz.stock;
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
    
    /*
    * @author Angel Miguel de la Rosa
    
     **********************************
     * Metodo para agregar un usuario *
     **********************************
     */
    public boolean agregar(Usuario objeto){
    	  boolean respuesta = false;
    	  Connection cn = conexion.conectar();
    	  
    	  try {
    		  
    		  PreparedStatement consulta = cn.prepareStatement("insert into usuario value(?,?,?,?,?,?,?)");
    		  consulta.setInt(1, 0);//ID
    		  consulta.setString(2, objeto.getNombre());
    		  consulta.setString(3, objeto.getApellido());
    		  consulta.setString(4, objeto.getUsuario());
    		  consulta.setString(5, objeto.getPassword());
    		  consulta.setString(6, objeto.getTelefono());
    		  consulta.setInt(7, objeto.getEstado());
    		  
    	  if (consulta.executeUpdate() > 0) {
    		  respuesta = true;
    		  
    	  }
    	  
    	  cn.close();
    	  
    	  }catch (SQLException e) {
    		  System.out.println("Error al guardar usuario" + e);
    		  
    	  }
    	  
		return respuesta;
    }
    
    /*
     *******************************************************************
     * Metodo para revisar si el usuario ya esta reguitrado en la BBDD *
     *******************************************************************
     */
    public boolean existeUsuario(String usuario){
    	  boolean respuesta = false;
    	  String sql = "select usuario from usuario where usuario = '" + usuario + "';";
    	  Statement st;
    	  
    	  
    	  try {
    		  Connection cn = conexion.conectar();
    		  st = cn.createStatement();
    		  ResultSet rs = st.executeQuery(sql);
    		  while (rs.next()) {
				respuesta= true;
				
			}
    	  
    	  }catch (SQLException e) {
    		  System.out.println("Error al consultar usuario" + e);
    		  
    	  }
    	  
		return respuesta;
    }
    
    /*
	 ******************************* 
	 * Metodo para guardar usuario *
	 *******************************
	 */
	public void guardar(javax.swing.JTextField textNombre, javax.swing.JTextField textApellido, javax.swing.JTextField textUser, javax.swing.JTextField textPassword, javax.swing.JTextField textTelefono) {
		if(textNombre.getText().isEmpty()|| textApellido.getText().isEmpty()|| textTelefono.getText().isEmpty()||
				textUser.getText().isEmpty()|| textPassword.getText().isEmpty()){
			
			JOptionPane.showMessageDialog(null, "Complete todos los campos");
			
		}else {
			
			//Verificar si el usuario ya está registrado
			Usuario usuario =new Usuario();
			Ctrl_Usuario ctrl_Usuario = new Ctrl_Usuario();
			if(!ctrl_Usuario.existeUsuario(textUser.getText().trim())) {
				
				//Enviamos los datos del usuario
				usuario.setNombre(textNombre.getText().trim());
				usuario.setApellido(textApellido.getText().trim());
				usuario.setUsuario(textUser.getText().trim());
				usuario.setPassword(textPassword.getText().trim());
				usuario.setTelefono(textTelefono.getText().trim());
				usuario.setEstado(1);
				
				if (agregar(usuario)) {
					JOptionPane.showMessageDialog(null, "Usuario registrado");
				}else {
					JOptionPane.showMessageDialog(null, "Error al registrar usuario");
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "El usuario ya está registrado, ingrese otro");
			}
			}
		}
	
    /*
	 ***********************************
	 * Metodo para actualizar usuarios *
	 ***********************************
	 */
    public void actualizar(javax.swing.JTable table, javax.swing.JTextField textNombre, javax.swing.JTextField textApellido, javax.swing.JTextField textUser, javax.swing.JTextField textPass, javax.swing.JTextField textTelefono) {
        try {
            Connection con = conexion.conectar();
            int filaSeleccionada = table.getSelectedRow();

            if (filaSeleccionada >= 0) {
                String nombre = textNombre.getText();
                String apellido = textApellido.getText();
                String user = textUser.getText();
                String pass = textPass.getText();
                String telefono = textTelefono.getText();

                String query = "UPDATE usuario SET nombre=?, apellido=?, usuario=?, password=?, telefono=? WHERE idUsuario=?";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, nombre);
                preparedStatement.setString(2, apellido);
                preparedStatement.setString(3, user);
                preparedStatement.setString(4, pass);
                preparedStatement.setString(5, telefono);
                preparedStatement.setInt(6, (int) table.getValueAt(filaSeleccionada, 0)); 
                preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(null, "Usuario editado.");

                con.close();
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e1) {
            System.out.println("Error al actualizar usuario: " + e1);
            JOptionPane.showMessageDialog(null, "Error al actualizar usuario: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /*
	 *********************************
	 * Metodo para eliminar usuarios *
	 *********************************
	 */
    public void eliminar(javax.swing.JTable table) {
        try {
            Connection con = conexion.conectar();
            int filaSeleccionada = table.getSelectedRow();

            if (filaSeleccionada >= 0) {

                int idUsuario = (int) table.getValueAt(filaSeleccionada, 0);

                String query = "DELETE FROM usuario WHERE idUsuario=?";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setInt(1, idUsuario);
                preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(null, "Usuario eliminado.");

                con.close();
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e1) {
            System.out.println("Error al eliminar usuario: " + e1);
            JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
