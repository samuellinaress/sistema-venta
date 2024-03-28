package Interfaz;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class AdministrarProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modo;
	private JTextField textCantidad;
	private JTextField textPrecio;
	private JTextField textNombre;
	private JTextField textDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministrarProducto frame = new AdministrarProducto();
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
	public AdministrarProducto() {
		setTitle("Adiministrar Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 409);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 42, 863, 183);
		contentPane.add(panel);
		panel.setLayout(null);
		modo = new DefaultTableModel(
				new Object[][] {,},
				new String[] {"N'","Nombre", "Cantidad", "Precio", "Descripcion","ITBS","Categorias"}
		);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 843, 162);
		panel.add(scrollPane);
		
		table = new JTable(new DefaultTableModel(
			new Object[][] {
				{"1", "Coca Cola", "4", "25", "1 litro", "0.0","Bebida"},
				{"2", "TV TCL", "1", "50000", "49 pulgadas", "18%", "Electrodoméstico"},
				{"3", "Polo", "3", "500", "Negros", "0.0", "Ropa"},
			},
			new String[] {
					"N'","Nombre", "Cantidad", "Precio", "Descripcion","ITBS","Categorias"
			}
		));
		scrollPane.setViewportView(table);
		// Agregar listener para capturar la selección de la tabla
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = table.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    cargarDatosSelec(filaSeleccionada);
                }
            }
        });
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 873, 35);
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setForeground(new Color(0, 0, 0));
		contentPane.add(panel_1);
		
		JLabel lblAdiministrarUsuario = new JLabel("Adiministrar Productos");
		lblAdiministrarUsuario.setForeground(Color.WHITE);
		lblAdiministrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblAdiministrarUsuario);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 235, 863, 120);
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
		lblUsuario.setBounds(267, 38, 121, 22);
		lblUsuario.setForeground(new Color(0, 0, 0));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblUsuario);
		
		JLabel lblTelefono = new JLabel("Cantidad:");
		lblTelefono.setBounds(14, 38, 106, 22);
		lblTelefono.setForeground(new Color(0, 0, 0));
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblTelefono);
		
		textCantidad = new JTextField();
		textCantidad.setEditable(false);
		textCantidad.setEnabled(false);
		textCantidad.setBounds(111, 38, 136, 25);
		textCantidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCantidad.setColumns(10);
		panel_2.add(textCantidad);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(394, 6, 136, 25);
		textPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPrecio.setColumns(10);
		panel_2.add(textPrecio);
		
		textNombre = new JTextField();
		textNombre.setBounds(111, 10, 136, 25);
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNombre.setColumns(10);
		panel_2.add(textNombre);
		
		textDescripcion = new JTextField();
		textDescripcion.setBounds(394, 38, 136, 25);
		textDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textDescripcion.setColumns(10);
		panel_2.add(textDescripcion);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(14, 78, 112, 21);
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int filaSeleccionada = table.getSelectedRow();
			        if (filaSeleccionada >= 0) {
			            table.setValueAt(textNombre.getText(), filaSeleccionada, 1);
			            table.setValueAt(textCantidad.getText(), filaSeleccionada, 2);
			            table.setValueAt(textDescripcion.getText(), filaSeleccionada, 3);
			            table.setValueAt(textPrecio.getText(), filaSeleccionada, 4);
			           
			}
			}
		});
		btnActualizar.setForeground(new Color(255, 255, 255));
		btnActualizar.setBackground(new Color(0, 64, 128));
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(btnActualizar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(136, 78, 112, 21);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			       int filaSeleccionada = table.getSelectedRow();
					  if (filaSeleccionada >= 0) {
						  DefaultTableModel modelo = (DefaultTableModel) table.getModel();
						  modelo.removeRow(filaSeleccionada);
						  } else {
						  // en caso de no selecionar una fila para eliminar
						  JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
						  }
					
			}
		});
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminar.setBackground(new Color(255, 0, 0));
		panel_2.add(btnEliminar);
		
		JLabel lblItbis = new JLabel("ITBIS:");
		lblItbis.setForeground(new Color(0, 0, 0));
		lblItbis.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblItbis.setBounds(602, -5, 60, 44);
		panel_2.add(lblItbis);
		
		JComboBox comboBoxItbis = new JComboBox();
		comboBoxItbis.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxItbis.setModel(new DefaultComboBoxModel(new String[] {"Seleccione ITBIS:", "No paga ITBIS", "18%"}));
		comboBoxItbis.setBounds(667, 8, 181, 28);
		panel_2.add(comboBoxItbis);
		
		JLabel lblCategorias = new JLabel("Categorias:");
		lblCategorias.setForeground(new Color(0, 0, 0));
		lblCategorias.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCategorias.setBounds(556, 27, 106, 44);
		panel_2.add(lblCategorias);
		
		JComboBox comboBoxCateg = new JComboBox();
		comboBoxCateg.setModel(new DefaultComboBoxModel(new String[] {"Selecciona categoría:", "Bebida", "Electrodoméstico", "Ropa", "Comida"}));
		comboBoxCateg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxCateg.setBounds(667, 40, 181, 28);
		panel_2.add(comboBoxCateg);
	}
	//cargar datos seleccionados
	
	public void cargarDatosSelec(int filaSeleccionada) {
	        textNombre.setText((String) table.getValueAt(filaSeleccionada, 1));
	        textCantidad.setText((String) table.getValueAt(filaSeleccionada, 2));
	        textPrecio.setText((String) table.getValueAt(filaSeleccionada, 3));
	        textDescripcion.setText((String) table.getValueAt(filaSeleccionada, 4));
	       
	        
	    
		
	}
}
