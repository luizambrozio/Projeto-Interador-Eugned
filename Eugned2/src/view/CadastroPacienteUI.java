package view;

import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import controller.EnderecoController;
import controller.FocoController;
import controller.PacienteController;
import controller.PacienteEnderecoController;
import dao.FocoDAO;
import dao.PacienteDAO;
import dao.PacienteEnderecoDAO;
import exception.EnderecoException;
import exception.FocoException;
import exception.PacienteException;
import model.Endereco;
import model.EnderecoTableModel;
import model.EnumCorRaca;
import model.EnumEscolaridade;
import model.EnumEstadoCivil;
import model.EnumSexo;
import model.EnumTipoEndereco;
import model.Foco;
import model.FocoTableModel;
import model.Paciente;
import model.PacienteEndereco;
import model.PacienteEnderecoTableModel;
import model.PacienteTableModel;
import util.MaskFields;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.lang.reflect.GenericArrayType;
import java.awt.event.ActionEvent;

public class CadastroPacienteUI extends JInternalFrame {
	private JTextField jtfNome;
	private JFormattedTextField jtfCpf;
	private JFormattedTextField jtfRg;
	private JFormattedTextField jtfDataNascimento;
	private JTextField jtfRenda;
	private MaskFields maskFields = new MaskFields();
	private JTable jtListaPacienteEndereco;
	private JComboBox jcbEstadoCivil;
	private JComboBox jcbEscolaridade;
	private JComboBox jcbCor;
	private JComboBox jcbSexo;
	private SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
	private static CadastroPacienteUI instancia;
	private Paciente paciente;
	private Endereco endereco;
	private JCheckBox cboxGestante;

	public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
		
		preencheDados(paciente);
	}


	public Endereco getEndereco(){
		return endereco;
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPacienteUI frame = getInstace();
					frame.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static CadastroPacienteUI getInstace(){
		if(instancia==null){
			instancia = new CadastroPacienteUI();
		}
		return instancia;
	}


	/**
	 * Create the frame.
	 */
	public CadastroPacienteUI() {
		//		paciente = p;
		setClosable(true);
		setBounds(100, 100, 800, 600);	
		JPanel JPcadastroPaciente = new JPanel();
		JPcadastroPaciente.setBorder(new TitledBorder(null, "Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(JPcadastroPaciente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap())
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(JPcadastroPaciente, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(163, Short.MAX_VALUE))
				);

		JLabel jlNome = new JLabel("Nome:");

		JLabel jlCpf = new JLabel("CPF:");

		JLabel jlRg = new JLabel("RG:");

		JLabel jlEscolaridade = new JLabel("Escolaridade:");

		JLabel jlEstadoCivil = new JLabel("Estado Civil");

		jtfNome = new JTextField();
		jtfNome.setColumns(10);

		jtfCpf = new JFormattedTextField();
		try {
			maskFields.maskCpf(jtfCpf);
		} catch (ParseException e2) {
			JOptionPane.showMessageDialog(null, "Impossível aplicar máscara");
			e2.printStackTrace();
		}
		jtfCpf.setColumns(10);

		jtfRg = new JFormattedTextField();
		try {
			maskFields.maskRg(jtfRg);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Impossível aplicar máscara");
			e.printStackTrace();
		}
		jtfRg.setColumns(10);


		jcbEstadoCivil = new JComboBox();
		DefaultComboBoxModel<EnumEstadoCivil> comboBoxModelEstadoCivil = new DefaultComboBoxModel<>();
		for (EnumEstadoCivil e : EnumEstadoCivil.values()) {
			comboBoxModelEstadoCivil.addElement(e);			
		}
		jcbEstadoCivil.setModel(comboBoxModelEstadoCivil);

		//Inserir valore do enum no combobox

		JLabel jlSexo = new JLabel("Sexo");

		jcbSexo = new JComboBox();
		DefaultComboBoxModel<EnumSexo> comboBoxModelSexo = new DefaultComboBoxModel<>();
		for (EnumSexo e : EnumSexo.values()) {
			comboBoxModelSexo.addElement(e);			
		}		
		jcbSexo.setModel(comboBoxModelSexo);



		JLabel jlCor = new JLabel("Cor/Raca");		

		jcbCor = new JComboBox();
		DefaultComboBoxModel<EnumCorRaca> comboBoxModelCor = new DefaultComboBoxModel<>();
		for (EnumCorRaca e : EnumCorRaca.values()) {
			comboBoxModelCor.addElement(e);			
		}		
		jcbCor.setModel(comboBoxModelCor);




		JLabel jlDataNascimento = new JLabel("Data Nascimento");

		jtfDataNascimento = new JFormattedTextField();
		try {
			maskFields.maskData(jtfDataNascimento);
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Impossível aplicar máscara");
			e1.printStackTrace();
		}		

		JLabel jlRenda = new JLabel("Renda");

		jtfRenda = new JTextField();
		jtfRenda.setColumns(10);

		cboxGestante = new JCheckBox("Gestante");

		JButton jbNovoPaciente = new JButton("Novo");
		jbNovoPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				CadastroEnderecoUI cadEndereco = new CadastroEnderecoUI(paciente, null, null);
				cadEndereco.setFocusable(true);
				cadEndereco.requestFocus();
				PrincipalUI.getInstance().getFrame().getContentPane().add(cadEndereco, 0);
				cadEndereco.setVisible(true);	


			}
		});

		JPanel panel = new JPanel();

		jcbEscolaridade = new JComboBox();
		DefaultComboBoxModel<EnumEscolaridade> comboBoxModelEscolaridade = new DefaultComboBoxModel<>();
		for (EnumEscolaridade e : EnumEscolaridade.values()) {
			comboBoxModelEscolaridade.addElement(e);			
		}
		jcbEscolaridade.setModel(comboBoxModelEscolaridade);

		JButton btnSalva = new JButton("Salva");
		btnSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//salvar paciente				
				if(paciente == null) {
					paciente = new Paciente();
					try {
						//Salvar paciente novo						
						paciente.setNome(jtfNome.getText());
						paciente.setCpf(jtfCpf.getText());           
						paciente.setRg(jtfRg.getText());            
						paciente.setEscolaridade((EnumEscolaridade) jcbEscolaridade.getSelectedItem());  
						paciente.setEstadoCivil((EnumEstadoCivil) jcbEstadoCivil.getSelectedItem());   
						paciente.setSexo((EnumSexo) jcbSexo.getSelectedItem());          
						paciente.setCorRaca((EnumCorRaca) jcbCor.getSelectedItem()); 
						paciente.setDataNascimento(formatData.parse(jtfDataNascimento.getText()));  
						paciente.setRendaFamiliar(Float.parseFloat(jtfRenda.getText()));
						paciente.setGestante(cboxGestante.isSelected());
						try {
							new PacienteController().inserir(paciente);
							JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso!");
							ListaPacienteUI.getInstacia().atualizaLista();
							CadastroPacienteUI.getInstace().show();
							//							dispose();
						} catch (PacienteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					} catch (ParseException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}

				}else{
					//Salvar do Editar

					paciente.setNome(jtfNome.getText());
					paciente.setCpf(jtfCpf.getText());           
					paciente.setRg(jtfRg.getText());            
					paciente.setEscolaridade((EnumEscolaridade) jcbEscolaridade.getSelectedItem());
					//					System.out.println(paciente.getEscolaridade());
					paciente.setEstadoCivil((EnumEstadoCivil) jcbEstadoCivil.getSelectedItem());   
					paciente.setSexo((EnumSexo) jcbSexo.getSelectedItem());          
					paciente.setCorRaca((EnumCorRaca) jcbCor.getSelectedItem()); 
					try {
						paciente.setDataNascimento(formatData.parse(jtfDataNascimento.getText()));
					} catch (ParseException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}  
					paciente.setRendaFamiliar(Float.parseFloat(jtfRenda.getText()));
					paciente.setGestante(cboxGestante.isSelected());
					try {
						new PacienteController().editar(paciente);
						JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso!");
						ListaPacienteUI.getInstacia().atualizaLista();
						CadastroPacienteUI.getInstace().show();						
					} catch (PacienteException e1) {
						JOptionPane.showMessageDialog(null, "Homen não pode estar Gestante");
//						e1.printStackTrace();
					}
					//					new PacienteDAO().editar(paciente);
				} 
				//Fimm					


			}
		});

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Editar Endereco				
				PacienteEndereco pe;				
				pe = new PacienteEnderecoTableModel(new PacienteEnderecoController().getListaPacienteEnderecobyIdPe(paciente)).get(jtListaPacienteEndereco.getSelectedRow());				
				endereco = pe.getEndereco();
				CadastroEnderecoUI cadEnderecoUi = new CadastroEnderecoUI(paciente, endereco, pe);
				cadEnderecoUi.setFocusable(true);
				cadEnderecoUi.requestFocus();
				PrincipalUI.getInstance().getFrame().getContentPane().add(cadEnderecoUi, 0);
				cadEnderecoUi.setVisible(true);


			}
		});

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Excluir Endereco				
				System.out.println("Endereco: Excluindo");

				PacienteEndereco pe = new PacienteEnderecoTableModel(new PacienteEnderecoController().getListaPacienteEnderecobyIdPe()).get(jtListaPacienteEndereco.getSelectedRow());

				try {
					new EnderecoController().excluir(pe.getEndereco().getId());
				} catch (EnderecoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Endereco excluído com sucesso");
				atualizaLista();
			}		
		});

		GroupLayout gl_JPcadastroPaciente = new GroupLayout(JPcadastroPaciente);
		gl_JPcadastroPaciente.setHorizontalGroup(
				gl_JPcadastroPaciente.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_JPcadastroPaciente.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_JPcadastroPaciente.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
								.addGroup(gl_JPcadastroPaciente.createSequentialGroup()
										.addGroup(gl_JPcadastroPaciente.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_JPcadastroPaciente.createSequentialGroup()
														.addComponent(jlCpf)
														.addGap(18)
														.addComponent(jtfCpf, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(jlRg)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(jtfRg, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(jlEscolaridade)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(jcbEscolaridade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_JPcadastroPaciente.createSequentialGroup()
														.addComponent(jlNome)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(jtfNome, GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE))
												.addGroup(gl_JPcadastroPaciente.createSequentialGroup()
														.addGroup(gl_JPcadastroPaciente.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_JPcadastroPaciente.createSequentialGroup()
																		.addComponent(jlEstadoCivil)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(jcbEstadoCivil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(jlSexo)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(jcbSexo, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(jlCor, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
																.addGroup(gl_JPcadastroPaciente.createSequentialGroup()
																		.addComponent(jlDataNascimento)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(jtfDataNascimento, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(jlRenda)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_JPcadastroPaciente.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_JPcadastroPaciente.createSequentialGroup()
																		.addGap(12)
																		.addComponent(jtfRenda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																.addComponent(jcbCor, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_JPcadastroPaciente.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_JPcadastroPaciente.createSequentialGroup()
																		.addGap(84)
																		.addComponent(btnSalva))
																.addGroup(gl_JPcadastroPaciente.createSequentialGroup()
																		.addGap(18)
																		.addComponent(cboxGestante)))
														.addGap(19)))
										.addContainerGap())))
				.addGroup(Alignment.LEADING, gl_JPcadastroPaciente.createSequentialGroup()
						.addGap(18)
						.addComponent(jbNovoPaciente)
						.addGap(10)
						.addComponent(btnEditar)
						.addGap(10)
						.addComponent(btnRemover)
						.addContainerGap(478, Short.MAX_VALUE))
				);
		gl_JPcadastroPaciente.setVerticalGroup(
				gl_JPcadastroPaciente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_JPcadastroPaciente.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_JPcadastroPaciente.createParallelGroup(Alignment.BASELINE)
								.addComponent(jlNome)
								.addComponent(jtfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_JPcadastroPaciente.createParallelGroup(Alignment.BASELINE)
								.addComponent(jlCpf)
								.addComponent(jtfCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jtfRg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jlRg)
								.addComponent(jlEscolaridade)
								.addComponent(jcbEscolaridade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_JPcadastroPaciente.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_JPcadastroPaciente.createParallelGroup(Alignment.BASELINE)
										.addComponent(jlEstadoCivil)
										.addComponent(jcbEstadoCivil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(jlSexo)
										.addComponent(jcbSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_JPcadastroPaciente.createSequentialGroup()
										.addGap(3)
										.addComponent(jlCor))
								.addComponent(jcbCor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_JPcadastroPaciente.createParallelGroup(Alignment.BASELINE)
								.addComponent(jlDataNascimento)
								.addComponent(jtfDataNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jtfRenda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jlRenda)
								.addComponent(cboxGestante))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnSalva)
						.addGap(8)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_JPcadastroPaciente.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_JPcadastroPaciente.createSequentialGroup()
										.addGap(12)
										.addGroup(gl_JPcadastroPaciente.createParallelGroup(Alignment.LEADING)
												.addComponent(btnRemover)
												.addComponent(btnEditar)))
								.addGroup(gl_JPcadastroPaciente.createSequentialGroup()
										.addGap(9)
										.addComponent(jbNovoPaciente)))
						.addContainerGap(172, Short.MAX_VALUE))
				);

		JScrollPane jspListaPacienteEndereco = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(jspListaPacienteEndereco, GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(jspListaPacienteEndereco, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(169, Short.MAX_VALUE))
				);
		panel.setLayout(gl_panel);
		JPcadastroPaciente.setLayout(gl_JPcadastroPaciente);
		getContentPane().setLayout(groupLayout);
		panel.setVisible(true);

		jtListaPacienteEndereco = new JTable();
		if(paciente!=null){
			atualizaLista();
		}
		jspListaPacienteEndereco.setViewportView(jtListaPacienteEndereco);
		//jpConsultaCliente.setLayout(gl_jpConsultaCliente);
		getContentPane().setLayout(groupLayout);

//		preencheDados(paciente);


	}

	public void atualizaLista() {
		jtListaPacienteEndereco.setModel(new PacienteEnderecoTableModel(new PacienteEnderecoController().getListaPacienteEnderecobyIdPe(paciente)));
	}

	private void preencheDados(Paciente paciente) {
		if(paciente!=null){
			jtfNome.setText(paciente.getNome());
			jtfCpf.setText(paciente.getCpf());
			jtfRg.setText(paciente.getRg());
			jtfDataNascimento.setText(formatData.format(paciente.getDataNascimento()));
			jtfRenda.setText(""+paciente.getRendaFamiliar());
			jcbCor.setSelectedItem(paciente.getCorRaca());
			jcbEscolaridade.setSelectedItem(paciente.getEscolaridade());
			jcbEstadoCivil.setSelectedItem(paciente.getEstadoCivil());
			jcbSexo.setSelectedItem(paciente.getSexo());
			//			if(paciente.getGestante()!=null){
			cboxGestante.setSelected(paciente.getGestante());
			//			}
			
			atualizaLista();
		}else{
			jtfNome.setText("");
			jtfCpf.setText("");
			jtfRg.setText("");
			jtfDataNascimento.setText("");
			jtfRenda.setText("");
			jcbCor.setSelectedItem(0);
			jcbEscolaridade.setSelectedItem(EnumEscolaridade.values()[0]);
			jcbEstadoCivil.setSelectedItem(0);
			jcbSexo.setSelectedItem(0);
			//			if(paciente.getGestante()!=null){
			cboxGestante.setSelected(false);
			atualizaLista();

		}

	}
}
