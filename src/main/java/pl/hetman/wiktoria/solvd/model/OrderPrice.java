package pl.hetman.wiktoria.solvd.model;

import java.math.BigDecimal;

public class OrderPrice {
    private Long id;
    private Long orderId;
    private BigDecimal price;

    public OrderPrice() {
    }

    public OrderPrice(Long id, Long orderId, BigDecimal price) {
        this.id = id;
        this.orderId = orderId;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderPrice{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", price=" + price +
                '}';
    }
}
