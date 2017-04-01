package quality;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import models.MateriaPrimaBean;

import com.lowagie.text.pdf.TextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;



@SuppressWarnings("serial")
public class MateriaPrimaEditar extends JInternalFrame {
	private JButton btnBuscar;
	private JButton btnNuevo;
	private JDateChooser dateChooser;
	private JLabel lblCdigoDePadre;
	private JLabel lblColada;
	private JLabel lblEmpresa;
	private JLabel lblFechaDeIngreso;
	private JLabel lblNBoleta;
	private JLabel lblNRemito;
	private JLabel lblOrigen;
	private JLabel lblPeso;
	private JLabel lblTipo;
	private JScrollPane scrollPane;
	private JTable tableMaterias;
	private AutoCompleteTextField textFieldCodigo;
	private JTextField textFieldCodigoDePadre;
	private JTextField textFieldColada;
	private JTextField textFieldDescripcion;
	private JTextField textFieldEmpresaOrigen;
	private JTextField textFieldEspesor;
	private JTextField textFieldNBoleta;
	private JTextField textFieldNRemito;
	private JTextField textFieldOrigen;
	private JTextField textFieldPeso;
	private AutoCompleteTextField textFieldTipo;
	private JButton btnGuardar;
	private JTextField textFieldCalidad;
	private JLabel lblCalidad;
	private JTextField textFieldCodigoTango;
	private JLabel lblCdigoTango;
	private JButton button;
	private JTextField textField;
	private JLabel label;


	/**
	 * Create the frame.
	 */
	public MateriaPrimaEditar() {
		setFrameIcon(new ImageIcon("IMGS/logomiller.jpg"));
		setFrameIcon(null);
		setClosable(true);
		setRootPaneCheckingEnabled(false);
		setTitle("Cargar Materia Prima");
		setBounds(100, 100, 726, 464);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 103, 266, 21, 278, 0, 0};
		gridBagLayout.rowHeights = new int[]{74, 0, 20, 0, 18, 20, 0, 0, 17, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		label = new JLabel("C\u00F3digo");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.gridx = 1;
		gbc_label.gridy = 1;
		getContentPane().add(label, gbc_label);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		getContentPane().add(textField, gbc_textField);
		
		button = new JButton("Buscar");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 3;
		gbc_button.gridy = 1;
		getContentPane().add(button, gbc_button);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		GridBagConstraints gbc_lblCdigo = new GridBagConstraints();
		gbc_lblCdigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigo.anchor = GridBagConstraints.EAST;
		gbc_lblCdigo.gridx = 1;
		gbc_lblCdigo.gridy = 2;
		getContentPane().add(lblCdigo, gbc_lblCdigo);
		
		textFieldCodigo = new AutoCompleteTextField();
		textFieldCodigo.setEnabled(false);
		GridBagConstraints gbc_textFieldCodigo = new GridBagConstraints();
		gbc_textFieldCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCodigo.gridx = 2;
		gbc_textFieldCodigo.gridy = 2;
		getContentPane().add(textFieldCodigo, gbc_textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 16;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 4;
		gbc_scrollPane.gridy = 2;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		tableMaterias = new JTable();
		tableMaterias.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Descripci\u00F3n", "Espesor"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tableMaterias);
		
		lblTipo = new JLabel("Tipo*");
		GridBagConstraints gbc_lblTipo = new GridBagConstraints();
		gbc_lblTipo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipo.anchor = GridBagConstraints.EAST;
		gbc_lblTipo.gridx = 1;
		gbc_lblTipo.gridy = 3;
		getContentPane().add(lblTipo, gbc_lblTipo);
		
		textFieldTipo = new AutoCompleteTextField();
		GridBagConstraints gbc_textFieldTipo = new GridBagConstraints();
		gbc_textFieldTipo.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTipo.gridx = 2;
		gbc_textFieldTipo.gridy = 3;
		getContentPane().add(textFieldTipo, gbc_textFieldTipo);
		textFieldTipo.setColumns(10);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MateriaPrimaTipoCargar nuevaMat = new MateriaPrimaTipoCargar();
				nuevaMat.setModal(true);
				nuevaMat.setVisible(true);
				asignarValoresTipo();
			}
		});
		GridBagConstraints gbc_btnNuevo = new GridBagConstraints();
		gbc_btnNuevo.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNuevo.insets = new Insets(0, 0, 5, 5);
		gbc_btnNuevo.gridx = 3;
		gbc_btnNuevo.gridy = 3;
		getContentPane().add(btnNuevo, gbc_btnNuevo);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
		gbc_lblDescripcin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcin.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcin.gridx = 1;
		gbc_lblDescripcin.gridy = 4;
		getContentPane().add(lblDescripcin, gbc_lblDescripcin);
		
		textFieldDescripcion = new JTextField();
		GridBagConstraints gbc_textFieldDescripcion = new GridBagConstraints();
		gbc_textFieldDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDescripcion.gridx = 2;
		gbc_textFieldDescripcion.gridy = 4;
		getContentPane().add(textFieldDescripcion, gbc_textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		JLabel lblEspesor = new JLabel("Espesor");
		GridBagConstraints gbc_lblEspesor = new GridBagConstraints();
		gbc_lblEspesor.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspesor.anchor = GridBagConstraints.EAST;
		gbc_lblEspesor.gridx = 1;
		gbc_lblEspesor.gridy = 5;
		getContentPane().add(lblEspesor, gbc_lblEspesor);
		
		textFieldEspesor = new JTextField();
		GridBagConstraints gbc_textFieldEspesor = new GridBagConstraints();
		gbc_textFieldEspesor.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEspesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEspesor.gridx = 2;
		gbc_textFieldEspesor.gridy = 5;
		getContentPane().add(textFieldEspesor, gbc_textFieldEspesor);
		textFieldEspesor.setColumns(10);
		
		lblCalidad = new JLabel("Calidad*");
		GridBagConstraints gbc_lblCalidad = new GridBagConstraints();
		gbc_lblCalidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCalidad.anchor = GridBagConstraints.EAST;
		gbc_lblCalidad.gridx = 1;
		gbc_lblCalidad.gridy = 6;
		getContentPane().add(lblCalidad, gbc_lblCalidad);
		
		textFieldCalidad = new JTextField();
		GridBagConstraints gbc_textFieldCalidad = new GridBagConstraints();
		gbc_textFieldCalidad.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCalidad.gridx = 2;
		gbc_textFieldCalidad.gridy = 6;
		getContentPane().add(textFieldCalidad, gbc_textFieldCalidad);
		textFieldCalidad.setColumns(10);
		
		lblNRemito = new JLabel("N\u00BA Remito*");
		GridBagConstraints gbc_lblNRemito = new GridBagConstraints();
		gbc_lblNRemito.insets = new Insets(0, 0, 5, 5);
		gbc_lblNRemito.anchor = GridBagConstraints.EAST;
		gbc_lblNRemito.gridx = 1;
		gbc_lblNRemito.gridy = 7;
		getContentPane().add(lblNRemito, gbc_lblNRemito);
		
		textFieldNRemito = new JTextField();
		GridBagConstraints gbc_textFieldNRemito = new GridBagConstraints();
		gbc_textFieldNRemito.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNRemito.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNRemito.gridx = 2;
		gbc_textFieldNRemito.gridy = 7;
		getContentPane().add(textFieldNRemito, gbc_textFieldNRemito);
		textFieldNRemito.setColumns(10);
		
		lblEmpresa = new JLabel("Empresa");
		GridBagConstraints gbc_lblEmpresa = new GridBagConstraints();
		gbc_lblEmpresa.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmpresa.anchor = GridBagConstraints.EAST;
		gbc_lblEmpresa.gridx = 1;
		gbc_lblEmpresa.gridy = 8;
		getContentPane().add(lblEmpresa, gbc_lblEmpresa);
		
		textFieldEmpresaOrigen = new JTextField();
		GridBagConstraints gbc_textFieldEmpresaOrigen = new GridBagConstraints();
		gbc_textFieldEmpresaOrigen.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmpresaOrigen.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmpresaOrigen.gridx = 2;
		gbc_textFieldEmpresaOrigen.gridy = 8;
		getContentPane().add(textFieldEmpresaOrigen, gbc_textFieldEmpresaOrigen);
		textFieldEmpresaOrigen.setColumns(10);
		
		lblFechaDeIngreso = new JLabel("Fecha de ingreso*");
		GridBagConstraints gbc_lblFechaDeIngreso = new GridBagConstraints();
		gbc_lblFechaDeIngreso.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeIngreso.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeIngreso.gridx = 1;
		gbc_lblFechaDeIngreso.gridy = 9;
		getContentPane().add(lblFechaDeIngreso, gbc_lblFechaDeIngreso);
		
		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 9;
		getContentPane().add(dateChooser, gbc_dateChooser);
		
		lblPeso = new JLabel("Peso");
		GridBagConstraints gbc_lblPeso = new GridBagConstraints();
		gbc_lblPeso.insets = new Insets(0, 0, 5, 5);
		gbc_lblPeso.anchor = GridBagConstraints.EAST;
		gbc_lblPeso.gridx = 1;
		gbc_lblPeso.gridy = 10;
		getContentPane().add(lblPeso, gbc_lblPeso);
		
		textFieldPeso = new JTextField();
		GridBagConstraints gbc_textFieldPeso = new GridBagConstraints();
		gbc_textFieldPeso.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPeso.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPeso.gridx = 2;
		gbc_textFieldPeso.gridy = 10;
		getContentPane().add(textFieldPeso, gbc_textFieldPeso);
		textFieldPeso.setColumns(10);
		
		lblColada = new JLabel("Colada");
		GridBagConstraints gbc_lblColada = new GridBagConstraints();
		gbc_lblColada.insets = new Insets(0, 0, 5, 5);
		gbc_lblColada.anchor = GridBagConstraints.EAST;
		gbc_lblColada.gridx = 1;
		gbc_lblColada.gridy = 11;
		getContentPane().add(lblColada, gbc_lblColada);
		
		textFieldColada = new JTextField();
		GridBagConstraints gbc_textFieldColada = new GridBagConstraints();
		gbc_textFieldColada.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldColada.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldColada.gridx = 2;
		gbc_textFieldColada.gridy = 11;
		getContentPane().add(textFieldColada, gbc_textFieldColada);
		textFieldColada.setColumns(10);
		
		lblOrigen = new JLabel("Origen");
		GridBagConstraints gbc_lblOrigen = new GridBagConstraints();
		gbc_lblOrigen.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrigen.anchor = GridBagConstraints.EAST;
		gbc_lblOrigen.gridx = 1;
		gbc_lblOrigen.gridy = 12;
		getContentPane().add(lblOrigen, gbc_lblOrigen);
		
		textFieldOrigen = new JTextField();
		GridBagConstraints gbc_textFieldOrigen = new GridBagConstraints();
		gbc_textFieldOrigen.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldOrigen.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldOrigen.gridx = 2;
		gbc_textFieldOrigen.gridy = 12;
		getContentPane().add(textFieldOrigen, gbc_textFieldOrigen);
		textFieldOrigen.setColumns(10);
		
		lblCdigoDePadre = new JLabel("C\u00F3digo de padre");
		GridBagConstraints gbc_lblCdigoDePadre = new GridBagConstraints();
		gbc_lblCdigoDePadre.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigoDePadre.anchor = GridBagConstraints.EAST;
		gbc_lblCdigoDePadre.gridx = 1;
		gbc_lblCdigoDePadre.gridy = 13;
		getContentPane().add(lblCdigoDePadre, gbc_lblCdigoDePadre);
		
		textFieldCodigoDePadre = new JTextField();
		GridBagConstraints gbc_textFieldCodigoDePadre = new GridBagConstraints();
		gbc_textFieldCodigoDePadre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCodigoDePadre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCodigoDePadre.gridx = 2;
		gbc_textFieldCodigoDePadre.gridy = 13;
		getContentPane().add(textFieldCodigoDePadre, gbc_textFieldCodigoDePadre);
		textFieldCodigoDePadre.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MateriaPrimaCargarBuscarCodigoPadre nuevaMat = new MateriaPrimaCargarBuscarCodigoPadre();
				nuevaMat.setModal(true);
				nuevaMat.setVisible(true);
				String codigo = nuevaMat.getCodigo();
				textFieldCodigoDePadre.setText(codigo);
			}
		});
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.anchor = GridBagConstraints.EAST;
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 3;
		gbc_btnBuscar.gridy = 13;
		getContentPane().add(btnBuscar, gbc_btnBuscar);
		
		lblCdigoTango = new JLabel("C\u00F3digo tango");
		GridBagConstraints gbc_lblCdigoTango = new GridBagConstraints();
		gbc_lblCdigoTango.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigoTango.anchor = GridBagConstraints.EAST;
		gbc_lblCdigoTango.gridx = 1;
		gbc_lblCdigoTango.gridy = 14;
		getContentPane().add(lblCdigoTango, gbc_lblCdigoTango);
		
		textFieldCodigoTango = new JTextField();
		GridBagConstraints gbc_textFieldCodigoTango = new GridBagConstraints();
		gbc_textFieldCodigoTango.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCodigoTango.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCodigoTango.gridx = 2;
		gbc_textFieldCodigoTango.gridy = 14;
		getContentPane().add(textFieldCodigoTango, gbc_textFieldCodigoTango);
		textFieldCodigoTango.setColumns(10);
		
		lblNBoleta = new JLabel("N\u00BA Boleta");
		GridBagConstraints gbc_lblNBoleta = new GridBagConstraints();
		gbc_lblNBoleta.anchor = GridBagConstraints.EAST;
		gbc_lblNBoleta.insets = new Insets(0, 0, 5, 5);
		gbc_lblNBoleta.gridx = 1;
		gbc_lblNBoleta.gridy = 15;
		getContentPane().add(lblNBoleta, gbc_lblNBoleta);
		
		textFieldNBoleta = new JTextField();
		GridBagConstraints gbc_textFieldNBoleta = new GridBagConstraints();
		gbc_textFieldNBoleta.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNBoleta.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNBoleta.gridx = 2;
		gbc_textFieldNBoleta.gridy = 15;
		getContentPane().add(textFieldNBoleta, gbc_textFieldNBoleta);
		textFieldNBoleta.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				InsertarMateriaPrima();
				
				
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardar.gridx = 2;
		gbc_btnGuardar.gridy = 16;
		getContentPane().add(btnGuardar, gbc_btnGuardar);
		
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.gridwidth = 3;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridx = 2;
		gbc_textFieldNombre.gridy = 2;

		gbc_btnGuardar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardar.anchor = GridBagConstraints.NORTH;
		gbc_btnGuardar.gridx = 3;
		gbc_btnGuardar.gridy = 4;
		asignarValoresTipo();
	}
	
	private void asignarValoresTipo () {
		CargadorAutoCompleteTextField cargador = new CargadorAutoCompleteTextField();
		textFieldTipo.addAllPossibilitys(cargador.generarContenidoTiposMateriaPrima());
	}
	
	private void InsertarMateriaPrima () {
		if (!textFieldTipo.getText().isEmpty() && 
			!textFieldTipo.getText().equals("") && 
			!textFieldNRemito.getText().isEmpty() && 
			!textFieldNRemito.getText().equals("") && 
			!textFieldCalidad.getText().isEmpty() && 
			!textFieldCalidad.getText().equals("") && 
			dateChooser.getDate()!=null) {
				
				boolean valido =true;
				MateriaPrimaBean materiaPrima = new MateriaPrimaBean();
				String formato = dateChooser.getDateFormatString();
				Date date = dateChooser.getDate();
				SimpleDateFormat sdf = new SimpleDateFormat(formato);
				materiaPrima.setFechaIngreso(String.valueOf(sdf.format(date)));
				
				materiaPrima.setCalidad(textFieldCalidad.getText());
				materiaPrima.setColada(textFieldColada.getText());
				materiaPrima.setDescripcion(textFieldDescripcion.getText());
				materiaPrima.setEmpresa(textFieldEmpresaOrigen.getText());
				if ( textFieldEspesor.getText()!="" &&  !textFieldEspesor.getText().isEmpty()) {
					try{
						materiaPrima.setEspesor(Float.parseFloat((String) textFieldEspesor.getText()));
					}catch(NumberFormatException e){ 
						// captura la exepcion, en caso de que no sea un formato de Float valido y envia un mensaje.
						valido = false;
						javax.swing.JOptionPane.showMessageDialog(null, "Lo sentimos el valor ingresado de espesor no es valido, verifique");
					}
				}
				
				
				materiaPrima.setOrigen(textFieldOrigen.getText());
				materiaPrima.setPadre(textFieldCodigoDePadre.getText());
				materiaPrima.setCodigoTango(textFieldCodigoTango.getText());
				if ( textFieldPeso.getText()!="" &&  !textFieldPeso.getText().isEmpty()) {
					try{
						materiaPrima.setPeso(Float.parseFloat((String) textFieldPeso.getText()));
					}catch(NumberFormatException e){ 
						// captura la exepcion, en caso de que no sea un formato de Float valido y envia un mensaje.
						valido = false;
						javax.swing.JOptionPane.showMessageDialog(null, "Lo sentimos el valor ingresado de peso no es valido, verifique");
					}
				}
				try{
					materiaPrima.setRemitoNum(textFieldNRemito.getText());
				}catch(NumberFormatException e){ 
					// captura la exepcion, en caso de que no sea un formato de int valido y envia un mensaje.
					valido = false;
					javax.swing.JOptionPane.showMessageDialog(null, "Lo sentimos el valor ingresado de espesor no es valido, verifique");
				}
				
				materiaPrima.setTipo(textFieldTipo.getText());
				materiaPrima.setBoletaNum(textFieldNBoleta.getText());
				if (valido) {
					MateriaPrimaController mController = new MateriaPrimaController();
					try {
						mController.insertMateriaPrima(materiaPrima);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				textFieldCodigo.setText(materiaPrima.getCodigo());
				insertarEnTabla(materiaPrima);/*
				System.out.println( materiaPrima.getCalidad());
				System.out.println( materiaPrima.getCodigo());
				System.out.println( materiaPrima.getColada());
				System.out.println( materiaPrima.getDescripcion());
				System.out.println( materiaPrima.getEmpresa());
				System.out.println( materiaPrima.getEspesor());
				System.out.println( materiaPrima.getFechaCarga());
				System.out.println( materiaPrima.getFechaIngreso());
				System.out.println( materiaPrima.getOrigen());
				System.out.println( materiaPrima.getPadre());
				System.out.println( materiaPrima.getPeso());
				System.out.println( materiaPrima.getRemitoNum());
				System.out.println( materiaPrima.getTipo());*/
				
		}
		
	}
	
	
	private void insertarEnTabla(MateriaPrimaBean mat) {
		((DefaultTableModel) tableMaterias.getModel()).addRow(new Object[]
				{mat.getCodigo(), 
				mat.getDescripcion(), 
				mat.getEspesor()
				});

		
	}
}

