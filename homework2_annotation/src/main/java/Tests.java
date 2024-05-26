import annotation.AfterSuite;
import annotation.BeforeSuite;
import annotation.Test;

public class Tests {
    @Test(priority = 1)
    public void testOne() {System.out.println("test1");
    }
    @Test(priority = 9)
    public void testTwo() {
        System.out.println("test2");
    }
    @Test (priority = 3)
    public void testThree() {System.out.println("test3");
    }
    @Test (priority = 1)
    public void testFour() {System.out.println("test4");
    }
    @Test
    public void executedTest() {
        throw new RuntimeException();
    }
    @AfterSuite
    public void AfterSuite() {
        System.out.println("After");
    }
    @BeforeSuite
    public void BeforeSuite() {
        System.out.println("Before");
    }
}
