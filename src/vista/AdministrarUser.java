package vista;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import conexion.conexion;
import controlador.Ctrl_Usuario;

import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* @author Angel Miguel de la Rosa
*/
public class AdministrarUser extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel modo;
	private JTextField textApellido;
	private JTextField textPass;
	private JTextField textNombre;
	private JTextField textUser;
	private JTextField textTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministrarUser frame = new AdministrarUser();
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
	public AdministrarUser() {
	    setClosable(true);
		setIconifiable(true);
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 745, 162);
		panel.add(scrollPane);
		
		modo = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IdUsuario", "Nombre", "Apellido", "Usuario", "Password", "Telefono"
			}
		);
		table = new JTable(modo);
		
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
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
		
		JLabel lblAdiministrarUsuario = new JLabel("Adiministrar Usuario");
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
		lblApellido.setBounds(20, 38, 81, 22);
		lblApellido.setForeground(new Color(0, 0, 0));
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblApellido);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(292, 38, 78, 22);
		lblUsuario.setForeground(new Color(0, 0, 0));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(275, 6, 95, 22);
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblPassword);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(526, 6, 87, 22);
		lblTelefono.setForeground(new Color(0, 0, 0));
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblTelefono);
		
		textApellido = new JTextField();
		textApellido.setBounds(111, 38, 136, 25);
		textApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textApellido.setColumns(10);
		panel_2.add(textApellido);
		
		textPass = new JTextField();
		textPass.setBounds(380, 6, 136, 25);
		textPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPass.setColumns(10);
		panel_2.add(textPass);
		
		textNombre = new JTextField();
		textNombre.setBounds(111, 10, 136, 25);
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNombre.setColumns(10);
		panel_2.add(textNombre);
		
		textUser = new JTextField();
		textUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textUser.setColumns(10);
		textUser.setBounds(380, 38, 136, 25);
		panel_2.add(textUser);
		
		textTelefono = new JTextField();
		textTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textTelefono.setColumns(10);
		textTelefono.setBounds(619, 6, 136, 25);
		panel_2.add(textTelefono);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ctrl_Usuario ctrl_Usuario =new Ctrl_Usuario();
				ctrl_Usuario.actualizar(table, textNombre, textApellido, textUser, textPass, textTelefono);;
			limpiarTabla(modo);
			cargarDatosUsuario();
			limpiar();	 
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
				Ctrl_Usuario ctrl_Usuario =new Ctrl_Usuario();
				ctrl_Usuario.eliminar(table);
				limpiarTabla(modo);
				cargarDatosUsuario();
				limpiar();	   
						
			}
		});
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminar.setBackground(new Color(255, 0, 0));
		btnEliminar.setBounds(142, 78, 112, 21);
		panel_2.add(btnEliminar);
        
		cargarDatosUsuario();
	}
	/*
	 * **************************************
	 * Metodo para cargar datos de usuarios *
	 ****************************************
	 */
	
	public void cargarDatosUsuario() {
		try {
		Connection con = conexion.conectar();
		java.sql.Statement st = con.createStatement();
		
		ResultSet rSet = st.executeQuery("select idUsuario, nombre, apellido, usuario, password, telefono,estado from usuario");
		
		while (rSet.next()) {
			
			modo.addRow(new Object [] {rSet.getInt("idUsuario"),rSet.getString("nombre"),rSet.getString("apellido"),rSet.getString("usuario"),rSet.getString("password"),rSet.getString("telefono"),rSet.getString("estado")});
			
			
			
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
	
		public void cargarDatosSelec(int filaSeleccionada) {
		        textNombre.setText((String) table.getValueAt(filaSeleccionada, 1));
		        textApellido.setText((String) table.getValueAt(filaSeleccionada, 2));
		        textUser.setText((String) table.getValueAt(filaSeleccionada, 3));
		        textPass.setText((String) table.getValueAt(filaSeleccionada, 4));
		        textTelefono.setText((String) table.getValueAt(filaSeleccionada, 5));
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
		 **********************
		 * Metodo para limpiar *
		 ***********************
		 */ 
		public void limpiar() {
			textNombre.setText("");
			textApellido.setText("");
			textUser.setText("");
			textPass.setText("");
			textTelefono.setText("");
		}
		
	}
		
	

