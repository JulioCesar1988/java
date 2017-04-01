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

import org.codehaus.groovy.ast.stmt.CaseStatement;

@SuppressWarnings("serial")
public class MateriaPrimaTipoCargar extends JDialog {
	private JPanel contentPane;
	private JTextField textFieldTipo;
	private JTextField textFieldCodificacion;
	private boolean flag;
	
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
	public MateriaPrimaTipoCargar() {
		setType(Type.POPUP);
		setTitle("Cargar tipo de materia prima");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textFieldTipo = new JTextField();
		textFieldTipo.setColumns(10);
		
		JLabel lblTipoDeMateria = new JLabel("Tipo de materia prima*");
		
		textFieldCodificacion = new JTextField();
		textFieldCodificacion.setColumns(10);
		
		JLabel lblCodificacin = new JLabel("Codificaci\u00F3n*");
		
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTipoDeMateria)
						.addComponent(lblCodificacin))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(textFieldCodificacion, Alignment.LEADING)
						.addComponent(textFieldTipo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
					.addContainerGap(225, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(347, Short.MAX_VALUE)
					.addComponent(btnAceptar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCerrar)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoDeMateria)
						.addComponent(textFieldTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldCodificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCodificacin))
					.addPreferredGap(ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCerrar)
						.addComponent(btnAceptar))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
	}

	
	
	private void guardarNuevoTipo() {
		MateriaPrimaTipoBean tipo = new MateriaPrimaTipoBean();
		tipo.setCodificacion(textFieldCodificacion.getText());
		tipo.setTipo(textFieldTipo.getText());
		MateriaPrimaTipoController TController = new MateriaPrimaTipoController();
		int aux = TController.insert(tipo);
		switch (aux) {
		case 1:
			javax.swing.JOptionPane.showMessageDialog(null, "Operación exitosa");
			break;
		default:
			javax.swing.JOptionPane.showMessageDialog(null, "Error al insertar el nuevo tipo, pruebe cambiando algún campo");
			break;
		}
	}
	
}
