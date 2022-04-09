package chrisza.purchasing.usecase;

import chrisza.purchasing.domain.PurchaseRequest;
import chrisza.purchasing.domain.PurchaseRequestException;
import chrisza.purchasing.domain.dependencies.PurchaseRequestRepository;

public class PurchaseRequestUseCase {

    private final PurchaseRequestRepository repository;

    public PurchaseRequestUseCase(PurchaseRequestRepository repository) {
        this.repository = repository;
    }

    public PurchaseRequest Create(PurchaseRequest purchaseRequest) throws PurchaseRequestException {
        purchaseRequest.validate();
        return repository.Create(purchaseRequest);
    }

}
