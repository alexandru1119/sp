package Package1;

import java.util.ArrayList;

public class Paragraph implements IElement, IObservable {
    private String _paragraphName;
    private IAlignStrategy _strategy;
    private String _value;
    private String _oldValue;
    private ArrayList<IObserver> _observerList;

    public String get_paragraphName() {
        return _paragraphName;
    }

    public void set_paragraphName(String _paragraphName) {
        this._paragraphName = _paragraphName;
    }

    public Paragraph(String paragraphName){
        _paragraphName = paragraphName;
        _observerList = new ArrayList<IObserver>();
    }

    @Override
    public void print() {
        System.out.println("Paragraph name: "+get_paragraphName());
        if(_strategy == null){
            System.out.println(_paragraphName);
        }else{
            _strategy.Print(_paragraphName);
        }
    }

    public void SetStrategy(IAlignStrategy Strategy){
        _strategy = Strategy;
    }

    @Override
    public void Accept(IVisitor IVisitor) {
        IVisitor.Visit(this);
    }

    @Override
    public void SetNewValue(String newValue) {
        this._oldValue = _value;
        this._value = newValue;
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
        // ?
        System.out.println("Observers notified.");
    }
}
