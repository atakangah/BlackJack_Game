public class AlwaysHit implements Strategy {
    @Override
    public boolean getStrategyChoice(Player player) {
        return true;
    }
}
