package Interfaz;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class AdministrarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modo;
	private JTextField textTelefono;
	private JTextField textApellido;
	private JTextField textNombre;
	private JTextField textDireccion;
	private JTextField textCedula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministrarCliente frame = new AdministrarCliente();
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
	public AdministrarCliente() {
		setTitle("Adiministrar Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 402);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 42, 765, 183);
		contentPane.add(panel);
		panel.setLayout(null);
		modo = new DefaultTableModel(
				new Object[][] {,},
				new String[] {"IdCliente","Nombre", "Apellido", "Cedula", "Telefono","Direccion"}
		);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 745, 162);
		panel.add(scrollPane);
		
		table = new JTable(new DefaultTableModel(
			new Object[][] {
				{"1", "Angel", "de la Rosa", "1234567890", "829", "Boca Chica"},
				{"2", "Pepe", "Tito", "098765", "829", "Santo Domingo"},
				{"3", "Juan", "Antonio", "257822", "829", "Santo Domingo"},
			},
			new String[] {
					"IdCliente","Nombre", "Apellido", "Cedula", "Telefono","Direccion"
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
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 785, 35);
		contentPane.add(panel_1);
		
		JLabel lblAdiministrarUsuario = new JLabel("Adiministrar Clientes");
		lblAdiministrarUsuario.setForeground(Color.WHITE);
		lblAdiministrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblAdiministrarUsuario);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 235, 765, 120);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNombres = new JLabel("Nombre:");
		lblNombres.setBackground(new Color(0, 0, 0));
		lblNombres.setBounds(20, 6, 81, 22);
		lblNombres.setForeground(new Color(0, 0, 0));
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblNombres);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(285, 6, 81, 22);
		lblApellido.setForeground(new Color(0, 0, 0));
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblApellido);
		
		JLabel lblUsuario = new JLabel("Dirección:");
		lblUsuario.setBounds(271, 38, 149, 22);
		lblUsuario.setForeground(new Color(0, 0, 0));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Cédula:");
		lblPassword.setBounds(546, 6, 81, 22);
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblPassword);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(14, 38, 87, 22);
		lblTelefono.setForeground(new Color(0, 0, 0));
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblTelefono);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(111, 38, 136, 25);
		textTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textTelefono.setColumns(10);
		panel_2.add(textTelefono);
		
		textApellido = new JTextField();
		textApellido.setBounds(376, 6, 136, 25);
		textApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textApellido.setColumns(10);
		panel_2.add(textApellido);
		
		textNombre = new JTextField();
		textNombre.setBounds(111, 10, 136, 25);
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNombre.setColumns(10);
		panel_2.add(textNombre);
		
		textDireccion = new JTextField();
		textDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textDireccion.setColumns(10);
		textDireccion.setBounds(376, 38, 136, 25);
		panel_2.add(textDireccion);
		
		textCedula = new JTextField();
		textCedula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCedula.setColumns(10);
		textCedula.setBounds(619, 6, 136, 25);
		panel_2.add(textCedula);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int filaSeleccionada = table.getSelectedRow();
			        if (filaSeleccionada >= 0) {
			            table.setValueAt(textNombre.getText(), filaSeleccionada, 1);
			            table.setValueAt(textTelefono.getText(), filaSeleccionada, 2);
			            table.setValueAt(textDireccion.getText(), filaSeleccionada, 3);
			            table.setValueAt(textApellido.getText(), filaSeleccionada, 4);
			            table.setValueAt(textCedula.getText(), filaSeleccionada, 5);
			}
			}
		});
		btnActualizar.setForeground(new Color(255, 255, 255));
		btnActualizar.setBackground(new Color(0, 64, 128));
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnActualizar.setBounds(20, 78, 112, 21);
		panel_2.add(btnActualizar);
		
		JButton btnEliminar = new JButton("Eliminar");
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
		btnEliminar.setBounds(142, 78, 112, 21);
		panel_2.add(btnEliminar);
	}
	//cargar datos seleccionados
	
	public void cargarDatosSelec(int filaSeleccionada) {
	        textNombre.setText((String) table.getValueAt(filaSeleccionada, 1));
	        textApellido.setText((String) table.getValueAt(filaSeleccionada, 2));
	        textCedula.setText((String) table.getValueAt(filaSeleccionada, 3));
	        textTelefono.setText((String) table.getValueAt(filaSeleccionada, 4));
	        textDireccion.setText((String) table.getValueAt(filaSeleccionada, 5));
	       
	        
	    
		
	}
}
