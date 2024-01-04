package pl.hetman.wiktoria.solvd.stax;

import javax.xml.XMLConstants;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;

public class ToyShopStaxParser {


    public void printXmlByXmlCursorReader(Path path)
            throws FileNotFoundException, XMLStreamException {

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        xmlInputFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        xmlInputFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");

        XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(
                new FileInputStream(path.toFile()));

        int eventType = reader.getEventType();

        while (reader.hasNext()) {

            eventType = reader.next();

            if (eventType == XMLEvent.START_ELEMENT) {

                switch (reader.getName().getLocalPart()) {

                    case "toy":
                        String toyId = reader.getAttributeValue(null, "id");
                        System.out.printf("toy id : %s%n", toyId);
                        break;

                    case "employee":
                        String employeeId = reader.getAttributeValue(null, "id");
                        System.out.printf("employee id : %s%n", employeeId);
                        break;

                    case "employeeContact":
                        String employeeContactId = reader.getAttributeValue(null, "id");
                        System.out.printf("employeeContact id : %s%n", employeeContactId);
                        break;

                    case "supplierContact":
                        String supplierContactId = reader.getAttributeValue(null, "id");
                        System.out.printf("supplierContact id : %s%n", supplierContactId);
                        break;

                    case "orderDate":
                        String orderDateId = reader.getAttributeValue(null, "id");
                        System.out.printf("orderDate id : %s%n", orderDateId);
                        break;

                    case "date":
                        eventType = reader.next();
                        if (eventType == XMLEvent.CHARACTERS) {
                            System.out.printf("Date : %s%n", reader.getText());
                        }
                        break;

                    case "name":
                        eventType = reader.next();
                        if (eventType == XMLEvent.CHARACTERS) {
                            System.out.printf("name : %s%n", reader.getText());
                        }
                        break;

                    case "employeeId":
                        eventType = reader.next();
                        if (eventType == XMLEvent.CHARACTERS) {
                            System.out.printf("employeeId : %s%n", reader.getText());
                        }
                        break;

                    case "email":
                        String emailId = reader.getAttributeValue(null, "id");
                        System.out.printf("email id : %s%n", emailId);
                        eventType = reader.next();

                        if (eventType == XMLEvent.CHARACTERS) {
                            System.out.printf("email : %s%n", reader.getText());
                        }
                        break;

                    case "phone":
                        String phoneId = reader.getAttributeValue(null, "id");
                        System.out.printf("phone id : %s%n", phoneId);
                        eventType = reader.next();

                        if (eventType == XMLEvent.CHARACTERS) {
                            System.out.printf("phone : %s%n", reader.getText());
                        }
                        break;
                }

            }

            if (eventType == XMLEvent.END_ELEMENT) {
                if (reader.getName().getLocalPart().equals("toy")) {
                    System.out.printf("%n%s%n%n", "---");
                }
                if (reader.getName().getLocalPart().equals("employee")) {
                    System.out.printf("%n%s%n%n", "---");
                }
                if (reader.getName().getLocalPart().equals("employeeContact")) {
                    System.out.printf("%n%s%n%n", "---");
                }
                if (reader.getName().getLocalPart().equals("supplierContact")) {
                    System.out.printf("%n%s%n%n", "---");
                }
                if (reader.getName().getLocalPart().equals("orderDate")) {
                    System.out.printf("%n%s%n%n", "---");
                }
            }

        }

    }
}