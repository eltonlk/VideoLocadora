package view.person;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public final class FormPanel extends javax.swing.JPanel {

    private String kind;
    
    public FormPanel() {
        initComponents();
        
        enableOrDisableFields(false);
    }
    
    public FormPanel(String kind) {
        this();
        
        this.kind = kind;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelLegalName = new javax.swing.JLabel();
        inputLegalName = new javax.swing.JTextField();
        labelName = new javax.swing.JLabel();
        inputName = new javax.swing.JTextField();
        labelDocument1 = new javax.swing.JLabel();
        inputDocument1 = new javax.swing.JTextField();
        inputDocument2 = new javax.swing.JTextField();
        labelDocument2 = new javax.swing.JLabel();
        labelStatus = new javax.swing.JLabel();
        selectStatus = new javax.swing.JComboBox();
        jTabbedPane = new javax.swing.JTabbedPane();
        panelContact = new javax.swing.JPanel();
        labelEmail = new javax.swing.JLabel();
        inputEmail = new javax.swing.JTextField();
        labelPhone = new javax.swing.JLabel();
        inputPhone = new javax.swing.JTextField();
        inputCel = new javax.swing.JTextField();
        labelCel = new javax.swing.JLabel();
        panelAddress = new javax.swing.JPanel();
        labelAddress = new javax.swing.JLabel();
        inputAddress = new javax.swing.JTextField();
        labelId = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setPreferredSize(new java.awt.Dimension(450, 500));

        labelLegalName.setText("Razão Social");

        labelName.setText("Nome Fantasia");

        labelDocument1.setText("CNPJ");

        inputDocument1.setSize(new java.awt.Dimension(210, 0));

        labelDocument2.setText("Inscrição Estadual");

        labelStatus.setText("Situação");

        selectStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativo", "Inativo" }));

        labelEmail.setText("Email");

        labelPhone.setText("Telefone");

        labelCel.setText("Celular");

        javax.swing.GroupLayout panelContactLayout = new javax.swing.GroupLayout(panelContact);
        panelContact.setLayout(panelContactLayout);
        panelContactLayout.setHorizontalGroup(
            panelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContactLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContactLayout.createSequentialGroup()
                        .addGroup(panelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPhone)
                            .addComponent(inputPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelContactLayout.createSequentialGroup()
                                .addComponent(labelCel)
                                .addGap(0, 150, Short.MAX_VALUE))
                            .addComponent(inputCel)))
                    .addGroup(panelContactLayout.createSequentialGroup()
                        .addComponent(labelEmail)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(inputEmail))
                .addContainerGap())
        );
        panelContactLayout.setVerticalGroup(
            panelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContactLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPhone)
                    .addComponent(labelCel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Contato", panelContact);

        labelAddress.setText("Endereço");

        javax.swing.GroupLayout panelAddressLayout = new javax.swing.GroupLayout(panelAddress);
        panelAddress.setLayout(panelAddressLayout);
        panelAddressLayout.setHorizontalGroup(
            panelAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddressLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAddressLayout.createSequentialGroup()
                        .addComponent(labelAddress)
                        .addGap(0, 344, Short.MAX_VALUE))
                    .addComponent(inputAddress))
                .addContainerGap())
        );
        panelAddressLayout.setVerticalGroup(
            panelAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddressLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAddress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Endereço", panelAddress);

        labelId.setFont(new java.awt.Font("Droid Sans", 1, 12)); // NOI18N
        labelId.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelName)
                            .addComponent(labelStatus))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(selectStatus, javax.swing.GroupLayout.Alignment.LEADING, 0, 210, Short.MAX_VALUE)
                            .addComponent(labelDocument1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputDocument1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelDocument2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(inputDocument2)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(inputLegalName)
                            .addComponent(inputName)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelLegalName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelId, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelLegalName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputLegalName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDocument1)
                    .addComponent(labelDocument2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputDocument1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputDocument2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public JTextField getInputCel() {
        return inputCel;
    }

    public void setInputCel(JTextField inputCel) {
        this.inputCel = inputCel;
    }

    public JTextField getInputDocument1() {
        return inputDocument1;
    }

    public void setInputDocument1(JTextField inputDocument1) {
        this.inputDocument1 = inputDocument1;
    }

    public JTextField getInputDocument2() {
        return inputDocument2;
    }

    public void setInputDocument2(JTextField inputDocument2) {
        this.inputDocument2 = inputDocument2;
    }

    public JTextField getInputEmail() {
        return inputEmail;
    }

    public void setInputEmail(JTextField inputEmail) {
        this.inputEmail = inputEmail;
    }

    public JTextField getInputLegalName() {
        return inputLegalName;
    }

    public void setInputLegalName(JTextField inputLegalName) {
        this.inputLegalName = inputLegalName;
    }

    public JTextField getInputName() {
        return inputName;
    }

    public void setInputName(JTextField inputName) {
        this.inputName = inputName;
    }

    public JTextField getInputPhone() {
        return inputPhone;
    }

    public void setInputPhone(JTextField inputPhone) {
        this.inputPhone = inputPhone;
    }

    public JComboBox getSelectStatus() {
        return selectStatus;
    }

    public void setSelectStatus(JComboBox selectStatus) {
        this.selectStatus = selectStatus;
    }

    public JLabel getLabelId() {
        return labelId;
    }

    public void setLabelId(JLabel labelId) {
        this.labelId = labelId;
    }
    
    public String getKind() {
        return kind;
    }

    public JTextField getInputAddress() {
        return inputAddress;
    }

    public void setInputAddress(JTextField inputAddress) {
        this.inputAddress = inputAddress;
    }
    
    public void enableOrDisableFields(boolean enable) {
        inputCel.enable(enable);
        inputDocument1.enable(enable);
        inputDocument2.enable(enable);
        inputEmail.enable(enable);
        inputLegalName.enable(enable);
        inputName.enable(enable);
        inputPhone.enable(enable);
        selectStatus.enable(enable);
        inputAddress.enable(enable);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField inputAddress;
    private javax.swing.JTextField inputCel;
    private javax.swing.JTextField inputDocument1;
    private javax.swing.JTextField inputDocument2;
    private javax.swing.JTextField inputEmail;
    private javax.swing.JTextField inputLegalName;
    private javax.swing.JTextField inputName;
    private javax.swing.JTextField inputPhone;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JLabel labelAddress;
    private javax.swing.JLabel labelCel;
    private javax.swing.JLabel labelDocument1;
    private javax.swing.JLabel labelDocument2;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelLegalName;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelPhone;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JPanel panelAddress;
    private javax.swing.JPanel panelContact;
    private javax.swing.JComboBox selectStatus;
    // End of variables declaration//GEN-END:variables
}
