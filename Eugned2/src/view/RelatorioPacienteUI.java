package view;

import java.awt.EventQueue;
import java.text.ParseException;
import java.util.HashMap;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import util.ConnectionUtil;
import util.MaskFields;

import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RelatorioPacienteUI extends JInternalFrame {
	private JFormattedTextField jtdataInicialP;
	private JFormattedTextField jtdatafimP;
	private MaskFields maskFields = new MaskFields();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioPacienteUI frame = new RelatorioPacienteUI();
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
	public RelatorioPacienteUI() {
		setClosable(true);
		setBounds(100, 100, 486, 197);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Relat\u00F3rio Pacientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(73, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblInformeOPeriodo = new JLabel("Informe o periodo");
		
		jtdataInicialP = new JFormattedTextField();
		try {
			maskFields.maskData(jtdataInicialP);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Impossível aplicar máscara");
			e.printStackTrace();
		}
		jtdataInicialP.setColumns(10);
		
		JButton jbCalendarioFim = new JButton(".");
		
		jtdatafimP = new JFormattedTextField();
		try {
			maskFields.maskData(jtdatafimP);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Impossível aplicar máscara");
			e.printStackTrace();
		}
		jtdatafimP.setColumns(10);
		
		JButton jbcalendarFim = new JButton(".");
		
		JButton jbImprimir = new JButton("Imprimir");
		jbImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HashMap hm = new HashMap<>();
				
				try {
					JasperPrint	jp = JasperFillManager.fillReport("/home/wagmattei/git/Projeto-Interador-Eugned/Eugned2/src/view/RelatorioPaciente2.jasper", new HashMap<>(),ConnectionUtil.getConnection());
					JasperViewer.viewReport(jp, false);
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton jbVoltar = new JButton("Voltar");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInformeOPeriodo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jtdataInicialP, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jbCalendarioFim)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jtdatafimP, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jbcalendarFim)
					.addContainerGap(77, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(238, Short.MAX_VALUE)
					.addComponent(jbImprimir)
					.addGap(18)
					.addComponent(jbVoltar)
					.addGap(84))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInformeOPeriodo)
						.addComponent(jtdataInicialP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jbCalendarioFim)
						.addComponent(jtdatafimP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jbcalendarFim))
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(jbImprimir)
						.addComponent(jbVoltar))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}
}
