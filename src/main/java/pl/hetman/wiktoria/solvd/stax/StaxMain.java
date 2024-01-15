package pl.hetman.wiktoria.solvd.stax;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.nio.file.Paths;

public class StaxMain {

    public static void main(String[] args) {

        StaxToyShopHandler staxHandler = new StaxToyShopHandler();
        ToyShopStaxParser toyShopStaxParser = new ToyShopStaxParser(staxHandler);

        String fileName = "src/main/resources/toyshop.xml";


        try {
            toyShopStaxParser.printXmlByXmlCursorReader(Paths.get(fileName));
        } catch (FileNotFoundException | XMLStreamException e) {
            throw new RuntimeException(e);
        }
    }
}