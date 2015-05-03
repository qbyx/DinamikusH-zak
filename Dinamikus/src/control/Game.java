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

	public Game(int attributeCount, int houseCount, GameLoader gameLoader) {
		this.gameLoader = gameLoader;
		this.attributeCount = attributeCount;
		this.houseCount = houseCount;

		attributes = new Attribute[attributeCount * houseCount];
		attributeCategories = new AttributeCategory[attributeCount];

		gameData = gameLoader.getAttributes();
		Color[] gameColors = { Color.yellow, Color.red, Color.black,
				Color.cyan, Color.blue, Color.lightGray, Color.magenta,
				Color.orange };
		// 5
		for (int i = 0; i < gameData.length; i++) {
			attributeCategories[i] = new AttributeCategory(gameData[i][0],
					gameColors[i]);
			for (int j = 0; j < gameData[0].length; j++) {
				attributes[i * (gameData[i].length) + j] = new Attribute(
						gameData[i][j], attributeCategories[i]);
				System.out.println(i * gameData[i].length);
			}
			System.out.println();
		}
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
