package House;

public interface Subject{
    public void registerObserver ( Observer o);
    public void remover (Observer o);
    public void notifyObservers ();
}