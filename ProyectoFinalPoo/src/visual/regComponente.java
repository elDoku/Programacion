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
import logico.Ram;
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
	private JTextField txtModelo;
	private JTextField txtMarca;
	private JTextField txtTipoConexion;
	private JTextField txtProcesamiento;
	private JTextField txtMemoriaRam;
	private JTextField txtDiscoDuro;
	private JTextField textcodigo;
	private JTextField txtMicro;
	private JTextField txtTipo;
	private JTextField txtSerial;

	private JLabel lblCdigo;
	private JLabel lblPrecio;
	private JLabel lblTipo;
	private JLabel lblDiscoDuro;
	private JLabel lblRam;
	private JLabel lblMicro;
	private JLabel lblTipoConexion;
	private JLabel lblMarca;
	private JLabel lblModelo;
	private JLabel lblserial;
	private JLabel lblCantidad;
	private JLabel lblCantMemoria;
	private JLabel lblMarca2;
	private JLabel lblMemoriaRam;
	private JLabel lblProcesamiento;
	
	private JPanel pnlDiscoDuro;
	private JPanel pnlMicro;
	private JPanel pnlMotherBoard;
	private JPanel pnlRam;
	
	private JSpinner spnPrecio;
	private JSpinner spnCantidad;

	private JRadioButton rdbRam;
	private JRadioButton rdbMotherBoard;
	private JRadioButton rdbMicro;
	private JRadioButton rdbDiscoDuro;

	private JSpinner spnRadio;
	private JSpinner spnRadioExt;

	private JSpinner spnRadioExtCH;
	private JSpinner spnRdioIntCH;
	private JSpinner spnLongCH;
	private JSpinner spnLongitud;
	private JSpinner spnCapacidad;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		setBounds(100, 100, 416, 428);
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

			lblCdigo = new JLabel("Serial:");
			lblCdigo.setBounds(10, 24, 53, 14);
			panel.add(lblCdigo);

			textcodigo = new JTextField();
			textcodigo.setEditable(false);
			textcodigo.setBounds(10, 49, 364, 20);
			panel.add(textcodigo);
			textcodigo.setColumns(10);
			
			 lblPrecio = new JLabel("Precio:");
			lblPrecio.setBounds(10, 82, 72, 14);
			panel.add(lblPrecio);

			spnPrecio = new JSpinner();
			spnPrecio.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spnPrecio.setBounds(10, 107, 161, 20);
			panel.add(spnPrecio);

			lblCantidad = new JLabel("Cantidad:");
			lblCantidad.setBounds(203, 82, 72, 14);
			panel.add(lblCantidad);
			
			spnCantidad = new JSpinner();
			spnCantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnCantidad.setBounds(203, 107, 161, 20);
			panel.add(spnCantidad);

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

				pnlMicro.setVisible(false);
				pnlMotherBoard.setVisible(false);
				pnlDiscoDuro.setVisible(true);
				pnlRam.setVisible(false);
				updateCodigo();
			}
		});
		rdbDiscoDuro.setSelected(true);
		rdbDiscoDuro.setBounds(206, 25, 89, 23);
		panel.add(rdbDiscoDuro);

		rdbMicro = new JRadioButton("Micro");
		rdbMicro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbRam.setSelected(false);
				rdbMotherBoard.setSelected(false);
				rdbMicro.setSelected(true);
				rdbDiscoDuro.setSelected(false);

				pnlMicro.setVisible(true);
				pnlMotherBoard.setVisible(false);
				pnlDiscoDuro.setVisible(false);
				pnlRam.setVisible(false);
				updateCodigo();
			}
		});
		rdbMicro.setBounds(129, 25, 59, 23);
		panel.add(rdbMicro);

		rdbRam = new JRadioButton("Ram");
		rdbRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbRam.setSelected(true);
				rdbMotherBoard.setSelected(false);
				rdbMicro.setSelected(false);
				rdbDiscoDuro.setSelected(false);

				pnlMicro.setVisible(false);
				pnlMotherBoard.setVisible(false);
				pnlDiscoDuro.setVisible(false);
				pnlRam.setVisible(true);
				updateCodigo();
			}
		});
		rdbRam.setBounds(308, 25, 68, 23);
		panel.add(rdbRam);

		rdbMotherBoard = new JRadioButton("Mother Board");
		rdbMotherBoard.setBounds(8, 25, 112, 23);
		panel.add(rdbMotherBoard);
		rdbMotherBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbRam.setSelected(false);
				rdbMotherBoard.setSelected(true);
				rdbMicro.setSelected(false);
				rdbDiscoDuro.setSelected(false);

				pnlMicro.setVisible(false);
				pnlMotherBoard.setVisible(true);
				pnlDiscoDuro.setVisible(false);
				pnlRam.setVisible(false);
				updateCodigo();
			}
		});

		pnlDiscoDuro = new JPanel();
		pnlDiscoDuro.setVisible(false);
		pnlDiscoDuro.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDiscoDuro.setBounds(6, 230, 384, 98);
		contentPanel.add(pnlDiscoDuro);
		pnlDiscoDuro.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(12, 23, 116, 22);
		pnlDiscoDuro.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(140, 23, 105, 22);
		pnlDiscoDuro.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(256, 23, 116, 22);
		pnlDiscoDuro.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSerial = new JLabel("Serial:");
		lblSerial.setBounds(12, 0, 56, 16);
		pnlDiscoDuro.add(lblSerial);
		
		JLabel lblNewLabel = new JLabel("Marca:");
		lblNewLabel.setBounds(140, 0, 56, 16);
		pnlDiscoDuro.add(lblNewLabel);
		
		
		
		
		
		pnlMicro = new JPanel();
		pnlMicro.setVisible(false);
		pnlMicro.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlMicro.setBounds(6, 230, 384, 98);
		contentPanel.add(pnlMicro);
		pnlMicro.setLayout(null);

		
		
		pnlMotherBoard = new JPanel();
		pnlMotherBoard.setVisible(true);
		pnlMotherBoard.setLayout(null);
		pnlMotherBoard.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlMotherBoard.setBounds(6, 230, 384, 98);
		contentPanel.add(pnlMotherBoard);

		pnlRam = new JPanel();
		pnlRam.setVisible(false);
		pnlRam.setLayout(null);
		pnlRam.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlRam.setBounds(6, 230, 384, 98);
		contentPanel.add(pnlRam);

		

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
							float capacidad = Float.valueOf(spnLongCH.getValue().toString());
							String marca = textcodigo.getText();
							String tipoConexion = textcodigo.getText();
							String tipo = textcodigo.getText();
							String modelo = textcodigo.getText();

							aux = new DiscoDuro(tipo, precio, cantidad, serial, marca, modelo, capacidad, tipoConexion);
							Tienda.getInstance().insertarComponente(aux);
							JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion",
									JOptionPane.INFORMATION_MESSAGE);
							clean();
						}
						if (rdbMicro.isSelected()) {
							int radioE = Integer.valueOf(spnRadioExt.getValue().toString());
							float longitud = Float.valueOf(spnLongitud.getValue().toString());
							String marca = textcodigo.getText();
							String procesamiento = textcodigo.getText();
							String tipo = textcodigo.getText();
							String modelo = textcodigo.getText();
							String memoriaRam = textcodigo.getText();
							String tipoConexion = textcodigo.getText();

							aux = new Micro(tipo, precio, cantidad, serial, marca, modelo, tipoConexion, memoriaRam,
									procesamiento);
							Tienda.getInstance().insertarComponente(aux);
							JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion",
									JOptionPane.INFORMATION_MESSAGE);
							clean();
						}
						if (rdbMotherBoard.isSelected()) {
							String marca = textcodigo.getText();
							String tipoConexion = textcodigo.getText();
							String tipo = textcodigo.getText();
							String modelo = textcodigo.getText();
							String micro = textcodigo.getText();
							String discoDuro = textcodigo.getText();
							String ram = textcodigo.getText();

							int radioECH = Integer.valueOf(spnRadioExtCH.getValue().toString());
							float longitudCH = Float.valueOf(spnLongCH.getValue().toString());
							float radioICH = Float.valueOf(spnRdioIntCH.getValue().toString());
							aux = new MotherBoard(tipo, precio, cantidad, serial, marca, modelo, micro, discoDuro, ram);
							Tienda.getInstance().insertarComponente(aux);
							JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion",
									JOptionPane.INFORMATION_MESSAGE);
							clean();

						}
						if (rdbRam.isSelected()) {
							String marca = textcodigo.getText();
							String tipoConexion = textcodigo.getText();
							String tipo = textcodigo.getText();
							String modelo = textcodigo.getText();
							String tipo2 = textcodigo.getText();
							String marca2 = textcodigo.getText();
							float cantMemoria = Float.valueOf(spnLongCH.getValue().toString());
							float radioICH = Float.valueOf(spnRdioIntCH.getValue().toString());
							aux = new Ram(tipo, precio, cantidad, serial, marca, modelo, marca2, cantMemoria, tipo2);
							Tienda.getInstance().insertarComponente(aux);
							JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion",
									JOptionPane.INFORMATION_MESSAGE);
							clean();
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
