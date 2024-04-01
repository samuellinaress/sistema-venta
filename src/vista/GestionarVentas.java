package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

public class GestionarVentas extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modo;
	private JTextField textTelefono;
	private JTextField textNombre;
	
	public GestionarVentas() {
		super("Administrar Ventas", false, true, false, true);
		setDefaultCloseOperation(GestionarVentas.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 942, 402);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
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
				
			},
			new String[] {
					"IdCliente","Nombre", "Apellido", "Cedula", "Telefono","Direccion"
			}
		));
		scrollPane.setViewportView(table);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                }
            }
        );
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 920, 35);
		contentPane.add(panel_1);
		
		JLabel lblAdiministrarUsuario = new JLabel("Administrar Ventas");
		lblAdiministrarUsuario.setForeground(new Color(0, 0, 0));
		lblAdiministrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblAdiministrarUsuario);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 235, 910, 120);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNombres = new JLabel("Total Pagar:");
		lblNombres.setBackground(new Color(0, 0, 0));
		lblNombres.setBounds(20, 6, 120, 22);
		lblNombres.setForeground(new Color(0, 0, 0));
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblNombres);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(398, 6, 110, 22);
		lblApellido.setForeground(new Color(0, 0, 0));
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblApellido);
		
		JLabel lblUsuario = new JLabel("Dirección:");
		lblUsuario.setBounds(383, 38, 93, 22);
		lblUsuario.setForeground(new Color(0, 0, 0));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblUsuario);
		
		JLabel lblTelefono = new JLabel("Fecha:");
		lblTelefono.setBounds(69, 39, 61, 22);
		lblTelefono.setForeground(new Color(0, 0, 0));
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblTelefono);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(158, 38, 136, 25);
		textTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textTelefono.setColumns(10);
		panel_2.add(textTelefono);
		
		textNombre = new JTextField();
		textNombre.setBounds(158, 6, 136, 25);
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNombre.setColumns(10);
		panel_2.add(textNombre);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(486, 9, 158, 22);
		panel_2.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(486, 41, 158, 22);
		panel_2.add(comboBox_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(785, 42, 135, 183);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnActualizar_1 = new JButton("Actualizar");
		btnActualizar_1.setForeground(new Color(0, 0, 0));
		btnActualizar_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnActualizar_1.setBackground(Color.WHITE);
		btnActualizar_1.setBounds(10, 11, 112, 21);
		panel_3.add(btnActualizar_1);

	}
}
