package vista; //antes decia vista

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.Date;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

import java.awt.BorderLayout;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDateChooserBeanInfo;
import vista.InterGrafica;
import static vista.Menu.menu_interno;

public class Historial extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    int contador = 0;
    private JDateChooser dateChooser_inicio;
    private JDateChooser dateChooser_final;
    private JDesktopPane JDesktopPane_menu;
    public static String fechainicioString = "", fechafinalString = "";
   

    public Historial() {
        super("Historial", false, true, false, true);
        setDefaultCloseOperation(Historial.DISPOSE_ON_CLOSE);
        setBounds(120, 170, 456, 320);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(64, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JDesktopPane_menu = new JDesktopPane(); 
        contentPane.add(JDesktopPane_menu);
        
        
        
        JLabel lblNewLabel = new JLabel("Fecha inicial:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(66, 106, 117, 13);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Fecha final:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(66, 170, 90, 13);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Seleccione la Fecha");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setBackground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_2.setBounds(138, 20, 211, 42);
        contentPane.add(lblNewLabel_2);
        
        JButton btnNewButton = new JButton("Graficar Ventas");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        do_btnNewButton_actionPerformed(e);
                    }
                });
            }
        });

        btnNewButton.setBackground(new Color(192, 192, 192));
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton.setBounds(183, 239, 117, 42);
        contentPane.add(btnNewButton);
        
        
        dateChooser_inicio = new JDateChooser();
        dateChooser_inicio.setBounds(178, 106, 139, 24);
        contentPane.add(dateChooser_inicio);
        
        dateChooser_final = new JDateChooser();
        dateChooser_final.setBounds(178, 171, 139, 24);
        contentPane.add(dateChooser_final);
        
        
        
    }

    public void do_btnNewButton_actionPerformed(ActionEvent e) {
        fechainicioString = ((JTextField) dateChooser_inicio.getDateEditor().getUiComponent()).getText();
        fechafinalString = ((JTextField) dateChooser_final.getDateEditor().getUiComponent()).getText();

        InterGrafica interGraficaVentas = new InterGrafica(fechainicioString, fechafinalString);
        menu_interno.add(interGraficaVentas);
        interGraficaVentas.setVisible(true);
    }








}
