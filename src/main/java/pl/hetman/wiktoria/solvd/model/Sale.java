package pl.hetman.wiktoria.solvd.model;

public class Sale {
    private Long id;
    private Long orderId;
    private Long employeeId;

    public Sale() {
    }

    public Sale(Long id, Long orderId, Long employeeId) {
        this.id = id;
        this.orderId = orderId;
        this.employeeId = employeeId;
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

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", employeeId=" + employeeId +
                '}';
    }
}
