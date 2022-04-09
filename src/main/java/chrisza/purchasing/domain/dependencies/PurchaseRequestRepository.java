package chrisza.purchasing.domain.dependencies;

import java.util.UUID;

import chrisza.purchasing.domain.PurchaseRequest;
import chrisza.purchasing.persistance.SavePurchaseRequestException;

public interface PurchaseRequestRepository {
    PurchaseRequest Create(PurchaseRequest purchaseRequest) throws SavePurchaseRequestException;

    PurchaseRequest getById(UUID id);
}
