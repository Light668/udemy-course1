package de.light668.ecomdashboard.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="OrderRecieved",schema = "ecomDashApp")
public class OrderRecieved extends KeyEntity{

    private int orderReceived;
    private String dateReceived;

    public int getOrderReceived() {
        return orderReceived;
    }

    public void setOrderReceived(int orderReceived) {
        this.orderReceived = orderReceived;
    }

    public String getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }
}
