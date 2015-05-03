package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GameLoader {
	private int houseNumber;
	private int catNumber;
	private String cat[][];
	private String categorys[];

	public GameLoader() {
	}

	public void setGame(int game) {
		Game(game);
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public int getCatNumber() {
		return catNumber;
	}

	public void setCatNumber(int catNumber) {
		this.catNumber = catNumber;
	}

	public String[][] getCat() {
		return cat;
	}

	public void setCat(String[][] cat) {
		this.cat = cat;
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
			houseNumber = Integer.parseInt(br.readLine());
			catNumber = Integer.parseInt(br.readLine());
			cat = new String[houseNumber][catNumber + 1];
			for (int i = 0; i < houseNumber; i++) {
				sCurrentLine = br.readLine();
				cat[i] = sCurrentLine.split(" ");
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
		for (int i = 0; i < houseNumber; i++) {
			for (int j = 0; j < catNumber + 1; j++) {
				System.out.print(cat[i][j] + ",");
			}
			System.out.println();
		}
	}
}