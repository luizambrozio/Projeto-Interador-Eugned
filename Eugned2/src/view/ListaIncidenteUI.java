package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;

public class ListaIncidenteUI extends JInternalFrame {
	private JTextField jtfBuscaListaIncidente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaIncidenteUI frame = new ListaIncidenteUI();
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
	public ListaIncidenteUI() {
		setBounds(100, 100, 450, 300);
		
		JPanel jpListaIncidente = new JPanel();
		jpListaIncidente.setBorder(new TitledBorder(null, "Incidente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(jpListaIncidente, BorderLayout.CENTER);
		
		JLabel jlBuscaListaIncidente = new JLabel("Busca");
		
		jtfBuscaListaIncidente = new JTextField();
		jtfBuscaListaIncidente.setColumns(10);
		
		JButton jbNovoListaPaciente = new JButton("Novo");
		
		JPanel jpNomeListaPacienteIncidente = new JPanel();
		GroupLayout gl_jpListaIncidente = new GroupLayout(jpListaIncidente);
		gl_jpListaIncidente.setHorizontalGroup(
			gl_jpListaIncidente.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_jpListaIncidente.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpListaIncidente.createParallelGroup(Alignment.TRAILING)
						.addComponent(jpNomeListaPacienteIncidente, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
						.addGroup(gl_jpListaIncidente.createSequentialGroup()
							.addComponent(jlBuscaListaIncidente)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jtfBuscaListaIncidente, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
							.addComponent(jbNovoListaPaciente)))
					.addContainerGap())
		);
		gl_jpListaIncidente.setVerticalGroup(
			gl_jpListaIncidente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpListaIncidente.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpListaIncidente.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlBuscaListaIncidente)
						.addComponent(jtfBuscaListaIncidente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jbNovoListaPaciente))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jpNomeListaPacienteIncidente, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		
		JScrollPane jscrpNomeListaIncidente = new JScrollPane();
		GroupLayout gl_jpNomeListaPacienteIncidente = new GroupLayout(jpNomeListaPacienteIncidente);
		gl_jpNomeListaPacienteIncidente.setHorizontalGroup(
			gl_jpNomeListaPacienteIncidente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpNomeListaPacienteIncidente.createSequentialGroup()
					.addContainerGap()
					.addComponent(jscrpNomeListaIncidente, GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_jpNomeListaPacienteIncidente.setVerticalGroup(
			gl_jpNomeListaPacienteIncidente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpNomeListaPacienteIncidente.createSequentialGroup()
					.addContainerGap()
					.addComponent(jscrpNomeListaIncidente, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
					.addContainerGap())
		);
		jpNomeListaPacienteIncidente.setLayout(gl_jpNomeListaPacienteIncidente);
		jpListaIncidente.setLayout(gl_jpListaIncidente);

	}

}
