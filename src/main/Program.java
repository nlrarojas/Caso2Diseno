package main;

import Model.TextRepresentation;
import Model.strategy.FileSystemFactory;
import Model.strategy.IFileSystemStrategy;
import java.io.Console;
import view.PrincipalWindow;

public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        /*FileSystemFactory fsf = new FileSystemFactory();
        IFileSystemStrategy fyleSystem = fsf.create(IFileSystemStrategy.PDF_FILE);
        
        TextRepresentation text = new TextRepresentation();
        
        String path = "E:/Workspace/Diseno/Caso2/file.pdf";
        text.addText("Gato azul rojo y morado comen pan en la casa de don Rolando", "#000080");
        fyleSystem.setFile(path);
        fyleSystem.saveFile(text);
        text = fyleSystem.loadFile();
        System.out.println(text.getAsText());*/
        
        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PrincipalWindow().setVisible(true);
            }
        });
    }
}
