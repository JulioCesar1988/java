package views;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.engine.JRException;
import reportes.ReporteGenerador;
import tools.CargadorCombobox;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;

public class Warehouse extends JInternalFrame {
	private JTextField textFieldCodigoPieza;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Warehouse frame = new Warehouse();
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
	public Warehouse() {
		setFrameIcon(new ImageIcon("Reportes\\logoHeader.png"));
		setMaximizable(true);
		getContentPane().setBackground(Color.WHITE);
		setClosable(true);
		setTitle("Warehouse");
		setBounds(100, 100, 1027, 601);
		getContentPane().setLayout(null);
		
		JLabel lblInformacionParaEl = new JLabel("Informacion  para el sector de pa\u00F1ol ");
		lblInformacionParaEl.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInformacionParaEl.setForeground(Color.DARK_GRAY);
		lblInformacionParaEl.setBounds(10, 11, 249, 14);
		getContentPane().add(lblInformacionParaEl);
		
		JLabel lblObra = new JLabel("Obra");
		lblObra.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblObra.setForeground(Color.DARK_GRAY);
		lblObra.setBounds(10, 58, 46, 14);
		getContentPane().add(lblObra);
		
		JLabel lblPaquete = new JLabel("Paquete");
		lblPaquete.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPaquete.setForeground(Color.DARK_GRAY);
		lblPaquete.setBounds(10, 104, 62, 14);
		getContentPane().add(lblPaquete);
		
		JLabel lblCodigoDePiezas = new JLabel("Codigo de piezas");
		lblCodigoDePiezas.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCodigoDePiezas.setForeground(Color.DARK_GRAY);
		lblCodigoDePiezas.setBounds(10, 143, 108, 14);
		getContentPane().add(lblCodigoDePiezas);
		
		JLabel lblElemento = new JLabel("Elemento ");
		lblElemento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblElemento.setForeground(Color.DARK_GRAY);
		lblElemento.setBounds(10, 180, 69, 14);
		getContentPane().add(lblElemento);
		
		JLabel lblRemito = new JLabel("Remito");
		lblRemito.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRemito.setForeground(Color.DARK_GRAY);
		lblRemito.setBounds(10, 218, 46, 14);
		getContentPane().add(lblRemito);
		
		CargadorCombobox cc = new CargadorCombobox();
		
		final JComboBox comboBoxObra = new JComboBox(cc.generarContenidoObra());
		
		comboBoxObra.setBounds(98, 55, 229, 20);
		getContentPane().add(comboBoxObra);
		
		final JComboBox comboBoxPaquete = new JComboBox();
		comboBoxPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		comboBoxPaquete.setBounds(98, 101, 229, 20);
		getContentPane().add(comboBoxPaquete);
		
		
		final JComboBox comboBoxElemento = new JComboBox(cc.generarContenidoElementosTodos());
		comboBoxElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBoxElemento.setBounds(98, 177, 229, 20);
		getContentPane().add(comboBoxElemento);
		
		final JComboBox comboBoxRemito = new JComboBox();
		comboBoxRemito.setBounds(98, 215, 229, 20);
		getContentPane().add(comboBoxRemito);
		
		JButton btnGnenerar = new JButton("generar");
	
		btnGnenerar.setBounds(98, 304, 89, 23);
		getContentPane().add(btnGnenerar);
		
		textFieldCodigoPieza = new JTextField();
		textFieldCodigoPieza.setBounds(128, 141, 199, 20);
		getContentPane().add(textFieldCodigoPieza);
		textFieldCodigoPieza.setColumns(10);
		
		final JRadioButton rdbtnAplicarPaquete = new JRadioButton("aplicar ");
		rdbtnAplicarPaquete.setBackground(Color.WHITE);
		rdbtnAplicarPaquete.setForeground(Color.DARK_GRAY);
		rdbtnAplicarPaquete.setBounds(355, 101, 109, 23);
		getContentPane().add(rdbtnAplicarPaquete);
		
		final JRadioButton rdbtnAplicarElemento = new JRadioButton("aplicar");
		rdbtnAplicarElemento.setBackground(Color.WHITE);
		rdbtnAplicarElemento.setForeground(Color.DARK_GRAY);
		rdbtnAplicarElemento.setBounds(355, 177, 109, 23);
		getContentPane().add(rdbtnAplicarElemento);
		
		final JRadioButton rdbtnAplicarRemito = new JRadioButton("aplicar");
		rdbtnAplicarRemito.setBackground(Color.WHITE);
		rdbtnAplicarRemito.setForeground(Color.DARK_GRAY);
		rdbtnAplicarRemito.setBounds(355, 215, 109, 23);
		getContentPane().add(rdbtnAplicarRemito);
		
		final JRadioButton rdbtnAplicarCodigoPieza = new JRadioButton("aplicar");
		rdbtnAplicarCodigoPieza.setBackground(Color.WHITE);
		rdbtnAplicarCodigoPieza.setForeground(Color.DARK_GRAY);
		rdbtnAplicarCodigoPieza.setBounds(355, 140, 109, 23);
		getContentPane().add(rdbtnAplicarCodigoPieza);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(28, 274, 548, 2);
		getContentPane().add(separator);
		
		
		
		
		
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
		
		
		btnGnenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// declaracion de los filtros. 
				
				int numRemito = 0;
				int numCodigo = 0; 
			    String elem = "nada";
			    int num_paq = 0;
				int num_obra = 0;
			    
			    
			    ReporteGenerador rp = new ReporteGenerador();
				
			    
			    // Filtro de obra 
			    
				if (comboBoxObra.getSelectedItem()!= null) {
					String obra = (String) comboBoxObra.getSelectedItem();
					StringTokenizer tk = new StringTokenizer(obra, " - ");
					 num_obra=Integer.parseInt(tk.nextToken());	
				}else {
					javax.swing.JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Obra "); 
				}
				
				
					
					
					// Filtro de paquete puede o no filtrar por paquete .
				if (rdbtnAplicarPaquete.isSelected()){
					 if ( comboBoxPaquete.getSelectedItem()!=null)
					 {
						 String paquete = (String) comboBoxPaquete.getSelectedItem();
							StringTokenizer tk2 = new StringTokenizer(paquete, " - ");
							num_paq=Integer.parseInt(tk2.nextToken());
					 }
					 
					 else {

						     num_paq = 0;	 
					 }
				}
					 
					 
					 
					// Filtro de elementos  	 
					 if (rdbtnAplicarElemento.isSelected()){
					 if ( comboBoxElemento.getSelectedItem()!=null)
					 {
						 elem = (String) comboBoxElemento.getSelectedItem();
						
					 }
					 else {

						     elem = "nada";	 
					 }
					 
					 }
					 
					 // Filtro de Codigo de Piezas .
					 if (rdbtnAplicarCodigoPieza.isSelected()){
					 if (textFieldCodigoPieza.getText().length()>0){
						
						 
						 
						 try {
							   
							 numCodigo = Integer.parseInt((textFieldCodigoPieza.getText()));
							   
							} catch (NumberFormatException e1) {
							    // One of the integer fields failed to parse. Do something to alert the user.
								javax.swing.JOptionPane.showMessageDialog(null, "No ingreso un codigo de pieza valido."); 
							}
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
					 }
					 else {
						     numCodigo = 0;	 
					 }
					 }
					
					
	                 // Filtro de Remito
						if (rdbtnAplicarRemito.isSelected()){
							if (comboBoxRemito.getSelectedItem()!=null ) {
								String remito = (String) comboBoxRemito.getSelectedItem();
								numRemito = Integer.parseInt(remito);
							}
							else
							{
								javax.swing.JOptionPane.showMessageDialog(null, "Debe seleccionar un numero de remito , para aplicar el filtro"); 
							}
							
						} 

				
						try {
							rp.generarReporteWarehouse2016( num_obra , elem , numRemito ,num_paq , numCodigo);
						} catch (JRException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			}
			
			
			});
		
		

	}
}
