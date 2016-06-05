package view;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

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

public class CadastroPaciente extends JInternalFrame {
	private JTextField jtfNome;
	private JTextField jtfCpf;
	private JTextField jtfRg;
	private JTextField jtfEscolaridade;
	private JFormattedTextField jtfDataNascimento;
	private JTextField jtfRenda;
	private MaskFields maskFields = new MaskFields();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPaciente frame = new CadastroPaciente();
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
	public CadastroPaciente() {
		setClosable(true);
		setBounds(100, 100, 800, 600);	
		JPanel JPcadastroPaciente = new JPanel();
		JPcadastroPaciente.setBorder(new TitledBorder(null, "Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(JPcadastroPaciente, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(JPcadastroPaciente, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel jlNome = new JLabel("Nome:");
		
		JLabel jlCpf = new JLabel("CPF:");
		
		JLabel jlRg = new JLabel("RG:");
		
		JLabel jlEscolaridade = new JLabel("Escolaridade:");
		
		JLabel jlEstadoCivil = new JLabel("Estado Civil");
		
		jtfNome = new JTextField();
		jtfNome.setColumns(10);
		
		jtfCpf = new JTextField();
		jtfCpf.setColumns(10);
		
		jtfRg = new JTextField();
		jtfRg.setColumns(10);
		
		jtfEscolaridade = new JTextField();
		jtfEscolaridade.setColumns(10);
		
		JComboBox cBestatoCivil = new JComboBox();
		cBestatoCivil.setModel(new DefaultComboBoxModel(new String[] {"Selecione,", "Casado,", "Solteiro"}));
		cBestatoCivil.setToolTipText("");
		
		JLabel jlSexo = new JLabel("Sexo");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		
		JLabel jlCor = new JLabel("Cor/Raca");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("");
		
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
		
		JCheckBox cboxGestante = new JCheckBox("Gestante");
		
		JButton jbNovoPaciente = new JButton("Novo");
		
		JPanel panel = new JPanel();
		GroupLayout gl_JPcadastroPaciente = new GroupLayout(JPcadastroPaciente);
		gl_JPcadastroPaciente.setHorizontalGroup(
			gl_JPcadastroPaciente.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_JPcadastroPaciente.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_JPcadastroPaciente.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_JPcadastroPaciente.createSequentialGroup()
							.addComponent(jlCpf)
							.addGap(18)
							.addComponent(jtfCpf, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(jlRg)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jtfRg, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(jlEscolaridade)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jtfEscolaridade, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_JPcadastroPaciente.createSequentialGroup()
							.addComponent(jlNome)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(jtfNome, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_JPcadastroPaciente.createSequentialGroup()
							.addComponent(jlEstadoCivil)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cBestatoCivil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(jlSexo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jlCor, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_JPcadastroPaciente.createSequentialGroup()
							.addComponent(jlDataNascimento)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jtfDataNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(jlRenda)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jtfRenda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cboxGestante))
						.addComponent(jbNovoPaciente, Alignment.LEADING))
					.addContainerGap())
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
						.addComponent(jlEscolaridade)
						.addComponent(jlRg)
						.addComponent(jtfCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtfRg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtfEscolaridade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_JPcadastroPaciente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_JPcadastroPaciente.createParallelGroup(Alignment.BASELINE)
							.addComponent(jlEstadoCivil)
							.addComponent(cBestatoCivil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(jlSexo)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_JPcadastroPaciente.createSequentialGroup()
							.addGap(3)
							.addComponent(jlCor))
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_JPcadastroPaciente.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlDataNascimento)
						.addComponent(jtfDataNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jlRenda)
						.addComponent(jtfRenda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cboxGestante))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jbNovoPaciente)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
		);
		
		JTextArea jspListaPaciente = new JTextArea();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(jspListaPaciente, GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(jspListaPaciente, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		JPcadastroPaciente.setLayout(gl_JPcadastroPaciente);
		getContentPane().setLayout(groupLayout);
		panel.setVisible(true);


	}
}
