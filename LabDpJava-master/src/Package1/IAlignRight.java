package Package1;

public class IAlignRight implements IAlignStrategy {

    @Override
    public void Print(String text) {
        System.out.println("+++++"+text);
    }
}
