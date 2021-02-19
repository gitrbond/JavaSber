public class Holding extends Client{
    int HoldingID;
    @Override
    public String toString() {
        return "Holding{"
                + "name='" + name + '\n'
                + ", inn=" + inn + '\n'
                + ", clientType=" + clientType + ", ID=" + HoldingID + '\n'
                + "isSanctioned=" + isSanctioned + "\n}";
    }
}
