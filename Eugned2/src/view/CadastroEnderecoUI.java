package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import model.EnumSexo;
import model.EnumTipoEndereco;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class CadastroEnderecoUI extends JInternalFrame {
	private JTextField jtfRua;
	private JTextField jtfNum;
	private JTextField jtfBairro;
	private JTextField jtfCep;
	private JTextField jtfEstado;
	private JTextField jtfCidade;
	private JComboBox jcbTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroEnderecoUI frame = new CadastroEnderecoUI();
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
	public CadastroEnderecoUI() {
		setBounds(100, 100, 474, 235);
		setClosable(true);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Novo Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(88, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel jlRua = new JLabel("Rua:");
		
		jtfRua = new JTextField();
		jtfRua.setColumns(10);
		
		JLabel jlNum = new JLabel("Nº");
		
		jtfNum = new JTextField();
		jtfNum.setColumns(10);
		
		JLabel jlBairro = new JLabel("Bairro:");
		
		jtfBairro = new JTextField();
		jtfBairro.setColumns(10);
		
		JLabel jlCep = new JLabel("CEP:");
		
		jtfCep = new JTextField();
		jtfCep.setColumns(10);
		
		JLabel jlEstado = new JLabel("Estado:");
		
		JLabel lblCidade = new JLabel("Cidade:");
		
		JButton jbCancelar = new JButton("Cancelar");
		
		JButton jbSalvar = new JButton("Salvar");
		
		jtfEstado = new JTextField();
		jtfEstado.setColumns(10);
		
		jtfCidade = new JTextField();
		jtfCidade.setColumns(10);
		
		jcbTipo = new JComboBox();	
		DefaultComboBoxModel<EnumTipoEndereco> comboBoxModelTipoEndereco = new DefaultComboBoxModel<>();
		for (EnumTipoEndereco e : EnumTipoEndereco.values()) {
			comboBoxModelTipoEndereco.addElement(e);			
		}		
		jcbTipo.setModel(comboBoxModelTipoEndereco);
		
		JLabel lblTipo = new JLabel("tipo");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(jlRua)
							.addGap(4)
							.addComponent(jtfRua, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jlNum)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(jtfNum, 0, 0, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(jlBairro)
							.addGap(3)
							.addComponent(jtfBairro, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jlCep)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jtfCep, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(jlEstado)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jtfEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addComponent(lblCidade)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jtfCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(jbSalvar)
							.addGap(18)
							.addComponent(jbCancelar)))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(184, Short.MAX_VALUE)
					.addComponent(lblTipo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jcbTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(141))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlRua)
						.addComponent(jtfRua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jlNum)
						.addComponent(jtfNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlBairro)
						.addComponent(jtfBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jlCep)
						.addComponent(jtfCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlEstado)
						.addComponent(lblCidade)
						.addComponent(jtfEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtfCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(jcbTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTipo))
					.addGap(4)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(jbCancelar)
						.addComponent(jbSalvar))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}
}
