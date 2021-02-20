public class Client {
    String name;// - наименование
    int inn;// - инн
    String clientType;// – принадлежность к отрасли
    boolean isSanctioned;// – признак принадлежности к санкционным клиентам

    public Client(){}

    public Client(String name, int inn, String clientType, boolean isSanctioned) {
        this.name = name;
        this.inn = inn;
        this.clientType = clientType;
        this.isSanctioned = isSanctioned;
    }

    /*public String toString() {
        return "Holding{"
                + "name='" + name + '\n'
                + ", inn=" + inn + '\n'
                + ", clientType=" + clientType
                + ", isSanctioned=" + isSanctioned + "\n}";
    }*/
}
