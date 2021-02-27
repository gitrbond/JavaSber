public class Owner {
    private final int ownerId;
    private final String name;
    private final String lastName;
    private final int age;

    public Owner(int ownerId, String name, String lastName, int age) {
        this.ownerId = ownerId;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format(name + " " + lastName + ", " + age + " years, oID: " + ownerId);
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = name.hashCode() + lastName.hashCode();
        result = prime * result + age;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Owner owner = (Owner) obj;
        if (!name.equals(owner.name))
            return false;
        if (!lastName.equals(owner.lastName))
            return false;
        if (age != owner.age)
            return false;
        return true;
    }
}