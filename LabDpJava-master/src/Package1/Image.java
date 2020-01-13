package Package1;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Image implements IElement, IObservable {
    private String _imageName;
    private String _value;
    private String _oldValue;
    private ArrayList<IObserver> _observerList;

    public String get_imageName() {
        return _imageName;
    }

    public void set_imageName(String _imageName) {
        this._imageName = _imageName;
    }

    public Image(String imageName){
        _imageName = imageName;
        _observerList = new ArrayList<IObserver>();

        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (Exception ex){
            System.out.println(ex);
        }

    }

    @Override
    public void print() {
        System.out.println("Image name: "+get_imageName());
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
