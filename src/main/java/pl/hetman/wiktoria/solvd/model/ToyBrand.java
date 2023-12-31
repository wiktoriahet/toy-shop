package pl.hetman.wiktoria.solvd.model;

public class ToyBrand {
    private Long id;
    private Long toyId;
    private Long brandId;

    public ToyBrand() {
    }

    public ToyBrand(Long id, Long toyId, Long brandId) {
        this.id = id;
        this.toyId = toyId;
        this.brandId = brandId;
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

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    @Override
    public String toString() {
        return "ToyBrand{" +
                "id=" + id +
                ", toyId=" + toyId +
                ", brandId=" + brandId +
                '}';
    }
}
