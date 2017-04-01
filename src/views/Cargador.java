package views;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

public class Cargador extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cargador frame = new Cargador();
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
	public Cargador() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jcontreras\\workspace\\Reporte2016\\logo\\cargandoPagina.gif"));
		lblNewLabel.setBounds(12, 13, 262, 211);
		getContentPane().add(lblNewLabel);
		
		JLabel lblProcesandoConsulta = new JLabel("Procesando consulta ");
		lblProcesandoConsulta.setBounds(12, 252, 151, 16);
		getContentPane().add(lblProcesandoConsulta);
		setBounds(100, 100, 221, 303);

	}
}
