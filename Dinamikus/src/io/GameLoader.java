package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamCorruptedException;

public class GameLoader {
	private int attributeCount;
	private int houseCount;
	private String cat[][];
	private String categorys[];
	private String[][] attributes;
	private String[][] constrains;
	private int constrainsNumber;

	public GameLoader() {
	}

	public void setGame(int game) {
		Game(game);
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

	public void Game(int game) {
		switch (game) {
		case 3:
			FileReader("games/3.haz");
			break;
		case 5:
			FileReader("games/5.haz");
			break;
		case 7:
			FileReader("games/7.haz");
			break;
		case 1:
			System.out.println(1);
			break;
		default:
			FileReader("games/5.haz");
			break;
		}
	}

	public void FileReader(String fileName) {
		BufferedReader br = null;
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(fileName));
			attributeCount = Integer.parseInt(br.readLine());
			houseCount = Integer.parseInt(br.readLine());
			constrainsNumber = Integer.parseInt(br.readLine());
			cat = new String[attributeCount][houseCount + 1];
			for (int i = 0; i < attributeCount; i++) {
				sCurrentLine = br.readLine();
				cat[i] = sCurrentLine.split(" ");
			}
			constrains = new String[constrainsNumber][3];
			for (int i = 0; i < constrainsNumber; i++) {
				sCurrentLine = br.readLine();
				constrains[i] = sCurrentLine.split(" ");
			}
			// while ((sCurrentLine = br.readLine()) != null) {
			// cat[i] = sCurrentLine.split(" ");
			// i++;
			// }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		attributes = new String[attributeCount][houseCount];
		categorys = new String[attributeCount];
		for (int i = 0; i < attributeCount; i++) {
			categorys[i] = cat[i][0];
			for (int j = 1; j <= houseCount; j++) {
				attributes[i][j - 1] = cat[i][j];
			}
		}

		// for (int i = 0; i < contrainsNumber; i++) {
		// System.out.println();
		// for (int j = 0; j < 3; j++) {
		// System.out.print(contrains[i][j]+" ");
		// }
		// }
	}

	public String[][] getConstrains() {
		return constrains;
	}

	public void setConstrains(String[][] constrains) {
		this.constrains = constrains;
	}

	public int getConstrainsNumber() {
		return constrainsNumber;
	}

	public void setConstrainsNumber(int constrainsNumber) {
		this.constrainsNumber = constrainsNumber;
	}

	public String[] getCategorys() {
		return categorys;
	}

	public void setCategorys(String[] categorys) {
		this.categorys = categorys;
	}

	public String[][] getAttributes() {
		return attributes;
	}

	public void setAttributes(String[][] attributes) {
		this.attributes = attributes;
	}
}