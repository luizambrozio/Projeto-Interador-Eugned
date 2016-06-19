package view;

import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
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
import dao.PacienteDAO;
import exception.FocoException;
import exception.IncidenteException;
import model.Endereco;
import model.Foco;
import model.Incidente;
import model.Paciente;
import util.MaskFields;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;

public class CadastroIncidenteUI extends JInternalFrame {
	private JTextField jtfBuscaNomePacienteIncidente;
	private JTextField jtfDataIncidente;
	private JTextField jtfDataSintoma;
	private JTextArea textArea;
	private SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
	private MaskFields maskFields = new MaskFields();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroIncidenteUI frame = new CadastroIncidenteUI(null);
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
	public CadastroIncidenteUI(Incidente incidente) {
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
		
		jtfDataIncidente = new JTextField();
		jtfDataIncidente.setColumns(10);
		
		jtfDataSintoma = new JTextField();
		jtfDataSintoma.setColumns(10);
		
		JLabel jlDataSintoma = new JLabel("Data Sintoma");
		
		JPanel jpEnderecoPacienteIncidente = new JPanel();
		jpEnderecoPacienteIncidente.setBorder(new TitledBorder(null, "Endere\u00E7os", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel jpSintomas = new JPanel();
		jpSintomas.setBorder(new TitledBorder(null, "Sintomas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton jbNovoCadastroIncidente = new JButton("Novo");
		
		JButton jbAlterarCadastroIncidente = new JButton("Alterar");
		
		JButton jbExcluirCadastroIncidente = new JButton("Excluir");
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(incidente == null) {
						System.out.println("Incidente: Inserindo...");
						Incidente i = new Incidente();
						i.setPaciente((new PacienteDAO().getListaPacientesByNome(jtfBuscaNomePacienteIncidente.getText())).get(0));
						i.setDataIncidente(formatData.parse(jtfDataIncidente.getText()));
						i.setDataSintoma(formatData.parse(jtfDataIncidente.getText()));
						i.setSintomas(textArea.getText());
					
						new IncidenteController().inserir(i);
						JOptionPane.showMessageDialog(null, "Incidente cadastrado com sucesso!");
						ListaFocoUI.getInstance().atualizaLista();
						dispose();
					} else {
						System.out.println("Incidente: Alterando...");
						Paciente p = (new PacienteDAO().getListaPacientesByNome(jtfBuscaNomePacienteIncidente.getText())).get(0);
						if(p.getId() != incidente.getPaciente().getId()) {
							incidente.setPaciente((new PacienteDAO().getListaPacientesByNome(jtfBuscaNomePacienteIncidente.getText())).get(0));
						}
						incidente.setDataIncidente(formatData.parse(jtfDataIncidente.getText()));
						incidente.setDataSintoma(formatData.parse(jtfDataIncidente.getText()));
						incidente.setSintomas(textArea.getText());						
						//						Endereco endereco = foco.getEndereco();
//						endereco.setRua(jtfRuaFoco.getText());
//						endereco.setNumero(jtfNumeroFoco.getText());
//						endereco.setBairro(jtfBairroFoco.getText());
//						endereco.setCep(jtfCep.getText());
//						endereco.setCidade(jtfCidadeFoco.getText());
//						endereco.setEstado(jtfEStadoFoco.getText());
						new IncidenteController().editar(incidente);
						ListaFocoUI.getInstance().atualizaLista();
						dispose();
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
							.addComponent(jbNovoCadastroIncidente)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jbAlterarCadastroIncidente)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jbExcluirCadastroIncidente))
						.addGroup(gl_jpCadastroIncidente.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(jpEnderecoPacienteIncidente, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
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
					.addComponent(jpEnderecoPacienteIncidente, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jpCadastroIncidente.createParallelGroup(Alignment.BASELINE)
						.addComponent(jbNovoCadastroIncidente)
						.addComponent(jbAlterarCadastroIncidente)
						.addComponent(jbExcluirCadastroIncidente))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		textArea = new JTextArea();
		textArea.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GroupLayout gl_jpSintomas = new GroupLayout(jpSintomas);
		gl_jpSintomas.setHorizontalGroup(
			gl_jpSintomas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpSintomas.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_jpSintomas.setVerticalGroup(
			gl_jpSintomas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpSintomas.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
					.addContainerGap())
		);
		jpSintomas.setLayout(gl_jpSintomas);
		
		JScrollPane jscrpEnderecoIncidente = new JScrollPane();
		GroupLayout gl_jpEnderecoPacienteIncidente = new GroupLayout(jpEnderecoPacienteIncidente);
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
		
		table = new JTable();
		jscrpEnderecoIncidente.setColumnHeaderView(table);
		jpEnderecoPacienteIncidente.setLayout(gl_jpEnderecoPacienteIncidente);
		jpCadastroIncidente.setLayout(gl_jpCadastroIncidente);
		getContentPane().add(jpCadastroIncidente);
		
		preencheDados(incidente);

	}
	/**
	 * Metodo responsável pelo preenchimento dos campos na tela
	 * @param incidente
	 */
	private void preencheDados(Incidente incidente) {
		if(incidente != null) {
			jtfBuscaNomePacienteIncidente.setText(incidente.getPaciente().getNome());
			jtfDataIncidente.setText(new SimpleDateFormat("dd/MM/yyyy").format(incidente.getDataIncidente()));
			jtfDataSintoma.setText(new SimpleDateFormat("dd/MM/yyyy").format(incidente.getDataSintoma()));
			textArea.setText(incidente.getSintomas());
			
		}
		
		
		
	}
}
