package pl.hetman.wiktoria.solvd.stax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

public class StaxToyShopHandler {

    private static final Logger LOGGER = LogManager.getLogger(StaxToyShopHandler.class);

    public void handleToyElement(XMLStreamReader reader) {
        LOGGER.info("handleToyElement(" + reader + ")");
        String toyId = reader.getAttributeValue(null, "id");
        System.out.printf("toy id : %s%n", toyId);
        LOGGER.info("handleToyElement(...)");
    }

    public void handleEmployeeElement(XMLStreamReader reader) {
        LOGGER.info("handleEmployeeElement(" + reader + ")");
        String employeeId = reader.getAttributeValue(null, "id");
        System.out.printf("employee id : %s%n", employeeId);
        LOGGER.info("handleEmployeeElement(...)");
    }

    public void handleEmployeeContactElement(XMLStreamReader reader) {
        LOGGER.info("handleEmployeeContactElement(" + reader + ")");
        String employeeContactId = reader.getAttributeValue(null, "id");
        System.out.printf("employeeContact id : %s%n", employeeContactId);
        LOGGER.info("handleEmployeeContactElement(...)");
    }

    public void handleSupplierContactElement(XMLStreamReader reader) {
        LOGGER.info("handleSupplierContactElement(" + reader + ")");
        String supplierContactId = reader.getAttributeValue(null, "id");
        System.out.printf("supplierContact id : %s%n", supplierContactId);
        LOGGER.info("handleSupplierContactElement(...)");
    }

    public void handleOrderDateElement(XMLStreamReader reader) {
        LOGGER.info("handleOrderDateElement(" + reader + ")");
        String orderDateId = reader.getAttributeValue(null, "id");
        System.out.printf("orderDate id : %s%n", orderDateId);
        LOGGER.info("handleOrderDateElement(...)");
    }

    public void handleDateElement(XMLStreamReader reader, int eventType) throws XMLStreamException {
        LOGGER.info("handleDateElement(" + reader + ", " + eventType + ")");
        eventType = reader.next();
        if (eventType == XMLEvent.CHARACTERS) {
            System.out.printf("Date : %s%n", reader.getText());
        }
        LOGGER.info("handleDateElement(...)");
    }

    public void handleNameElement(XMLStreamReader reader, int eventType) throws XMLStreamException {
        LOGGER.info("handleNameElement(" + reader + ", " + eventType + ")");
        eventType = reader.next();
        if (eventType == XMLEvent.CHARACTERS) {
            System.out.printf("name : %s%n", reader.getText());
        }
        LOGGER.info("handleNameElement(...)");
    }

    public void handleEmployeeIdElement(XMLStreamReader reader, int eventType) throws XMLStreamException {
        LOGGER.info("handleEmployeeIdElement(" + reader + ", " + eventType + ")");
        eventType = reader.next();
        if (eventType == XMLEvent.CHARACTERS) {
            System.out.printf("employeeId : %s%n", reader.getText());
        }
        LOGGER.info("handleEmployeeIdElement(...)");
    }

    public void handleEmailElement(XMLStreamReader reader, int eventType) throws XMLStreamException {
        LOGGER.info("handleEmailElement(" + reader + ", " + eventType + ")");
        String emailId = reader.getAttributeValue(null, "id");
        System.out.printf("email id : %s%n", emailId);
        eventType = reader.next();

        if (eventType == XMLEvent.CHARACTERS) {
            System.out.printf("email : %s%n", reader.getText());
        }
        LOGGER.info("handleEmailElement(...)");
    }

    public void handlePhoneElement(XMLStreamReader reader, int eventType) throws XMLStreamException {
        LOGGER.info("handlePhoneElement(" + reader + ", " + eventType + ")");
        String phoneId = reader.getAttributeValue(null, "id");
        System.out.printf("phone id : %s%n", phoneId);
        eventType = reader.next();

        if (eventType == XMLEvent.CHARACTERS) {
            System.out.printf("phone : %s%n", reader.getText());
        }
        LOGGER.info("handlePhoneElement(...)");
    }
}
