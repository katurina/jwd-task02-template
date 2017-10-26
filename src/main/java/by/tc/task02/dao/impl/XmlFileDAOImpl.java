package by.tc.task02.dao.impl;

import by.tc.task02.dao.XmlBufferedReader;
import by.tc.task02.dao.XmlFileDAO;
import by.tc.task02.dao.XmlParser;
import by.tc.task02.dao.exception.XmlDAOException;
import by.tc.task02.entity.XMLElem;

import java.io.InputStream;

public class XmlFileDAOImpl implements XmlFileDAO {

    public XMLElem readXml(InputStream inputStream) throws XmlDAOException {
        try (XmlBufferedReader XmlBufferedReader = new XmlBufferedReaderImpl(inputStream)) {
            XmlParser xmlParser = new XmlParserImpl(XmlBufferedReader);
            return xmlParser.parseXML();
        }
    }
}
