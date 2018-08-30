public class Main {

    public static void main(String[] args) {
        Person[] user = new Person[4];
        user[0] = new Person("Lucian", "Voicu", 1820108030023L);
        user[1] = new Person("Alexandru", "Voicu", 182010830032L);
        user[2] = new Person("Dan", "Voicu", 182010830032L);
        user[3] = new Person("Cristina", "Jurconi", 282010830032L);

        for (Person users : user) {
            System.out.println(" " + users.getFirstname() + " " + users.getLastname() + " ; cnp: " + users.getCnp());
        }

        BankAccount btAccount = new BankAccount(120, "iban1");
        user[0].addBankAccount(btAccount);

        Card btCard = new Card("iban1", DateUtils.getDate(2018,10,31), 4444333322221111L);

        Bancomat bancomat = new Bancomat();

    }



}
