/**
 * Use Case 3: Hint Generation
 * 
 * This class is responsible for generating controlled hints based on number of incorrect attempts
 */

class HintService {
    public static String generateHint(int target, int hintCount) {
        /**
         * Generates an hint based on how many hints have already been used.
         */
        if (hintCount == 1) {
            return (target % 2 == 0)
            ? "Hint: NUMBER is EVEN"
            : "Hint: NUMBER is ODD";
        } else if (hintCount == 2) {
            return (target >= 50)
            ? "Hint: Number is greater than 50"
            : "Hint: Number is 50 or less";
        }

        return "No more hints available";
    }
}