package Menu;

import interfases.Command;
import interfases.Printable;

import java.util.ArrayList;
import java.util.List;

public class MainMenu implements Printable {
    /// Open-closed principle
    List<Command> listItems = getMenu();

    private List<Command> getMenu() {
        List<Command> list = new ArrayList<>();
        list.add(() -> System.out.println("1. Заказать цветы"));
        list.add(() -> System.out.println("2. Показать содержимое корзины"));
        list.add(() -> System.out.println("3. Редактировать заказ"));
        list.add(() -> System.out.println("4. Оформить заказ"));
        list.add(() -> System.out.println("5. Очистить корзину"));
        list.add(() -> System.out.println("6. Завершить программу"));
        return list;
    }

    @Override
    public void print() {
        listItems.forEach(Command::execute);
    }
}
