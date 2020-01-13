package Package1;

public class BookStatistics implements IVisitor {

    private int _numberOfImage=0;
    private int _numberOfImageProxy=0;
    private int _numberOfParagraph=0;
    private int _numberOfTable=0;


    @Override
    public void Visit(Image image) {
        _numberOfImage++;
    }

    @Override
    public void Visit(ImageProxy imageProxy) {
        _numberOfImageProxy++;
    }

    @Override
    public void Visit(Paragraph paragraph) {
        _numberOfParagraph++;
    }

    @Override
    public void Visit(Table table) {
        _numberOfTable++;
    }

    public void PrintStatistics()
    {
        System.out.println("Number of Images: "+_numberOfImage);
        System.out.println("Number of Image Proxys: "+_numberOfImageProxy);
        System.out.println("Number of Paragraphs: "+_numberOfParagraph);
        System.out.println("Number of Tables: "+_numberOfTable);
    }
}
