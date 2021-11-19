public class AlwaysStick implements Strategy {
    @Override
    public boolean getStrategyChoice(Player player) {
        if (player.getPlayerCards().size() >= 2) return false;
        return true;
    }
}
