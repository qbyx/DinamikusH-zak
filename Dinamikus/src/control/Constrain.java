package control;

public abstract class Constrain {
	
	public enum Verdict {
		CORRECT, INCORRECT, UNKNOWN,
	};
	
	protected Attribute firstAttr;
	protected Attribute secondAttr;
	
	public Constrain(Attribute firstAttr, Attribute secondAttr) {
		super();
		this.firstAttr = firstAttr;
		this.secondAttr = secondAttr;
	}

	public Attribute getFirstAttr() {
		return firstAttr;
	}

	public void setFirstAttr(Attribute firstAttr) {
		this.firstAttr = firstAttr;
	}

	public Attribute getSecondAttr() {
		return secondAttr;
	}

	public void setSecondAttr(Attribute secondAttr) {
		this.secondAttr = secondAttr;
	}

	public abstract Verdict evaluate(GameState gs);

}
