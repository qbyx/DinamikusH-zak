package control;

import gui.MainFrame;
import io.GameLoader;

public class GameState {

	final private Game game;

	private Attribute houses[][];
	// private boolean correct[][];
	private boolean usedAttr[];
	private GameLoader gameLoader;
	private MainFrame mainFrame;
	private String[][] constrainsList;

	public GameState(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		game = mainFrame.getGame();
		gameLoader = mainFrame.getGameLoader();
		constrainsList = gameLoader.getConstrains();
		houses = new Attribute[game.getHouseCount()][game.getAttributeCount()];
		// correct = new
		// boolean[game.getHouseCount()][game.getAttributeCount()];
		usedAttr = new boolean[game.getHouseCount() * game.getAttributeCount()];
	}

	public void setAttributeAt(int houseIndex, Attribute attr) {
		houses[houseIndex][attr.getAttributeCategory().getIndex()] = attr;
		System.out.println("set: " + houseIndex + ", "
				+ attr.getAttributeCategory().getName());
	}

	public Attribute getAttributeAt(int houseIndex, AttributeCategory attrCat) {
		return houses[houseIndex][attrCat.getIndex()];
	}

	public Game getGame() {
		return game;
	}

	public Constrain.Verdict Evaluate() {
		Constrain.Verdict verdict;
		Constrain.Verdict finalVerdict = Constrain.Verdict.CORRECT;
		Constrain[] constrains = game.getConstrains();
		for (int i = 0; i < constrains.length; ++i) {

			// System.out.print(constrainsList[i][0] + " " +
			// constrainsList[i][1]
			// + " " + constrainsList[i][2] + ":                ");

			verdict = constrains[i].evaluate(this);
			if (verdict == Constrain.Verdict.CORRECT) {
				// System.out.println("CORRECT");
			} else if (verdict == Constrain.Verdict.UNKNOWN) {
				// System.out.println("UNKNOWN");
				if (finalVerdict == Constrain.Verdict.CORRECT) {
					finalVerdict = Constrain.Verdict.UNKNOWN;
				}
			} else if (verdict == Constrain.Verdict.INCORRECT) {
				// System.out.println("INCORRECT");
				finalVerdict = Constrain.Verdict.INCORRECT;
			} else {
				System.out.println("UNKNOWN VERDICT");
			}
		}

		return finalVerdict;
	}

	public int getHouseIndex(Attribute attr) {
		for (int i = 0; i < houses.length; ++i) {
			for (Attribute a : houses[i]) {
				if (attr == a) {
					return i;
				}
			}
		}

		// not found
		return -1;
	}

	public void ClearAttribute(int houseIndex, int categoryIndex) {
		houses[houseIndex][categoryIndex] = null;
	}

	public void RecursiveBackTrack(int houseIndex, int attributeIndex) {
		Constrain.Verdict v;

		// out of houses
		if (houseIndex >= game.getHouseCount()) {
			return;
		}

		// next house
		if (attributeIndex >= game.getAttributeCount()) {
			// RecursiveBackTrack(houseIndex + 1, 0);
			houseIndex++;
			attributeIndex = 0;
		}

		for (int i = 0; i < game.getAttributeCount() * game.getHouseCount(); ++i) {
			// unset before select
			int indexBefore = game
					.getAttributeIndex(houses[houseIndex][attributeIndex]);
			if (indexBefore != -1) {
				usedAttr[indexBefore] = false;
				houses[houseIndex][attributeIndex] = null;
			}

			// already placed
			if (usedAttr[i]) {
				continue;
			}

			// different attribute category
			if (attributeIndex != game.getAttributes()[i]
					.getAttributeCategory().getIndex()) {
				continue;
			}

			// set after
			houses[houseIndex][attributeIndex] = game.getAttributes()[i];
			usedAttr[i] = true;

			// dump
			// for (int h = 0; h < game.getHouseCount(); ++h) {
			// for (int k = 0; k < game.getAttributeCount(); ++k) {
			// if (houses[h][k] != null) {
			// System.out.println("House[" + h + "][" + k + "]: " +
			// houses[h][k].getName());
			// }
			// }
			// }

			// evaluate current state
			v = Evaluate();
			if (v == Constrain.Verdict.INCORRECT) {
				continue;
			} else if (v == Constrain.Verdict.CORRECT) {
				System.out.println("SOLUTONIONNOR");

				// dump
				for (int h = 0; h < game.getHouseCount(); ++h) {
					for (int k = 0; k < game.getAttributeCount(); ++k) {
						if (houses[h][k] != null) {
							System.out.println("House[" + h + "][" + k + "]: "
									+ houses[h][k].getName());
						}
					}
				}
			} else {
				usedAttr[i] = true;
				RecursiveBackTrack(houseIndex, attributeIndex + 1);
			}
		}

		// reset the last one
		{
			int indexBefore = game
					.getAttributeIndex(houses[houseIndex][attributeIndex]);
			if (indexBefore != -1) {
				usedAttr[indexBefore] = false;
				houses[houseIndex][attributeIndex] = null;
			}
		}

		return;
	}

}
