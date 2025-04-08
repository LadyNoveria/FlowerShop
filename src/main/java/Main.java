import Menu.MainMenu;
import interfases.Printable;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    /// Принцип Single Responsibility principle - разная логика в разных классах
    private static final ChoiceOfFlowers CHOICE_OF_FLOWERS = new ChoiceOfFlowers();
    private static final EditOrder EDIT_ORDER = new EditOrder();
    private static final PlaceAnOrder PLACE_AN_ORDER = new PlaceAnOrder();
    private static final Printable printable = new MainMenu();

    public static void main(String[] args) {

        while (true) {
            printable.print();
            int menuItem = scanner.nextInt();
            switch (menuItem) {
                case 1:
                    CHOICE_OF_FLOWERS.workingWithChoiceOfFlowersMenu();
                    continue;
                case 2: {
                    if (Basket.isEmpty()) {
                        System.out.println("Корзина пуста.");
                    } else {
                        Basket.printBasket();
                    }
                }
                continue;
                case 3: {
                    if (Basket.isEmpty()) {
                        System.out.println("Hет заказов, доступных для редактирования. Добавьте товары в корзину.");
                    } else {
                        EDIT_ORDER.workingWithEditOrderMenu();
                    }
                }
                continue;
                case 4: {
                    if (Basket.isEmpty()) {
                        System.out.println("Hет заказов, доступных для оформления. Добавьте товары в корзину.");
                        continue;
                    } else {
                        PLACE_AN_ORDER.workingWithPlaceAnOrderMenu();
                    }
                    System.out.println("Всего доброго!");
                }
                return;
                case 5:
                    System.out.println("Корзина очищена");
                    Basket.clearBasket();
                    continue;
                case 6:
                default:
                    System.out.println("Всего доброго!");
                    return;
            }
        }
    }
}
