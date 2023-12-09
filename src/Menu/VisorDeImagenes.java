package Menu;

import javax.swing.ImageIcon;
import java.io.File;
import javax.swing.JOptionPane;

public class VisorDeImagenes extends javax.swing.JInternalFrame {

    private File[] ImgArray;
    private int Pos;

    public VisorDeImagenes() {
        
        initComponents();
        
        this.setTitle("Mis Imagenes");
        File imageFolder = new File("Z/" + MenuPrincipal.nombreIngresado + "/Mis Imagenes");

        ImgArray = imageFolder.listFiles();

        if (ImgArray != null && ImgArray.length > 0) {
            Pos = 0;
            ImageIcon Imagen = new ImageIcon(ImgArray[Pos].getPath());
           
        } else {
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bevelBorder1 = (javax.swing.border.BevelBorder)javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED);
        CuadroImagenes = new javax.swing.JLabel();
        Izuierda = new javax.swing.JButton();
        derecha = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Visor De Imagenes");
        setPreferredSize(new java.awt.Dimension(775, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CuadroImagenes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CuadroImagenes.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 255)));
        getContentPane().add(CuadroImagenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 500, 380));

        Izuierda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Flecha inversa.png"))); // NOI18N
        Izuierda.setBorder(null);
        Izuierda.setOpaque(false);
        Izuierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IzuierdaActionPerformed(evt);
            }
        });
        getContentPane().add(Izuierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 90, 60));

        derecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Flecha.png"))); // NOI18N
        derecha.setBorder(null);
        derecha.setOpaque(false);
        derecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derechaActionPerformed(evt);
            }
        });
        getContentPane().add(derecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, 100, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void derechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derechaActionPerformed
     if(ImgArray.length>0){
        Pos++;
        if (Pos >= ImgArray.length) {
            Pos = 0;
        }
        ImageIcon newIcon = new ImageIcon(ImgArray[Pos].getPath());
        CuadroImagenes.setIcon(newIcon);
       }
    }//GEN-LAST:event_derechaActionPerformed

    private void IzuierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IzuierdaActionPerformed
        if(ImgArray.length>0){
        Pos--;
        if (Pos < 0) {
            Pos = ImgArray.length - 1;
        }
        ImageIcon newIcon = new ImageIcon(ImgArray[Pos].getPath());
        CuadroImagenes.setIcon(newIcon);
        }
       
    }//GEN-LAST:event_IzuierdaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VisorDeImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisorDeImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisorDeImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisorDeImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VisorDeImagenes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel CuadroImagenes;
    private javax.swing.JButton Izuierda;
    private javax.swing.border.BevelBorder bevelBorder1;
    private javax.swing.JButton derecha;
    // End of variables declaration//GEN-END:variables
}
