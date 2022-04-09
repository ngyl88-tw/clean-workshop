package chrisza.purchasing.usecase;

import chrisza.purchasing.domain.PurchaseRequest;
import chrisza.purchasing.domain.PurchaseRequestException;
import chrisza.purchasing.domain.dependencies.PurchaseRequestRepository;
import chrisza.purchasing.persistance.SavePurchaseRequestException;

public class PurchaseRequestUseCase {

    private final PurchaseRequestRepository repository;

    public PurchaseRequestUseCase(PurchaseRequestRepository repository) {
        this.repository = repository;
    }

    public PurchaseRequest Create(PurchaseRequest purchaseRequest) throws PurchaseRequestException, PurchaseSystemException {
        purchaseRequest.validate();

        try {
            return repository.Create(purchaseRequest);
        } catch (SavePurchaseRequestException e) {
            throw new PurchaseSystemException(e);
        }
    }

}
