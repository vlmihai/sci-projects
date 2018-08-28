import java.util.Date;

class Card {
    private String iban;
    private Date expirationDate;
    private int cardNumber;

    public Card(String iban, Date expirationDate, int cardNumber) {
        this.iban = iban;
        this.expirationDate = expirationDate;
        this.cardNumber = cardNumber;
    }

    public String getIban() { return iban; }

    public Date getExpirationDate() { return expirationDate; }

    public int getCardNumber() { return cardNumber; }

    public boolean isValid(){ return expirationDate.compareTo(new Date()) > 0; }
}