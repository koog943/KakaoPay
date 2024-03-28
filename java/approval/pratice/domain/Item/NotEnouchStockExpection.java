package approval.pratice.domain.Item;

public class NotEnouchStockExpection extends RuntimeException {
    public NotEnouchStockExpection(String message) {
    }

    public NotEnouchStockExpection() {
    }

    public NotEnouchStockExpection(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnouchStockExpection(Throwable cause) {
        super(cause);
    }
}
