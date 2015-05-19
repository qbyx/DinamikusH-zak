package control;

public class GameState {

	final private Game game;

	Attribute houses[][];

	public GameState(Game game) {
		super();
		this.game = game;

		houses = new Attribute[game.getHouseCount()][game.getAttributeCount()];
	}

	public void setAttributeAt(int houseIndex, Attribute attr) {
		houses[houseIndex][attr.getAttributeCategory().getIndex()] = attr;
		System.out.println("set: " + houseIndex + ", "
				+ attr.getAttributeCategory().getIndex());
	}
	
	public Attribute getAttributeAt(int houseIndex, AttributeCategory attrCat) {
		return houses[houseIndex][attrCat.getIndex()];
	}

	public Game getGame() {
		return game;
	}

	public boolean Evaluate() {
		Constrain[] constrains = game.getConstrains();
		for (int i = 0; i < constrains.length; ++i) {
			Constrain.Verdict verdict;
			
			System.out.print("constrain[" + i + "]: ");

			verdict = constrains[i].evaluate(this);
			if (verdict == Constrain.Verdict.CORRECT) {
				System.out.println("CORRECT");
			} else if (verdict == Constrain.Verdict.UNKNOWN) {
				System.out.println("UNKNOWN");
			} else if (verdict == Constrain.Verdict.INCORRECT){
				System.out.println("INCORRECT");
			} else {
				System.out.println("UNKNOWN VERDICT");
			}
		}

		// temp
		return false;
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

}
