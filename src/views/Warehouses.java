package views;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Warehouses extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Warehouses frame = new Warehouses();
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
	public Warehouses() {
		setBounds(100, 100, 450, 300);

	}

}
