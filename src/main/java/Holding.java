public class Holding extends Client{
    int HoldingID;

    public Holding(String name, int inn, String clientType, boolean isSanctioned, int HoldingID) {
        super(name, inn, clientType, isSanctioned);
        this.HoldingID = HoldingID;
    }

    @Override
    public String toString() {
        return "{"
                + "name='" + name + '\n'
                + ", inn=" + inn + '\n'
                + ", clientType=" + clientType + ", ID=" + HoldingID + '\n'
                + "isSanctioned=" + isSanctioned + "\n}";
    }
}
