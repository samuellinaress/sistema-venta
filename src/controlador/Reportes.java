package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.conexion;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel Linares
 */
public class Reportes {
    
    //Metodo Reportes Clientes Registrados
    public void reporteClientes(){
        Document doc = new Document();
        
        try {
            
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(doc, new FileOutputStream(ruta + "/Desktop/Reporte_Clientes.pdf"));
            Image cabecera = Image.getInstance("src/img/header1.jpg");
            cabecera.scaleToFit(650,1000);
            cabecera.setAlignment(Chunk.ALIGN_CENTER);
            
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte: ");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Clientes \n\n");
            
            doc.open();
            //se agregan los datos
            doc.add(cabecera);
            doc.add(parrafo);
            
            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("Codigo");
            tabla.addCell("Nombres");
            tabla.addCell("Cedula");
            tabla.addCell("Telefono");
            tabla.addCell("Direccion");
            
            try {
                String sql = "select idcliente, concat(nombre,' ', apellido) as nombres, cedula, telefono, direccion from cliente;";
                Statement st = conexion.conectar().createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    tabla.addCell(rs.getString(1));
                    tabla.addCell(rs.getString(2));
                    tabla.addCell(rs.getString(3));
                    tabla.addCell(rs.getString(4));
                    tabla.addCell(rs.getString(5));
                }
                doc.add(tabla);
                
            } catch (SQLException e) {
                System.out.println("Error: " + e.toString());
            }
            doc.close();
            JOptionPane.showMessageDialog(null, "Reporte Creado");
            
        } catch (DocumentException e) {
            System.out.println("Error 1:" + e.toString());
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2:" + ex.toString());
        } catch (IOException ex) {
            System.out.println("Error 3:" + ex.toString());
        }
        
    }
    
    //Metodo Reportes Categorias Registrados
    public void reporteCategorias(){
        Document doc = new Document();
        
        try {
            
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(doc, new FileOutputStream(ruta + "/Desktop/Reporte_Categorias.pdf"));
            Image cabecera = Image.getInstance("src/img/header1.jpg");
            cabecera.scaleToFit(650,1000);
            cabecera.setAlignment(Chunk.ALIGN_CENTER);
            
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte: ");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Categorias \n\n");
            
            doc.open();
            //se agregan los datos
            doc.add(cabecera);
            doc.add(parrafo);
            
            PdfPTable tabla = new PdfPTable(3);
            tabla.addCell("Codigo");
            tabla.addCell("Descripcion");
            tabla.addCell("Estado");
            
            try {
                String sql = "select * from categoria;";
                Statement st = conexion.conectar().createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    tabla.addCell(rs.getString(1));
                    tabla.addCell(rs.getString(2));
                    tabla.addCell(rs.getString(3));

                }
                doc.add(tabla);
                
            } catch (SQLException e) {
                System.out.println("Error: " + e.toString());
            }
            doc.close();
            JOptionPane.showMessageDialog(null, "Reporte Creado");
            
        } catch (DocumentException e) {
            System.out.println("Error 1:" + e.toString());
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2:" + ex.toString());
        } catch (IOException ex) {
            System.out.println("Error 3:" + ex.toString());
        }
        
    }
    
    //Metodo Reportes Prodcutos Registrados
    public void reporteProductos(){
        Document doc = new Document();
        
        try {
            
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(doc, new FileOutputStream(ruta + "/Desktop/Reporte_Productos.pdf"));
            Image cabecera = Image.getInstance("src/img/header1.jpg");
            cabecera.scaleToFit(650,1000);
            cabecera.setAlignment(Chunk.ALIGN_CENTER);
            
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte: ");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Productos \n\n");
            
            doc.open();
            //se agregan los datos
            doc.add(cabecera);
            doc.add(parrafo);
            
            float[] columnsWidhts = {3, 5, 4, 5, 7, 5, 6};
            
            PdfPTable tabla = new PdfPTable(7);
            tabla.addCell("Codigo");
            tabla.addCell("Nombre");
            tabla.addCell("Cantidad");
            tabla.addCell("Precio");
            tabla.addCell("Descripcion");
            tabla.addCell("ITBIS");
            tabla.addCell("Categoria");
            
            try {
                String sql = "select p.idProducto, p.nombre, p.cantidad, p.precio, p.descripcion, p.itbis, c.descripcion from producto p inner join categoria c on p.idCategoria = c.idCategoria;";
                Statement st = conexion.conectar().createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    tabla.addCell(rs.getString(1));
                    tabla.addCell(rs.getString(2));
                    tabla.addCell(rs.getString(3));
                    tabla.addCell(rs.getString(4));
                    tabla.addCell(rs.getString(5));
                    tabla.addCell(rs.getString(6));
                    tabla.addCell(rs.getString(7));
                }
                doc.add(tabla);
                
            } catch (SQLException e) {
                System.out.println("Error: " + e.toString());
            }
            doc.close();
            JOptionPane.showMessageDialog(null, "Reporte Creado");
            
        } catch (DocumentException e) {
            System.out.println("Error 1:" + e.toString());
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2:" + ex.toString());
        } catch (IOException ex) {
            System.out.println("Error 3:" + ex.toString());
        }
        
    }
    
    //Metodo Reportes Ventas Registrados
    public void reporteVentas(){
        Document doc = new Document();
        
        try {
            
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(doc, new FileOutputStream(ruta + "/Desktop/Reporte_Ventas.pdf"));
            Image cabecera = Image.getInstance("src/img/header1.jpg");
            cabecera.scaleToFit(650,1000);
            cabecera.setAlignment(Chunk.ALIGN_CENTER);
            
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte: ");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Ventas \n\n");
            
            doc.open();
            //se agregan los datos
            doc.add(cabecera);
            doc.add(parrafo);
            
            float[] columnsWidhts = {3, 9, 4, 5, 3};
            
            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("Codigo");
            tabla.addCell("Cliente");
            tabla.addCell("Total Pagar");
            tabla.addCell("Fecha Venta");
            tabla.addCell("Estado");
            
            try {
                String sql = "select cv.idCabeceraVenta as id, concat(c.nombre,' ', c.apellido) as Cliente, cv.valorPagar as total, cv.fechaVenta as fecha, cv.estado from cabecera_venta cv inner join cliente c on cv.idCliente = c.idCliente;";
                Statement st = conexion.conectar().createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    tabla.addCell(rs.getString(1));
                    tabla.addCell(rs.getString(2));
                    tabla.addCell(rs.getString(3));
                    tabla.addCell(rs.getString(4));
                    tabla.addCell(rs.getString(5));
                }
                doc.add(tabla);
                
            } catch (SQLException e) {
                System.out.println("Error: " + e.toString());
            }
            doc.close();
            JOptionPane.showMessageDialog(null, "Reporte Creado");
            
        } catch (DocumentException e) {
            System.out.println("Error 1:" + e.toString());
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2:" + ex.toString());
        } catch (IOException ex) {
            System.out.println("Error 3:" + ex.toString());
        }
        
    }
    
}
