public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("abcd");
        str.setCharAt(0, 'd');
        str.append("def");
        System.out.println(str + " " + str.length());
    }
}
