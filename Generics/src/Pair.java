/*
Generics allows us to create a single class, interface, and method that can be used with
different types of data (objects)
*/
public class Pair<T,S>{
    private T first;
    private S second;

    public Pair(T first, S second){
        this.first = first;
        this.second = second;
    }

    public Pair() {

    }

    public T getFirst(){
        return first;
    }

    public void setFirst(T first){
        this.first=first;
    }

    public S getSecond(){
        return second;
    }

    public void setSecond(S second){
        this.second= second;
    }
}
