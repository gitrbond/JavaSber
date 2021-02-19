public class Individual extends Client{
    String IndividualName;
    String IndividualSurname;
    @Override
    public String toString() {
        return "Holding{"
                + "name='" + name + '\n'
                + "owner: individual " + IndividualName + " " + IndividualSurname + "\n"
                + ", inn=" + inn + '\n'
                + ", clientType=" + clientType + '\n'
                + "isSanctioned=" + isSanctioned + "\n}";
    }
}
