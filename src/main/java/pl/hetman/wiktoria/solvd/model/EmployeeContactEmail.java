package pl.hetman.wiktoria.solvd.model;

import java.util.List;

public class EmployeeContactEmail {

    private Long id;
    private Long employeeId;
    private List<Email> emails;

    public EmployeeContactEmail() {
    }

    public EmployeeContactEmail(Long id, Long employeeId, List<Email> emails) {
        this.id = id;
        this.employeeId = employeeId;
        this.emails = emails;
    }

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

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    @Override
    public String toString() {
        return "EmployeeContactEmail{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", emails=" + emails +
                '}';
    }
}
