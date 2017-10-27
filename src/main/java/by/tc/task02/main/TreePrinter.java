package by.tc.task02.main;


import by.tc.task02.entity.Node;
import by.tc.task02.entity.Text;
import by.tc.task02.entity.XMLAttribute;
import by.tc.task02.entity.XMLElem;

import java.util.List;

public class TreePrinter {

    private static final String SINGLE_SPACE = " ";
    private static final String TAB_SPACE = "   ";
    private static final String LONG_TAB = "      ";
    private static final String NAME = "name:";
    private static final String NODES = "nodes:";
    private static final String ATTRIBUTES = "attributes:";

    public static void print(XMLElem root) {
        print(root, SINGLE_SPACE);
    }

    private static void print(XMLElem element, String space) {
        System.out.println(space + NAME + element.getName());
        printAttributes(space, element);
        System.out.println(space + NODES);
        printNodes(element, space);
    }

    private static void printNodes(XMLElem element, String space) {
        List<Node> nodes = element.getNodes();
        if (!nodes.isEmpty()) {
            for (Node node : nodes) {
                if (node instanceof XMLElem) {
                    printXMLElem(space, (XMLElem) node);
                } else {
                    System.out.println(space + LONG_TAB + ((Text) node).getText());
                }
            }
        }
    }

    private static void printXMLElem(String space, XMLElem node) {
        String spaceNew = space + LONG_TAB;
        print(node, spaceNew);
    }

    private static void printAttributes(String space, XMLElem element) {
        if (!element.getAttrs().isEmpty()) {
            System.out.println(space + ATTRIBUTES);
            printAttributes(element, space);
        }
    }

    private static void printAttributes(XMLElem element, String space) {
        List<XMLAttribute> attributes = element.getAttrs();
        for (XMLAttribute attribute : attributes) {
            System.out.println(space + TAB_SPACE +
                    attribute.getAttrName()
                    + "=\""
                    + attribute.getAttrValue() + "\"");
        }
    }
}

