package com.solvd.db.jaxb;

import com.solvd.db.utils.XMLExtractor;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class XmlValidator {

    public static void validateXMLAgainstXSD(String xmlFilePath, String xsdFilePath) {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new StreamSource(xsdFilePath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFilePath));
            System.out.println(XMLExtractor.getMainNodeName(xmlFilePath) + " XML is valid");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(XMLExtractor.getMainNodeName(xmlFilePath) + " XML is not valid against the XSD.");
        }
    }
}
