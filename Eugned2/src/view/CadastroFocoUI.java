package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class CadastroFocoUI extends JInternalFrame {
	private JTextField jtfDataFoco;
	private JTextField jtfRuaFoco;
	private JTextField textField_1;
	private JTextField jtfBairroFoco;
	private JTextField jtfCep;
	private JTextField htfCidadeFoco;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFocoUI frame = new CadastroFocoUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroFocoUI() {
		setBounds(100, 100, 544, 292);
		getContentPane().setLayout(null);
		
		JPanel jpFoco = new JPanel();
		jpFoco.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Foco", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		jpFoco.setBounds(12, 12, 510, 236);
		getContentPane().add(jpFoco);
		
		JLabel lblDataFoco = new JLabel("Data:");
		
		jtfDataFoco = new JTextField();
		jtfDataFoco.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Novo Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel jlbRuaFoco = new JLabel("Rua:");
		
		jtfRuaFoco = new JTextField();
		jtfRuaFoco.setColumns(10);
		
		JLabel jlbNumero = new JLabel("Nº");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel jlbBairroFoco = new JLabel("Bairro:");
		
		jtfBairroFoco = new JTextField();
		jtfBairroFoco.setColumns(10);
		
		JLabel jlbCepFoco = new JLabel("CEP:");
		
		jtfCep = new JTextField();
		jtfCep.setColumns(10);
		
		JLabel label_4 = new JLabel("Estado:");
		
		JLabel label_5 = new JLabel("Cidade:");
		
		JButton button = new JButton("Salvar");
		
		JButton button_1 = new JButton("Cancelar");
		
		htfCidadeFoco = new JTextField();
		htfCidadeFoco.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_5)
								.addComponent(jlbBairroFoco)
								.addComponent(jlbRuaFoco))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(jtfRuaFoco, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
								.addComponent(jtfBairroFoco, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
								.addComponent(htfCidadeFoco, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(jlbNumero)
								.addComponent(label_4)
								.addComponent(jlbCepFoco))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addComponent(jtfCep, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(120)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button_1)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlbRuaFoco)
						.addComponent(jtfRuaFoco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jlbNumero)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlbBairroFoco)
						.addComponent(jtfBairroFoco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jlbCepFoco)
						.addComponent(jtfCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(label_4)
						.addComponent(htfCidadeFoco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(button_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_jpFoco = new GroupLayout(jpFoco);
		gl_jpFoco.setHorizontalGroup(
			gl_jpFoco.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpFoco.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpFoco.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 483, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_jpFoco.createSequentialGroup()
							.addComponent(lblDataFoco)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(jtfDataFoco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_jpFoco.setVerticalGroup(
			gl_jpFoco.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpFoco.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpFoco.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataFoco)
						.addComponent(jtfDataFoco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		jpFoco.setLayout(gl_jpFoco);

	}
}
