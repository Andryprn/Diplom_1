package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BunParamTest {
    private final String bunName;
    private final float bunPrice;
    private Bun bun;

    public BunParamTest(String name, float price) {
        this.bunName = name;
        this.bunPrice = price;
    }

    @Parameters(name = "Набор тестовых данных {index} >> Name: {0}, Price: {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Обычная", 1},
                {"Флотная", 0.01F},
                {"Бесценная", 0},
                {"Имя булочки с пробелами", 100},
                {"", 0},
                {null, 0},
                {"Отрицательная", -100},
                {"$%#^@&$$(%^^)symbol_bun", 999},
                {"ОченьБольшоеИДлинноеИмяБургераИТакДваРазаОченьБольшоеИДлинноеИмяБургераИТакДваРаза", Float.MAX_VALUE}
        };
    }

    @Before
    public void setBun() {
        this.bun = new Bun(bunName, bunPrice);
    }

    @Test
    public void getBunNameTestShouldReturnValidBunName() {
        System.out.println(this.bunName);

        Assert.assertEquals("Имя булочки не соответствует указанному", bunName, bun.getName());
    }

    @Test
    public void getBunPriceTestShouldReturnValidBunPrice() {
        Assert.assertEquals("Цена булочки не соответствует указанной", bunPrice, bun.getPrice(), 0.01F);
    }
}
