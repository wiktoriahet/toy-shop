package pl.hetman.wiktoria.solvd.jaxb;

import pl.hetman.wiktoria.solvd.exceptions.FileException;
import pl.hetman.wiktoria.solvd.model.ToyShop;

import java.io.File;

public class JaxbMain {
    public static void main(String[] args) {

        File fileName = new File("src/main/resources/toyshop.xml");

        JaxbParser jaxbParser = new JaxbParser();
        try {
            ToyShop parsedToyShop = jaxbParser.parse(fileName);
            parsedToyShop.printToyShopInfo();
        } catch (FileException e) {
            throw new RuntimeException(e);
        }

    }
}
