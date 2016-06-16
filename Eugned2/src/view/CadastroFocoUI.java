package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import controller.FocoController;
import dao.EnderecoDao;
import dao.FocoDAO;
import exception.FocoException;
import model.Endereco;
import model.Foco;
import util.MaskFields;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class CadastroFocoUI extends JInternalFrame {
	private JFormattedTextField jtfDataFoco;
	private JTextField jtfRuaFoco;
	private JTextField jtfNumeroFoco;
	private JTextField jtfBairroFoco;
	private JTextField jtfCep;
	private JTextField jtfCidadeFoco;
	private JTextField jtfEStadoFoco;
	private SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
	private MaskFields maskFields = new MaskFields();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFocoUI frame = new CadastroFocoUI(null);
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
	public CadastroFocoUI(Foco foco) {
		setTitle("Registrar Foco");
		setClosable(true);
		setBounds(100, 100, 544, 292);
		getContentPane().setLayout(null);
		
		JPanel jpFoco = new JPanel();
		jpFoco.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Foco", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		jpFoco.setBounds(12, 12, 510, 236);
		getContentPane().add(jpFoco);
		
		JLabel lblDataFoco = new JLabel("Data:");
		
		jtfDataFoco = new JFormattedTextField();
		try {
			maskFields.maskData(jtfDataFoco);
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Impossível aplicar máscara");
			e1.printStackTrace();
		}
		jtfDataFoco.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Novo Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel jlbRuaFoco = new JLabel("Rua:");
		
		jtfRuaFoco = new JTextField();
		jtfRuaFoco.setColumns(10);
		
		JLabel jlbNumeroFoco = new JLabel("Nº");
		
		jtfNumeroFoco = new JTextField();
		jtfNumeroFoco.setColumns(10);
		
		JLabel jlbBairroFoco = new JLabel("Bairro:");
		
		jtfBairroFoco = new JTextField();
		jtfBairroFoco.setColumns(10);
		
		JLabel jlbCepFoco = new JLabel("CEP:");
		
		jtfCep = new JTextField();
		jtfCep.setColumns(10);
		
		JLabel jlbEstadoFoco = new JLabel("Estado:");
		
		JLabel jlbCidadeFoco = new JLabel("Cidade:");
		
		// Ação de Salvamaneto
		JButton button = new JButton("Salvar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(foco == null) {
						System.out.println("FOCO: Inserindo...");
						Foco f = new Foco();
						f.setDataFoco(formatData.parse(jtfDataFoco.getText()));
						Endereco endereco = new Endereco();
						endereco.setRua(jtfRuaFoco.getText());
						endereco.setNumero(jtfNumeroFoco.getText());
						endereco.setBairro(jtfBairroFoco.getText());
						endereco.setCep(jtfCep.getText());
						endereco.setCidade(jtfCidadeFoco.getText());
						endereco.setEstado(jtfEStadoFoco.getText());
						f.setEndereco(endereco);
						
						new FocoController().inserir(f);
						JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
						ListaFocoUI.getInstance().atualizaLista();
						dispose();
					} else {
						System.out.println("FOCO: Alterando...");
						foco.setDataFoco(formatData.parse(jtfDataFoco.getText()));
						Endereco endereco = foco.getEndereco();
						endereco.setRua(jtfRuaFoco.getText());
						endereco.setNumero(jtfNumeroFoco.getText());
						endereco.setBairro(jtfBairroFoco.getText());
						endereco.setCep(jtfCep.getText());
						endereco.setCidade(jtfCidadeFoco.getText());
						endereco.setEstado(jtfEStadoFoco.getText());
						new FocoController().editar(foco);
						ListaFocoUI.getInstance().atualizaLista();
						dispose();
					}
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (FocoException e1) {
					System.out.println("FOCO: Erro no salvamento: " + e1.getMessage());
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		
		JButton jtbCancelarFoco = new JButton("Cancelar");
		jtbCancelarFoco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		jtfCidadeFoco = new JTextField();
		jtfCidadeFoco.setColumns(10);
		
		jtfEStadoFoco = new JTextField();
		jtfEStadoFoco.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(jlbCidadeFoco)
								.addComponent(jlbBairroFoco)
								.addComponent(jlbRuaFoco))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(jtfRuaFoco, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
								.addComponent(jtfBairroFoco, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
								.addComponent(jtfCidadeFoco, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(jlbNumeroFoco)
								.addComponent(jlbEstadoFoco)
								.addComponent(jlbCepFoco))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(jtfEStadoFoco, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addComponent(jtfCep, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addComponent(jtfNumeroFoco, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(120)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(jtbCancelarFoco)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlbRuaFoco)
						.addComponent(jtfRuaFoco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jlbNumeroFoco)
						.addComponent(jtfNumeroFoco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlbBairroFoco)
						.addComponent(jtfBairroFoco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jlbCepFoco)
						.addComponent(jtfCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlbCidadeFoco)
						.addComponent(jlbEstadoFoco)
						.addComponent(jtfCidadeFoco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtfEStadoFoco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(jtbCancelarFoco, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_jpFoco = new GroupLayout(jpFoco);
		gl_jpFoco.setHorizontalGroup(
			gl_jpFoco.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpFoco.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpFoco.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 483, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_jpFoco.createSequentialGroup()
							.addComponent(lblDataFoco)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(jtfDataFoco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_jpFoco.setVerticalGroup(
			gl_jpFoco.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpFoco.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpFoco.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataFoco)
						.addComponent(jtfDataFoco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		jpFoco.setLayout(gl_jpFoco);
		
		preencheDados(foco);

	}

	private void preencheDados(Foco foco) {
		if(foco != null) {
			jtfDataFoco.setText(formatData.format(foco.getDataFoco()));
			jtfRuaFoco.setText(foco.getEndereco().getRua());
			jtfNumeroFoco.setText(foco.getEndereco().getNumero());
			jtfBairroFoco.setText(foco.getEndereco().getBairro());
			jtfCep.setText(foco.getEndereco().getCep());
			jtfCidadeFoco.setText(foco.getEndereco().getCidade());
			jtfEStadoFoco.setText(foco.getEndereco().getEstado());
		}
		
	}
}
