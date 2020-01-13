package Package1;

import java.util.ArrayList;

public class Table implements IElement, IObservable {

    private String _tableName;
    private String _value;
    private String _oldValue;
    private ArrayList<IObserver> _observerList;

    public String get_tableName() {
        return _tableName;
    }

    public void set_tableName(String _tableName) {
        this._tableName = _tableName;
    }

    public Table(String tableName){
        _tableName = tableName;
        _observerList = new ArrayList<IObserver>();
    }

    @Override
    public void print() {
        System.out.println("Table name: "+get_tableName());
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
        System.out.printf("Observers notified.");
    }
}
