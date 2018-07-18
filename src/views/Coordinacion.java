package views;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRException;
import reportes.ReporteGenerador;
import tools.CargadorCombobox;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JComboBox;

public class Coordinacion extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coordinacion frame = new Coordinacion();
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
	public Coordinacion() {
		setFrameIcon(new ImageIcon("Reportes\\logoHeader.png"));
		setMaximizable(true);
		setClosable(true);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Coordinacion");
		setBounds(100, 100, 1047, 527);
		getContentPane().setLayout(null);
		
		final JLabel lblInformesDeCoordinacion = new JLabel("Informes de coordinaci\u00F3n");
		lblInformesDeCoordinacion.setBackground(Color.DARK_GRAY);
		lblInformesDeCoordinacion.setForeground(Color.DARK_GRAY);
		lblInformesDeCoordinacion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblInformesDeCoordinacion.setBounds(10, 27, 289, 14);
		getContentPane().add(lblInformesDeCoordinacion);
		
		
		JButton btnObrasYPaquetes = new JButton("Obras y Paquetes");
		btnObrasYPaquetes.setForeground(Color.DARK_GRAY);
		btnObrasYPaquetes.setBackground(Color.WHITE);
		
	
		btnObrasYPaquetes.setBounds(45, 244, 159, 23);
		getContentPane().add(btnObrasYPaquetes);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.DARK_GRAY);
		separator.setBounds(10, 90, 631, 2);
		getContentPane().add(separator);
		
		JLabel lblObra = new JLabel("Obra ");
		lblObra.setForeground(Color.DARK_GRAY);
		lblObra.setBounds(10, 121, 46, 14);
		getContentPane().add(lblObra);
		
		
		CargadorCombobox cc = new CargadorCombobox();
		
		final JComboBox comboBoxObra = new JComboBox(cc.generarContenidoObra());
		comboBoxObra.setForeground(Color.DARK_GRAY);
		comboBoxObra.setBackground(Color.DARK_GRAY);
		comboBoxObra.setBounds(45, 118, 326, 20);
		getContentPane().add(comboBoxObra);
		
		btnObrasYPaquetes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Generacion de paquetes
			  
				
				if (comboBoxObra.getSelectedItem()!=null) {
					
					String obra = (String) comboBoxObra.getSelectedItem();
					StringTokenizer tk = new StringTokenizer(obra, " - ");
					int numObra=Integer.parseInt(tk.nextToken());
					
					ReporteGenerador rp = new ReporteGenerador();
					
					
						try {
							rp.generarReporteCoordinacion2016(numObra);
						} catch (JRException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
				} else {
					javax.swing.JOptionPane.showMessageDialog(null, "Debe seleccionar una obra y un paquete asociado");
				}
	
			}
		});

	}
}
