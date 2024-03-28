package Interfaz;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class stock extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stock frame = new stock();
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
	public stock() {
		setTitle("Actualizar Stock de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(167, 168, 190, 28);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setText("4");
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(167, 122, 190, 28);
		panel.add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccione producto:", "Coca Cola", "TV TCL", "Polo"}));
		comboBox.setBounds(167, 73, 190, 29);
		panel.add(comboBox);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnActualizar.setBackground(new Color(0, 64, 128));
		btnActualizar.setBounds(195, 206, 123, 29);
		panel.add(btnActualizar);
	}
}
