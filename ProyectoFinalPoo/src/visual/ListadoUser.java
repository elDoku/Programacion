package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;
import logico.Tienda;
import logico.User;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListadoUser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static DefaultTableModel model;
	private static Object row[];
	private JButton btnModificar;

	private JButton btnDelete;
	private User selected = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoUser dialog = new ListadoUser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoUser() {
		setTitle("Listado User");
		setBounds(100, 100, 635, 344);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					String headers[] = {"Usuario","PassWord","User"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int index = table.getSelectedRow();
							if(index>=0){
								btnModificar.setEnabled(true);
								btnDelete.setEnabled(true);
								String user = table.getValueAt(index, 0).toString();
								selected = Tienda.getInstance().buscarUserByCedula(user); 
							}
						}
					});
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setModel(model);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnDelete = new JButton("Eliminar");
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (selected != null) {
							
							 int opcion = JOptionPane.showOptionDialog(
							            null, "¿Estas Segur@?", "Confirmación",
							            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
							            new Object[] {"Continuar", "Cancelar"}, "Continuar"
							        );
							 
							 if (opcion == JOptionPane.YES_OPTION) {
								 Tienda.getInstance().getMisUser().remove(selected);
								 Tienda.getInstance().guardarUserEnArchivo();
						        } 
							
							
							loadUser();
							btnDelete.setEnabled(false);
						}
					}
				});
				btnDelete.setEnabled(false);
				buttonPane.add(btnDelete);
			}
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					ModUser modCliente = new ModUser(selected);
					modCliente.setModal(true);
						modCliente.setVisible(true);
						btnModificar.setEnabled(false);
					}
				});
				btnModificar.setEnabled(false);
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		
		loadUser();
	}

	public static void loadUser() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for (User aux : Tienda.getInstance().getMisUser()) {
			row[0] = aux.getUserName();
			row[1] = aux.getPass();
		    row[2] = aux.getTipo();
		   
		    model.addRow(row);
		}
		
	  
		
	}

}
