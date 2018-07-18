package views;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class InformeControlProduccion extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformeControlProduccion frame = new InformeControlProduccion();
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
	public InformeControlProduccion() {
		setBounds(100, 100, 669, 531);
		getContentPane().setLayout(null);
		
		JLabel lblFiltroDeControl = new JLabel("filtro de control de produccion");
		lblFiltroDeControl.setBounds(22, 11, 238, 66);
		getContentPane().add(lblFiltroDeControl);

	}
}
