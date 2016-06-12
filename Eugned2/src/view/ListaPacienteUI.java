package view;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


import dao.PacienteDAO;

import model.PacienteTableModel;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class ListaPacienteUI extends JInternalFrame {
	
	private JTextField jtfBuscarPaciente;
	private JTable jtListaPaciente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaPacienteUI frame = new ListaPacienteUI();
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
	public ListaPacienteUI() {
		setClosable(true);
		setBounds(100, 100, 600, 400);
		System.out.println("setvisibreTrueteste");
		
		JPanel jpListaPacientes = new JPanel();
		jpListaPacientes.setBorder(new TitledBorder(null, "Lasta Pacientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpListaPacientes, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(572, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpListaPacientes, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel jlBuscar = new JLabel("Buscar");
		
		jtfBuscarPaciente = new JTextField();
		jtfBuscarPaciente.setColumns(10);
		
		JButton jbBuscar = new JButton("Buscar");
		
		JButton jbNovoPaciente = new JButton("Novo");
		jbNovoPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroPacienteUI cadPaciente = new CadastroPacienteUI();
				cadPaciente.setFocusable(true);
				cadPaciente.requestFocus();
				PrincipalUI.getInstance().getFrame().getContentPane().add(cadPaciente, 0);
				cadPaciente.setVisible(true);				
			}
		});
		
		JScrollPane jspListaPaciente = new JScrollPane();
		GroupLayout gl_jpListaPacientes = new GroupLayout(jpListaPacientes);
		gl_jpListaPacientes.setHorizontalGroup(
			gl_jpListaPacientes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpListaPacientes.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpListaPacientes.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpListaPacientes.createSequentialGroup()
							.addComponent(jlBuscar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jtfBuscarPaciente, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jbBuscar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jbNovoPaciente)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_jpListaPacientes.createSequentialGroup()
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
						.addComponent(jbBuscar)
						.addComponent(jbNovoPaciente))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addComponent(jspListaPaciente, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		jtListaPaciente = new JTable();
		jtListaPaciente.setModel(new PacienteTableModel(new PacienteDAO().getListaPacientes()));
		jspListaPaciente.setViewportView(jtListaPaciente);		
		jpListaPacientes.setLayout(gl_jpListaPacientes);
		getContentPane().setLayout(groupLayout);
		
	}
}
