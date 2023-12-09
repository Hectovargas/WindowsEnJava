package Menu;

import Usuarios.Users;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class InicioDeSistema extends javax.swing.JFrame {
    Users User = new Users();
    public File file = null;
    MenuPrincipal menu = new MenuPrincipal();

     
    public InicioDeSistema() {
        this.setUndecorated(true);
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        BotonSalir = new javax.swing.JButton();
        imgPerfil = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        Contraseñafiel = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 255));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonSalir.setBackground(new java.awt.Color(102, 102, 102));
        BotonSalir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BotonSalir.setForeground(new java.awt.Color(255, 255, 255));
        BotonSalir.setText("Apagar sistema");
        BotonSalir.setBorder(new javax.swing.border.MatteBorder(null));
        BotonSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.N_RESIZE_CURSOR));
        BotonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSalirActionPerformed(evt);
            }
        });
        jPanel2.add(BotonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 680, 200, 70));

        imgPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/profile.png"))); // NOI18N
        jPanel2.add(imgPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 260, 280));

        txtUsuario.setBackground(new java.awt.Color(1, 46, 70));
        txtUsuario.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setToolTipText("");
        txtUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 46, 70), 8, true));
        txtUsuario.setCaretColor(new java.awt.Color(255, 255, 255));
        txtUsuario.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtUsuario.setMargin(new java.awt.Insets(5, 5, 5, 5));
        txtUsuario.setSelectedTextColor(new java.awt.Color(1, 46, 70));
        txtUsuario.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, 310, 30));

        Contraseñafiel.setBackground(new java.awt.Color(1, 46, 70));
        Contraseñafiel.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        Contraseñafiel.setForeground(new java.awt.Color(255, 255, 255));
        Contraseñafiel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 46, 70), 8, true));
        Contraseñafiel.setCaretColor(new java.awt.Color(255, 255, 255));
        Contraseñafiel.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(Contraseñafiel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 420, 310, 30));

        btnIngresar.setBackground(new java.awt.Color(85, 121, 150));
        btnIngresar.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(2, 29, 52));
        btnIngresar.setText("Ingresar");
        btnIngresar.setToolTipText("");
        btnIngresar.setBorder(new javax.swing.border.MatteBorder(null));
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel2.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 490, 200, 40));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 80, 30));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Contraseña:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, 110, 30));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen_fondo_windows (1).jpg"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1369, 780));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped

    }//GEN-LAST:event_formKeyTyped

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
                                         
        String nombre = this.txtUsuario.getText();
        String contra = this.Contraseñafiel.getText();
        try {
            if (User.VerificarUsuarios(nombre, contra)) {
                String tipo = User.BuscarTipo(nombre, contra);
                JOptionPane.showMessageDialog(this, "Bienvenido " + nombre+"!");
                menu.setVisible(true);
                this.dispose();
                MenuPrincipal.nombreIngresado = nombre;
                menu.tipoIngresado = tipo;
                txtUsuario.setText("");
                Contraseñafiel.setText("");

            } else {

                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
                txtUsuario.setText("");
                Contraseñafiel.setText("");

            }

        } catch (IOException ex) {
            Logger.getLogger(InicioDeSistema.class.getName()).log(Level.SEVERE, null, ex);
        }                      
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void BotonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BotonSalirActionPerformed
                               

                                       
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new InicioDeSistema().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonSalir;
    private javax.swing.JPasswordField Contraseñafiel;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel imgPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
