package cmd;

import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class principal extends javax.swing.JInternalFrame {

    public static String tipo;
    public static String nombre;
    File carpetainicial = new File(System.getProperty("user.dir"));
    String carpetaAct=carpetainicial.getAbsolutePath();
    public principal() {
        initComponents();
        jTextArea1.append("Carpeta actual: "+carpetaAct);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setBorder(new javax.swing.border.MatteBorder(null));
        jTextArea1.setCaretColor(new java.awt.Color(51, 51, 51));
        jTextArea1.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 390));

        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 700, 40));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 700, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1FocusLost

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped

    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
            String command = jTextField1.getText();
            String[] tokens = command.split(" ");
            jTextArea1.append("\n"+carpetaAct+">"+tokens[0]);
            File carpetaActual = new File(System.getProperty("user.dir"));

            switch (tokens[0]) {
                case "mkdir":
                    String nombreCarpeta = String.join(" ", Arrays.copyOfRange(tokens, 1, tokens.length));

                    String rutaNuevaCarpeta = carpetaActual.getAbsolutePath() + File.separator + nombreCarpeta;

                    File nuevaCarpeta = new File(rutaNuevaCarpeta);
                    if (nuevaCarpeta.mkdir()) {
                        jTextArea1.append("\nCarpeta creada: " + nuevaCarpeta.getAbsolutePath() + "\n");
                    } else {
                        jTextArea1.append("\nError al crear carpeta.\n");
                    }
                    break;

                case "rm":
                    String nombreCarpetaEliminar = String.join(" ", Arrays.copyOfRange(tokens, 1, tokens.length));

                    String rutaCarpetaAEliminar = carpetaActual.getAbsolutePath() + File.separator + nombreCarpetaEliminar;
                    File carpetaAEliminar = new File(rutaCarpetaAEliminar);

                    if (carpetaAEliminar.delete()) {
                        jTextArea1.append("\nCarpeta eliminada: " + carpetaAEliminar.getAbsolutePath() + "\n");
                    } else {
                        jTextArea1.append("\nError al eliminar carpeta\n");
                    }
                    break;

                case "cd":
                    String nombreCarpetaCD = String.join(" ", Arrays.copyOfRange(tokens, 1, tokens.length));
                    
                    File carpetaACambiar = new File(carpetaActual, nombreCarpetaCD);
                    if (carpetaACambiar.isDirectory()) {
                        System.setProperty("user.dir", carpetaACambiar.getAbsolutePath());
                        carpetaAct=carpetaACambiar.getAbsolutePath();
                        jTextArea1.append("\nCarpeta actual: " + carpetaACambiar.getAbsolutePath() + "\n");
                    } else {
                        jTextArea1.append("\nError: " + nombreCarpetaCD + " no es una carpeta\n");
                    }
                    break;
                case "cd..":
                    File carpetaAnterior = carpetaActual.getParentFile();
                    if (carpetaAnterior != null) {
                        System.setProperty("user.dir", carpetaAnterior.getAbsolutePath());
                        carpetaAct=carpetaAnterior.getAbsolutePath();
                        jTextArea1.append("\nCarpeta actual: " + carpetaAnterior.getAbsolutePath() + "\n");
                    } else {
                        jTextArea1.append("\nError: No hay carpeta anterior\n");
                    }
                    break;
                case "help":
                    jTextArea1.append("\nComandos disponibles:\n");
                    jTextArea1.append("mkdir <nombreCarpeta>: Crear una nueva carpeta.\n");
                    jTextArea1.append("rm <nombreCarpeta>: Eliminar una carpeta.\n");
                    jTextArea1.append("cd <nombreCarpeta>: Cambiar al directorio especificado.\n");
                    jTextArea1.append("cd..: Retroceder al directorio padre.\n");
                    jTextArea1.append("dir: Mostrar lista de carpetas en el directorio actual.\n");
                    jTextArea1.append("date: Mostrar la fecha actual.\n");
                    jTextArea1.append("time: Mostrar la hora actual.\n");
                    jTextArea1.append("help: Mostrar esta ayuda.\n");
                    break;
                    
                case "dir":
                    File[] archivos = carpetaActual.listFiles();
                    Arrays.sort(archivos);

                    String formatoFecha = "yyyy-MM-dd HH:mm:ss";
                    SimpleDateFormat sdf = new SimpleDateFormat(formatoFecha);

                    String tabla = String.format("%-50s%-20s\n", "Nombre", "Fecha de creación");
                    tabla += "------------------------------------------------------------------\n";

                    for (File archivo : archivos) {
                        if (archivo.isDirectory()) {
                            String fecha = sdf.format(new Date(archivo.lastModified()));
                            tabla += String.format("%-50s%-20s\n", archivo.getName(), fecha);
                        }
                    }

                    jTextArea1.append("\n"+tabla);
                    break;
                    
                case "date":
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                    Date date = new Date();
                    jTextArea1.append("\nFecha actual: " + dateFormat.format(date) + "\n");
                    break;
                case "time":
                    DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                    Date time = new Date();
                    jTextArea1.append("\nHora actual: " + timeFormat.format(time) + "\n");
                    break;
                default:
                    jTextArea1.append("\nError: comando invalido\n");
                    break;
            }
            jTextField1.setText("");
        }
    }//GEN-LAST:event_jTextField1KeyPressed
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new principal().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
