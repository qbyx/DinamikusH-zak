package control;

public class Positional extends Constrain {
	private int position;

	public Positional(Attribute firstAttr, int position) {
		super(firstAttr, null);
		this.position = position;
	}

	@Override
	public Verdict evaluate(GameState gs) {
		int houseIndex = gs.getHouseIndex(firstAttr);

		if (houseIndex == -1) {
			Attribute other = gs.getAttributeAt(position,
					firstAttr.getAttributeCategory());
			if (other != null) {
				return Constrain.Verdict.INCORRECT;
			} else {
				return Constrain.Verdict.UNKNOWN;
			}
		}

		if (position == gs.getHouseIndex(firstAttr)) {
			return Constrain.Verdict.CORRECT;
		} else {
			return Constrain.Verdict.INCORRECT;
		}
	}
}