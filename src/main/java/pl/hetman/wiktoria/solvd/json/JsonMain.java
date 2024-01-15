package pl.hetman.wiktoria.solvd.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import pl.hetman.wiktoria.solvd.model.ToyShop;

import java.io.File;
import java.io.IOException;

public class JsonMain {
    public static void main(String[] args) {

        File fileName = new File("src/main/resources/toyshop.json");

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        try {
            ToyShop toyShop = mapper.readValue(fileName, ToyShop.class);
            System.out.println(toyShop.getToys());
            System.out.println(toyShop.getEmployees());
            System.out.println(toyShop.getEmployeesContacts());
            System.out.println(toyShop.getSuppliersContacts());
            System.out.println(toyShop.getOrdersDates());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
