package sciprojects.stringutility.homework;

class Sentances {
    private String sentance;

    Sentances(String sentance) {
        this.sentance = sentance;
    }

    String getSentance() {
        return sentance;
    }

    @Override
    public String toString() {
        return "Sentances{" +
                "sentance='" + sentance + '\'' +
                '}';
    }
}
