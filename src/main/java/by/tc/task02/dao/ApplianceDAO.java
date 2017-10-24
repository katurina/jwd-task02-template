package by.tc.task02.dao;

import by.tc.task02.dao.exception.ApplianceDAOException;
import by.tc.task02.entity.XMLElem;

public interface ApplianceDAO {
	XMLElem parse() throws ApplianceDAOException;
}
