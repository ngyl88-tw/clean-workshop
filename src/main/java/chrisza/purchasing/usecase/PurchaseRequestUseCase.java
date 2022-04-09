package chrisza.purchasing.usecase;

import chrisza.purchasing.domain.Employee;
import chrisza.purchasing.domain.PurchaseRequest;
import chrisza.purchasing.domain.PurchaseRequestException;
import chrisza.purchasing.domain.PurchaseRequestItem;
import chrisza.purchasing.domain.dependencies.PurchaseRequestRepository;

import java.util.List;

public class PurchaseRequestUseCase {

    private final PurchaseRequestRepository repository;

    public PurchaseRequestUseCase(PurchaseRequestRepository repository) {
        this.repository = repository;
    }

    public PurchaseRequest Create(List<PurchaseRequestItem> items, Employee owner, Employee approver)
            throws PurchaseRequestException {
        PurchaseRequest purchaseRequest = PurchaseRequest.create(items, owner, approver);
        return repository.Create(purchaseRequest);
    }

}
