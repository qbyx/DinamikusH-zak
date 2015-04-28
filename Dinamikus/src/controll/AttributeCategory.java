package controll;

import java.awt.Color;

// italok / kedvence állat / autó / ...
public class AttributeCategory {
	
	private String name;
	private Color color;
	
	public String getName() {
		return name;
	}

	public AttributeCategory(String name, Color color) {
		super();
		this.name = name;
		this.color = color;
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
	
}
