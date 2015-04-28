package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import draganddrop.DraggableImageComponent;
import controll.AttributeCategory;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel Panel1, Panel2, Panel3;
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
		Panel1.setPreferredSize(new Dimension(300,200));
		add(Panel1, BorderLayout.SOUTH);
		
		AttributeCategory attrCat[] = new AttributeCategory[3];
		{
			attrCat[0] = new AttributeCategory("auto", Color.blue);
			attrCat[1] = new AttributeCategory("auto", Color.gray);
			attrCat[2] = new AttributeCategory("kedvenc cuni", Color.red);

			AttributeContent tryfirst = new AttributeContent(attrCat[0], "asdf");
			AttributeContent tryfirst2 = new AttributeContent(attrCat[0], "a234");
			AttributeContent tryfirst3 = new AttributeContent(attrCat[0], ", asdfaaa");
			AttributeContent tryfirst4 = new AttributeContent(attrCat[1], "asdfsdfa");
//			tryfirst.addMouseListener(new MouseAdapter() {
//					public void mousePressed(MouseEvent me) { 
//						System.out.println(me); 
//					}
//			}); 
			Panel1.add(tryfirst);
			Panel1.add(tryfirst2);
			Panel1.add(tryfirst3);
			Panel1.add(tryfirst4);
		}

		Panel2 = new JPanel();
		Panel2.setBackground(Color.RED);
		Panel2.setPreferredSize(new Dimension(200, 1));
		add(Panel2, BorderLayout.EAST);

		System.out.println(Panel1.getSize());
		addWindowListener(listener);
		loadPhotos();
		
		
		
		Panel3 = new JPanel(new GridLayout(1, 4, 10, 10));
		Panel3.setBackground(Color.WHITE);
		Panel3.setBorder(BorderFactory.createEmptyBorder());

		{
			Panel3.add(new House(attrCat));
			Panel3.add(new House(attrCat));
			Panel3.add(new House(attrCat));
			Panel3.add(new House(attrCat));
		}
		add(Panel3, BorderLayout.CENTER);
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
//		p.y += Height / 2;
		photo.setLocation(p);

//		img = Toolkit.getDefaultToolkit().createImage(
//				"Images/" + "haz.jpg");
//		photo = new DraggableImageComponent();
//		Panel1.add(photo);// Adds this component to main container
//		photo.setImage(img);// Sets image
//		photo.setAutoSize(true);// The component get ratio w/h of source image
//		photo.setOverbearing(true);// On click ,this panel gains lowest z-buffer
//		photo.setBorder(new LineBorder(Color.black, 1));
//		photo.setSize(360, 360);
//		photo.setLocation(40, 40);
//		photo.setDraggable(false);
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
