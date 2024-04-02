package vista;
import controlador.Ctrl_Cliente;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import modelo.Cliente;

public class NewCliente extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textCedula;
	private JTextField textDireccion;
	private JTextField textTelefono;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NewCliente frame = new NewCliente();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public NewCliente() {
		//setTitle("Nuevo Cliente");
                super("Nuevo Cliente",false,true,false,true);
		setDefaultCloseOperation(NewCliente.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 526, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(0, 0, 593, 395);
		contentPane.add(panel);
		
		JLabel lblNuevoCliente = new JLabel("Nuevo Cliente");
		lblNuevoCliente.setForeground(Color.WHITE);
		lblNuevoCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNuevoCliente.setBounds(179, 10, 161, 44);
		panel.add(lblNuevoCliente);
		
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
		
		JLabel lblUbicacin = new JLabel("Dirección:");
		lblUbicacin.setForeground(Color.WHITE);
		lblUbicacin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUbicacin.setBounds(60, 241, 97, 44);
		panel.add(lblUbicacin);
		
		JLabel lblCdula = new JLabel("Cédula:");
		lblCdula.setForeground(Color.WHITE);
		lblCdula.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCdula.setBounds(79, 158, 78, 44);
		panel.add(lblCdula);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNombre.setColumns(10);
		textNombre.setBounds(167, 78, 190, 28);
		panel.add(textNombre);
		
		textApellido = new JTextField();
		textApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textApellido.setColumns(10);
		textApellido.setBounds(167, 124, 190, 28);
		panel.add(textApellido);
		
		textCedula = new JTextField();
		textCedula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCedula.setColumns(10);
		textCedula.setBounds(167, 168, 190, 28);
		panel.add(textCedula);
		
		textDireccion = new JTextField();
		textDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textDireccion.setColumns(10);
		textDireccion.setBounds(167, 251, 190, 28);
		panel.add(textDireccion);
		
		textTelefono = new JTextField();
		textTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textTelefono.setColumns(10);
		textTelefono.setBounds(167, 208, 190, 28);
		panel.add(textTelefono);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textNombre.getText().isEmpty()|| textApellido.getText().isEmpty()|| textTelefono.getText().isEmpty()||
						textCedula.getText().isEmpty()|| textDireccion.getText().isEmpty()){
					
					JOptionPane.showMessageDialog(null, "Complete todos los campos");
					
				}else {
                                    Ctrl_Cliente controlCliente = new Ctrl_Cliente();
                                    
                                        if(!controlCliente.clienteExistente(textCedula)){
                                            
                                            Cliente nuevoCliente = new Cliente();
                                            nuevoCliente.setNombre(textNombre.getText().trim());
                                            nuevoCliente.setApellido(textApellido.getText().trim());
                                            nuevoCliente.setCedula(textCedula.getText().trim());
                                            nuevoCliente.setTelefono(textTelefono.getText().trim());
                                            nuevoCliente.setDireccion(textDireccion.getText().trim());
                                            nuevoCliente.setEstado(1);
                                        
                                            if(controlCliente.agregarCliente(nuevoCliente)){
                                            
                                                JOptionPane.showMessageDialog(null, "Usuario guardado");
                                                textNombre.setText("");
                                                textApellido.setText("");
                                                textTelefono.setText("");
                                                textCedula.setText("");
                                                textDireccion.setText("");
                                            }
					
                                        }else{
                                            
                                            JOptionPane.showMessageDialog(null, "Este cliente ya existe");
                                        }
                                  
				}
				
			}
		});
		btnGuardar.setToolTipText("");
		btnGuardar.setForeground(Color.BLACK);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGuardar.setBackground(new Color(0, 255, 64));
		btnGuardar.setBounds(179, 311, 133, 33);
		panel.add(btnGuardar);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setForeground(Color.WHITE);
		lblTelfono.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTelfono.setBounds(69, 198, 88, 44);
		panel.add(lblTelfono);
	}

}
