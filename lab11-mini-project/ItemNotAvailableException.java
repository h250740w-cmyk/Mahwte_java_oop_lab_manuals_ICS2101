/** Checked exception: the item is already on loan. */
public class ItemNotAvailableException extends Exception {
    public ItemNotAvailableException(String title) {
        super("'" + title + "' is currently on loan");
    }
}
