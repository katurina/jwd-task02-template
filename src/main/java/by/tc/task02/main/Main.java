package by.tc.task02.main;

import by.tc.task02.dao.exception.XmlDAOException;
import by.tc.task02.entity.XMLElem;
import by.tc.task02.service.ServiceFactory;
import by.tc.task02.service.exception.XMLServiceException;

import java.io.InputStream;

public class Main {

    private final static String FILE_NAME = "task02.xml";

    public static void main(String[] args) throws XmlDAOException {
        try {
            InputStream resourceAsStream = Main.class.getClassLoader().getResourceAsStream(FILE_NAME);
            ServiceFactory instance = ServiceFactory.getInstance();
            XMLElem xmlElem = instance.getApplianceService().readXML(resourceAsStream);
            TreePrinter.print(xmlElem);
        } catch (XMLServiceException e) {
            e.printStackTrace();
        }

    }
}
