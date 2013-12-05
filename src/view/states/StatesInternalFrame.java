package view.states;

import comboBoxModel.CountryComboBoxModel;
import controller.StateController;
import javax.swing.JButton;
import model.State;
import tableModel.StateTableModel;
import util.GenericActionListener;

public class StatesInternalFrame extends util.GenericInternalFrame<StateController, State, StateTableModel> {

    public StatesInternalFrame(StateController controller) {
        initComponents();

        this.controller = controller;

        this.listTableModel = new StateTableModel();

        this.tableStates.setModel(listTableModel);

        this.listener = new GenericActionListener(this, tableStates, listTableModel, controller);

        loadResources();
        
        loadStateResources();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        form = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        formName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        formAcronym = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        formSubmit = new javax.swing.JButton();
        formCountry = new javax.swing.JComboBox();
        destroyButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        tableStates = new javax.swing.JTable();

        setClosable(true);
        setTitle("Cadastro de Estados");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/tag_2.png"))); // NOI18N

        form.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Nome");

        jLabel2.setText("País");

        jLabel3.setText("Sigla");

        formSubmit.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        formSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/Save.png"))); // NOI18N
        formSubmit.setText("Gravar");
        formSubmit.setActionCommand("save");

        javax.swing.GroupLayout formLayout = new javax.swing.GroupLayout(form);
        form.setLayout(formLayout);
        formLayout.setHorizontalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(formName)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(formSubmit))
                    .addGroup(formLayout.createSequentialGroup()
                        .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(formLayout.createSequentialGroup()
                                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(formCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(formAcronym, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 86, Short.MAX_VALUE)))
                .addContainerGap())
        );
        formLayout.setVerticalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formAcronym, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                .addComponent(formSubmit)
                .addContainerGap())
        );

        destroyButton.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        destroyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/trash_16.png"))); // NOI18N
        destroyButton.setText("Excluír");
        destroyButton.setActionCommand("destroy");

        editButton.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/edit_16.png"))); // NOI18N
        editButton.setText("Alterar");
        editButton.setActionCommand("edit");

        addButton.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/plus_16.png"))); // NOI18N
        addButton.setText("Adicionar");
        addButton.setActionCommand("add");

        tableStates.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollPane.setViewportView(tableStates);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(destroyButton))
                    .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(destroyButton)
                            .addComponent(editButton)
                            .addComponent(addButton))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void loadStateResources() {
        this.formCountry.setModel(new CountryComboBoxModel());
    }

    @Override
    public JButton getAddButton() {
        return addButton;
    }

    @Override
    public JButton getDestroyButton() {
        return destroyButton;
    }

    @Override
    public JButton getEditButton() {
        return editButton;
    }

    @Override
    public JButton getFormSubmit() {
        return formSubmit;
    }

    @Override
    protected void enableOrDisableFields(boolean enable) {
        this.formName.setEnabled(enable);
        this.formCountry.setEnabled(enable);
        this.formAcronym.setEnabled(enable);

        this.formSubmit.setEnabled(enable);

        this.form.repaint();
    }

    @Override
    protected void setNewObject() {
        this.object = new State();
    }

    @Override
    protected void mappingObjectToForm() {
        this.formName.setText(object.getName());
        this.formCountry.getModel().setSelectedItem(object.getCountry());
        this.formAcronym.setText(object.getAcronym());
    }

    @Override
    protected void mappingFormToObject() {
        this.object.setName(formName.getText());
        this.object.setCountry( (model.Country) formCountry.getModel().getSelectedItem() );
        this.object.setAcronym(formAcronym.getText());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton destroyButton;
    private javax.swing.JButton editButton;
    private javax.swing.JPanel form;
    private javax.swing.JTextField formAcronym;
    private javax.swing.JComboBox formCountry;
    private javax.swing.JTextField formName;
    private javax.swing.JButton formSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tableStates;
    // End of variables declaration//GEN-END:variables
}
