package control;

import java.awt.Color;

// italok / kedvence állat / autó / ...
public class AttributeCategory {

	private String name;
	private Color color;
	private int index;

	public AttributeCategory(String name, Color color, int index) {
		this.name = name;
		this.color = color;
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
