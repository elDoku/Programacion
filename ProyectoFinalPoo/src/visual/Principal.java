package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


import logico.Tienda;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Dimension dim;

	
	static Socket sfd = null;
	static DataInputStream EntradaSocket;
	static DataOutputStream SalidaSocket;

	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
			
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		
		
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				
				FileOutputStream empresa2;
				ObjectOutputStream empresaWrite;
				try {
					empresa2 = new  FileOutputStream("empresa.dat");
					empresaWrite = new ObjectOutputStream(empresa2);
					empresaWrite.writeObject(Tienda.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			
		});
		
		
		setTitle("Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height - 50);
		setLocationRelativeTo(null);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnComponente = new JMenu("Componentes");
		mnComponente.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		menuBar.add(mnComponente);

		JMenuItem mntmFabricarComponente = new JMenuItem("Fabricar Componentes");
		mntmFabricarComponente.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		mntmFabricarComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegComponente regC = new RegComponente();
				regC.setModal(true);
				regC.setVisible(true);
			}
		});
		mnComponente.add(mntmFabricarComponente);

		JMenuItem mntmListadoDeComponentes = new JMenuItem("Listado de Componentes");
		mntmListadoDeComponentes.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		mntmListadoDeComponentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoComponente list = new ListadoComponente();
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnComponente.add(mntmListadoDeComponentes);

		JMenuItem mntmNewMenuItem = new JMenuItem("Agregar Combo");
		mntmNewMenuItem.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AgregarCombo list = new AgregarCombo();
				list.setModal(true);
				list.setVisible(true);

			}
		});
		mnComponente.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listado de Combos");
		mntmNewMenuItem_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListadoCombo list = new ListadoCombo();
				list.setModal(true);
				list.setVisible(true);
				
				
				
			}
		});
		mnComponente.add(mntmNewMenuItem_1);

		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		menuBar.add(mnClientes);

		JMenuItem mntmListadoDeClientes = new JMenuItem("Listado de Clientes");
		mntmListadoDeClientes.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		mntmListadoDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoCliente list = new ListadoCliente();
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnClientes.add(mntmListadoDeClientes);

		JMenu mnVentas = new JMenu("Ventas");
		mnVentas.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		menuBar.add(mnVentas);

		JMenuItem mntmListaFactura = new JMenuItem("Lista de Facturas");
		mntmListaFactura.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		mntmListaFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoFactura list = new ListadoFactura();
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnVentas.add(mntmListaFactura);

		JMenuItem mntmFacturar = new JMenuItem("Facturar");
		mntmFacturar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		mntmFacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facturar factura = new Facturar();
				factura.setModal(true);
				factura.setVisible(true);
			}
		});
		mnVentas.add(mntmFacturar);

		JMenu mnAdmin = new JMenu("Administracion");
		mnAdmin.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		if(!Tienda.getLoginUser().getTipo().equalsIgnoreCase("Administrador")){
			mnAdmin.setEnabled(false);
		}
		menuBar.add(mnAdmin);

		JMenuItem mntmReporte = new JMenuItem("Reporte");
		mntmReporte.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		mntmReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*if(!Control.getLoginUser().getTipo().equalsIgnoreCase("Administrador")){
					mnAdministracin.setEnabled(false);
				}*/
				Reporte reporte = new Reporte();
				reporte.setModal(true);
				reporte.setVisible(true);
			}
		});
		
		JMenuItem mntmRegistarUser = new JMenuItem("Registar User");
		mntmRegistarUser.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		mntmRegistarUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				regUser reg= new regUser();
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		mnAdmin.add(mntmRegistarUser);
		
		JMenuItem mntmL = new JMenuItem("Listado User");
		mntmL.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		mntmL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				ListadoUser reg= new ListadoUser ();
				reg.setModal(true);
				reg.setVisible(true);
				
				
			}
		});
		mnAdmin.add(mntmL);
		mnAdmin.add(mntmReporte);
		
		JMenu mnNewMenu = new JMenu("Respaldo");
		mnNewMenu.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Respaldar");
		mntmNewMenuItem_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
			    {
			      sfd = new Socket("127.0.0.1",7000);
			       DataInputStream aux=new DataInputStream(new FileInputStream(new File("empresa.dat")));
			     // EntradaSocket = new DataInputStream(new FileInputStream(sfd.getInputStream()));
			      SalidaSocket = new DataOutputStream((sfd.getOutputStream()));
			      String ejemplo = new String("Esto es una prueba nueva");
			      int unByte;
			      try
			      {
			        //SalidaSocket.writeUTF(ejemplo);
			       // SalidaSocket.flush();
			    	  
			    	  while((unByte=aux.read()) != -1) {
			    		  SalidaSocket.write(unByte);
			          	SalidaSocket.flush();
			          	}
			      }
			      catch (IOException ioe)
			      {
			        System.out.println("Error: "+ioe);
			      }
			    }
			    catch (UnknownHostException uhe)
			    {
			      System.out.println("No se puede acceder al servidor.");
			      System.exit(1);
			    }
			    catch (IOException ioe)
			    {
			      System.out.println("Comunicación rechazada.");
			      System.exit(1);
			    }
				
				
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JLabel labelfondo = new JLabel("Fondo");
		labelfondo.setSize(1920, 1080);
		ImageIcon imagen=new ImageIcon("Imagenes/81042.jpg");
		Icon imagenIcon=new ImageIcon(imagen.getImage().getScaledInstance(labelfondo.getWidth(), labelfondo.getHeight(), Image.SCALE_DEFAULT));
		labelfondo.setIcon(imagenIcon);
		
		
		
		labelfondo.setBounds(-36, -79, 550, 434);
		contentPane.add(labelfondo);
	}

}
