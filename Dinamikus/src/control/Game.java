package control;

import io.GameLoader;

import java.awt.Color;

public class Game {

	private int attributeCount;
	private int houseCount;
	private Attribute[] attributes;
	private AttributeCategory[] attributeCategories;
	private GameLoader gameLoader;
	private String[][] gameData;
	private Constrain constrains[];

	public Game(int attributeCount, int houseCount, GameLoader gameLoader,
			Constrain[] constrains) {
		this.gameLoader = gameLoader;
		this.attributeCount = attributeCount;
		this.houseCount = houseCount;

		attributes = new Attribute[attributeCount * houseCount];
		attributeCategories = new AttributeCategory[attributeCount];

		gameData = gameLoader.getAttributes();
		Color[] gameColors = { Color.yellow, Color.red, Color.black,
				Color.cyan, Color.blue, Color.lightGray, Color.magenta,
				Color.orange };

		for (int i = 0; i < gameData.length; i++) {
			attributeCategories[i] = new AttributeCategory(gameData[i][0],
					gameColors[i], i);
			for (int j = 0; j < gameData[0].length; j++) {
				attributes[i * (gameData[i].length) + j] = new Attribute(
						gameData[i][j], attributeCategories[i]);
				System.out.println(i * gameData[i].length);
			}
			System.out.println();
		}

		// hard coded constrains
		this.constrains = new Constrain[7];

		this.constrains[0] = new Equals(getAttributeByName("Dán"), getAttributeByName("Tea"));
		this.constrains[1] = new MiddlePosition(getAttributeByName("Kutya"));
		//this.constrains[1] = new Positional(getAttributeByName("Kutya"), 1);
		this.constrains[2] = new EqualsByIndex(getAttributeByName("Tej"), 0);
		this.constrains[3] = new Negate(new Neighbor(getAttributeByName("Zöld"), getAttributeByName("Kék")));
		this.constrains[4] = new Neighbor(getAttributeByName("Zöld"), getAttributeByName("Angol"));
		this.constrains[5] = new Equals(getAttributeByName("Kecske"), getAttributeByName("Kék"));
		this.constrains[6] = new Negate(new Equals(getAttributeByName("Kék"), getAttributeByName("Tej")));
	}

	public Constrain[] getConstrains() {
		return constrains;
	}

	public void setConstrains(Constrain[] constrains) {
		this.constrains = constrains;
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
	
	public Attribute getAttributeByName(String attrName) {
		for (Attribute a : attributes) {
			if (a.getName().equals(attrName)) {
				System.out.println("found");
				return a;
			}
		}

		return null;
	}

}
