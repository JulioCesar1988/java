package views;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;

import tools.CargadorCombobox;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import net.sf.jasperreports.engine.JRException;
import reportes.ReporteGenerador;

public class ControlDeProduccion extends JInternalFrame {
	private JTextField textFieldCorrelatividad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlDeProduccion frame = new ControlDeProduccion();
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
	public ControlDeProduccion() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setFrameIcon(new ImageIcon("Reportes\\logoHeader.png"));
		setMaximizable(true);
		setClosable(true);
		getContentPane().setBackground(Color.WHITE);
		
		final JComboBox comboBoxElementos = new JComboBox();
		
		JLabel lblObra = new JLabel("Obra ");
		lblObra.setBounds(10, 11, 46, 14);
		getContentPane().add(lblObra);
		
		JLabel lblPosiciones = new JLabel("Elemento");
		lblPosiciones.setBounds(10, 66, 142, 14);
		getContentPane().add(lblPosiciones);
		
		
		final CargadorCombobox cc = new CargadorCombobox();
		
		final JComboBox comboBoxObra = new JComboBox(cc.generarContenidoObra());
		comboBoxObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		         // Aca vamos a cargar los elemento de la obra seleccionada . 
				
				String obra = (String) comboBoxObra.getSelectedItem();
				StringTokenizer tk2 = new StringTokenizer(obra, " - ");
				int obra_num=Integer.parseInt(tk2.nextToken());
				CargadorCombobox cc = new CargadorCombobox();
				comboBoxElementos.setModel(new DefaultComboBoxModel(cc.generarContenidoElementosTodos()));
				
			
				
				
			}
		});
		comboBoxObra.setBackground(Color.WHITE);
		comboBoxObra.setBounds(90, 8, 259, 20);
		getContentPane().add(comboBoxObra);
		
		
		
		
		
		comboBoxElementos.setBounds(90, 63, 259, 20);
		getContentPane().add(comboBoxElementos);
		
		JButton btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String elem;
				String obra = (String) comboBoxObra.getSelectedItem();
				StringTokenizer tk2 = new StringTokenizer(obra, " - ");
				int obra_num=Integer.parseInt(tk2.nextToken());
			
				 if ( comboBoxElementos.getSelectedItem()!=null)
				 {
					 elem = (String) comboBoxElementos.getSelectedItem();
					
				 }
				 else {

					     elem = "nada";	 
				 }
				
	
				 String correlatividad;
				 if(textFieldCorrelatividad.getText().length()>0)
				 { correlatividad = textFieldCorrelatividad.getText(); 
				 }else
				     { correlatividad = "nada";
				     }  
				 
				 
				 ReporteGenerador rp = new ReporteGenerador(); 
				 
				 try {
					rp.generarReporteDePesoPieza2016(obra_num ,elem ,correlatividad );
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				 
				
				
			}
		});
		btnVer.setBounds(10, 263, 89, 23);
		getContentPane().add(btnVer);
		
		JLabel lblPosicion = new JLabel("Correlatividad");
		lblPosicion.setBounds(10, 129, 68, 14);
		getContentPane().add(lblPosicion);
		
		textFieldCorrelatividad = new JTextField();
		textFieldCorrelatividad.setBounds(88, 126, 86, 20);
		getContentPane().add(textFieldCorrelatividad);
		textFieldCorrelatividad.setColumns(10);
		setTitle("Peso de Pieza");
		setBounds(100, 100, 789, 653);

	}
}
