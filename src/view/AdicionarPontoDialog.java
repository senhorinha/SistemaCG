/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import javax.swing.JDialog;

import modelo.Coordenada;

/**
 *
 * @author thiago
 */
public class AdicionarPontoDialog extends javax.swing.JDialog {

	private JDialog dialogoPai;

	/**
	 * Creates new form AdicionarPontoDialog
	 */
	public AdicionarPontoDialog(java.awt.Frame parent,
			javax.swing.JDialog dialogoPai, boolean modal) {
		super(parent, modal);
		this.dialogoPai = dialogoPai;
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoCancelar = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        poligonoPontoXLabel = new javax.swing.JLabel();
        poligonoPontoYLabel = new javax.swing.JLabel();
        poligonoPontoXTextField = new javax.swing.JTextField();
        poligonoPontoYTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Ponto");
        setResizable(false);

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        poligonoPontoXLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        poligonoPontoXLabel.setText("X:");

        poligonoPontoYLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        poligonoPontoYLabel.setText("Y:");

        poligonoPontoXTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poligonoPontoXTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(poligonoPontoXLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(poligonoPontoXTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(poligonoPontoYLabel))
                    .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(poligonoPontoYTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(poligonoPontoXLabel)
                    .addComponent(poligonoPontoYLabel)
                    .addComponent(poligonoPontoYTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(poligonoPontoXTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void poligonoPontoXTextFieldActionPerformed(
			java.awt.event.ActionEvent evt) {// GEN-FIRST:event_poligonoPontoXTextFieldActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_poligonoPontoXTextFieldActionPerformed

	private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botaoCancelarActionPerformed
		this.dispose();
	}// GEN-LAST:event_botaoCancelarActionPerformed

	private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botaoSalvarActionPerformed
		boolean semErros = true;
		semErros = Validador.validarInteiro(poligonoPontoXTextField,
				poligonoPontoXLabel);
		semErros &= Validador.validarInteiro(poligonoPontoYTextField,
				poligonoPontoYLabel);
		if (semErros) {
			int x = Integer.parseInt(poligonoPontoXTextField.getText());
			int y = Integer.parseInt(poligonoPontoXTextField.getText());
			Coordenada coordenada = new Coordenada(x, y);
			((AdicionarFormaDialog) dialogoPai)
					.adicionarCoordenadaAoPoligono(coordenada);
			this.dispose();
		}

	}// GEN-LAST:event_botaoSalvarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JLabel poligonoPontoXLabel;
    private javax.swing.JTextField poligonoPontoXTextField;
    private javax.swing.JLabel poligonoPontoYLabel;
    private javax.swing.JTextField poligonoPontoYTextField;
    // End of variables declaration//GEN-END:variables
}
