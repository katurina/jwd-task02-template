package by.tc.task02.dao;

import by.tc.task02.dao.exception.XmlDAOException;
import by.tc.task02.entity.XMLElem;

import java.io.InputStream;

public interface XmlFileDAO {
    XMLElem readXml(InputStream inputStream) throws XmlDAOException;
}
