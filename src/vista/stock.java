package vista;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexion.conexion;
import controlador.Ctrl_Producto;
import modelo.Producto;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.SwingConstants;

public class stock extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField CantidadActual;
	private JLabel X2,X1;
	private JSpinner spinner;
	private JComboBox Productos;
	 int idProducto = 0;
	 int cantidad = 0;
		Ctrl_Producto producto = new Ctrl_Producto();

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					stock frame = new stock();
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
	public stock() {
		//setTitle("Actualizar Stock de Productos");
                super("Actualizar Inventario",false,true,false,true);
		setDefaultCloseOperation(stock.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(0, 0, 449, 275);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblActualizarStockDe = new JLabel("Actualizar Stock de Productos");
		lblActualizarStockDe.setForeground(Color.WHITE);
		lblActualizarStockDe.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblActualizarStockDe.setBounds(67, 10, 308, 44);
		panel.add(lblActualizarStockDe);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setForeground(Color.WHITE);
		lblProducto.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProducto.setBounds(67, 64, 90, 44);
		panel.add(lblProducto);
		
		JLabel lblStockActual = new JLabel("Stock Actual:");
		lblStockActual.setForeground(Color.WHITE);
		lblStockActual.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStockActual.setBounds(34, 112, 123, 44);
		panel.add(lblStockActual);
		
		JLabel lblStockNuevo = new JLabel("Stock Nuevo:");
		lblStockNuevo.setForeground(Color.WHITE);
		lblStockNuevo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStockNuevo.setBounds(34, 158, 123, 44);
		panel.add(lblStockNuevo);
		
		CantidadActual = new JTextField();
		CantidadActual.setHorizontalAlignment(SwingConstants.RIGHT);
		CantidadActual.setText("0");
		CantidadActual.setEnabled(false);
		CantidadActual.setEditable(false);
		CantidadActual.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CantidadActual.setColumns(10);
		CantidadActual.setBounds(167, 122, 190, 28);
		panel.add(CantidadActual);
		
		Productos = new JComboBox();
		Productos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarStock();
			}
		});
		Productos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Productos.setModel(new DefaultComboBoxModel(new String[] {"Seleccione producto:"}));
		Productos.setBounds(167, 73, 190, 29);
		panel.add(Productos);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cantidadSeleccionada = (int) spinner.getValue();
			    
				 //validamos seleccion del producto
				if(!Productos.getSelectedItem().equals("Seleccione producto:")) {
					X1.setForeground(new Color(64, 128, 128)); 
					
			 //validamos si se ingreso un numero positivo
				if (cantidadSeleccionada <0) {
			         X2.setForeground(Color.red);
			        JOptionPane.showMessageDialog(null, "La cantidad debe ser un numero positivo o igual qué cero");
			       return; 
			    }X2.setForeground(new Color(64, 128, 128)); 
				  
				}else {
					 X1.setForeground(Color.red);
					   JOptionPane.showMessageDialog(null, "Seleccione producto");
				} 
				
				int stockNuevo = (int) spinner.getValue();
				Producto ProductoS = new Producto();
				ProductoS.setCantidad(stockNuevo);
				
                if (producto.actualizarStock(ProductoS, idProducto)) {
                    JOptionPane.showMessageDialog(null, "Stock Actualizado");
                    Productos.setSelectedItem("Seleccione producto:");
                   CantidadActual.setText("");
                    spinner.setModel(new SpinnerNumberModel(Integer.valueOf(0), null, null, Integer.valueOf(0)));
                   
                    producto.cargarComboProducto(Productos);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Actualizar Stock");
                }
				
				
			}
		});
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnActualizar.setBackground(new Color(0, 64, 128));
		btnActualizar.setBounds(195, 206, 123, 29);
		panel.add(btnActualizar);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, null, 10000, 1));
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner.setBounds(167, 166, 190, 28);
		panel.add(spinner);
		
	
		producto.cargarComboProducto(Productos);
		
		X2 = new JLabel("X");
		X2.setForeground(new Color(64, 128, 128));
		X2.setBackground(new Color(64, 128, 128));
		X2.setFont(new Font("Tahoma", Font.BOLD, 18));
		X2.setBounds(367, 174, 45, 13);
		panel.add(X2);
		
		X1 = new JLabel("X");
		X1.setForeground(new Color(64, 128, 128));
		X1.setFont(new Font("Tahoma", Font.BOLD, 18));
		X1.setBackground(new Color(64, 128, 128));
		X1.setBounds(367, 83, 45, 13);
		panel.add(X1);
		
		
	}

	  //metodo para mostrar stock del producto seleccionado
    private void MostrarStock() {
        try {

            Connection cn = conexion.conectar();
            String sql = "select * from producto where nombre = '" + Productos.getSelectedItem()+ "'";
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                idProducto = rs.getInt("idProducto");
                cantidad = rs.getInt("cantidad");
                CantidadActual.setText(String.valueOf(cantidad));
            } else {
                CantidadActual.setText("");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener stock del producto en: " + e);
        }
    }
}
