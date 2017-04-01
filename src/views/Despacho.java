package views;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;
import net.sf.jasperreports.engine.JRException;
import reportes.ReporteGenerador;
import tools.CargadorCombobox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.ImageIcon;


public class Despacho extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JComboBox comboBoxObra;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Despacho frame = new Despacho();
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
	public Despacho() {
		setFrameIcon(new ImageIcon("Reportes\\logoHeader.png"));
		setMaximizable(true);
		setClosable(true);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Despacho");
		setBounds(100, 100, 1042, 665);
		getContentPane().setLayout(null);
		
		JLabel lblObra = new JLabel("Obra");
		lblObra.setBackground(Color.DARK_GRAY);
		lblObra.setForeground(Color.DARK_GRAY);
		lblObra.setBounds(10, 37, 86, 14);
		getContentPane().add(lblObra);
		
		JLabel lblPaquete = new JLabel("Paquete");
		lblPaquete.setBackground(Color.DARK_GRAY);
		lblPaquete.setForeground(Color.DARK_GRAY);
		lblPaquete.setBounds(10, 87, 86, 14);
		getContentPane().add(lblPaquete);
		
		final JComboBox comboBoxPaquete = new JComboBox();
		comboBoxPaquete.setBackground(Color.WHITE);
		comboBoxPaquete.setForeground(Color.DARK_GRAY);
		final JComboBox comboBoxRemito = new JComboBox();
		comboBoxRemito.setBackground(Color.WHITE);
		comboBoxRemito.setForeground(Color.DARK_GRAY);
		comboBoxPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    // Cargar Remitos 
				
				
				
				
				
				
			}
		});
		CargadorCombobox cc = new CargadorCombobox();
		
		comboBoxObra = new JComboBox(cc.generarContenidoObra());
		comboBoxObra.setBackground(Color.LIGHT_GRAY);
		comboBoxObra.setForeground(Color.DARK_GRAY);
		comboBoxObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String obra = (String) comboBoxObra.getSelectedItem();
				StringTokenizer tk2 = new StringTokenizer(obra, " - ");
				int obra_num=Integer.parseInt(tk2.nextToken());
				CargadorCombobox cc = new CargadorCombobox();
				comboBoxPaquete.setModel(new DefaultComboBoxModel(cc.generarContenidoPaquetesConDescripcion(obra_num)));
				
				
				
				
				comboBoxRemito.setModel(new DefaultComboBoxModel(cc.generarNumeroRemito(obra_num)));
				
			}
		});
		
		comboBoxObra.setBounds(155, 34, 322, 20);
		getContentPane().add(comboBoxObra);
		
		
		comboBoxPaquete.setBounds(155, 84, 223, 20);
		getContentPane().add(comboBoxPaquete);
		final JRadioButton rdbtnFiltro = new JRadioButton("Solo faltantas a despachar");
		final JRadioButton rdbtnAplicarPaquete = new JRadioButton("aplicar");
		final JRadioButton rdbtnAplicarRemito = new JRadioButton("aplicar");
		JButton btnGenerar = new JButton("generar");
		btnGenerar.setBackground(Color.GRAY);
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				// Agregamos el filtro 
				
				int filtro = 1;
				int numObra = 0;
				int numPaquete = 0;
				int numRemito = 0;
				int numCodigo = 0; 
			
			
				
				if (comboBoxObra.getSelectedItem()!=null && comboBoxPaquete.getSelectedItem()!=null) {
					String obra = (String) comboBoxObra.getSelectedItem();
					StringTokenizer tk = new StringTokenizer(obra, " - ");
					int num_obra=Integer.parseInt(tk.nextToken());
					String paquete = (String) comboBoxPaquete.getSelectedItem();
					tk = new StringTokenizer(paquete, " - ");
					int num_paq=Integer.parseInt(tk.nextToken());
					
					ReporteGenerador rp = new ReporteGenerador();
					
						try {
							
							
							if (rdbtnFiltro.isSelected()){
							     System.out.println("Selecciono Filtro Solo faltates a despachar");
								 filtro = 0;
							} 
						
						
						
						if (rdbtnAplicarPaquete.isSelected()){
						     System.out.println("Selecciono Filtro Paquete ");
							 
						} 
					else {
						System.out.println(" No Selecciono  filtro Paquete  ");
						num_paq = 0;					
					}
						
						if (rdbtnAplicarRemito.isSelected()){
							
							if (comboBoxRemito.getSelectedItem()!=null ) {
								
								
								String remito = (String) comboBoxRemito.getSelectedItem();
								numRemito = Integer.parseInt(remito);
							
							}
							else
							{
								javax.swing.JOptionPane.showMessageDialog(null, "Debe seleccionar un numero de remito , para aplicar el filtro"); 
							}
							
							
							
						     System.out.println("Selecciono filtro remito");
							
						} 
					else {
						System.out.println(" No selecciono filtro remito");
						numRemito = 0;					
					}
							
							
							
							rp.generarReporteDespacho2016 ( num_obra , num_paq , numRemito , filtro , numCodigo);
						
						} catch (JRException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
				} else {
					javax.swing.JOptionPane.showMessageDialog(null, "Debe seleccionar una obra y un paquete asociado");
				}
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnGenerar.setBounds(10, 271, 99, 23);
		getContentPane().add(btnGenerar);
		
		JLabel lblRemito = new JLabel("Remito");
		lblRemito.setBackground(Color.DARK_GRAY);
		lblRemito.setForeground(Color.DARK_GRAY);
		lblRemito.setBounds(10, 141, 86, 14);
		getContentPane().add(lblRemito);
		
		
		comboBoxRemito.setBounds(155, 138, 223, 20);
		getContentPane().add(comboBoxRemito);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 237, 985, 17);
		getContentPane().add(separator);
		
		
		rdbtnAplicarRemito.setBackground(Color.WHITE);
		rdbtnAplicarRemito.setForeground(Color.DARK_GRAY);
		rdbtnAplicarRemito.setBounds(425, 137, 109, 23);
		getContentPane().add(rdbtnAplicarRemito);
		
		
		rdbtnAplicarPaquete.setBackground(Color.WHITE);
		rdbtnAplicarPaquete.setForeground(Color.DARK_GRAY);
		rdbtnAplicarPaquete.setBounds(425, 83, 109, 23);
		getContentPane().add(rdbtnAplicarPaquete);
		
		
		rdbtnFiltro.setForeground(Color.DARK_GRAY);
		rdbtnFiltro.setBackground(Color.WHITE);
		rdbtnFiltro.setBounds(155, 271, 309, 23);
		getContentPane().add(rdbtnFiltro);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.DARK_GRAY);
		panel.setBackground(Color.WHITE);
		panel.setBounds(323, 179, 426, 45);
		getContentPane().add(panel);
		
		JLabel lblLosRemitosSon = new JLabel("Los Remitos son de la Obra seleccionada , no estan asociados al paquete .");
		lblLosRemitosSon.setBackground(Color.DARK_GRAY);
		lblLosRemitosSon.setForeground(Color.DARK_GRAY);
		panel.add(lblLosRemitosSon);
		
		
	

	}
}
