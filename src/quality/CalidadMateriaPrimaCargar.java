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
public class CalidadMateriaPrimaCargar extends JDialog {
	private JPanel contentPane;
	private JTextField textFieldCalidad;
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
	public CalidadMateriaPrimaCargar() {
		setType(Type.POPUP);
		setTitle("Cargar calidad");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textFieldCalidad = new JTextField();
		textFieldCalidad.setColumns(10);
		
		JLabel lblTipoDeMateria = new JLabel("Calidad de materia prima*");
		
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
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(lblTipoDeMateria)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFieldCalidad, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(174, Short.MAX_VALUE))
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
						.addComponent(textFieldCalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCerrar)
						.addComponent(btnAceptar))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
	}

	
	
	private void guardarNuevoTipo() {
		CalidadMateriaPrimaBean calidad = new CalidadMateriaPrimaBean();
		calidad.setNombre(textFieldCalidad.getText());
		CalidadMateriaPrimaController mController = new CalidadMateriaPrimaController();
		int aux = mController.insert(calidad);
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
