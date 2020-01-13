package Package1;

public interface IVisitor {
    void Visit(Image image);
    void Visit(ImageProxy imageProxy);
    void Visit(Paragraph paragraph);
    void Visit(Table table);
}
