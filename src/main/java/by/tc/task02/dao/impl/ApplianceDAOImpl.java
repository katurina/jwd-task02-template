package by.tc.task02.dao.impl;


import by.tc.task02.dao.ApplianceDAO;
import by.tc.task02.dao.exception.ApplianceDAOException;
import by.tc.task02.entity.XMLElem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class ApplianceDAOImpl implements ApplianceDAO {

	private final static Pattern FIRST_LINE = Pattern.compile("^(<\\?xml)");

	//	private final static Pattern
	private static final String FILE_NAME = "task02.xml";
	private XMLElem root;

	public XMLElem parse() throws ApplianceDAOException {
		try (BufferedReader bufferedReader = new BufferedReader
				(new InputStreamReader(getClass().getClassLoader()
						.getResourceAsStream(FILE_NAME), "UTF-8"))) {
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				if (line.isEmpty()) {
					continue;
				}
				parseLine(line);
			}
			return root;
		} catch (IOException e) {
			throw new ApplianceDAOException(e);
		}
	}

	private void parseLine(String line) {
		if (FIRST_LINE.matcher(line).find()) {
			return;
		}

	}

}

