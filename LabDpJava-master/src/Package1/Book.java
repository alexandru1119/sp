package Package1;

import java.util.ArrayList;

public class Book {

    private String _title;
    private Author _bookAuthor;
    private ArrayList<IElement> _content;

    public Book(String Title) {
        this._title = Title;
        _content = new ArrayList<IElement>();
    }

    public void AddAuthor(Author author) {
        _bookAuthor = author;
    }

    public void AddContent(IElement IElement)
    {
        _content.add(IElement);
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public Author get_bookAuthor() {
        return _bookAuthor;
    }

    public void set_bookAuthor(Author _bookAuthor) {
        this._bookAuthor = _bookAuthor;
    }

    public ArrayList<IElement> get_content() {
        return _content;
    }

    public void set_content(ArrayList<IElement> _content) {
        this._content = _content;
    }


    public void Accept(IVisitor IVisitor){
        for(IElement IElement :_content){
            IElement.Accept(IVisitor);
        }
    }


    public void Print()
    {
        System.out.println("Book Title: "+_title);
        //System.out.println("Author: "+_bookAuthor.get_authorName());

        for (var element:_content)
        {
            element.print();
        }

    }


}
