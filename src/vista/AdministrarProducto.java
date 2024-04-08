package vista;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import conexion.conexion;
import controlador.Ctrl_Producto;
import modelo.Producto;

import javax.swing.JSpinner;
import javax.swing.UIManager;

public class AdministrarProducto extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modo;
	private JTextField txtnombre;
	private JTextField textDescripcion;
	private JComboBox comboBoxCateg,comboBoxItbis;
	private Ctrl_Producto producto = new Ctrl_Producto(); 
	private JTextField precio;
	private JTextField txtcantidad;
	 int idProducto;
	 int obtenerIdCategoria = 0;
	 String descripcionCategoria = "";
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AdministrarProducto frame = new AdministrarProducto();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AdministrarProducto() {
		//setTitle("Adiministrar Productos");
                super("Adiministrar Productos",false,true,false,true);
		setDefaultCloseOperation(AdministrarProducto.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 886, 409);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 42, 854, 183);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 833, 162);
		panel.add(scrollPane);
		
		modo = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"IdProducto", "Nombre", "Cantidad", "Precio", "Descripcion","Itbis","IdCategoria","Estado"
				}
			);
			table = new JTable(modo);
			
			table.setFillsViewportHeight(true);
			scrollPane.setViewportView(table);
			 table.addMouseListener(new MouseAdapter() {
		            @Override
		                public void mouseClicked(MouseEvent e) {
		                    int fila_point = table.rowAtPoint(e.getPoint());
		                    int columna_point = 0;

		                    if (fila_point > -1) {
		                        idProducto = (int) modo.getValueAt(fila_point, columna_point);
		                        EnviarDatosProductoSeleccionado(idProducto);//metodo
		                    }
		            }
		        });
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 929, 35);
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setForeground(new Color(0, 0, 0));
		contentPane.add(panel_1);
		
		JLabel lblAdiministrarUsuario = new JLabel("Adiministrar Productos");
		lblAdiministrarUsuario.setForeground(Color.WHITE);
		lblAdiministrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblAdiministrarUsuario);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(192, 192, 192));
		panel_2.setBounds(10, 235, 854, 120);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNombres = new JLabel("Nombre:");
		lblNombres.setBounds(20, 6, 81, 22);
		lblNombres.setBackground(new Color(0, 0, 0));
		lblNombres.setForeground(new Color(0, 0, 0));
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblNombres);
		
		JLabel lblApellido = new JLabel("Precio:");
		lblApellido.setBounds(317, 6, 81, 22);
		lblApellido.setForeground(new Color(0, 0, 0));
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblApellido);
		
		JLabel lblUsuario = new JLabel("Descripción:");
		lblUsuario.setBounds(263, 41, 121, 22);
		lblUsuario.setForeground(new Color(0, 0, 0));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblUsuario);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(111, 6, 136, 25);
		txtnombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtnombre.setColumns(10);
		panel_2.add(txtnombre);
		
		textDescripcion = new JTextField();
		textDescripcion.setBounds(394, 41, 136, 25);
		textDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textDescripcion.setColumns(10);
		panel_2.add(textDescripcion);
		
		JLabel lblItbis = new JLabel("ITBIS:");
		lblItbis.setForeground(new Color(0, 0, 0));
		lblItbis.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblItbis.setBounds(602, -5, 60, 44);
		panel_2.add(lblItbis);
		
		comboBoxItbis = new JComboBox();
		comboBoxItbis.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxItbis.setModel(new DefaultComboBoxModel(new String[] {"Seleccione ITBIS:", "No paga ITBIS", "18%"}));
		comboBoxItbis.setBounds(667, 8, 181, 28);
		panel_2.add(comboBoxItbis);
		
		JLabel lblCategorias = new JLabel("Categorias:");
		lblCategorias.setForeground(new Color(0, 0, 0));
		lblCategorias.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCategorias.setBounds(556, 30, 106, 44);
		panel_2.add(lblCategorias);
		
        comboBoxCateg = new JComboBox();
		comboBoxCateg.setModel(new DefaultComboBoxModel(new String[] {"Selecciona categoría:"}));
		comboBoxCateg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxCateg.setBounds(667, 39, 181, 28);
		panel_2.add(comboBoxCateg);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(136, 78, 112, 21);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			       int filaSeleccionada = table.getSelectedRow();
					  producto.eliminar(table);
					  limpiarTabla(modo);
					  cargarDatosProducto();
						limpiar();	   
					
			}
		});
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(14, 78, 112, 21);
		btnActualizar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Verificar si se ha seleccionado un producto de la tabla
		        if (idProducto != 0) {
		            try {
		                // Obtener los datos ingresados en los campos de texto
		                String nombre = txtnombre.getText().trim();
		                int cantidad = Integer.parseInt(txtcantidad.getText().trim());
		                double Precio = Double.parseDouble(precio.getText().trim());
		                String descripcion = textDescripcion.getText().trim();
		                String itbis = comboBoxItbis.getSelectedItem().toString().trim();
		                String categoria = comboBoxCateg.getSelectedItem().toString().trim();
		                
		                // Crear un objeto Producto con los nuevos datos
		                Producto productoActualizado = new Producto();
		                productoActualizado.setNombre(nombre);
		                productoActualizado.setCantidad(cantidad);
		                productoActualizado.setPrecio(Precio);
		                productoActualizado.setDescripcion(descripcion);
		                
		                // Asignar el valor de itbis dependiendo de la selección
		                if (itbis.equalsIgnoreCase("No paga ITBIS")) {
		                    productoActualizado.setItbis(0);
		                } else if (itbis.equalsIgnoreCase("18%")) {
		                    productoActualizado.setItbis(18);
		                }
		                
		                // Obtener el ID de la categoría seleccionada
		                IdCategoria(comboBoxCateg);
		                productoActualizado.setIdCategoria(obtenerIdCategoria);
		                productoActualizado.setEstado(1); 
		                
		                // Llamar al método de actualización del controlador
		                if (producto.actualizar(productoActualizado, idProducto)) {
		                    JOptionPane.showMessageDialog(null, "Producto actualizado correctamente.");
		                    limpiar();
		                    limpiarTabla(modo);
		                    cargarDatosProducto();
		                } else {
		                    JOptionPane.showMessageDialog(null, "Error al actualizar el producto.", "Error", JOptionPane.ERROR_MESSAGE);
		                }
		            } catch (NumberFormatException ex) {
		                JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor numérico válido para el precio.", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Por favor, seleccione un producto de la tabla para actualizar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		        }
		    }
		});
		btnActualizar.setForeground(new Color(255, 255, 255));
		btnActualizar.setBackground(new Color(0, 64, 128));
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(btnActualizar);
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminar.setBackground(new Color(255, 0, 0));
		panel_2.add(btnEliminar);
		
		
		producto.cargarComboCategoria(comboBoxCateg);
		
		precio = new JTextField();
		precio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		precio.setColumns(10);
		precio.setBounds(394, 6, 136, 25);
		panel_2.add(precio);
		
		JLabel Cantida = new JLabel("Cantidad:");
		Cantida.setForeground(Color.BLACK);
		Cantida.setFont(new Font("Tahoma", Font.BOLD, 18));
		Cantida.setBackground(Color.BLACK);
		Cantida.setBounds(20, 38, 81, 22);
		panel_2.add(Cantida);
		
		txtcantidad = new JTextField();
		txtcantidad.setEnabled(false);
		txtcantidad.setEditable(false);
		txtcantidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtcantidad.setColumns(10);
		txtcantidad.setBounds(111, 38, 136, 25);
		panel_2.add(txtcantidad);
		cargarDatosProducto();
	}
	/*
	 * **************************************
	 * Metodo para cargar datos de usuarios *
	 ****************************************
	 */
	
	public void cargarDatosProducto() {
		try {
		Connection con = conexion.conectar();
		Statement st = con.createStatement();
		
		ResultSet rSet = st.executeQuery("select idProducto, nombre, cantidad, precio, descripcion,itbis,idCategoria,estado from producto");
		
		while (rSet.next()) {
			
			modo.addRow(new Object [] {rSet.getInt("idProducto"),rSet.getString("nombre"),rSet.getInt("cantidad"),rSet.getDouble("precio"),rSet.getString("descripcion"),rSet.getInt("itbis"),rSet.getInt("idCategoria"),rSet.getInt("estado")});
			
			
			
			}
			con.close();
			
		}catch(SQLException e) {
			System.out.println("Error al cargar la tabla usuario" + e);
			
		}
				
	}
	/*
	 * *******************************************
	 * Metodo para cargar datos de seleccionados *
	 *********************************************
	 */
	
	 private void EnviarDatosProductoSeleccionado(int idProducto) {
	    
		 try {
	            Connection con = conexion.conectar();
	           
				PreparedStatement pst = con.prepareStatement(
	                    "select * from producto where idProducto = '" + idProducto + "'");
	            ResultSet rs = pst.executeQuery();
	            if (rs.next()) {
	                txtnombre.setText(rs.getString("nombre"));
	                txtcantidad.setText(rs.getString("cantidad"));
	                precio.setText(rs.getString("precio"));
	                textDescripcion.setText(rs.getString("descripcion"));
	                int iva = rs.getInt("itbis");
	                switch (iva) {
	                    case 0:
	                        comboBoxItbis.setSelectedItem("No paga ITBIS");
	                        break;
	                    case 18:
	                        comboBoxItbis.setSelectedItem("18%");
	                        break;
	                    
	                    default:
	                        comboBoxItbis.setSelectedItem("Seleccione ITBIS:");
	                        break;
	                }
	                int idCate = rs.getInt("idCategoria");
	                comboBoxCateg.setSelectedItem(relacionarCategoria(idCate));  
	            }
	            con.close();
	        } catch (SQLException e) {
	            System.out.println("Error al seleccionar producto: " + e);
	        }
	}
    

		
		/*
		 ********************************
		 * Metodo para limpiar la tabla *
		 ********************************
		 */
		public void limpiarTabla(DefaultTableModel model) {
           while (model.getRowCount() > 0) {
        	   model.removeRow(0);
        	   }
           }

		  /*
	     * ***********************************
	     * Metodo para relacionar categorias *
	     * ***********************************
	     */
			public int IdCategoria(javax.swing.JComboBox comboBoxCateg) {
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
			
		    private String relacionarCategoria(int idCategoria) {

		        String sql = "select descripcion from categoria where idCategoria = '" + idCategoria + "'";
		        Statement st;
		        try {
		            Connection cn = conexion.conectar();
		            st = cn.createStatement();
		            ResultSet rs = st.executeQuery(sql);
		            while (rs.next()) {
		                descripcionCategoria = rs.getString("descripcion");
		            }
		            cn.close();

		        } catch (SQLException e) {
		            System.out.println("¡Error al obtener el id de la categoria!");
		        }
		        return descripcionCategoria;
		    }

		 /*
		 **********************
		 * Metodo para limpiar *
		 ***********************
		 */ 
		public void limpiar() {
			txtnombre.setText("");
			  precio.setText("");
			  textDescripcion.setText("");
			  comboBoxItbis.setSelectedItem("Seleccione ITBIS:");
			  comboBoxCateg.setSelectedItem("Seleccione categoria:"); 
		}
}
