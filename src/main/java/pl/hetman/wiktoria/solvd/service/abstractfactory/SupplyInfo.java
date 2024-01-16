package pl.hetman.wiktoria.solvd.service.abstractfactory;

import java.util.Optional;

public interface SupplyInfo<T> {
    Optional<T> getSupplyInfo();
}
