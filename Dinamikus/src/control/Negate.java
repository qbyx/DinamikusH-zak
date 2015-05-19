package control;

public class Negate extends Constrain {
	private Constrain constrain;

	public Negate(Constrain constrain) {
		super(constrain.getFirstAttr(), constrain.getFirstAttr());
		this.constrain = constrain;
	}

	@Override
	public Verdict evaluate(GameState gs) {
		Constrain.Verdict verdict = constrain.evaluate(gs);
		
		if (verdict == Constrain.Verdict.INCORRECT) {
			return Constrain.Verdict.CORRECT;
		} else if (verdict == Constrain.Verdict.CORRECT) {
			return Constrain.Verdict.INCORRECT;
		} else {
			return Constrain.Verdict.UNKNOWN;
		}
	}

}
