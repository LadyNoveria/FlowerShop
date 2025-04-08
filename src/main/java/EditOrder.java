import Menu.EditOrderMenu;
import enums.Flowers;
import interfases.Printable;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class EditOrder {

    private static final Scanner SCANNER = new Scanner(System.in);
    Printable printable = new EditOrderMenu();

    public void workingWithEditOrderMenu() {
        while (true) {
            if (Basket.isEmpty()) {
                System.out.println("Hет заказов, доступных для редактирования. Добавьте товары в корзину.");
                break;
            }

            System.out.println("Содержимое корзины: ");
            Basket.printBasket();
            System.out.println("Выберите, что нужно сделать");
            printable.print();
            int menuItem = SCANNER.nextInt();
            switch (menuItem) {
                case 1:
                    deleteOrderItem();
                    continue;
                case 2:
                    editQuantity();
                    continue;
                case 3:
                default:
                    return;
            }
        }
    }

    private void deleteOrderItem() {
        System.out.println("Выберите товар, который нужно удалить: ");
        Scanner scanner = new Scanner(System.in);
        String itemMenu = scanner.nextLine();
        Set<Flowers> items = Basket.getFlowers().keySet();

        int count = 0;
        for (Flowers flower : items) {
            if (itemMenu.equals(flower.getFlower())) {
                Basket.deleteFlowerFromBasket(flower);
                count = 1;
                System.out.println("Товар удален.");
                break;
            }
        }
        if (count == 0) {
            if (itemMenu.equals(Basket.getBoxing().getBoxing())) {
                Basket.deleteBoxingFromBasket();
                count = 1;
                System.out.println("Товар удален.");
            }
        }
        if (count == 0) {
            System.out.println("Hет заказов, доступных для удаления. Добавьте товары в корзину.");
        }
    }

    private void editQuantity() {
        List<Flowers> flowers = Basket.getFlowers().keySet().stream().toList();
        try {
            System.out.print("Выберите цветок, количество которого нужно поменять: ");
            printFlowers(flowers);
            int flower = SCANNER.nextInt();
            System.out.print("Введите количество: ");
            int numberOfFlowers = SCANNER.nextInt();
            Basket.addFlowersToBasket(flowers.get(flower), numberOfFlowers);
        } catch (Exception e) {
            System.out.println("Неверно введенные параметры");
        }
    }

    private void printFlowers(List<Flowers> flowers) {
        for (int i = 0; i < flowers.size(); i++) {
            System.out.println(i + ". " + flowers.get(i).getFlower());
        }
    }
}
