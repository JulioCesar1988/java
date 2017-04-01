package quality;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import tools.CargadorCombobox;
import tools.CargadorTabla;
import tools.Java2sAutoComboBox;
import models.PaqueteBean;

import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.StringTokenizer;

import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class MateriaPrimaCargarBuscarCodigoPadre extends JDialog {
	private JPanel contentPane;
	private int obraNumero=-1;
	private int paqueteNumero=-1;
	private Boolean filtro=false;
	private String elemento;
	private String correlatividad;
	private JTable table;
	private String codigo = null;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaqueteInformacion frame = new PaqueteInformacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}   */

	/**
	 * Create the frame.
	 */
	public MateriaPrimaCargarBuscarCodigoPadre() {
		setType(Type.POPUP);
		setTitle("Cargar tipo de material");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow()!=-1) {
				codigo = (String) table.getValueAt(table.getSelectedRow(), 0);
				dispose();
				}else{
					javax.swing.JOptionPane.showMessageDialog(null, "Debe seleccionar una materia prima");
				}			
			}
		});
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAceptar)
							.addGap(18)
							.addComponent(btnCerrar)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCerrar)
						.addComponent(btnAceptar))
					.addContainerGap())
		);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
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
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(60);
		scrollPane.setViewportView(table);
		CargadorCombobox cc=new CargadorCombobox();
		contentPane.setLayout(gl_contentPane);
		
		cargarTablaMateriasPrimas(null);
		
	}

	

	private void cargarTablaMateriasPrimas (String tipo){
		CargadorTabla ct = new CargadorTabla();
		ct.generarContenidoMateriaPrimaEnStock(tipo, (DefaultTableModel) table.getModel());
		
	}

	public String getCodigo () {
		return codigo;
	}

	
}
