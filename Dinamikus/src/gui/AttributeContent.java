package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controll.AttributeCategory;

public class AttributeContent extends JPanel {
	
	private String text;
	private AttributeCategory attrCategory;
	
	public AttributeCategory getAttrCategory() {
		return attrCategory;
	}

	public void setAttrCategory(AttributeCategory attrCategory) {
		this.attrCategory = attrCategory;
	}
	
	public AttributeContent(AttributeCategory attrCategory) {
		this.attrCategory = attrCategory;
	}
	
	public AttributeContent(AttributeCategory attrCategory, String text) {
		add(new JLabel(text));
		setBackground(attrCategory.getColor());

		this.attrCategory = attrCategory;
	}
	
}
