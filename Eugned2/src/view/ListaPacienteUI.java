package view;

/**
 * @author ambrozio
 */

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.EnderecoController;
import controller.FocoController;
import controller.PacienteController;
import controller.PacienteEnderecoController;
import dao.PacienteDAO;
import exception.EnderecoException;
import exception.FocoException;
import exception.PacienteException;
import model.Endereco;
import model.Foco;
import model.FocoTableModel;
import model.Paciente;
import model.PacienteEndereco;
import model.PacienteTableModel;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class ListaPacienteUI extends JInternalFrame {

	private JTextField jtfBuscarPaciente;
	private JTable jtListaPaciente;
	private static ListaPacienteUI instancia;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaPacienteUI frame = getInstacia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static ListaPacienteUI getInstacia(){
		if(instancia==null){
			instancia = new ListaPacienteUI();
		}
		return instancia;
	}

	/**
	 * Create the frame.
	 */
	public ListaPacienteUI() {
		setClosable(true);
		setBounds(100, 100, 600, 400);
		System.out.println("setvisibreTrueteste");

		JPanel jpListaPacientes = new JPanel();
		jpListaPacientes.setBorder(new TitledBorder(null, "Lasta Pacientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JButton jbNovoPaciente = new JButton("Novo");
		jbNovoPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroPacienteUI cadPaciente = new CadastroPacienteUI(null);
				cadPaciente.setFocusable(true);
				cadPaciente.requestFocus();
				PrincipalUI.getInstance().getFrame().getContentPane().add(cadPaciente, 0);
				cadPaciente.setVisible(true);				
			}
		});

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//Editar Paciente				
				Paciente p;
				p = new PacienteTableModel(new PacienteController().getListaPacientes()).get(jtListaPaciente.getSelectedRow());
				CadastroPacienteUI cadPacienteUi = new CadastroPacienteUI(p);
				cadPacienteUi.setFocusable(true);
				cadPacienteUi.requestFocus();
				PrincipalUI.getInstance().getFrame().getContentPane().add(cadPacienteUi, 0);
				cadPacienteUi.setVisible(true);
			}
		});

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Paciente: Excluindo");
				
				Paciente p = new PacienteTableModel(new PacienteController().getListaPacientes()).get(jtListaPaciente.getSelectedRow());
				List<PacienteEndereco> listEnderedeco = new ArrayList<>();
				listEnderedeco= new PacienteEnderecoController().getListaPacienteEnderecobyIdPe2(p);
				try {
					for (PacienteEndereco endereco : listEnderedeco) {
						try {
							new EnderecoController().excluir(endereco.getEndereco().getId());
						} catch (EnderecoException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}						
					}
					new PacienteController().excluir(p.getId());
				} catch (PacienteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Paciente excluído com sucesso");

			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(12)
										.addComponent(jbNovoPaciente)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnEditar)
										.addGap(18)
										.addComponent(btnExcluir))
								.addComponent(jpListaPacientes, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jpListaPacientes, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jbNovoPaciente)
								.addComponent(btnEditar)
								.addComponent(btnExcluir))
						.addContainerGap(18, Short.MAX_VALUE))
				);

		JLabel jlBuscar = new JLabel("Buscar");

		jtfBuscarPaciente = new JTextField();
		jtfBuscarPaciente.setColumns(10);

		JButton jbBuscar = new JButton("Buscar");
		jbBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//buscar paciente na lista
				ArrayList<Paciente> listaPacientePesquisa = new ArrayList<Paciente>();
				for ( Paciente c : new PacienteDAO().getListaPacientes()){
					if (c.getNome().contains(jtfBuscarPaciente.getText())){
						listaPacientePesquisa.add(c);
					}
				}
				jtListaPaciente.setModel(new PacienteTableModel(listaPacientePesquisa));
			}
		});

		JScrollPane jspListaPaciente = new JScrollPane();
		GroupLayout gl_jpListaPacientes = new GroupLayout(jpListaPacientes);
		gl_jpListaPacientes.setHorizontalGroup(
				gl_jpListaPacientes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpListaPacientes.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_jpListaPacientes.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_jpListaPacientes.createSequentialGroup()
										.addComponent(jlBuscar)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(jtfBuscarPaciente, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(jbBuscar)
										.addGap(77))
								.addGroup(gl_jpListaPacientes.createSequentialGroup()
										.addComponent(jspListaPaciente, GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
										.addGap(21))))
				);
		gl_jpListaPacientes.setVerticalGroup(
				gl_jpListaPacientes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpListaPacientes.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_jpListaPacientes.createParallelGroup(Alignment.BASELINE)
								.addComponent(jlBuscar)
								.addComponent(jtfBuscarPaciente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jbBuscar))
						.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
						.addComponent(jspListaPaciente, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);

		jtListaPaciente = new JTable();
		atualizaLista();
		jspListaPaciente.setViewportView(jtListaPaciente);		
		jpListaPacientes.setLayout(gl_jpListaPacientes);
		getContentPane().setLayout(groupLayout);

	}

	public void atualizaLista() {
		jtListaPaciente.setModel(new PacienteTableModel(new PacienteDAO().getListaPacientes()));
	}
}
