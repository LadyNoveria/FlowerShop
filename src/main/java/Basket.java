import enums.Boxing;
import enums.Flowers;

import java.util.HashMap;
import java.util.Map;

public class Basket {

    private static Basket basket = null;
    private static Map<Flowers, Integer> flowers = new HashMap<>();
    private static Boxing boxing = null;
    private static double finalPrice;

    private Basket() {
    }

    public static Map<Flowers, Integer> getFlowers() {
        return flowers;
    }

    public static Boxing getBoxing() {
        return boxing;
    }

    public static double getFinalPrice() {
        return finalPrice;
    }

    public static Basket getBasket() {
        if (basket == null) {
            basket = new Basket();
        }
        return basket;
    }

    public static void addFlowersToBasket(Flowers flowerName, int quantityOfGoods) {
        getBasket();
        flowers.put(flowerName, quantityOfGoods);
    }

    public static void addBoxingToBasket(Boxing boxing) {
        getBasket();
        Basket.boxing = boxing;
    }

    public static boolean isEmpty() {
        return flowers.isEmpty() && isBoxingNull();
    }

    public static boolean isBoxingNull() {
        return boxing == null;
    }

    public static void deleteFlowerFromBasket(Flowers flowers) {
        Basket.flowers.remove(flowers);
    }

    public static void deleteBoxingFromBasket() {
        boxing = null;
    }

    public static void clearBasket() {
        flowers = new HashMap<>();
        boxing = null;
    }

    public static void printBasket() {
        System.out.println("Содержимое корзины");
        finalPrice = 0;
        for (Flowers flower : flowers.keySet()) {
            System.out.println("Товар: " + flower.getFlower() + " Количество: x" + flowers.get(flower) + " Цена: " + flower.getPrice());
            finalPrice += flower.getPrice() * flowers.get(flower);
        }
        if (boxing != null) {
            System.out.println("Товар: " + boxing.getBoxing() + " Количество: x1 Цена: " + boxing.getPrice());
            finalPrice += boxing.getPrice();
        }
        System.out.println("ИТОГО: " + finalPrice);
    }
}
