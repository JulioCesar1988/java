package views;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import tools.CargadorCombobox;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.util.StringTokenizer;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import net.sf.jasperreports.engine.JRException;
import reportes.ReporteGenerador;

import java.awt.Component;
import java.awt.Panel;
import java.awt.ScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JSeparator;

public class Produccion extends JInternalFrame {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Produccion frame = new Produccion();
					frame.setVisible(true);
					frame.setMaximum(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Produccion() {
		setFrameIcon(new ImageIcon("Reportes\\logoHeader.png"));
		getContentPane().setForeground(Color.WHITE);
		setBackground(Color.DARK_GRAY);
		setMaximizable(true);
		setClosable(true);
		setForeground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Produccion");
		setBounds(100, 100, 992, 628);
		getContentPane().setLayout(null);
		
		JLabel lblReporteDeProduccion = new JLabel("Reporte de Produccion");
		lblReporteDeProduccion.setForeground(Color.DARK_GRAY);
		lblReporteDeProduccion.setBackground(Color.GRAY);
		lblReporteDeProduccion.setFont(new Font("SansSerif", Font.ITALIC, 18));
		lblReporteDeProduccion.setBounds(70, 6, 261, 33);
		getContentPane().add(lblReporteDeProduccion);
		
		JLabel lblObra = new JLabel("Obra");
		lblObra.setForeground(Color.DARK_GRAY);
		lblObra.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblObra.setBounds(25, 59, 55, 16);
		getContentPane().add(lblObra);
		
		JLabel lblPaquete = new JLabel("Paquete");
		lblPaquete.setBackground(Color.DARK_GRAY);
		lblPaquete.setForeground(Color.DARK_GRAY);
		lblPaquete.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblPaquete.setBounds(14, 113, 72, 16);
		getContentPane().add(lblPaquete);
		
		// cargamos los paquetes . 
				final JComboBox comboBoxPaquete = new JComboBox();
				comboBoxPaquete.setForeground(Color.DARK_GRAY);
				comboBoxPaquete.setBackground(Color.LIGHT_GRAY);
			
				comboBoxPaquete.setBounds(96, 103, 354, 26);
				getContentPane().add(comboBoxPaquete);
		
		
		
		// vamos a cargar el combobox . 
		
		CargadorCombobox cc = new CargadorCombobox();
		
		final JComboBox comboBoxObra = new JComboBox(cc.generarContenidoObra());
		comboBoxObra.setForeground(Color.DARK_GRAY);
		comboBoxObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("jlñasdfjlñasfjlñasfjlñasfjlñasf");
				String obra = (String) comboBoxObra.getSelectedItem();
				StringTokenizer tk2 = new StringTokenizer(obra, " - ");
				int obra_num=Integer.parseInt(tk2.nextToken());
				CargadorCombobox cc = new CargadorCombobox();
				comboBoxPaquete.setModel(new DefaultComboBoxModel(cc.generarContenidoPaquetesConDescripcion(obra_num)));
				
			}
		});
		
	
		comboBoxObra.setBackground(Color.LIGHT_GRAY);
		comboBoxObra.setBounds(96, 49, 354, 26);
		getContentPane().add(comboBoxObra);
		
		
		
		
		
		
		JButton btnGenerar = new JButton("Lista de Piezas");
		btnGenerar.setBackground(Color.WHITE);
		btnGenerar.setForeground(Color.DARK_GRAY);
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Agregar el reporte 
				
				
				if (comboBoxObra.getSelectedItem()!=null && comboBoxPaquete.getSelectedItem()!=null) {
					String obra = (String) comboBoxObra.getSelectedItem();
					StringTokenizer tk = new StringTokenizer(obra, " - ");
					int num_obra=Integer.parseInt(tk.nextToken());
					String paquete = (String) comboBoxPaquete.getSelectedItem();
					tk = new StringTokenizer(paquete, " - ");
					int num_paq=Integer.parseInt(tk.nextToken());
					
					ReporteGenerador rp = new ReporteGenerador();
					
						try {
							rp.generarReportePaquetePiezasPDF(num_obra, num_paq);
						} catch (JRException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
				} else {
					javax.swing.JOptionPane.showMessageDialog(null, "Debe seleccionar una obra y un paquete asociado");
				}
				
				
				
				
			}
		});
		btnGenerar.setBounds(70, 178, 162, 26);
		getContentPane().add(btnGenerar);
		
		JButton btnObrasEnProduccion = new JButton("Obras en produccion");
		btnObrasEnProduccion.setBackground(Color.WHITE);
		btnObrasEnProduccion.setForeground(Color.DARK_GRAY);
		btnObrasEnProduccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReporteGenerador rp = new ReporteGenerador();
				try {
					rp.generarReporteObrasActivas();
				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnObrasEnProduccion.setBounds(70, 293, 162, 23);
		getContentPane().add(btnObrasEnProduccion);
		
		JButton btnListadoDeObras = new JButton("Listado de obras ");
		btnListadoDeObras.setBackground(Color.WHITE);
		btnListadoDeObras.setForeground(Color.DARK_GRAY);
		btnListadoDeObras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteGenerador rp = new ReporteGenerador();
				try {
					rp.generarReporteObras();
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnListadoDeObras.setBounds(70, 327, 162, 23);
		getContentPane().add(btnListadoDeObras);
		
		JButton btnNewButton = new JButton("Lista de Subpiezas");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				if (comboBoxObra.getSelectedItem()!=null && comboBoxPaquete.getSelectedItem()!=null) {
					String obra = (String) comboBoxObra.getSelectedItem();
					StringTokenizer tk = new StringTokenizer(obra, " - ");
					int num_obra=Integer.parseInt(tk.nextToken());
					String paquete = (String) comboBoxPaquete.getSelectedItem();
					tk = new StringTokenizer(paquete, " - ");
					int num_paq=Integer.parseInt(tk.nextToken());
					
					ReporteGenerador rp = new ReporteGenerador();
					
						try {
							rp.generarReportePaqueteSubpiezasPDF(num_obra, num_paq);
						} catch (JRException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
				} else {
					javax.swing.JOptionPane.showMessageDialog(null, "Debe seleccionar una obra y un paquete asociado");
				}
				
			
			
			}
		});
		btnNewButton.setBounds(70, 217, 162, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnPiezasYSubpiezas = new JButton("Piezas y Subpiezas");
		btnPiezasYSubpiezas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (comboBoxObra.getSelectedItem()!=null && comboBoxPaquete.getSelectedItem()!=null) {
					String obra = (String) comboBoxObra.getSelectedItem();
					StringTokenizer tk = new StringTokenizer(obra, " - ");
					int num_obra=Integer.parseInt(tk.nextToken());
					String paquete = (String) comboBoxPaquete.getSelectedItem();
					tk = new StringTokenizer(paquete, " - ");
					int num_paq=Integer.parseInt(tk.nextToken());
					
					ReporteGenerador rp = new ReporteGenerador();
					
						try {
							rp.generarReportePaquetePiezasSubpiezasPDF(num_obra, num_paq);
						} catch (JRException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
				} else {
					javax.swing.JOptionPane.showMessageDialog(null, "Debe seleccionar una obra y un paquete asociado");
				}
				
				
				
				
				
			}
		});
		final JRadioButton rdbtnFiltro = new JRadioButton("Solo Produccion Pendiente");
		btnPiezasYSubpiezas.setBackground(Color.WHITE);
		btnPiezasYSubpiezas.setForeground(Color.DARK_GRAY);
		btnPiezasYSubpiezas.setBounds(70, 251, 162, 23);
		getContentPane().add(btnPiezasYSubpiezas);
		
		JButton btnProduccion = new JButton("Produccion  por obra");
		btnProduccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Agregamos el filtro 
			
				int filtro;
				
				
				if (rdbtnFiltro.isSelected()){
					     System.out.println("SELECCIONO ");
						 filtro = 0;
					} 
				else {
					System.out.println(" no selecciono nada ");
					filtro = 1;
					
				}
				
				
				
				if (comboBoxObra.getSelectedItem()!=null) {
					
					String obra = (String) comboBoxObra.getSelectedItem();
					StringTokenizer tk = new StringTokenizer(obra, " - ");
					int numObra=Integer.parseInt(tk.nextToken());
					
					ReporteGenerador rp = new ReporteGenerador();
					
					
						try {
							 rp.generarReporteProduccion2016(numObra,filtro);
						} catch (JRException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
				} else {
					javax.swing.JOptionPane.showMessageDialog(null, "Debe seleccionar una obra y un paquete asociado");
				}
				
				
				
			}
		});
		btnProduccion.setForeground(Color.DARK_GRAY);
		btnProduccion.setBackground(Color.WHITE);
		btnProduccion.setBounds(70, 361, 162, 23);
		getContentPane().add(btnProduccion);
		
		
		rdbtnFiltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("selecciono ");
			}
		});
		rdbtnFiltro.setBackground(Color.WHITE);
		rdbtnFiltro.setForeground(Color.DARK_GRAY);
		rdbtnFiltro.setBounds(238, 361, 261, 23);
		getContentPane().add(rdbtnFiltro);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 146, 725, 2);
		getContentPane().add(separator);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{getContentPane(), lblReporteDeProduccion, lblObra, lblPaquete, comboBoxPaquete, comboBoxObra, btnGenerar}));
	
		
		
		
		
		
		

	}
}
