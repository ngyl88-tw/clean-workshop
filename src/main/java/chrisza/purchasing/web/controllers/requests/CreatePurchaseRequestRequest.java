package chrisza.purchasing.web.controllers.requests;

import chrisza.purchasing.domain.Employee;
import chrisza.purchasing.domain.PurchaseRequest;
import chrisza.purchasing.domain.PurchaseRequestItem;

import java.util.List;
import java.util.stream.Collectors;

public class CreatePurchaseRequestRequest {
    private List<PurchaseRequestItemRequest> items;
    private String ownerEmail;
    private String approverEmail;

    public PurchaseRequest toDomainObject() {
        List<PurchaseRequestItem> itemsDomain = items.stream()
                .map(PurchaseRequestItemRequest::toDomainObject)
                .collect(Collectors.toUnmodifiableList());

        return new PurchaseRequest(itemsDomain, new Employee(ownerEmail), new Employee(approverEmail));
    }

    /* Getters and Setters */

    public List<PurchaseRequestItemRequest> getItems() {
        return items;
    }

    public void setItems(List<PurchaseRequestItemRequest> items) {
        this.items = items;
    }

}
