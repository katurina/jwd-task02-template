package by.tc.task02.main;

import by.tc.task02.dao.exception.XmlDAOException;

public class Main {

    private final static String FILE_NAME = "task02.xml";

    public static void main(String[] args) throws XmlDAOException {
//        InputStream resourceAsStream = Main.class.getClassLoader().getResourceAsStream(FILE_NAME);
        String checker = "0123456789";
        System.out.println(checker.substring(0, checker.indexOf("5")));
        System.out.println(checker.substring(checker.indexOf("5")));
    }
}
