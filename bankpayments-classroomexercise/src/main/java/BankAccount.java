class BankAccount {
    private double balance;
    private String iban;
    private double anualInterestRate;

    // Here is where you create a default account.
    BankAccount(int balance, String iban, double anualInterestRate) {
        this.balance = balance;
        this.iban = iban;
        this.anualInterestRate = anualInterestRate;
    }

    double getBalance() {
        return balance;
    }

    String getIban() {
        return iban;
    }

    private double getAnualInterestRate() {
        return anualInterestRate/100;
    }

    // Method that checks to see if balance is sufficient for withdrawal.
    // If so, reduces balance by amount; if not, prints message.
    void withdraw(double amount) {
        if (balance >= amount)
        {
            balance -= amount;
        } else {
            System.out.println("\nInsufficient funds");
        }
    }
    // Method that adds deposit amount to balance.
    void deposit(double amount) {
        balance += amount;
    }

    // Adds interest to the account and returns the new balance.
    double addInterest () {
        balance += balance * getAnualInterestRate();
        return balance;
    }
}
