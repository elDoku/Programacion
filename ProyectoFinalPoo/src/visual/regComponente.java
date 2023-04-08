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

	private JTextField txtTipoConexionMc;
	private JTextField txtTipoConexionDd;
	private JTextField txtTipoConexionMb;
	private JTextField txtProcesamiento;
	private JTextField txtMemoriaRam;
	private JTextField txtDiscoDuro;
	private JTextField textcodigo;
	private JTextField txtTipo;
	private JTextField txtTipoRam;
	private JTextField txtSerial;
	private JTextField txtRam;
	private JTextField txtMicro;
	private JTextField txtModeloMb;
	private JTextField txtMarcaMb;
	private JTextField txtModeloMc;
	private JTextField txtMarcaMc;
	private JTextField txtModeloDd;
	private JTextField txtMarcaDd;
	private JTextField txtModeloRm;
	private JTextField txtMarcaRm;

	private JLabel lblCdigo;
	private JLabel lblPrecio;
	private JLabel lblDiscoDuro;
	private JLabel lblRam;
	private JLabel lblTipoRam;
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
	private JSpinner spnCapacidad;
	private JRadioButton rdbRam;
	private JRadioButton rdbMotherBoard;
	private JRadioButton rdbMicro;
	private JRadioButton rdbDiscoDuro;

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

		txtMarcaRm = new JTextField();
		txtMarcaRm.setBounds(12, 43, 105, 22);
		pnlRam.add(txtMarcaRm);
		txtMarcaRm.setColumns(10);

		txtModeloRm = new JTextField();
		txtModeloRm.setBounds(140, 43, 90, 22);
		pnlRam.add(txtModeloRm);
		txtModeloRm.setColumns(10);

		lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(12, 14, 105, 16);
		pnlRam.add(lblMarca);

		lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(140, 14, 56, 16);
		pnlRam.add(lblModelo);

		spnCantMemoria = new JSpinner();
		spnCantMemoria.setModel(new SpinnerNumberModel(new Float(4096), new Float(4096), null, new Float(1)));
		spnCantMemoria.setBounds(12, 102, 105, 22);
		pnlRam.add(spnCantMemoria);

		txtTipoRam = new JTextField();
		txtTipoRam.setBounds(140, 102, 90, 22);
		pnlRam.add(txtTipoRam);
		txtTipoRam.setColumns(10);

		lblDiscoDuro = new JLabel("#Memoria (Mb):");
		lblDiscoDuro.setBounds(12, 78, 105, 16);
		pnlRam.add(lblDiscoDuro);

		lblTipoRam = new JLabel("Tipo de Ram:");
		lblTipoRam.setBounds(140, 78, 90, 16);
		pnlRam.add(lblTipoRam);
		contentPanel.add(pnlMotherBoard);
		pnlMotherBoard.setLayout(null);

		txtMarcaMb = new JTextField();
		txtMarcaMb.setBounds(12, 38, 105, 22);
		pnlMotherBoard.add(txtMarcaMb);
		txtMarcaMb.setColumns(10);

		txtModeloMb = new JTextField();
		txtModeloMb.setBounds(139, 38, 90, 22);
		pnlMotherBoard.add(txtModeloMb);
		txtModeloMb.setColumns(10);

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

		lblDiscoDuro = new JLabel("Conexion Disco Duro:");
		lblDiscoDuro.setBounds(12, 73, 105, 16);
		pnlMotherBoard.add(lblDiscoDuro);

		lblRam = new JLabel("Ram:");
		lblRam.setBounds(139, 73, 56, 16);
		pnlMotherBoard.add(lblRam);

		txtTipoConexionMb = new JTextField();
		txtTipoConexionMb.setBounds(254, 102, 105, 22);
		pnlMotherBoard.add(txtTipoConexionMb);
		txtTipoConexionMb.setColumns(10);

		lblTipoConexion = new JLabel("Tipo de Conector:");
		lblTipoConexion.setBounds(254, 73, 105, 16);
		pnlMotherBoard.add(lblTipoConexion);
		pnlMicro.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlMicro.setBounds(6, 230, 384, 137);
		contentPanel.add(pnlMicro);
		pnlMicro.setLayout(null);

		txtMarcaMc = new JTextField();
		txtMarcaMc.setBounds(12, 40, 105, 22);
		pnlMicro.add(txtMarcaMc);
		txtMarcaMc.setColumns(10);

		txtModeloMc = new JTextField();
		txtModeloMc.setBounds(140, 40, 90, 22);
		pnlMicro.add(txtModeloMc);
		txtModeloMc.setColumns(10);

		lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(12, 13, 56, 16);
		pnlMicro.add(lblMarca);

		lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(140, 13, 56, 16);
		pnlMicro.add(lblModelo);

		txtTipoConexionMc = new JTextField();
		txtTipoConexionMc.setBounds(254, 40, 105, 22);
		pnlMicro.add(txtTipoConexionMc);
		txtTipoConexionMc.setColumns(10);

		txtProcesamiento = new JTextField();
		txtProcesamiento.setBounds(12, 102, 105, 22);
		pnlMicro.add(txtProcesamiento);
		txtProcesamiento.setColumns(10);

		lblTipoConexion = new JLabel("Tipo de Conexion:");
		lblTipoConexion.setBounds(254, 13, 105, 16);
		pnlMicro.add(lblTipoConexion);

		lblProcesamiento = new JLabel("Procesamiento:");
		lblProcesamiento.setBounds(12, 75, 90, 16);
		pnlMicro.add(lblProcesamiento);

		// -----------------------------------------------

		pnlDiscoDuro = new JPanel();
		pnlDiscoDuro.setBounds(6, 230, 384, 137);
		contentPanel.add(pnlDiscoDuro);
		pnlDiscoDuro.setVisible(false);
		pnlDiscoDuro.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDiscoDuro.setLayout(null);

		txtMarcaDd = new JTextField();
		txtMarcaDd.setBounds(12, 35, 105, 22);
		pnlDiscoDuro.add(txtMarcaDd);
		txtMarcaDd.setColumns(10);

		txtModeloDd = new JTextField();
		txtModeloDd.setBounds(140, 35, 90, 22);
		pnlDiscoDuro.add(txtModeloDd);
		txtModeloDd.setColumns(10);

		lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(12, 13, 56, 16);
		pnlDiscoDuro.add(lblMarca);

		lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(140, 13, 56, 16);
		pnlDiscoDuro.add(lblModelo);

		txtTipoConexionDd = new JTextField();
		txtTipoConexionDd.setBounds(12, 100, 105, 22);
		pnlDiscoDuro.add(txtTipoConexionDd);
		txtTipoConexionDd.setColumns(10);

		lblCapacidad = new JLabel("Capacidad (Gb):");
		lblCapacidad.setBounds(257, 13, 105, 16);
		pnlDiscoDuro.add(lblCapacidad);

		lblTipoConexion = new JLabel("Tipo de Conexion:");
		lblTipoConexion.setBounds(12, 71, 112, 16);
		pnlDiscoDuro.add(lblTipoConexion);

		spnCapacidad = new JSpinner();
		spnCapacidad.setModel(new SpinnerNumberModel(new Integer(64), null, null, new Integer(1)));
		spnCapacidad.setBounds(257, 35, 105, 22);
		pnlDiscoDuro.add(spnCapacidad);

		spnCapacidad = new JSpinner();
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
						if (rdbMotherBoard.isSelected()) {
							String marcaMb = txtMarcaMb.getText();
							String tipoConexionMb = txtTipoConexionMb.getText();

							String modeloMb = txtModeloMb.getText();
							String micro = txtMicro.getText();
							String discoDuro = txtDiscoDuro.getText();
							String tipoRam = txtTipoRam.getText();

							aux = new MotherBoard(precio, cantidad, serial, marcaMb, modeloMb, micro, discoDuro,
									tipoRam, tipoConexionMb);
							Tienda.getInstance().insertarComponente(aux);
							JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion",
									JOptionPane.INFORMATION_MESSAGE);
							clean();

						}
						if (rdbDiscoDuro.isSelected()) {
							float capacidad = Float.valueOf(spnCapacidad.getValue().toString());
							String marcaDd = txtMarcaDd.getText();
							String tipoConexionDd = txtTipoConexionDd.getText();
							String modeloDd = txtModeloDd.getText();

							aux = new DiscoDuro(precio, cantidad, serial, marcaDd, modeloDd, capacidad, tipoConexionDd);
							Tienda.getInstance().insertarComponente(aux);
							JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion",
									JOptionPane.INFORMATION_MESSAGE);

							clean();
						}
						if (rdbMicro.isSelected()) {
							String marcaMc = txtMarcaMc.getText();
							String procesamiento = txtProcesamiento.getText();
							String modeloMc = txtModeloMc.getText();
							String tipoConexionMc = txtTipoConexionMc.getText();

							aux = new Micro(precio, cantidad, serial, marcaMc, modeloMc, tipoConexionMc, procesamiento);
							Tienda.getInstance().insertarComponente(aux);
							JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion",
									JOptionPane.INFORMATION_MESSAGE);
							clean();
						}

						if (rdbRam.isSelected()) {
							String marcaRm = txtMarcaRm.getText();
							String tipoRam = txtTipoRam.getText();
							String modeloRm = txtModeloRm.getText();
							float cantMemoria = Float.valueOf(spnCantMemoria.getValue().toString());
							aux = new Ram(precio, cantidad, serial, marcaRm, modeloRm, cantMemoria, tipoRam);
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

		txtMarcaMb.setText("");
		txtModeloMb.setText("");
		txtMarcaMc.setText("");
		txtModeloMc.setText("");
		txtMarcaDd.setText("");
		txtModeloDd.setText("");
		txtMarcaRm.setText("");
		txtModeloRm.setText("");
		txtTipoConexionMc.setText("");
		txtTipoConexionDd.setText("");
		txtTipoConexionMb.setText("");

		txtProcesamiento.setText("");
		txtMicro.setText("");
		txtDiscoDuro.setText("");
		txtRam.setText("");
		txtTipoRam.setText("");
		spnCapacidad.setValue(new Float(64));
		spnCantMemoria.setValue(new Float(4096));

	}
}
