/**
* This class is responsible to validate user input. Checks if input is between 1 and 100.
*/
class ValidationService {
    public static int validateInput(String input) throws InvalidInputException {
        try {
            int value = Integer.parseInt(input);

            if (value < 1 || value > 100) {
                throw new InvalidInputException("Number must be between 1 and 100");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Invalid input. Please enter numbers only.");
        }
    }
}
