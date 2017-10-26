package by.tc.task02.dao;


import by.tc.task02.dao.exception.XmlDAOException;

public interface XmlBufferedReader extends AutoCloseable {

    @Override
    void close() throws XmlDAOException;

    String readLine() throws XmlDAOException;

}