package view.main;

import util.GenericController;

public class ListPanel extends javax.swing.JInternalFrame {
    
    private GenericController controller;
        
    public ListPanel() {
        initComponents();
    }
    
    public ListPanel(GenericController controller) {
        this();

        this.controller = controller;
        
        controller.loadItemsToTable(table);
    }

    public GenericController getController() {
        return controller;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        toolBar = new javax.swing.JToolBar();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        toolBar.setBackground(new java.awt.Color(245, 245, 245));
        toolBar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(211, 211, 211)));
        toolBar.setRollover(true);
        toolBar.setPreferredSize(new java.awt.Dimension(800, 25));

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/plus_16.png"))); // NOI18N
        addButton.setText("Adicionar");
        addButton.setFocusable(false);
        addButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        addButton.setMaximumSize(new java.awt.Dimension(65, 38));
        addButton.setMinimumSize(new java.awt.Dimension(65, 38));
        addButton.setPreferredSize(new java.awt.Dimension(65, 38));
        addButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(addButton);

        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/edit_16.png"))); // NOI18N
        editButton.setText("Alterar");
        editButton.setFocusable(false);
        editButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        editButton.setMaximumSize(new java.awt.Dimension(65, 38));
        editButton.setMinimumSize(new java.awt.Dimension(65, 38));
        editButton.setPreferredSize(new java.awt.Dimension(65, 38));
        editButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(editButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(toolBar, gridBagConstraints);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollPane.setViewportView(table);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 700;
        gridBagConstraints.ipady = 300;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(scrollPane, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton editButton;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable table;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
}
