package chrisza.purchasing.domain;

import java.util.List;
import java.util.UUID;

public class PurchaseRequest {
    private UUID id;
    private List<PurchaseRequestItem> Items;
    private Employee Owner;
    private Employee Approver;

    private static final int AMOUNT_REQUIRING_SENIOR_MANAGEMENT_APPROVAL = 100_000;

    PurchaseRequest(List<PurchaseRequestItem> items, Employee owner, Employee approver) {
        this.setItems(items);
        this.setOwner(owner);
        this.setApprover(approver);
    }

    public static PurchaseRequest create(List<PurchaseRequestItem> items, Employee owner, Employee approver)
            throws PurchaseRequestException {

        if (!approver.isHigherLevelThan(owner)) {
            throw new PurchaseRequestException("Invalid approver hierarchy.");
        }

        int totalPurchase = items.stream()
                .mapToInt(PurchaseRequestItem::getTotalPrice)
                .sum();
        checkApproverByTotalPurchase(totalPurchase, approver);

        return new PurchaseRequest(items, owner, approver);

    }

    private static void checkApproverByTotalPurchase(int totalPurchase, Employee approver) throws PurchaseRequestException {
        if(!approver.isManagement()) {
            throw new PurchaseRequestException("Approver need to be Management level.");
        }

        if (totalPurchase >= AMOUNT_REQUIRING_SENIOR_MANAGEMENT_APPROVAL && !approver.isSeniorManagement()) {
            throw new PurchaseRequestException("Require Senior Management approval for purchase amount.");
        }
    }

    /* Getters and Setters */

    public Employee getApprover() {
        return Approver;
    }

    public void setApprover(Employee approver) {
        this.Approver = approver;
    }

    public Employee getOwner() {
        return Owner;
    }

    public void setOwner(Employee owner) {
        this.Owner = owner;
    }

    public List<PurchaseRequestItem> getItems() {
        return Items;
    }

    public void setItems(List<PurchaseRequestItem> items) {
        this.Items = items;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
