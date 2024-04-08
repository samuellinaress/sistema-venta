package controlador;

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import conexion.conexion;
import modelo.Producto;
import vista.intCategoria;

/*
 * @author Angel Miguel de la Rosa
 */
public class Ctrl_Producto {

	int obtenerIdCategoria = 0;
	//private int idProducto;
	/*
	***********************************
    * Metodo para agregar un producto *
    ***********************************
    */
   public boolean agregar(Producto objeto){
   	  boolean respuesta = false;
   	  Connection cn = conexion.conectar();
   	  
   	  try {
   		  
   		  PreparedStatement consulta = cn.prepareStatement("insert into producto value(?,?,?,?,?,?,?,?)");
   		  consulta.setInt(1, 0);//ID
   		  consulta.setString(2, objeto.getNombre());
   		  consulta.setInt(3, objeto.getCantidad());
   		  consulta.setDouble(4, objeto.getPrecio());
   		  consulta.setString(5, objeto.getDescripcion());
   		  consulta.setInt(6, objeto.getItbis());
   		  consulta.setInt(7, objeto.getIdCategoria());
   		  consulta.setInt(8, objeto.getEstado());
   		  
   	  if (consulta.executeUpdate() > 0) {
   		  respuesta = true;
   		  
   	  }
   	  
   	  cn.close();
   	  
   	  }catch (SQLException e) {
   		  System.out.println("Error al guardar producto" + e);
   		  
   	  }
   	  
		return respuesta;
   }
   
   /*
    ********************************************************************
    * Metodo para revisar si el producto ya esta registrado en la BBDD *
    ********************************************************************
    */
   public boolean existeProducto(String producto){
   	  boolean respuesta = false;
   	  String sql = "select nombre from producto where nombre = '" + producto + "';";
   	  Statement st;
   	  
   	  
   	  try {
   		  Connection cn = conexion.conectar();
   		  st = cn.createStatement();
   		  ResultSet rs = st.executeQuery(sql);
   		  while (rs.next()) {
				respuesta= true;
				
			}
   	  
   	  }catch (SQLException e) {
   		  System.out.println("Error al consultar producto" + e);
   		  
   	  }
   	  
		return respuesta;
   }
   
 
   

   /*
	 ********************************
	 * Metodo para cargar categoria *
	 ********************************
	 */
 
public void cargarComboCategoria(javax.swing.JComboBox comboBoxCateg) {
	   Connection cn = conexion.conectar();
	   String sql="select * from categoria";
	   Statement st;
	   
	   try {
		   st = cn.createStatement();
		   ResultSet rs = st.executeQuery(sql);
		   comboBoxCateg.removeAllItems();
		   comboBoxCateg.addItem("Seleccione categoria:");
		   
		   while(rs.next()) {
			   comboBoxCateg.addItem(rs.getString("descripcion"));
		   }
		   
		   cn.close();
	   
	   }catch (SQLException e) {
		   System.out.println("Error al cargar categoria" + e);
	   }
   }
   
   /*
	 ******************************* 
	 * Metodo para guardar usuario *
	 *******************************
	 
    */
	public void guardar(javax.swing.JTextField textNombre,javax.swing.JSpinner cantidad, javax.swing.JSpinner precio ,javax.swing.JTextField textDescripcion,
		 javax.swing.JComboBox comboBoxItbis,javax.swing.JComboBox comboBoxCateg,javax.swing.JLabel X1,javax.swing.JLabel X2,javax.swing.JLabel X3,
		 javax.swing.JLabel X4,javax.swing.JLabel X5,javax.swing.JLabel X6) {
			
			Producto producto =new Producto();
			Ctrl_Usuario ctrl_Usuario = new Ctrl_Usuario();
			
			String itbis = "";
			String categoria = "";
			itbis = comboBoxItbis.getSelectedItem().toString().trim();
			categoria = comboBoxCateg.getSelectedItem().toString().trim();
			
			// Validar campos
		    if (textNombre.getText().isEmpty()) {
		       X1.setForeground(Color.red);
		    	JOptionPane.showMessageDialog(null, "Complete el campo nombre ");     
		        return; 
		            } X1.setForeground(new Color(64, 128, 128));
		            
		    // Validar que la cantidad no sea cero
		    int cantidadSeleccionada = (int) cantidad.getValue();
		    if (cantidadSeleccionada <=0) {
		         X2.setForeground(Color.red);
		        JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor que cero");
		       return; 
		    }X2.setForeground(new Color(64, 128, 128));        
		    
		   // Validar que el precio no sea cero
		    int precioSeleccionado = (int) precio.getValue();
		    if (precioSeleccionado <=0) {
		        X3.setForeground(Color.red);
		        JOptionPane.showMessageDialog(null, "El precio debe ser mayor que cero");
		        return; 
		    }X3.setForeground(new Color(64, 128, 128));
		            
		   if (textDescripcion.getText().isEmpty()){
			   X4.setForeground(Color.red);
			   JOptionPane.showMessageDialog(null, "Complete el campo descripcion ");
			   return; 
			   
		   }X4.setForeground(new Color(64, 128, 128));
			
		   if(!existeProducto(textNombre.getText().trim())){
			   if(itbis.equalsIgnoreCase("Seleccione ITBIS:")) {
				   X5.setForeground(Color.red);
				   JOptionPane.showMessageDialog(null, "Seleccione el ITBIS ");
			
			   }
				else {
					X5.setForeground(new Color(64, 128, 128));
					if(categoria.equalsIgnoreCase("Seleccione categoria:")) {
						   X6.setForeground(Color.red);
						   JOptionPane.showMessageDialog(null, "Seleccione la categoria");
						
					   }else {
						  X6.setForeground(new Color(64, 128, 128)); 
						  
						  try {
							  
							  producto.setNombre(textNombre.getText().trim());
							  producto.setCantidad(cantidadSeleccionada);
							  producto.setPrecio(precioSeleccionado);
							  producto.setDescripcion(textDescripcion.getText());
							  
							  //Porsentaje de itbis
							  if (itbis.equalsIgnoreCase("No paga ITBIS")) {
								producto.setItbis(0);
								
							}else if (itbis.equalsIgnoreCase("18%")) {
								producto.setItbis(18);
							}
							  
							  //idCategoria cargar metodo que obtine cargar categoria
							  this.IdCategoria(comboBoxCateg);
							  producto.setIdCategoria(obtenerIdCategoria);
							  producto.setEstado(1);
							  
							  if (agregar(producto)) {
								  JOptionPane.showMessageDialog(null, "Producto guardo.");
								  textNombre.setText("");
								  cantidad.setModel(new SpinnerNumberModel(Integer.valueOf(0), null, null, Integer.valueOf(0)));
								  precio.setModel(new SpinnerNumberModel(Integer.valueOf(0), null, null, Integer.valueOf(0)));
								  textDescripcion.setText("");
								  comboBoxItbis.setSelectedItem("Seleccione ITBIS:");
								  comboBoxCateg.setSelectedItem("Seleccione categoria:");  
							  }
							  
							  
						  }catch (HeadlessException | NumberFormatException e) {
							  System.out.println("Error");
						  }
						  
						 
					   }
				}
		   }else {
			   X1.setForeground(Color.red);
			   JOptionPane.showMessageDialog(null, "El profucto ya existe.");
		   }
				
				
			}
			
	 /*
		 *********************************
		 * Metodo para obtener categoria *
		 *********************************
		 */
	private int IdCategoria(javax.swing.JComboBox comboBoxCateg) {
	    String sql = "select idCategoria from categoria where descripcion = '" + comboBoxCateg.getSelectedItem() + "'";
	    Statement st;
	    try {
	        Connection cn = conexion.conectar();
	        st = cn.createStatement();
	        ResultSet rS = st.executeQuery(sql);
	        while (rS.next()) {
	            obtenerIdCategoria = rS.getInt("idCategoria");
	        }
	        cn.close(); 
	    } catch (SQLException e) {
	        System.out.println("Error al obtener categoria: " + e.getMessage()); 
	    }
	    return obtenerIdCategoria;
	}

	
	
	
   /*
	 ************************************
	 * Metodo para actualizar productos *
	 ************************************
	 */

	public boolean actualizar(Producto objeto, int idProducto) {
	    boolean respuesta = false;
	    Connection cn = conexion.conectar();
	    try {
	        PreparedStatement consulta = cn.prepareStatement("UPDATE producto SET nombre=?, cantidad=?, precio=?, descripcion=?, itbis=?, idCategoria=?, estado=? WHERE idProducto=?");
	        consulta.setString(1, objeto.getNombre());
	        consulta.setInt(2, objeto.getCantidad());
	        consulta.setDouble(3, objeto.getPrecio());
	        consulta.setString(4, objeto.getDescripcion());
	        consulta.setInt(5, objeto.getItbis());
	        consulta.setInt(6, objeto.getIdCategoria());
	        consulta.setInt(7, objeto.getEstado());
	        consulta.setInt(8, idProducto);

	        if (consulta.executeUpdate() > 0) {
	            respuesta = true;
	        }
	        cn.close();
	    } catch (SQLException e) {
	        System.out.println("Error al actualizar producto: " + e);
	    }
	    return respuesta;
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

               int idProducto = (int) table.getValueAt(filaSeleccionada, 0);

               String query = "DELETE FROM producto WHERE idProducto=?";
               PreparedStatement preparedStatement = con.prepareStatement(query);
               preparedStatement.setInt(1, idProducto);
               preparedStatement.executeUpdate();

               JOptionPane.showMessageDialog(null, "Producto eliminado.");

               con.close();
           } else {
               JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
           }
       } catch (SQLException e1) {
           System.out.println("Error al eliminar usuario: " + e1);
           JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
       }
   }
   
   
   /*
	 *********************************
	 * Metodo para obtener productos *
	 *********************************
	 */
   public void cargarComboProducto(javax.swing.JComboBox comboBoxCateg) {
	   Connection cn = conexion.conectar();
	   String sql="select * from producto";
	   Statement st;
	   
	   try {
		   st = cn.createStatement();
		   ResultSet rs = st.executeQuery(sql);
		   comboBoxCateg.removeAllItems();
		   comboBoxCateg.addItem("Seleccione producto:");
		   
		   while(rs.next()) {
			   comboBoxCateg.addItem(rs.getString("nombre"));
		   }
		   
		   cn.close();
	   
	   }catch (SQLException e) {
		   System.out.println("Error al cargar categoria" + e);
	   }
   }
	
   /**
    ********************************************
    * Metodo para actualizar stock un producto *
    ********************************************
    */
   
    public boolean actualizarStock(Producto object, int idProducto) {
       boolean respuesta = false;
       Connection cn = conexion.conectar();
       try {
           PreparedStatement consulta = cn.prepareStatement("update producto set cantidad=? where idProducto ='" + idProducto + "'");
           consulta.setInt(1, object.getCantidad());

           if (consulta.executeUpdate() > 0) {
               respuesta = true;
           }
           cn.close();
       } catch (SQLException e) {
           System.out.println("Error al actualizar stock del producto: " + e);
       }
       return respuesta;
   }
}
