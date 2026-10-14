/** Lab 5 - Challenge: common type for the two payment kinds. */
public interface Payment {
    double amount();
    void process();     // used by the polymorphic design only
}
