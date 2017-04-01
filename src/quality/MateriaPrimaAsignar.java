package quality;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ComboBoxModel;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.AbstractListModel;

import org.jfree.data.general.CombinationDataset;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.StringTokenizer;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class MateriaPrimaAsignar extends JInternalFrame {
	private JTable tablePiezas;
	private JTable tableMateriasPrimas;
	private JTable tablaListaMateriales;
	private JTextField textFieldCodigoMateria;
	private JTextField textFieldPiezaSeleccionada;
	private JComboBox comboBoxObra;
	private JComboBox comboBoxLista;
	private int posTabla = -1;
	private int codigo;


	/**
	 * Create the frame.
	 */
	public MateriaPrimaAsignar() {
		setFrameIcon(new ImageIcon("IMGS/logomiller.jpg"));
		setFrameIcon(null);
		setClosable(true);
		setRootPaneCheckingEnabled(false);
		setTitle("Asignar Materia Prima");
		setBounds(100, 100, 860, 464);
		
		JLabel lblObra = new JLabel("Obra");
		
		comboBoxObra = new JComboBox();
		comboBoxObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarComboboxNLista ();
				vaciarTabla((DefaultTableModel) tablaListaMateriales.getModel());
				vaciarTabla((DefaultTableModel) tablePiezas.getModel());
			}

		});
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		
		textFieldCodigoMateria = new JTextField();
		textFieldCodigoMateria.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MateriaPrimaCargarBuscarCodigoPadre nuevaMat = new MateriaPrimaCargarBuscarCodigoPadre();
				nuevaMat.setModal(true);
				nuevaMat.setVisible(true);
				String codigo = nuevaMat.getCodigo();
				textFieldCodigoMateria.setText(codigo);
				realizarAsignacion();
			}
			
		});
		
		JLabel lblLista = new JLabel("Lista");
		
		comboBoxLista = new JComboBox();
		comboBoxLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarTablaPiezas();
				vaciarTabla((DefaultTableModel) tablaListaMateriales.getModel());
				vaciarTabla((DefaultTableModel) tableMateriasPrimas.getModel());
			} 

		});
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				realizarAsignacion();
				
			}
		});
		
		JLabel lblPieza = new JLabel("C\u00F3digo de pieza");
		
		textFieldPiezaSeleccionada = new JTextField();
		textFieldPiezaSeleccionada.setEditable(false);
		textFieldPiezaSeleccionada.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		tablePiezas = new JTable();
		tablePiezas.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				
			}
		});
		tablePiezas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Pocici\u00F3n", "Descripci\u00F3n", "C\u00F3digo"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tablePiezas.getColumnModel().getColumn(0).setResizable(false);
		tablePiezas.getColumnModel().getColumn(0).setMaxWidth(120);
		tablePiezas.getColumnModel().getColumn(2).setMaxWidth(100);
		scrollPane.setViewportView(tablePiezas);
		
		ListSelectionModel lsm=tablePiezas.getSelectionModel();
		lsm.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				System.out.println(posTabla);
				if (posTabla!=tablePiezas.getSelectedRow()) {
					posTabla=tablePiezas.getSelectedRow();
					cargarListaMaterialesYMateriasAsignadas();

				}			
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		tablaListaMateriales = new JTable();
		tablaListaMateriales.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
			},
			new String[] {
				"Materiales"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablaListaMateriales.getColumnModel().getColumn(0).setResizable(false);
		scrollPane_1.setViewportView(tablaListaMateriales);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		tableMateriasPrimas = new JTable();
		tableMateriasPrimas.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Descripci\u00F3n", "Espesor", "Calidad", "Empresa", "Remito N\u00BA", "Ingreso"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableMateriasPrimas.getColumnModel().getColumn(0).setPreferredWidth(45);
		tableMateriasPrimas.getColumnModel().getColumn(0).setMaxWidth(70);
		tableMateriasPrimas.getColumnModel().getColumn(1).setPreferredWidth(92);
		tableMateriasPrimas.getColumnModel().getColumn(1).setMaxWidth(400);
		tableMateriasPrimas.getColumnModel().getColumn(2).setPreferredWidth(50);
		tableMateriasPrimas.getColumnModel().getColumn(2).setMaxWidth(70);
		tableMateriasPrimas.getColumnModel().getColumn(3).setPreferredWidth(45);
		tableMateriasPrimas.getColumnModel().getColumn(3).setMaxWidth(80);
		tableMateriasPrimas.getColumnModel().getColumn(4).setPreferredWidth(55);
		tableMateriasPrimas.getColumnModel().getColumn(4).setMaxWidth(80);
		tableMateriasPrimas.getColumnModel().getColumn(5).setPreferredWidth(65);
		tableMateriasPrimas.getColumnModel().getColumn(5).setMaxWidth(80);
		tableMateriasPrimas.getColumnModel().getColumn(6).setPreferredWidth(65);
		tableMateriasPrimas.getColumnModel().getColumn(6).setMaxWidth(80);
		scrollPane_2.setViewportView(tableMateriasPrimas);
		
		JButton btnQuitar = new JButton("Quitar");
		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tableMateriasPrimas.getSelectedRow()!=-1) {
					String codigoAsignacion = (String) tableMateriasPrimas.getValueAt(tableMateriasPrimas.getSelectedRow(), 0);
					quitarAsignacion(codigoAsignacion);
					}else{
						javax.swing.JOptionPane.showMessageDialog(null, "Debe seleccionar una materia prima");
					}	
			}

		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblObra)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(lblLista)))
							.addGap(5)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBoxLista, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxObra, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 227, Short.MAX_VALUE)
									.addComponent(lblCdigo)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPieza)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldPiezaSeleccionada, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
									.addGap(68)))
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textFieldCodigoMateria, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(btnBuscar))
								.addComponent(btnIngresar)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnQuitar)
								.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldCodigoMateria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscar)
								.addComponent(lblCdigo))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnIngresar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(lblObra))
								.addComponent(comboBoxObra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(lblLista))
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblPieza)
									.addComponent(textFieldPiezaSeleccionada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(comboBoxLista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnQuitar)))
					.addGap(32))
		);
		getContentPane().setLayout(groupLayout);
		
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.gridwidth = 3;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridx = 2;
		gbc_textFieldNombre.gridy = 2;

		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardar.anchor = GridBagConstraints.NORTH;
		gbc_btnGuardar.gridx = 3;
		gbc_btnGuardar.gridy = 4;

		cargarComboObra ();
	}

	private void cargarComboObra () {
		CargadorCombobox cargador = new CargadorCombobox();
		comboBoxObra.setModel(new DefaultComboBoxModel(cargador.generarContenidoObra()));
	}
	

	private void cargarComboboxNLista() {
		String obra = (String) comboBoxObra.getSelectedItem();
		StringTokenizer tk2 = new StringTokenizer(obra, " - ");
		int obra_num=Integer.parseInt(tk2.nextToken());
		CargadorCombobox cc = new CargadorCombobox();
		comboBoxLista.setModel(new DefaultComboBoxModel(cc.generarContenidoPaquetesConDescripcion(obra_num)));
	}
	

	private void cargarTablaPiezas() {
		
		String obra = (String) comboBoxObra.getSelectedItem();
		StringTokenizer tk = new StringTokenizer(obra, " - ");
		int obraNum=Integer.parseInt(tk.nextToken());
		
		String lista = (String) comboBoxLista.getSelectedItem();
		StringTokenizer tk2 = new StringTokenizer(lista, " - ");
		int listaNum=Integer.parseInt(tk2.nextToken());
		
		CargadorTabla ct = new CargadorTabla();
		ct.generarContenidoTablaPiezasAsignarMateriaPrima(obraNum, listaNum, tablePiezas.getModel());
		
		 
	}
	
	private void cargarListaMaterialesYMateriasAsignadas() {
		if (tablePiezas.getSelectedRow()!=-1 ) {
			codigo = (int) tablePiezas.getValueAt(tablePiezas.getSelectedRow(), 2);
			CargadorTabla ct = new CargadorTabla();
			ct.generarContenidoTablaMaterialesPorCodigo(codigo, (DefaultTableModel) tablaListaMateriales.getModel());
			textFieldPiezaSeleccionada.setText(Integer.toString(codigo));
			
			ct.generarContenidoTablaMateriasPrimasAsignadasPorCodigo(codigo, (DefaultTableModel) tableMateriasPrimas.getModel());
		}
	}
	
	
	private void vaciarTabla( DefaultTableModel modelo){
		int aux = modelo.getRowCount();
		for (int i = 0; i < aux ; i++) {
			modelo.removeRow(0);
		}
	}
	
	private void realizarAsignacion() {
		
		MateriaPrimaBean mPrima = new MateriaPrimaBean();
		MateriaPrimaController mCOntroller = new MateriaPrimaController();
		int msg=0;
		if (!textFieldCodigoMateria.getText().isEmpty() && !textFieldPiezaSeleccionada.getText().isEmpty()) {
			try {
				msg=mCOntroller.asignarMateriaPrimaEnStock(textFieldCodigoMateria.getText(), Integer.parseInt(textFieldPiezaSeleccionada.getText()), mPrima);
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switch (msg) {
			case 0:
				javax.swing.JOptionPane.showMessageDialog(this, "No se pudo realizar la asignación");
				break;
			case 1:
				break;
			case 2:
				javax.swing.JOptionPane.showMessageDialog(this, "La materia prima seleccionada ya se encuentra asignada a esta pieza");
				break;
			case -1:
				javax.swing.JOptionPane.showMessageDialog(this, "Error de conexion");	
			default:
				break;
			}
		} else {
			javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar una pieza y una materia prima");
		}
		if (mPrima.getCodigo()!=null && msg==1) {
			asignarMateriaPrimaATabla(mPrima);
		} else {

		}
	}
	
	private void asignarMateriaPrimaATabla(MateriaPrimaBean mPrima) {
		((DefaultTableModel) tableMateriasPrimas.getModel()).addRow(new Object[]
				{mPrima.getCodigo(), 
				mPrima.getDescripcion(), 
				mPrima.getEspesor(), 
				mPrima.getCalidad(),
				mPrima.getEmpresa(),
				mPrima.getRemitoNum(),
				mPrima.getFechaIngreso()
				});
		
	}
	private void quitarAsignacion(String codigoAsignacion) {
		MateriaPrimaController mController = new MateriaPrimaController();
		int aux = 0;
		try {
			aux = mController.quitarAsignacion(codigoAsignacion, codigo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		switch (aux) {
		case -1:
			javax.swing.JOptionPane.showMessageDialog(this, "Error de conexión");
			break;
		case -0:
			System.out.println(codigoAsignacion + " " + codigo);
			javax.swing.JOptionPane.showMessageDialog(this, "No se pudo quitar el elemento");
			break;
		case 1:
			javax.swing.JOptionPane.showMessageDialog(this, "Asignación eliminada con éxito");
			cargarListaMaterialesYMateriasAsignadas();
			break;
		default:
			break;
		}
	}
}


