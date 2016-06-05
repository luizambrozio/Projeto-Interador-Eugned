package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RelatorioPaciente extends JInternalFrame {
	private JTextField jtdataInicialP;
	private JTextField jtdatafimP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioPaciente frame = new RelatorioPaciente();
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
	public RelatorioPaciente() {
		setClosable(true);
		setBounds(100, 100, 552, 238);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Relat\u00F3rio Pacientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(68, Short.MAX_VALUE))
		);
		
		JRadioButton rdbtnTodos = new JRadioButton("Todos");
		
		JRadioButton rdbtnDiaginosticadoEmUm = new JRadioButton("Diaginosticados em um periodo");
		
		JLabel lblInformeOPeriodo = new JLabel("Informe o periodo");
		
		jtdataInicialP = new JTextField();
		jtdataInicialP.setColumns(10);
		
		JButton jbCalendarioFim = new JButton(".");
		
		jtdatafimP = new JTextField();
		jtdatafimP.setColumns(10);
		
		JButton jbcalendarFim = new JButton(".");
		
		JButton jbImprimir = new JButton("Imprimir");
		
		JButton jbVoltar = new JButton("Voltar");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnTodos)
								.addComponent(rdbtnDiaginosticadoEmUm)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(57)
							.addComponent(lblInformeOPeriodo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jtdataInicialP, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
									.addComponent(jbImprimir)
									.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
									.addComponent(jbVoltar))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(jbCalendarioFim)
									.addGap(18)
									.addComponent(jtdatafimP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(jbcalendarFim)))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(rdbtnTodos)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnDiaginosticadoEmUm)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInformeOPeriodo)
						.addComponent(jtdataInicialP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jbCalendarioFim)
						.addComponent(jtdatafimP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jbcalendarFim))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(jbVoltar)
						.addComponent(jbImprimir))
					.addContainerGap(82, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}
}
