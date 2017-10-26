package by.tc.task02.entity;

import java.util.List;

public class XMLElem implements Node {

    private String name;
    private List<XMLAttribute> attrs;
    private List<Node> nodes;

    public XMLElem() {
    }

    public XMLElem(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getAttrs() != null ? getAttrs().hashCode() : 0);
        result = 31 * result + (getNodes() != null ? getNodes().hashCode() : 0);
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

        XMLElem that = (XMLElem) o;

        if (getName() == null) {
            if (that.getName() != null) {
                return false;
            }
        } else if (!getName().equals(that.getName())) {
            return false;
        }
        if (getAttrs() == null) {
            if (that.getAttrs() != null) {
                return false;
            }
        } else if (!getAttrs().equals(that.getAttrs())) {
            return false;
        }
        return getNodes() != null ? getNodes().equals(that.getNodes()) : that.getNodes() == null;
    }

    @Override
    public String toString() {
        return "XMLElem{" +
                "name='" + name + '\'' +
                ", attrs=" + attrs +
                ", nodes=" + nodes +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<XMLAttribute> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<XMLAttribute> attrs) {
        this.attrs = attrs;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
}
