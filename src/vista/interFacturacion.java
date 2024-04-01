package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class interFacturacion extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	
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
		lblNewLabel_1_1_1.setBounds(291, 88, 69, 22);
		getContentPane().add(lblNewLabel_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(376, 91, 115, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(129, 59, 142, 22);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(129, 90, 142, 22);
		getContentPane().add(comboBox_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(281, 60, 200, 30);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(494, 57, 117, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnAadirProductos = new JButton("Añadir Productos");
		btnAadirProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAadirProductos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAadirProductos.setBounds(494, 91, 170, 23);
		getContentPane().add(btnAadirProductos);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 123, 742, 212);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 11, 722, 190);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(345, 346, 405, 287);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
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
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(127, 15, 142, 30);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(127, 52, 142, 30);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setBounds(127, 87, 142, 30);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setBounds(127, 125, 142, 30);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(127, 160, 142, 30);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setEnabled(false);
		textField_7.setBounds(127, 202, 142, 30);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Calcular Cambio");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(127, 233, 170, 44);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Registrar Venta");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(193, 396, 142, 102);
		getContentPane().add(btnNewButton_2);

	}
}
