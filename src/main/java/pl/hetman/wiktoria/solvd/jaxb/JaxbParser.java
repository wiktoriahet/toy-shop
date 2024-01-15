package pl.hetman.wiktoria.solvd.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.FileException;
import pl.hetman.wiktoria.solvd.model.ToyShop;

import java.io.File;

public class JaxbParser {

    private static final Logger LOGGER = LogManager.getLogger(JaxbParser.class);

    public ToyShop parse(File file) throws FileException {
        if (file != null) {
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(ToyShop.class);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                ToyShop toyShop = (ToyShop) unmarshaller.unmarshal(file);
                return toyShop;
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }
        } else if (file == null) {
            throw new FileException("Can't parse the file. The file is null");
        }
        return null;
    }
}
