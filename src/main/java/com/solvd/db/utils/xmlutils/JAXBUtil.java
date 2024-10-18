package com.solvd.db.utils.xmlutils;

import com.solvd.db.enums.Paths;
import com.solvd.db.utils.XMLExtractor;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBUtil {

    public static void marshall(Object object) {
        try {
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(object, new File(Paths.XMLFOLDER.getPath() + object.getClass().getSimpleName() + ".xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static Object unMarshall(String filePath) {
        try {
            String clazz = XMLExtractor.getMainNodeName(filePath);
            clazz = Character.toUpperCase(clazz.charAt(0)) + clazz.substring(1);
            Class<?> objectClass = Class.forName(Paths.MODELFOLDER.getPath() + "." + clazz);
            JAXBContext context = JAXBContext.newInstance(objectClass);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return objectClass.cast(unmarshaller.unmarshal(new File(filePath)));
        } catch (JAXBException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
