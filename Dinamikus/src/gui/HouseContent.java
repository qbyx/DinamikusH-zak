package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import control.AttributeCategory;

public class HouseContent extends JPanel {

	private static final long serialVersionUID = -7422863894753507568L;
	static final private int PADDING = 10;
	static final private int BOARDER_THICKNESS = 6;
	static final private int GAP_SIZE = 8;

	private AttributeBorder borders[];
	int houseIndex;

	public AttributeBorder[] getBorders() {
		return borders;
	}

	public void setBorders(AttributeBorder[] borders) {
		this.borders = borders;
	}

	public HouseContent(AttributeCategory attrCategories[], int houseIndex) {
		super(new GridLayout(((attrCategories.length - 1) / 2) + 1, 2,
				GAP_SIZE, GAP_SIZE));

		this.houseIndex = houseIndex;

		setBorder(new CompoundBorder(BorderFactory.createLineBorder(
				Color.black, BOARDER_THICKNESS), new EmptyBorder(PADDING,
				PADDING, PADDING, PADDING)));

		borders = new AttributeBorder[attrCategories.length];
		for (int i = 0; i < attrCategories.length; ++i) {
			borders[i] = new AttributeBorder(attrCategories[i], this.houseIndex);
			System.out.println("houseindex: " + houseIndex);
			add(borders[i]);
		}
	}

}
