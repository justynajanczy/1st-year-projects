public class Person {
    String firstName;
    String secondName;

    public Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    @Override
    public String toString()
    {
        return "" + firstName + " " + secondName;
    }
}
