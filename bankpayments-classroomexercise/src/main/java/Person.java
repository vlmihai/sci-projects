public class Person {
    //declarare
    private String firstname;
    private String lastname;
    private long cnp;

   Person(String firstname, String lastname, long cnp) {
        //initializare
        this.firstname = firstname;
        this.lastname = lastname;
        this.cnp = cnp;
    }

    String getFirstname() {
        return firstname;
    }
    String getLastname() {
        return lastname;
    }
    long getCnp() {
       return cnp;
    }

}

