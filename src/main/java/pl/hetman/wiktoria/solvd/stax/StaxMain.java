package pl.hetman.wiktoria.solvd.stax;

import pl.hetman.wiktoria.solvd.parser.ToyShopStaxParser;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.nio.file.Paths;

public class StaxMain {

    public static void main(String[] args) {

        String fileName = "src/main/resources/toyshop.xml";

        ToyShopStaxParser toyShopStaxParser = new ToyShopStaxParser();
        try {
            toyShopStaxParser.printXmlByXmlCursorReader(Paths.get(fileName));
        } catch (FileNotFoundException | XMLStreamException e) {
            throw new RuntimeException(e);
        }

    }

}