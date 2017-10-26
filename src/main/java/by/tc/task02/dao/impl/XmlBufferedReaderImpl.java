package by.tc.task02.dao.impl;

import by.tc.task02.dao.XmlBufferedReader;
import by.tc.task02.dao.exception.XmlDAOException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class XmlBufferedReaderImpl implements XmlBufferedReader {

    private BufferedReader bufferedReader;
    private static final String UTF_8 = "UTF-8";
    private static final String LAST_BRACKET = ">";
    private static final String FIRST_LINE_XML = "<?xml";
    private static final String SPACE_LINKER_LINES = " ";
    private static final int BEGIN_OF_LINE = 0;
    private static final int INCLUDING_LAST_BRACKET = 1;
    private String buffer = "";


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
        String line;
        try {
            while (!buffer.contains(LAST_BRACKET) && (line = bufferedReader.readLine()) != null) {
                if (line.isEmpty() || line.contains(FIRST_LINE_XML)) {
                    continue;
                }
                if (buffer.isEmpty()) {
                    buffer = line.trim();
                } else {
                    buffer = buffer + SPACE_LINKER_LINES + line.trim();
                }
            }

            element = getElement();
            buffer = getPartAfterElement();
            return element;

        } catch (IOException e) {
            throw new XmlDAOException(e);
        }
    }

    private String getElement() {
        return buffer.substring(BEGIN_OF_LINE, buffer.indexOf(LAST_BRACKET) + 1);
    }

    private String getPartAfterElement() {
        return buffer.substring(buffer.indexOf(LAST_BRACKET) + INCLUDING_LAST_BRACKET);
    }
}