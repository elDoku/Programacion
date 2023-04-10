package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Combo;
import logico.Componente;
import logico.DiscoDuro;
import logico.Micro;
import logico.MotherBoard;
import logico.Ram;
import logico.Tienda;
import sun.security.jca.GetInstance;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner.DefaultEditor;
import java.awt.Font;
import java.awt.Color;
import java.awt.TextArea;

public class DetallesCombo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private TextArea textAreaCombos; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DetallesCombo dialog = new DetallesCombo(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DetallesCombo(Combo combo) {

		setTitle("Reporte");
		setBounds(100, 100, 302, 292);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 36, 229, 188);
		contentPanel.add(panel_1);
		
		TextArea textAreaCombos = new TextArea();
		textAreaCombos.setEditable(false);
		textAreaCombos.setBounds(0, 0, 219, 178);
		panel_1.add(textAreaCombos);

		JLabel lblVentas = new JLabel("Componentes:");
		lblVentas.setBounds(12, 7, 97, 16);
		contentPanel.add(lblVentas);
///////////////////////////////////////////////////////////////////////////////////
		ArrayList<String> nombresComponentes = new ArrayList<String>();
		
		for (Componente q : combo.getMisComponentes()) {
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
		
		for (String string : nombresComponentes) {
			
			textAreaCombos.append(string +"\n");
			
		}
		
		

	}

	
}
