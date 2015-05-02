package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.Attribute;
import control.AttributeCategory;
import control.Game;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private House houses[];
	private JPanel housePanel;
	private JPanel actionPanel;
	private JPanel attributePanel;
	private AttributeContent attributes[];

	public MainFrame() {
		//
		int houseCount = 5;
		int attributeCount = 5;
		attributes = new AttributeContent[attributeCount * houseCount];
		Game game = new Game(attributeCount, houseCount);

		setLayout(new BorderLayout());
		setSize(1200, 600);

		buildHousePanel(houseCount, game.getAttributeCategories());

		buildActionPanel();

		buildAttributePanel();

		dropAttributes(game.getAttributes());

		repaint();
		setVisible(true);
	}

	public void buildHousePanel(int houseCount,
			AttributeCategory[] attributeCategories) {
		housePanel = new JPanel(new GridLayout(1, houseCount, 10, 10));

		housePanel.setBackground(Color.WHITE);
		housePanel.setBorder(BorderFactory.createEmptyBorder());

		houses = new House[houseCount];
		for (int i = 0; i < houseCount; ++i) {
			houses[i] = new House(attributeCategories);
			housePanel.add(houses[i]);
		}

		getContentPane().add(housePanel, BorderLayout.CENTER);
	}

	public void buildActionPanel() {
		actionPanel = new JPanel(null);

		actionPanel.setBackground(Color.RED);
		actionPanel.setPreferredSize(new Dimension(200, 1));

		getContentPane().add(actionPanel, BorderLayout.EAST);
	}

	public void buildAttributePanel() {
		attributePanel = new JPanel(new FlowLayout());

		attributePanel.setBackground(Color.green);
		attributePanel.setPreferredSize(new Dimension(1, 200));

		getContentPane().add(attributePanel, BorderLayout.SOUTH);
	}

	public void dropAttributes(Attribute[] attr) {
		JPanel glassPanel = (JPanel) getGlassPane();

		for (int i = 0; i < attr.length; ++i) {
			attributes[i] = new AttributeContent(attr[i]);

			glassPanel.add(attributes[i]);
		}

		glassPanel.setVisible(true);
	}

	// public void loadPhotos() {
	// Panel1.removeAll();
	// for (int i = 1; i <= 10; i++) {
	// String fileName = String.valueOf(i) + ".jpg";
	// addNewPhoto(fileName);
	// }
	// Panel1.repaint();
	// }
	//
	// public void addNewPhoto(String fileName) {
	// // Get resources from Directory or Jar file
	// Image img = Toolkit.getDefaultToolkit().createImage(
	// "Images/" + fileName);
	//
	// // Creates a draggableImageComponent and adds loaded image
	// DraggableImageComponent photo = new DraggableImageComponent();
	// Panel1.add(photo);// Adds this component to main container
	// photo.setImage(img);// Sets image
	// photo.setAutoSize(true);// The component get ratio w/h of source image
	// photo.setOverbearing(true);// On click ,this panel gains lowest z-buffer
	// photo.setBorder(new LineBorder(Color.black, 1));
	//
	// // A small randomization of object size/position
	// photo.setSize(100, 100);
	// Point p = getRandomPoint((int) (Width
	// - Panel2.getPreferredSize().getWidth() - photo.getSize()
	// .getWidth()), (int) (Height / 2 - photo.getSize().getHeight()));
	// // p.y += Height / 2;
	// photo.setLocation(p);
	//
	// // img = Toolkit.getDefaultToolkit().createImage(
	// // "Images/" + "haz.jpg");
	// // photo = new DraggableImageComponent();
	// // Panel1.add(photo);// Adds this component to main container
	// // photo.setImage(img);// Sets image
	// // photo.setAutoSize(true);// The component get ratio w/h of source image
	// // photo.setOverbearing(true);// On click ,this panel gains lowest
	// z-buffer
	// // photo.setBorder(new LineBorder(Color.black, 1));
	// // photo.setSize(360, 360);
	// // photo.setLocation(40, 40);
	// // photo.setDraggable(false);
	// Panel1.repaint();
	// }
	//
	// public static int getRandom(int range) {
	// int r = (int) (Math.random() * range) - range;
	// return r;
	// }
	//
	// public static Point getRandomPoint(int MaxWidth, int MaxHeight) {
	// Point p = new Point();
	// p.x = (int) (Math.random() * MaxWidth);
	// p.y = (int) (Math.random() * MaxHeight);
	// return p;
	// }
	//
	// WindowListener listener = new WindowAdapter() {
	// public void windowClosing(WindowEvent we) {
	// System.exit(0);
	// }
	// };
}
