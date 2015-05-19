package control;

public class Neighbor extends Constrain {
	public Neighbor(Attribute firstAttr, Attribute secondAttr) {
		super(firstAttr, secondAttr);
	}

	@Override
	public Verdict evaluate(GameState gs) {
		int firstHouseIndex = gs.getHouseIndex(firstAttr);
		int secondHouseIndex = gs.getHouseIndex(secondAttr);
		
		if (firstHouseIndex == -1 || secondHouseIndex == -1) {
			return Constrain.Verdict.UNKNOWN;
		}

		if (firstHouseIndex + 1 == secondHouseIndex || secondHouseIndex + 1 == firstHouseIndex) {
			return Constrain.Verdict.CORRECT;
		}
		else {
			return Constrain.Verdict.INCORRECT;
		}
	}

}
