package frame;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class JPanelBackground extends JFrame {

	private JPanel contentPane;

	// Atributo que guardara la imagen de Background que le pasemos.
	private Image background;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPanelBackground frame = new JPanelBackground();
					frame.setVisible(true);
					frame.setBackground("/assets/img/LogoNba.png");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public JPanelBackground() {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(JPanelBackground.class.getResource("/assets/img/IconNBA.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}


	// Metodo donde le pasaremos la dirección de la imagen a cargar.
	public void setBackground(String imagePath) {

		// Construimos la imagen y se la asignamos al atributo background.
		this.setOpacity(0);
		this.background = new ImageIcon(imagePath).getImage();
		repaint();
	}
}
