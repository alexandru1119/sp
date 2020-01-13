package Package1;

public class IAlignLeft implements IAlignStrategy {
    @Override
    public void Print(String text) {
        System.out.println(text+"+++++");
    }
}
