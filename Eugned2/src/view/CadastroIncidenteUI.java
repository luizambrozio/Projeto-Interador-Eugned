package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class CadastroIncidenteUI extends JInternalFrame {
	private JTextField jtfBuscaNomePacienteIncidente;
	private JTextField jtfDataIncidente;
	private JTextField jtfDataSintoma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroIncidenteUI frame = new CadastroIncidenteUI();
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
	public CadastroIncidenteUI() {
		setBounds(100, 100, 554, 394);
		
		JPanel jpCadastroIncidente = new JPanel();
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
		
		JPanel jpSintomas = new JPanel();
		jpSintomas.setBorder(new TitledBorder(null, "Sintomas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_jpCadastroIncidente = new GroupLayout(jpCadastroIncidente);
		gl_jpCadastroIncidente.setHorizontalGroup(
			gl_jpCadastroIncidente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadastroIncidente.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpCadastroIncidente.createParallelGroup(Alignment.LEADING)
						.addComponent(jpEnderecoPacienteIncidente, GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
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
						.addComponent(jpSintomas, GroupLayout.PREFERRED_SIZE, 493, GroupLayout.PREFERRED_SIZE))
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
					.addComponent(jpEnderecoPacienteIncidente, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jpSintomas, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
					.addContainerGap())
		);
		GroupLayout gl_jpSintomas = new GroupLayout(jpSintomas);
		gl_jpSintomas.setHorizontalGroup(
			gl_jpSintomas.createParallelGroup(Alignment.LEADING)
				.addGap(0, 396, Short.MAX_VALUE)
		);
		gl_jpSintomas.setVerticalGroup(
			gl_jpSintomas.createParallelGroup(Alignment.LEADING)
				.addGap(0, 72, Short.MAX_VALUE)
		);
		jpSintomas.setLayout(gl_jpSintomas);
		
		JScrollPane jscrpEnderecoIncidente = new JScrollPane();
		GroupLayout gl_jpEnderecoPacienteIncidente = new GroupLayout(jpEnderecoPacienteIncidente);
		gl_jpEnderecoPacienteIncidente.setHorizontalGroup(
			gl_jpEnderecoPacienteIncidente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpEnderecoPacienteIncidente.createSequentialGroup()
					.addContainerGap()
					.addComponent(jscrpEnderecoIncidente, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_jpEnderecoPacienteIncidente.setVerticalGroup(
			gl_jpEnderecoPacienteIncidente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpEnderecoPacienteIncidente.createSequentialGroup()
					.addContainerGap()
					.addComponent(jscrpEnderecoIncidente, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
					.addContainerGap())
		);
		jpEnderecoPacienteIncidente.setLayout(gl_jpEnderecoPacienteIncidente);
		jpCadastroIncidente.setLayout(gl_jpCadastroIncidente);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpCadastroIncidente, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpCadastroIncidente, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}
}
