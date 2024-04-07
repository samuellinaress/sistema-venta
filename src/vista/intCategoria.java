package vista;
//Autor: Angel Naut;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controlador.Ctrl_Categoria;
import modelo.Categoria;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Categoria categoria = new Categoria();
				Ctrl_Categoria controlCategoria = new Ctrl_Categoria();

				// validamos campos vacios
				if (desCategoria.getText().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Completa todos los campos");

				} else {

					if (!controlCategoria.existeCategoria(desCategoria.getText().trim())) {
						categoria.setDescripcion(desCategoria.getText().trim());
						categoria.setEstado(1);

						if (controlCategoria.guardar(categoria)) {

							JOptionPane.showMessageDialog(null, "Resgistro Guardado");

						} else {

							JOptionPane.showMessageDialog(null, "Error al Guardar");

						}
					} else {
						JOptionPane.showMessageDialog(null, "La categoria ya esta guardada");
					}

				}

				// limpiar campo

				desCategoria.setText("");
			}
		});
		guardar.setFont(new Font("Tahoma", Font.BOLD, 14));
		guardar.setBounds(192, 102, 109, 30);
		getContentPane().add(guardar);

	}
}
