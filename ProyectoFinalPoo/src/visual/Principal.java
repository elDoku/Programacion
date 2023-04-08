package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private Dimension dim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height - 50);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnComponente = new JMenu("Componentes");
		menuBar.add(mnComponente);

		JMenuItem mntmFabricarComponente = new JMenuItem("Fabricar Componentes");
		mntmFabricarComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegComponente regC = new RegComponente();
				regC.setModal(true);
				regC.setVisible(true);
			}
		});
		mnComponente.add(mntmFabricarComponente);

		JMenuItem mntmListadoDeComponentes = new JMenuItem("Listado de Componentes");
		mntmListadoDeComponentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoComponente list = new ListadoComponente();
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnComponente.add(mntmListadoDeComponentes);

		JMenuItem mntmNewMenuItem = new JMenuItem("Agregar Combo");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AgregarCombo list = new AgregarCombo();
				list.setModal(true);
				list.setVisible(true);

			}
		});
		mnComponente.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listado de Combos");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListadoCombo list = new ListadoCombo();
				list.setModal(true);
				list.setVisible(true);
				
				
				
			}
		});
		mnComponente.add(mntmNewMenuItem_1);

		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);

		JMenuItem mntmListadoDeClientes = new JMenuItem("Listado de Clientes");
		mntmListadoDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoCliente list = new ListadoCliente();
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnClientes.add(mntmListadoDeClientes);

		JMenu mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);

		JMenuItem mntmListaFactura = new JMenuItem("Lista de Facturas");
		mntmListaFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoFactura list = new ListadoFactura();
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnVentas.add(mntmListaFactura);

		JMenuItem mntmFacturar = new JMenuItem("Facturar");
		mntmFacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facturar factura = new Facturar();
				factura.setModal(true);
				factura.setVisible(true);
			}
		});
		mnVentas.add(mntmFacturar);

		JMenu mnAdmin = new JMenu("Administracion");
		menuBar.add(mnAdmin);

		JMenuItem mntmReporte = new JMenuItem("Reporte");
		mntmReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ReporteDinero reporteD = new ReporteDinero();
//				reporteD.setModal(true);
//				reporteD.setVisible(true);
			}
		});
		mnAdmin.add(mntmReporte);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
