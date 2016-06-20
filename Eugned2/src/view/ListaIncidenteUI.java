package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import controller.IncidenteController;
import dao.IncidenteDAO;
import dao.PacienteDAO;
import exception.IncidenteException;
import model.Incidente;
import model.IncidenteTableModel;
import model.PacienteTableModel;
import util.MaskFields;

public class ListaIncidenteUI extends JInternalFrame {
	
	private static ListaIncidenteUI instancia;
	private JFormattedTextField jtfDataIniIncidentes;
	private JFormattedTextField jtfDataFim; 
	private SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
	private MaskFields maskFields = new MaskFields();
	private JTable jtListaIncidente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ListaIncidenteUI frame = ListaIncidenteUI.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Obrigatório
	public static ListaIncidenteUI getInstance(){
		if(instancia == null) {
			instancia = new ListaIncidenteUI();
		} 
		return instancia;
	}
	/**
	 * Create the frame.
	 */
	public ListaIncidenteUI() {
		setClosable(true);
		setTitle("Consulta Incidentes");
		setBounds(100, 100, 600, 400);
		
		JPanel jpListaIncidente = new JPanel();
		jpListaIncidente.setBorder(new TitledBorder(null, "Lista Incidentes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpListaIncidente, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(572, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpListaIncidente, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel jlPeriodo = new JLabel("Periodo");
		
		jtfDataIniIncidentes = new JFormattedTextField();
		try {
			maskFields.maskData(jtfDataIniIncidentes);
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Impossível aplicar máscara");
			e1.printStackTrace();
		}
		jtfDataIniIncidentes.setColumns(10);
		
		JLabel lblAt = new JLabel("até");
		
		jtfDataFim = new JFormattedTextField();
		try {
			maskFields.maskData(jtfDataFim);
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Impossível aplicar máscara");
			e1.printStackTrace();
		}
		jtfDataFim.setColumns(10);
		
		// Chama ação de FIltro
		JButton jbBuscar = new JButton("Buscar");
		jbBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaLista();
			}
		});
		
		// Chama ação de Inserir
		JButton jbNovoIncidente = new JButton("Novo");
		jbNovoIncidente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroIncidenteUI cadIncidente = new CadastroIncidenteUI(null);
				cadIncidente.setFocusable(true);
				cadIncidente.requestFocus();
				PrincipalUI.getInstance().getFrame().getContentPane().add(cadIncidente, 0);
				cadIncidente.setVisible(true);	
			}
		});

		JScrollPane jspListaIncidente = new JScrollPane();
		
		// Chama ação de Editar
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Incidente i;
					i = new IncidenteTableModel(
							new IncidenteController().getListaIncidentes()
							).get(jtListaIncidente.getSelectedRow());
					CadastroIncidenteUI cadIncidenteUi = new CadastroIncidenteUI(i);
					cadIncidenteUi.setFocusable(true);
					cadIncidenteUi.requestFocus();
					PrincipalUI.getInstance().getFrame().getContentPane().add(cadIncidenteUi, 0);
					cadIncidenteUi.setVisible(true);
					
				} catch (IncidenteException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}


				
			}
		});
		
		// Chama Ação de Excluir
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("Incidente: Excluindo");
					Incidente i = 
							new IncidenteTableModel(
									new IncidenteController().getListaIncidentes()
									).get(jtListaIncidente.getSelectedRow());

					new IncidenteController().excluir(i.getId());
					JOptionPane.showMessageDialog(null, "Incidente excluído com sucesso");
					atualizaLista();
					//jtListaIncidente.setModel(
					//		new IncidenteTableModel(
					//				new IncidenteController().getListaIncidentes()));
				} catch (IncidenteException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

				
			}
		});
		
		// Chama Ação de Limpar Filtro
		JButton jbtLimparFiltro = new JButton("Limpar");
		jbtLimparFiltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtfDataIniIncidentes.setText("");
				jtfDataFim.setText("");
				atualizaLista();
			}
		});
		GroupLayout gl_jpListaIncidente = new GroupLayout(jpListaIncidente);
		gl_jpListaIncidente.setHorizontalGroup(
			gl_jpListaIncidente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpListaIncidente.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpListaIncidente.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_jpListaIncidente.createSequentialGroup()
							.addComponent(jlPeriodo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jtfDataIniIncidentes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAt, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(jtfDataFim, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jbBuscar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jbtLimparFiltro, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addGap(35))
						.addGroup(gl_jpListaIncidente.createSequentialGroup()
							.addComponent(jspListaIncidente, GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
							.addGap(21))
						.addGroup(gl_jpListaIncidente.createSequentialGroup()
							.addComponent(jbNovoIncidente, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(243))))
		);
		gl_jpListaIncidente.setVerticalGroup(
			gl_jpListaIncidente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpListaIncidente.createSequentialGroup()
					.addGroup(gl_jpListaIncidente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpListaIncidente.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_jpListaIncidente.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_jpListaIncidente.createSequentialGroup()
									.addGroup(gl_jpListaIncidente.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_jpListaIncidente.createParallelGroup(Alignment.BASELINE)
											.addComponent(jtfDataFim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(jbBuscar)
											.addComponent(jbtLimparFiltro))
										.addComponent(jtfDataIniIncidentes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(9))
								.addGroup(gl_jpListaIncidente.createSequentialGroup()
									.addComponent(jlPeriodo)
									.addGap(11)))
							.addComponent(jspListaIncidente, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_jpListaIncidente.createParallelGroup(Alignment.BASELINE)
								.addComponent(jbNovoIncidente)
								.addComponent(btnEditar)
								.addComponent(btnExcluir)))
						.addGroup(gl_jpListaIncidente.createSequentialGroup()
							.addGap(17)
							.addComponent(lblAt)))
					.addGap(8))
		);

		//JPanel panel = new JPanel();
		
		jtListaIncidente = new JTable();
		atualizaLista();
		//jtListaIncidente.setModel(
		//		new IncidenteTableModel(new IncidenteDAO().getListaIncidentes()));
		jspListaIncidente.setViewportView(jtListaIncidente);		
		jpListaIncidente.setLayout(gl_jpListaIncidente);
		getContentPane().setLayout(groupLayout);

	}

	public void atualizaLista() {
		System.out.println(jtfDataIniIncidentes.getText());
		if(jtfDataIniIncidentes.getText().equals("__/__/____") || jtfDataFim.getText().equals("__/__/____")) {
			jtListaIncidente.setModel(
					new IncidenteTableModel(
							new IncidenteController().getListaIncidentes()));		
		} else {
			Date dataIni;
			Date dataFim;
			try {
				dataIni = new SimpleDateFormat("dd/MM/yyyy").parse(jtfDataIniIncidentes.getText());
				dataFim = new SimpleDateFormat("dd/MM/yyyy").parse(jtfDataFim.getText());
				jtListaIncidente.setModel(
						new IncidenteTableModel(
								new IncidenteController().getListaIncidentesByData(dataIni, dataFim)));
			} catch (ParseException | IncidenteException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				e1.printStackTrace();
			}
		}
	}
}
