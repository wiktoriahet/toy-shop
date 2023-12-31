package pl.hetman.wiktoria.solvd.model;

public class ToySupply {
    private Long id;
    private Long toyId;
    private Integer quantity;

    public ToySupply() {
    }

    public ToySupply(Long id, Long toyId, Integer quantity) {
        this.id = id;
        this.toyId = toyId;
        this.quantity = quantity;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ToySupply{" +
                "id=" + id +
                ", toyId=" + toyId +
                ", quantity=" + quantity +
                '}';
    }
}
