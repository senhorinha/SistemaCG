/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.dialogs;

import javax.swing.JDialog;

import modelo.Coordenada;
import view.Validador;

/**
 *
 * @author thiago
 */
public class AdicionarPontoCurvaDialog extends javax.swing.JDialog {

	private JDialog dialogoPai;

	/**
	 * Creates new form AdicionarPontoDialog
	 * 
	 * @param numeroDePontosDeControleDeBezier
	 * @param numeroDePontosNormais
	 */
	public AdicionarPontoCurvaDialog(java.awt.Frame parent, javax.swing.JDialog dialogoPai, boolean modal,
			int numeroDePontosDeControleDeBezier, int numeroDePontosNormais) {
		super(parent, modal);
		initComponents();
		this.dialogoPai = dialogoPai;
		if (numeroDePontosDeControleDeBezier == 2) {
			this.controleCheckBox.setEnabled(false);
		}

		if (numeroDePontosNormais == 2) {
			this.controleCheckBox.setSelected(true);
			this.controleCheckBox.setEnabled(false);
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		botaoCancelar = new javax.swing.JButton();
		botaoSalvar = new javax.swing.JButton();
		curvaPontoXLabel = new javax.swing.JLabel();
		curvaPontoYLabel = new javax.swing.JLabel();
		curvaPontoXTextField = new javax.swing.JTextField();
		curvaPontoYTextField = new javax.swing.JTextField();
		controleLabel = new javax.swing.JLabel();
		controleCheckBox = new javax.swing.JCheckBox();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Adicionar Ponto");
		setResizable(false);

		botaoCancelar.setText("Cancelar");
		botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botaoCancelarActionPerformed(evt);
			}
		});

		botaoSalvar.setText("Salvar");
		botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botaoSalvarActionPerformed(evt);
			}
		});

		curvaPontoXLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
		curvaPontoXLabel.setText("X:");

		curvaPontoYLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
		curvaPontoYLabel.setText("Y:");

		curvaPontoXTextField.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				poligonoPontoXTextFieldActionPerformed(evt);
			}
		});

		controleLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
		controleLabel.setText("Controle?");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(controleLabel)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(controleCheckBox))
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						botaoSalvar,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						72,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										curvaPontoXLabel)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										curvaPontoXTextField,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										66,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										curvaPontoYLabel)))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						curvaPontoYTextField,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						66,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(botaoCancelar))))
								.addGap(0, 2, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(curvaPontoXTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(curvaPontoXLabel)
										.addComponent(curvaPontoYLabel)
										.addComponent(curvaPontoYTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(10, 10, 10)
						.addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(controleLabel).addComponent(controleCheckBox))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(botaoSalvar).addComponent(botaoCancelar)).addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void poligonoPontoXTextFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_poligonoPontoXTextFieldActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_poligonoPontoXTextFieldActionPerformed

	private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botaoCancelarActionPerformed
		this.dispose();
	}// GEN-LAST:event_botaoCancelarActionPerformed

	private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botaoSalvarActionPerformed
		boolean semErros = true;
		semErros = Validador.validarInteiro(curvaPontoXTextField, curvaPontoXLabel);
		semErros &= Validador.validarInteiro(curvaPontoYTextField, curvaPontoYLabel);
		if (semErros) {
			int x = Integer.parseInt(curvaPontoXTextField.getText());
			int y = Integer.parseInt(curvaPontoYTextField.getText());
			Coordenada coordenada = new Coordenada(x, y);
			((AdicionarFormaDialog) dialogoPai).adicionarCoordenadaACurva(coordenada,
					this.controleCheckBox.isSelected());
			this.dispose();
		}

	}// GEN-LAST:event_botaoSalvarActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton botaoCancelar;
	private javax.swing.JButton botaoSalvar;
	private javax.swing.JCheckBox controleCheckBox;
	private javax.swing.JLabel controleLabel;
	private javax.swing.JLabel curvaPontoXLabel;
	private javax.swing.JTextField curvaPontoXTextField;
	private javax.swing.JLabel curvaPontoYLabel;
	private javax.swing.JTextField curvaPontoYTextField;
	// End of variables declaration//GEN-END:variables
}
