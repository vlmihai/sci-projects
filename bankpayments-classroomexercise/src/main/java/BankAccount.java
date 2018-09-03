import java.util.ArrayList;
import java.util.List;

class BankAccount {
    double balance;
    private String iban;
    private int anualInterestRate;

    // Here is where you create a default account.
    BankAccount(int balance, String iban) {
        this.balance = balance;
        this.iban = iban;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", iban='" + iban + '\'' +
                '}';
    }

    double getBalance() {
        return balance;
    }

    double setBalance (double balance) { return this.balance = balance; }

    String getIban() {
        return iban;
    }

    public void setAnualInterestRate(int anualInterestRate) {
        this.anualInterestRate = anualInterestRate;
    }

    // Adds interest to the account and returns the new balance.
    double addInterest () {
        balance += balance * anualInterestRate/100;
        return balance;
    }

    private List<Card> cards = new ArrayList<>();

    List<Card> getCards() { return cards; }

    void addCard (Card card) { cards.add(card); }
}

