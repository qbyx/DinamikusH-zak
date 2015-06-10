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
	private int houseIndex;

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

	public int getHouseIndex() {
		return houseIndex;
	}

	public void setHouseIndex(int houseIndex) {
		this.houseIndex = houseIndex;
	}

	public AttributeBorder(AttributeCategory attrCategory, int houseIndex) {
		super(null);

		this.attrCategory = attrCategory;
		this.houseIndex = houseIndex;

		setBorder(new CompoundBorder(new LineBorder(Color.black),
				new LineBorder(attrCategory.getColor(), THICKNESS)));
	}

	public void loadAttributeContent(AttributeContent ac) {
		System.out.println("aasdfasdf" + ac);
		if (ac != null) {
			ac.setLocation((int) (getLocationOnScreen().getX() - ac.getParent()
					.getLocationOnScreen().getX()), (int) (getLocationOnScreen()
							.getY() - ac.getParent().getLocationOnScreen().getY()));

			ac.setHiPlaced(getHouseIndex());
			ac.setCatiPlaced(ac.getAttr().getAttributeCategory().getIndex());
			System.out.println(ac.getName());
		}
		else {
			//setVisible(false);
			System.out.println("null");
		}
	}

}
