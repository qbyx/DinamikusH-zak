package control;

public class Neighbor extends Constrain {
	private int distance; 

	public Neighbor(Attribute firstAttr, Attribute secondAttr, int distance) {
		super(firstAttr, secondAttr);
		this.distance = distance;
	}

	@Override
	public Verdict evaluate(GameState gs) {
		int firstHouseIndex = gs.getHouseIndex(firstAttr);
		int secondHouseIndex = gs.getHouseIndex(secondAttr);
		
		if (firstHouseIndex == -1 || secondHouseIndex == -1) {
			return Constrain.Verdict.UNKNOWN;
		}

		if (firstHouseIndex + distance == secondHouseIndex || secondHouseIndex + distance == firstHouseIndex) {
			return Constrain.Verdict.CORRECT;
		}
		else {
			return Constrain.Verdict.INCORRECT;
		}
	}

}
