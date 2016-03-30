import org.joda.money.Money;
import org.junit.Test;

import java.math.BigDecimal;

public class TestMoney {
    @Test
    public void testMoney() {
        Money parse = Money.parse("KZT 1200");
        String s = parse.toString();
        System.out.println(s);
    }
}
