package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class intCategoria extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField desCategoria;

	
	public intCategoria() {
		super("Categoria", false, true, false, true);
		setBounds(100, 100, 400, 200);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nueva Categoria");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(117, 10, 160, 30);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion Categoria");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(22, 62, 160, 17);
		getContentPane().add(lblNewLabel_1);
		
		desCategoria = new JTextField();
		desCategoria.setBounds(192, 63, 186, 30);
		getContentPane().add(desCategoria);
		desCategoria.setColumns(10);
		
		JButton guardar = new JButton("Guardar");
		guardar.setFont(new Font("Tahoma", Font.BOLD, 14));
		guardar.setBounds(192, 102, 109, 30);
		getContentPane().add(guardar);

	}
}
