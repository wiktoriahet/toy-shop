package pl.hetman.wiktoria.solvd.model;

import java.math.BigDecimal;

public class ToyPrice {
    private Long id;
    private Long toyId;
    private BigDecimal price;

    public ToyPrice() {
    }

    public ToyPrice(Long id, Long toyId, BigDecimal price) {
        this.id = id;
        this.toyId = toyId;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getToyId() {
        return toyId;
    }

    public void setToyId(Long toyId) {
        this.toyId = toyId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ToyPrice{" +
                "id=" + id +
                ", toyId=" + toyId +
                ", price=" + price +
                '}';
    }
}
