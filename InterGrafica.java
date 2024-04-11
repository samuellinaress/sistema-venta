package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import conexion.conexion;

public class InterGrafica extends JInternalFrame {
    private ArrayList<Integer> listadecantidad = new ArrayList<>();
    private ArrayList<String> listafechas = new ArrayList<>();
    private int cantidadResultados = 0;
    private static final long serialVersionUID = 1L;

    public InterGrafica(String fechainicioString, String fechafinalString) {
        setTitle("Historial de ventas");
        setSize(new Dimension(650, 550));
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Gráficas de resultados");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel.setBounds(186, 0, 211, 42);
        getContentPane().add(lblNewLabel);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        consultarBaseDeDatos(g);
    }

    private void consultarBaseDeDatos(Graphics g) {
        try {
            Connection cn = conexion.conectar();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaInicioFormateada = sdf.format(new Date());
            String fechaFinalFormateada = sdf.format(new Date());
            
            PreparedStatement pst = cn.prepareStatement("SELECT fechaVenta, COUNT(fechaVenta) as ventas FROM cabecera_venta "
                    + "WHERE fechaVenta BETWEEN ? AND ? GROUP BY fechaVenta");
            pst.setString(1, fechaInicioFormateada);
            pst.setString(2, fechaFinalFormateada);
            ResultSet resul = pst.executeQuery();
            int contador = 0;
            while (resul.next()) {
                cantidadResultados++;
                String fechaVenta = resul.getString("fechaVenta");
                int ventas = resul.getInt("ventas");
                listafechas.add(fechaVenta);
                listadecantidad.add(ventas);
                contador++;
            }
            
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error en " + e);
        }
        
        dibujarGrafica(g);   
    }

    private void dibujarGrafica(Graphics g) {
        int mayorVenta = Metodomayorventa(listadecantidad);
        int largo_nuevoingreso = 0;
        int Parametro1 = 133;
        int ParametroFecha = 118;
        int Parametro3 = 100;
        for (int i = 0; i < listadecantidad.size(); i++) {
            largo_nuevoingreso = listadecantidad.get(i) * 400 / mayorVenta;
            Color color = obtenerColor(i);
            g.setColor(color);
            g.fillRect(100, Parametro3, largo_nuevoingreso, 40);
            g.drawString(listafechas.get(i), 10, ParametroFecha);
            g.drawString("Cantidad: " + listadecantidad.get(i), 10, Parametro1);
            Parametro1 += 50;
            ParametroFecha += 50;
            Parametro3 += 50;
        }
    }

    private int Metodomayorventa(ArrayList<Integer> listadecantidad) {
        int mayor = 0;
        for (int i = 0; i < listadecantidad.size(); i++) {
            if (listadecantidad.get(i) > mayor) {
                mayor = listadecantidad.get(i);
            }
        }
        return mayor;
    }

    private Color obtenerColor(int i) {
        Color[] colores = { new Color(255, 87, 51), new Color(51, 221, 255), new Color(255, 51, 142),
                new Color(190, 51, 255), new Color(255, 51, 174), new Color(51, 91, 255), new Color(51, 255, 133) };
        return colores[i % colores.length];
    }
}
