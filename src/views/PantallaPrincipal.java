package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Toolkit;
import javax.swing.JToolBar;

public class PantallaPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal frame = new PantallaPrincipal();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.setExtendedState(Frame.MAXIMIZED_BOTH);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaPrincipal() {
		setBackground(Color.DARK_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Reportes\\logoHeader.png"));
		setTitle("Reporte 2016");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1845, 818);

		try {
			setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnSector = new JMenu("Sectores");
		mnSector.setForeground(Color.DARK_GRAY);
		mnSector.setFont(new Font("Dialog", Font.BOLD, 13));
		
		menuBar.add(mnSector);
		

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		final JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Reportes\\logoHeader.png"));
		lblNewLabel.setBounds(1198, 11, 170, 183);
		desktopPane.add(lblNewLabel);

		JLabel lblReportesProto = new JLabel("Reportes Proto ");
		lblReportesProto.setForeground(Color.DARK_GRAY);
		lblReportesProto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 38));
		lblReportesProto.setBounds(854, 80, 313, 114);
		desktopPane.add(lblReportesProto);

		JSeparator separator = new JSeparator();
		separator.setBounds(693, 205, 619, 2);
		desktopPane.add(separator);

		JMenuItem mntmProduccion = new JMenuItem("Producci\u00F3n");
		mnSector.add(mntmProduccion);
		mntmProduccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Produccion p = new Produccion();
				p.setVisible(true);
				p.setMaximizable(true);
				desktopPane.add(p);
			}
		});

		JMenuItem mntmCoordinacion = new JMenuItem("Coordinaci\u00F3n");
		mnSector.add(mntmCoordinacion);
		mntmCoordinacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coordinacion c = new Coordinacion();
				c.setVisible(true);
				c.setMaximizable(true);
				desktopPane.add(c);
			}
		});

		JMenuItem mntmDespacho = new JMenuItem("Despacho");
		mnSector.add(mntmDespacho);

		JMenuItem mntmWarehouse = new JMenuItem("Warehouse");
		mntmWarehouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Warehouse w = new Warehouse();
				w.setVisible(true);
				desktopPane.add(w);

			}
		});
		mnSector.add(mntmWarehouse);

		JMenuItem mntmControl2018 = new JMenuItem("Warehouse");
		mntmWarehouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Warehouse w = new Warehouse();
				w.setVisible(true);
				desktopPane.add(w);

			}
		});
		mnSector.add(mntmWarehouse);

		JMenuItem mntmControlDeProduccion = new JMenuItem("Control de Produccion");
		mntmControlDeProduccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControlDeProduccion cp = new ControlDeProduccion();
				cp.setVisible(true);
				desktopPane.add(cp);

			}
		});
		mnSector.add(mntmControlDeProduccion);

		JMenuItem mntmCargarListaCon = new JMenuItem("Cargar Lista Con Excel");
		mntmCargarListaCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// DATOS A OBTENER DEL EXCEL.
				// Obra
				// Paquete (descripcion) El número de paquete me lo genera el controlador cuando
				// lo doy de alta .
				// Edificio.
				// fecha de temrinacion + fechas de despacho
				// Sistema de diseño
				// PIEZAS : Cantidad , Elemento , Correlatividad , Descripcion , Descripcion
				// extra , Pintura ,Color ,largo ,Peso Unitario ,Codigo , Área ,Ubicación
				// SUBPIEZAs : Cantidad posicion correlatividad , Descripcion ,Material peso ,
				// largo/area , Peso unidad , peso total , observaciones.
				// Datos del usuario : legajo + Empresa

				CargadorExcel c = new CargadorExcel();
				c.setVisible(true);
				desktopPane.add(c);

			}
		});
		mnSector.add(mntmCargarListaCon);

		// 17/7/2018
		JMenuItem mntmControlproduccion = new JMenuItem("ControlProduccion2018");
		mntmControlproduccion.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				InformeControlProduccion inf = new InformeControlProduccion();
				inf.setVisible(true);
				desktopPane.add(inf);

			}
		});
		mnSector.add(mntmControlproduccion);

		mntmDespacho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Despacho despacho = new Despacho();
				despacho.setVisible(true);
				desktopPane.add(despacho);
			}
		});

	}
}
