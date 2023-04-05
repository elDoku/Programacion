package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


import logico.Componente;
import logico.Tienda;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

public class ListadoComponente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object rows[];
	private JComboBox comboBox;
	private JButton btnUpdate;
	private JButton btnDelete;
	private Componente selected = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoComponente dialog = new ListadoComponente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoComponente() {
		setTitle("Lista de Quesos");
		setBounds(100, 100, 581, 345);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 15));
			{
				JLabel lblTipoDeQueso = new JLabel("Tipo de Queso:");
				lblTipoDeQueso.setHorizontalAlignment(SwingConstants.LEFT);
				panel.add(lblTipoDeQueso);
			}
			{
				comboBox = new JComboBox();
				comboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//loadQuesos(comboBox.getSelectedIndex());
					}
				});
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Esf\u00E9rico", "Cil\u00EDndrico", "Cil\u00EDdrico Hueco"}));
				panel.add(comboBox);
			}
		}
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
					String[] headers = {"Código","Volumen","Precio","Tipo"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int index = table.getSelectedRow();
							if(index>=0){
								btnDelete.setEnabled(true);
								btnUpdate.setEnabled(true);
								String codigo = table.getValueAt(index, 0).toString();
								//selected = TiendaQueso.getInstance().buscarQuesoByCodigo(codigo); 
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
						if(selected!=null){
							//TiendaQueso.getInstance().getMisQuesos().remove(selected);
							//loadQuesos(0);
							btnDelete.setEnabled(false);
							comboBox.setSelectedItem("<Todos>");
						}
					}
				});
				btnDelete.setEnabled(false);
				buttonPane.add(btnDelete);
			}
			{
				btnUpdate = new JButton("Modificar");
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//ModQueso modQueso= new ModQueso(selected);
						//modQueso.setModal(true);
					//	modQueso.setVisible(true);
						btnUpdate.setEnabled(false);
						comboBox.setSelectedItem("<Todos>");
					}
				});
				btnUpdate.setEnabled(false);
				btnUpdate.setActionCommand("OK");
				buttonPane.add(btnUpdate);
				getRootPane().setDefaultButton(btnUpdate);

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
		//loadQuesos(0);
	}

	public static void loadComponentes(int index) {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		if(index == 0){
			for (Componente aux : Tienda.getInstance().getMisComponentes()) {
				
					rows[0] = aux
					rows[1] = aux.Volumen();
					rows[2] = aux.precioT();
					if(aux instanceof QuesoEsferico){
						rows[3] = "Esférico";	
					}
					if(aux instanceof QuesoCilindricoH){
						rows[3] = "Cilíndrico Hueco";	
					}
					if(aux instanceof QuesoCilindrico && !(aux instanceof QuesoCilindricoH)){
						rows[3] = "Cilíndrico";
					}
					model.addRow(rows);
				
			}
		}

		if(index == 1){
			for (Queso aux : TiendaQueso.getInstance().getMisQuesos()) {
				if(aux instanceof QuesoEsferico && aux.getEstado() == 'D'){
					rows[0] = aux.getCodigo();
					rows[1] = aux.Volumen();
					rows[2] = aux.precioT();
					rows[3] = "Esférico";	
					model.addRow(rows);
				}
			}	
		}
		if(index == 3){
			for (Queso aux : TiendaQueso.getInstance().getMisQuesos()) {
				if(aux instanceof QuesoCilindricoH && aux.getEstado()=='D'){
					rows[0] = aux.getCodigo();
					rows[1] = aux.Volumen();
					rows[2] = aux.precioT();
					rows[3] = "Cilíndrico Hueco";	
					model.addRow(rows);
				}
			}	
		}
		if(index==2){
			for (Queso aux : TiendaQueso.getInstance().getMisQuesos()) {
				if(!(aux instanceof QuesoCilindricoH) && !(aux instanceof QuesoEsferico) && aux.getEstado()=='D'){
					rows[0] = aux.getCodigo();
					rows[1] = aux.Volumen();
					rows[2] = aux.precioT();
					rows[3] = "Cilíndrico";
					model.addRow(rows);
				}

			}	
		}
	}
	


}
