package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Tienda;
import logico.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream empresa;
				FileOutputStream empresa2;
				ObjectInputStream empresaRead;
				ObjectOutputStream empresaWrite;
				
				try {
					empresa = new FileInputStream ("empresa.dat");
					empresaRead = new ObjectInputStream(empresa);
					Tienda temp = (Tienda)empresaRead.readObject();
					Tienda.setTienda(temp);
					empresa.close();
					empresaRead.close();
				} catch (FileNotFoundException e) {
					try {
						empresa2 = new  FileOutputStream("empresa.dat");
						empresaWrite = new ObjectOutputStream(empresa2);
						
						User aux = new User("Administrador", "Admin", "Admin");
						
						Tienda.getInstance().regUser(aux);
						System.out.println("Se ha guardado el user");
						
						empresaWrite.writeObject(Tienda.getInstance());
						empresa2.close();
						empresaWrite.close();
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 294);
		
		
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		
		//panel.setSize(400,300);
		
		
		panel.setBackground(UIManager.getColor("InternalFrame.borderLight"));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBackground(Color.WHITE);
		lblUsuario.setBounds(39, 39, 87, 14);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setBackground(UIManager.getColor("Button.highlight"));
		lblContrasea.setBounds(39, 98, 105, 14);
		
		panel.add(lblContrasea);
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.DARK_GRAY);
		textField.setBounds(39, 64, 191, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setBackground(Color.DARK_GRAY);
		textField_1.setBounds(39, 128, 191, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		btnLogin.setBackground(SystemColor.activeCaption);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Tienda.getInstance().confirmLogin(textField.getText(),textField_1.getText())){
					Principal frame = new Principal();
					dispose();
					frame.setVisible(true);
				}else{
					
					JOptionPane.showMessageDialog(null, "Usuario No Existe", "Informacion",
							JOptionPane.INFORMATION_MESSAGE);
				};
				
			}
		});
		btnLogin.setBounds(37, 175, 89, 23);
		panel.add(btnLogin);
		
		JLabel labelfondo = new JLabel("Fondo");
		labelfondo.setSize(640, 640);
		ImageIcon imagen=new ImageIcon("Imagenes/80s_retro_gaming_diffused_with_modern_gaming_setup_by_minhazabtahi_dfm5ny8-fullview.jpg");
		Icon imagenIcon=new ImageIcon(imagen.getImage().getScaledInstance(labelfondo.getWidth(), labelfondo.getHeight(), Image.SCALE_DEFAULT));
		labelfondo.setIcon(imagenIcon);
		
		
		labelfondo.setBackground(Color.WHITE);
		labelfondo.setBounds(-36, -79, 550, 434);
		panel.add(labelfondo);
	}
}
