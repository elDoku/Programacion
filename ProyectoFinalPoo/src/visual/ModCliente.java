package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Cliente;
import logico.Tienda;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtApellidos;
	private JTextField txtNombre;
	private JTextField txtPhone;
	private Cliente cliente = null;
	private JTextField txtDir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModCliente dialog = new ModCliente(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModCliente(Cliente pCliente) {
		cliente = pCliente;
		setTitle("Modificar de Cliente:");
		setBounds(100, 100, 434, 289);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);

			JLabel lblCedula = new JLabel("Cedula:");
			lblCedula.setBounds(181, 1, 58, 14);
			panel.add(lblCedula);

			txtCedula = new JTextField();
			txtCedula.setEditable(false);
			txtCedula.setBounds(115, 28, 180, 20);
			panel.add(txtCedula);
			txtCedula.setColumns(10);

			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(12, 72, 75, 14);
			panel.add(lblNombre);

			txtNombre = new JTextField();
			txtNombre.setBounds(12, 99, 180, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);

			JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
			lblTelfono.setBounds(220, 72, 75, 14);
			panel.add(lblTelfono);

			txtPhone = new JTextField();
			txtPhone.setBounds(220, 99, 177, 20);
			panel.add(txtPhone);
			txtPhone.setColumns(10);

			JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
			lblDireccin.setBounds(12, 132, 122, 14);
			panel.add(lblDireccin);

			txtDir = new JTextField();
			txtDir.setBounds(12, 152, 385, 22);
			panel.add(txtDir);
			txtDir.setColumns(10);
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
						cliente.setNombre(txtNombre.getText());
						cliente.setTelefono(txtPhone.getText());
						cliente.setDireccion(txtDir.getText());
						Tienda.getInstance().modificarCliente(cliente);
						ListadoCliente.loadClients();
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
		}

		loadCliente();
	}

	private void loadCliente() {
		if (cliente != null) {
			txtCedula.setText(cliente.getCedula());
			txtNombre.setText(cliente.getNombre());
			txtPhone.setText(cliente.getTelefono());
			txtDir.setText(cliente.getDireccion());
		}

	}
}
