package by.tc.task02.entity;

public class XMLAttribute implements Node {

    private String attrName;
    private String attrValue;

    public XMLAttribute() {
    }

    public XMLAttribute(String attrName, String attrValue) {
        this.attrName = attrName;
        this.attrValue = attrValue;
    }

    @Override
    public int hashCode() {
        int result = getAttrName() != null ? getAttrName().hashCode() : 0;
        result = 31 * result + (getAttrValue() != null ? getAttrValue().hashCode() : 0);
        return result;
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
    public String toString() {
        return "XMLAttribute{" +
                "attrName='" + attrName + '\'' +
                ", attrValue='" + attrValue + '\'' +
                '}';
    }
}
