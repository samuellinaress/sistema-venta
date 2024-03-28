package vista;

import javax.swing.JDesktopPane;

/**
 *
 * @author Samuel Linares
 */
public class Menu extends javax.swing.JFrame {
    
    public static JDesktopPane menu_interno;

    public Menu() {
        initComponents();
        this.setSize(1200, 600);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setTitle("Sistema de Ventas");
        this.setVisible(true);
        
        this.setLayout(null);
        menu_interno = new JDesktopPane();
        
        //ancho y alto de la pantalla de la computadora para que cuando el frame principal 
        //tome el tamano de la pantalla completa el frame interno tambien la tome
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        menu_interno.setBounds(0, 0, ancho, (alto-110)); //-110 para que no ocupe la barra de herramientas de la laptop
        this.add(menu_interno); //se agrega al frame principal
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menu_Usuario = new javax.swing.JMenu();
        mItem_nuevoUser = new javax.swing.JMenuItem();
        mItem_gestionarUsers = new javax.swing.JMenuItem();
        menu_Producto = new javax.swing.JMenu();
        mItem_nuevoProduc = new javax.swing.JMenuItem();
        mItem_gestionarProduc = new javax.swing.JMenuItem();
        mItem_actualizarStock = new javax.swing.JMenuItem();
        menu_Cliente = new javax.swing.JMenu();
        mItem_nuevoCliente = new javax.swing.JMenuItem();
        mItem_gestionarClientes = new javax.swing.JMenuItem();
        menu_Categoria = new javax.swing.JMenu();
        mItem_nuevaCategoria = new javax.swing.JMenuItem();
        mItem_gestionarCategorias = new javax.swing.JMenuItem();
        menu_Facturar = new javax.swing.JMenu();
        mItem_nuevaVenta = new javax.swing.JMenuItem();
        mItem_gestionarVentas = new javax.swing.JMenuItem();
        menu_Reporte = new javax.swing.JMenu();
        mItem_reporteCliente = new javax.swing.JMenuItem();
        mItem_reporteCategorias = new javax.swing.JMenuItem();
        mItem_reporteProductos = new javax.swing.JMenuItem();
        mItem_reporteVentas = new javax.swing.JMenuItem();
        menu_Historial = new javax.swing.JMenu();
        mItem_verHistorial = new javax.swing.JMenuItem();
        menu_CerrarSesion = new javax.swing.JMenu();
        mItem_cerrarSesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(150, 50));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jMenuBar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        menu_Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario.png"))); // NOI18N
        menu_Usuario.setText("Usuario");
        menu_Usuario.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        menu_Usuario.setPreferredSize(new java.awt.Dimension(150, 50));

        mItem_nuevoUser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mItem_nuevoUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo-cliente.png"))); // NOI18N
        mItem_nuevoUser.setText("Nuevo Usuario");
        mItem_nuevoUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItem_nuevoUserActionPerformed(evt);
            }
        });
        menu_Usuario.add(mItem_nuevoUser);

        mItem_gestionarUsers.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mItem_gestionarUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/configuraciones.png"))); // NOI18N
        mItem_gestionarUsers.setText("Gestionar Usuarios");
        mItem_gestionarUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItem_gestionarUsersActionPerformed(evt);
            }
        });
        menu_Usuario.add(mItem_gestionarUsers);

        jMenuBar1.add(menu_Usuario);

        menu_Producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/producto.png"))); // NOI18N
        menu_Producto.setText("Producto");
        menu_Producto.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        menu_Producto.setPreferredSize(new java.awt.Dimension(150, 50));

        mItem_nuevoProduc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mItem_nuevoProduc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo-producto.png"))); // NOI18N
        mItem_nuevoProduc.setText("Nuevo Producto");
        mItem_nuevoProduc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItem_nuevoProducActionPerformed(evt);
            }
        });
        menu_Producto.add(mItem_nuevoProduc);

        mItem_gestionarProduc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mItem_gestionarProduc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/producto.png"))); // NOI18N
        mItem_gestionarProduc.setText("Gestionar Productos");
        mItem_gestionarProduc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItem_gestionarProducActionPerformed(evt);
            }
        });
        menu_Producto.add(mItem_gestionarProduc);

        mItem_actualizarStock.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mItem_actualizarStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        mItem_actualizarStock.setText("Actualizar Stock");
        mItem_actualizarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItem_actualizarStockActionPerformed(evt);
            }
        });
        menu_Producto.add(mItem_actualizarStock);

        jMenuBar1.add(menu_Producto);

        menu_Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cliente.png"))); // NOI18N
        menu_Cliente.setText("Cliente");
        menu_Cliente.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        menu_Cliente.setPreferredSize(new java.awt.Dimension(150, 50));

        mItem_nuevoCliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mItem_nuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo-cliente.png"))); // NOI18N
        mItem_nuevoCliente.setText("Nuevo Cliente");
        mItem_nuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItem_nuevoClienteActionPerformed(evt);
            }
        });
        menu_Cliente.add(mItem_nuevoCliente);

        mItem_gestionarClientes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mItem_gestionarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cliente.png"))); // NOI18N
        mItem_gestionarClientes.setText("Gestionar Clientes");
        mItem_gestionarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItem_gestionarClientesActionPerformed(evt);
            }
        });
        menu_Cliente.add(mItem_gestionarClientes);

        jMenuBar1.add(menu_Cliente);

        menu_Categoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/categorias.png"))); // NOI18N
        menu_Categoria.setText("Categoria");
        menu_Categoria.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        menu_Categoria.setPreferredSize(new java.awt.Dimension(150, 50));

        mItem_nuevaCategoria.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mItem_nuevaCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        mItem_nuevaCategoria.setText("Nueva Categoria");
        menu_Categoria.add(mItem_nuevaCategoria);

        mItem_gestionarCategorias.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mItem_gestionarCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/categorias.png"))); // NOI18N
        mItem_gestionarCategorias.setText("Gestionar Categorias");
        menu_Categoria.add(mItem_gestionarCategorias);

        jMenuBar1.add(menu_Categoria);

        menu_Facturar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carrito.png"))); // NOI18N
        menu_Facturar.setText("Facturar");
        menu_Facturar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        menu_Facturar.setPreferredSize(new java.awt.Dimension(150, 50));

        mItem_nuevaVenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mItem_nuevaVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anadir.png"))); // NOI18N
        mItem_nuevaVenta.setText("Nueva Venta");
        menu_Facturar.add(mItem_nuevaVenta);

        mItem_gestionarVentas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mItem_gestionarVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/configuraciones.png"))); // NOI18N
        mItem_gestionarVentas.setText("Gestionar Ventas");
        menu_Facturar.add(mItem_gestionarVentas);

        jMenuBar1.add(menu_Facturar);

        menu_Reporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reportes.png"))); // NOI18N
        menu_Reporte.setText("Reportes");
        menu_Reporte.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        menu_Reporte.setPreferredSize(new java.awt.Dimension(150, 50));

        mItem_reporteCliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mItem_reporteCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reporte1.png"))); // NOI18N
        mItem_reporteCliente.setText("Reporte Clientes");
        menu_Reporte.add(mItem_reporteCliente);

        mItem_reporteCategorias.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mItem_reporteCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reporte1.png"))); // NOI18N
        mItem_reporteCategorias.setText("Reporte Categorias");
        menu_Reporte.add(mItem_reporteCategorias);

        mItem_reporteProductos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mItem_reporteProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reporte1.png"))); // NOI18N
        mItem_reporteProductos.setText("Reporte Productos");
        menu_Reporte.add(mItem_reporteProductos);

        mItem_reporteVentas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mItem_reporteVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reporte1.png"))); // NOI18N
        mItem_reporteVentas.setText("Reporte Ventas");
        menu_Reporte.add(mItem_reporteVentas);

        jMenuBar1.add(menu_Reporte);

        menu_Historial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/historial1.png"))); // NOI18N
        menu_Historial.setText("Historial");
        menu_Historial.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        menu_Historial.setPreferredSize(new java.awt.Dimension(150, 50));

        mItem_verHistorial.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mItem_verHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/historial1.png"))); // NOI18N
        mItem_verHistorial.setText("Ver Historial ");
        menu_Historial.add(mItem_verHistorial);

        jMenuBar1.add(menu_Historial);

        menu_CerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion.png"))); // NOI18N
        menu_CerrarSesion.setText("Cerrar Sesion");
        menu_CerrarSesion.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        menu_CerrarSesion.setPreferredSize(new java.awt.Dimension(150, 50));

        mItem_cerrarSesion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mItem_cerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion.png"))); // NOI18N
        mItem_cerrarSesion.setText("Cerrar Sesion");
        menu_CerrarSesion.add(mItem_cerrarSesion);

        jMenuBar1.add(menu_CerrarSesion);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mItem_nuevoUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItem_nuevoUserActionPerformed
        NuevoUser nuevoUsuario = new NuevoUser();
        menu_interno.add(nuevoUsuario);
        nuevoUsuario.setVisible(true);
    }//GEN-LAST:event_mItem_nuevoUserActionPerformed

    private void mItem_gestionarUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItem_gestionarUsersActionPerformed
        AdministrarUser usuarios = new AdministrarUser();
        menu_interno.add(usuarios);
        usuarios.setVisible(true);
    }//GEN-LAST:event_mItem_gestionarUsersActionPerformed

    private void mItem_nuevoProducActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItem_nuevoProducActionPerformed
        NewProducto nuevoProducto = new NewProducto();
        menu_interno.add(nuevoProducto);
        nuevoProducto.setVisible(true);
    }//GEN-LAST:event_mItem_nuevoProducActionPerformed

    private void mItem_gestionarProducActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItem_gestionarProducActionPerformed
        AdministrarProducto productos = new AdministrarProducto();
        menu_interno.add(productos);
        productos.setVisible(true);
    }//GEN-LAST:event_mItem_gestionarProducActionPerformed

    private void mItem_actualizarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItem_actualizarStockActionPerformed
        stock inventario = new stock();
        menu_interno.add(inventario);
        inventario.setVisible(true);
    }//GEN-LAST:event_mItem_actualizarStockActionPerformed

    private void mItem_nuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItem_nuevoClienteActionPerformed
       NewCliente nuevoCliente = new NewCliente();
       menu_interno.add(nuevoCliente);
       nuevoCliente.setVisible(true);
    }//GEN-LAST:event_mItem_nuevoClienteActionPerformed

    private void mItem_gestionarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItem_gestionarClientesActionPerformed
        AdministrarCliente clientes = new AdministrarCliente();
        menu_interno.add(clientes);
        clientes.setVisible(true);
    }//GEN-LAST:event_mItem_gestionarClientesActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Menu().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mItem_actualizarStock;
    private javax.swing.JMenuItem mItem_cerrarSesion;
    private javax.swing.JMenuItem mItem_gestionarCategorias;
    private javax.swing.JMenuItem mItem_gestionarClientes;
    private javax.swing.JMenuItem mItem_gestionarProduc;
    private javax.swing.JMenuItem mItem_gestionarUsers;
    private javax.swing.JMenuItem mItem_gestionarVentas;
    private javax.swing.JMenuItem mItem_nuevaCategoria;
    private javax.swing.JMenuItem mItem_nuevaVenta;
    private javax.swing.JMenuItem mItem_nuevoCliente;
    private javax.swing.JMenuItem mItem_nuevoProduc;
    private javax.swing.JMenuItem mItem_nuevoUser;
    private javax.swing.JMenuItem mItem_reporteCategorias;
    private javax.swing.JMenuItem mItem_reporteCliente;
    private javax.swing.JMenuItem mItem_reporteProductos;
    private javax.swing.JMenuItem mItem_reporteVentas;
    private javax.swing.JMenuItem mItem_verHistorial;
    private javax.swing.JMenu menu_Categoria;
    private javax.swing.JMenu menu_CerrarSesion;
    private javax.swing.JMenu menu_Cliente;
    private javax.swing.JMenu menu_Facturar;
    private javax.swing.JMenu menu_Historial;
    private javax.swing.JMenu menu_Producto;
    private javax.swing.JMenu menu_Reporte;
    private javax.swing.JMenu menu_Usuario;
    // End of variables declaration//GEN-END:variables
}
