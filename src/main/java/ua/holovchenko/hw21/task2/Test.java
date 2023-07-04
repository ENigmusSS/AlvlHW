package ua.holovchenko.hw21.task2;

@Service
public class Test {
    @Override
    public String toString() {
        return "Test{" +
                "testString='" + testString + '\'' +
                '}';
    }

    @Value(initValue = "some value")
    private String testString;

    @Init
    private void doSomething() {
        System.out.println("I'm did it!");
    }
}
