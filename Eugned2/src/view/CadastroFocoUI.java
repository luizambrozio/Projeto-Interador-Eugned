package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class CadastroFoco extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFoco frame = new CadastroFoco();
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
	public CadastroFoco() {
		setBounds(100, 100, 450, 300);

	}

}
