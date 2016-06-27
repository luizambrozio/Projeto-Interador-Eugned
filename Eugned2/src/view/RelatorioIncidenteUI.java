package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

public class RelatorioIncidenteUI extends JInternalFrame {
	private JFormattedTextField jtdataInicialP;
	private JFormattedTextField jtdatafimP;
	private MaskFields maskFields = new MaskFields();
	private SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioIncidenteUI frame = new RelatorioIncidenteUI();
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
	public RelatorioIncidenteUI() {
		setClosable(true);
		setBounds(100, 100, 552, 238);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Relatório Incidentes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Map hm = new HashMap<>();
				
				try {
					
					Date dataInicial = new Date();
					Date dataFinal = new Date();
					if(rdbtnTodos.isSelected()) {
						hm.put("paramFiltrar", false);
					} else {
						hm.put("paramFiltrar", true);				    	
						dataFinal = formatData.parse(jtdatafimP.getText());
						dataInicial = formatData.parse(jtdataInicialP.getText());
					}
					// /home/wagmattei/git/Projeto-Interador-Eugned/Eugned2/src/
				    hm.put("paramDataInicial", dataInicial);
				    hm.put("paramDataFinal", dataFinal);
					JasperPrint jp =  JasperFillManager.fillReport("/home/wagmattei/git/Projeto-Interador-Eugned/Eugned2/src/view/RelatorioIncidentes.jasper", hm,ConnectionUtil.getConnection());
					JasperViewer.viewReport(jp, false);
				} catch (ParseException e2) {
					JOptionPane.showMessageDialog(null, "Data inválida");
				} catch (JRException e1) {
					JOptionPane.showMessageDialog(null, "Problemas ao Carregar o Relatório.");
					e1.printStackTrace();
				}
				
			}
		});
		
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
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(31)
									.addComponent(lblInformeOPeriodo)
									.addGap(3)
									.addComponent(jtdataInicialP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(jbCalendarioFim)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
									.addContainerGap(234, Short.MAX_VALUE)
									.addComponent(jbImprimir)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(jbVoltar)
									.addGap(18))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(jtdatafimP, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
									.addGap(46)))
							.addComponent(jbcalendarFim)
							.addGap(25)))
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
						.addComponent(jbImprimir)
						.addComponent(jbVoltar))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}
}
