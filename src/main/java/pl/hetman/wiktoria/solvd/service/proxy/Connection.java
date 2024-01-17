package pl.hetman.wiktoria.solvd.service.proxy;

import pl.hetman.wiktoria.solvd.exceptions.WebException;

public interface Connection {
    boolean connect(String host) throws WebException;
}
