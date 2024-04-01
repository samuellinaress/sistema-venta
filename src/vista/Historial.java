package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class Historial extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFecha;
	private JTable table;
	private DefaultTableModel modelo;
	int contador=0;
	private JComboBox comboBox_1;
        
        
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Historial frame = new Historial();
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
	public Historial() {
		super("Historial", false, true, false, true);
		setDefaultCloseOperation(Historial.DISPOSE_ON_CLOSE);
		setBounds(120, 170, 806, 360);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Buscar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 770, 63);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textFecha = new JTextField();
		textFecha.setColumns(10);
		textFecha.setBounds(365, 17, 145, 29);
		panel.add(textFecha);
		
		comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Selecciona categoría:", "Bebida", "Electrodoméstico", "Ropa", "Comida"}));
		comboBox_1.setBounds(101, 16, 160, 26);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("Categoria:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 10, 96, 38);
		panel.add(lblNewLabel_1);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     String fechaBuscada = textFecha.getText();
			     
			        if (!fechaBuscada.isEmpty()) {
			            DefaultTableModel modeloTabla = (DefaultTableModel) table.getModel();
			            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modeloTabla);
			            table.setRowSorter(sorter);
			            RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter(fechaBuscada, 5); 
			            sorter.setRowFilter(rowFilter);
			        } else {
			           
			            table.setRowSorter(null);
			        }
			        
			}
		});
		btnBuscar.setBounds(531, 18, 152, 26);
		panel.add(btnBuscar);
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(299, 10, 69, 38);
		panel.add(lblNewLabel_1_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 83, 770, 230);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "Angel", "Ropa", "Polo", "2", "2-2-2024", "500$"},
				{"2", "Miguel", "Bebida", "Coca Cola", "40", "2-2-2024", "5000$"},
				{"3", "Juan", "Ropa", "Pantal\u00F3n", "1", "2-2-2024", "100$"},
				{"4", "Angel", "Bebida", "Agua", "5", "5-3-2024", "80$"},
				{"5", "Juan", "Comida", "Pollo", "1", "10-3-2024", "100$"},
			},
			new String[] {
				"N'", "Nombre", "Categoria", "Producto", "Cantidad", "Fecha", "Total de pago"
			}
		));
		scrollPane.setViewportView(table);
	
		
	}
	}
