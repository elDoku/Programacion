package visual;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import logico.Cliente;
import logico.Combo;
import logico.Componente;
import logico.DiscoDuro;
import logico.Factura;
import logico.Micro;
import logico.MotherBoard;
import logico.Ram;
import logico.Tienda;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class AgregarCombo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JScrollPane scrollPane;
	private JList<String> list;
	private JList<String> list_1;
	private JScrollPane scrollPane_1;
	private JButton btnDerecha;
	private JButton btnIzquierda;
	private JSpinner spnTotal;
	private JSpinner spnDescuento;

	private JButton btnFacturar;

	private ArrayList<Cliente> misCliente;
	private ArrayList<Componente> misComponentes;
	DefaultListModel<String> modelo0 = new DefaultListModel<String>();
	DefaultListModel<String> modelo = new DefaultListModel<String>();
	DefaultListModel<String> modeloAux = new DefaultListModel<String>();
	// para crear un modelo para el texto del jlist

	public static void main(String[] args) {
		try {
			AgregarCombo dialog = new AgregarCombo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarCombo() {
		setTitle("Combo");
		setBounds(100, 100, 522, 476);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 486, 82);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 45, 52, 14);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(70, 42, 216, 23);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 104, 486, 224);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 34, 177, 174);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(299, 34, 177, 174);
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		scrollPane_1 = new JScrollPane();
		panel_3.add(scrollPane_1, BorderLayout.CENTER);

		list = new JList<String>();
		scrollPane.setViewportView(list);

		list_1 = new JList<String>();
		scrollPane_1.setViewportView(list_1);

		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				btnDerecha.setEnabled(!list.isSelectionEmpty());
			}
		});
		list_1.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				btnIzquierda.setEnabled(!list_1.isSelectionEmpty());
			}
		});

		// Llena el carrito de disponibles
		ArrayList<Componente> componentes2 = Tienda.getInstance().getMisComponentes();
		// Aqui traigo mis quesos hacia un arreglo
		ArrayList<String> nombresComponentes = new ArrayList<String>();
		// Aqui creo un arreglo de strings para colocar los codigos y nombres de los
		// quesos
		for (Componente q : componentes2) {
			if (q instanceof Ram) {
				nombresComponentes.add(q.getSerial() + "-Ram");
				// es decir que a un string si se le puede agregar de otra clase
			}
			if (q instanceof Micro) {
				nombresComponentes.add(q.getSerial() + "-Micro");
			}
			if (q instanceof MotherBoard) {
				nombresComponentes.add(q.getSerial() + "-MotherBoard");
			}
			
			if (q instanceof DiscoDuro) {
				nombresComponentes.add(q.getSerial() + "-DiscoDuro");
			}
			
			
			
		}
		// Aqui se presentan los quesos
		// Creo una lista modelo para presentar los los nombres de la lista anterior
		DefaultListModel<String> modeloComponentes = new DefaultListModel<String>();
		for (String nombre : nombresComponentes) {
			// se recorre el arreglo string de la variable nombre de la clase string
			modeloComponentes.addElement(nombre);
		}
		list.setModel(modeloComponentes);

		// ------------------------------------------------------------------------

		JLabel lblCarritoDeCompra = new JLabel("Combo");
		lblCarritoDeCompra.setBounds(299, 9, 177, 14);
		panel_1.add(lblCarritoDeCompra);

		// ------------------------------------------------------------------------
		//
		// ---------------------------------------------------------------------------------------

		btnDerecha = new JButton(">>");
		btnDerecha.setEnabled(false);
		btnDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = list.getSelectedIndex();
				ArrayList<Componente> Componentes = Tienda.getInstance().getMisComponentes();
				// array que recoge los quesos
				if (index >= 0 && index < Componentes.size()) {
					// verifica que lo que se busca esta dentro de la lista
					// seleccionado dentro de los quesos
					// boolean encontrado = false;
					modelo = modeloComponentes;
					// aqui igualo modelo al modelo de la lista 1

					if (index >= 0 && index < modelo.getSize()) {

						String codigo = (String) modelo.getElementAt(index);
						// index++;
						modelo0.addElement(codigo);
						// modelo0 es la lista 2
						modelo.removeElementAt(index);
					}
					list.setModel(modelo);
					list_1.setModel(modelo0);
					
					spnTotal.setValue(Tienda.getInstance().totalFactura(list_1));
					//spnDescuento.setValue(Tienda.getInstance().totalFactura(list_1));
					
					if (list_1.getModel().getSize() > 0) {
						btnFacturar.setEnabled(true);
					}
					if (list_1.getModel().getSize() < 1) {
						btnFacturar.setEnabled(false);
					}
				}
			}
		});
		btnDerecha.setBounds(200, 83, 89, 25);
		panel_1.add(btnDerecha);

		// ---------------------------------------------------------------------------------------
		btnIzquierda = new JButton("<<");
		btnIzquierda.setEnabled(false);
		btnIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = list_1.getSelectedIndex();
				ListModel<String> componentes = list_1.getModel();
				// quesos es un arreglo con los datos de la primera lista
				if (index >= 0 && index < componentes.getSize()) {
//					modelo0 = modelo;

					String codigo = (String) modelo0.getElementAt(index);
					// codigo es el elemento seleccionado de la 2dalista
					modelo.addElement(codigo);
					// modelo0 es la lista 2
					modelo0.removeElementAt(index);

				}
				list.setModel(modelo);
				list_1.setModel(modelo0);
				spnTotal.setValue(Tienda.getInstance().totalFactura(list_1));
				//spnDescuento.setValue(Tienda.getInstance().totalFactura(list_1));

				if (list_1.getModel().getSize() > 0) {
					btnFacturar.setEnabled(true);
				}
				if (list_1.getModel().getSize() < 1) {
					btnFacturar.setEnabled(false);
				}
			}
			// modelo.removeAllElements();

		});
		btnIzquierda.setBounds(200, 119, 89, 23);
		panel_1.add(btnIzquierda);
		
				JLabel lblQuesosDisponibles = new JLabel("Componentes Disponibles");
				lblQuesosDisponibles.setBounds(10, 9, 177, 14);
				panel_1.add(lblQuesosDisponibles);

		// ---------------------------------------------------------------------------------------
		//

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(311, 369, 46, 14);
		contentPanel.add(lblTotal);

		spnTotal = new JSpinner();
		spnTotal.setEnabled(false);
		spnTotal.setBounds(349, 365, 110, 22);
		contentPanel.add(spnTotal);

//		
//		ArrayList<Queso> quesos3 = TiendaQueso.getInstance().getMisQuesos();
////		
//		for (Queso q : quesos3) {
//			if (q instanceof QuesoEsferico) {
//				modelo.addElement(q.getCodigo() + "-Esférico");
//				// es decir que a un string si se le puede agregar de otra clase
//			}
//			if (q instanceof QuesoCilindrico && !(q instanceof QuesoCilindricoH)) {
//				modelo.addElement(q.getCodigo() + "-Cilíndrico");
//			}
//			if (q instanceof QuesoCilindricoH) {
//				modelo.addElement(q.getCodigo() + "-CilíndricoH");
//			}
//
//		}

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnFacturar = new JButton("Agregar");
				btnFacturar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Combo aux=null;
						String nombre = txtNombre.getText();
						aux=new Combo("CO-" + Tienda.getInstance().getMisCombos().size(), nombre, losComponentes(), Tienda.getInstance().totalFactura(list_1));
						ArrayList<String> nombresQ = new ArrayList<String>();
						ListModel<String> misComponentes = list_1.getModel();
						Tienda.getInstance().insertarCombo(aux);
						
						Tienda.getInstance().guardarCombosEnArchivo();
						Tienda.getInstance().verificarDisponibles(losComponentes());

//						
						
						
						JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion",
								JOptionPane.INFORMATION_MESSAGE);
						clean();

					}
				});
				btnFacturar.setActionCommand("OK");
				buttonPane.add(btnFacturar);
				getRootPane().setDefaultButton(btnFacturar);
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
	}

	private ArrayList<Componente> losComponentes() {
		ArrayList<Componente> array = new ArrayList<>();
		int i = 0;
		for (i = 0; i >= 0 && i < list_1.getModel().getSize(); i++) {
			String str = list_1.getModel().getElementAt(i);
			String cod = str.substring(0, 4);
			for (Componente componente : Tienda.getInstance().getMisComponentes()) {
				
				if (componente.getSerial().equalsIgnoreCase(cod)) {
					array.add(componente);
				}
			}
		}
		return array;
	}

	private void clean() {
		
		txtNombre.setText("");
	
		txtNombre.setEditable(false);
		
		btnDerecha.setEnabled(false);
		btnIzquierda.setEnabled(false);

		DefaultListModel<String> limpio = new DefaultListModel<String>();
		spnTotal.setValue(new Float(0.0));
		//spnDescuento.setValue(new Float(0.0));
		modelo0 = limpio;
		list_1.setModel(limpio);

	}
}
