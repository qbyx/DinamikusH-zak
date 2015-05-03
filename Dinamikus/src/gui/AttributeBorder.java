package gui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import control.AttributeCategory;

public class AttributeBorder extends JPanel {

	private static final long serialVersionUID = 3246428149613626754L;

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

		setBorder(new CompoundBorder(new LineBorder(Color.black),
				new LineBorder(attrCategory.getColor(), THICKNESS)));
	}

}
