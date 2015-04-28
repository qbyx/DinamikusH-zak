package gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controll.AttributeCategory;

public class AttributeBorder extends JPanel {
	
	static final public int THICKNESS = 4;
	
	private AttributeContent attrContent;
	private AttributeCategory attrCategory;
	
	public AttributeCategory getAttrCategory() {
		return attrCategory;
	}

	public void setAttrCategory(AttributeCategory attrCategory) {
		this.attrCategory = attrCategory;
	}

	public AttributeContent getAttrContent() {
		return attrContent;
	}

	public void setAttrContent(AttributeContent attrContent) {
		this.attrContent = attrContent;
	}

	public AttributeBorder(AttributeCategory attrCategory) {
		super(null);
		
		this.attrCategory = attrCategory;
		
		setBorder(BorderFactory.createLineBorder(attrCategory.getColor(), THICKNESS));
		attrContent = new AttributeContent(attrCategory);
		add(attrContent);
	}

}
