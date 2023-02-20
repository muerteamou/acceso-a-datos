package frames;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tools.DepInsert;
import tools.DepartamentoVista;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTextPane;

public class FraDepartamentos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField noDptoTF;
	private JTextField nombreDptoTF;
	private JMenuBar menuBar;
	private JTextField locDptoTF;

	ArrayList<ArrayList> depEmp;

	ArrayList<String> empList;
	ArrayList<String> depList;

	DepartamentoVista dptoVista;
	DepInsert newDep;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FraDepartamentos frame = new FraDepartamentos();
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

	public FraDepartamentos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		menuBar = new JMenuBar();
		menuBar.setToolTipText("Archivo");
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Menú");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Departamentos");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Empleados");
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.blue);
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel noDptoLabel = new JLabel("Nº departamento");
		noDptoLabel.setBounds(10, 14, 105, 14);
		contentPane.add(noDptoLabel);

		JLabel nombreDptoLabel = new JLabel("Nombre");
		nombreDptoLabel.setBounds(10, 45, 105, 14);
		contentPane.add(nombreDptoLabel);

		noDptoTF = new JTextField();
		noDptoTF.setBounds(125, 11, 86, 20);
		contentPane.add(noDptoTF);
		noDptoTF.setColumns(10);

		nombreDptoTF = new JTextField();
		nombreDptoTF.setColumns(10);
		nombreDptoTF.setBounds(125, 42, 86, 20);
		contentPane.add(nombreDptoTF);

		locDptoTF = new JTextField();
		locDptoTF.setColumns(10);
		locDptoTF.setBounds(125, 73, 86, 20);
		contentPane.add(locDptoTF);

		JLabel locDptoLabel = new JLabel("Localidad");
		locDptoLabel.setBounds(10, 76, 105, 14);
		contentPane.add(locDptoLabel);

		JTextArea taEmpList = new JTextArea();
		taEmpList.setBounds(221, 9, 203, 219);
		contentPane.add(taEmpList);

		JButton btnBuscarDpto = new JButton("Buscar");
		btnBuscarDpto.setBounds(10, 205, 89, 23);
		contentPane.add(btnBuscarDpto);
		btnBuscarDpto.addActionListener(new ActionListener() {

			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				dptoVista = new DepartamentoVista();
				depEmp = dptoVista.verDptoInterfaz(Integer.valueOf(noDptoTF.getText()));
				depList = depEmp.get(0);
				empList = depEmp.get(1);
				nombreDptoTF.setText(depList.get(0));
				locDptoTF.setText(depList.get(1));
			}
		});

		JButton btnInserDpto = new JButton("Crear");
		btnInserDpto.setBounds(125, 205, 89, 23);
		contentPane.add(btnInserDpto);
		btnInserDpto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int numDep = Integer.valueOf(noDptoTF.getText());
				String nomDep, locDep;
				nomDep = nombreDptoTF.getText();
				locDep = locDptoTF.getText();
				System.out.println(numDep);
				System.out.println(nomDep);
				System.out.println(locDep);
				newDep = new DepInsert();
				//newDep.insertarDepartamento();
				newDep.insDepart(numDep, nomDep, locDep);
			}
		});

	}
}
