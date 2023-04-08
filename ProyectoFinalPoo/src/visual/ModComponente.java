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

public class ModComponente extends JDialog {

	private final JPanel contentPanel = new JPanel();

	Componente cp = null;

	private JTextField txtTipoConexionMc;
	private JTextField txtTipoConexionDd;
	private JTextField txtTipoConexionMb;
	private JTextField txtProcesamiento;
	private JTextField txtMemoriaRam;
	private JTextField txtDiscoDuro;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegComponente dialog = new RegComponente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModComponente(Componente selected) {
		cp = selected;
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
		{
			JPanel panel = new JPanel();
			panel.setBounds(6, 13, 384, 204);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n General:",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel);
			panel.setLayout(null);

			lblPrecio = new JLabel("Precio:");
			lblPrecio.setBounds(12, 36, 72, 14);
			panel.add(lblPrecio);

			spnPrecio = new JSpinner();
			spnPrecio.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spnPrecio.setBounds(12, 67, 161, 20);
			panel.add(spnPrecio);

			lblCantidad = new JLabel("Cantidad:");
			lblCantidad.setBounds(12, 112, 72, 14);
			panel.add(lblCantidad);

			spnCantidad = new JSpinner();
			spnCantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnCantidad.setBounds(12, 148, 161, 20);
			panel.add(spnCantidad);

		}

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			{
				JButton okButton = new JButton("Modificar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						float precio = Float.valueOf(spnPrecio.getValue().toString());
						int cantidad = Integer.valueOf(spnCantidad.getValue().toString());
						if (cp instanceof MotherBoard) {
							String marcaMb = txtMarcaMb.getText();
							String tipoConexionMb = txtTipoConexionMb.getText();

							String modeloMb = txtModeloMb.getText();
							String micro = txtMicro.getText();
							String discoDuro = txtDiscoDuro.getText();
							String tipoRam = txtTipoRam.getText();
							((MotherBoard) cp).setSerial(txtSerial.getText());
							((MotherBoard) cp).setPrecio(precio);
							((MotherBoard) cp).setCantidad(cantidad);

							((MotherBoard) cp).setMarca(marcaMb);
							((MotherBoard) cp).setModelo(modeloMb);
							((MotherBoard) cp).setMicro(micro);
							((MotherBoard) cp).setConexionDisco(tipoConexionMb);
							((MotherBoard) cp).setTipoRam(tipoRam);
							((MotherBoard) cp).setTipoConexion(tipoConexionMb);

						}
						if (cp instanceof DiscoDuro) {
							float capacidad = Float.valueOf(spnCapacidad.getValue().toString());
							String marcaDd = txtMarcaDd.getText();
							String tipoConexionDd = txtTipoConexionDd.getText();
							String modeloDd = txtModeloDd.getText();

							((DiscoDuro) cp).setPrecio(precio);
							((DiscoDuro) cp).setCantidad(cantidad);
							((DiscoDuro) cp).setMarca(marcaDd);
							((DiscoDuro) cp).setModelo(modeloDd);
							((DiscoDuro) cp).setCapacidad(capacidad);
							((DiscoDuro) cp).setTipoConexion(tipoConexionDd);

							// clean();
						}
						if (cp instanceof Micro) {
							String marcaMc = txtMarcaMc.getText();
							String procesamiento = txtProcesamiento.getText();
							String modeloMc = txtModeloMc.getText();
							String tipoConexionMc = txtTipoConexionMc.getText();

							((Micro) cp).setPrecio(precio);
							((Micro) cp).setCantidad(cantidad);
							((Micro) cp).setMarca(marcaMc);
							((Micro) cp).setModelo(modeloMc);
							((Micro) cp).setTipoConexion(tipoConexionMc);
							((Micro) cp).setProcesamiento(procesamiento);

							// clean();
						}

						if (cp instanceof Ram) {
							String marcaRm = txtMarcaRm.getText();
							String tipoRam = txtTipoRam.getText();
							String modeloRm = txtModeloRm.getText();
							float cantMemoria = Float.valueOf(spnCantMemoria.getValue().toString());

							((Ram) cp).setPrecio(precio);
							((Ram) cp).setCantidad(cantidad);
							((Ram) cp).setMarca(marcaRm);
							((Ram) cp).setModelo(modeloRm);
							((Ram) cp).setCantMemoria(cantMemoria);
							((Ram) cp).setTipoRam(tipoRam);
							// clean();
						}
						Tienda.getInstance().modificarQueso(cp);
						ListadoComponente.loadComponentes(0);
						JOptionPane.showMessageDialog(null, "Modificación Exitosa", "Informacion",
								JOptionPane.INFORMATION_MESSAGE);
						dispose();

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
			if (cp instanceof MotherBoard) {
				pnlMotherBoard.setVisible(true);
				pnlRam.setVisible(false);
				pnlMicro.setVisible(false);
				pnlDiscoDuro.setVisible(false);

				spnPrecio.setValue(cp.getPrecio());
				spnCantidad.setValue(cp.getCantidad());
				txtMarcaMb.setText(cp.getMarca());
				txtModeloMb.setText(cp.getModelo());
				txtMicro.setText(((MotherBoard) cp).getMicro());
				txtDiscoDuro.setText(((MotherBoard) cp).getConexionDisco());
				txtRam.setText(((MotherBoard) cp).getTipoRam());
				txtTipoConexionMb.setText(((MotherBoard) cp).getTipoConexion());
			}

			if (cp instanceof Ram) {
				pnlMotherBoard.setVisible(false);
				pnlRam.setVisible(true);
				pnlMicro.setVisible(false);
				pnlDiscoDuro.setVisible(false);

				spnPrecio.setValue(cp.getPrecio());
				spnCantidad.setValue(cp.getCantidad());
				txtMarcaRm.setText(cp.getMarca());
				txtModeloRm.setText(cp.getModelo());
				spnCantMemoria.setValue(((Ram) cp).getCantMemoria());
				txtTipoRam.setText(((Ram) cp).getTipoRam());

			}

			if (cp instanceof Micro) {
				pnlMotherBoard.setVisible(false);
				pnlRam.setVisible(false);
				pnlMicro.setVisible(true);
				pnlDiscoDuro.setVisible(false);

				spnPrecio.setValue(cp.getPrecio());
				spnCantidad.setValue(cp.getCantidad());
				txtMarcaMc.setText(cp.getMarca());
				txtModeloMc.setText(cp.getModelo());
				txtTipoConexionMc.setText(((Micro) cp).getTipoConexion());
				txtProcesamiento.setText(((Micro) cp).getProcesamiento());

			}
			if (cp instanceof DiscoDuro) {
				pnlMotherBoard.setVisible(false);
				pnlRam.setVisible(false);
				pnlMicro.setVisible(false);
				pnlDiscoDuro.setVisible(true);

				spnPrecio.setValue(cp.getPrecio());
				spnCantidad.setValue(cp.getCantidad());
				txtMarcaDd.setText(cp.getMarca());
				txtModeloDd.setText(cp.getModelo());
				spnCapacidad.setValue(((DiscoDuro) cp).getCapacidad());
				txtTipoConexionDd.setText(((DiscoDuro) cp).getTipoConexion());

			}

		}

	}

}
