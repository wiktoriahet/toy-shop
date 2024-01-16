package pl.hetman.wiktoria.solvd.model.builder;

import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;

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

    public Long getOrderId() {
        return orderId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", employeeId=" + employeeId +
                '}';
    }

    public static class SaleBuilder{
        private Long id;
        private Long orderId;
        private Long employeeId;

        public SaleBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public SaleBuilder setOrderId(Long orderId) {
            this.orderId = orderId;
            return this;
        }

        public SaleBuilder setEmployeeId(Long employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Sale build() throws ToyShopException {
            if(id==null){
                throw new ToyShopException("Can't build Sale. Id is null");
            }
            return new Sale(id, orderId, employeeId);
        }
    }
}
