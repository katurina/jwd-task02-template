package by.tc.task02.dao;

import by.tc.task02.dao.exception.XmlDAOException;
import by.tc.task02.dao.impl.XmlFileDAOImpl;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private XmlFileDAO xmlFileDAO = new XmlFileDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public XmlFileDAO getApplianceDAO() throws XmlDAOException {
        return xmlFileDAO;
    }
}
