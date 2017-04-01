package quality;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import tools.CargadorCombobox;
import tools.CargadorTabla;
import models.MateriaPrimaBean;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;

import org.jdesktop.swingx.autocomplete.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTabbedPane;


import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;



@SuppressWarnings("serial")
public class MateriaPrimaCargar extends JInternalFrame {
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
	private JScrollPane scrollPaneT1;
	private JTable tableMaterias;
	private AutoCompleteTextField textFieldCodigo;
	private JTextField textFieldCodigoDePadre;
	private JTextField textFieldColada;
	private JTextField textFieldDescripcion;
	private JTextField textFieldEspesor;
	private JTextField textFieldNBoleta;
	private JTextField textFieldNRemito;
	private JTextField textFieldPeso;
	private JButton btnGuardar;
	private JLabel lblCalidad;
	private JTextField textFieldCodigoTango;
	private JLabel lblCdigoTango;
	private JLabel lblCdigoBobinaPadre;
	private JTextField textFieldCdigoBobinaPadre;
	private JLabel lblT1Observacion;
	private JTextPane textPaneT1Observaciones;
	private JPanel panelT1P1;
	private JPanel panelT1P2;
	private JPanel panelT1P3;
	private JButton buttonCalidadNueva;
	private JButton buttonNuevaEmpresa;
	private JButton buttonNuevaEmpresa2;
	private JComboBox comboBoxEmpresaOrigen;
	private JComboBox comboBoxEmpresa;
	private JComboBox comboBoxCalidad;
	private JComboBox comboBoxTipo;
	private JTabbedPane tabbedPane;
	private JPanel panelT1;
	private JScrollPane scrollPane_2;
	private JPanel panelT2;
	private JTextField t2TextFieldDescripcion;
	private JTextField t2TextFieldEspesor;
	private JTextField t2TextFieldPeso;
	private JTextField textFieldCodigoBuscar;
	private JTextField t2TextFieldRemito;
	private JTextField t2TextFieldColada;
	private JTextField t2TextFieldCodigoInternoPadre;
	private JTextField t2TextFieldCodigoTango;
	private JTextField t2TextFieldBoleta;
	private JTextField t2TextFieldCodigoBobinaPadre;
	private JComboBox comboBoxT2Tipo;
	private JComboBox comboBoxT2Calidad;
	private JComboBox comboBoxT2Empresa;
	private JComboBox comboBoxT2EmpresaOrigen; 
	private JTable tableT2Materiales;
	private JDateChooser dateChooserDesdeBusqueda;
	private JDateChooser dateChooserHastaBusqueda;
	private int posTabla = -1;
	private String codigo;
	private JTextPane textPaneT2Observaciones;
	private JScrollPane scrollPane;
	private AutoCompleteTextField t2TextFieldCodigo;
	private JDateChooser t2DateChooser;
	private JButton btnEliminar;
	private JPanel panelT2P1;
	private JPanel panelT2P2;
	private JPanel panelT2P3;
	private JPanel panelT2P4;
	private JCheckBox chckbxEnStock;
	private JCheckBox chckbxIncluirFuerqaDe;
	private JTextField textFieldNCertificadoT1;
	private JTextField textFieldUrlCertificadoT1;
	private JTextField textFieldNCertificado;
	private JTextField textFieldURLCertificado;
	private JLabel lblNCertificado;
	private JLabel lblUrlCertificado;
	private JLabel label_7;
	private JLabel lblUrlCertificado_1;
	private JTextField textFieldCantidad;
	private JLabel lblCantidad_1;
	private JTextField t2textFieldCantidad;


	/**
	 * Create the frame.
	 */
	public MateriaPrimaCargar() {
		setFrameIcon(new ImageIcon("IMGS/logomiller.jpg"));
		setFrameIcon(null);
		setClosable(true);
		setRootPaneCheckingEnabled(false);
		setTitle("Cargar Materia Prima");
		setBounds(100, 100, 1186, 735);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{148, 0};
		gridBagLayout.rowHeights = new int[]{127, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 0;
		getContentPane().add(scrollPane_2, gbc_scrollPane_2);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		scrollPane_2.setViewportView(tabbedPane);
		
		panelT1 = new JPanel();
		tabbedPane.addTab("Ingreso de materia prima", null, panelT1, null);
				
				panelT1P2 = new JPanel();
				panelT1P2.setBorder(new TitledBorder(null, "Datos de procedencia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				GridBagLayout gbl_panelT1P2 = new GridBagLayout();
				gbl_panelT1P2.columnWidths = new int[]{148, 266, 0, 0};
				gbl_panelT1P2.rowHeights = new int[]{0, 0, 0, 0, 0};
				gbl_panelT1P2.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
				gbl_panelT1P2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				panelT1P2.setLayout(gbl_panelT1P2);
				
				lblCalidad = new JLabel("Calidad*");
				GridBagConstraints gbc_lblCalidad = new GridBagConstraints();
				gbc_lblCalidad.anchor = GridBagConstraints.EAST;
				gbc_lblCalidad.insets = new Insets(0, 0, 5, 5);
				gbc_lblCalidad.gridx = 0;
				gbc_lblCalidad.gridy = 0;
				panelT1P2.add(lblCalidad, gbc_lblCalidad);
				
				comboBoxCalidad = new JComboBox();
				AutoCompleteDecorator.decorate(this.comboBoxCalidad);
				
						GridBagConstraints gbc_comboBoxCalidad = new GridBagConstraints();
						gbc_comboBoxCalidad.insets = new Insets(0, 0, 5, 5);
						gbc_comboBoxCalidad.fill = GridBagConstraints.HORIZONTAL;
						gbc_comboBoxCalidad.gridx = 1;
						gbc_comboBoxCalidad.gridy = 0;
						panelT1P2.add(comboBoxCalidad, gbc_comboBoxCalidad);
						
						buttonCalidadNueva = new JButton("Nuevo");
						buttonCalidadNueva.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								CalidadMateriaPrimaCargar cargarCal = new CalidadMateriaPrimaCargar();
								cargarCal.setModal(true);
								cargarCal.setVisible(true);
								asignarValoresCalidades();
							}
						});
						GridBagConstraints gbc_buttonCalidadNueva = new GridBagConstraints();
						gbc_buttonCalidadNueva.insets = new Insets(0, 0, 5, 0);
						gbc_buttonCalidadNueva.gridx = 2;
						gbc_buttonCalidadNueva.gridy = 0;
						panelT1P2.add(buttonCalidadNueva, gbc_buttonCalidadNueva);
						
						lblNRemito = new JLabel("N\u00BA Remito*");
						GridBagConstraints gbc_lblNRemito = new GridBagConstraints();
						gbc_lblNRemito.anchor = GridBagConstraints.EAST;
						gbc_lblNRemito.insets = new Insets(0, 0, 5, 5);
						gbc_lblNRemito.gridx = 0;
						gbc_lblNRemito.gridy = 1;
						panelT1P2.add(lblNRemito, gbc_lblNRemito);
						
						textFieldNRemito = new JTextField();
						GridBagConstraints gbc_textFieldNRemito = new GridBagConstraints();
						gbc_textFieldNRemito.gridwidth = 2;
						gbc_textFieldNRemito.fill = GridBagConstraints.HORIZONTAL;
						gbc_textFieldNRemito.insets = new Insets(0, 0, 5, 0);
						gbc_textFieldNRemito.gridx = 1;
						gbc_textFieldNRemito.gridy = 1;
						panelT1P2.add(textFieldNRemito, gbc_textFieldNRemito);
						textFieldNRemito.setColumns(10);
						
						lblEmpresa = new JLabel("Empresa");
						GridBagConstraints gbc_lblEmpresa = new GridBagConstraints();
						gbc_lblEmpresa.anchor = GridBagConstraints.EAST;
						gbc_lblEmpresa.insets = new Insets(0, 0, 5, 5);
						gbc_lblEmpresa.gridx = 0;
						gbc_lblEmpresa.gridy = 2;
						panelT1P2.add(lblEmpresa, gbc_lblEmpresa);
						
						comboBoxEmpresa = new JComboBox();
						AutoCompleteDecorator.decorate(this.comboBoxEmpresa);
						
								GridBagConstraints gbc_comboBoxEmpresa = new GridBagConstraints();
								gbc_comboBoxEmpresa.insets = new Insets(0, 0, 5, 5);
								gbc_comboBoxEmpresa.fill = GridBagConstraints.HORIZONTAL;
								gbc_comboBoxEmpresa.gridx = 1;
								gbc_comboBoxEmpresa.gridy = 2;
								panelT1P2.add(comboBoxEmpresa, gbc_comboBoxEmpresa);
								
								buttonNuevaEmpresa = new JButton("Nuevo");
								buttonNuevaEmpresa.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										EmpresaProveedorCargar empresaProveedorCarga = new EmpresaProveedorCargar();
										empresaProveedorCarga.setModal(true);
										empresaProveedorCarga.setVisible(true);
										asignarValoresEmpresa();
									}
								});
								GridBagConstraints gbc_buttonNuevaEmpresa = new GridBagConstraints();
								gbc_buttonNuevaEmpresa.insets = new Insets(0, 0, 5, 0);
								gbc_buttonNuevaEmpresa.gridx = 2;
								gbc_buttonNuevaEmpresa.gridy = 2;
								panelT1P2.add(buttonNuevaEmpresa, gbc_buttonNuevaEmpresa);
								
								lblFechaDeIngreso = new JLabel("Fecha de ingreso*");
								GridBagConstraints gbc_lblFechaDeIngreso = new GridBagConstraints();
								gbc_lblFechaDeIngreso.anchor = GridBagConstraints.EAST;
								gbc_lblFechaDeIngreso.insets = new Insets(0, 0, 0, 5);
								gbc_lblFechaDeIngreso.gridx = 0;
								gbc_lblFechaDeIngreso.gridy = 3;
								panelT1P2.add(lblFechaDeIngreso, gbc_lblFechaDeIngreso);
								
								dateChooser = new JDateChooser();
								GridBagConstraints gbc_dateChooser = new GridBagConstraints();
								gbc_dateChooser.gridwidth = 2;
								gbc_dateChooser.fill = GridBagConstraints.HORIZONTAL;
								gbc_dateChooser.gridx = 1;
								gbc_dateChooser.gridy = 3;
								panelT1P2.add(dateChooser, gbc_dateChooser);
		
		panelT1P1 = new JPanel();
		panelT1P1.setBorder(new TitledBorder(null, "Datos de material", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_panelT1P1 = new GridBagLayout();
		gbl_panelT1P1.columnWidths = new int[]{148, 98, 35, 0, 0};
		gbl_panelT1P1.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelT1P1.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelT1P1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelT1P1.setLayout(gbl_panelT1P1);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		GridBagConstraints gbc_lblCdigo = new GridBagConstraints();
		gbc_lblCdigo.anchor = GridBagConstraints.EAST;
		gbc_lblCdigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigo.gridx = 0;
		gbc_lblCdigo.gridy = 0;
		panelT1P1.add(lblCdigo, gbc_lblCdigo);
		
		textFieldCodigo = new AutoCompleteTextField();
		GridBagConstraints gbc_textFieldCodigo = new GridBagConstraints();
		gbc_textFieldCodigo.gridwidth = 3;
		gbc_textFieldCodigo.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCodigo.gridx = 1;
		gbc_textFieldCodigo.gridy = 0;
		panelT1P1.add(textFieldCodigo, gbc_textFieldCodigo);
		textFieldCodigo.setEnabled(false);
		textFieldCodigo.setColumns(10);
		
		lblTipo = new JLabel("Tipo*");
		GridBagConstraints gbc_lblTipo = new GridBagConstraints();
		gbc_lblTipo.anchor = GridBagConstraints.EAST;
		gbc_lblTipo.fill = GridBagConstraints.VERTICAL;
		gbc_lblTipo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipo.gridx = 0;
		gbc_lblTipo.gridy = 1;
		panelT1P1.add(lblTipo, gbc_lblTipo);
		
		comboBoxTipo = new JComboBox();
		AutoCompleteDecorator.decorate(this.comboBoxTipo);
		
				GridBagConstraints gbc_comboBoxTipo = new GridBagConstraints();
				gbc_comboBoxTipo.insets = new Insets(0, 0, 5, 5);
				gbc_comboBoxTipo.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBoxTipo.gridx = 1;
				gbc_comboBoxTipo.gridy = 1;
				panelT1P1.add(comboBoxTipo, gbc_comboBoxTipo);
				
				btnNuevo = new JButton("Nuevo");
				GridBagConstraints gbc_btnNuevo = new GridBagConstraints();
				gbc_btnNuevo.insets = new Insets(0, 0, 5, 0);
				gbc_btnNuevo.gridx = 3;
				gbc_btnNuevo.gridy = 1;
				panelT1P1.add(btnNuevo, gbc_btnNuevo);
				btnNuevo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MateriaPrimaTipoCargar nuevoTipoMat = new MateriaPrimaTipoCargar();
						nuevoTipoMat.setModal(true);
						nuevoTipoMat.setVisible(true);
						asignarValoresTipo();
					}
				});
				
				JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
				GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
				gbc_lblDescripcin.anchor = GridBagConstraints.EAST;
				gbc_lblDescripcin.fill = GridBagConstraints.VERTICAL;
				gbc_lblDescripcin.insets = new Insets(0, 0, 5, 5);
				gbc_lblDescripcin.gridx = 0;
				gbc_lblDescripcin.gridy = 2;
				panelT1P1.add(lblDescripcin, gbc_lblDescripcin);
				
				textFieldDescripcion = new JTextField();
				GridBagConstraints gbc_textFieldDescripcion = new GridBagConstraints();
				gbc_textFieldDescripcion.gridwidth = 3;
				gbc_textFieldDescripcion.fill = GridBagConstraints.BOTH;
				gbc_textFieldDescripcion.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldDescripcion.gridx = 1;
				gbc_textFieldDescripcion.gridy = 2;
				panelT1P1.add(textFieldDescripcion, gbc_textFieldDescripcion);
				textFieldDescripcion.setColumns(10);
				
				JLabel lblEspesor = new JLabel("Espesor");
				GridBagConstraints gbc_lblEspesor = new GridBagConstraints();
				gbc_lblEspesor.anchor = GridBagConstraints.EAST;
				gbc_lblEspesor.fill = GridBagConstraints.VERTICAL;
				gbc_lblEspesor.insets = new Insets(0, 0, 5, 5);
				gbc_lblEspesor.gridx = 0;
				gbc_lblEspesor.gridy = 3;
				panelT1P1.add(lblEspesor, gbc_lblEspesor);
				
				textFieldEspesor = new JTextField();
				GridBagConstraints gbc_textFieldEspesor = new GridBagConstraints();
				gbc_textFieldEspesor.gridwidth = 3;
				gbc_textFieldEspesor.fill = GridBagConstraints.BOTH;
				gbc_textFieldEspesor.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldEspesor.gridx = 1;
				gbc_textFieldEspesor.gridy = 3;
				panelT1P1.add(textFieldEspesor, gbc_textFieldEspesor);
				textFieldEspesor.setColumns(10);
				
				lblPeso = new JLabel("Peso");
				GridBagConstraints gbc_lblPeso = new GridBagConstraints();
				gbc_lblPeso.anchor = GridBagConstraints.EAST;
				gbc_lblPeso.fill = GridBagConstraints.VERTICAL;
				gbc_lblPeso.insets = new Insets(0, 0, 0, 5);
				gbc_lblPeso.gridx = 0;
				gbc_lblPeso.gridy = 4;
				panelT1P1.add(lblPeso, gbc_lblPeso);
				
				textFieldPeso = new JTextField();
				GridBagConstraints gbc_textFieldPeso = new GridBagConstraints();
				gbc_textFieldPeso.insets = new Insets(0, 0, 0, 5);
				gbc_textFieldPeso.fill = GridBagConstraints.BOTH;
				gbc_textFieldPeso.gridx = 1;
				gbc_textFieldPeso.gridy = 4;
				panelT1P1.add(textFieldPeso, gbc_textFieldPeso);
				textFieldPeso.setColumns(10);
		
		scrollPaneT1 = new JScrollPane();
		
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
		scrollPaneT1.setViewportView(tableMaterias);
		
		panelT1P3 = new JPanel();
		panelT1P3.setBorder(new TitledBorder(null, "Datos de seguimiento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_panelT1P3 = new GridBagLayout();
		gbl_panelT1P3.columnWidths = new int[]{148, 266, 0, 0};
		gbl_panelT1P3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelT1P3.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelT1P3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelT1P3.setLayout(gbl_panelT1P3);
		
		lblColada = new JLabel("Colada");
		GridBagConstraints gbc_lblColada = new GridBagConstraints();
		gbc_lblColada.fill = GridBagConstraints.VERTICAL;
		gbc_lblColada.anchor = GridBagConstraints.EAST;
		gbc_lblColada.insets = new Insets(0, 0, 5, 5);
		gbc_lblColada.gridx = 0;
		gbc_lblColada.gridy = 0;
		panelT1P3.add(lblColada, gbc_lblColada);
		
		textFieldColada = new JTextField();
		GridBagConstraints gbc_textFieldColada = new GridBagConstraints();
		gbc_textFieldColada.gridwidth = 2;
		gbc_textFieldColada.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldColada.fill = GridBagConstraints.BOTH;
		gbc_textFieldColada.gridx = 1;
		gbc_textFieldColada.gridy = 0;
		panelT1P3.add(textFieldColada, gbc_textFieldColada);
		textFieldColada.setColumns(10);
		
		lblOrigen = new JLabel("Origen");
		GridBagConstraints gbc_lblOrigen = new GridBagConstraints();
		gbc_lblOrigen.anchor = GridBagConstraints.EAST;
		gbc_lblOrigen.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrigen.gridx = 0;
		gbc_lblOrigen.gridy = 1;
		panelT1P3.add(lblOrigen, gbc_lblOrigen);
		
		comboBoxEmpresaOrigen = new JComboBox();
		AutoCompleteDecorator.decorate(this.comboBoxEmpresaOrigen);
		
				GridBagConstraints gbc_comboBoxEmpresaOrigen = new GridBagConstraints();
				gbc_comboBoxEmpresaOrigen.insets = new Insets(0, 0, 5, 5);
				gbc_comboBoxEmpresaOrigen.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBoxEmpresaOrigen.gridx = 1;
				gbc_comboBoxEmpresaOrigen.gridy = 1;
				panelT1P3.add(comboBoxEmpresaOrigen, gbc_comboBoxEmpresaOrigen);
				
				buttonNuevaEmpresa2 = new JButton("Nuevo");
				buttonNuevaEmpresa2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EmpresaProveedorCargar empresaProveedorCarga = new EmpresaProveedorCargar();
						empresaProveedorCarga.setModal(true);
						empresaProveedorCarga.setVisible(true);
						asignarValoresEmpresa();
					}
				});
				GridBagConstraints gbc_buttonNuevaEmpresa2 = new GridBagConstraints();
				gbc_buttonNuevaEmpresa2.fill = GridBagConstraints.HORIZONTAL;
				gbc_buttonNuevaEmpresa2.insets = new Insets(0, 0, 5, 0);
				gbc_buttonNuevaEmpresa2.gridx = 2;
				gbc_buttonNuevaEmpresa2.gridy = 1;
				panelT1P3.add(buttonNuevaEmpresa2, gbc_buttonNuevaEmpresa2);
				
				lblCdigoDePadre = new JLabel("C\u00F3digo interno de madre");
				GridBagConstraints gbc_lblCdigoDePadre = new GridBagConstraints();
				gbc_lblCdigoDePadre.anchor = GridBagConstraints.EAST;
				gbc_lblCdigoDePadre.insets = new Insets(0, 0, 5, 5);
				gbc_lblCdigoDePadre.gridx = 0;
				gbc_lblCdigoDePadre.gridy = 2;
				panelT1P3.add(lblCdigoDePadre, gbc_lblCdigoDePadre);
				
				textFieldCodigoDePadre = new JTextField();
				GridBagConstraints gbc_textFieldCodigoDePadre = new GridBagConstraints();
				gbc_textFieldCodigoDePadre.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldCodigoDePadre.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldCodigoDePadre.gridx = 1;
				gbc_textFieldCodigoDePadre.gridy = 2;
				panelT1P3.add(textFieldCodigoDePadre, gbc_textFieldCodigoDePadre);
				textFieldCodigoDePadre.setColumns(10);
				
				btnBuscar = new JButton("Buscar");
				GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
				gbc_btnBuscar.insets = new Insets(0, 0, 5, 0);
				gbc_btnBuscar.gridx = 2;
				gbc_btnBuscar.gridy = 2;
				panelT1P3.add(btnBuscar, gbc_btnBuscar);
				
				lblCdigoTango = new JLabel("C\u00F3digo tango");
				GridBagConstraints gbc_lblCdigoTango = new GridBagConstraints();
				gbc_lblCdigoTango.anchor = GridBagConstraints.EAST;
				gbc_lblCdigoTango.insets = new Insets(0, 0, 5, 5);
				gbc_lblCdigoTango.gridx = 0;
				gbc_lblCdigoTango.gridy = 3;
				panelT1P3.add(lblCdigoTango, gbc_lblCdigoTango);
				
				textFieldCodigoTango = new JTextField();
				GridBagConstraints gbc_textFieldCodigoTango = new GridBagConstraints();
				gbc_textFieldCodigoTango.gridwidth = 2;
				gbc_textFieldCodigoTango.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldCodigoTango.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldCodigoTango.gridx = 1;
				gbc_textFieldCodigoTango.gridy = 3;
				panelT1P3.add(textFieldCodigoTango, gbc_textFieldCodigoTango);
				textFieldCodigoTango.setColumns(10);
				
				lblNBoleta = new JLabel("N\u00BA Boleta");
				GridBagConstraints gbc_lblNBoleta = new GridBagConstraints();
				gbc_lblNBoleta.anchor = GridBagConstraints.EAST;
				gbc_lblNBoleta.insets = new Insets(0, 0, 5, 5);
				gbc_lblNBoleta.gridx = 0;
				gbc_lblNBoleta.gridy = 4;
				panelT1P3.add(lblNBoleta, gbc_lblNBoleta);
				
				textFieldNBoleta = new JTextField();
				GridBagConstraints gbc_textFieldNBoleta = new GridBagConstraints();
				gbc_textFieldNBoleta.gridwidth = 2;
				gbc_textFieldNBoleta.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldNBoleta.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldNBoleta.gridx = 1;
				gbc_textFieldNBoleta.gridy = 4;
				panelT1P3.add(textFieldNBoleta, gbc_textFieldNBoleta);
				textFieldNBoleta.setColumns(10);
				
				lblCdigoBobinaPadre = new JLabel("C\u00F3digo bobina origen");
				GridBagConstraints gbc_lblCdigoBobinaPadre = new GridBagConstraints();
				gbc_lblCdigoBobinaPadre.anchor = GridBagConstraints.EAST;
				gbc_lblCdigoBobinaPadre.insets = new Insets(0, 0, 5, 5);
				gbc_lblCdigoBobinaPadre.gridx = 0;
				gbc_lblCdigoBobinaPadre.gridy = 5;
				panelT1P3.add(lblCdigoBobinaPadre, gbc_lblCdigoBobinaPadre);
				
				textFieldCdigoBobinaPadre = new JTextField();
				GridBagConstraints gbc_textFieldCdigoBobinaPadre = new GridBagConstraints();
				gbc_textFieldCdigoBobinaPadre.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldCdigoBobinaPadre.gridwidth = 2;
				gbc_textFieldCdigoBobinaPadre.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldCdigoBobinaPadre.gridx = 1;
				gbc_textFieldCdigoBobinaPadre.gridy = 5;
				panelT1P3.add(textFieldCdigoBobinaPadre, gbc_textFieldCdigoBobinaPadre);
				textFieldCdigoBobinaPadre.setColumns(10);
				btnBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						MateriaPrimaCargarBuscarCodigoPadre nuevaMat = new MateriaPrimaCargarBuscarCodigoPadre();
						nuevaMat.setModal(true);
						nuevaMat.setVisible(true);
						String codigo = nuevaMat.getCodigo();
						textFieldCodigoDePadre.setText(codigo);
					}
				});
		
		lblT1Observacion = new JLabel("Observaciones");
		
		scrollPane = new JScrollPane();
		
		textPaneT1Observaciones = new JTextPane();
		scrollPane.setViewportView(textPaneT1Observaciones);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				InsertarMateriaPrima();
				
				
			}
		});
		GroupLayout gl_panelT1 = new GroupLayout(panelT1);
		gl_panelT1.setHorizontalGroup(
			gl_panelT1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelT1.createSequentialGroup()
					.addGroup(gl_panelT1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelT1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelT1.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelT1.createSequentialGroup()
									.addComponent(lblT1Observacion)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelT1.createParallelGroup(Alignment.LEADING)
									.addComponent(panelT1P3, GroupLayout.PREFERRED_SIZE, 521, GroupLayout.PREFERRED_SIZE)
									.addComponent(panelT1P2, GroupLayout.PREFERRED_SIZE, 521, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnGuardar)))
						.addComponent(panelT1P1, GroupLayout.PREFERRED_SIZE, 521, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPaneT1, GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
					.addGap(7))
		);
		gl_panelT1.setVerticalGroup(
			gl_panelT1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelT1.createSequentialGroup()
					.addGroup(gl_panelT1.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPaneT1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelT1.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelT1P1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelT1P2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelT1P3, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelT1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblT1Observacion)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnGuardar)))
					.addGap(147))
		);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		GridBagConstraints gbc_lblCantidad = new GridBagConstraints();
		gbc_lblCantidad.anchor = GridBagConstraints.EAST;
		gbc_lblCantidad.insets = new Insets(0, 0, 0, 5);
		gbc_lblCantidad.gridx = 2;
		gbc_lblCantidad.gridy = 4;
		panelT1P1.add(lblCantidad, gbc_lblCantidad);
		
		textFieldCantidad = new JTextField();
		GridBagConstraints gbc_textFieldCantidad = new GridBagConstraints();
		gbc_textFieldCantidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCantidad.gridx = 3;
		gbc_textFieldCantidad.gridy = 4;
		panelT1P1.add(textFieldCantidad, gbc_textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		lblNCertificado = new JLabel("N\u00BA Certificado");
		GridBagConstraints gbc_lblNCertificado = new GridBagConstraints();
		gbc_lblNCertificado.insets = new Insets(0, 0, 5, 5);
		gbc_lblNCertificado.anchor = GridBagConstraints.EAST;
		gbc_lblNCertificado.gridx = 0;
		gbc_lblNCertificado.gridy = 6;
		panelT1P3.add(lblNCertificado, gbc_lblNCertificado);
		
		textFieldNCertificadoT1 = new JTextField();
		GridBagConstraints gbc_textFieldNCertificadoT1 = new GridBagConstraints();
		gbc_textFieldNCertificadoT1.gridwidth = 2;
		gbc_textFieldNCertificadoT1.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNCertificadoT1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNCertificadoT1.gridx = 1;
		gbc_textFieldNCertificadoT1.gridy = 6;
		panelT1P3.add(textFieldNCertificadoT1, gbc_textFieldNCertificadoT1);
		textFieldNCertificadoT1.setColumns(10);
		
		lblUrlCertificado = new JLabel("URL Certificado");
		GridBagConstraints gbc_lblUrlCertificado = new GridBagConstraints();
		gbc_lblUrlCertificado.insets = new Insets(0, 0, 5, 5);
		gbc_lblUrlCertificado.anchor = GridBagConstraints.EAST;
		gbc_lblUrlCertificado.gridx = 0;
		gbc_lblUrlCertificado.gridy = 7;
		panelT1P3.add(lblUrlCertificado, gbc_lblUrlCertificado);
		
		textFieldUrlCertificadoT1 = new JTextField();
		GridBagConstraints gbc_textFieldUrlCertificadoT1 = new GridBagConstraints();
		gbc_textFieldUrlCertificadoT1.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldUrlCertificadoT1.gridwidth = 2;
		gbc_textFieldUrlCertificadoT1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUrlCertificadoT1.gridx = 1;
		gbc_textFieldUrlCertificadoT1.gridy = 7;
		panelT1P3.add(textFieldUrlCertificadoT1, gbc_textFieldUrlCertificadoT1);
		textFieldUrlCertificadoT1.setColumns(10);
		panelT1.setLayout(gl_panelT1);
		
		panelT2 = new JPanel();
		tabbedPane.addTab("Edicion de materia prima", null, panelT2, null);
		
		panelT2P1 = new JPanel();
		panelT2P1.setBorder(new TitledBorder(null, "Datos de material", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_panelT2P1 = new GridBagLayout();
		gbl_panelT2P1.columnWidths = new int[]{148, 98, 23, 144, 0};
		gbl_panelT2P1.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelT2P1.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelT2P1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelT2P1.setLayout(gbl_panelT2P1);
		
		JLabel label = new JLabel("C\u00F3digo");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panelT2P1.add(label, gbc_label);
		
		t2TextFieldCodigo = new AutoCompleteTextField();
		t2TextFieldCodigo.setEnabled(false);
		t2TextFieldCodigo.setColumns(10);
		GridBagConstraints gbc_t2TextFieldCodigo = new GridBagConstraints();
		gbc_t2TextFieldCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_t2TextFieldCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_t2TextFieldCodigo.gridx = 1;
		gbc_t2TextFieldCodigo.gridy = 0;
		panelT2P1.add(t2TextFieldCodigo, gbc_t2TextFieldCodigo);
		
		chckbxEnStock = new JCheckBox("En stock");
		GridBagConstraints gbc_chckbxEnStock = new GridBagConstraints();
		gbc_chckbxEnStock.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxEnStock.gridx = 3;
		gbc_chckbxEnStock.gridy = 0;
		panelT2P1.add(chckbxEnStock, gbc_chckbxEnStock);
		
		JLabel label_1 = new JLabel("Tipo*");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.fill = GridBagConstraints.VERTICAL;
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		panelT2P1.add(label_1, gbc_label_1);
		
		comboBoxT2Tipo = new JComboBox();
		comboBoxT2Tipo.setEnabled(false);
		AutoCompleteDecorator.decorate(this.comboBoxT2Tipo);
		GridBagConstraints gbc_comboBoxT2Tipo = new GridBagConstraints();
		gbc_comboBoxT2Tipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxT2Tipo.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxT2Tipo.gridx = 1;
		gbc_comboBoxT2Tipo.gridy = 1;
		panelT2P1.add(comboBoxT2Tipo, gbc_comboBoxT2Tipo);
		
		JButton button = new JButton("Nuevo");
		button.setEnabled(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MateriaPrimaTipoCargar nuevoTipoMat = new MateriaPrimaTipoCargar();
				nuevoTipoMat.setModal(true);
				nuevoTipoMat.setVisible(true);
				asignarValoresTipo();
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 3;
		gbc_button.gridy = 1;
		panelT2P1.add(button, gbc_button);
		
		JLabel label_2 = new JLabel("Descripci\u00F3n");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.fill = GridBagConstraints.VERTICAL;
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 2;
		panelT2P1.add(label_2, gbc_label_2);
		
		t2TextFieldDescripcion = new JTextField();
		t2TextFieldDescripcion.setColumns(10);
		GridBagConstraints gbc_t2TextFieldDescripcion = new GridBagConstraints();
		gbc_t2TextFieldDescripcion.fill = GridBagConstraints.BOTH;
		gbc_t2TextFieldDescripcion.gridwidth = 3;
		gbc_t2TextFieldDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_t2TextFieldDescripcion.gridx = 1;
		gbc_t2TextFieldDescripcion.gridy = 2;
		panelT2P1.add(t2TextFieldDescripcion, gbc_t2TextFieldDescripcion);
		
		JLabel label_3 = new JLabel("Espesor");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.fill = GridBagConstraints.VERTICAL;
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 3;
		panelT2P1.add(label_3, gbc_label_3);
		
		t2TextFieldEspesor = new JTextField();
		t2TextFieldEspesor.setColumns(10);
		GridBagConstraints gbc_t2TextFieldEspesor = new GridBagConstraints();
		gbc_t2TextFieldEspesor.fill = GridBagConstraints.BOTH;
		gbc_t2TextFieldEspesor.gridwidth = 3;
		gbc_t2TextFieldEspesor.insets = new Insets(0, 0, 5, 0);
		gbc_t2TextFieldEspesor.gridx = 1;
		gbc_t2TextFieldEspesor.gridy = 3;
		panelT2P1.add(t2TextFieldEspesor, gbc_t2TextFieldEspesor);
		
		JLabel label_4 = new JLabel("Peso");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.fill = GridBagConstraints.VERTICAL;
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 0, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 4;
		panelT2P1.add(label_4, gbc_label_4);
		
		t2TextFieldPeso = new JTextField();
		t2TextFieldPeso.setColumns(10);
		GridBagConstraints gbc_t2TextFieldPeso = new GridBagConstraints();
		gbc_t2TextFieldPeso.insets = new Insets(0, 0, 0, 5);
		gbc_t2TextFieldPeso.fill = GridBagConstraints.BOTH;
		gbc_t2TextFieldPeso.gridx = 1;
		gbc_t2TextFieldPeso.gridy = 4;
		panelT2P1.add(t2TextFieldPeso, gbc_t2TextFieldPeso);
		
		panelT2P4 = new JPanel();
		panelT2P4.setBorder(new TitledBorder(null, "Herramientas de busqueda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_panelT2P4 = new GridBagLayout();
		gbl_panelT2P4.columnWidths = new int[]{0, 0, 0, 91, 0, 0, 196, 0, 0};
		gbl_panelT2P4.rowHeights = new int[]{20, 0, 0, 0, 15, 26, 0};
		gbl_panelT2P4.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelT2P4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		panelT2P4.setLayout(gbl_panelT2P4);
		
		JLabel label_5 = new JLabel("Buscar por codigo");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.WEST;
		gbc_label_5.gridwidth = 4;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 0;
		panelT2P4.add(label_5, gbc_label_5);
		
		chckbxIncluirFuerqaDe = new JCheckBox("Incluir fuerqa de stock");
		GridBagConstraints gbc_chckbxIncluirFuerqaDe = new GridBagConstraints();
		gbc_chckbxIncluirFuerqaDe.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxIncluirFuerqaDe.gridx = 7;
		gbc_chckbxIncluirFuerqaDe.gridy = 0;
		panelT2P4.add(chckbxIncluirFuerqaDe, gbc_chckbxIncluirFuerqaDe);
		
		JLabel label_6 = new JLabel("C\u00F3digo");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.EAST;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 2;
		gbc_label_6.gridy = 1;
		panelT2P4.add(label_6, gbc_label_6);
		
		textFieldCodigoBuscar = new JTextField();
		textFieldCodigoBuscar.setColumns(10);
		GridBagConstraints gbc_textFieldCodigoBuscar = new GridBagConstraints();
		gbc_textFieldCodigoBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCodigoBuscar.anchor = GridBagConstraints.NORTH;
		gbc_textFieldCodigoBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCodigoBuscar.gridx = 3;
		gbc_textFieldCodigoBuscar.gridy = 1;
		panelT2P4.add(textFieldCodigoBuscar, gbc_textFieldCodigoBuscar);
		
		JButton button_1 = new JButton("Buscar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarMateriaPrimaPorCodigo();
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.anchor = GridBagConstraints.WEST;
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 6;
		gbc_button_1.gridy = 1;
		panelT2P4.add(button_1, gbc_button_1);
		
		JLabel lblBuscarSegnIntervalo = new JLabel("Buscar seg\u00FAn intervalo de fecha de ingreso");
		GridBagConstraints gbc_lblBuscarSegnIntervalo = new GridBagConstraints();
		gbc_lblBuscarSegnIntervalo.anchor = GridBagConstraints.WEST;
		gbc_lblBuscarSegnIntervalo.gridwidth = 4;
		gbc_lblBuscarSegnIntervalo.insets = new Insets(0, 0, 5, 5);
		gbc_lblBuscarSegnIntervalo.gridx = 0;
		gbc_lblBuscarSegnIntervalo.gridy = 3;
		panelT2P4.add(lblBuscarSegnIntervalo, gbc_lblBuscarSegnIntervalo);
		
		JLabel label_8 = new JLabel("Desde");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 2;
		gbc_label_8.gridy = 4;
		panelT2P4.add(label_8, gbc_label_8);
		
		dateChooserDesdeBusqueda = new JDateChooser();
		GridBagConstraints gbc_dateChooserDesdeBusqueda = new GridBagConstraints();
		gbc_dateChooserDesdeBusqueda.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooserDesdeBusqueda.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooserDesdeBusqueda.gridx = 3;
		gbc_dateChooserDesdeBusqueda.gridy = 4;
		panelT2P4.add(dateChooserDesdeBusqueda, gbc_dateChooserDesdeBusqueda);
		
		JLabel label_9 = new JLabel("Hasta");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 5;
		gbc_label_9.gridy = 4;
		panelT2P4.add(label_9, gbc_label_9);
		
		dateChooserHastaBusqueda = new JDateChooser();
		GridBagConstraints gbc_dateChooserHastaBusqueda = new GridBagConstraints();
		gbc_dateChooserHastaBusqueda.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooserHastaBusqueda.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooserHastaBusqueda.gridx = 6;
		gbc_dateChooserHastaBusqueda.gridy = 4;
		panelT2P4.add(dateChooserHastaBusqueda, gbc_dateChooserHastaBusqueda);
		
		JButton button_2 = new JButton("Buscar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarMateriaPrimaPorFechas(); 
			}
		});
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 0);
		gbc_button_2.gridx = 7;
		gbc_button_2.gridy = 4;
		panelT2P4.add(button_2, gbc_button_2);
		
		panelT2P2 = new JPanel();
		panelT2P2.setBorder(new TitledBorder(null, "Datos de procedencia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_panelT2P2 = new GridBagLayout();
		gbl_panelT2P2.columnWidths = new int[]{148, 266, 0, 0};
		gbl_panelT2P2.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panelT2P2.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelT2P2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelT2P2.setLayout(gbl_panelT2P2);
		
		JLabel label_10 = new JLabel("Calidad*");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.anchor = GridBagConstraints.EAST;
		gbc_label_10.insets = new Insets(0, 0, 5, 5);
		gbc_label_10.gridx = 0;
		gbc_label_10.gridy = 0;
		panelT2P2.add(label_10, gbc_label_10);
		
		comboBoxT2Calidad = new JComboBox();
		AutoCompleteDecorator.decorate(this.comboBoxT2Calidad);
		GridBagConstraints gbc_comboBoxT2Calidad = new GridBagConstraints();
		gbc_comboBoxT2Calidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxT2Calidad.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxT2Calidad.gridx = 1;
		gbc_comboBoxT2Calidad.gridy = 0;
		panelT2P2.add(comboBoxT2Calidad, gbc_comboBoxT2Calidad);
		
		JButton button_3 = new JButton("Nuevo");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalidadMateriaPrimaCargar cargarCal = new CalidadMateriaPrimaCargar();
				cargarCal.setModal(true);
				cargarCal.setVisible(true);
				asignarValoresCalidades();
			}
		});
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 5, 0);
		gbc_button_3.gridx = 2;
		gbc_button_3.gridy = 0;
		panelT2P2.add(button_3, gbc_button_3);
		
		JLabel label_11 = new JLabel("N\u00BA Remito*");
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.anchor = GridBagConstraints.EAST;
		gbc_label_11.insets = new Insets(0, 0, 5, 5);
		gbc_label_11.gridx = 0;
		gbc_label_11.gridy = 1;
		panelT2P2.add(label_11, gbc_label_11);
		
		t2TextFieldRemito = new JTextField();
		t2TextFieldRemito.setColumns(10);
		GridBagConstraints gbc_t2TextFieldRemito = new GridBagConstraints();
		gbc_t2TextFieldRemito.fill = GridBagConstraints.HORIZONTAL;
		gbc_t2TextFieldRemito.gridwidth = 2;
		gbc_t2TextFieldRemito.insets = new Insets(0, 0, 5, 0);
		gbc_t2TextFieldRemito.gridx = 1;
		gbc_t2TextFieldRemito.gridy = 1;
		panelT2P2.add(t2TextFieldRemito, gbc_t2TextFieldRemito);
		
		JLabel label_12 = new JLabel("Empresa");
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.anchor = GridBagConstraints.EAST;
		gbc_label_12.insets = new Insets(0, 0, 5, 5);
		gbc_label_12.gridx = 0;
		gbc_label_12.gridy = 2;
		panelT2P2.add(label_12, gbc_label_12);
		
		comboBoxT2Empresa = new JComboBox();
		AutoCompleteDecorator.decorate(this.comboBoxT2Empresa);
		GridBagConstraints gbc_comboBoxT2Empresa = new GridBagConstraints();
		gbc_comboBoxT2Empresa.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxT2Empresa.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxT2Empresa.gridx = 1;
		gbc_comboBoxT2Empresa.gridy = 2;
		panelT2P2.add(comboBoxT2Empresa, gbc_comboBoxT2Empresa);
		
		JButton button_4 = new JButton("Nuevo");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmpresaProveedorCargar empresaProveedorCarga = new EmpresaProveedorCargar();
				empresaProveedorCarga.setModal(true);
				empresaProveedorCarga.setVisible(true);
				asignarValoresEmpresa();
			}
		});
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(0, 0, 5, 0);
		gbc_button_4.gridx = 2;
		gbc_button_4.gridy = 2;
		panelT2P2.add(button_4, gbc_button_4);
		
		JLabel label_13 = new JLabel("Fecha de ingreso*");
		GridBagConstraints gbc_label_13 = new GridBagConstraints();
		gbc_label_13.anchor = GridBagConstraints.EAST;
		gbc_label_13.insets = new Insets(0, 0, 0, 5);
		gbc_label_13.gridx = 0;
		gbc_label_13.gridy = 3;
		panelT2P2.add(label_13, gbc_label_13);
		
		t2DateChooser = new JDateChooser();
		GridBagConstraints gbc_t2DateChooser = new GridBagConstraints();
		gbc_t2DateChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_t2DateChooser.gridwidth = 2;
		gbc_t2DateChooser.gridx = 1;
		gbc_t2DateChooser.gridy = 3;
		panelT2P2.add(t2DateChooser, gbc_t2DateChooser);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		
		tableT2Materiales = new JTable();
		tableT2Materiales.setModel(new DefaultTableModel(
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
		scrollPane_3.setViewportView(tableT2Materiales);
		
		ListSelectionModel lsm=tableT2Materiales.getSelectionModel();
		lsm.addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {
				System.out.println(posTabla);
				if (posTabla!=tableT2Materiales.getSelectedRow()) {
					posTabla=tableT2Materiales.getSelectedRow();
					cargarMateriaPrima();

				}			
			}
		});
		
		panelT2P3 = new JPanel();
		panelT2P3.setBorder(new TitledBorder(null, "Datos de seguimiento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_panelT2P3 = new GridBagLayout();
		gbl_panelT2P3.columnWidths = new int[]{148, 266, 0, 0};
		gbl_panelT2P3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelT2P3.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelT2P3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelT2P3.setLayout(gbl_panelT2P3);
		
		JLabel label_15 = new JLabel("Colada");
		GridBagConstraints gbc_label_15 = new GridBagConstraints();
		gbc_label_15.fill = GridBagConstraints.VERTICAL;
		gbc_label_15.anchor = GridBagConstraints.EAST;
		gbc_label_15.insets = new Insets(0, 0, 5, 5);
		gbc_label_15.gridx = 0;
		gbc_label_15.gridy = 0;
		panelT2P3.add(label_15, gbc_label_15);
		
		t2TextFieldColada = new JTextField();
		t2TextFieldColada.setColumns(10);
		GridBagConstraints gbc_t2TextFieldColada = new GridBagConstraints();
		gbc_t2TextFieldColada.fill = GridBagConstraints.BOTH;
		gbc_t2TextFieldColada.gridwidth = 2;
		gbc_t2TextFieldColada.insets = new Insets(0, 0, 5, 0);
		gbc_t2TextFieldColada.gridx = 1;
		gbc_t2TextFieldColada.gridy = 0;
		panelT2P3.add(t2TextFieldColada, gbc_t2TextFieldColada);
		
		JLabel label_16 = new JLabel("Origen");
		GridBagConstraints gbc_label_16 = new GridBagConstraints();
		gbc_label_16.anchor = GridBagConstraints.EAST;
		gbc_label_16.insets = new Insets(0, 0, 5, 5);
		gbc_label_16.gridx = 0;
		gbc_label_16.gridy = 1;
		panelT2P3.add(label_16, gbc_label_16);
		
		comboBoxT2EmpresaOrigen = new JComboBox();
		AutoCompleteDecorator.decorate(this.comboBoxT2EmpresaOrigen);
		GridBagConstraints gbc_comboBoxT2EmpresaOrigen = new GridBagConstraints();
		gbc_comboBoxT2EmpresaOrigen.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxT2EmpresaOrigen.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxT2EmpresaOrigen.gridx = 1;
		gbc_comboBoxT2EmpresaOrigen.gridy = 1;
		panelT2P3.add(comboBoxT2EmpresaOrigen, gbc_comboBoxT2EmpresaOrigen);
		
		JButton button_5 = new JButton("Nuevo");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmpresaProveedorCargar empresaProveedorCarga = new EmpresaProveedorCargar();
				empresaProveedorCarga.setModal(true);
				empresaProveedorCarga.setVisible(true);
				asignarValoresEmpresa();
			}
		});
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_5.insets = new Insets(0, 0, 5, 0);
		gbc_button_5.gridx = 2;
		gbc_button_5.gridy = 1;
		panelT2P3.add(button_5, gbc_button_5);
		
		JLabel lblCdigoInternoDe = new JLabel("C\u00F3digo interno de madre");
		GridBagConstraints gbc_lblCdigoInternoDe = new GridBagConstraints();
		gbc_lblCdigoInternoDe.anchor = GridBagConstraints.EAST;
		gbc_lblCdigoInternoDe.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigoInternoDe.gridx = 0;
		gbc_lblCdigoInternoDe.gridy = 2;
		panelT2P3.add(lblCdigoInternoDe, gbc_lblCdigoInternoDe);
		
		t2TextFieldCodigoInternoPadre = new JTextField();
		t2TextFieldCodigoInternoPadre.setColumns(10);
		GridBagConstraints gbc_t2TextFieldCodigoInternoPadre = new GridBagConstraints();
		gbc_t2TextFieldCodigoInternoPadre.fill = GridBagConstraints.HORIZONTAL;
		gbc_t2TextFieldCodigoInternoPadre.insets = new Insets(0, 0, 5, 5);
		gbc_t2TextFieldCodigoInternoPadre.gridx = 1;
		gbc_t2TextFieldCodigoInternoPadre.gridy = 2;
		panelT2P3.add(t2TextFieldCodigoInternoPadre, gbc_t2TextFieldCodigoInternoPadre);
		
		JButton button_6 = new JButton("Buscar");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MateriaPrimaCargarBuscarCodigoPadre nuevaMat = new MateriaPrimaCargarBuscarCodigoPadre();
				nuevaMat.setModal(true);
				nuevaMat.setVisible(true);
				String codigo = nuevaMat.getCodigo();
				textFieldCodigoDePadre.setText(codigo);
			}
		});
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.insets = new Insets(0, 0, 5, 0);
		gbc_button_6.gridx = 2;
		gbc_button_6.gridy = 2;
		panelT2P3.add(button_6, gbc_button_6);
		
		JLabel label_18 = new JLabel("C\u00F3digo tango");
		GridBagConstraints gbc_label_18 = new GridBagConstraints();
		gbc_label_18.anchor = GridBagConstraints.EAST;
		gbc_label_18.insets = new Insets(0, 0, 5, 5);
		gbc_label_18.gridx = 0;
		gbc_label_18.gridy = 3;
		panelT2P3.add(label_18, gbc_label_18);
		
		t2TextFieldCodigoTango = new JTextField();
		t2TextFieldCodigoTango.setColumns(10);
		GridBagConstraints gbc_t2TextFieldCodigoTango = new GridBagConstraints();
		gbc_t2TextFieldCodigoTango.fill = GridBagConstraints.HORIZONTAL;
		gbc_t2TextFieldCodigoTango.gridwidth = 2;
		gbc_t2TextFieldCodigoTango.insets = new Insets(0, 0, 5, 0);
		gbc_t2TextFieldCodigoTango.gridx = 1;
		gbc_t2TextFieldCodigoTango.gridy = 3;
		panelT2P3.add(t2TextFieldCodigoTango, gbc_t2TextFieldCodigoTango);
		
		JLabel label_19 = new JLabel("N\u00BA Boleta");
		GridBagConstraints gbc_label_19 = new GridBagConstraints();
		gbc_label_19.anchor = GridBagConstraints.EAST;
		gbc_label_19.insets = new Insets(0, 0, 5, 5);
		gbc_label_19.gridx = 0;
		gbc_label_19.gridy = 4;
		panelT2P3.add(label_19, gbc_label_19);
		
		t2TextFieldBoleta = new JTextField();
		t2TextFieldBoleta.setColumns(10);
		GridBagConstraints gbc_t2TextFieldBoleta = new GridBagConstraints();
		gbc_t2TextFieldBoleta.fill = GridBagConstraints.HORIZONTAL;
		gbc_t2TextFieldBoleta.gridwidth = 2;
		gbc_t2TextFieldBoleta.insets = new Insets(0, 0, 5, 0);
		gbc_t2TextFieldBoleta.gridx = 1;
		gbc_t2TextFieldBoleta.gridy = 4;
		panelT2P3.add(t2TextFieldBoleta, gbc_t2TextFieldBoleta);
		
		JLabel lblCdigoBobinaOrigen = new JLabel("C\u00F3digo bobina origen");
		GridBagConstraints gbc_lblCdigoBobinaOrigen = new GridBagConstraints();
		gbc_lblCdigoBobinaOrigen.anchor = GridBagConstraints.EAST;
		gbc_lblCdigoBobinaOrigen.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigoBobinaOrigen.gridx = 0;
		gbc_lblCdigoBobinaOrigen.gridy = 5;
		panelT2P3.add(lblCdigoBobinaOrigen, gbc_lblCdigoBobinaOrigen);
		
		t2TextFieldCodigoBobinaPadre = new JTextField();
		t2TextFieldCodigoBobinaPadre.setColumns(10);
		GridBagConstraints gbc_t2TextFieldCodigoBobinaPadre = new GridBagConstraints();
		gbc_t2TextFieldCodigoBobinaPadre.insets = new Insets(0, 0, 5, 0);
		gbc_t2TextFieldCodigoBobinaPadre.fill = GridBagConstraints.HORIZONTAL;
		gbc_t2TextFieldCodigoBobinaPadre.gridwidth = 2;
		gbc_t2TextFieldCodigoBobinaPadre.gridx = 1;
		gbc_t2TextFieldCodigoBobinaPadre.gridy = 5;
		panelT2P3.add(t2TextFieldCodigoBobinaPadre, gbc_t2TextFieldCodigoBobinaPadre);
		
		JLabel label_14 = new JLabel("Observaciones");
		
		JScrollPane scrollPane_4 = new JScrollPane();
		
		textPaneT2Observaciones = new JTextPane();
		scrollPane_4.setViewportView(textPaneT2Observaciones);
		
		JButton btnGuardarCambios = new JButton("Guardar cambios");
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarMateriaPrima();
			}
		});
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarMateriaPrima();
			}
		});
		GroupLayout gl_panelT2 = new GroupLayout(panelT2);
		gl_panelT2.setHorizontalGroup(
			gl_panelT2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelT2.createSequentialGroup()
					.addGroup(gl_panelT2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelT2.createParallelGroup(Alignment.LEADING, false)
							.addGroup(Alignment.TRAILING, gl_panelT2.createSequentialGroup()
								.addContainerGap()
								.addComponent(btnEliminar)
								.addGap(18)
								.addComponent(btnGuardarCambios))
							.addComponent(panelT2P1, GroupLayout.PREFERRED_SIZE, 484, GroupLayout.PREFERRED_SIZE)
							.addComponent(panelT2P2, GroupLayout.PREFERRED_SIZE, 484, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panelT2.createSequentialGroup()
								.addComponent(label_14)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)))
						.addComponent(panelT2P3, GroupLayout.PREFERRED_SIZE, 484, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelT2.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelT2P4, GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
						.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE))
					.addGap(22))
		);
		gl_panelT2.setVerticalGroup(
			gl_panelT2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelT2.createSequentialGroup()
					.addGroup(gl_panelT2.createParallelGroup(Alignment.LEADING)
						.addComponent(panelT2P1, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelT2P4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelT2.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelT2.createSequentialGroup()
							.addComponent(panelT2P2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelT2P3, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelT2.createParallelGroup(Alignment.LEADING)
								.addComponent(label_14)
								.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelT2.createParallelGroup(Alignment.LEADING)
								.addComponent(btnGuardarCambios)
								.addComponent(btnEliminar)))
						.addComponent(scrollPane_3))
					.addGap(108))
		);
		
		lblCantidad_1 = new JLabel("Cantidad");
		GridBagConstraints gbc_lblCantidad_1 = new GridBagConstraints();
		gbc_lblCantidad_1.anchor = GridBagConstraints.EAST;
		gbc_lblCantidad_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblCantidad_1.gridx = 2;
		gbc_lblCantidad_1.gridy = 4;
		panelT2P1.add(lblCantidad_1, gbc_lblCantidad_1);
		
		t2textFieldCantidad = new JTextField();
		GridBagConstraints gbc_t2textFieldCantidad = new GridBagConstraints();
		gbc_t2textFieldCantidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_t2textFieldCantidad.gridx = 3;
		gbc_t2textFieldCantidad.gridy = 4;
		panelT2P1.add(t2textFieldCantidad, gbc_t2textFieldCantidad);
		t2textFieldCantidad.setColumns(10);
		
		label_7 = new JLabel("N\u00BA Certificado");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.anchor = GridBagConstraints.EAST;
		gbc_label_7.gridx = 0;
		gbc_label_7.gridy = 6;
		panelT2P3.add(label_7, gbc_label_7);
		
		textFieldNCertificado = new JTextField();
		GridBagConstraints gbc_textFieldNCertificado = new GridBagConstraints();
		gbc_textFieldNCertificado.gridwidth = 2;
		gbc_textFieldNCertificado.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNCertificado.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNCertificado.gridx = 1;
		gbc_textFieldNCertificado.gridy = 6;
		panelT2P3.add(textFieldNCertificado, gbc_textFieldNCertificado);
		textFieldNCertificado.setColumns(10);
		
		lblUrlCertificado_1 = new JLabel("URL Certificado");
		GridBagConstraints gbc_lblUrlCertificado_1 = new GridBagConstraints();
		gbc_lblUrlCertificado_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblUrlCertificado_1.anchor = GridBagConstraints.EAST;
		gbc_lblUrlCertificado_1.gridx = 0;
		gbc_lblUrlCertificado_1.gridy = 7;
		panelT2P3.add(lblUrlCertificado_1, gbc_lblUrlCertificado_1);
		
		textFieldURLCertificado = new JTextField();
		GridBagConstraints gbc_textFieldURLCertificado = new GridBagConstraints();
		gbc_textFieldURLCertificado.gridwidth = 2;
		gbc_textFieldURLCertificado.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldURLCertificado.gridx = 1;
		gbc_textFieldURLCertificado.gridy = 7;
		panelT2P3.add(textFieldURLCertificado, gbc_textFieldURLCertificado);
		textFieldURLCertificado.setColumns(10);
		panelT2.setLayout(gl_panelT2);
		
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.gridwidth = 3;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridx = 2;
		gbc_textFieldNombre.gridy = 2;
		asignarValoresTipo();
		asignarValoresEmpresa();
		asignarValoresCalidades();
	}
	
	private void asignarValoresTipo() {
		CargadorCombobox cc = new CargadorCombobox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(cc.generarContenidoTipoMateriaPrima()));
		comboBoxT2Tipo.setModel(new DefaultComboBoxModel(cc.generarContenidoTipoMateriaPrima()));
	}
	
	private void asignarValoresEmpresa() {
		CargadorCombobox cc = new CargadorCombobox();
		comboBoxEmpresa.setModel(new DefaultComboBoxModel(cc.generarContenidoEmpresaproveedoraMateriaPrima()));
		comboBoxEmpresaOrigen.setModel(new DefaultComboBoxModel(cc.generarContenidoEmpresaproveedoraMateriaPrima()));
		comboBoxT2Empresa.setModel(new DefaultComboBoxModel(cc.generarContenidoEmpresaproveedoraMateriaPrima()));
		comboBoxT2EmpresaOrigen.setModel(new DefaultComboBoxModel(cc.generarContenidoEmpresaproveedoraMateriaPrima()));
		
		
	}
	
	private void asignarValoresCalidades() {
		CargadorCombobox cc = new CargadorCombobox();
		comboBoxCalidad.setModel(new DefaultComboBoxModel(cc.generarContenidoCalidadMateriaPrima()));
		comboBoxT2Calidad.setModel(new DefaultComboBoxModel(cc.generarContenidoCalidadMateriaPrima()));

	}
	
	
	private void InsertarMateriaPrima () {
		if (!comboBoxTipo.getSelectedItem().toString().isEmpty() && 
			!comboBoxTipo.getSelectedItem().equals("")  && 
			!textFieldNRemito.getText().isEmpty() && 
			!textFieldNRemito.getText().equals("") && 
			!comboBoxCalidad.getSelectedItem().toString().isEmpty() && 
			!comboBoxCalidad.getSelectedItem().equals("") && 
			dateChooser.getDate()!=null) {
				System.out.println("Insert");
				boolean valido =true;
				MateriaPrimaBean materiaPrima = new MateriaPrimaBean();
				String formato = dateChooser.getDateFormatString();
				Date date = dateChooser.getDate();
				SimpleDateFormat sdf = new SimpleDateFormat(formato);
				materiaPrima.setFechaIngreso(String.valueOf(sdf.format(date)));
				
				materiaPrima.setCalidad(comboBoxCalidad.getSelectedItem().toString());
				materiaPrima.setColada(textFieldColada.getText());
				materiaPrima.setDescripcion(textFieldDescripcion.getText());
				materiaPrima.setEmpresa(comboBoxEmpresa.getSelectedItem().toString());
				materiaPrima.setCodigoBobinaPadre(textFieldCdigoBobinaPadre.getText());
				materiaPrima.setObservaciones(textPaneT1Observaciones.getText());
				if ( textFieldEspesor.getText()!="" &&  !textFieldEspesor.getText().isEmpty()) {
					try{
						materiaPrima.setEspesor(Float.parseFloat((String) textFieldEspesor.getText()));
					}catch(NumberFormatException e){ 
						// captura la exepcion, en caso de que no sea un formato de Float valido y envia un mensaje.
						valido = false;
						javax.swing.JOptionPane.showMessageDialog(null, "Lo sentimos el valor ingresado de espesor no es valido, verifique");
					}
				}
				
				
				materiaPrima.setOrigen(comboBoxEmpresaOrigen.getSelectedItem().toString());
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
				
				if ( textFieldCantidad.getText()!="" &&  !textFieldCantidad.getText().isEmpty()) {
					try{
						materiaPrima.setCantidad(Float.parseFloat((String) textFieldCantidad.getText()));
					}catch(NumberFormatException e){ 
						// captura la exepcion, en caso de que no sea un formato de Float valido y envia un mensaje.
						valido = false;
						javax.swing.JOptionPane.showMessageDialog(null, "Lo sentimos el valor ingresado de cantidad no es valido, verifique");
					}
				}
				materiaPrima.setRemitoNum(textFieldNRemito.getText());
				
				
				materiaPrima.setTipo(comboBoxTipo.getSelectedItem().toString());
				materiaPrima.setBoletaNum(textFieldNBoleta.getText());
				materiaPrima.setnCertificado(textFieldNCertificadoT1.getText());
				materiaPrima.setUrlCertificado(textFieldUrlCertificadoT1.getText());
				
				int aux = 0;
				if (valido) {
					MateriaPrimaController mController = new MateriaPrimaController();
					try {
						System.out.println("entre try");
						aux = mController.insertMateriaPrima(materiaPrima);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (aux==1) {
					textFieldCodigo.setText(materiaPrima.getCodigo());
					insertarEnTabla(materiaPrima);
				}else {
					javax.swing.JOptionPane.showMessageDialog(null, "Error en la carga, verifique");
				}
				/*
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
	

	private void buscarMateriaPrimaPorCodigo() {
		CargadorTabla ct = new CargadorTabla();
		ct.generarContenidoMateriaPrimaPorCodigo((DefaultTableModel) tableT2Materiales.getModel(), textFieldCodigoBuscar.getText(), chckbxIncluirFuerqaDe.isSelected());
		if (tableT2Materiales.getRowCount()<1) {
			javax.swing.JOptionPane.showMessageDialog(null, "No se encontraron elementos que cumplan con las especificaciones de búsqueda");
			limpiarCampos(panelT2);
			comboBoxT2Calidad.setSelectedIndex(0);
			comboBoxT2Empresa.setSelectedIndex(0);
			comboBoxT2EmpresaOrigen.setSelectedIndex(0);
			comboBoxT2Tipo.setSelectedIndex(0);
			textPaneT2Observaciones.setText("");
		}
		
	}
	
	
	private void buscarMateriaPrimaPorFechas() {
		
		if (dateChooserDesdeBusqueda.getDate()!=null && dateChooserHastaBusqueda.getDate()!=null) {
			String formato = dateChooserDesdeBusqueda.getDateFormatString();
			
			Date date = dateChooserDesdeBusqueda.getDate();
			SimpleDateFormat sdf = new SimpleDateFormat(formato);
			
			String desde= String.valueOf(sdf.format(date));
			
			date = dateChooserHastaBusqueda.getDate();
			String hasta= String.valueOf(sdf.format(date));
			
			CargadorTabla ct = new CargadorTabla();
			ct.generarContenidoMateriaPrimaPorFechas((DefaultTableModel) tableT2Materiales.getModel(), desde, hasta, chckbxIncluirFuerqaDe.isSelected());
			if (tableT2Materiales.getRowCount()<1) {
				javax.swing.JOptionPane.showMessageDialog(null, "No se encontraron elementos que cumplan con las especificaciones de búsqueda");
				limpiarCampos(panelT2);
				comboBoxT2Calidad.setSelectedIndex(0);
				comboBoxT2Empresa.setSelectedIndex(0);
				comboBoxT2EmpresaOrigen.setSelectedIndex(0);
				comboBoxT2Tipo.setSelectedIndex(0);
				textPaneT2Observaciones.setText("");
			} 
			
			
		} else {
			javax.swing.JOptionPane.showMessageDialog(null, "Los campos 'Desde' y 'Hasta' son obligatorios");
		}
		
	}
	
	private void cargarMateriaPrima() {
		if (tableT2Materiales.getSelectedRow()!=-1 ) {
			codigo = (String) tableT2Materiales.getValueAt(tableT2Materiales.getSelectedRow(), 0);
			MateriaPrimaController mController = new MateriaPrimaController();
			MateriaPrimaBean materiaPrima = new MateriaPrimaBean();
			try {
				materiaPrima = mController.devolverMateriaPrimaPorCodigo(codigo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cargarEnFields (materiaPrima);
		}
	}

	private void cargarEnFields(MateriaPrimaBean materiaPrima) {
		t2TextFieldCodigo.setText(materiaPrima.getCodigo());
		t2TextFieldDescripcion.setText(materiaPrima.getDescripcion());
		t2TextFieldEspesor.setText(Float.toString(materiaPrima.getEspesor()));
		t2TextFieldPeso.setText(Float.toString(materiaPrima.getPeso()));
		t2TextFieldRemito.setText(materiaPrima.getRemitoNum());
		t2TextFieldColada.setText(materiaPrima.getColada());
		t2TextFieldCodigoInternoPadre.setText(materiaPrima.getPadre());
		t2TextFieldCodigoTango.setText(materiaPrima.getCodigoTango());
		t2TextFieldBoleta.setText(materiaPrima.getBoletaNum());
		t2TextFieldCodigoBobinaPadre.setText(materiaPrima.getCodigoBobinaPadre());
		comboBoxT2Calidad.setSelectedItem(materiaPrima.getCalidad());
		comboBoxT2Tipo.setSelectedItem(materiaPrima.getTipo());
		t2textFieldCantidad.setText(Float.toString(materiaPrima.getCantidad()));
		if (materiaPrima.getEmpresa()==null ) {
			comboBoxT2Empresa.setSelectedItem("(Ninguno)");
			
		} else {
			comboBoxT2Empresa.setSelectedItem(materiaPrima.getEmpresa());
		}
	
		if (materiaPrima.getOrigen()==null ) {
			comboBoxT2EmpresaOrigen.setSelectedItem("(Ninguno)");
			
		} else {
			comboBoxT2EmpresaOrigen.setSelectedItem(materiaPrima.getOrigen());	
		}
		
		
		textPaneT2Observaciones.setText(materiaPrima.getObservaciones());
		chckbxEnStock.setSelected(materiaPrima.isEnStock());
		setearFechaEnDateChooser(t2DateChooser, materiaPrima.getFechaIngreso());
		textFieldNCertificado.setText(materiaPrima.getnCertificado());
		textFieldURLCertificado.setText(materiaPrima.getUrlCertificado());

		
	}
	
	private void setearFechaEnDateChooser(JDateChooser dateFecha, String stringFecha) {
		Date fecha = null;
		try {
			fecha = new SimpleDateFormat("yyyy-MM-dd").parse(stringFecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dateFecha.setDate(fecha);		
		
	}
	
	private void modificarMateriaPrima () {
		if (!comboBoxT2Tipo.getSelectedItem().toString().isEmpty() && 
			!comboBoxT2Tipo.getSelectedItem().equals("")  && 
			!t2TextFieldRemito.getText().isEmpty() && 
			!t2TextFieldRemito.getText().equals("") && 
			!comboBoxT2Calidad.getSelectedItem().toString().isEmpty() && 
			!comboBoxT2Calidad.getSelectedItem().equals("") && 
			t2DateChooser.getDate()!=null) {
				boolean valido =true;
				MateriaPrimaBean materiaPrima = new MateriaPrimaBean();
				String formato = t2DateChooser.getDateFormatString();
				Date date = t2DateChooser.getDate();
				SimpleDateFormat sdf = new SimpleDateFormat(formato);
				materiaPrima.setFechaIngreso(String.valueOf(sdf.format(date)));
				materiaPrima.setCodigo(t2TextFieldCodigo.getText());
				materiaPrima.setCalidad(comboBoxT2Calidad.getSelectedItem().toString());
				materiaPrima.setColada(t2TextFieldColada.getText());
				materiaPrima.setDescripcion(t2TextFieldDescripcion.getText());
				materiaPrima.setEmpresa(comboBoxT2Empresa.getSelectedItem().toString());
				materiaPrima.setCodigoBobinaPadre(t2TextFieldCodigoBobinaPadre.getText());
				materiaPrima.setObservaciones(textPaneT2Observaciones.getText());
				materiaPrima.setEnStock(chckbxEnStock.isSelected());
				if ( t2TextFieldEspesor.getText()!="" &&  !t2TextFieldEspesor.getText().isEmpty()) {
					try{
						materiaPrima.setEspesor(Float.parseFloat((String) t2TextFieldEspesor.getText()));
					}catch(NumberFormatException e){ 
						// captura la exepcion, en caso de que no sea un formato de Float valido y envia un mensaje.
						valido = false;
						javax.swing.JOptionPane.showMessageDialog(null, "Lo sentimos el valor ingresado de espesor no es valido, verifique");
					}
				}
								
				materiaPrima.setOrigen(comboBoxT2EmpresaOrigen.getSelectedItem().toString());
				materiaPrima.setPadre(t2TextFieldCodigoInternoPadre.getText());
				materiaPrima.setCodigoTango(t2TextFieldCodigoTango.getText());
				if ( t2TextFieldPeso.getText()!="" &&  !t2TextFieldPeso.getText().isEmpty()) {
					try{
						materiaPrima.setPeso(Float.parseFloat((String) t2TextFieldPeso.getText()));
					}catch(NumberFormatException e){ 
						// captura la exepcion, en caso de que no sea un formato de Float valido y envia un mensaje.
						valido = false;
						javax.swing.JOptionPane.showMessageDialog(null, "Lo sentimos el valor ingresado de peso no es valido, verifique");
					}
				}
				if ( t2textFieldCantidad.getText()!="" &&  !t2textFieldCantidad.getText().isEmpty()) {
					try{
						materiaPrima.setCantidad(Float.parseFloat((String) t2textFieldCantidad.getText()));
					}catch(NumberFormatException e){ 
						// captura la exepcion, en caso de que no sea un formato de Float valido y envia un mensaje.
						valido = false;
						javax.swing.JOptionPane.showMessageDialog(null, "Lo sentimos el valor ingresado de cantidad no es valido, verifique");
					}
				}
				
				try{
					materiaPrima.setRemitoNum(t2TextFieldRemito.getText());
				}catch(NumberFormatException e){ 
					// captura la exepcion, en caso de que no sea un formato de int valido y envia un mensaje.
					valido = false;
					javax.swing.JOptionPane.showMessageDialog(null, "Lo sentimos el valor ingresado de número de remito no es valido, verifique");
				}
				
				materiaPrima.setTipo(comboBoxT2Tipo.getSelectedItem().toString());
				materiaPrima.setBoletaNum(t2TextFieldBoleta.getText());
				materiaPrima.setnCertificado(textFieldNCertificado.getText());
				materiaPrima.setUrlCertificado(textFieldURLCertificado.getText());
				int aux = 0;
				if (valido) {
					MateriaPrimaController mController = new MateriaPrimaController();
					try {
						aux = mController.updateMateriaPrima(materiaPrima);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (aux==1) {
					javax.swing.JOptionPane.showMessageDialog(null, "Los cambios se han guardados correctamente");
					//t2TextFieldCodigo.setText(materiaPrima.getCodigo());
				}else {
					javax.swing.JOptionPane.showMessageDialog(null, "Error en la carga, verifique");
				}				
		}
	}

	private void eliminarMateriaPrima() {
		int aux = 0;
		MateriaPrimaController mController = new MateriaPrimaController();
		try {
			aux = mController.deleteMateriaPrima(t2TextFieldCodigo.getText());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (aux==1) {
			javax.swing.JOptionPane.showMessageDialog(null, "El elemento se ha eliminado correctamente");
			//t2TextFieldCodigo.setText(materiaPrima.getCodigo());
			limpiarCampos(panelT2P1);
			limpiarCampos(panelT2P2);
			limpiarCampos(panelT2P3);
			comboBoxT2Calidad.setSelectedIndex(0);
			comboBoxT2Empresa.setSelectedIndex(0);
			comboBoxT2EmpresaOrigen.setSelectedIndex(0);
			comboBoxT2Tipo.setSelectedIndex(0);
			textPaneT2Observaciones.setText("");
			int aux2 = tableT2Materiales.getRowCount();
			for (int i = 0; i < aux ; i++) {
				 ((DefaultTableModel) tableT2Materiales.getModel()).removeRow(tableT2Materiales.getSelectedRow());
			}

		}else {
			javax.swing.JOptionPane.showMessageDialog(null, "Error al eliminar, verifique");
		}		
	}
	
	public void limpiarCampos(JPanel jPanel){ 
        for(int i=0; jPanel.getComponents().length>i;i++){
            if(jPanel.getComponents()[i]instanceof JTextField){
                ((JTextField)jPanel.getComponents()[i]).setText("");
            } else {
            	if(jPanel.getComponents()[i]instanceof JPanel){
            		limpiarCampos((JPanel) jPanel.getComponents()[i]);
                }
			}   
        }
	}     
}

