package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import dao.FocoDAO;
import dao.PacienteDAO;
import model.Foco;
import model.FocoTableModel;
import model.PacienteTableModel;

public class ListaFocoUI extends JInternalFrame {
	
	private JTextField jtfBuscarFocos;
	private JTable jtListaFoco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaFocoUI frame = new ListaFocoUI();
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
	public ListaFocoUI() {
		setClosable(true);
		setTitle("Consulta Focos");
		setBounds(100, 100, 600, 400);
		
		JPanel jpListaFoco = new JPanel();
		jpListaFoco.setBorder(new TitledBorder(null, "Lista Focos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpListaFoco, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(572, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpListaFoco, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel jlPeriodo = new JLabel("Periodo");
		
		jtfBuscarFocos = new JTextField();
		jtfBuscarFocos.setColumns(10);
		
		JButton jbBuscar = new JButton("Buscar");
		
		JButton jbNovoFoco = new JButton("Novo");
		jbNovoFoco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroFocoUI cadFoco = new CadastroFocoUI(null);
				cadFoco.setFocusable(true);
				cadFoco.requestFocus();
				PrincipalUI.getInstance().getFrame().getContentPane().add(cadFoco, 0);
				cadFoco.setVisible(true);				
			}
		});

		JScrollPane jspListaFoco = new JScrollPane();
		GroupLayout gl_jpListaFoco = new GroupLayout(jpListaFoco);
		gl_jpListaFoco.setHorizontalGroup(
			gl_jpListaFoco.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpListaFoco.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpListaFoco.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpListaFoco.createSequentialGroup()
							.addComponent(jlPeriodo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jtfBuscarFocos, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jbBuscar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jbNovoFoco)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_jpListaFoco.createSequentialGroup()
							.addComponent(jspListaFoco, GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
							.addGap(21))))
		);

		gl_jpListaFoco.setVerticalGroup(
				gl_jpListaFoco.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_jpListaFoco.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_jpListaFoco.createParallelGroup(Alignment.BASELINE)
							.addComponent(jlPeriodo)
							.addComponent(jtfBuscarFocos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(jbBuscar)
							.addComponent(jbNovoFoco))
						.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
						.addComponent(jspListaFoco, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);

		//JPanel panel = new JPanel();
		
		jtListaFoco = new JTable();
		jtListaFoco.setModel(
				new FocoTableModel(new FocoDAO().getListaFocos()));
		jspListaFoco.setViewportView(jtListaFoco);		
		jpListaFoco.setLayout(gl_jpListaFoco);
		getContentPane().setLayout(groupLayout);

	}
}
