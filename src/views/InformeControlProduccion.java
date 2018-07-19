package views;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.RadialGradientPaint;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;

import com.toedter.calendar.JDateChooser;

import controllers.EdificioController;
import controllers.ObrasController;
import net.sf.jasperreports.engine.JRException;
import reportes.ReporteGenerador;
import tools.CargadorCombobox;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class InformeControlProduccion extends JInternalFrame {

	JDateChooser dateChooser;
	JDateChooser dateChooser_1;
	JComboBox comboBoxObra;
	JComboBox comboBoxEdificio;
	JRadioButton rdbtnNewRadioButton;

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
		setFrameIcon(new ImageIcon("C:\\Users\\jcontreras\\eclipse-workspace\\java\\logo\\logoHeader.png"));
		setMaximizable(true);
		setClosable(true);
		setForeground(Color.WHITE);
		setTitle("Contorl de produccion");
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setBounds(100, 100, 669, 531);
		getContentPane().setLayout(null);

		final JComboBox comboBoxEdificio = new JComboBox();
		comboBoxEdificio.setEditable(false);
		comboBoxEdificio.setBackground(SystemColor.textHighlight);
		comboBoxEdificio.setBounds(10, 153, 181, 20);
		getContentPane().add(comboBoxEdificio);

		CargadorCombobox cc = new CargadorCombobox();
		comboBoxObra = new JComboBox(cc.generarContenidoObra());
		comboBoxObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String obra = (String) comboBoxObra.getSelectedItem();
				StringTokenizer tk2 = new StringTokenizer(obra, " - ");
				int obra_num = Integer.parseInt(tk2.nextToken());
				comboBoxEdificio.setModel(new DefaultComboBoxModel(generarContenidoEdificios(obra_num)));

			}

			private String[] generarContenidoEdificios(int obra) {
				CargadorCombobox cc = new CargadorCombobox();
				return cc.generarContenidoEdificiosParaModificar(obra);
			}

		});
		comboBoxObra.setBackground(SystemColor.textHighlight);
		comboBoxObra.setBounds(10, 68, 181, 20);
		getContentPane().add(comboBoxObra);

		JLabel lblObras = new JLabel("Obras");
		lblObras.setBounds(10, 53, 46, 14);
		getContentPane().add(lblObras);

		JLabel lblEdificio = new JLabel("Edificio");
		lblEdificio.setBounds(10, 138, 46, 14);
		getContentPane().add(lblEdificio);

		rdbtnNewRadioButton = new JRadioButton("Aplicar");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbtnNewRadioButton.isSelected()) {
					comboBoxEdificio.setEnabled(true);
				}else {
					comboBoxEdificio.setEnabled(false);
				}
				
				
				
				
				
			}
		});

		rdbtnNewRadioButton.setBounds(237, 152, 109, 23);
		getContentPane().add(rdbtnNewRadioButton);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 238, 297, 59);
		getContentPane().add(panel);

		// Agregando fechas
		dateChooser = new JDateChooser();
		dateChooser.setBounds(0, 54, 51, -54);
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooser.insets = new Insets(0, 0, 0, 5);
		gbc_dateChooser.gridx = 6;
		gbc_dateChooser.gridy = 1;
		panel.add(dateChooser, gbc_dateChooser);

		dateChooser_1 = new JDateChooser();
		GridBagConstraints gbc_dateChooser_1 = new GridBagConstraints();
		gbc_dateChooser_1.insets = new Insets(0, 0, 0, 5);
		gbc_dateChooser_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooser_1.gridx = 9;
		gbc_dateChooser_1.gridy = 1;
		panel.add(dateChooser_1, gbc_dateChooser_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(20, 194, 450, 2);
		getContentPane().add(separator);

		JButton btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("paso 1 ");
				
				if ((dateChooser.getDate() != null) && (dateChooser_1.getDate() != null)) {
					System.out.println("paso 2 ");

					if (comboBoxObra.getSelectedItem() != null) {
						System.out.println("paso 3");
						
						// No seleciono edificio ó no aplico el filtro
						if ((rdbtnNewRadioButton.isSelected())) {
							System.out.println("paso 4");
								System.out.println("Filtrado de Edificio Aplicado");
								if (comboBoxEdificio.getSelectedItem() != null) {
									System.out.println("Obra -> " + comboBoxObra.getSelectedIndex());
									System.out.println("Edificio -> " + comboBoxEdificio.getSelectedIndex());
									System.out.println("Edificio -> " + (String) comboBoxEdificio.getSelectedItem());
									System.out.println("Proceso de generacion de informe -> ....");
									// Generacion de Reporte con filtro de edificios .
									String formato = dateChooser.getDateFormatString();
									Date date = dateChooser.getDate();
									SimpleDateFormat sdf = new SimpleDateFormat(formato);

									System.out.println("Desde -> " + String.valueOf(sdf.format(date)));
									String desde = String.valueOf(sdf.format(date));
									Date date1 = dateChooser_1.getDate();
									System.out.println("Hasta -> " + String.valueOf(sdf.format(date1)));
                                    String hasta = String.valueOf(sdf.format(date1));
									System.out.println("Proceso de generacion de informe -> ....");
									
									String obra = (String) comboBoxObra.getSelectedItem();
									StringTokenizer tk = new StringTokenizer(obra, " - ");
									int num_obra = Integer.parseInt(tk.nextToken());
									
                                    ReporteGenerador rp = new ReporteGenerador();
                            
                                    
									try {

	                                    int id_obra = 0;
								        // buscamos informacion del edifio para enviar al filtro 
	                                    EdificioController  ed = new EdificioController();
	                                    ObrasController ob = new ObrasController();
										id_obra = ob.getIdObraPorId(num_obra);
										int id_edificio = ed.getIdEdificioPorNombre((String) comboBoxEdificio.getSelectedItem(), id_obra);
										try {
											rp.generarReporteControlProduccion2018PDFConFiltro(desde,hasta,num_obra ,id_edificio);
										} catch (JRException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										
										
									} catch (SQLException e2) {
										// TODO Auto-generated catch block
										e2.printStackTrace();
									}
                                   
                                    
                                 
                                    
									
								} else {
									System.out.println("No ingreso Edificio !!!");
								}

							} else {
								System.out.println("Sin Aplicacion de Filtrado");
								// Generacion de Reporte sin filtro de edificios .
								System.out.println(" Obra - > " + comboBoxObra.getSelectedIndex());
								String obra = (String) comboBoxObra.getSelectedItem();
								StringTokenizer tk = new StringTokenizer(obra, " - ");
								int num_obra = Integer.parseInt(tk.nextToken());
								String formato = dateChooser.getDateFormatString();
								Date date = dateChooser.getDate();
								SimpleDateFormat sdf = new SimpleDateFormat(formato);
								System.out.println("Desde -> " + String.valueOf(sdf.format(date)));
								String desde = String.valueOf(sdf.format(date));
								Date date1 = dateChooser_1.getDate();
								System.out.println("Hasta -> " + String.valueOf(sdf.format(date1)));
                                String hasta = String.valueOf(sdf.format(date1));
								System.out.println("Proceso de generacion de informe -> ....");
								ReporteGenerador rp = new ReporteGenerador();
                                           try {
									 rp.generarReporteControlProduccion2018PDF(desde,hasta,num_obra);
                                } catch (JRException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

							}

					} else {
						
						System.out.println("No selecciono Obra ");
						
						
					}

					
				} else {

					System.out.println("Falta ingresar alguna fecha valida ");

				}


			}
		});
		btnGenerar.setBackground(SystemColor.activeCaption);
		btnGenerar.setBounds(10, 396, 89, 23);
		getContentPane().add(btnGenerar);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\jcontreras\\eclipse-workspace\\java\\logo\\logoHeader.png"));
		label.setBounds(414, 31, 165, 142);
		getContentPane().add(label);

		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setForeground(Color.DARK_GRAY);
		lblDesde.setBounds(64, 213, 46, 14);
		getContentPane().add(lblDesde);

		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setBounds(169, 213, 46, 14);
		getContentPane().add(lblHasta);

	}
}
