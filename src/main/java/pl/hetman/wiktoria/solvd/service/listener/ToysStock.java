package pl.hetman.wiktoria.solvd.service.listener;

import pl.hetman.wiktoria.solvd.model.ToySupply;

import java.util.ArrayList;
import java.util.List;

public class ToysStock {

    private Integer toysInStock;
    private List<ToySupply> toySupplies = new ArrayList<>();

    public void addListener(ToySupply toySupply){
        this.toySupplies.add(toySupply);
    }

    public void removeListener(ToySupply toySupply){
        this.toySupplies.remove(toySupply);
    }

    public void setToysInStock(Integer toysInStock){
        this.toysInStock = toysInStock;
        for(ToySupply toySupply: this.toySupplies){
            toySupply.update(this.toysInStock);
        }
    }
}
