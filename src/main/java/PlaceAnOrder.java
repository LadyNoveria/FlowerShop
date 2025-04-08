import Menu.PlaceAnOrderMenu;
import interfases.Printable;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class PlaceAnOrder {

    private static final Scanner SCANNER = new Scanner(System.in);
    /// Вынесла стоимость доставки в переменную SHIPPING_COST, чтобы избежать магических чисел
    private static final double SHIPPING_COST = 1582.45;
    Printable printable = new PlaceAnOrderMenu();

    public void workingWithPlaceAnOrderMenu() {
        while (true) {
            if (Basket.isEmpty()) {
                System.out.println("Hет заказов, доступных для оформления. Добавьте товары в корзину.");
                break;
            }
            System.out.println("Выберите, что нужно сделать");
            printable.print();
            int menuItem;
            try {
                menuItem = SCANNER.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Неверно введенное значение");
                return;
            }
            switch (menuItem) {
                case 1:
                    calculateTotalCost();
                    continue;
                case 2:
                    makeAnOrder();
                    return;
                case 3:
                default:
                    return;
            }
        }
    }

    private void calculateTotalCost() {
        System.out.println("Содержимое корзины");
        Basket.printBasket();
        double totalCosWithDelivery = Basket.getFinalPrice() + SHIPPING_COST;
        System.out.println("Итоговая стоимость с учетом доставки: " + totalCosWithDelivery);
    }

    private void makeAnOrder() {
        Random random = new Random();
        System.out.println("Введите адрес доставки");
        Scanner scanner = new Scanner(System.in);
        String address = scanner.nextLine();
        System.out.println("Поздравляем! Ваш заказ оформлен. \nДоставка по адресу: " + address + ". \nНомер заказа: " + Math.abs(random.nextInt()));
        Basket.clearBasket();
    }
}
