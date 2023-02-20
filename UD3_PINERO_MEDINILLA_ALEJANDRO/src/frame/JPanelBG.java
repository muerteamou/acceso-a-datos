package frame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Toolkit;

public class JPanelBG extends JFrame {
	public JPanelBG() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JPanelBG.class.getResource("/assets/img/IconNBA.png")));
	}

	public static void main(String args[]) {
		JFrame frame = new JFrame("Display an image in the background");
		final ImageIcon icon = new ImageIcon("assets/img/LogoNbaSmall.png");
		JTextArea text = new JTextArea() {
			Image img = icon.getImage();
			// instance initializer
			{
				setOpaque(false);
			}

			public void paintComponent(Graphics graphics) {
				graphics.drawImage(img, 0, 0, this);
				super.paintComponent(graphics);
			}
		};
		JScrollPane pane = new JScrollPane(text);
		Container content = frame.getContentPane();
		content.add(pane, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(3);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
}
