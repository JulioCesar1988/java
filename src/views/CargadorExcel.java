package views;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JScrollPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.lowagie.text.Cell;

import controllers.EdificioController;
import controllers.MaterialController;
import controllers.ObrasController;
import controllers.SistemaController;
import controllers.UsuarioController;
import models.MaterialBean;
import models.PaqueteBean;
import models.PiezaBean;
import models.SubpiezaBean;
import session.Session;
import tools.CargadorCombobox;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Scrollbar;
import java.awt.TextArea;

import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class CargadorExcel extends JInternalFrame {
	private JTextField textFieldPath;
	JComboBox comboBoxEdificio;
	JComboBox comboBoxObra;
	JComboBox comboBoxSistemas;
	TextArea textArea;
	

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
	public CargadorExcel() {
		setClosable(true);
		setMaximizable(true);
		setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setEnabled(false);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.WHITE);
		setFrameIcon(new ImageIcon("C:\\Users\\jcontreras\\Desktop\\myprogram\\nuevo\\Julinchy\\logo\\logoHeader.png"));
		setTitle("Cargador Excel");
		setBounds(100, 100, 919, 633);
		getContentPane().setLayout(null);
		
		JLabel lblCargaTuOrde = new JLabel("Cargar una orden de producci\u00F3n");
		lblCargaTuOrde.setBounds(10, 11, 504, 32);
		getContentPane().add(lblCargaTuOrde);
		
		
		try {
			
			final ObrasController o = new ObrasController();
			final JComboBox comboBoxObra;
			comboBoxObra = new JComboBox(o.getListaDeObra());
			comboBoxObra.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Si se selecciona una obra se cargaran los Idificios . 
						
				System.out.println("Esta seleccionando una obra.");
					
					
					
					
				}
			});
			comboBoxObra.setBackground(UIManager.getColor("Button.background"));
			comboBoxObra.setForeground(Color.DARK_GRAY);
			comboBoxObra.setBounds(33, 54, 231, 20);
			getContentPane().add(comboBoxObra);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	
		
		JComboBox comboBoxEdificio = new JComboBox();
		comboBoxEdificio.setForeground(Color.WHITE);
		comboBoxEdificio.setBounds(33, 106, 231, 20);
		getContentPane().add(comboBoxEdificio);
		
		JLabel lblObra = new JLabel("Obra");
		lblObra.setBounds(274, 60, 46, 14);
		getContentPane().add(lblObra);
		
		JLabel lblEdificio = new JLabel("Edificio");
		lblEdificio.setBounds(274, 109, 46, 14);
		getContentPane().add(lblEdificio);
		
		
		
		
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// Hacemos la mismas validaciones que se generan para almacenar el paquete en la base de datos
				
				
				/*
				
					//ObrasController ctrl_obras = new ObrasController();
		//PaqueteController ctrl_paquetes = new PaqueteController();
	
	  	 PaqueteBean paquete;
		 paquete = new PaqueteBean();
		 PiezaBean pieza;
		 SubpiezaBean subpieza;
		 pieza = new PiezaBean();
		 subpieza = new SubpiezaBean();

		FileInputStream file;
		
		try {
	
			file = new FileInputStream(new File("C:\\prueb_excel.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			Row row;
			
			// Recorremos todas las filas para mostrar el contenido de cada celda

			while (rowIterator.hasNext()){
			    row = rowIterator.next();
			    // Obtenemos el iterator que permite recorres todas las celdas de una fila
			    Iterator<Cell> cellIterator = row.cellIterator();
			  
			    Cell celda;
		  
			    while (cellIterator.hasNext()){
				celda = cellIterator.next();
				if ((celda.getColumnIndex() == 0) && (celda.getRowIndex()== 0)   ) {	
					int numObra = (int) celda.getNumericCellValue(); 
					paquete.setNumeroObra(numObra);
				}
				if ((celda.getColumnIndex() == 1) && (celda.getRowIndex()== 0)   ) {					
					String nombreEdificio = celda.getStringCellValue() ;
					paquete.setNombreEdificio( nombreEdificio);
				}
				if ((celda.getColumnIndex() == 2) && (celda.getRowIndex()== 0)   ) {	
					String descripcionExcel =  celda.getStringCellValue();
					// Asignamos la descripcion del paquete 
					paquete.setDescripcion( descripcionExcel);
				}
               if ((celda.getColumnIndex() == 3) && (celda.getRowIndex() == 0)   ) {			
					String softdiseño =  celda.getStringCellValue();
					// Asignamos la descripcion del paquete 
					paquete.setSoftDiseno(softdiseño);
				}
      
			    }
			    
			}
			
		} catch (FileNotFoundException e2) {
			
			// TODO Auto-generated catch block
		    System.out.print("entra al catch");
			e2.printStackTrace();
		
		}


		    // Datos del usuario .
			String usuario = "MBI266";
			String password = "MBI266";
			
			// Generamos la sesion . 
			Session session = new Session();
			
			session.cargarUsuario(usuario, password);
			
			UsuarioController uController = new UsuarioController();
		
			int res = 0;
			
			try {
				
		
				res = uController.getUsuario(Integer.parseInt(usuario), password);
		
				
				
				
			} catch (NumberFormatException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		
				
			}
			
			
			if (res == 0){
				

			
				
			}else{
				
			
				
				
			}
		
		

		 
		 
		 // Vamos a cargar a la pieza. 
		 pieza.setCantidad(1);
		 pieza.setElemento("ELEM");
		 pieza.setIdPaquete(paquete.getId_paquete() );
		 pieza.setCorrelatividad("123");
		 pieza.setDescripcion("PIEZA AGREGADA POR SISTEMAS ");
		 pieza.setDescripcion_extra("PIEZA AGREGADA POR SISTEMAS");
		 pieza.setPintura(true);
		 pieza.setColor("NEGRO");
         pieza.setLargo(123456);
         pieza.setPesoUnitario(100);
         pieza.setArea("PRIMARIOS");
        
         

        // Vamos a cargar la subpieza.
         subpieza.setCantidad(5);
         subpieza.setCodigo(6666);
         subpieza.setDescripcion("DESCRIPCION DE SUBPIEZA");
         subpieza.setCorrelatividad("123456");
         subpieza.setElemento("ELEM");
         subpieza.setAncho(123);
         subpieza.setPeso(15);
         
       
         
        	  MaterialController mController = new MaterialController();
              MaterialBean mat = new MaterialBean();
            
              try {
            	 
				ArrayList<MaterialBean> materiales = mController.getTodos();
				
				 
				subpieza.setIdMaterial(2);
		
				System.out.println(" ID DEL MATERIAL QUE VAMOS ASIGNAR A LA SUBPIEZA :  "+subpieza.getIdMaterial());
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
              
         
         subpieza.setIdPiezaPadre(pieza.getIdPieza());
         pieza.añadirSubpieza(subpieza);
        
         ArrayList<PiezaBean> piezas = new ArrayList<PiezaBean>();
		 piezas.add(pieza);
		 System.out.println( " CANTIDAD DE PIEZAS : "+ piezas.size() );
		 System.out.println("ÁREA DE LA PIEZA :" + piezas.get(0).getArea());

		 System.out.println("CANTIDAD DE PIEZAS :"+piezas.get(0).getCantidad());
		 System.out.println( "CODIGO DE LA PIEZA :"+ piezas.get(0).getCodigo());
		 System.out.println("COLOR DE LA PIEZA :"+piezas.get(0).getColor());
		 paquete.setPiezas(piezas);
        
		 // Asignamos la descripcion del paquete 
		//paquete.setDescripcion( "Prueba de Sistemas 2017 ");
		// Asignamos el sistema de diseño con el que se realizo (tekla , autocad , BP)
		//paquete.setSoftDiseno("tekla");
		
		// asignamos numero de la obra 
		//int numObra = 9999; 
		//paquete.setNumeroObra(numObra);
		
		// nombre del edificio 
		//paquete.setNombreEdificio( "FANTASMA" );

		piezas.add(new PiezaBean());

      
		// Cargamos la lista de piezas que tenemos en la lista. 
		paquete.setPiezas(piezas);

       
		//String formato = dateChooser.getDateFormatString();
		//Date date = dateChooser.getDate();
		//SimpleDateFormat sdf = new SimpleDateFormat(formato);
		
		paquete.setFechaFinalizacion("27/03/2017");

		paquete.setFechaFinalizacion("27/03/2017");
		//date=dateChooser_1.getDate();
		paquete.setFechaDespacho("27/03/2017");
		
		paquete.guardarPaquete();

       
		
		
	
	}
	
				
				
				
				
				
				
				
				
				*/
				
			}
		});
		btnCargar.setForeground(Color.BLACK);
		btnCargar.setBounds(33, 273, 89, 23);
		getContentPane().add(btnCargar);
		
		textFieldPath = new JTextField();
		textFieldPath.setBounds(33, 153, 320, 20);
		getContentPane().add(textFieldPath);
		textFieldPath.setColumns(10);
		
		JButton btnSeleccionarExcel = new JButton("Seleccionar Excel");
		btnSeleccionarExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			// Áca vamos a seleccionar el archivo excel.	
				
				
				JFileChooser fileChooser = new JFileChooser();
			      int returnValue = fileChooser.showOpenDialog(null);
			      if (returnValue == JFileChooser.APPROVE_OPTION) {
			        File selectedFile = fileChooser.getSelectedFile();
			           // Acá ya tengo el path del archivo 
			           textFieldPath.setText(selectedFile.getPath()  ); 
			
				
			      }
			      
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			}
		});
		btnSeleccionarExcel.setBounds(363, 152, 176, 20);
		getContentPane().add(btnSeleccionarExcel);
		
		SistemaController s = new SistemaController();
		JComboBox comboBoxSistemas;
		try {
			comboBoxSistemas = new JComboBox(s.getListaDeSistemas());
			comboBoxSistemas.setBounds(349, 54, 198, 20);
			getContentPane().add(comboBoxSistemas);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		JLabel lblSistemaDiseo = new JLabel("Sistema Dise\u00F1o");
		lblSistemaDiseo.setBounds(549, 57, 113, 14);
		getContentPane().add(lblSistemaDiseo);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\jcontreras\\Desktop\\myprogram\\nuevo\\Julinchy\\logo\\logoHeader.png"));
		label.setBounds(33, 416, 189, 166);
		getContentPane().add(label);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 244, 844, 2);
		getContentPane().add(separator);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(249, 257, 626, 317);
		getContentPane().add(textArea);

	}
}
