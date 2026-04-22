// ABSTRACTION: An abstract class acts as a template
abstract class Payment {
    // ENCAPSULATION: private fields protected from outside interference
    private double amount;
    private String transactionId;

    public Payment(double amount, String transactionId) {
        this.amount = amount;
        this.transactionId = transactionId;
    }

    // Encapsulation: Public getters to safely access private data
    public double getAmount() { return amount; }
    public String getId() { return transactionId; }

    // Abstraction: Every payment must implement this, but in its own way
    public abstract void authorize();
}

// INHERITANCE: CreditCardPayment "is-a" Payment
class CreditCardPayment extends Payment {
    private String cardNumber;

    public CreditCardPayment(double amount, String id, String cardNumber) {
        super(amount, id); // Passing data to the parent constructor
        this.cardNumber = cardNumber;
    }

    @Override
    public void authorize() {
        System.out.println("[Credit Card] Authorizing $" + getAmount() + " for card: " + cardNumber);
    }
}

// INHERITANCE: PayPalPayment "is-a" Payment
class PayPalPayment extends Payment {
    private String email;

    public PayPalPayment(double amount, String id, String email) {
        super(amount, id);
        this.email = email;
    }

    @Override
    public void authorize() {
        System.out.println("[PayPal] Authorizing $" + getAmount() + " for account: " + email);
    }
}

// MAIN CLASS
public class PaymentSystem {
    public static void main(String[] args) {
        // POLYMORPHISM: Storing different objects in a single Payment list
        Payment[] wallet = {
            new CreditCardPayment(150.00, "TXN001", "1234-5678-9012"),
            new PayPalPayment(45.50, "TXN002", "user@example.com")
        };

        System.out.println("--- Processing Payments ---");
        for (Payment p : wallet) {
            // Polymorphism: Java knows which 'authorize' to call at runtime
            p.authorize(); 
        }
    }
}