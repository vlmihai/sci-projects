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

        BankAccount[] bankAccounts = new BankAccount[4];
        bankAccounts[0] = new BankAccount(120, "RO61BTRLRONCRT0400355001", 5 );
        bankAccounts[1] = new BankAccount(150, "RO14TREZ2165503XXXXXXXXX", 4);
        bankAccounts[2] = new BankAccount(180, "RO14TREZ21620A470300XXXX", 4.5);
        bankAccounts[3] = new BankAccount(150, "RO11RNCB0026152073040001", 4.2);


        bankAccounts[0].withdraw(20);
        bankAccounts[0].deposit(120);
        bankAccounts[0].addInterest();
            System.out.println("\nNew balance for " + user[0].getFirstname() + " " + user[0].getLastname() + " " + bankAccounts[0].getIban() + " is: " + bankAccounts[0].getBalance());

    }

}
