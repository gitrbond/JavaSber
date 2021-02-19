public class LegalEntity extends Client{
    @Override
    public String toString() {
        return "Holding{"
                + "name='" + name + '\n'
                + ", inn=" + inn + '\n'
                + ", clientType=" + clientType
                + "isSanctioned=" + isSanctioned + "\n}";
    }
}
