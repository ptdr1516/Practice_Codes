//Primitive data types are not allowed in generics but has alternate way.

public class PairUse {
    public static void main(String[] args) {
        Pair<String,Integer> pInner = new Pair<>("ab",100);
        Pair<Pair<String, Integer>, String> p = new Pair<>();
        p.setFirst(pInner);
        System.out.println(p.getFirst());
        System.out.println(p.getFirst().getFirst());
        System.out.println(p.getFirst().getSecond());
//        p.setSecond("abcd");
//        System.out.println(p.getSecond());
//        Pair<Integer, String> pSI = new Pair<Integer, String>(10,"ab");

//        Pair<String> p = new Pair<>();
//        System.out.println(p.getFirst() + " " + p.getSecond());
//        Pair p = new Pair(10,20);  Danger!!! to USE
//        System.out.println(p.getFirst() + " " + p.getSecond());

//        PairString pS = new PairString("aa","bb");
//        PairDouble pD = new PairDouble(3.17,1.6);

//        Pair<String> pS = new Pair<String>("aa","bb");
//        System.out.println(pS.getFirst() + " " + pS.getSecond());
//        pS.setFirst("xyz");
//
//        //Pair<int> pI = new Pair<int>(10,20);
//        Pair<Integer> pI = new Pair<Integer>(10,20);
//        System.out.println(pI.getFirst() + " " + pI.getSecond());
//
//        Pair<Double> pD = new Pair<Double>(3.17,1.6);
//        System.out.println(pD.getFirst() + " " + pD.getSecond());

//        Pair<Vehicle> pV = new Pair<Vehicle>(new Vehicle(), new Vehicle());
    }
}
