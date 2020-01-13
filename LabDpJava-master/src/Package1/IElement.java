package Package1;

public interface IElement {
    void print();
    void Accept(IVisitor IVisitor);
    void SetNewValue(String newValue);
}
