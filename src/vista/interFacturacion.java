
package vista;
// Autor: Angel Naut
import java.awt.EventQueue;

import modelo.CabeceraVenta;
import modelo.DetalleVenta;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Point;


import conexion.conexion;
import controlador.Ctrl_RegistrarVenta;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class interFacturacion extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtcantidad;
	private JTextField clienteBuscar;
	private JTable tableProductos;
	private JTextField txt_subtotal;
	private JTextField txt_descuento;
	private JTextField txt_itbis;
	private JTextField txt_totalPagar;
	private JTextField txt_efectivo;
	private JTextField txt_cambio;
	private JComboBox CB_cliente;
	private JComboBox CB_producto;
	private DefaultTableModel modeloDatosProductos;
	//lista para el detalle de los productos
	ArrayList<DetalleVenta> ListaProductos = new ArrayList<>();
	private DetalleVenta producto;
	
	private int idCliente = 0; // id del cliente
	
	
	
	private int idProducto = 0;
	private String nombre = "";
	private int cantidadProductoBBDD = 0;
	private double precioUnitario = 0.0;
	private int porcentajeItbis = 0 ;
	
	private int cantidad = 0; // cantidad de productos a comprar
	private double subtotal = 0.0;//cantidad por precio
	private double descuento = 0.0;
	private double itbis = 0.0;
	private double totalPagar = 0.0;
	
	//variables para calculos globales
	private double subTotalGeneral = 0.0;
	private double descuentoGeneral = 0.0;
	private double itbisGeneral = 0.0;
	private double totalPagarGeneral = 0.0;
	
	
	
	private int auxIdDetalle = 1; // id del detalle de venta
	
	int idArraylist = 0;
	
	public interFacturacion() {
		
		
        super("Facturacion", true, true, false, true);
		getContentPane().setName("");
		setBounds(100, 100, 800, 674);
		getContentPane().setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Facturacion");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(345, 11, 117, 22);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cliente:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(67, 57, 60, 22);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Producto:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(51, 90, 69, 22);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Cantidad:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(281, 90, 69, 22);
		getContentPane().add(lblNewLabel_1_1_1);
		
		txtcantidad = new JTextField();
		txtcantidad.setBounds(360, 90, 115, 28);
		getContentPane().add(txtcantidad);
		txtcantidad.setColumns(10);
		
		CB_cliente = new JComboBox();
        CB_cliente.setBounds(129, 59, 142, 22);
        getContentPane().add(CB_cliente);
		
		CB_producto = new JComboBox();
		CB_producto.setBounds(129, 90, 142, 22);
		getContentPane().add(CB_producto);
		
		CargarComboProductos();
		
		
		clienteBuscar = new JTextField();
		clienteBuscar.setBounds(284, 55, 191, 30);
		getContentPane().add(clienteBuscar);
		clienteBuscar.setColumns(10);
		
		CargarComboCliente();
		
		JButton botonBuscar = new JButton("Buscar");
		botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cliente_buscar = clienteBuscar.getText().trim();
				Connection cn = conexion.conectar();
				String sql = "select nombre, apellido from cliente where cedula = '"+ cliente_buscar +"'";
				Statement st;
				
				try {
					st = cn.createStatement();
					ResultSet rs =  st.executeQuery(sql);
					
					if(rs.next()) {
						CB_cliente.setSelectedItem(rs.getString("nombre") + " " + rs.getString("apellido"));
						
						
					}else {
						CB_cliente.setSelectedItem("Seleccionar cliente:");
						JOptionPane.showMessageDialog(null, "Cedula de cliente incorrecta o no encontrada");
						
					}
					clienteBuscar.setText("");
					cn.close();
				}catch(SQLException e1) {
					System.out.println("" + e1);
				}
				
			}
		});
		botonBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonBuscar.setBounds(657, 57, 117, 23);
		getContentPane().add(botonBuscar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(345, 346, 405, 287);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnCalcularCambio = new JButton("Calcular Cambio");
		btnCalcularCambio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txt_efectivo.getText().isEmpty()) {
					//validar que el usuario no ingrese caracteres no numericos
					boolean validacion =  validarDouble(txt_efectivo.getText());
					if(validacion == true) {
						//validad que el efectivo sea mayor a cero
						
						double efc = Double.parseDouble(txt_efectivo.getText().trim());
						double top = Double.parseDouble(txt_totalPagar.getText().trim());
						
						if(efc < top) {
							JOptionPane.showMessageDialog(null, "El dinero en efectivo no es suficiente");
							
						}else {
							double cambio = (efc - top);
							double cambi = (double) Math.round(cambio * 100d) / 100;
							String camb = String.valueOf(cambi);
							txt_cambio.setText(camb);
							
							
						}
						
					}else {
						
						JOptionPane.showMessageDialog(null, "No se admiten caracteres no numericos");
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "ingrese dinero en efectivo para calcular cambio");
				}
				
			}
		});
		btnCalcularCambio.setEnabled(false);
		btnCalcularCambio.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCalcularCambio.setBounds(127, 233, 170, 44);
		panel_1.add(btnCalcularCambio);
		
		JButton btnanadir = new JButton("Añadir Productos");
		btnanadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String combo = CB_producto.getSelectedItem().toString();
				//validar que seleccione un producto
				if(combo.equalsIgnoreCase("Seleccione producto:")) {
					JOptionPane.showMessageDialog(null, "Seleccione un producto");
				
				
				}else {
					//validar que ingrese una cantidad
					if(!txtcantidad.getText().isEmpty()) {
						//validar que el usuario no ingrese caracteres no numericos;
						
						boolean validacion = validar(txtcantidad.getText());
						
						if(validacion == true){
							//validar que la cantidad se mayor a cero
							if(Integer.parseInt(txtcantidad.getText()) > 0) {
								
								cantidad = Integer.parseInt(txtcantidad.getText());
								// eejecutar metodo para obetener datos del producto
								DatosDelProducto();
								
								// validar que la cantidad de productos seleccionados no sea mayor al stock de la base de datos
								if(cantidad <= cantidadProductoBBDD) {
									subtotal =  precioUnitario * cantidad;
									totalPagar = subtotal + itbis - descuento;
									
									//redondar decimales
									
									subtotal = (double) Math.round(subtotal*100) / 100;
									itbis = (double) Math.round(itbis*100) / 100;
									descuento = (double) Math.round(descuento*100) / 100;
									totalPagar = (double) Math.round(totalPagar*100) / 100;
									// se crea un nuevo producto
									
									producto =  new DetalleVenta(auxIdDetalle, //idDetalleventa
									1, //	idCabecera
									idProducto,
									nombre,
									Integer.parseInt(txtcantidad.getText()),
									precioUnitario,
									subtotal,
									descuento,
									itbis,
									totalPagar,
									1   //estado
									
											);
									
									//añadir a la lista
									ListaProductos.add(producto);
									JOptionPane.showMessageDialog(null, "Producto Agregado");
									auxIdDetalle++;
									txtcantidad.setText("");//limpiar el campo
									//volver a caragar combo productos
									CargarComboProductos();
									CalcularTotalPagar();
									txt_efectivo.setEnabled(true);
									btnCalcularCambio.setEnabled(true);
								}
							}else {
								JOptionPane.showMessageDialog(null, "la cantidad no puede ser cero ni negativa");
							}
							
						}else {
							JOptionPane.showMessageDialog(null, "en la cantidad no se admiten caracteres no numericos");
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Seleccione la cantidad de productos");
					}
				}
				
				// llamar metodo
				listaTablaProductos();
			}
		});
		btnanadir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnanadir.setBounds(491, 90, 170, 23);
		getContentPane().add(btnanadir);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 123, 742, 212);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 742, 212);
		panel.add(scrollPane);
		
		tableProductos = new JTable();
		tableProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila_point = tableProductos.rowAtPoint(e.getPoint());
				int columna_point = 0;
				
				if(fila_point > -1) {
					idArraylist =  (int) modeloDatosProductos.getValueAt(fila_point, columna_point);
					
					}
				int opcion = JOptionPane.showConfirmDialog(null, "¿Eliminar Producto?)");
				//opciones de confir dialog - ( si = 0; no = 1; cancel = 2; close = -1)
				
				switch (opcion) {
				case 0: //presione si
					ListaProductos.remove(idArraylist - 1);
					CalcularTotalPagar();
					listaTablaProductos();
					break;
					
				case 1: // presione 1
					break;
					
				default: //si presiona cancel(2) o close (-1)	
					break;
				}
			}
		});
		scrollPane.setColumnHeaderView(tableProductos);
		inicializarTablaProducto();
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Subtotal:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 11, 70, 24);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Descuento:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(10, 48, 86, 24);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Itbis:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(10, 83, 103, 24);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Total a pagar:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(10, 121, 103, 24);
		panel_1.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Efectivo:");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_4.setBounds(10, 156, 103, 24);
		panel_1.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("Cambio:");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_5.setBounds(10, 198, 103, 24);
		panel_1.add(lblNewLabel_2_5);
		
		txt_subtotal = new JTextField();
		txt_subtotal.setEnabled(false);
		txt_subtotal.setBounds(127, 15, 142, 30);
		panel_1.add(txt_subtotal);
		txt_subtotal.setColumns(10);
		
		txt_subtotal.setText("0.0");
		
		txt_descuento = new JTextField();
		txt_descuento.setEnabled(false);
		txt_descuento.setBounds(127, 52, 142, 30);
		panel_1.add(txt_descuento);
		txt_descuento.setColumns(10);
		txt_descuento.setText("0.0");
		
		txt_itbis = new JTextField();
		txt_itbis.setEnabled(false);
		txt_itbis.setBounds(127, 87, 142, 30);
		panel_1.add(txt_itbis);
		txt_itbis.setColumns(10);
		txt_itbis.setText("0.0");
		
		txt_totalPagar = new JTextField();
		txt_totalPagar.setEnabled(false);
		txt_totalPagar.setBounds(127, 125, 142, 30);
		panel_1.add(txt_totalPagar);
		txt_totalPagar.setColumns(10);
		txt_totalPagar.setText("0.0");
		
		txt_efectivo = new JTextField();
		txt_efectivo.setEnabled(false);
		txt_efectivo.setBounds(127, 160, 142, 30);
		panel_1.add(txt_efectivo);
		txt_efectivo.setColumns(10);
		
		txt_cambio = new JTextField();
		txt_cambio.setEnabled(false);
		txt_cambio.setBounds(127, 202, 142, 30);
		panel_1.add(txt_cambio);
		txt_cambio.setColumns(10);
		
		
		
		JButton btnNewButton_2 = new JButton("Registrar Venta");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CabeceraVenta cabeceraVenta = new CabeceraVenta();
		        DetalleVenta detalleVenta = new DetalleVenta();
		        Ctrl_RegistrarVenta controlVenta = new Ctrl_RegistrarVenta();
		        

		        String fechaActual = "";
		        Date date = new Date();
		        fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
		        
		        if (!CB_cliente.getSelectedItem().equals("Seleccione cliente:")) {
		            if (ListaProductos.size() > 0) {

		                //metodo para obtener el id del cliente
		                ObtenerIdCliente();
		                //registrar cabecera
		                cabeceraVenta.setIdCabeceraventa(0);
		                cabeceraVenta.setIdCliente(idCliente);
		                cabeceraVenta.setValorPagar(Double.parseDouble(txt_totalPagar.getText()));
		                cabeceraVenta.setFechaVenta(fechaActual);
		                cabeceraVenta.setEstado(1);

		                if (controlVenta.guardar(cabeceraVenta)) {
		                    JOptionPane.showMessageDialog(null, "¡Venta Registrada!");

		                    //guardar detalle
		                    for (DetalleVenta elemento : ListaProductos) {
		                        detalleVenta.setIdDetalleVenta(0);
		                        detalleVenta.setIdCabeceraVenta(0);
		                        detalleVenta.setIdProducto(elemento.getIdProducto());
		                        detalleVenta.setCantidad(elemento.getCantidad());
		                        detalleVenta.setPrecioUnitario(elemento.getPrecioUnitario());
		                        detalleVenta.setSubTotal(elemento.getSubTotal());
		                        detalleVenta.setDescuento(elemento.getDescuento());
		                        detalleVenta.setItbis(elemento.getItbis());
		                        detalleVenta.setTotalPagar(elemento.getTotalPagar());
		                        detalleVenta.setEstado(1);

		                        if (controlVenta.guardarDetalle(detalleVenta)) {
		                            //System.out.println("Detalle de Venta Registrado");

		                            txt_subtotal.setText("0.0");
		                            txt_itbis.setText("0.0");
		                            txt_descuento.setText("0.0");
		                            txt_totalPagar.setText("0.0");
		                            txt_efectivo.setText("");
		                            txt_cambio.setText("0.0");
		                            auxIdDetalle = 1;

		                            CargarComboCliente();
		                            RestarStockProductos(elemento.getIdProducto(), elemento.getCantidad());

		                        } else {
		                            JOptionPane.showMessageDialog(null, "¡Error al guardar detalle de venta!");
		                        }
		                    }
		                    //vaciamos la lista
		                    ListaProductos.clear();
		                    listaTablaProductos();

		                } else {
		                    JOptionPane.showMessageDialog(null, "¡Error al guardar cabecera de venta!");
		                }
		            } else {
		                JOptionPane.showMessageDialog(null, "¡Seleccione un producto!");
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "¡Seleccione un cliente!");
		        }

		    }
			
		});
		btnNewButton_2.setBounds(193, 396, 142, 102);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Buscar cliente por cedula");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(480, 53, 181, 30);
		getContentPane().add(lblNewLabel_3);
		
		
		
		
	}
	//metodo para mostrar los datos del producto
	
	private void DatosDelProducto() {
		try {
			String sql = "select * from producto where nombre = '"+CB_producto.getSelectedItem()+"'";
			Connection cn = conexion.conectar();
			Statement st;
			st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
			idProducto = rs.getInt("idProducto");
			nombre = rs.getString("nombre");
			cantidadProductoBBDD = rs.getInt("cantidad");
			precioUnitario = rs.getDouble("precio");
			porcentajeItbis	= rs.getInt("itbis");
			calcularItbis(precioUnitario, porcentajeItbis);//calcula y retorna el itbis
			}
			
		}catch(SQLException e) {
			System.out.println("Error al obtener datos del producto, " + e);
		}
		
	}
	
	//metodo para calcular itbis
	private double calcularItbis(double precio, int porcentajeItbis) {
		int p_itbis = porcentajeItbis;
		
		switch(p_itbis) {
		case 0:
			itbis = 0.0;
			break;
		case 18:
			itbis = (precio * cantidad) * 0.18;
			default:
				break;
		}
		return itbis;
	}
	
	//metodo para validar que el usuario no ingrese caracteres no numericos
	
	private boolean validar(String valor) {
		try {
			int num = Integer.parseInt(valor);
			return true;
		}catch(NumberFormatException e) {
			
			return false;
		}
	
	}
	
	
	//metodo para validar que el usuario no ingrese caracteres no numericos
	
		private boolean validarDouble(String valor) {
			try {
				double num = Double.parseDouble(valor);
				return true;
			}catch(NumberFormatException e) {
				
				return false;
			}
		
		}
	
	//metodo para inicializar la tabla de los productos
	
	private void inicializarTablaProducto(){
		 modeloDatosProductos = new DefaultTableModel();

		    // Añadir columnas al modelo
		    modeloDatosProductos.addColumn("N");
		    modeloDatosProductos.addColumn("Nombre");
		    modeloDatosProductos.addColumn("Cantidad");
		    modeloDatosProductos.addColumn("P. Unitario");
		    modeloDatosProductos.addColumn("SubTotal");
		    modeloDatosProductos.addColumn("Descuento");
		    modeloDatosProductos.addColumn("Itbis");
		    modeloDatosProductos.addColumn("Total Pagar");
		    modeloDatosProductos.addColumn("Acción");

		    // Configurar el modelo como el modelo de datos de la tabla
		    tableProductos.setModel(modeloDatosProductos);
		
		
		
	}
	
	//metodo para presentar la informacion de la tabla ventas
			private void listaTablaProductos() {
			modeloDatosProductos.setRowCount(ListaProductos.size());
			for(int i = 0; i < ListaProductos.size(); i++) {
				modeloDatosProductos.setValueAt(i + 1, i, 0);
				modeloDatosProductos.setValueAt(ListaProductos.get(i).getNombre(), i, 1);
				modeloDatosProductos.setValueAt(ListaProductos.get(i).getCantidad(), i, 2);
				modeloDatosProductos.setValueAt(ListaProductos.get(i).getPrecioUnitario(), i, 3);
				modeloDatosProductos.setValueAt(ListaProductos.get(i).getSubTotal(), i, 4);
				modeloDatosProductos.setValueAt(ListaProductos.get(i).getDescuento(), i, 5);
				modeloDatosProductos.setValueAt(ListaProductos.get(i).getItbis(), i, 6);
				modeloDatosProductos.setValueAt(ListaProductos.get(i).getTotalPagar(), i, 7);
				modeloDatosProductos.setValueAt("Eliminar", i, 8);//aqui luego poner un boto eliminar productos
				
				//añadir al Jtable
				tableProductos.setModel(modeloDatosProductos);
			}
				
			}
			
	
	// Metodo para cargar los clientes en el jCombo
	
			// Método para cargar el JComboBox de clientes
			public void CargarComboCliente() {
			    Connection cn = null;
			    Statement st = null;
			    ResultSet rs = null;
			    
			    try {
			        // Establecer la conexión a la base de datos
			        cn = conexion.conectar();
			        st = cn.createStatement();
			        
			        // Consulta SQL para obtener la lista de clientes
			        String sql = "SELECT nombre, apellido FROM cliente";
			        
			        // Ejecutar la consulta
			        rs = st.executeQuery(sql);
			        
			        // Limpiar el JComboBox antes de cargar nuevos clientes
			        CB_cliente.removeAllItems();
			        
			        // Agregar un elemento por defecto
			        CB_cliente.addItem("Seleccione cliente:");
			        
			        // Iterar sobre los resultados de la consulta y agregar los clientes al JComboBox
			        while (rs.next()) {
			            String nombreCliente = rs.getString("nombre") + " " + rs.getString("apellido");
			            CB_cliente.addItem(nombreCliente);
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			    } finally {
			        // Cerrar recursos (ResultSet, Statement y Connection)
			        try {
			            if (rs != null) rs.close();
			            if (st != null) st.close();
			            if (cn != null) cn.close();
			        } catch (SQLException e) {
			            e.printStackTrace();
			        }
			    }
			}

	
	// Metodo para cargar los productos en el jCombo
	
	@SuppressWarnings("unchecked")
	private void CargarComboProductos() {
		
		Connection cn = conexion.conectar();
		String sql = "select * from producto";
		Statement st;
		
		
		try {
			st =  cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			CB_producto.removeAllItems();
			CB_producto.addItem("Seleccione Producto:");
			while(rs.next()) {
				CB_producto.addItem(rs.getString("nombre"));
				
			}
			cn.close();
			
		}catch(SQLException e){
			System.out.println("Error al cargar productos, !" + e);
			
		}
		
		
	}
	//Metdod para calcular el total a pagar de todos los productos
	private void CalcularTotalPagar() {
		subTotalGeneral = 0;
		descuentoGeneral = 0;
		itbisGeneral = 0;
		totalPagarGeneral = 0;
		
		
		for (DetalleVenta elemento : ListaProductos) {
			
			subTotalGeneral += elemento.getSubTotal();
			descuentoGeneral += elemento.getDescuento();
			itbisGeneral += elemento.getItbis();
			totalPagarGeneral += elemento.getTotalPagar();
	
		}
		
		//redondear decimales
		
		subTotalGeneral =  (double) Math.round(subTotalGeneral * 100) /100;
		itbisGeneral =  (double) Math.round(itbisGeneral * 100) /100;
		descuentoGeneral =  (double) Math.round(descuentoGeneral * 100) /100;
		totalPagarGeneral =  (double) Math.round(totalPagarGeneral * 100) /100;
		
		//enviar datos a la vista
		
		txt_subtotal.setText(String.valueOf(subTotalGeneral));
		txt_itbis.setText(String.valueOf(itbisGeneral));
		txt_descuento.setText(String.valueOf(descuentoGeneral));
		txt_totalPagar.setText(String.valueOf(totalPagarGeneral));
		
	}
	
	/*
    Metodo para obtener id del cliente
     */
    private void ObtenerIdCliente() {
        try {
            String sql = "select * from cliente where concat(nombre,' ',apellido) = '" + CB_cliente.getSelectedItem() + "'";
            Connection cn = conexion.conectar();
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idCliente = rs.getInt("idCliente");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener id del cliente, " + e);
        }
    }
    
  //metodo para restar la cantidad (stock) de los productos vendidos
    private void RestarStockProductos(int idProducto, int cantidad) {
        int cantidadProductosBaseDeDatos = 0;
        try {
            Connection cn = conexion.conectar();
            String sql = "select idProducto, cantidad from producto where idProducto = '" + idProducto + "'";
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cantidadProductosBaseDeDatos = rs.getInt("cantidad");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al restar cantidad 1, " + e);
        }
        try {
        	Connection cn = conexion.conectar ();
        	PreparedStatement consulta = cn.prepareStatement("update producto set cantidad=? where idProducto = '" + idProducto + "'");
            int catidadNueva = cantidadProductosBaseDeDatos - cantidad;
			consulta.setInt(1, catidadNueva);
			 if(consulta.executeUpdate() > 0){
				 
	            }
	            cn.close();
	        } catch (SQLException e) {
	            System.out.println("Error al restar cantidad 2, " + e);
	        }
    }
	  
}
