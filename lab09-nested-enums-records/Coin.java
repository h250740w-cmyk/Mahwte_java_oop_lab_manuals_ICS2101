import java.util.EnumMap;
import java.util.Map;

/** Lab 9 - Challenge: enum with a field, a constructor and a greedy change-maker. */
public enum Coin {
    PENNY(1), NICKEL(5), DIME(10), QUARTER(25);

    private final int cents;

    Coin(int cents) { this.cents = cents; }

    public int getCents() { return cents; }

    /**
     * Fewest coins for an amount. Greedy (largest coin first) is optimal for THIS coin set.
     * It is not optimal for every set (e.g. coins 1, 3, 4 and amount 6 needs 2 coins, greedy gives 3).
     */
    public static Map<Coin, Integer> makeChange(int amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount cannot be negative");
        Map<Coin, Integer> result = new EnumMap<>(Coin.class);
        Coin[] all = values();
        for (int i = all.length - 1; i >= 0; i--) {          // QUARTER down to PENNY
            int count = amount / all[i].cents;
            if (count > 0) {
                result.put(all[i], count);
                amount -= count * all[i].cents;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] tests = {0, 1, 30, 41, 99, 100};
        for (int t : tests) {
            Map<Coin, Integer> change = makeChange(t);
            int coins = change.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println(t + " cents -> " + change + "  (" + coins + " coins)");
        }
    }
}
