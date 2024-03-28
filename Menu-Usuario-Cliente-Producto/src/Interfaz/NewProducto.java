package Interfaz;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class NewProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textCantidad;
	private JTextField textPrecio;
	private JTextField textDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewProducto frame = new NewProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewProducto() {
		setTitle("Nuevo Producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		lblItbis.setBounds(97, 241, 60, 44);
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
		
		textCantidad = new JTextField();
		textCantidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCantidad.setColumns(10);
		textCantidad.setBounds(167, 124, 190, 28);
		panel.add(textCantidad);
		
		textPrecio = new JTextField();
		textPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPrecio.setColumns(10);
		textPrecio.setBounds(167, 168, 190, 28);
		panel.add(textPrecio);
		
		textDescripcion = new JTextField();
		textDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(167, 208, 190, 28);
		panel.add(textDescripcion);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textNombre.getText().isEmpty()|| textCantidad.getText().isEmpty()|| textDescripcion.getText().isEmpty()||
						textPrecio.getText().isEmpty()){
					
					JOptionPane.showMessageDialog(null, "Complete todos los campos");
					
				}else {
				
					
					
					JOptionPane.showMessageDialog(null, "Usuario guardado");
					
					textNombre.setText("");
					textCantidad.setText("");
					textPrecio.setText("");
					textDescripcion.setText("");
					
				}
				
			
		}
		});
		btnGuardar.setToolTipText("");
		btnGuardar.setForeground(Color.BLACK);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGuardar.setBackground(new Color(0, 255, 64));
		btnGuardar.setBounds(204, 341, 133, 33);
		panel.add(btnGuardar);
		
		JLabel lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setForeground(Color.WHITE);
		lblDescripcin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDescripcin.setBounds(44, 198, 114, 44);
		panel.add(lblDescripcin);
		
		JComboBox comboBoxItbis = new JComboBox();
		comboBoxItbis.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxItbis.setModel(new DefaultComboBoxModel(new String[] {"Seleccione ITBIS:", "No paga ITBIS", "18%"}));
		comboBoxItbis.setBounds(167, 249, 190, 28);
		panel.add(comboBoxItbis);
		
		JLabel lblCategorias = new JLabel("Categorias:");
		lblCategorias.setForeground(Color.WHITE);
		lblCategorias.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCategorias.setBounds(51, 278, 106, 44);
		panel.add(lblCategorias);
		
		JComboBox comboBoxCateg = new JComboBox();
		comboBoxCateg.setModel(new DefaultComboBoxModel(new String[] {"Selecciona categoría:", "Bebida", "Electrodoméstico", "Ropa", "Comida"}));
		comboBoxCateg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxCateg.setBounds(167, 287, 190, 28);
		panel.add(comboBoxCateg);
	}
}
