package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Attribute;
import control.AttributeCategory;
import control.Game;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 6270545319112969177L;
	private House houses[];
	private JPanel housePanel;
	private JPanel actionPanel;
	private JPanel attributePanel;

	private AttributeContent attributesConents[];
	int houseCount = 5;
	int attributeCount = 5;
	// QQQ
	private AttributeBorder attributeBorders[];

	public MainFrame() {

		attributesConents = new AttributeContent[attributeCount * houseCount];
		attributeBorders = new AttributeBorder[attributeCount * houseCount];
		Game game = new Game(attributeCount, houseCount);

		setLayout(new BorderLayout());
		setSize(1300, 700);

		buildHousePanel(houseCount, game.getAttributeCategories());

		buildActionPanel();

		buildAttributePanel();

		repaint();
		setVisible(true);

		dropAttributes(game.getAttributes());
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
			// QQQ
			for (int j = 0; j < attributeCount; ++j) {
				attributeBorders[i * attributeCount + j] = houses[i]
						.getBorders()[j];
			}
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
		attributePanel.setPreferredSize(new Dimension(1, 300));

		getContentPane().add(attributePanel, BorderLayout.SOUTH);
	}

	public void dropAttributes(Attribute[] attr) {
		JPanel glassPanel = (JPanel) getGlassPane();
		glassPanel.setBorder(new EmptyBorder(400, 0, 0, 0));

		for (int i = 0; i < attr.length; ++i) {
			attributesConents[i] = new AttributeContent(attr[i],
					attributeBorders);

			glassPanel.add(attributesConents[i]);
		}

		glassPanel.setVisible(true);
	}

}
