package pl.hetman.wiktoria.solvd.model;

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
}
