package pl.hetman.wiktoria.solvd;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import pl.hetman.wiktoria.solvd.model.ToyShop;

import java.io.File;

public class JaxbMain {
    public static void main(String[] args) {

        File fileName = new File("src/main/resources/toyshop.xml");

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ToyShop.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            ToyShop toyShop = (ToyShop) unmarshaller.unmarshal(fileName);
            System.out.println(toyShop.getToys());
            System.out.println(toyShop.getOrdersDates());
            System.out.println(toyShop.getEmployees());
            System.out.println(toyShop.getEmployeesContacts());
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }


    }
}
