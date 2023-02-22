package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

import tools.EquipoVistaQuery;

public class Programa {

	private JFrame frame;
	private JTextField tfNombre;
	private JTextField tfCiudad;
	private JTextField tfConf;
	private JTextField tfDiv;
	private JTextField tfBuscar;
	private JTextField tfDetalleDiv;
	private JTextField tfDetalleConf;
	private JTextField tfDetalleCiudad;
	private JTextField tfDetalleNombre;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Programa window = new Programa();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Programa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 675);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel jPaneDatos = new JPanel();
		jPaneDatos.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jPaneDatos.setBounds(10, 10, 1166, 300);
		frame.getContentPane().add(jPaneDatos);
		jPaneDatos.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(719, 24, 437, 266);
		jPaneDatos.add(panel);
		panel.setBorder(new TitledBorder(null, "Operaciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);

		JButton btnAnyadir = new JButton("Añadir");
		btnAnyadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAnyadir.setIcon(new ImageIcon(Programa.class.getResource("/icons/agregar-carpeta.png")));
		btnAnyadir.setFont(new Font("Verdana", Font.BOLD, 14));
		btnAnyadir.setBounds(170, 110, 125, 25);

		panel.add(btnAnyadir);

		JButton btnMod = new JButton("Modificar");
		btnMod.setIcon(new ImageIcon(Programa.class.getResource("/icons/editar-alt.png")));
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMod.setFont(new Font("Verdana", Font.BOLD, 14));
		btnMod.setBounds(170, 145, 125, 25);
		panel.add(btnMod);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(Programa.class.getResource("/icons/carpeta-menos.png")));
		btnEliminar.setFont(new Font("Verdana", Font.BOLD, 14));
		btnEliminar.setBounds(170, 180, 125, 25);
		panel.add(btnEliminar);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(Programa.class.getResource("/icons/busqueda.png")));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnBuscar ) {
					EquipoVistaQuery equipoVistaQuery = new EquipoVistaQuery();
					equipoVistaQuery.mostrarEquipo(tfBuscar.getText());
				}
			}
		});
		btnBuscar.setFont(new Font("Verdana", Font.BOLD, 14));
		btnBuscar.setBounds(170, 75, 125, 25);
		panel.add(btnBuscar);

		tfBuscar = new JTextField();
		tfBuscar.setFont(new Font("Verdana", Font.BOLD, 14));
		tfBuscar.setBounds(170, 40, 100, 25);
		panel.add(tfBuscar);
		tfBuscar.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Ingresar Equipo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 24, 699, 266);
		jPaneDatos.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNombre.setBounds(10, 40, 110, 25);
		panel_1.add(lblNombre);

		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setFont(new Font("Verdana", Font.BOLD, 12));
		lblCiudad.setBounds(10, 75, 110, 25);
		panel_1.add(lblCiudad);

		JLabel lblConf = new JLabel("Conferencia:");
		lblConf.setFont(new Font("Verdana", Font.BOLD, 12));
		lblConf.setBounds(10, 110, 110, 25);
		panel_1.add(lblConf);

		JLabel lblDiv = new JLabel("División:");
		lblDiv.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDiv.setBounds(10, 145, 110, 25);
		panel_1.add(lblDiv);

		tfNombre = new JTextField();
		tfNombre.setBounds(150, 40, 150, 25);
		panel_1.add(tfNombre);
		tfNombre.setColumns(10);

		tfCiudad = new JTextField();
		tfCiudad.setColumns(10);
		tfCiudad.setBounds(150, 75, 150, 25);
		panel_1.add(tfCiudad);

		tfConf = new JTextField();
		tfConf.setColumns(10);
		tfConf.setBounds(150, 110, 150, 25);
		panel_1.add(tfConf);

		tfDiv = new JTextField();
		tfDiv.setColumns(10);
		tfDiv.setBounds(150, 145, 150, 25);
		panel_1.add(tfDiv);

		JPanel jPaneDetalle = new JPanel();
		jPaneDetalle.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Detalle",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		jPaneDetalle.setBounds(10, 328, 1166, 300);
		frame.getContentPane().add(jPaneDetalle);
		jPaneDetalle.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Equipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 22, 350, 268);
		jPaneDetalle.add(panel_2);
		panel_2.setLayout(null);

		tfDetalleDiv = new JTextField();
		tfDetalleDiv.setColumns(10);
		tfDetalleDiv.setBounds(150, 134, 150, 25);
		panel_2.add(tfDetalleDiv);

		JLabel lblDetalleDiv = new JLabel("División:");
		lblDetalleDiv.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDetalleDiv.setBounds(10, 134, 110, 25);
		panel_2.add(lblDetalleDiv);

		JLabel lblDetalleConf = new JLabel("Conferencia:");
		lblDetalleConf.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDetalleConf.setBounds(10, 99, 110, 25);
		panel_2.add(lblDetalleConf);

		tfDetalleConf = new JTextField();
		tfDetalleConf.setColumns(10);
		tfDetalleConf.setBounds(150, 99, 150, 25);
		panel_2.add(tfDetalleConf);

		tfDetalleCiudad = new JTextField();
		tfDetalleCiudad.setColumns(10);
		tfDetalleCiudad.setBounds(150, 64, 150, 25);
		panel_2.add(tfDetalleCiudad);

		JLabel lblDetalleCiudad = new JLabel("Ciudad:");
		lblDetalleCiudad.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDetalleCiudad.setBounds(10, 64, 110, 25);
		panel_2.add(lblDetalleCiudad);

		JLabel lblDetalleNombre = new JLabel("Nombre:");
		lblDetalleNombre.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDetalleNombre.setBounds(10, 29, 110, 25);
		panel_2.add(lblDetalleNombre);

		tfDetalleNombre = new JTextField();
		tfDetalleNombre.setColumns(10);
		tfDetalleNombre.setBounds(150, 29, 150, 25);
		panel_2.add(tfDetalleNombre);

		table = new JTable();
		table.setBorder(new TitledBorder(null, "Jugadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, },
				new String[] { "C\u00F3digo", "Peso", "Altura", "Procedencia", "Nombre", "Posici\u00F3n" }));
		table.setBounds(370, 22, 468, 268);
		jPaneDetalle.add(table);
	}
}
