/** Lab 1 - Challenge (part 2): Person HAS-A Address; shows chained dots and null handling. */
public class Person {
    String name;
    Address address;   // reference to another object, may be null

    public static void main(String[] args) {
        Address a = new Address();
        a.street = "12 Main Road";
        a.city = "Nairobi";

        Person withAddress = new Person();
        withAddress.name = "Amina";
        withAddress.address = a;

        // Chained dot expression: person -> address -> city
        System.out.println(withAddress.name + " lives in " + withAddress.address.city);

        Person noAddress = new Person();
        noAddress.name = "Brian";          // address was never set, so it is null

        // Safe way: check for null first
        if (noAddress.address == null) {
            System.out.println(noAddress.name + " has no address (null check works)");
        }

        // Unsafe way: this throws NullPointerException
        try {
            System.out.println(noAddress.address.city);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: address is null, so .city cannot be read");
        }
    }
}
