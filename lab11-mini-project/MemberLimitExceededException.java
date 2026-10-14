/** Checked exception: the member already holds the maximum number of loans. */
public class MemberLimitExceededException extends Exception {
    public MemberLimitExceededException(String memberName, int max) {
        super(memberName + " already has the maximum of " + max + " loans");
    }
}
