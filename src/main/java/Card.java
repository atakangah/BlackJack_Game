public class Card{
    private Suit cardType;
    private int value;
    private String cardName;

    public Card(Suit cardType, String cardName, int value) {
        this.cardType = cardType;
        this.cardName = cardName;
        this.value = value;
    }

    public Suit getCardType() {
        return cardType;
    }

    public void setCardType(Suit cardType) {
        this.cardType = cardType;
    }


   public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCardName() {
        return cardName;
    }


    @Override
    public String toString() {
        return "Card{" +
                "cardType=" + cardType +
                ", value=" + value +
                ", cardName='" + cardName + '\'' +
                '}';
    }
}
