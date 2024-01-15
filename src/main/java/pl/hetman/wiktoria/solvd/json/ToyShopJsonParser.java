package pl.hetman.wiktoria.solvd.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.model.ToyShop;

import java.io.File;
import java.io.IOException;

public class ToyShopJsonParser {

    private static final Logger LOGGER = LogManager.getLogger(ToyShopJsonParser.class);

    void parse(File file, ObjectMapper mapper, Class<ToyShop> toyShopClass) {
        mapper.registerModule(new JavaTimeModule());

        try {
            ToyShop toyShop = mapper.readValue(file, toyShopClass);
            toyShop.printToyShopInfo();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
