package pl.hetman.wiktoria.solvd.model;

public class Phone {
    private Long id;
    private Long phone;

    public Phone() {
    }

    public Phone(Long id, Long phone) {
        this.id = id;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", phone=" + phone +
                '}';
    }
}
