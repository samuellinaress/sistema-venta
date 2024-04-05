package controlador;

/**
 *
 * @author Samuel Linares
 */
public interface iCRUD {
    
    void guardar(javax.swing.JTextField textNombre, 
            javax.swing.JTextField textApellido, javax.swing.JTextField textCedula, 
            javax.swing.JTextField textTelefono, javax.swing.JTextField textDireccion);
  
    void actualizar(javax.swing.JTable table, javax.swing.JTextField textNombre, 
            javax.swing.JTextField textApellido, javax.swing.JTextField textCedula, 
            javax.swing.JTextField textTelefono, javax.swing.JTextField textDireccion);
    
    void eliminar(javax.swing.JTable table);
    
}
