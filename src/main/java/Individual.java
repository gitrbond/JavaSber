public class Individual extends Client{
    String IndividualName;
    String IndividualSurname;

    public Individual(String name, int inn, String clientType, boolean isSanctioned, String indName, String indSurname) {
        super(name, inn, clientType, isSanctioned);
        this.IndividualName = indName;
        this.IndividualSurname = indSurname;
    }

    @Override
    public String toString() {
        return "{"
                + "name='" + name + '\n'
                + "owner: individual " + IndividualName + " " + IndividualSurname + "\n"
                + ", inn=" + inn + '\n'
                + ", clientType=" + clientType + '\n'
                + "isSanctioned=" + isSanctioned + "\n}";
    }
}
