package by.tc.task02.dao;

import by.tc.task02.dao.exception.XmlDAOException;
import by.tc.task02.entity.XMLElem;

public interface XmlParser {

    XMLElem parseXML() throws XmlDAOException;

}
