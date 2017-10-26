package by.tc.task02.dao.impl;


import by.tc.task02.dao.XmlBufferedReader;
import by.tc.task02.dao.XmlParser;
import by.tc.task02.dao.exception.XmlDAOException;
import by.tc.task02.entity.XMLElem;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;


public class XmlParserImpl implements XmlParser {

    private static final Pattern OPEN_TAG = Pattern.compile("<[^/][^<>]+>");
    private static final Pattern CLOSE_TAG = Pattern.compile("</[^<>]+>");

    private XmlBufferedReader xmlBufferedReader;
    private XMLElem root = null;
    private List<XMLElem> controlList = new LinkedList<>();

    public XmlParserImpl(XmlBufferedReader xmlBufferedReader) {
        this.xmlBufferedReader = xmlBufferedReader;
    }

    @Override
    public XMLElem getRoot() throws XmlDAOException {
        String element;
        while ((element = xmlBufferedReader.readLine()) != null) {
            element = element.trim();
            if (OPEN_TAG.matcher(element).matches()) {
                parseOpenTag(element);
            } else if (CLOSE_TAG.matcher(element).matches()) {
                parseCloseTag(element);
            } else {
                String text = element.substring(0, element.indexOf("<"));
                parseText(text);
                String tagAfterText = element.substring(element.indexOf("<"), element.length());
                parseCloseTag(tagAfterText);
            }
        }
        return root;
    }

    private void parseOpenTag(String tag) {

    }

    private void parseCloseTag(String tag) {

    }

    private void parseText(String text) {

    }
}
