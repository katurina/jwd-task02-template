package by.tc.task02.main;

import by.tc.task02.dao.exception.ApplianceDAOException;
import by.tc.task02.dao.impl.ApplianceDAOImpl;

public class Main {
	public static void main(String[] args) throws ApplianceDAOException {
		new ApplianceDAOImpl().parse();
	}
}
