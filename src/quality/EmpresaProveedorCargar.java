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
import models.CalidadMateriaPrimaBean;
import models.EmpresaProveedorBean;
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

import org.codehaus.groovy.ast.stmt.CaseStatement;

@SuppressWarnings("serial")
public class EmpresaProveedorCargar extends JDialog {
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private boolean flag;
	private JTextField textFieldRazonsocial;
	private JTextField textFieldTelefono;
	private JTextField textFieldLocalidad;
	private JTextField textFieldDirección;
	
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
	 * @param aux 
	 */
	public EmpresaProveedorCargar() {
		setType(Type.POPUP);
		setTitle("Cargar empresa proveedor");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		
		JLabel lblNombreDeProveedor = new JLabel("Nombre de proveedor*");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarNuevoTipo();
			}

			
		});
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		textFieldRazonsocial = new JTextField();
		textFieldRazonsocial.setColumns(10);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		
		textFieldLocalidad = new JTextField();
		textFieldLocalidad.setColumns(10);
		
		textFieldDirección = new JTextField();
		textFieldDirección.setColumns(10);
		
		JLabel lblRaznSocial = new JLabel("Raz\u00F3n social");
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		
		JLabel lblLocalidad = new JLabel("Localidad");
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(347, Short.MAX_VALUE)
					.addComponent(btnAceptar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCerrar)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNombreDeProveedor)
						.addComponent(lblRaznSocial)
						.addComponent(lblTelfono)
						.addComponent(lblLocalidad)
						.addComponent(lblDireccin))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textFieldNombre, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
						.addComponent(textFieldRazonsocial)
						.addComponent(textFieldTelefono)
						.addComponent(textFieldLocalidad)
						.addComponent(textFieldDirección))
					.addContainerGap(155, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreDeProveedor)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldRazonsocial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRaznSocial))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelfono))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldLocalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLocalidad))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldDirección, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDireccin))
					.addPreferredGap(ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCerrar)
						.addComponent(btnAceptar))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
	}

	
	
	private void guardarNuevoTipo() {
		EmpresaProveedorBean proveedor = new EmpresaProveedorBean();
		proveedor.setNombre(textFieldNombre.getText());
		proveedor.setRazonSocial(textFieldRazonsocial.getText());
		proveedor.setTelefono(textFieldTelefono.getText());
		proveedor.setLocalidad(textFieldLocalidad.getText());
		proveedor.setDireccion(textFieldDirección.getText());
		EmpresaProveedorController eController = new EmpresaProveedorController();
		int aux = eController.insert(proveedor);
		switch (aux) {
		case 1:
			javax.swing.JOptionPane.showMessageDialog(null, "Operación exitosa");
			break;
		default:
			javax.swing.JOptionPane.showMessageDialog(null, "Error al insertar el nuevo proveedor, pruebe cambiando algún campo");
			break;
		}
	}
}
