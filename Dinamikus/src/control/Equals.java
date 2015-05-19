package control;

public class Equals extends Constrain {

	public Equals(Attribute firstAttr, Attribute secondAttr) {
		super(firstAttr, secondAttr);
	}

	@Override
	public Verdict evaluate(GameState gs) {
		int firstIndex = gs.getHouseIndex(firstAttr);
		int secondIndex = gs.getHouseIndex(secondAttr);

		//System.out.println(firstIndex + " --- " + secondIndex);
		if (firstIndex == -1 && secondIndex == -1) {
			return Constrain.Verdict.UNKNOWN;
		} else if (secondIndex == -1) {
			//System.out.println("no second");
			Attribute other = gs.getAttributeAt(firstIndex,
					secondAttr.getAttributeCategory());
			if (other != null) {
				return Constrain.Verdict.INCORRECT;
			} else {
				return Constrain.Verdict.UNKNOWN;
			}
		} else if (firstIndex == -1) {
			//System.out.println("no first");
			Attribute other = gs.getAttributeAt(secondIndex,
					firstAttr.getAttributeCategory());
			if (other != null) {
				return Constrain.Verdict.INCORRECT;
			} else {
				return Constrain.Verdict.UNKNOWN;
			}
		}

		if (firstIndex == secondIndex) {
			// correctly placed
			return Constrain.Verdict.CORRECT;
		} else {
			// incorrectly placed
			return Constrain.Verdict.INCORRECT;
		}
	}

}
