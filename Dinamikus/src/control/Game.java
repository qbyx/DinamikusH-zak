package control;

import java.awt.Color;

public class Game {

	private int attributeCount;
	private int houseCount;
	private Attribute[] attributes;
	private AttributeCategory[] attributeCategories;

	public Game(int attributeCount, int houseCount) {
		this.attributeCount = attributeCount;
		this.houseCount = houseCount;

		attributes = new Attribute[attributeCount * houseCount];
		attributeCategories = new AttributeCategory[attributeCount];

		// 5
		attributeCategories[0] = new AttributeCategory("asdf", Color.yellow);
		attributeCategories[1] = new AttributeCategory("asdf", Color.red);
		attributeCategories[2] = new AttributeCategory("asdf", Color.black);
		attributeCategories[3] = new AttributeCategory("asdf", Color.cyan);
		attributeCategories[4] = new AttributeCategory("asdf", Color.blue);

		// harqoded
		// 1
		attributes[0] = new Attribute("somename", attributeCategories[0]);
		attributes[1] = new Attribute("somename", attributeCategories[0]);
		attributes[2] = new Attribute("somename", attributeCategories[0]);
		attributes[3] = new Attribute("somename", attributeCategories[0]);
		attributes[4] = new Attribute("somename", attributeCategories[0]);
		attributes[5] = new Attribute("somename", attributeCategories[1]);
		attributes[6] = new Attribute("somename", attributeCategories[1]);
		attributes[7] = new Attribute("somename", attributeCategories[1]);
		attributes[8] = new Attribute("somename", attributeCategories[1]);
		attributes[9] = new Attribute("somename", attributeCategories[1]);
		attributes[10] = new Attribute("somename", attributeCategories[2]);
		attributes[11] = new Attribute("somename", attributeCategories[2]);
		attributes[12] = new Attribute("somename", attributeCategories[2]);
		attributes[13] = new Attribute("somename", attributeCategories[2]);
		attributes[14] = new Attribute("somename", attributeCategories[2]);
		attributes[15] = new Attribute("somename", attributeCategories[3]);
		attributes[16] = new Attribute("somename", attributeCategories[3]);
		attributes[17] = new Attribute("somename", attributeCategories[3]);
		attributes[18] = new Attribute("somename", attributeCategories[3]);
		attributes[19] = new Attribute("somename", attributeCategories[3]);
		attributes[20] = new Attribute("somename", attributeCategories[4]);
		attributes[21] = new Attribute("somename", attributeCategories[4]);
		attributes[22] = new Attribute("somename", attributeCategories[4]);
		attributes[23] = new Attribute("somename", attributeCategories[4]);
		attributes[24] = new Attribute("somename", attributeCategories[4]);
	}

	public int getAttributeCount() {
		return attributeCount;
	}

	public void setAttributeCount(int attributeCount) {
		this.attributeCount = attributeCount;
	}

	public int getHouseCount() {
		return houseCount;
	}

	public void setHouseCount(int houseCount) {
		this.houseCount = houseCount;
	}

	public AttributeCategory[] getAttributeCategories() {
		return attributeCategories;
	}

	public void setAttributeCategories(AttributeCategory[] attributeCategories) {
		this.attributeCategories = attributeCategories;
	}

	public Attribute[] getAttributes() {
		return attributes;
	}

	public void setAttributes(Attribute[] attributes) {
		this.attributes = attributes;
	}

}
