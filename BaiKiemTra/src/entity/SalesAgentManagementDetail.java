package entity;

import constant.ItemsType;
import logic.SalesAgentLogic;

public class SalesAgentManagementDetail {

    private ItemsType itemsType;
    private int quantity;

    public SalesAgentManagementDetail(ItemsType itemsType, int quantity) {
        this.itemsType = itemsType;
        this.quantity = quantity;
    }

    public ItemsType getItemsType() {
        return itemsType;
    }

    public void setItemsType(ItemsType itemsType) {
        this.itemsType = itemsType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "SalesAgentManagementDetail{" +
                "itemsType=" + itemsType +
                ", quantity=" + quantity +
                '}';
    }
}
