package Package1;

import java.util.ArrayList;

public class Section implements IElement, IObservable {

    private String _sectionTitle;
    public ArrayList<IElement> content;
    private ArrayList<IObserver> _observerList;

    public Section(String title){
        this._sectionTitle = title;
        content = new ArrayList<IElement>();
        _observerList = new ArrayList<IObserver>();
    }

    public int AddElement(IElement IElement){
        content.add(IElement);
        return content.indexOf(IElement);
    }

    public void RemoveElement(IElement IElement){
        content.remove(IElement);
    }

    public IElement GetElement(int indexOfElement){
        return content.get(indexOfElement);
    }

    public String get_sectionTitle() {
        return _sectionTitle;
    }

    public void set_sectionTitle(String _sectionTitle) {
        this._sectionTitle = _sectionTitle;
    }

    public ArrayList<IElement> getContent() {
        return content;
    }

    public void setContent(ArrayList<IElement> content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println();
        System.out.println("Title: "+get_sectionTitle());

        for(var element:content){
            element.print();
        }
    }

    @Override
    public void Accept(IVisitor bookStatistics) {
        for(IElement IElement :content){
            IElement.Accept(bookStatistics);
        }
    }

    @Override
    public void SetNewValue(String newValue) {
        // ?
    }

    @Override
    public void AddObserver(IObserver observer) {
        _observerList.add(observer);
    }

    @Override
    public void RemoveObserver(IObserver observer) {
        _observerList.remove(observer);
    }

    @Override
    public void NotifyAllObservers() {
        //?
        System.out.println("Observers notified.");
    }
}
