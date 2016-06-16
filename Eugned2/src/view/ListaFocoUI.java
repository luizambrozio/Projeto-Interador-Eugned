package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

import controller.FocoController;
import dao.FocoDAO;
import dao.PacienteDAO;
import exception.FocoException;
import model.Foco;
import model.FocoTableModel;
import model.PacienteTableModel;
import util.MaskFields;

public class ListaFocoUI extends JInternalFrame {
	
	private static ListaFocoUI instancia;
	private JFormattedTextField jtfDataIniFocos;
	private SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
	private MaskFields maskFields = new MaskFields();
	private JTable jtListaFoco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ListaFocoUI frame = ListaFocoUI.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static ListaFocoUI getInstance(){
		if(instancia == null) {
			instancia = new ListaFocoUI();
		} 
		return instancia;
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
		
		jtfDataIniFocos = new JFormattedTextField();
		try {
			maskFields.maskData(jtfDataIniFocos);
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Impossível aplicar máscara");
			e1.printStackTrace();
		}
		jtfDataIniFocos.setColumns(10);
		
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
		
		JLabel lblAt = new JLabel("até");
		
		JFormattedTextField jtfDataFim = new JFormattedTextField();
		try {
			maskFields.maskData(jtfDataFim);
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Impossível aplicar máscara");
			e1.printStackTrace();
		}
		jtfDataFim.setColumns(10);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Foco f;
					f = new FocoTableModel(
							new FocoController().getListaFocos()
							).get(jtListaFoco.getSelectedRow());
					CadastroFocoUI cadFocoUi = new CadastroFocoUI(f);
					cadFocoUi.setFocusable(true);
					cadFocoUi.requestFocus();
					PrincipalUI.getInstance().getFrame().getContentPane().add(cadFocoUi, 0);
					cadFocoUi.setVisible(true);
					
				} catch (FocoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}


				
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("FOCO: Excluindo");
					Foco f = 
							new FocoTableModel(
									new FocoController().getListaFocos()
									).get(jtListaFoco.getSelectedRow());

					new FocoController().excluir(f.getId());
					JOptionPane.showMessageDialog(null, "Foco excluído com sucesso");
					jtListaFoco.setModel(
							new FocoTableModel(
									new FocoController().getListaFocos()));
				} catch (FocoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

				
			}
		});
		GroupLayout gl_jpListaFoco = new GroupLayout(jpListaFoco);
		gl_jpListaFoco.setHorizontalGroup(
			gl_jpListaFoco.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpListaFoco.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpListaFoco.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_jpListaFoco.createSequentialGroup()
							.addComponent(jlPeriodo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jtfDataIniFocos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAt, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(jtfDataFim, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(jbBuscar)
							.addGap(70))
						.addGroup(Alignment.TRAILING, gl_jpListaFoco.createSequentialGroup()
							.addComponent(jspListaFoco, GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
							.addGap(21))
						.addGroup(gl_jpListaFoco.createSequentialGroup()
							.addComponent(jbNovoFoco, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(243))))
		);
		gl_jpListaFoco.setVerticalGroup(
			gl_jpListaFoco.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpListaFoco.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpListaFoco.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlPeriodo)
						.addComponent(jtfDataIniFocos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jbBuscar)
						.addComponent(lblAt)
						.addComponent(jtfDataFim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addComponent(jspListaFoco, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_jpListaFoco.createParallelGroup(Alignment.BASELINE)
						.addComponent(jbNovoFoco)
						.addComponent(btnEditar)
						.addComponent(btnExcluir))
					.addGap(8))
		);

		//JPanel panel = new JPanel();
		
		jtListaFoco = new JTable();
		jtListaFoco.setModel(
				new FocoTableModel(new FocoDAO().getListaFocos()));
		jspListaFoco.setViewportView(jtListaFoco);		
		jpListaFoco.setLayout(gl_jpListaFoco);
		getContentPane().setLayout(groupLayout);

	}

	public void atualizaLista() {
		jtListaFoco.setModel(
				new FocoTableModel(
						new FocoController().getListaFocos()));		
	}
}
