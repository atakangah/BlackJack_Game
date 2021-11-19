import java.util.Arrays;

public class Main {
    static class InvalidPlayerNumberException extends Exception {
        @Override
        public String getMessage() {
            return "Invalid number of players entered";
        }
    }

    public static void main(String[] args) {
        try {
            if (Integer.parseInt(args[0]) < 2 || Integer.parseInt(args[0]) > 6)
                throw new InvalidPlayerNumberException();
            startGame(Integer.parseInt(args[0]));
        } catch (NumberFormatException nfe) {
            System.out.println("Please enter an integer for the number of players");
        } catch (IndexOutOfBoundsException ioob) {
            startGame(3);
        } catch (InvalidPlayerNumberException ipne) {
            System.out.println(ipne.getMessage());
        }
    }

    static void startGame(int numberOfPlayers) {
        new Game(numberOfPlayers);
    }
}
