package view;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
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

@SuppressWarnings("serial")
public class ListaPaciente extends JInternalFrame {
	
	private JTextField jtfBuscarPaciente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaPaciente frame = new ListaPaciente();
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
	public ListaPaciente() {
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
				CadastroPaciente cadPaciente = new CadastroPaciente();
				cadPaciente.setFocusable(true);
				cadPaciente.requestFocus();
				PrincipalUI.getInstance().getFrame().add(cadPaciente, 0);
				cadPaciente.setVisible(true);				
			}
		});
		
		JPanel panel = new JPanel();
		
		JTextArea textArea = new JTextArea();
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
							.addComponent(jbNovoPaciente))
						.addGroup(gl_jpListaPacientes.createSequentialGroup()
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
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
					.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
					.addGroup(gl_jpListaPacientes.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 550, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 250, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		jpListaPacientes.setLayout(gl_jpListaPacientes);
		getContentPane().setLayout(groupLayout);

	}

}
