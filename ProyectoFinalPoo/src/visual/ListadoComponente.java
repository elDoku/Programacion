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
import logico.DiscoDuro;
import logico.Micro;
import logico.MotherBoard;
import logico.Ram;
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
		setTitle("Componentes");
		setBounds(100, 100, 635, 401);
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
						loadComponentes(comboBox.getSelectedIndex());
					}
				});
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "DiscoDuro", "Ram", "Micro", "MotherBoard"}));
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
					String[] headers = {"Serial","Tipo","Marca","Modelo","Cantidad","Precio"};
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
								selected = Tienda.getInstance().buscarQuesoByCodigo(codigo); 
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
							Tienda.getInstance().getMisComponentes().remove(selected);
							loadComponentes(0);
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
						ModComponente modComponente= new ModComponente(selected);
						modComponente.setModal(true);
						modComponente.setVisible(true);
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
		loadComponentes(0);
	}

	public static void loadComponentes(int index) {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		if(index == 0){
			for (Componente aux : Tienda.getInstance().getMisComponentes()) {
				
				rows[0] = aux.getSerial();
				if(aux instanceof Ram){
					rows[1] = "Ram";	
				}
				if(aux instanceof DiscoDuro){
					rows[1] = "DiscoDuro";	
				}
				if(aux instanceof Micro){
					rows[1] = "Micro";
				}
				if(aux instanceof MotherBoard){
					rows[1] = "MotherBoard";
				}
				
					rows[2] = aux.getMarca();
					rows[3] = aux.getModelo();
					rows[4] = aux.getCantidad();
					rows[5] = aux.getPrecio();
					model.addRow(rows);
				
			}
		}

		if(index == 1){
			for (Componente aux : Tienda.getInstance().getMisComponentes()) {
				if(aux instanceof Ram){
					rows[0] = aux.getSerial();
					rows[1] = "Ram";	
					rows[2] = aux.getMarca();
					rows[3] = aux.getModelo();
					rows[4] = aux.getCantidad();
					rows[5] = aux.getPrecio();

					model.addRow(rows);
				}
			}	
		}
		if(index == 3){
			for (Componente aux : Tienda.getInstance().getMisComponentes()) {
				if(aux instanceof DiscoDuro){
					
					rows[0] = aux.getSerial();
					rows[1] = "DiscoDuro";	
					rows[2] = aux.getMarca();
					rows[3] = aux.getModelo();
					rows[4] =aux.getCantidad();
					rows[5] = aux.getPrecio();
					model.addRow(rows);
				}
			}	
		}
		if(index==2){
			for (Componente aux : Tienda.getInstance().getMisComponentes()) {
				if((aux instanceof Micro) ){
					
					rows[0] = aux.getSerial();
					rows[1] = "Micro";	
					rows[2] = aux.getMarca();
					rows[3] = aux.getModelo();
					rows[4] =aux.getCantidad();
					rows[5] = aux.getPrecio();
					model.addRow(rows);
				}
			}	
		}
		if(index==4){
			for (Componente aux : Tienda.getInstance().getMisComponentes()) {
				if((aux instanceof MotherBoard) ){
					
					rows[0] = aux.getSerial();
					rows[1] = "Board";	
					rows[2] = aux.getMarca();
					rows[3] = aux.getModelo();
					rows[4] = aux.getCantidad();
					rows[5] = aux.getPrecio();
					model.addRow(rows);
				}
			}
			}
		
	}
	


}
