package models;

import java.util.List;

public class OrderDTO {
    private OrderProduct orderProduct;
    private List<DetailOrder> detailOrders;

    public OrderDTO(OrderProduct orderProduct, List<DetailOrder> detailOrders) {
        this.orderProduct = orderProduct;
        this.detailOrders = detailOrders;
    }

    public OrderProduct getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(OrderProduct orderProduct) {
        this.orderProduct = orderProduct;
    }

    public List<DetailOrder> getDetailOrders() {
        return detailOrders;
    }

    public void setDetailOrders(List<DetailOrder> detailOrders) {
        this.detailOrders = detailOrders;
    }
}
