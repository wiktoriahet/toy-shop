package pl.hetman.wiktoria.solvd.service.abstractfactory;

import pl.hetman.wiktoria.solvd.exceptions.ContactException;
import pl.hetman.wiktoria.solvd.exceptions.SupplyException;

public abstract class AbstractFactory {
    abstract Contact getContact(String type) throws ContactException;
    abstract SupplyInfo getSupplyInfo(String type) throws SupplyException;
}
