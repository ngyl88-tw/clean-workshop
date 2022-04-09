package chrisza.purchasing.persistance;

import chrisza.purchasing.domain.PurchaseRequest;
import chrisza.purchasing.domain.dependencies.PurchaseRequestRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PurchaseRequestRepositoryImpl implements PurchaseRequestRepository {

    private final List<PurchaseRequest> database = new ArrayList<>();

    @Override
    public PurchaseRequest Create(PurchaseRequest purchaseRequest) throws SavePurchaseRequestException {
        // assume validation at business domain
        // not saving if id exist
        if (purchaseRequest.getId() != null) {
            throw new SavePurchaseRequestException();
        }
        purchaseRequest.setId(UUID.randomUUID());
        database.add(purchaseRequest);
        return purchaseRequest;
    }

    @Override
    public PurchaseRequest getById(UUID id) {
        return database.stream()
                .filter(purchaseRequest -> id == purchaseRequest.getId())
                .findFirst()
                .orElse(null);
    }

}
