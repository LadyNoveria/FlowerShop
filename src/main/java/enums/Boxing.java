package enums;

public enum Boxing {

    BOX("коробка", 455),
    FILM("плёнка", 152),
    FLOWER_BASKET("корзина", 256);

    private final String boxing;
    private final double price;


    Boxing(String boxing, double price) {
        this.boxing = boxing;
        this.price = price;
    }

    public String getBoxing() {
        return boxing;
    }

    public double getPrice() {
        return price;
    }
}
