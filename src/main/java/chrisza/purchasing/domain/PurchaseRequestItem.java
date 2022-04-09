package chrisza.purchasing.domain;

import java.util.UUID;

public class PurchaseRequestItem {
    private UUID Id;
    private final String Item;
    private final int Amount;
    private final int TotalPrice;

    public PurchaseRequestItem(String item, int amount, int totalPrice) {
        Item = item;
        Amount = amount;
        TotalPrice = totalPrice;
    }

    /* Getters and Setters */

    public UUID getId() {
        return Id;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public int getAmount() {
        return Amount;
    }

    public String getItem() {
        return Item;
    }

    public void setId(UUID id) {
        this.Id = id;
    }
}
