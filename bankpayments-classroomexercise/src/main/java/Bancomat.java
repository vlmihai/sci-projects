import java.util.ArrayList;

class Bancomat {

    private ArrayList<Card> cards = new ArrayList<>();

    void knowsAboutCard (Card card) { cards.add(card); }

    void withdraw(double amount, BankAccount bankAccount) {
        // iterate over all Cards and find out whether the Card is attached to an existing account.
        for (Card card : cards) {
            if (card.getIban().equals(bankAccount.getIban())) {
                // Method that checks that  to see if balance is sufficient for withdrawal.
                // If so, reduces balance by amount; if not, prints message.
                if (bankAccount.getBalance() >= amount) {
                    bankAccount.balance -= amount;
                    System.out.println("Balance is: " + bankAccount.getBalance());
                } else {
                    System.out.println("\nInsufficient funds. You are trying to withdraw: " + amount + " while balance is " + bankAccount.getBalance());
                }
            } else {
                System.out.println("\nBank Account Not Found");
            }
        }
    }

    void deposit(double amount, BankAccount bankAccount) {
        // iterate over all Cards and find out whether the Card is attached to an existing account.
        for (Card card : cards) {
                if (card.getIban().equals(bankAccount.getIban())) {
                    // Method that adds deposit amount to balance.
                    bankAccount.balance += amount;
                    System.out.println("Balance is: " + bankAccount.getBalance());
                } else {
                    System.out.println("\nBank Account Not Found");
                }
        }
    }
}


