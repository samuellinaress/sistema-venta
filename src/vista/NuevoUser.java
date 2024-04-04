package vista;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Ctrl_Usuario;
import modelo.Usuario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
*
* @author Angel Miguel de la Rosa
*/
public class NuevoUser extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textTelefono;
	private JTextField textUser;
	private JPasswordField textPassword;
	private JTextField Visible;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoUser frame = new NuevoUser();
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
	public NuevoUser() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Nuevo usuario");
		setBounds(100, 100, 496, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(0, 0, 593, 395);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nuevo Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(179, 10, 161, 44);
		panel.add(lblNewLabel);
		
		JLabel lblNombres = new JLabel("Nombre:");
		lblNombres.setForeground(Color.WHITE);
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNombres.setBounds(69, 66, 88, 44);
		panel.add(lblNombres);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblApellido.setBounds(69, 112, 88, 44);
		panel.add(lblApellido);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsuario.setBounds(79, 196, 78, 44);
		panel.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setBounds(62, 239, 95, 44);
		panel.add(lblPassword);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTelefono.setBounds(69, 156, 88, 44);
		panel.add(lblTelefono);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNombre.setBounds(167, 78, 190, 28);
		panel.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textApellido.setColumns(10);
		textApellido.setBounds(167, 124, 190, 28);
		panel.add(textApellido);
		
		textTelefono = new JTextField();
		textTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textTelefono.setColumns(10);
		textTelefono.setBounds(167, 168, 190, 28);
		panel.add(textTelefono);
		
		textUser = new JTextField();
		textUser.setFont(new Font("Tahoma", Font.PLAIN, 15));textPassword = new JPasswordField();
		textPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPassword.setBounds(167, 251, 190, 28);
		panel.add(textPassword);
		
		Visible = new JTextField();
		Visible.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Visible.setColumns(10);
		Visible.setBounds(167, 251, 190, 28);
		panel.add(Visible);
		
		textUser.setColumns(10);
		textUser.setBounds(167, 208, 190, 28);
		panel.add(textUser);
		
		JCheckBox JCheckBoxVer = new JCheckBox("");
		JCheckBoxVer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JCheckBoxVer.isSelected()==true) {
					String pass = "";
					
					char [] passIngresado = textPassword.getPassword();
					
					for (int i=0; i < passIngresado.length; i++  ) {
						pass += passIngresado[i];
						
					}
					
					Visible.setText(pass);
					textPassword.setVisible(false);
					Visible.setVisible(true);
					
				}else {
					
					String passIngresado = Visible.getText().trim();
					textPassword.setText(passIngresado);
					Visible.setVisible(false);
					textPassword.setVisible(true);
				}
			}
		});
		JCheckBoxVer.setHorizontalAlignment(SwingConstants.CENTER);
		JCheckBoxVer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JCheckBoxVer.setBackground(new Color(64, 128, 128));
		JCheckBoxVer.setBounds(363, 254, 21, 21);
		panel.add(JCheckBoxVer);
		
		//Boton Guardar
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ctrl_Usuario ctrl_Usuario = new Ctrl_Usuario();
				ctrl_Usuario.guardar(textNombre, textApellido, textUser, textPassword, textTelefono);
				limpiar();
			}	
		});
		btnGuardar.setToolTipText("");
		btnGuardar.setForeground(new Color(0, 0, 0));
		btnGuardar.setBackground(new Color(0, 255, 64));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGuardar.setBounds(179, 311, 133, 33);
		panel.add(btnGuardar);	
	}
	
	public void limpiar() {
		textNombre.setText("");
			textApellido.setText("");
			textTelefono.setText("");
			textUser.setText("");
			textPassword.setText("");
			Visible.setText("");
	}
			
			
			
		
	
}
