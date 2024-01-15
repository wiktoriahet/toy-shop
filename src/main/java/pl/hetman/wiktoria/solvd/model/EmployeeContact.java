package pl.hetman.wiktoria.solvd.model;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;

import java.util.List;

public class EmployeeContact {

    private Long id;
    private Long employeeId;
    private List<Email> emails;
    private List<Phone> phones;

    public EmployeeContact() {
    }

    public EmployeeContact(Long id, Long employeeId, List<Email> emails, List<Phone> phones) {
        this.id = id;
        this.employeeId = employeeId;
        this.emails = emails;
        this.phones = phones;
    }

    @XmlAttribute(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @XmlElementWrapper(name = "emails")
    @XmlElement(name = "email")
    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    @XmlElementWrapper(name = "phones")
    @XmlElement(name = "phone")
    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "EmployeeContact{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", emails=" + emails +
                ", phones=" + phones +
                '}';
    }
}
