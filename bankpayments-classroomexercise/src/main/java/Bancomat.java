import java.util.ArrayList;

class Bancomat {

    private ArrayList<Card> cards = new ArrayList<>();

    public ArrayList<Card> getCards() { return cards; }

    public void addCard (Card card) {
        cards.add(card);
    }

    void withdraw(double amount) {

        // iterate over all Cards and find out whether the Card is attached to an existing account.
        for (Card card : cards) {
                if (card.getIban().equals(.getIban())){
            }

            // Method that checks that  to see if balance is sufficient for withdrawal.
            // If so, reduces balance by amount; if not, prints message.
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

}


