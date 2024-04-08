package vista;
//Autor: Angel Naut
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import conexion.conexion;
import controlador.Ctrl_Categoria;
import modelo.Categoria;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class GestionarCategoria extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	public static JTable table;
	private JTextField descripcion;
	private int idCategoria;
	public static JScrollPane scrollPane;

	
	public GestionarCategoria() {
		
		
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Administrar categoria");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(187, 10, 202, 36);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 64, 353, 267);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 333, 247);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		//metodo para poner las categorias en la tabla
		cargarTablaCategorias();
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(399, 85, 143, 90);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton actualizar = new JButton("Actualizar");
		actualizar.setFont(new Font("Tahoma", Font.BOLD, 14));
		actualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!descripcion.getText().isEmpty()) {
					Categoria categoria = new Categoria();
					Ctrl_Categoria controlCategoria = new Ctrl_Categoria();
					
					categoria.setDescripcion(descripcion.getText().trim());
					
					if(controlCategoria.actualizar(categoria, idCategoria)) {
						JOptionPane.showMessageDialog(null, "Categoria Actualizada");
						descripcion.setText("");
						cargarTablaCategorias();
						
					}else {
						JOptionPane.showMessageDialog(null, "error al actualizar Categoria");
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "seleccione una categoria");
				}
			}
		});
		actualizar.setBounds(10, 14, 123, 21);
		panel_1.add(actualizar);
		
		JButton eliminar = new JButton("Eliminar");
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!descripcion.getText().isEmpty()) {
					Categoria categoria = new Categoria();
					Ctrl_Categoria controlCategoria = new Ctrl_Categoria();
					
					categoria.setDescripcion(descripcion.getText().trim());
					
					if(!controlCategoria.eliminar(idCategoria)) {
						JOptionPane.showMessageDialog(null, "Categoria eliminada");
						descripcion.setText("");
						cargarTablaCategorias();
						
					}else {
						JOptionPane.showMessageDialog(null, "error al eliminar una Categoria");
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "seleccione una categoria");
				}
			}
		});
		eliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
		eliminar.setBounds(10, 59, 123, 21);
		panel_1.add(eliminar);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1_1.setBounds(373, 208, 205, 78);
		getContentPane().add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 10, 99, 24);
		panel_1_1.add(lblNewLabel_1);
		
		descripcion = new JTextField();
		descripcion.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		descripcion.setBounds(10, 49, 185, 19);
		panel_1_1.add(descripcion);
		descripcion.setColumns(10);

	}
	
	// metodo para mostrar todas las categorias registradas
	
	private void cargarTablaCategorias() {
		Connection con = conexion.conectar();
		DefaultTableModel model = new DefaultTableModel();
		String sql = "select idCategoria, descripcion, estado from categoria";
		Statement st;
		
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			GestionarCategoria.table = new JTable(model);
			GestionarCategoria.scrollPane.setViewportView(GestionarCategoria.table);
			
			model.addColumn("idCategoria");
			model.addColumn("descripcion");
			model.addColumn("estado");
			
			while(rs.next()) {
				Object fila[] =  new Object[3];
				
				for (int i = 0; i < 3; i++) {
					fila[i] = rs.getObject(i+1);
					
					
				}
				model.addRow(fila);
				
				
			}
			
			con.close();
		}catch(SQLException e) {
			System.out.println("Error al llenar la Tabla categorias: " + e);
		}
		
		table.addMouseListener(new MouseAdapter(){
		@Override
		public void mouseClicked(MouseEvent e) {
			int fila_point = table.rowAtPoint(e.getPoint());
			int columna_point = 0;
			if(fila_point > -1) {
				idCategoria =  (int) model.getValueAt(fila_point, columna_point);
				EnviarDatosCategoriaSeleccionada(idCategoria);
			}
					
		}
		
	});
	}
	
	private void EnviarDatosCategoriaSeleccionada(int idCategoria) {
		try {
			
			Connection con = conexion.conectar();
			PreparedStatement pst = con.prepareStatement("select * from categoria where idCategoria = '" + idCategoria +"'");
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				
				descripcion.setText(rs.getString("descripcion"));
			}
			con.close();
			
		}catch(SQLException e) {
			
			System.out.println("Error al seleccionar categoria " + e);
		}
	}
}
