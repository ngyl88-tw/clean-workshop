package chrisza.purchasing.web.controllers.requests;

import chrisza.purchasing.domain.PurchaseRequestItem;

public class PurchaseRequestItemRequest {
    private String item;
    private int amount;
    private int totalPrice;

    public PurchaseRequestItem toDomainObject() {
        return new PurchaseRequestItem(item, amount, totalPrice);
    }

    /* Getters and Setters */

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
