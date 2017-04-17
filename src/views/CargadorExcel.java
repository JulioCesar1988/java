package views;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.List;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JTextField;
import tools.CargadorCombobox;
import javax.swing.border.BevelBorder;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.lowagie.text.Row;
import com.toedter.calendar.JDateChooser;

import controllers.ElementoController;
import controllers.ObrasController;
import controllers.SistemaController;
import controllers.UsuarioController;
import groovyjarjarantlr.StringUtils;
import models.PaqueteBean;
import models.PiezaBean;
import models.SubpiezaBean;
import session.Session;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import java.awt.Scrollbar;
import java.awt.TextArea;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CargadorExcel extends JInternalFrame {
	public  JTextField textFieldPath;
	public  JComboBox<String> comboBoxEdificio;
    public  JComboBox<String> comboBoxObra;
	public  JComboBox<String> comboBoxSistemas;
	public  TextArea textArea;
	public File selectedFile;
	private JTextField textFieldDescripcion;
	JDateChooser dateChooserFinalizacion;
	JDateChooser dateChooserDespacho;
	public ArrayList<PiezaBean> piezas = new ArrayList<PiezaBean>();
	
	
	
 	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CargadorExcel frame = new CargadorExcel();
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
	@SuppressWarnings("unchecked")
	public CargadorExcel() {
		setBackground(Color.DARK_GRAY);
		setClosable(true);
		setMaximizable(true);
		setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setEnabled(false);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.WHITE);
		setFrameIcon(new ImageIcon("C:\\Users\\jcontreras\\Desktop\\myprogram\\nuevo\\Julinchy\\logo\\logoHeader.png"));
		setTitle("Cargador Excel");
		setBounds(100, 100, 973, 753);
		getContentPane().setLayout(null);

		 final JComboBox comboBoxEdificio = new JComboBox();
		comboBoxEdificio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
			}
		});
	
			JLabel lblEdificio = new JLabel("Edificio");
			lblEdificio.setBounds(274, 109, 46, 14);
			getContentPane().add(lblEdificio);
		
	
		
			CargadorCombobox cc = new CargadorCombobox();
			comboBoxObra = new JComboBox(cc.generarContenidoObra() );
			comboBoxObra.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent e) {
				String obra = (String) comboBoxObra.getSelectedItem();
				StringTokenizer tk2 = new StringTokenizer(obra, " - ");
				int obra_num = Integer.parseInt(tk2.nextToken());
				
				CargadorCombobox cc = new CargadorCombobox();
				 String[]  lista   =  cc.generarContenidoEdificiosParaModificar(obra_num);
				 
				 if (lista.length > 0 ) {
					 comboBoxEdificio.setModel(new DefaultComboBoxModel(lista));
					 

					 System.out.println(" Edificio seleccionado :" +comboBoxEdificio.getSelectedItem());
					 
							
				} else {
					comboBoxEdificio.setModel(new DefaultComboBoxModel( lista));
					System.out.println("esta obra no tiene edificio ... ");

				}
				
		
				}

			
					
			});
			
			JLabel lblObra = new JLabel("Obra");
			lblObra.setBounds(274, 60, 46, 14);
			getContentPane().add(lblObra);
		
		
			
			JLabel lblSistemaDiseo = new JLabel("Sistema");
			lblSistemaDiseo.setBounds(549, 57, 113, 14);
			getContentPane().add(lblSistemaDiseo);
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon("C:\\Users\\jcontreras\\Desktop\\myprogram\\nuevo\\Julinchy\\logo\\logoHeader.png"));
			label.setBounds(741, 521, 189, 166);
			getContentPane().add(label);
			comboBoxObra.setBackground(Color.WHITE);
			comboBoxObra.setForeground(Color.DARK_GRAY);
			comboBoxObra.setBounds(33, 54, 231, 20);
			getContentPane().add(comboBoxObra);
		
		
		
	
	
	
		comboBoxEdificio.setBackground(Color.WHITE);
		comboBoxEdificio.setForeground(Color.DARK_GRAY);
		comboBoxEdificio.setBounds(33, 106, 231, 20);
		getContentPane().add(comboBoxEdificio);

		SistemaController s = new SistemaController();
		try {
			comboBoxSistemas = new JComboBox(s.getListaDeSistemas());
			comboBoxSistemas.setBackground(Color.WHITE);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		comboBoxSistemas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Sistema seleccionado : " +  comboBoxSistemas.getSelectedItem() );
				
			}
		});
		comboBoxSistemas.setBounds(349, 54, 198, 20);
		getContentPane().add(comboBoxSistemas);
		

		textFieldPath = new JTextField();
		textFieldPath.setBackground(Color.WHITE);
		textFieldPath.setBounds(33, 153, 320, 20);
		getContentPane().add(textFieldPath);
		textFieldPath.setColumns(10);
		
	
	
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 244, 844, 2);
		getContentPane().add(separator);
		
		
		JButton btnSeleccionarExcel = new JButton("Seleccionar Excel");
		btnSeleccionarExcel.setBackground(Color.WHITE);
		btnSeleccionarExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			// Áca vamos a seleccionar el archivo excel.	
				
				JFileChooser fileChooser = new JFileChooser();
			      int returnValue = fileChooser.showOpenDialog(null);
			      if (returnValue == JFileChooser.APPROVE_OPTION) {
			        selectedFile = fileChooser.getSelectedFile();
			           // Acá ya tengo el path del archivo 
			           textFieldPath.setText(selectedFile.getPath()  ); 
			        
				          
			      }
				
			      

			
			}
		});
		
		
		
		

		JButton btnCargar = new JButton("Cargar");
		btnCargar.setBackground(Color.WHITE);
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
		
				try {
					
					// SESION ( NECESARIA PARA ALGUNOS CONTROLADRES PARA TOMAR EL DATO DEL USUARIO )   
					String usuario = "MBI266";
					String password = "MBI266"; 
					Session session = new Session(); 
					session.cargarUsuario(usuario, password);
					UsuarioController uController = new UsuarioController();
					int res = 0;
					
					
					//int u = Integer.parseInt(usuario);
					res = uController.getUsuario(266, password);
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.out.println("Usuario logeado : "+  session.Session.getNombreUsuario() );
				
				
				
				PaqueteBean paq = new PaqueteBean(); // MODELO DEL PAQUETE QUE TENEMOS QUE GUARDAR EN LA BASE DE DATOS .
				PiezaBean    pieza = null;  		 // MODELO DE LA PIEZA LA CUAL TENGO QUE CARGAR CON LOS DATOS DEL EXCEL 
				SubpiezaBean subpieza = null;        // MODELO DE LA SUBPIEZA 
		        ElementoController ctl_elem = new ElementoController();  // CONTROLADOR NECESARIO PARA ALLAR EN AREA DE UNA PIEZA. 

				
		        
		        
				// Lectura del CSV 
				
				String csvFile = selectedFile.getPath();
		        String line = "";
		        String cvsSplitBy = ";";
		        
		        try {
		       
		        	BufferedReader br = new BufferedReader(new FileReader(csvFile));
		        	boolean primero = true;
		            while ((line = br.readLine()) != null) {
		            	if(!primero){
		            		
		            		String[] country = line.split(cvsSplitBy);
		                    
		                	if(country[0].trim().length()> 0) {                  // ENTRO A PROCESAR LA PIEZA  DEL EXCEL (CSV)
		                		 
		                		pieza = new PiezaBean();                         // INSTANCIO EL MODELO , PARA PODER IR CARGANDO CON LOS CAMPOS DEL CSV 
		                		
		                		
		                		
		                		System.out.println("Creando una pieza... ");              // VEO LOS DATOS QUE ESTOY LEYENDO 
		                		System.out.print("   Conjunto: " + country[0].trim());                		
		                		System.out.print("   Dato1: " + country[1].trim());
		                		System.out.print("   Cant. Conj.: " + country[3].trim());
		                		System.out.print("   Longitud: " + country[6].trim());
		                		System.out.print("   Peso: " + country[8].trim());
		                		System.out.print("   Pintura: " + country[9].trim());
		                		System.out.println("   Descripcion: " + country[10].trim());
		                       
		                         
		                		
		                		
		                		 int Cantidad = Integer.parseInt(country[3].trim()); // COMENAZAMOS A CARGAR LA PIEZA CON LOS DATOS DEL EXCEL HACIENDO LAS CONVERSIONES QUE SEAN NECESARIAS DADO QUE ALGUNOS DATOS SON INT.
		                		 pieza.setCantidad( Cantidad);
		                		 
		                		// System.out.println("Cantidad " + pieza.getCantidad());  // DE PASO , VALIDAMOS SI LA PIEZA SE CARGO CON SU CAMPO.
		                		 
		                		 
		                		String correlatividad = country[1].trim();
		                		pieza.setCorrelatividad(correlatividad);
		                		 
		                	//	System.out.println("correlatividad " + pieza.getCorrelatividad() );
		                		 
		                		
		                		String elem = country[0].trim();
		                		pieza.setElemento(elem);  
		                		
		                	//	System.out.println("Elemento " + pieza.getElemento());
		                		 
		                		
		                		
		                		
		                		pieza.setDescripcion("Prueba de sistemas");
		                		
		                	//	System.out.println("Descripcion " + pieza.getDescripcion()  );
		                		
		                		String descripcion_extra = country[10].trim();
		                		pieza.setDescripcion_extra(descripcion_extra);
		                		 
		                	//	System.out.println("Descripcion extra " + pieza.getDescripcion_extra() );
		                		 
		                		
		                		
		                		String Pintura = country[9].trim(); //   
		                		 if (Pintura.length()> 0 ) {
		                			 
		                		 pieza.setPintura(true);
		                		pieza.setColor(Pintura);
		                		
		                		
		                	//	System.out.println("Pintar " + pieza.getColor());
		                
		                		 
		                			 
		                		 }else{
									
		                		pieza.setPintura(false);
		                		  pieza.setColor("");
		                		 }
		                		 
		                		int  longitud =  Integer.parseInt(country[6].trim());// Cargamos la longitud(el largo de la pieza).   
		                		pieza.setLargo(longitud);
		                         
		                	//	System.out.println("Largo " + pieza.getLargo() );
		                		
		                		
		                		
		                		pieza.setPesoUnitario(0);// Deberia de traerlo de la BD. 
		                         
		                	 String s = (String) comboBoxSistemas.getSelectedItem(); 
		                	 String area;
							try {
								area = ctl_elem.getArea(elem,s);
								pieza.setArea( area ); // Cargamos el area de la pieza dado el elemento de esa pieza.
						//		System.out.println("Area  " + pieza.getArea()); 
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		                	 
							
		                         
		                      // TERMINAMOS DE CARGAR LA PIEZA , AHORA AL SALIR DE ACA , DEBERIAMOS CARGAR LAS SUBPIEZAS DE MI  PIEZA. 
		                		 
										
		                	  } else if (country[2].trim().length()>0) {   // ACA ENTRAMOS A PROCESAR LAS SUBPIEZAS 
		                        
		                		  
		                		  
		                		// GUARDAMOS LOS DATOS DE LA SUBPIEZAS , ESTAS SUBPIEZA PROCESADA CORRESPONDE A LA PIEZA  DEL PRIMER IF 
		                		System.out.println("     Creando una subpieza... ");
		            			System.out.print("        Parte: " + country[2].trim());                		
		                		System.out.print("        Cant.: " + country[4].trim());
		                		System.out.print("        Perfil: " + country[5].trim());
		                		System.out.print("        Longitud: " + country[6].trim());
		                		System.out.print("        Area: " + country[7].trim());
		                		System.out.println("        Peso: " + country[8].trim());
		                		
		                		
		                		 SubpiezaBean sub = new SubpiezaBean(); // GENERO LA INSTANCIA DE LA SUBPIEZAS PARA CARGAR 
		                		
		                			sub.setIdPiezaPadre(pieza.getIdPieza());// Asigno el ID de mi pieza.
		                		 	int cantSub = Integer.parseInt(country[4].trim());  
		                		 	sub.setCantidad(cantSub); // Cargo la Cantidad 
		    
		                		 	int largoSubpieza = Integer.parseInt(country[6].trim());
		                		 	sub.setLargo( largoSubpieza); // Asignacion del largo de la subpiezas. 
		                		
		                		 	String codMaterial =  (String ) country[5].trim();
		                		    sub.setCodigoMaterial(codMaterial);// Asignamos condigo de material(el material tenemos que buscarlo de la BD) .
		                	       
		                		    sub.setIdMaterial(2);  // ASIGNAMOS ALGUN ID DE UN MATERIAL .
		                		    sub.setCorrelatividad("7777");
		                		    
		                		    
		                	
		                		// INFORMACION DE LA SUBPIEZA  
		                //		System.out.println(" subpieza id  PADRE: " + sub.getIdPiezaPadre());
		                //		System.out.println(" subpieza CANTIDAD : " + sub.getCantidad());
		                //		System.out.println(" subpieza LARGO : " + sub.getLargo());
		                //		System.out.println(" subpieza CODIGO MATERIAL : " + sub.getCodigoMaterial());
		                		
		                		
		                		// AL PROCESAR UNA SUBPIEZA TENGO QUE GUARDARLA EN LA PIEZA . 
		                		pieza.añadirSubpieza(sub);
		                			
		                	} else {
		                		
		                		piezas.add(pieza);
		                		System.out.println("**************************INTENTO GUARDAR UN PAQUETE ");
		                		
		                		paq.setPiezas(piezas);
		                		String formato = dateChooserFinalizacion.getDateFormatString();
								java.util.Date date = dateChooserFinalizacion.getDate();
								SimpleDateFormat sdf = new SimpleDateFormat(formato); 
								
								String formato1 = dateChooserDespacho.getDateFormatString();
								java.util.Date date1 = dateChooserDespacho.getDate();
								SimpleDateFormat sdf1 = new SimpleDateFormat(formato1); 
								
								String obra = (String) comboBoxObra.getSelectedItem();
								StringTokenizer tk2 = new StringTokenizer(obra, " - ");
								int obra_num=Integer.parseInt(tk2.nextToken());
								
								paq.setFechaFinalizacion(String.valueOf(sdf.format(date)));
								
								paq.setFechaDespacho(String.valueOf(sdf.format(date1)));
								
								
								
								paq.setNumeroObra(obra_num);                                     
							    paq.setDescripcion(textFieldDescripcion.getText());              
							    String Edificio = (String ) comboBoxEdificio.getSelectedItem();  
							    paq.setNombreEdificio(Edificio);                                  
							    paq.setSoftDiseno((String)comboBoxSistemas.getSelectedItem());    
							    paq.guardarPaquete();
							    javax.swing.JOptionPane.showMessageDialog(null, "Carga Exitosa");
		                	
		                	}
		                	
		                	
		            		
		            	} else {
		            		
		            		primero = false;
		            		
		            		
		            	
		            	}
		            	
		            	
                   
		            	
		            	
		            }
		            
		           
		            
		            
		            // VALIDACIONES PARA HACER LA CARGA DEL PAQUETE , EL PAQUETE CONCISTE EN DATOS DE LA INTERFAZ Y LAS PIEZAS Y SUBPIEZAS . 
		        	if (dateChooserFinalizacion.getDate()!=null) {
						if (dateChooserDespacho.getDate()!=null){
							if (textFieldDescripcion.getText().length() > 0 ) {
								if(comboBoxEdificio.getSelectedItem() != null){
								
		                        
								/*	
								// SI PASA LAS VERIFIACIONES HACEMOS LA CARGA DEL PAQUETE EN LA BASE DE DATOS (YA TENEMOS LOS CONTROLADORES Y MODELOS PARA DAR DE ALTA A ESTOS OBJETOS )
								String formato = dateChooserFinalizacion.getDateFormatString();
								java.util.Date date = dateChooserFinalizacion.getDate();
								SimpleDateFormat sdf = new SimpleDateFormat(formato); 
								
								String formato1 = dateChooserDespacho.getDateFormatString();
								java.util.Date date1 = dateChooserDespacho.getDate();
								SimpleDateFormat sdf1 = new SimpleDateFormat(formato1); 
								
								String obra = (String) comboBoxObra.getSelectedItem();
								StringTokenizer tk2 = new StringTokenizer(obra, " - ");
								int obra_num=Integer.parseInt(tk2.nextToken());
								
								paq.setNumeroObra(obra_num);                                     
							    paq.setDescripcion(textFieldDescripcion.getText());              
							    String Edificio = (String ) comboBoxEdificio.getSelectedItem();  
							    paq.setNombreEdificio(Edificio);                                  
							    paq.setSoftDiseno((String)comboBoxSistemas.getSelectedItem());    
							    paq.guardarPaquete();
							    javax.swing.JOptionPane.showMessageDialog(null, "Carga Exitosa");
							    */
							
			
								}
								else{
									javax.swing.JOptionPane.showMessageDialog(null, "La El Edificio asignacion al paquete debe ser existente ");
									
								}
			
								
							} else {javax.swing.JOptionPane.showMessageDialog(null, "La descripcion del paquete debe ser obligatoria "); }
							
					
						}
						else{javax.swing.JOptionPane.showMessageDialog(null, "La fecha de despacho es obligatoria");}
					}else{
						javax.swing.JOptionPane.showMessageDialog(null, "La fecha de fabricación es obligatoria");
					}
						
        
		          br.close();

		        } catch (IOException e1) {
		            e1.printStackTrace();
		            
		            
		        }
				
			}		        
				
			
  
				  
		});
