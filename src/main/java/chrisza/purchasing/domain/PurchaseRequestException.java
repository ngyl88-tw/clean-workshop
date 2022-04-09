package chrisza.purchasing.domain;

public class PurchaseRequestException extends Exception {
    private final String reason;

    public PurchaseRequestException(String reason) {
        super();
        this.reason = reason;
    }
}
