package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalUI {

	private JFrame frame;
	private static PrincipalUI window;
	
	
	
	public static PrincipalUI getInstance(){
		if(window == null){
			window = new PrincipalUI();
		} 
		return window;
	}
	

	public JFrame getFrame() {
		return frame;
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = getInstance();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrincipalUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 1600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 272, Short.MAX_VALUE)
		);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
				
		JMenu mnCadastro = new JMenu("Cadastros");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmPaciente = new JMenuItem("Paciente");
		mntmPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaPaciente listPaciente = new ListaPaciente();
				listPaciente.setFocusable(true);
				listPaciente.requestFocus();
				frame.getContentPane().add(listPaciente, 0);
				listPaciente.setVisible(true);	
			}
		});
		mnCadastro.add(mntmPaciente);
		
		JMenuItem mntmIncidente = new JMenuItem("Incidente");
		mnCadastro.add(mntmIncidente);
		
		JMenuItem mntmFoco = new JMenuItem("Foco");
		mnCadastro.add(mntmFoco);
				
		JMenu mnRelatorios = new JMenu("Relatórios");
		menuBar.add(mnRelatorios);			
		
		JMenuItem mntmRelatrioIncidente = new JMenuItem("Relatório Incidente");
		mnRelatorios.add(mntmRelatrioIncidente);
		
		JMenuItem mntmRelatorioFoco = new JMenuItem("Relatórios Focos");
		mnRelatorios.add(mntmRelatorioFoco);
		
		JMenuItem mntmRelatrioPaciente = new JMenuItem("Relatório Paciente");
		mntmRelatrioPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatorioPaciente relPaciente = new RelatorioPaciente();
				relPaciente.setFocusable(true);
				relPaciente.requestFocus();
				frame.getContentPane().add(relPaciente, 0);
				relPaciente.setVisible(true);
			}
		});
		mnRelatorios.add(mntmRelatrioPaciente);
				
		JMenu mnGrafico = new JMenu("Graficos");
		menuBar.add(mnGrafico);
	}
}
