import Menu.ChoiceOfFlowersMenu;
import enums.Boxing;
import enums.Flowers;
import interfases.Printable;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ChoiceOfFlowers {

    private static final List<Flowers> FLOWERS = Arrays.stream(Flowers.values()).toList();
    private static final List<Boxing> BOXING = Arrays.stream(Boxing.values()).toList();
    Printable printable = new ChoiceOfFlowersMenu();

    public void workingWithChoiceOfFlowersMenu() {
        while (true) {
            printable.print();
            Scanner scanner = new Scanner(System.in);
            int menuItem;
            try {
                menuItem = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Неверно введенное значение");
                return;
            }
            switch (menuItem) {
                case 1: {
                    for (int i = 0; i < FLOWERS.size(); i++) {
                        System.out.println(i + ". " + FLOWERS.get(i).getFlower());
                    }
                    try {
                        System.out.print("Какой цветок добавить в заказ: ");
                        int flower = scanner.nextInt();
                        System.out.print("Выберите количество: ");
                        int numberOfFlowers = scanner.nextInt();
                        Basket.addFlowersToBasket(FLOWERS.get(flower), numberOfFlowers);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Выберите число в пределах указанного списка");
                        continue;
                    } catch (InputMismatchException ex) {
                        System.out.println("Неверно введенные параметры");
                    }
                }
                continue;
                case 2: {
                    System.out.println("Доступные для заказа упаковки (можно выбрать только одну):");
                    for (int i = 0; i < BOXING.size(); i++) {
                        System.out.println(i + ". " + BOXING.get(i).getBoxing());
                    }
                    try {
                        System.out.print("Какую упаковку добавить в заказ: ");
                        int boxing = scanner.nextInt();
                        if (!Basket.isBoxingNull()) {
                            System.out.println("Упаковка изменена");
                        }
                        Basket.addBoxingToBasket(BOXING.get(boxing));
                        System.out.println("Упаковка добавлена");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Выберите число в пределах указанного списка");
                        continue;
                    } catch (InputMismatchException ex) {
                        System.out.println("Неверно введенные параметры");
                    }
                }
                continue;
                case 3:
                default:
                    return;
            }
        }
    }
}
