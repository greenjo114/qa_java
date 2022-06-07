package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {

    Feline feline;

    private final String sexVariant;
    private final boolean expected;

    public LionTest(String sexVariant, boolean expected) {
        this.sexVariant = sexVariant;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[] getResult() {
        return new Object[][] {
            {"Самец", true},
            {"Самка", false}
        };
    }

    @Test
    public void shouldCheckSexLion()  {
        try {
            Lion lion = new Lion(sexVariant, feline);
            boolean actual = lion.hasMane;
            assertEquals(expected, actual);
        } catch (Exception exception) {
            System.out.println("Используйте допустимые значения пола животного - самец или самка");
        }

    }

    @Test
    public void shouldCheckCountKittensLion() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(sexVariant, feline);
        int actual = lion.getKittens();
        System.out.println(actual);

    }

}