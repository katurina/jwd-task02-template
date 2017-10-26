package by.tc.task02.dao.impl;

import by.tc.task02.dao.XmlBufferedReader;
import by.tc.task02.dao.exception.XmlDAOException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class XmlBufferedReaderImpl implements XmlBufferedReader {

    private static final String UTF_8 = "UTF-8";

    private BufferedReader bufferedReader;
    private String reservoir = "";


    public XmlBufferedReaderImpl(InputStream inputStream) throws XmlDAOException {
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, UTF_8));
        } catch (UnsupportedEncodingException e) {
            throw new XmlDAOException(e);
        }
    }

    public void close() throws XmlDAOException {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            throw new XmlDAOException(e);
        }

    }

    @Override
    public String readLine() throws XmlDAOException {
        String element;
        try {
            while (!reservoir.contains(">")) {
                if (reservoir.isEmpty()) {
                    reservoir = bufferedReader.readLine().trim();
                } else {
                    reservoir = reservoir + " " + bufferedReader.readLine().trim();
                }
            }

            element = reservoir.substring(0, reservoir.indexOf('>'));
            reservoir = reservoir.substring(reservoir.indexOf('>') + 1, reservoir.length());
            return element;

        } catch (IOException e) {
            throw new XmlDAOException(e);
        }

    }

}