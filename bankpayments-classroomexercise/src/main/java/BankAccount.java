class BankAccount {
    double balance;
    private String iban;
    private int anualInterestRate;

    // Here is where you create a default account.
    BankAccount(int balance, String iban) {
        this.balance = balance;
        this.iban = iban;
    }

    double getBalance() {
        return balance;
    }

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
}

