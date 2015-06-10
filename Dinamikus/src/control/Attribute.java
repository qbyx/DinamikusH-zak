package control;

import gui.AttributeContent;

public class Attribute {

	private String name;
	private AttributeCategory attributeCategory;
	// QQQ
	private AttributeContent attributeContent;

	public AttributeContent getAttributeContent() {
		return attributeContent;
	}

	public void setAttributeContent(AttributeContent attributeContent) {
		this.attributeContent = attributeContent;
	}

	public AttributeCategory getAttributeCategory() {
		return attributeCategory;
	}

	public void setAttributeCategory(AttributeCategory attributeCategory) {
		this.attributeCategory = attributeCategory;
	}

	public Attribute(String name, AttributeCategory attrCat) {
		this.name = name;
		this.attributeCategory = attrCat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
