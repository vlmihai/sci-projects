public class Main {

    public static void main(String[] args) {
        Person[] user = new Person[4];
        user[0] = new Person("Lucian", "Voicu", 1820108030023L);
        user[1] = new Person("Alexandru", "Voicu", 182010830032L);
        user[2] = new Person("Dan", "Voicu", 182010830032L);
        user[3] = new Person("Cristina", "Jurconi", 282010830032L);

        /* for (Person users : user) {
            System.out.println(" " + users.getFirstname() + " " + users.getLastname() + " ; cnp: " + users.getCnp());
        } */

        BankAccount btAccount = new BankAccount(120, "iban1");
        BankAccount btAccount1 = new BankAccount(220,"iban2");
        user[0].addBankAccount(btAccount);
        user[0].addBankAccount(btAccount1);
        Card btCard = new Card("iban1", DateUtils.getDate(2018,10,31), 4444333322221111L);
        Card btCard1 = new Card("iban2",DateUtils.getDate(2018, 11, 28), 5555444433332222L);
        btAccount.addCard(btCard);
        btAccount.addCard(btCard1);

        /* System.out.println("\nConturile inregistrate pentru Lucian Voicu sunt: " + user[0].getBankAccounts());
        System.out.println("\nCardurile inregistrate pentru contul: " + btAccount + " sunt:" +
                 "\n"+ btAccount.getCards()); */

        Bancomat bancomat = new Bancomat();
        bancomat.knowsAboutCard(btCard);
        bancomat.withdraw(200, btAccount);
        bancomat.deposit(80, btAccount);
    }
}
