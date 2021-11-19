import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static class InvalidPlayerNumberException extends Exception {
        @Override
        public String getMessage() {
            return "Invalid number of players entered";
        }
    }

    static class InvalidPlayerStrategyParametersException extends Exception {
        @Override
        public String getMessage() {
            return "You entered the players and their strategies wrong. Please try again";
        }
    }

    public static void main(String[] args) {
        List<String> strategies = parsePlayerStrategiesCommands(args);
        List<Player> gamePlayers = generateGamePlayers(strategies);
        startGame(gamePlayers);
    }

    public static void parseNumberOfPlayers(String[] commands) {
        try {
            if (Integer.parseInt(commands[0]) < 2 || Integer.parseInt(commands[0]) > 6)
                throw new InvalidPlayerNumberException();

            List<String> defaultStrategies = IntStream.range(0, Integer.parseInt(commands[0])).mapToObj(idx -> "default").collect(Collectors.toList());
            startGame(generateGamePlayers(defaultStrategies));

        } catch (NumberFormatException nfe) {
            System.out.println("Please enter an integer for the number of players");
        } catch (IndexOutOfBoundsException ioob) {
            startGame(generateGamePlayers(List.of("default", "default", "default")));
        } catch (InvalidPlayerNumberException ipne) {
            System.out.println(ipne.getMessage());
        }
    }

    public static List<String> parsePlayerStrategiesCommands(String[] commands) {
        try {
            if (commands.length > 12) throw new InvalidPlayerStrategyParametersException();
            if (commands.length < 4) throw new InvalidPlayerStrategyParametersException();
        } catch (InvalidPlayerStrategyParametersException ipse) {
            System.out.println(ipse.getMessage());
            System.exit(0);
        }
        return Arrays.stream(commands).filter(command -> !command.startsWith("--")).collect(Collectors.toList());
    }

    public static List<Player> generateGamePlayers(List<String> strategies) {
        //IntStream.range(1, strategies.size()+1).forEach(idx -> System.out.println("Player " + idx + " is using the " + strategies.get(idx-1) + " strategy"));
        return IntStream.range(1, strategies.size()+1).mapToObj(idx -> generatePlayerWithStrategy(idx, strategies.get(idx-1))).collect(Collectors.toList());
    }

    public static Player generatePlayerWithStrategy(int index, String strategyType) {
        Player player = new Player(1 + "", new Default());
        try {
            switch (strategyType) {
                case "always-hit":
                    player = new Player("Player " + index + "", new AlwaysHit());
                    break;
                case "always-stick":
                    player = new Player("Player " + index + "", new AlwaysStick());
                    break;
                case "risk-calculator":
                    player = new Player("Player " + index + "", new RiskBased());
                    break;
                case "default":
                    player = new Player("Player " + index + "", new Default());
                    break;
                default:
                    throw new InvalidPlayerStrategyParametersException();
            }
        } catch (InvalidPlayerStrategyParametersException ipse) {
            System.out.println(ipse.getMessage());
            System.exit(0);
        }
        return player;
    }

    static void startGame(List<Player> gamePlayers) {
        new Game(gamePlayers);
    }
}
