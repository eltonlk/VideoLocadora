package view.main;

import com.jgoodies.looks.plastic.PlasticXPLookAndFeel;
import com.jgoodies.looks.plastic.theme.SkyBlue;
import view.genre.GenreInternalFrame;
import view.person.PersonInternalFrame;
import view.user.UserInternalFrame;

public class Main extends javax.swing.JFrame {

    public Main() {
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

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        customersMenuItem = new javax.swing.JMenuItem();
        suppliersMenuItem = new javax.swing.JMenuItem();
        employeesMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        usersMenuItem = new javax.swing.JMenuItem();
        optionsMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        movieMenu = new javax.swing.JMenu();
        genresMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gestão de Video Locadoras");
        setPreferredSize(getMaximumSize());

        fileMenu.setMnemonic('f');
        fileMenu.setText("Cadastros");

        customersMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/customers_16.png"))); // NOI18N
        customersMenuItem.setMnemonic('o');
        customersMenuItem.setText("Clientes");
        customersMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customersMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(customersMenuItem);

        suppliersMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/suppliers_16.png"))); // NOI18N
        suppliersMenuItem.setMnemonic('s');
        suppliersMenuItem.setText("Fornecedores");
        suppliersMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppliersMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(suppliersMenuItem);

        employeesMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/employees_16.png"))); // NOI18N
        employeesMenuItem.setMnemonic('a');
        employeesMenuItem.setText("Colaboradores");
        employeesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeesMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(employeesMenuItem);
        fileMenu.add(jSeparator1);

        usersMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/user_16.png"))); // NOI18N
        usersMenuItem.setText("Usuários");
        usersMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(usersMenuItem);

        optionsMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/config_16.png"))); // NOI18N
        optionsMenuItem.setText("Opções do Sistema");
        fileMenu.add(optionsMenuItem);
        fileMenu.add(jSeparator2);

        exitMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/sign_out_16.png"))); // NOI18N
        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Sair");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        movieMenu.setMnemonic('e');
        movieMenu.setText("Filmes");

        genresMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/category_16.png"))); // NOI18N
        genresMenuItem.setMnemonic('t');
        genresMenuItem.setText("Generos");
        genresMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genresMenuItemActionPerformed(evt);
            }
        });
        movieMenu.add(genresMenuItem);

        menuBar.add(movieMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Ajuda");

        aboutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/about_16.png"))); // NOI18N
        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("Sobre");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(desktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(desktopPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void customersMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customersMenuItemActionPerformed
        PersonInternalFrame personIF = new PersonInternalFrame("customer");
        
        personIF.setLocation((getWidth() - personIF.getWidth()) / 2, 40);
        
        personIF.setVisible(true);
        
        desktopPane.add(personIF);
    }//GEN-LAST:event_customersMenuItemActionPerformed

    private void suppliersMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppliersMenuItemActionPerformed
        PersonInternalFrame personIF = new PersonInternalFrame("supplier");
        
        personIF.setLocation((getWidth() - personIF.getWidth()) / 2, 40);
        
        personIF.setVisible(true);
        
        desktopPane.add(personIF);
    }//GEN-LAST:event_suppliersMenuItemActionPerformed
    
    private void employeesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeesMenuItemActionPerformed
        PersonInternalFrame personIF = new PersonInternalFrame("employee");
        
        personIF.setLocation((getWidth() - personIF.getWidth()) / 2, 40);
        
        personIF.setVisible(true);
        
        desktopPane.add(personIF);
    }//GEN-LAST:event_employeesMenuItemActionPerformed

    private void usersMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersMenuItemActionPerformed
        UserInternalFrame userIF = new UserInternalFrame();
        
        userIF.setLocation((getWidth() - userIF.getWidth()) / 2, 40);
        
        userIF.setVisible(true);
        
        desktopPane.add(userIF);
    }//GEN-LAST:event_usersMenuItemActionPerformed

    private void genresMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genresMenuItemActionPerformed
        GenreInternalFrame genreIF = new GenreInternalFrame();
        
        genreIF.setLocation((getWidth() - genreIF.getWidth()) / 2, 40);
        
        genreIF.setVisible(true);
        
        desktopPane.add(genreIF);
    }//GEN-LAST:event_genresMenuItemActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        PlasticXPLookAndFeel.setPlasticTheme(new SkyBlue());
        
        try {
//            javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticXPLookAndFeel");
        
            javax.swing.UIManager.setLookAndFeel( new PlasticXPLookAndFeel() );
            
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
        } catch (javax.swing.UnsupportedLookAndFeelException ex) { // ClassNotFoundException | InstantiationException | IllegalAccessException | 
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem customersMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem employeesMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem genresMenuItem;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu movieMenu;
    private javax.swing.JMenuItem optionsMenuItem;
    private javax.swing.JMenuItem suppliersMenuItem;
    private javax.swing.JMenuItem usersMenuItem;
    // End of variables declaration//GEN-END:variables
}
