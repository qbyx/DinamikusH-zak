package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import draganddrop.DraggableImageComponent;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel Panel1, Panel2;
	private final int Width = 1366, Height = 728;

	public MainFrame() {
		setLayout(new BorderLayout());
		setBounds(0, 0, Width, Height);

		setTitle("Paint");
		setVisible(true);
		setResizable(false);

		Panel1 = new JPanel();
		Panel1.setBackground(Color.darkGray);
		Panel1.setPreferredSize(new Dimension(1, 300));
		Panel1.setLayout(null);
		Panel1.setSize(1000,1000);
		add(Panel1, BorderLayout.CENTER);

		Panel2 = new JPanel();
		Panel2.setBackground(Color.RED);
		Panel2.setPreferredSize(new Dimension(200, 1));
		add(Panel2, BorderLayout.EAST);

		JButton bb = new JButton("fdsfds");
		bb.setBounds(50, 50, 40, 100);
		Panel1.add(bb);
		System.out.println(Panel1.getSize());
		addWindowListener(listener);
		loadPhotos();
	}

	public void loadPhotos() {
		Panel1.removeAll();
		for (int i = 1; i <= 10; i++) {
			String fileName = String.valueOf(i) + ".jpg";
			addNewPhoto(fileName);
		}
		Panel1.repaint();
	}

	public void addNewPhoto(String fileName) {
		// Get resources from Directory or Jar file
		Image img = Toolkit.getDefaultToolkit().createImage(
				"Images/" + fileName);

		// Creates a draggableImageComponent and adds loaded image
		DraggableImageComponent photo = new DraggableImageComponent();
		Panel1.add(photo);// Adds this component to main container
		photo.setImage(img);// Sets image
		photo.setAutoSize(true);// The component get ratio w/h of source image
		photo.setOverbearing(true);// On click ,this panel gains lowest z-buffer
		photo.setBorder(new LineBorder(Color.black, 1));

		// A small randomization of object size/position
		photo.setSize(100, 100);
		Point p = getRandomPoint((int) (Width
				- Panel2.getPreferredSize().getWidth() - photo.getSize()
				.getWidth()), (int) (Height / 2 - photo.getSize().getHeight()));
		p.y += Height / 2;
		photo.setLocation(p);
		
		img = Toolkit.getDefaultToolkit().createImage(
				"Images/" + "haz.jpg");
		photo = new DraggableImageComponent();
		Panel1.add(photo);// Adds this component to main container
		photo.setImage(img);// Sets image
		photo.setAutoSize(true);// The component get ratio w/h of source image
		photo.setOverbearing(true);// On click ,this panel gains lowest z-buffer
		photo.setBorder(new LineBorder(Color.black, 1));
		photo.setSize(360, 360);
		photo.setLocation(40, 40);
		photo.setDraggable(false);
		Panel1.repaint();
	}

	public static int getRandom(int range) {
		int r = (int) (Math.random() * range) - range;
		return r;
	}

	public static Point getRandomPoint(int MaxWidth, int MaxHeight) {
		Point p = new Point();
		p.x = (int) (Math.random() * MaxWidth);
		p.y = (int) (Math.random() * MaxHeight);
		return p;
	}

	WindowListener listener = new WindowAdapter() {
		public void windowClosing(WindowEvent we) {
			System.exit(0);
		}
	};
}
