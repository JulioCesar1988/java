package quality;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import tools.CargadorCombobox;
import reportes.ReporteGenerador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class ProtocoloCalidadReporte extends JInternalFrame {
	private JasperPrint reporte;
	private JRViewer viewer;
	private JPanel panel_1;
	private JLabel label;
	private JComboBox comboBoxObra;
	private JButton buttonVerNoProd;
	private JComboBox comboBoxLista;
	private JCheckBox chckbxTodasLasListas;
	JCheckBox chckbxMaterialesPreestablecidos;
	

	
	public ProtocoloCalidadReporte() {
		setBounds(100, 100, 850, 700);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(tabbedPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
						.addComponent(btnCerrar))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCerrar)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Reporte calidad", null, panel_1, null);
		
		label = new JLabel("Obra");
		
		comboBoxObra = new JComboBox();
		comboBoxObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarComboBoxPaqueteNumero();
			}
		});
		
		buttonVerNoProd = new JButton("Ver");
		buttonVerNoProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBoxObra.getSelectedItem()!=null && (comboBoxLista.getSelectedItem()!=null || chckbxTodasLasListas.isSelected())) {
					String obra = (String) comboBoxObra.getSelectedItem();
					StringTokenizer tk = new StringTokenizer(obra, " - ");
					int num_obra=Integer.parseInt(tk.nextToken());
					int num_paq = 0;
					if (chckbxTodasLasListas.isSelected()==false) {
						String paquete = (String) comboBoxLista.getSelectedItem();
						tk = new StringTokenizer(paquete, " - ");
						num_paq=Integer.parseInt(tk.nextToken());
					}	
					
					ReporteGenerador rp = new ReporteGenerador();
					if (chckbxMaterialesPreestablecidos.isSelected()==false) {
						
					
					try {
						rp.generarReporteProtocoloCalidad(num_obra, num_paq);
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}else{
						try {
							rp.generarReporteProtocoloCalidadMaterialesPreestablecidos(num_obra, num_paq);
						} catch (JRException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		
		comboBoxLista = new JComboBox();
		comboBoxLista.setEnabled(false);
		
		JLabel lblLista = new JLabel("N\u00BA lista");
		
		chckbxTodasLasListas = new JCheckBox("Todas las listas");
		chckbxTodasLasListas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxTodasLasListas.isSelected()) {
					comboBoxLista.setEnabled(false);
				} else {
					comboBoxLista.setEnabled(true);
				}
			}
		});
		chckbxTodasLasListas.setSelected(true);
		
		chckbxMaterialesPreestablecidos = new JCheckBox("Materiales preestablecidos");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(label)
						.addComponent(lblLista))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(comboBoxLista, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(comboBoxObra, 0, 364, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonVerNoProd)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(chckbxMaterialesPreestablecidos)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(chckbxTodasLasListas)
							.addGap(20)))
					.addGap(232))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxObra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label)
								.addComponent(buttonVerNoProd))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxLista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLista)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(52)
							.addComponent(chckbxTodasLasListas)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxMaterialesPreestablecidos)
					.addContainerGap(494, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		CargadorCombobox cc = new CargadorCombobox(); 
		DefaultComboBoxModel modelo = new DefaultComboBoxModel(cc.generarContenidoObra());
		comboBoxObra.setModel(modelo);

		

	}
	
	private void cargarComboBoxPaqueteNumero() {
		String obra = (String) comboBoxObra.getSelectedItem();
		StringTokenizer tk2 = new StringTokenizer(obra, " - ");
		int obra_num=Integer.parseInt(tk2.nextToken());
		CargadorCombobox cc = new CargadorCombobox();
		comboBoxLista.setModel(new DefaultComboBoxModel(cc.generarContenidoPaquetesConDescripcion(obra_num)));
	}
}
