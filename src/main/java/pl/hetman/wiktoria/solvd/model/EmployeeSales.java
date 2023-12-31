package pl.hetman.wiktoria.solvd.model;

public class EmployeeSales {
    private Long id;
    private Long employeeId;
    private Integer totalSales;

    public EmployeeSales() {
    }

    public EmployeeSales(Long id, Long employeeId, Integer totalSales) {
        this.id = id;
        this.employeeId = employeeId;
        this.totalSales = totalSales;
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

    public Integer getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Integer totalSales) {
        this.totalSales = totalSales;
    }

    @Override
    public String toString() {
        return "EmployeeSales{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", totalSales=" + totalSales +
                '}';
    }
}
