package Package1;

public class OpenICommand implements ICommand {
    private String _pathToJSON;

    public OpenICommand(String path){
        this._pathToJSON = path;
    }

    @Override
    public void Execute() {
        JSONIBuilder builder = new JSONIBuilder();
        builder.Build();
        Book newBook = new Book("book 1");
        newBook.AddContent(builder.GetResult());
        DocumentManager.GetInstance().SetBook(newBook);
        newBook.Print();
    }
}
