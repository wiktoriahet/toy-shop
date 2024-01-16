package pl.hetman.wiktoria.solvd.model;

import java.util.Objects;

public class Order {
    private Long id;
    private Long customerId;

    public Order() {
    }

    public Order(Long id, Long customerId) {
        this.id = id;
        this.customerId = customerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Order order)) return false;
        return Objects.equals(getId(), order.getId()) && Objects.equals(getCustomerId(), order.getCustomerId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomerId());
    }
}
