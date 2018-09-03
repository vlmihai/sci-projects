import java.util.ArrayList;
import java.util.List;

class Bancomat {

    private List<Card> cards = new ArrayList<>();

    void withdraw(double amount, BankAccount bankAccount) {
        // iterate over all Cards and find out whether the Card is attached to an existing account.
        for (Card card : cards) {
            if (card.getIban().equals(bankAccount.getIban())) {
                // Method that checks that  to see if balance is sufficient for withdrawal.
                // If so, reduces balance by amount; if not, prints message.
                if (bankAccount.getBalance() >= amount) {
                    bankAccount.balance -= amount;
                } else {
                    System.out.println("\nInsufficient funds");
                }
            }
            System.out.println("\nBank Account Not Found");
        }
    }

    void deposit(double amount, BankAccount bankAccount) {
        // iterate over all Cards and find out whether the Card is attached to an existing account.
        for (Card card : cards) {
                if (card.getIban().equals(bankAccount.getIban())) {
                    // Method that adds deposit amount to balance.
                    bankAccount.balance += amount;
                }
        }
    }
}


