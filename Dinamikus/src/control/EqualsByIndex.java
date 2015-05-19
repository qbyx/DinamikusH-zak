package control;

public class EqualsByIndex extends Constrain{
	
	private int index;

	public EqualsByIndex(Attribute firstAttr, int index) {
		super(firstAttr, null);
		this.index = index;
	}

	@Override
	public Verdict evaluate(GameState gs) {
		// not placed yet
		int firstIndex = gs.getHouseIndex(firstAttr);

		if (firstIndex == -1) {
			return Constrain.Verdict.UNKNOWN;
		}

		if (firstIndex == index) {
			// correctly placed
			return Constrain.Verdict.CORRECT;
		} else {
			// incorrectly placed
			return Constrain.Verdict.INCORRECT;
		}
	}

}
