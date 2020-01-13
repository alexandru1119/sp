package Package1;

public interface IObservable {

    void AddObserver(IObserver observer);
    void RemoveObserver(IObserver observer);
    void NotifyAllObservers();

}
