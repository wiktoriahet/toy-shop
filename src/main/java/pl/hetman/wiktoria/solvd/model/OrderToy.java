package pl.hetman.wiktoria.solvd.model;

public class OrderToy {
    private Long id;
    private Long orderId;
    private Long toyId;
    private Integer quantity;

    public OrderToy() {
    }

    public OrderToy(Long id, Long orderId, Long toyId, Integer quantity) {
        this.id = id;
        this.orderId = orderId;
        this.toyId = toyId;
        this.quantity = quantity;
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

    public Long getToyId() {
        return toyId;
    }

    public void setToyId(Long toyId) {
        this.toyId = toyId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderToy{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", toyId=" + toyId +
                ", quantity=" + quantity +
                '}';
    }
}
