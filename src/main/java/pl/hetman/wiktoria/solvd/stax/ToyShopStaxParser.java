package pl.hetman.wiktoria.solvd.stax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.XMLConstants;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;

public class ToyShopStaxParser {

    private static final Logger LOGGER = LogManager.getLogger(ToyShopStaxParser.class);

    private static final String TOY_ELEMENT = "toy";
    private static final String EMPLOYEE_ELEMENT = "employee";
    private static final String EMPLOYEE_CONTACT_ELEMENT = "employeeContact";
    private static final String SUPPLIER_CONTACT_ELEMENT = "supplierContact";
    private static final String ORDER_DATE_ELEMENT = "orderDate";
    private static final String DATE_ELEMENT = "date";
    private static final String NAME_ELEMENT = "name";
    private static final String EMPLOYEE_ID_ELEMENT = "employeeId";
    private static final String EMAIL_ELEMENT = "email";
    private static final String PHONE_ELEMENT = "phone";

    private StaxToyShopHandler handler;

    public ToyShopStaxParser(StaxToyShopHandler handler) {
        this.handler = handler;
    }

    public void printXmlByXmlCursorReader(Path path)
            throws FileNotFoundException, XMLStreamException {

        LOGGER.info("printXmlByXmlCursorReader(" + path + ")");

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

                    case TOY_ELEMENT:
                        handler.handleToyElement(reader);
                        break;

                    case EMPLOYEE_ELEMENT:
                        handler.handleEmployeeElement(reader);
                        break;

                    case EMPLOYEE_CONTACT_ELEMENT:
                        handler.handleEmployeeContactElement(reader);
                        break;

                    case SUPPLIER_CONTACT_ELEMENT:
                        handler.handleSupplierContactElement(reader);
                        break;

                    case ORDER_DATE_ELEMENT:
                        handler.handleOrderDateElement(reader);
                        break;

                    case DATE_ELEMENT:
                        handler.handleDateElement(reader, eventType);
                        break;

                    case NAME_ELEMENT:
                        handler.handleNameElement(reader, eventType);
                        break;

                    case EMPLOYEE_ID_ELEMENT:
                        handler.handleEmployeeIdElement(reader, eventType);
                        break;

                    case EMAIL_ELEMENT:
                        handler.handleEmailElement(reader, eventType);
                        break;

                    case PHONE_ELEMENT:
                        handler.handlePhoneElement(reader, eventType);
                        break;
                }

            }

            if (eventType == XMLEvent.END_ELEMENT) {
                if (reader.getName().getLocalPart().equals(TOY_ELEMENT)) {
                    System.out.printf("%n%s%n%n", "---");
                }
                if (reader.getName().getLocalPart().equals(EMPLOYEE_ELEMENT)) {
                    System.out.printf("%n%s%n%n", "---");
                }
                if (reader.getName().getLocalPart().equals(EMPLOYEE_CONTACT_ELEMENT)) {
                    System.out.printf("%n%s%n%n", "---");
                }
                if (reader.getName().getLocalPart().equals(SUPPLIER_CONTACT_ELEMENT)) {
                    System.out.printf("%n%s%n%n", "---");
                }
                if (reader.getName().getLocalPart().equals(ORDER_DATE_ELEMENT)) {
                    System.out.printf("%n%s%n%n", "---");
                }
            }

        }
        LOGGER.info("printXmlByXmlCursorReader(...)");
    }
}