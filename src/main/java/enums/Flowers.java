package enums;

public enum Flowers {

    TULIP_YELLOW("тюльпан жёлтый", 125),
    TULIP_RED("тюльпан белый", 124),
    WHITE_ROSE("роза белая", 180),
    TEA_ROSE("роза чайная", 200),
    RED_ROSE("роза красная", 160),
    CHRYSANTHEMUM("хризантема", 80),
    PEONY("пион", 230),
    NARCISSUS("нарцисс", 90),
    LILY("лилия", 195);

    private final String flower;
    private final double price;


    Flowers(String flower, double price) {
        this.flower = flower;
        this.price = price;
    }

    public String getFlower() {
        return flower;
    }

    public double getPrice() {
        return price;
    }
}