package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Componente;
import logico.DiscoDuro;
import logico.Micro;
import logico.MotherBoard;
import logico.Tienda;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class regComponente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField modelo;
	private JTextField marca;
	private JTextField tipoConexion;
	private JTextField procesamiento;
	private JTextField MemoriaRam;
	private JTextField DiscoDuro;
	private JTextField textcodigo;
	private JTextField micro;
	private JTextField tipo;
	private JSpinner spnPrecio;
	private JSpinner spnCantidad;
	private JRadioButton rdbRam;
	private JRadioButton rdbMotherBoard;
	private JRadioButton rdbMicro;
	private JRadioButton rdbDiscoDuro;
	private JSpinner spnRadio;
	private JSpinner spnRadioExt;
	private JPanel pnlDiscoDuro;
	private JPanel pnlMicro;
	private JPanel pnlMotherBoard;
	private JPanel pnlRam;
	private JSpinner spnRadioExtCH;
	private JSpinner spnRdioIntCH;
	private JSpinner spnLongCH;
	private JSpinner spnLongitud;
	private JSpinner spnCapacidad;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			regComponente dialog = new regComponente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public regComponente() {
		setBounds(100, 100, 415, 382);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(5, 5, 384, 152);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n General:",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel);
			panel.setLayout(null);

			JLabel lblCdigo = new JLabel("Serial:");
			lblCdigo.setBounds(10, 24, 53, 14);
			panel.add(lblCdigo);

			textcodigo = new JTextField();
			textcodigo.setEditable(false);
			textcodigo.setBounds(10, 49, 364, 20);
			panel.add(textcodigo);
			textcodigo.setColumns(10);

			JLabel lblPrecio = new JLabel("Precio:");
			lblPrecio.setBounds(10, 82, 72, 14);
			panel.add(lblPrecio);

			spnPrecio = new JSpinner();
			spnPrecio.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spnPrecio.setBounds(10, 107, 161, 20);
			panel.add(spnPrecio);
			

			JLabel lblCantidad = new JLabel("Cantidad:");
			lblCantidad.setBounds(10, 82, 72, 14);
			panel.add(lblCantidad);

			spnCantidad.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spnCantidad.setBounds(10, 107, 161, 39);
			panel.add(spnPrecio);

		}

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo de Queso:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(5, 161, 384, 66);
		contentPanel.add(panel);
		panel.setLayout(null);

		rdbDiscoDuro = new JRadioButton("Disco Duro");
		rdbDiscoDuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbRam.setSelected(false);
				rdbMotherBoard.setSelected(false);
				rdbMicro.setSelected(false);
				rdbDiscoDuro.setSelected(true);
				updateCodigo();
			}
		});
		rdbDiscoDuro.setSelected(true);
		rdbDiscoDuro.setBounds(7, 25, 118, 23);
		panel.add(rdbDiscoDuro);

		rdbMicro = new JRadioButton("Micro");
		rdbMicro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbRam.setSelected(false);
				rdbMotherBoard.setSelected(false);
				rdbMicro.setSelected(true);
				rdbDiscoDuro.setSelected(false);
				updateCodigo();
			}
		});
		rdbMicro.setBounds(132, 25, 109, 23);
		panel.add(rdbMicro);

		rdbMotherBoard = new JRadioButton("Mother Board");
		rdbMotherBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbRam.setSelected(false);
				rdbMotherBoard.setSelected(true);
				rdbMicro.setSelected(false);
				rdbDiscoDuro.setSelected(false);
				updateCodigo();
			}
		});
		rdbMotherBoard.setBounds(248, 25, 127, 23);
		panel.add(rdbMotherBoard);

		rdbRam = new JRadioButton("Ram");
		rdbRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbRam.setSelected(true);
				rdbMotherBoard.setSelected(false);
				rdbMicro.setSelected(false);
				rdbDiscoDuro.setSelected(false);
				updateCodigo();
			}
		});
		rdbRam.setBounds(248, 25, 127, 23);
		panel.add(rdbRam);

		pnlDiscoDuro = new JPanel();
		pnlDiscoDuro.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDiscoDuro.setBounds(5, 229, 384, 66);
		pnlDiscoDuro.add(pnlDiscoDuro);
		pnlDiscoDuro.setLayout(null);

		JLabel lblRedio = new JLabel("Radio:");
		lblRedio.setBounds(10, 11, 46, 14);
		pnlDiscoDuro.add(lblRedio);

		spnRadio = new JSpinner();
		spnRadio.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnRadio.setBounds(10, 35, 161, 20);
		pnlDiscoDuro.add(spnRadio);

		pnlMicro.setVisible(false);
		pnlMicro.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlMicro.setBounds(5, 229, 384, 66);
		contentPanel.add(pnlMicro);
		pnlMicro.setLayout(null);

		JLabel lblNewLabel = new JLabel("Radio Exterior:");
		lblNewLabel.setBounds(10, 11, 90, 14);
		pnlMicro.add(lblNewLabel);

		spnRadioExt = new JSpinner();
		spnRadioExt.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnRadioExt.setBounds(10, 35, 161, 20);
		pnlMicro.add(spnRadioExt);

		JLabel lblNewLabel_1 = new JLabel("Longitud:");
		lblNewLabel_1.setBounds(213, 11, 110, 14);
		pnlMicro.add(lblNewLabel_1);

		spnLongitud = new JSpinner();
		spnLongitud.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
		spnLongitud.setBounds(213, 35, 161, 20);
		pnlMicro.add(spnLongitud);

		pnlMotherBoard.setVisible(false);
		pnlMotherBoard.setLayout(null);
		pnlMotherBoard.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlMotherBoard.setBounds(5, 229, 384, 66);
		contentPanel.add(pnlMotherBoard);

		JLabel label = new JLabel("Radio Exterior:");
		label.setBounds(10, 11, 90, 14);
		pnlMotherBoard.add(label);

		spnRadioExtCH = new JSpinner();
		spnRadioExtCH.setModel(new SpinnerNumberModel(new Integer(2), new Integer(1), null, new Integer(1)));
		spnRadioExtCH.setBounds(10, 35, 100, 20);
		pnlMotherBoard.add(spnRadioExtCH);

		JLabel label_1 = new JLabel("Longitud:");
		label_1.setBounds(150, 11, 110, 14);
		pnlMotherBoard.add(label_1);

		spnLongCH.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
		spnLongCH.setBounds(150, 35, 100, 20);
		pnlMotherBoard.add(spnLongCH);

		JLabel lblRadioInterior = new JLabel("Radio Interior:");
		lblRadioInterior.setBounds(275, 11, 90, 14);
		pnlMotherBoard.add(lblRadioInterior);

		spnRdioIntCH = new JSpinner();
		spnRdioIntCH.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
		spnRdioIntCH.setBounds(275, 35, 100, 20);
		pnlMotherBoard.add(spnRdioIntCH);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Componente aux = null;
						String serial = textcodigo.getText();
						float precio = Float.valueOf(spnPrecio.getValue().toString());
						int cantidad = Integer.valueOf(spnCantidad.getValue().toString());
						if (rdbDiscoDuro.isSelected()) {
							int radio = Integer.valueOf(spnRadio.getValue().toString());
							aux = new DiscoDuro(marca, modelo, capacidad, tipoConexion);
							Tienda.getInstance().insertarComponente(aux);
							JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion",
									JOptionPane.INFORMATION_MESSAGE);
							clean();
						}
						if (rdbMicro.isSelected()) {
							int radioE = Integer.valueOf(spnRadioExt.getValue().toString());
							float longitud = Float.valueOf(spnLongitud.getValue().toString());
							aux = new Micro(tipo, precio, cantidad, serial);
							Tienda.getInstance().insertarComponente(aux);
							JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion",
									JOptionPane.INFORMATION_MESSAGE);
							clean();
						}
						if (rdbMotherBoard.isSelected()) {
							int radioECH = Integer.valueOf(spnRadioExtCH.getValue().toString());
							float longitudCH = Float.valueOf(spnLongCH.getValue().toString());
							float radioICH = Float.valueOf(spnRdioIntCH.getValue().toString());
							if (radioICH >= radioECH) {
								JOptionPane.showMessageDialog(null,
										"Operacion Negada, el radio interior no puede ser mayor o igual al exterior",
										"Informacion", JOptionPane.INFORMATION_MESSAGE);

							}
						}
						if (rdbRam.isSelected()) {
							int radioECH = Integer.valueOf(spnRadioExtCH.getValue().toString());
							float longitudCH = Float.valueOf(spnLongCH.getValue().toString());
							float radioICH = Float.valueOf(spnRdioIntCH.getValue().toString());
							if (radioICH >= radioECH) {
								JOptionPane.showMessageDialog(null,
										"Operacion Negada, el radio interior no puede ser mayor o igual al exterior",
										"Informacion", JOptionPane.INFORMATION_MESSAGE);

							}
						}
					}

				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");

				buttonPane.add(cancelButton);
			}
		}
		updateCodigo();
	}

	private void updateCodigo() {
		String pre = "";
		if (rdbDiscoDuro.isSelected()) {
			pre = "QE";
		}
		if (rdbMicro.isSelected()) {
			pre = "QCH";
		}
		if (rdbMotherBoard.isSelected()) {
			pre = "QC";
		}
		if (rdbRam.isSelected()) {
			pre = "QC";
		}
		textcodigo.setText(pre + "-" + Tienda.codigo);

	}

	private void clean() {
		pnlDiscoDuro.setVisible(true);
		pnlMicro.setVisible(false);
		pnlMotherBoard.setVisible(false);
		pnlRam.setVisible(false);
		
		rdbDiscoDuro.setSelected(true);
		rdbMicro.setSelected(false);
		rdbMotherBoard.setSelected(false);
		rdbRam.setSelected(false);
		
		updateCodigo();
		spnCantidad.setValue(new Integer(0));
		spnPrecio.setValue(new Float(1));
		spnRadio.setValue(new Integer(1));

		spnRadioExt.setValue(new Integer(1));
		spnLongitud.setValue(new Float(1));

		spnRadioExtCH.setValue(new Integer(2));
		spnLongCH.setValue(new Integer(1));
		spnRdioIntCH.setValue(new Integer(1));

	}
}
