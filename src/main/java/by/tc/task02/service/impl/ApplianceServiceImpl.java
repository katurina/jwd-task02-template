package by.tc.task02.service.impl;

import by.tc.task02.dao.DAOFactory;
import by.tc.task02.dao.XmlFileDAO;
import by.tc.task02.dao.exception.XmlDAOException;
import by.tc.task02.entity.XMLElem;
import by.tc.task02.service.ApplianceService;
import by.tc.task02.service.exception.XMLServiceException;

import java.io.InputStream;

public class ApplianceServiceImpl implements ApplianceService {

    @Override
    public XMLElem readXML(InputStream inputStream) throws XMLServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            XmlFileDAO applianceDAO = daoFactory.getApplianceDAO();
            return applianceDAO.readXml(inputStream);
        } catch (XmlDAOException e) {
            throw new XMLServiceException(e);
        }
    }
}
