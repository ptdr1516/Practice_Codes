import java.util.ArrayList;

public class arrayList {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(2,15);
        System.out.println(arr);
        System.out.println(arr.size());
        System.out.println(arr.get(2));

        ArrayList<String> list = new ArrayList<String>() ;
        list.add( "Ant" );
        list.add( "Bat" );
        list.add( "Car" );
        list.add( "Door" );
        list.add( "Euro" );
        list.set(2,"Bus");
        System.out.println(list);
    }
}
