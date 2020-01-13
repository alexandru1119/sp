package Package1;

public class SecondObserver implements IObserver {
    @Override
    public void Update(String oldValue, String newValue) {
        System.out.println("Value updated.");
    }
}
