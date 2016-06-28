package view;

import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Event;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import controller.FocoController;
import controller.IncidenteController;
import dao.IncidenteEnderecoDAO;
import dao.PacienteDAO;
import exception.FocoException;
import exception.IncidenteException;
import model.Endereco;
import model.Foco;
import model.Incidente;
import model.IncidenteEndereco;
import model.IncidenteEnderecoTableModel;
import model.IncidenteTableModel;
import model.Paciente;
import util.MaskFields;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;

public class CadastroIncidenteUI extends JInternalFrame {
	private static CadastroIncidenteUI instancia;
	private JTextField jtfBuscaNomePacienteIncidente;
	private JFormattedTextField jtfDataIncidente;
	private JFormattedTextField jtfDataSintoma;
	private JTextArea jtaSintomas;
	private SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
	private MaskFields maskFields = new MaskFields();
	private JTable jtListaIncidenteEnderecos;
	private Incidente incidente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroIncidenteUI frame = new CadastroIncidenteUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static CadastroIncidenteUI getInstance() {
		if(instancia == null) {
			instancia =  new CadastroIncidenteUI();
		}
		return instancia;
		
	}
	
	/**
	 * Create the frame.
	 */
	public CadastroIncidenteUI() {
		setTitle("Registra Incidente");
		setClosable(true);
		setBounds(100, 100, 565, 475);

		JPanel jpCadastroIncidente = new JPanel();
		jpCadastroIncidente.setBounds(12, 12, 531, 419);
		jpCadastroIncidente.setBorder(new TitledBorder(null, "Cadastro Incidente", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JLabel jlNomePacienteIncidente = new JLabel("Nome");

		jtfBuscaNomePacienteIncidente = new JTextField();
		jtfBuscaNomePacienteIncidente.setColumns(10);

		JLabel jllDataIncidente = new JLabel("Data Inicidente");

		jtfDataIncidente = new JFormattedTextField();
		try {
			maskFields.maskData(jtfDataIncidente);
		} catch (ParseException e2) {
			JOptionPane.showMessageDialog(null, "Impossível aplicar máscara de data");
			e2.printStackTrace();
		}
		jtfDataIncidente.setColumns(10);

		jtfDataSintoma = new JFormattedTextField();
		try {
			maskFields.maskData(jtfDataSintoma);
		} catch (ParseException e2) {
			JOptionPane.showMessageDialog(null, "Impossível aplicar máscara de data");
			e2.printStackTrace();
		}
		jtfDataSintoma.setColumns(10);

		JLabel jlDataSintoma = new JLabel("Data Sintoma");

		JPanel jpEnderecosDoIncidente = new JPanel();
		jpEnderecosDoIncidente.setBorder(new TitledBorder(null, "Endere\u00E7os", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel jpSintomas = new JPanel();
		jpSintomas.setBorder(new TitledBorder(null, "Sintomas", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JButton jbNovoEnderecoIncidente = new JButton("Novo");
		jbNovoEnderecoIncidente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroEnderecoIncidenteUI cadastroEnderecoIncidenteUI = CadastroEnderecoIncidenteUI.getInstace();
				// Passa null porque é inserção
				cadastroEnderecoIncidenteUI.setIncidenteEndereco(null);
				cadastroEnderecoIncidenteUI.setFocusable(true);
				cadastroEnderecoIncidenteUI.requestFocus();
				// Seta o incidente para que o endereço saiba para qual incidente registrar.
				cadastroEnderecoIncidenteUI.setIncidente(incidente);
				PrincipalUI.getInstance().getFrame().getContentPane().add(cadastroEnderecoIncidenteUI,0);
				cadastroEnderecoIncidenteUI.setVisible(true);
			
			}
		});

		JButton jbAlterarEnderecoIncidente = new JButton("Alterar");
		jbAlterarEnderecoIncidente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IncidenteEndereco ie;
				try {
					ie = new IncidenteEnderecoTableModel(
							new IncidenteEnderecoDAO().getEnderecosIncidentes(incidente)
							).get(jtListaIncidenteEnderecos.getSelectedRow());
					CadastroEnderecoIncidenteUI cadastroEnderecoIncidenteUI = CadastroEnderecoIncidenteUI.getInstace();
					cadastroEnderecoIncidenteUI.setIncidenteEndereco(ie);
					cadastroEnderecoIncidenteUI.setFocusable(true);
					cadastroEnderecoIncidenteUI.requestFocus();
					// Seta o incidente para que o endereço saiba para qual incidente registrar.
					cadastroEnderecoIncidenteUI.setIncidente(incidente);
					PrincipalUI.getInstance().getFrame().getContentPane().add(cadastroEnderecoIncidenteUI,0);
					cadastroEnderecoIncidenteUI.setVisible(true);
				} catch (IncidenteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JButton jbExcluirEnderecoIncidente = new JButton("Excluir");
		jbExcluirEnderecoIncidente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("Incidente Endereço: Excluindo");
					IncidenteEndereco ieExclui = new IncidenteEnderecoTableModel(
							new IncidenteEnderecoDAO().getEnderecosIncidentes(incidente)
							).get(jtListaIncidenteEnderecos.getSelectedRow());
					
					System.out.println("Incidente: " + ieExclui.getId());
					System.out.println("Linha Selecionado: " + jtListaIncidenteEnderecos.getSelectedRow());

					new IncidenteEnderecoDAO().excluir(ieExclui.getId());
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

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(incidente==null) {
					incidente =  new Incidente();
				}
				try {
					if(incidente.getId() == 0) {
						System.out.println("Incidente: Inserindo...");
						incidente.setPaciente((new PacienteDAO().getListaPacientesByNome(jtfBuscaNomePacienteIncidente.getText())).get(0));
						incidente.setDataIncidente(formatData.parse(jtfDataIncidente.getText()));
						incidente.setDataSintoma(formatData.parse(jtfDataIncidente.getText()));
						incidente.setSintomas(jtaSintomas.getText());

						new IncidenteController().inserir(incidente);
						JOptionPane.showMessageDialog(null, "Incidente cadastrado com sucesso!");
						ListaIncidenteUI.getInstance().atualizaLista();
						//dispose();
					} else {
						System.out.println("Incidente: Alterando...");
						Paciente p = (new PacienteDAO().getListaPacientesByNome(jtfBuscaNomePacienteIncidente.getText())).get(0);
						if(p.getId() != incidente.getPaciente().getId()) {
							incidente.setPaciente((new PacienteDAO().getListaPacientesByNome(jtfBuscaNomePacienteIncidente.getText())).get(0));
						}
						incidente.setDataIncidente(formatData.parse(jtfDataIncidente.getText()));
						incidente.setDataSintoma(formatData.parse(jtfDataIncidente.getText()));
						incidente.setSintomas(jtaSintomas.getText());						

						new IncidenteController().editar(incidente);
						ListaIncidenteUI.getInstance().atualizaLista();
						CadastroIncidenteUI.getInstance().show();
						// dispose();
					}
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (IncidenteException e1) {
					System.out.println("Incidente: Erro no salvamento: " + e1.getMessage());
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		getContentPane().setLayout(null);
		GroupLayout gl_jpCadastroIncidente = new GroupLayout(jpCadastroIncidente);
		gl_jpCadastroIncidente.setHorizontalGroup(
				gl_jpCadastroIncidente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadastroIncidente.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_jpCadastroIncidente.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jpCadastroIncidente.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_jpCadastroIncidente.createSequentialGroup()
												.addComponent(jlNomePacienteIncidente)
												.addGap(18)
												.addComponent(jtfBuscaNomePacienteIncidente, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_jpCadastroIncidente.createSequentialGroup()
												.addComponent(jllDataIncidente)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(jtfDataIncidente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jlDataSintoma)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(jtfDataSintoma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(40)))
								.addGroup(gl_jpCadastroIncidente.createSequentialGroup()
										.addComponent(jbNovoEnderecoIncidente)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(jbAlterarEnderecoIncidente)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(jbExcluirEnderecoIncidente))
								.addGroup(gl_jpCadastroIncidente.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(jpEnderecosDoIncidente, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
										.addComponent(btnSalvar)
										.addComponent(jpSintomas, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)))
						.addContainerGap())
				);
		gl_jpCadastroIncidente.setVerticalGroup(
				gl_jpCadastroIncidente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadastroIncidente.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_jpCadastroIncidente.createParallelGroup(Alignment.BASELINE)
								.addComponent(jlNomePacienteIncidente)
								.addComponent(jtfBuscaNomePacienteIncidente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_jpCadastroIncidente.createParallelGroup(Alignment.BASELINE)
								.addComponent(jllDataIncidente)
								.addComponent(jlDataSintoma)
								.addComponent(jtfDataSintoma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jtfDataIncidente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addComponent(jpSintomas, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnSalvar)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(jpEnderecosDoIncidente, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_jpCadastroIncidente.createParallelGroup(Alignment.BASELINE)
								.addComponent(jbNovoEnderecoIncidente)
								.addComponent(jbAlterarEnderecoIncidente)
								.addComponent(jbExcluirEnderecoIncidente))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		jtaSintomas = new JTextArea();
		jtaSintomas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GroupLayout gl_jpSintomas = new GroupLayout(jpSintomas);
		gl_jpSintomas.setHorizontalGroup(
				gl_jpSintomas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpSintomas.createSequentialGroup()
						.addContainerGap()
						.addComponent(jtaSintomas, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
						.addContainerGap())
				);
		gl_jpSintomas.setVerticalGroup(
				gl_jpSintomas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpSintomas.createSequentialGroup()
						.addContainerGap()
						.addComponent(jtaSintomas, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
						.addContainerGap())
				);
		jpSintomas.setLayout(gl_jpSintomas);

		JScrollPane jscrpEnderecoIncidente = new JScrollPane();
		GroupLayout gl_jpEnderecoPacienteIncidente = new GroupLayout(jpEnderecosDoIncidente);
		gl_jpEnderecoPacienteIncidente.setHorizontalGroup(
				gl_jpEnderecoPacienteIncidente.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_jpEnderecoPacienteIncidente.createSequentialGroup()
						.addContainerGap()
						.addComponent(jscrpEnderecoIncidente, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
						.addContainerGap())
				);
		gl_jpEnderecoPacienteIncidente.setVerticalGroup(
				gl_jpEnderecoPacienteIncidente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpEnderecoPacienteIncidente.createSequentialGroup()
						.addContainerGap()
						.addComponent(jscrpEnderecoIncidente, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		jtListaIncidenteEnderecos = new JTable();
		jscrpEnderecoIncidente.setViewportView(jtListaIncidenteEnderecos);		
		jpEnderecosDoIncidente.setLayout(gl_jpEnderecoPacienteIncidente);
		jpCadastroIncidente.setLayout(gl_jpCadastroIncidente);
		getContentPane().add(jpCadastroIncidente);

		preencheDados(incidente);
		
		

	}
	/**
	 * Metodo responsável pelo preenchimento dos campos na tela
	 * @param incidente
	 */
	private void preencheDados(Incidente incidente) {
		System.out.println(incidente);
		if(incidente != null) {
			jtfBuscaNomePacienteIncidente.setText(incidente.getPaciente().getNome());
			jtfDataIncidente.setText(new SimpleDateFormat("dd/MM/yyyy").format(incidente.getDataIncidente()));
			jtfDataSintoma.setText(new SimpleDateFormat("dd/MM/yyyy").format(incidente.getDataSintoma()));
			jtaSintomas.setText(incidente.getSintomas());
		} else {
			jtfBuscaNomePacienteIncidente.setText("");
			jtfDataIncidente.setText("");
			jtfDataSintoma.setText("");
			jtaSintomas.setText("");
		}
		atualizaLista();
	}

	public void atualizaLista() {
		jtListaIncidenteEnderecos.setModel(
				new IncidenteEnderecoTableModel(
						new IncidenteController().getListaIncidentesEnderecos(incidente)));
		// new IncidenteController().getListaIncidentes()
	}

	public Incidente getIncidente() {
		return incidente;
	}

	public void setIncidente(Incidente incidente) {
		this.incidente = incidente;
		preencheDados(incidente);
	}


}
