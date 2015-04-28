package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import controll.AttributeCategory;

public class House extends JPanel {
	
	static final private int PADDING = 10;
	static final private int BOARDER_THICKNESS = 6;
	
	private AttributeCategory attrCategories[];
	
	//private Attributes;

	public House(AttributeCategory attrCategories[]) {
		super(new GridLayout(((attrCategories.length - 1) / 2) + 1, 2, 8, 8));
		
		setBorder(new CompoundBorder(
				BorderFactory.createLineBorder(Color.black, BOARDER_THICKNESS),
				new EmptyBorder(PADDING, PADDING, PADDING, PADDING))
		);
		
		for (AttributeCategory ac : attrCategories) {
			add(new AttributeBorder(ac));
		}
		
	}
	
	
	
}
