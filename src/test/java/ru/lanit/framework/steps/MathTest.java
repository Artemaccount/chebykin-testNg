package ru.lanit.framework.steps;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.lanit.testng.Math;

public class MathTest {

    @BeforeClass
    public void beforeClass() {
        System.out.println("Подготовка перед тестами");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Подчищаем после тестов");
    }

    @DataProvider
    public Object[][] sumMinTestEquals() {
        return new Object[][]{
                {4, 2, 2},
                {0, -1, 1},
                {8, 4, 4},
                {-1, 0, -1},
                {5, 2, 3}
        };
    }

    @Test(dataProvider = "sumMinTestEquals")
    public void sumTestEquals(int one, int two, int tree) {
        Assert.assertEquals(one, new Math().sumTest(two, tree), "Значения не равны!");
    }

    @Test(dataProvider = "sumMinTestEquals")
    public void minTestEquals(int one, int two, int tree) {
        Assert.assertEquals(two, new Math().minTest(one, tree), "Значения не равны!");
    }

    @DataProvider
    public Object[][] multDivTest() {
        return new Object[][]{
                {4, 2, 2},
                {10, 2, 5},
                {8, 4, 2},
                {12, 3, 4},
                {6, 3, 2}
        };
    }

    @Test(dataProvider = "multDivTest")
    public void multTestEqals(int one, int two, int tree) {
        Assert.assertEquals(one, new Math().multTest(two, tree), "Значения не равны!");
    }

    @Test(dataProvider = "multDivTest")
    public void divTestEquals(int one, int two, int tree) {
        Assert.assertEquals(two, new Math().divTest(one, tree), "Значения не равны!");
    }


    @DataProvider(parallel = true)
    public Object[][] testEqualsNegative() {
        return new Object[][]{
                {5, 2, 2},
                {1, -3, 1},
                {100, 4, 4},
                {7, 0, -1},
                {3, 2, 3}
        };
    }

    @Test(dataProvider = "testEqualsNegative")
    public void sumTestEqualsNegative(int one, int two, int tree) {
        Assert.assertNotEquals(one, new Math().sumTest(two, tree), "Значения равны!");
    }

    @Test(dataProvider = "testEqualsNegative")
    public void minTestEqualsNegative(int one, int two, int tree) {
        Assert.assertNotEquals(one, new Math().multTest(two, tree), "Значения равны!");
    }

    @Test(dataProvider = "testEqualsNegative")
    public void multTestEqualsNegative(int one, int two, int tree) {
        Assert.assertNotEquals(one, new Math().multTest(two, tree), "Значения равны!");
    }

    @Test(dataProvider = "testEqualsNegative")
    public void divTestEqualsNegative(int one, int two, int tree) {
        Assert.assertNotEquals(one, new Math().sumTest(two, tree), "Значения равны!");
    }

    @DataProvider
    public Object[][] testObject() {
        return new Object[][]{
                {"five", 2, 2},
                {1, -1, "one"},
                {100, "four", 4},
                {"seven", "0", -1},
                {3, null, 3}
        };
    }

    @Test(dataProvider = "testObject", expectedExceptions = {ClassCastException.class, NullPointerException.class, AssertionError.class})
    public void sumTestNegativeObject(Object one, Object two, Object tree) {
        Assert.assertEquals(one, new Math().sumTest(two, tree), "Значения не равны!");
    }

    @Test(dataProvider = "testObject", expectedExceptions = {ClassCastException.class, NullPointerException.class, AssertionError.class})
    public void minTestNegativeObject(Object one, Object two, Object tree) {
        Assert.assertEquals(one, new Math().minTest(two, tree), "Значения не равны!");
    }

    @Test(dataProvider = "testObject", expectedExceptions = {ClassCastException.class, NullPointerException.class, AssertionError.class})
    public void multTestNegativeObject(Object one, Object two, Object tree) {
        Assert.assertEquals(one, new Math().multTest(two, tree), "Значения не равны!");
    }

    @Test(dataProvider = "testObject", expectedExceptions = {ClassCastException.class, NullPointerException.class, AssertionError.class})
    public void divTestNegativeObject(Object one, Object two, Object tree) {
        Assert.assertEquals(one, new Math().divTest(two, tree), "Значения не равны!");
    }

    @Test
    public void testNotEquals() {
        assert 2 * 2 == 4 : "two times two is not five!";
        Assert.assertFalse(5 == 2 + 2);
    }
}
