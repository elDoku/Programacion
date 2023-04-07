package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import javafx.scene.control.Spinner;
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
	private JTextField txtCapacidad;
	private JTextField textcodigo;
	private JTextField txtTipo;
	private JTextField txtTipoRam;
	private JTextField txtSerial;
	private JTextField txtRam;
	private JTextField txtMicro;

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
	private JLabel lblMarcaRam;
	private JLabel lblMemoriaRam;
	private JLabel lblProcesamiento;
	private JLabel lblSerial;
	private JLabel lblCapacidad;

	private JPanel pnlDiscoDuro;
	private JPanel pnlMicro;
	private JPanel pnlMotherBoard;
	private JPanel pnlRam;

	private JSpinner spnPrecio;
	private JSpinner spnCantidad;
	private JSpinner spnCantMemoria;

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
	private JLabel lblNewLabel;

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
		setBounds(100, 100, 416, 467);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		// ---------------------------------------

		pnlMicro = new JPanel();
		pnlMicro.setVisible(false);

		// --------------------------------------------

		pnlMotherBoard = new JPanel();
		pnlMotherBoard.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlMotherBoard.setBounds(6, 230, 384, 137);
		pnlMotherBoard.setVisible(true);

		// ---------------------------------------

		pnlRam = new JPanel();
		pnlRam.setVisible(false);

		pnlRam.setLayout(null);
		pnlRam.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlRam.setBounds(6, 230, 384, 137);
		contentPanel.add(pnlRam);

		txtMarca = new JTextField();
		txtMarca.setBounds(12, 43, 105, 22);
		pnlRam.add(txtMarca);
		txtMarca.setColumns(10);

		txtModelo = new JTextField();
		txtModelo.setBounds(140, 43, 90, 22);
		pnlRam.add(txtModelo);
		txtModelo.setColumns(10);

		lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(12, 14, 105, 16);
		pnlRam.add(lblMarca);

		lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(140, 14, 56, 16);
		pnlRam.add(lblModelo);

		spnCantMemoria = new JSpinner();
		spnCantMemoria.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
		spnCantMemoria.setBounds(12, 102, 105, 22);
		pnlRam.add(spnCantMemoria);

		txtTipo = new JTextField();
		txtTipo.setBounds(140, 102, 90, 22);
		pnlRam.add(txtTipo);
		txtTipo.setColumns(10);

		lblDiscoDuro = new JLabel("#Memoria (Mb):");
		lblDiscoDuro.setBounds(12, 78, 105, 16);
		pnlRam.add(lblDiscoDuro);

		lblTipo = new JLabel("Tipo de Ram:");
		lblTipo.setBounds(140, 78, 90, 16);
		pnlRam.add(lblTipo);

		// -----------------------------------------------

		pnlDiscoDuro = new JPanel();
		pnlDiscoDuro.setBounds(6, 230, 384, 137);
		contentPanel.add(pnlDiscoDuro);
		pnlDiscoDuro.setVisible(false);
		pnlDiscoDuro.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDiscoDuro.setLayout(null);

		txtMarca = new JTextField();
		txtMarca.setBounds(12, 35, 105, 22);
		pnlDiscoDuro.add(txtMarca);
		txtMarca.setColumns(10);

		txtModelo = new JTextField();
		txtModelo.setBounds(140, 35, 90, 22);
		pnlDiscoDuro.add(txtModelo);
		txtModelo.setColumns(10);

		lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(12, 13, 56, 16);
		pnlDiscoDuro.add(lblMarca);

		lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(140, 13, 56, 16);
		pnlDiscoDuro.add(lblModelo);

		spnCapacidad = new JSpinner();
		pnlDiscoDuro.add(spnCapacidad);

		txtCapacidad = new JTextField();
		txtCapacidad.setBounds(257, 35, 105, 22);
		pnlDiscoDuro.add(txtCapacidad);
		txtCapacidad.setColumns(10);

		txtTipoConexion = new JTextField();
		txtTipoConexion.setBounds(12, 100, 112, 22);
		pnlDiscoDuro.add(txtTipoConexion);
		txtTipoConexion.setColumns(10);

		lblCapacidad = new JLabel("Capacidad:");
		lblCapacidad.setBounds(257, 13, 90, 16);
		pnlDiscoDuro.add(lblCapacidad);

		lblTipoConexion = new JLabel("Tipo de Conexion:");
		lblTipoConexion.setBounds(12, 71, 112, 16);
		pnlDiscoDuro.add(lblTipoConexion);
		contentPanel.add(pnlMotherBoard);
		pnlMotherBoard.setLayout(null);

		txtMarca = new JTextField();
		txtMarca.setBounds(12, 38, 105, 22);
		pnlMotherBoard.add(txtMarca);
		txtMarca.setColumns(10);

		txtModelo = new JTextField();
		txtModelo.setBounds(139, 38, 90, 22);
		pnlMotherBoard.add(txtModelo);
		txtModelo.setColumns(10);

		lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(12, 9, 56, 16);
		pnlMotherBoard.add(lblMarca);

		lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(140, 9, 56, 16);
		pnlMotherBoard.add(lblModelo);

		txtDiscoDuro = new JTextField();
		txtDiscoDuro.setBounds(12, 102, 105, 22);
		pnlMotherBoard.add(txtDiscoDuro);
		txtDiscoDuro.setColumns(10);

		txtRam = new JTextField();
		txtRam.setBounds(139, 102, 90, 22);
		pnlMotherBoard.add(txtRam);
		txtRam.setColumns(10);

		txtMicro = new JTextField();
		txtMicro.setBounds(254, 38, 105, 22);
		pnlMotherBoard.add(txtMicro);
		txtMicro.setColumns(10);

		lblMicro = new JLabel("Micro:");
		lblMicro.setBounds(254, 9, 56, 16);
		pnlMotherBoard.add(lblMicro);

		lblDiscoDuro = new JLabel("Disco Duro:");
		lblDiscoDuro.setBounds(12, 73, 90, 16);
		pnlMotherBoard.add(lblDiscoDuro);

		lblRam = new JLabel("Ram:");
		lblRam.setBounds(139, 73, 56, 16);
		pnlMotherBoard.add(lblRam);

		txtTipoConexion = new JTextField();
		txtTipoConexion.setBounds(254, 102, 105, 22);
		pnlMotherBoard.add(txtTipoConexion);
		txtTipoConexion.setColumns(10);

		lblTipoConexion = new JLabel("Tipo de Conector:");
		lblTipoConexion.setBounds(254, 73, 105, 16);
		pnlMotherBoard.add(lblTipoConexion);
		pnlMicro.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlMicro.setBounds(6, 230, 384, 137);
		contentPanel.add(pnlMicro);
		pnlMicro.setLayout(null);

		txtMarca = new JTextField();
		txtMarca.setBounds(12, 40, 105, 22);
		pnlMicro.add(txtMarca);
		txtMarca.setColumns(10);

		txtModelo = new JTextField();
		txtModelo.setBounds(140, 40, 90, 22);
		pnlMicro.add(txtModelo);
		txtModelo.setColumns(10);

		lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(12, 13, 56, 16);
		pnlMicro.add(lblMarca);

		lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(140, 13, 56, 16);
		pnlMicro.add(lblModelo);

		txtTipoConexion = new JTextField();
		txtTipoConexion.setBounds(254, 40, 105, 22);
		pnlMicro.add(txtTipoConexion);
		txtTipoConexion.setColumns(10);

		txtMemoriaRam = new JTextField();
		txtMemoriaRam.setBounds(12, 102, 105, 22);
		pnlMicro.add(txtMemoriaRam);
		txtMemoriaRam.setColumns(10);

		txtProcesamiento = new JTextField();
		txtProcesamiento.setBounds(140, 102, 90, 22);
		pnlMicro.add(txtProcesamiento);
		txtProcesamiento.setColumns(10);

		lblTipoConexion = new JLabel("Tipo de Conexion:");
		lblTipoConexion.setBounds(254, 13, 105, 16);
		pnlMicro.add(lblTipoConexion);

		lblMemoriaRam = new JLabel("MemoriaRam:");
		lblMemoriaRam.setBounds(12, 73, 90, 16);
		pnlMicro.add(lblMemoriaRam);

		lblProcesamiento = new JLabel("Procesamiento:");
		lblProcesamiento.setBounds(140, 73, 90, 16);
		pnlMicro.add(lblProcesamiento);
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo de Queso:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(5, 161, 384, 66);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

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

		rdbDiscoDuro.setBounds(206, 25, 89, 23);
		panel_1.add(rdbDiscoDuro);

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
		panel_1.add(rdbMicro);

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
		panel_1.add(rdbRam);

		rdbMotherBoard = new JRadioButton("MotherBoard");
		rdbMotherBoard.setBounds(8, 25, 112, 23);
		panel_1.add(rdbMotherBoard);
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
		rdbMotherBoard.setSelected(true);
		rdbRam.setBounds(308, 25, 68, 23);
		panel_1.add(rdbRam);
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
							String marca = txtMarca.getText();
							String tipoConexion = txtTipoConexion.getText();
							String tipo = txtTipo.getText();
							String modelo = txtModelo.getText();

							aux = new DiscoDuro(tipo, precio, cantidad, serial, marca, modelo, capacidad, tipoConexion);
							Tienda.getInstance().insertarComponente(aux);
							JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion",
									JOptionPane.INFORMATION_MESSAGE);
							clean();
						}
						if (rdbMicro.isSelected()) {
							String marca = txtMarca.getText();
							String procesamiento = txtProcesamiento.getText();
							String tipo = txtTipo.getText();
							String modelo = txtModelo.getText();
							String memoriaRam = txtMemoriaRam.getText();
							String tipoConexion = txtTipoConexion.getText();

							aux = new Micro(tipo, precio, cantidad, serial, marca, modelo, tipoConexion, memoriaRam,
									procesamiento);
							Tienda.getInstance().insertarComponente(aux);
							JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion",
									JOptionPane.INFORMATION_MESSAGE);
							clean();
						}
						if (rdbMotherBoard.isSelected()) {
							String marca = txtMarca.getText();
							String tipoConexion = txtTipoConexion.getText();
							String tipo = txtTipo.getText();
							String modelo = txtModelo.getText();
							String micro = txtMicro.getText();
							String discoDuro = txtDiscoDuro.getText();
							String ram = txtRam.getText();
							

							aux = new MotherBoard(tipo, precio, cantidad, serial, marca, modelo, micro, discoDuro, ram,
									tipoConexion);
							Tienda.getInstance().insertarComponente(aux);
							JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion",
									JOptionPane.INFORMATION_MESSAGE);
							clean();

						}
						if (rdbRam.isSelected()) {
							String marca = txtMarca.getText();
							String tipoConexion = txtTipoConexion.getText();
							String tipo = txtTipo.getText();
							String modelo = txtModelo.getText();
							float cantMemoria = Float.valueOf(spnCantMemoria.getValue().toString());
							aux = new Ram(tipo, precio, cantidad, serial, marca, modelo, cantMemoria, tipoConexion);
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
		clean();
		updateCodigo();
	}

	private void updateCodigo() {
		String pre = "";
		if (rdbDiscoDuro.isSelected()) {
			pre = "DD";
		}
		if (rdbMicro.isSelected()) {
			pre = "MC";
		}
		if (rdbMotherBoard.isSelected()) {
			pre = "MB";
		}
		if (rdbRam.isSelected()) {
			pre = "RM";
		}
		textcodigo.setText(pre + "-" + Tienda.codigo);

	}

	private void clean() {
		pnlDiscoDuro.setVisible(false);
		pnlMicro.setVisible(false);
		pnlMotherBoard.setVisible(true);
		pnlRam.setVisible(false);

		rdbDiscoDuro.setSelected(false);
		rdbMicro.setSelected(false);
		rdbMotherBoard.setSelected(true);
		rdbRam.setSelected(false);

		updateCodigo();
		spnCantidad.setValue(new Integer(1));
		spnPrecio.setValue(new Float(1));

		spnCapacidad.setValue(new Float(64));
		txtTipoConexion.setText("");
		txtMarca.setText("");
		txtModelo.setText("");
		txtProcesamiento.setText("");
		txtMemoriaRam.setText("");
		txtMicro.setText("");
		txtDiscoDuro.setText("");
		txtRam.setText("");
		txtTipoRam.setText("");
		spnCapacidad.setValue(new Float(4000));

	}
}
