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

	private JSpinner spnGMotherBoard;
	private JSpinner spnGMicro;
	private JSpinner spnGRam;
	private JSpinner spnGDiscoDuro;
	private JSpinner spnTotal;
	private JSpinner spnVMicro;
	private JSpinner spnVRam;
	private JSpinner spnVDiscoDuro;
	private JSpinner spnVMotherBoard;

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

		JLabel lblGMotherBoard = new JLabel("Mother board's:");
		lblGMotherBoard.setBounds(10, 24, 97, 14);
		panel.add(lblGMotherBoard);

		spnGMotherBoard = new JSpinner();
		spnGMotherBoard.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		spnGMotherBoard.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnGMotherBoard.setEnabled(false);

		//System.out.println(Tienda.getInstance().gananciaQEsferico());
		// valor seteado
		spnGMotherBoard.setBounds(119, 19, 123, 23);
		panel.add(spnGMotherBoard);
	
		
		
		JLabel lblGMicro = new JLabel("Micro's:");
		lblGMicro.setBounds(10, 60, 97, 14);
		panel.add(lblGMicro);
		spnGMicro = new JSpinner();
		spnGMicro.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		spnGMicro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnGMicro.setEnabled(false);
		spnGMicro.setBounds(119, 55, 123, 23);
		panel.add(spnGMicro);

		JLabel lblGRam = new JLabel("Ram's:");
		lblGRam.setBounds(10, 95, 123, 14);
		panel.add(lblGRam);
		spnGRam = new JSpinner();
		spnGRam.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		spnGRam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnGRam.setEnabled(false);
		spnGRam.setBounds(119, 91, 123, 23);
		panel.add(spnGRam);

		JLabel lblTotal = new JLabel("Total Ganacias:");
		lblTotal.setBounds(10, 180, 97, 14);
		panel.add(lblTotal);

		spnTotal = new JSpinner();
		spnTotal.setEnabled(false);
		spnTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnTotal.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		// con el setvalue es que coloco el valor de la funcion dentro del spinner

		spnTotal.setBounds(119, 175, 123, 23);
		panel.add(spnTotal);
		
		JLabel lblGDiscoDuro = new JLabel("Discos Duros:");
		lblGDiscoDuro.setBounds(10, 134, 95, 16);
		panel.add(lblGDiscoDuro);
		
		JSpinner spnGDiscoDuro = new JSpinner();
		spnGDiscoDuro.setEnabled(false);
		spnGDiscoDuro.setBounds(119, 127, 123, 23);
		panel.add(spnGDiscoDuro);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 36, 274, 207);
		contentPanel.add(panel_1);

		JLabel lblVMotherBoard = new JLabel("Mother board's:");
		lblVMotherBoard.setBounds(10, 16, 97, 14);
		panel_1.add(lblVMotherBoard);

		spnVMotherBoard = new JSpinner();
		spnVMotherBoard.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spnVMotherBoard.setEnabled(false);
		spnVMotherBoard.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnVMotherBoard.setBounds(139, 12, 123, 23);
		panel_1.add(spnVMotherBoard);

		JLabel lblVMicro = new JLabel("Micro's:");
		lblVMicro.setBounds(10, 58, 97, 14);
		panel_1.add(lblVMicro);

		spnVMicro = new JSpinner();
		spnVMicro.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spnVMicro.setEnabled(false);
		spnVMicro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnVMicro.setBounds(139, 53, 123, 23);
		panel_1.add(spnVMicro);

		JLabel lblVRam = new JLabel("Ram's:");
		lblVRam.setBounds(10, 85, 123, 37);
		panel_1.add(lblVRam);

		spnVRam = new JSpinner();
		spnVRam.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spnVRam.setEnabled(false);
		spnVRam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnVRam.setBounds(139, 91, 123, 23);
		panel_1.add(spnVRam);
		
		JLabel lblVDiscoDuro = new JLabel("Discos Duros:");
		lblVDiscoDuro.setBounds(10, 135, 107, 16);
		panel_1.add(lblVDiscoDuro);
		
		JSpinner spnVDiscosDuros = new JSpinner();
		spnVDiscosDuros.setEnabled(false);
		spnVDiscosDuros.setBounds(139, 132, 123, 23);
		panel_1.add(spnVDiscosDuros);

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

		spnGMotherBoard.setValue(Tienda.getInstance().gananciaMotherBoard());
		spnGMicro.setValue(Tienda.getInstance().gananciaMicro());
		spnGRam.setValue(Tienda.getInstance().gananciaRam());
		spnGDiscoDuro.setValue(Tienda.getInstance().gananciaDiscoDuro());
		spnTotal.setValue(Tienda.getInstance().totalGanancia());

		// cantidad de ventas
		spnVMotherBoard.setValue(Tienda.getInstance().ventaMotherBoard());
		spnVMicro.setValue(Tienda.getInstance().ventaMicro());
		spnVRam.setValue(Tienda.getInstance().ventaRam());
		spnVDiscoDuro.setValue(Tienda.getInstance().ventaDiscoDuro());
	}
}
