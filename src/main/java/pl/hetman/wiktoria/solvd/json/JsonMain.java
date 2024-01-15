package pl.hetman.wiktoria.solvd.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.hetman.wiktoria.solvd.model.ToyShop;

import java.io.File;

public class JsonMain {
    public static void main(String[] args) {

        File fileName = new File("src/main/resources/toyshop.json");

        ObjectMapper mapper = new ObjectMapper();

        ToyShopJsonParser toyShopJsonParser = new ToyShopJsonParser();
        toyShopJsonParser.parse(fileName, mapper, ToyShop.class);
    }
}
