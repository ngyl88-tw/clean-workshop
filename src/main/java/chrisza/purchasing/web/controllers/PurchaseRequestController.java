package chrisza.purchasing.web.controllers;

import chrisza.purchasing.domain.PurchaseRequest;
import chrisza.purchasing.domain.PurchaseRequestException;
import chrisza.purchasing.persistance.PurchaseRequestRepositoryImpl;
import chrisza.purchasing.usecase.PurchaseRequestUseCase;
import chrisza.purchasing.usecase.PurchaseSystemException;
import chrisza.purchasing.web.controllers.requests.CreatePurchaseRequestRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseRequestController {

    private static final PurchaseRequestUseCase USECASE = new PurchaseRequestUseCase(
            new PurchaseRequestRepositoryImpl()
    );

    @PostMapping("/purchase")
    public ResponseEntity<PurchaseRequest> create(@RequestBody CreatePurchaseRequestRequest request) {
        PurchaseRequest purchaseRequest = request.toDomainObject();
        try {
            return new ResponseEntity<>(USECASE.Create(purchaseRequest), HttpStatus.ACCEPTED);
        } catch (PurchaseSystemException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (PurchaseRequestException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
