package control;

import gui.MainFrame;
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
	private String[] categorys;
	private String[][] constrainsList;
	private int constrainsNumber;

	public Game(MainFrame mainFrame) {
		gameLoader = mainFrame.getGameLoader();
		attributeCount = mainFrame.getAttributeCount();
		houseCount = mainFrame.getHouseCount();

		attributes = new Attribute[attributeCount * houseCount];
		attributeCategories = new AttributeCategory[attributeCount];

		categorys = gameLoader.getCategorys();
		constrainsNumber = gameLoader.getConstrainsNumber();
		constrainsList = gameLoader.getConstrains();
		gameData = gameLoader.getAttributes();
		Color[] gameColors = { Color.yellow, Color.red, Color.black,
				Color.cyan, Color.blue, Color.lightGray, Color.magenta,
				Color.orange };

		for (int i = 0; i < gameData.length; i++) {
			attributeCategories[i] = new AttributeCategory(categorys[i],
					gameColors[i], i);
			for (int j = 0; j < gameData[0].length; j++) {
				attributes[i * (gameData[i].length) + j] = new Attribute(
						gameData[i][j], attributeCategories[i]);
				// System.out.println(i * gameData[i].length);
			}
			System.out.println();
		}

		// hard coded constrains
		LoadContrains();

	}

	private void LoadContrains() {
		constrains = new Constrain[constrainsNumber];
		for (int i = 0; i < constrainsNumber; i++) {
			switch (constrainsList[i][1]) {
			case "=":
				try {
					constrains[i] = new Positional(
							getAttributeByName(constrainsList[i][0]),
							Integer.parseInt(constrainsList[i][2]) - 1);
					System.out.println("constrains " + constrainsList[i][0]
							+ " " + constrainsList[i][2]);
				} catch (NumberFormatException e) {
					constrains[i] = new Equals(
							getAttributeByName(constrainsList[i][0]),
							getAttributeByName(constrainsList[i][2]));
				}
				break;
			case "!=":
				constrains[i] = new Negate(new Equals(
						getAttributeByName(constrainsList[i][0]),
						getAttributeByName(constrainsList[i][2])));
				break;
			case "<>":
				constrains[i] = new Neighbor(
						getAttributeByName(constrainsList[i][0]),
						getAttributeByName(constrainsList[i][2]));
				break;
			case "!<>":
				constrains[i] = new Negate(new Neighbor(
						getAttributeByName(constrainsList[i][0]),
						getAttributeByName(constrainsList[i][2])));
				break;
			default:
				break;
			}
		}
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
