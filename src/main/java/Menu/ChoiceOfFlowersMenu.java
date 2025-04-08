package Menu;

import interfases.Command;
import interfases.Printable;

import java.util.ArrayList;
import java.util.List;

public class ChoiceOfFlowersMenu implements Printable {

    /// Open-closed principle
    List<Command> listItems = getMenu();

    private List<Command> getMenu() {
        List<Command> list = new ArrayList<>();
        list.add(() -> System.out.println("1. Выбрать цветы"));
        list.add(() -> System.out.println("2. Выбрать упаковку"));
        list.add(() -> System.out.println("3. Вернуться в главное меню"));
        return list;
    }

    @Override
    public void print() {
        listItems.forEach(Command::execute);
    }
}
