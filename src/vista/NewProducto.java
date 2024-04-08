package vista;
import java.awt.EventQueue;



import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Ctrl_Producto;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JSpinner;
import javax.swing.UIManager;
import javax.swing.SpinnerNumberModel;

public class NewProducto extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textDescripcion;
	private Ctrl_Producto producto = new Ctrl_Producto(); 
	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NewProducto frame = new NewProducto();
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
	public NewProducto() {
		//setTitle("Nuevo Producto");
                super("Nuevo Producto",false,true,false,true);
		setDefaultCloseOperation(NewProducto.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 548, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(0, 0, 593, 395);
		contentPane.add(panel);
		
		JLabel lblNuevoProducto = new JLabel("Nuevo Producto");
		lblNuevoProducto.setForeground(Color.WHITE);
		lblNuevoProducto.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNuevoProducto.setBounds(179, 10, 161, 44);
		panel.add(lblNuevoProducto);
		
		JLabel lblNombres = new JLabel("Nombre:");
		lblNombres.setForeground(Color.WHITE);
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNombres.setBounds(69, 66, 88, 44);
		panel.add(lblNombres);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCantidad.setBounds(60, 112, 97, 44);
		panel.add(lblCantidad);
		
		JLabel lblItbis = new JLabel("ITBIS:");
		lblItbis.setForeground(Color.WHITE);
		lblItbis.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblItbis.setBounds(88, 241, 69, 44);
		panel.add(lblItbis);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPrecio.setBounds(79, 158, 78, 44);
		panel.add(lblPrecio);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNombre.setColumns(10);
		textNombre.setBounds(167, 78, 190, 28);
		panel.add(textNombre);
		
		textDescripcion = new JTextField();
		textDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(167, 208, 190, 28);
		panel.add(textDescripcion);
		JLabel lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setForeground(Color.WHITE);
		lblDescripcin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDescripcin.setBounds(30, 198, 127, 44);
		panel.add(lblDescripcin);
		
		JComboBox comboBoxItbis = new JComboBox();
		comboBoxItbis.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxItbis.setModel(new DefaultComboBoxModel(new String[] {"Seleccione ITBIS:", "No paga ITBIS", "18%"}));
		comboBoxItbis.setBounds(167, 249, 190, 28);
		panel.add(comboBoxItbis);
		
		JLabel lblCategorias = new JLabel("Categorias:");
		lblCategorias.setForeground(Color.WHITE);
		lblCategorias.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCategorias.setBounds(45, 278, 106, 44);
		panel.add(lblCategorias);
		
		JComboBox comboBoxCateg = new JComboBox();
		comboBoxCateg.setModel(new DefaultComboBoxModel(new String[] {"Selecciona categoria:"}));
		comboBoxCateg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxCateg.setBounds(167, 287, 190, 28);
		panel.add(comboBoxCateg);
		
		JSpinner cantidad = new JSpinner();
		cantidad.setModel(new SpinnerNumberModel(0, null, 200, 1));
		
		cantidad.setBackground(new Color(255, 255, 255));
		
		cantidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cantidad.setBounds(167, 122, 190, 28);
		panel.add(cantidad);
		
		JSpinner precio = new JSpinner();
		precio.setModel(new SpinnerNumberModel(0, null, 2147483647, 1));
		precio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		precio.setBounds(167, 170, 190, 28);
		panel.add(precio);;
		
		JLabel X1 = new JLabel("X");
		X1.setForeground(new Color(64, 128, 128));
		X1.setBackground(new Color(240, 240, 240));
		X1.setFont(new Font("Tahoma", Font.BOLD, 17));
		X1.setBounds(364, 85, 45, 13);
		panel.add(X1);
		
		JLabel X2 = new JLabel("X");
		X2.setForeground(new Color(64, 128, 128));
		X2.setFont(new Font("Tahoma", Font.BOLD, 17));
		X2.setBackground(UIManager.getColor("Button.background"));
		X2.setBounds(367, 131, 45, 13);
		panel.add(X2);
		
		JLabel X3 = new JLabel("X");
		X3.setForeground(new Color(64, 128, 128));
		X3.setFont(new Font("Tahoma", Font.BOLD, 17));
		X3.setBackground(UIManager.getColor("Button.background"));
		X3.setBounds(364, 177, 45, 13);
		panel.add(X3);
		
		JLabel X4 = new JLabel("X");
		X4.setForeground(new Color(64, 128, 128));
		X4.setFont(new Font("Tahoma", Font.BOLD, 17));
		X4.setBackground(UIManager.getColor("Button.background"));
		X4.setBounds(367, 217, 45, 13);
		panel.add(X4);
		
		JLabel X5 = new JLabel("X");
		X5.setForeground(new Color(64, 128, 128));
		X5.setFont(new Font("Tahoma", Font.BOLD, 17));
		X5.setBackground(UIManager.getColor("Button.background"));
		X5.setBounds(364, 260, 45, 13);
		panel.add(X5);
		
		JLabel X6 = new JLabel("X");
		X6.setForeground(new Color(64, 128, 128));
		X6.setFont(new Font("Tahoma", Font.BOLD, 17));
		X6.setBackground(UIManager.getColor("Button.background"));
		X6.setBounds(364, 297, 45, 13);
		panel.add(X6);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				producto.guardar(textNombre, cantidad, precio, textDescripcion, comboBoxItbis, comboBoxCateg,X1,X2,X3,X4, X5, X6);
			
		}
		});
		btnGuardar.setToolTipText("");
		btnGuardar.setForeground(Color.BLACK);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGuardar.setBackground(new Color(0, 255, 64));
		btnGuardar.setBounds(204, 341, 133, 33);
		panel.add(btnGuardar);
		
	
		producto.cargarComboCategoria(comboBoxCateg);
		
	}
}
