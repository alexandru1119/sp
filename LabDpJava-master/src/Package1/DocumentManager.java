package Package1;

public class DocumentManager {

    private static DocumentManager _documentManager = null;
    private Book _book;

    private DocumentManager(){

    }

    public static DocumentManager GetInstance(){
        if(_documentManager == null){
            _documentManager = new DocumentManager();
        }
        return _documentManager;
    }

    public void SetBook(Book book){
        this._book = book;
    }

    public Book GetBook(){
        return this._book;
    }

}
