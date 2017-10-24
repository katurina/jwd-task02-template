package entity;

public class XMLAttribute implements Node {
	private String attrName;
	private String attrValue;

	public XMLAttribute() {
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getAttrValue() {
		return attrValue;
	}

	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (getClass() != o.getClass()) {
			return false;
		}

		XMLAttribute that = (XMLAttribute) o;

		if (getAttrName() == null) {
			if (that.getAttrName() != null) {
				return false;
			}
		} else if (!getAttrName().equals(that.getAttrName())) {
			return false;
		}
		return getAttrValue() != null ? getAttrValue().equals(that.getAttrValue()) : that.getAttrValue() == null;
	}

	@Override
	public int hashCode() {
		int result = getAttrName() != null ? getAttrName().hashCode() : 0;
		result = 31 * result + (getAttrValue() != null ? getAttrValue().hashCode() : 0);
		return result;
	}
}
