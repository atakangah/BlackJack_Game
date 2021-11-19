public class RiskBased implements Strategy {
    @Override
    public boolean getStrategyChoice(Player player) {
        if (player.getPlayerScore() >= 17) return false;
        return true;
    }
}
