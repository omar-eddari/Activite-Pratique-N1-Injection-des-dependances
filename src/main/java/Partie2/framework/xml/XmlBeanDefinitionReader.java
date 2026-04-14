package Partie2.framework.xml;

import jakarta.xml.bind.*;
import java.io.File;

public class XmlBeanDefinitionReader {

    public Beans loadBeans(String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Beans.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            return (Beans) unmarshaller.unmarshal(new File(filePath));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}