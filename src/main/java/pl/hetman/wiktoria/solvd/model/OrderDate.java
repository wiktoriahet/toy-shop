package pl.hetman.wiktoria.solvd.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import pl.hetman.wiktoria.solvd.jaxb.LocalDateTimeAdapter;

import java.time.LocalDateTime;

public class OrderDate {

    private Long id;
    private Long orderId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    public OrderDate() {
    }

    public OrderDate(Long id, Long orderId, LocalDateTime date) {
        this.id = id;
        this.orderId = orderId;
        this.date = date;
    }

    @XmlAttribute(name = "id")
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

    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
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
