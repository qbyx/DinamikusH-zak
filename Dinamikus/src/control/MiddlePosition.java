package control;

public class MiddlePosition extends Constrain {

	public MiddlePosition(Attribute firstAttr) {
		super(firstAttr, null);
	}

	@Override
	public Verdict evaluate(GameState gs) {
		int houseCount = gs.getGame().getHouseCount();
		int houseIndex = gs.getHouseIndex(firstAttr);

		if (houseCount % 2 == 0) {
			return Constrain.Verdict.INCORRECT;
		}

		if (houseIndex == -1) {
			Attribute other = gs.getAttributeAt(houseCount / 2,
					firstAttr.getAttributeCategory());
			if (other != null) {
				return Constrain.Verdict.INCORRECT;
			} else {
				return Constrain.Verdict.UNKNOWN;
			}
		}

		if (houseCount / 2 == gs.getHouseIndex(firstAttr)) {
			return Constrain.Verdict.CORRECT;
		} else {
			//System.out.println("was: " + (houseCount / 2));
			//System.out.println("was: " + gs.getHouseIndex(firstAttr));
			return Constrain.Verdict.INCORRECT;
		}
	}

}
