public class LegalEntity extends Client{

    public LegalEntity(String name, int inn, String clientType, boolean isSanctioned) {
        super(name, inn, clientType, isSanctioned);
    }

    @Override
    public String toString() {
        return "{"
                + "name='" + name + '\n'
                + ", inn=" + inn + '\n'
                + ", clientType=" + clientType + "\n"
                + "isSanctioned=" + isSanctioned + "\n}";
    }
}
