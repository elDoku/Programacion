package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Tienda;
import sun.security.jca.GetInstance;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner.DefaultEditor;
import java.awt.Font;
import java.awt.Color;

public class Reporte extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JSpinner spnEGanancia;
	private JSpinner spnCGanancia;
	private JSpinner spnCHGanancia;
	private JSpinner spnTotal;
	private JSpinner spnQCVenta;
	private JSpinner spnQCHVenta;
	private JSpinner spnQEVenta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Facturar dialog = new Facturar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Reporte() {

		setTitle("Reporte");
		setBounds(100, 100, 595, 319);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(304, 36, 261, 207);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblQEGanancia = new JLabel("Queso Esf\u00E9rico:");
		lblQEGanancia.setBounds(10, 11, 97, 14);
		panel.add(lblQEGanancia);

		spnEGanancia = new JSpinner();
		spnEGanancia.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		spnEGanancia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnEGanancia.setEnabled(false);

		//System.out.println(Tienda.getInstance().gananciaQEsferico());
		// valor seteado
		spnEGanancia.setBounds(119, 7, 123, 23);
		panel.add(spnEGanancia);
	
		
		
		JLabel lblQCGanancia = new JLabel("Queso Cil\u00EDndrico:");
		lblQCGanancia.setBounds(10, 59, 97, 14);
		panel.add(lblQCGanancia);
		spnCGanancia = new JSpinner();
		spnCGanancia.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		spnCGanancia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnCGanancia.setEnabled(false);
		spnCGanancia.setBounds(119, 55, 123, 23);
		panel.add(spnCGanancia);

		JLabel lblQCHGanancia = new JLabel("Q.Cil\u00EDndrico H:");
		lblQCHGanancia.setBounds(10, 111, 123, 14);
		panel.add(lblQCHGanancia);
		spnCHGanancia = new JSpinner();
		spnCHGanancia.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		spnCHGanancia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnCHGanancia.setEnabled(false);
		spnCHGanancia.setBounds(119, 107, 123, 23);
		panel.add(spnCHGanancia);

		JLabel lblTotal = new JLabel("Total Ganacias:");
		lblTotal.setBounds(10, 157, 97, 14);
		panel.add(lblTotal);

		spnTotal = new JSpinner();
		spnTotal.setEnabled(false);
		spnTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnTotal.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		// con el setvalue es que coloco el valor de la funcion dentro del spinner

		spnTotal.setBounds(119, 153, 123, 23);
		panel.add(spnTotal);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 36, 274, 207);
		contentPanel.add(panel_1);

		JLabel lblQEVenta = new JLabel("Queso Esf\u00E9rico:");
		lblQEVenta.setBounds(10, 16, 97, 14);
		panel_1.add(lblQEVenta);

		spnQEVenta = new JSpinner();
		spnQEVenta.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spnQEVenta.setEnabled(false);
		spnQEVenta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnQEVenta.setBounds(139, 12, 123, 23);
		panel_1.add(spnQEVenta);

		JLabel lblQCVenta = new JLabel("Queso Cil\u00EDndrico:");
		lblQCVenta.setBounds(10, 81, 97, 14);
		panel_1.add(lblQCVenta);

		spnQCVenta = new JSpinner();
		spnQCVenta.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spnQCVenta.setEnabled(false);
		spnQCVenta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnQCVenta.setBounds(139, 77, 123, 23);
		panel_1.add(spnQCVenta);

		JLabel lblQCHVenta = new JLabel("Q.Cil\u00EDndrico H:");
		lblQCHVenta.setBounds(12, 150, 123, 14);
		panel_1.add(lblQCHVenta);

		spnQCHVenta = new JSpinner();
		spnQCHVenta.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spnQCHVenta.setEnabled(false);
		spnQCHVenta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnQCHVenta.setBounds(139, 146, 123, 23);
		panel_1.add(spnQCHVenta);

		JLabel lblVentas = new JLabel("Ventas:");
		lblVentas.setBounds(12, 7, 97, 16);
		contentPanel.add(lblVentas);

		JLabel lblGanancias = new JLabel("Ganancias:");
		lblGanancias.setBounds(304, 7, 97, 16);
		contentPanel.add(lblGanancias);

		recarga();

	}

	private void recarga() {
		// ganancias

		spnEGanancia.setValue(Tienda.getInstance().gananciaQEsferico());
		spnCGanancia.setValue(Tienda.getInstance().gananciaQCilindrico());
		spnCHGanancia.setValue(Tienda.getInstance().gananciaQCilindricoH());

		spnTotal.setValue(Tienda.getInstance().totalGanancia());

		// cantidad de ventas
		spnQEVenta.setValue(Tienda.getInstance().ventaQEsferico());
		spnQCVenta.setValue(Tienda.getInstance().ventaQCilindrico());
		spnQCHVenta.setValue(Tienda.getInstance().ventaQCilindricoH());
	}
}
