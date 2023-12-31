package pl.hetman.wiktoria.solvd.model;

public class ToyDiscount {
    private Long id;
    private Long toyId;
    private Long discountId;

    public ToyDiscount() {
    }

    public ToyDiscount(Long id, Long toyId, Long discountId) {
        this.id = id;
        this.toyId = toyId;
        this.discountId = discountId;
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

    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }

    @Override
    public String toString() {
        return "ToyDiscount{" +
                "id=" + id +
                ", toyId=" + toyId +
                ", discountId=" + discountId +
                '}';
    }
}
