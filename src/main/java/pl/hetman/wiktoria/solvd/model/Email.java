package pl.hetman.wiktoria.solvd.model;

import jakarta.xml.bind.annotation.XmlAttribute;

public class Email {

    private Long id;
    private String email;

    public Email() {
    }

    public Email(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    @XmlAttribute(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
