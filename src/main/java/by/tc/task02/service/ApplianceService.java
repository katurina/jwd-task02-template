package by.tc.task02.service;

import by.tc.task02.entity.XMLElem;
import by.tc.task02.service.exception.XMLServiceException;

import java.io.InputStream;

public interface ApplianceService {
    XMLElem readXML(InputStream inputStream) throws XMLServiceException;
}
