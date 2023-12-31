package pl.hetman.wiktoria.solvd.model;

public class Review {
    private Long id;
    private Long toyId;
    private Long customerId;

    public Review() {
    }

    public Review(Long id, Long toyId, Long customerId) {
        this.id = id;
        this.toyId = toyId;
        this.customerId = customerId;
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", toyId=" + toyId +
                ", customerId=" + customerId +
                '}';
    }
}
