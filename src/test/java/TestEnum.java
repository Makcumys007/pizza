import com.epam.pizza.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class TestEnum {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(2);
        list.add(1);
        System.out.println(list.get(0));
        list.add(2);
        System.out.println(list.get(1));
        list.add(3);
        System.out.println(list.get(3));
    }
}
