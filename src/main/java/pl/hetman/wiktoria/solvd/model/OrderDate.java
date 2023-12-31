package pl.hetman.wiktoria.solvd.model;

import java.time.LocalDateTime;

public class OrderDate {
    private Long id;
    private Long orderId;
    private LocalDateTime date;

    public OrderDate() {
    }

    public OrderDate(Long id, Long orderId, LocalDateTime date) {
        this.id = id;
        this.orderId = orderId;
        this.date = date;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "OrderDate{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", date=" + date +
                '}';
    }
}
