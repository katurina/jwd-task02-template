package by.tc.task02.dao.impl;


import by.tc.task02.dao.XmlBufferedReader;
import by.tc.task02.dao.XmlParser;
import by.tc.task02.dao.exception.XmlDAOException;
import by.tc.task02.entity.Text;
import by.tc.task02.entity.XMLAttribute;
import by.tc.task02.entity.XMLElem;

import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class XmlParserImpl implements XmlParser {

    private XmlBufferedReader xmlBufferedReader;
    private Deque<XMLElem> controlList = new LinkedList<>();

    private static final Pattern OPEN_TAG = Pattern.compile("<[^/][^<>]*>");
    private static final Pattern CLOSE_TAG = Pattern.compile("</[^<>]+>");
    private static final Pattern TAGS_ATTRIBUTES = Pattern.compile("([\\w-:]+)=\"([^\"]+)\"");
    private static final String OPEN_BRACKET = "<";
    private static final String CLOSE_BRACKET = ">";
    private static final String ATTRIBUTE_SIGN = "\"";
    private static final String SPACE_BEFORE_ATTRIBUTE = " ";
    private static final int NEXT_SYMBOL = 1;

    public XmlParserImpl(XmlBufferedReader xmlBufferedReader) {
        this.xmlBufferedReader = xmlBufferedReader;
    }

    @Override
    public XMLElem parseXML() throws XmlDAOException {
        String element;
        while (!(element = xmlBufferedReader.readLine()).isEmpty()) {
            element = element.trim();
            processElement(element);
        }
        return controlList.getFirst();
    }

    private void processElement(String element) {
        if (OPEN_TAG.matcher(element).matches()) {
            initTag(element);
        } else if (CLOSE_TAG.matcher(element).matches()) {
            linkTag();
        } else {
            String text = element.substring(0, element.indexOf(OPEN_BRACKET)).trim();
            linkText(text);
            linkTag();
        }
    }

    private void initTag(String tag) {
        String nameTag;
        if (tag.contains(ATTRIBUTE_SIGN)) {
            nameTag = tag.substring(tag.indexOf(OPEN_BRACKET) + NEXT_SYMBOL, tag.indexOf(SPACE_BEFORE_ATTRIBUTE));
            tag = tag.substring(tag.indexOf(SPACE_BEFORE_ATTRIBUTE) + NEXT_SYMBOL, tag.lastIndexOf(CLOSE_BRACKET));
            XMLElem openTag = linkAttributes(tag, nameTag);
            controlList.add(openTag);
        } else {
            nameTag = tag.substring(tag.indexOf(OPEN_BRACKET) + NEXT_SYMBOL, tag.indexOf(CLOSE_BRACKET)).trim();
            controlList.add(new XMLElem(nameTag));
        }

    }

    private void linkTag() {
        if (controlList.size() != 1) {
            XMLElem lastXMLElem = controlList.pollLast();
            controlList.peekLast().getNodes().add(lastXMLElem);
        }
    }

    private void linkText(String text) {
        controlList.peekLast().getNodes().add(new Text(text));
    }

    private XMLElem linkAttributes(String tag, String nameTag) {
        XMLElem openTag = new XMLElem(nameTag);
        Matcher matcher = TAGS_ATTRIBUTES.matcher(tag);
        while (matcher.find()) {
            openTag.getAttrs().add(new XMLAttribute(matcher.group(1), matcher.group(2)));
        }
        return openTag;
    }

}
