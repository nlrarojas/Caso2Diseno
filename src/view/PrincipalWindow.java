package view;

import Model.TextRepresentation;
import controller.Client;
import java.awt.Color;
import java.io.File;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Nelson
 */
public class PrincipalWindow extends javax.swing.JFrame {

    private Client client;
    private JFileChooser fc;
    private Color color;
    private TextRepresentation text;
    /**
     * Creates new form PrincipalWindow
     */
    public PrincipalWindow() {
        initComponents();        
        
        this.client = new Client();
        
        fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("xml", "xml"));
        fc.setFileFilter(new FileNameExtensionFilter("txt", "txt"));
        fc.setFileFilter(new FileNameExtensionFilter("pdf", "pdf"));
        fc.setFileFilter(new FileNameExtensionFilter("csv",  "csv"));
        
        color = Color.black;
    }

    public File openFile() {
        int returnVal = fc.showOpenDialog(this);
        File file = null;
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            //This is where a real application would open the file.
            System.out.println("Opening: " + file.getName() + ".");
        } else {
            System.out.println("Open command cancelled by user.");
        }
        return file;
    }
    
    public File saveFile() {
        int returnVal = fc.showSaveDialog(this);
        File file = null;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            //This is where a real application would open the file.
            System.out.println("Opening: " + file.getName() + ".");
        } else {
            System.out.println("Open command cancelled by user.");
        }
        return file;
    }
    
    public void save(File fileCreated) {
        text = new TextRepresentation();
        String hex = "#"+Integer.toHexString(color.getRGB()).substring(2);
        text.addText(editorPane.getText(), hex);
        this.client.saveFile(fileCreated, text);
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
        jPanel1 = new javax.swing.JPanel();
        newFileBtn = new javax.swing.JButton();
        openFileBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        saveAsBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        undoBtn = new javax.swing.JButton();
        redoBtn = new javax.swing.JButton();
        cutBtn = new javax.swing.JButton();
        copyBtn = new javax.swing.JButton();
        pasteBtn = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        colorPickerBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
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
        setPreferredSize(new java.awt.Dimension(800, 700));

        jScrollPane1.setViewportView(editorPane);

        newFileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/new.png"))); // NOI18N
        newFileBtn.setBorder(null);
        newFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileBtnActionPerformed(evt);
            }
        });

        openFileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/open.png"))); // NOI18N
        openFileBtn.setBorder(null);
        openFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileBtnActionPerformed(evt);
            }
        });

        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        saveBtn.setToolTipText("");
        saveBtn.setBorder(null);
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        saveAsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/saveas.png"))); // NOI18N
        saveAsBtn.setBorder(null);
        saveAsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsBtnActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        undoBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/undo.png"))); // NOI18N
        undoBtn.setBorder(null);
        undoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoBtnActionPerformed(evt);
            }
        });

        redoBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/redo.png"))); // NOI18N
        redoBtn.setBorder(null);
        redoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoBtnActionPerformed(evt);
            }
        });

        cutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cut.png"))); // NOI18N
        cutBtn.setBorder(null);
        cutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutBtnActionPerformed(evt);
            }
        });

        copyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy.png"))); // NOI18N
        copyBtn.setBorder(null);
        copyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyBtnActionPerformed(evt);
            }
        });

        pasteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/paste.png"))); // NOI18N
        pasteBtn.setBorder(null);
        pasteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteBtnActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        colorPickerBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/color.png"))); // NOI18N
        colorPickerBtn.setBorder(null);
        colorPickerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorPickerBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(newFileBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(openFileBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveAsBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(undoBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(redoBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cutBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(copyBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pasteBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(colorPickerBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(colorPickerBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator2)
                    .addComponent(pasteBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(copyBtn)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cutBtn, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(redoBtn)
                            .addComponent(undoBtn)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(saveAsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(openFileBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(newFileBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1)))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        fileMenu.setText("Archivo");

        addNewItemMenu.setText("Nuevo");
        addNewItemMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewItemMenuActionPerformed(evt);
            }
        });
        fileMenu.add(addNewItemMenu);

        openItemMenu.setText("Abrir");
        openItemMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openItemMenuActionPerformed(evt);
            }
        });
        fileMenu.add(openItemMenu);

        saveItemMenu.setText("Guardar");
        saveItemMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveItemMenuActionPerformed(evt);
            }
        });
        fileMenu.add(saveItemMenu);

        saveAsItemMenu.setText("Guardar como");
        saveAsItemMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsItemMenuActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsItemMenu);

        jMenuBar1.add(fileMenu);

        editMenu.setText("Editar");

        undoItemMenu.setText("Rehacer");
        undoItemMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoItemMenuActionPerformed(evt);
            }
        });
        editMenu.add(undoItemMenu);

        redoItemMenu.setText("Deshacer");
        redoItemMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoItemMenuActionPerformed(evt);
            }
        });
        editMenu.add(redoItemMenu);

        copyItemMenu.setText("Copiar");
        copyItemMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyItemMenuActionPerformed(evt);
            }
        });
        editMenu.add(copyItemMenu);

        cutItemMenu.setText("Cortar");
        cutItemMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutItemMenuActionPerformed(evt);
            }
        });
        editMenu.add(cutItemMenu);

        pastItemMenu.setText("Pegar");
        pastItemMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pastItemMenuActionPerformed(evt);
            }
        });
        editMenu.add(pastItemMenu);

        jMenuBar1.add(editMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openItemMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openItemMenuActionPerformed
        this.client.openFile(openFile());
    }//GEN-LAST:event_openItemMenuActionPerformed

    private void colorPickerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorPickerBtnActionPerformed
        color = JColorChooser.showDialog(null, "Seleccione un Color", Color.BLUE);
    }//GEN-LAST:event_colorPickerBtnActionPerformed

    private void newFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileBtnActionPerformed
        if (!editorPane.getText().isEmpty()) {
            File fileCreated = saveFile();
            if (fileCreated == null) {
                editorPane.setText("");
            } else {
                save(fileCreated);
            }            
        }
    }//GEN-LAST:event_newFileBtnActionPerformed

    private void openFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileBtnActionPerformed
        this.client.openFile(openFile());
    }//GEN-LAST:event_openFileBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        text = null;
        this.client.saveFile(saveFile(), text);
        //check if file already exists otherwise open saveDialogBox        
    }//GEN-LAST:event_saveBtnActionPerformed

    private void saveAsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsBtnActionPerformed
        text = null;
        this.client.saveFile(saveFile(), text);       
    }//GEN-LAST:event_saveAsBtnActionPerformed

    private void undoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoBtnActionPerformed
        this.client.undo();
    }//GEN-LAST:event_undoBtnActionPerformed

    private void redoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoBtnActionPerformed
        this.client.redo();
    }//GEN-LAST:event_redoBtnActionPerformed

    private void cutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutBtnActionPerformed
        this.client.cut();
    }//GEN-LAST:event_cutBtnActionPerformed

    private void copyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyBtnActionPerformed
        this.client.copy();
    }//GEN-LAST:event_copyBtnActionPerformed

    private void pasteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteBtnActionPerformed
        this.client.paste();
    }//GEN-LAST:event_pasteBtnActionPerformed

    private void addNewItemMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewItemMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addNewItemMenuActionPerformed

    private void saveItemMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveItemMenuActionPerformed
        text = null;
        this.client.saveFile(saveFile(), text);
        //check if file already exists otherwise open saveDialogBox        
    }//GEN-LAST:event_saveItemMenuActionPerformed

    private void saveAsItemMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsItemMenuActionPerformed
        text = null;
        this.client.saveFile(saveFile(), text);    
    }//GEN-LAST:event_saveAsItemMenuActionPerformed

    private void undoItemMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoItemMenuActionPerformed
        this.client.redo();
    }//GEN-LAST:event_undoItemMenuActionPerformed

    private void redoItemMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoItemMenuActionPerformed
        this.client.undo();
    }//GEN-LAST:event_redoItemMenuActionPerformed

    private void copyItemMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyItemMenuActionPerformed
        this.client.copy();
    }//GEN-LAST:event_copyItemMenuActionPerformed

    private void cutItemMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutItemMenuActionPerformed
        this.client.cut();
    }//GEN-LAST:event_cutItemMenuActionPerformed

    private void pastItemMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pastItemMenuActionPerformed
        this.client.paste();
    }//GEN-LAST:event_pastItemMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addNewItemMenu;
    private javax.swing.JButton colorPickerBtn;
    private javax.swing.JButton copyBtn;
    private javax.swing.JMenuItem copyItemMenu;
    private javax.swing.JButton cutBtn;
    private javax.swing.JMenuItem cutItemMenu;
    private javax.swing.JMenu editMenu;
    private javax.swing.JEditorPane editorPane;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton newFileBtn;
    private javax.swing.JButton openFileBtn;
    private javax.swing.JMenuItem openItemMenu;
    private javax.swing.JMenuItem pastItemMenu;
    private javax.swing.JButton pasteBtn;
    private javax.swing.JButton redoBtn;
    private javax.swing.JMenuItem redoItemMenu;
    private javax.swing.JButton saveAsBtn;
    private javax.swing.JMenuItem saveAsItemMenu;
    private javax.swing.JButton saveBtn;
    private javax.swing.JMenuItem saveItemMenu;
    private javax.swing.JButton undoBtn;
    private javax.swing.JMenuItem undoItemMenu;
    // End of variables declaration//GEN-END:variables
}
