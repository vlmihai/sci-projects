import java.util.Date;

class Card {
    private String iban;
    private Date expirationDate;
    private long cardNumber;

    public Card(String iban, Date expirationDate, long cardNumber) {
        this.iban = iban;
        this.expirationDate = expirationDate;
        this.cardNumber = cardNumber;
    }

    public String getIban() { return iban; }

    public Date getExpirationDate() { return expirationDate; }

    public long getCardNumber() { return cardNumber; }

    public boolean isValid(){ return expirationDate.compareTo(new Date()) > 0; }
}