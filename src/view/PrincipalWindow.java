/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Nelson
 */
public class PrincipalWindow extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalWindow
     */
    public PrincipalWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        editorPane = new javax.swing.JEditorPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        addNewItemMenu = new javax.swing.JMenuItem();
        openItemMenu = new javax.swing.JMenuItem();
        saveItemMenu = new javax.swing.JMenuItem();
        saveAsItemMenu = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        undoItemMenu = new javax.swing.JMenuItem();
        redoItemMenu = new javax.swing.JMenuItem();
        copyItemMenu = new javax.swing.JMenuItem();
        cutItemMenu = new javax.swing.JMenuItem();
        pastItemMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jScrollPane1.setViewportView(editorPane);

        fileMenu.setText("Archivo");

        addNewItemMenu.setText("Nuevo");
        fileMenu.add(addNewItemMenu);

        openItemMenu.setText("Abrir");
        openItemMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openItemMenuActionPerformed(evt);
            }
        });
        fileMenu.add(openItemMenu);

        saveItemMenu.setText("Guardar");
        fileMenu.add(saveItemMenu);

        saveAsItemMenu.setText("Guardar como");
        fileMenu.add(saveAsItemMenu);

        jMenuBar1.add(fileMenu);

        editMenu.setText("Editar");

        undoItemMenu.setText("Rehacer");
        editMenu.add(undoItemMenu);

        redoItemMenu.setText("Deshacer");
        editMenu.add(redoItemMenu);

        copyItemMenu.setText("Copiar");
        editMenu.add(copyItemMenu);

        cutItemMenu.setText("Cortar");
        editMenu.add(cutItemMenu);

        pastItemMenu.setText("Pegar");
        editMenu.add(pastItemMenu);

        jMenuBar1.add(editMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openItemMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openItemMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_openItemMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addNewItemMenu;
    private javax.swing.JMenuItem copyItemMenu;
    private javax.swing.JMenuItem cutItemMenu;
    private javax.swing.JMenu editMenu;
    private javax.swing.JEditorPane editorPane;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem openItemMenu;
    private javax.swing.JMenuItem pastItemMenu;
    private javax.swing.JMenuItem redoItemMenu;
    private javax.swing.JMenuItem saveAsItemMenu;
    private javax.swing.JMenuItem saveItemMenu;
    private javax.swing.JMenuItem undoItemMenu;
    // End of variables declaration//GEN-END:variables
}
