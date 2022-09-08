public class Recursion2 {
    public static String replaceChar(String s, char a, char b) {
        if (s.length() == 0) {
            return s;
        }
        String smallOutput = replaceChar(s.substring(1), a, b);
        if (s.charAt(0) == a) {
            return b + smallOutput;
        } else {
            return s.charAt(0) + smallOutput;
        }
    }

    public static String replacePi(String s) {
        if (s.length() <= 1) {
            return s;
        }
        if (s.charAt(0) == 'p' && s.charAt(1) == 'i') {
            //recurion call on string n - 2
            String smallOutput = replacePi(s.substring(2));
            return "3.14" + smallOutput;
        } else {
            //recurion call on string n - 1
            String smallOutput = replacePi(s.substring(1));
            return s.charAt(0) + smallOutput;
        }
    }

    public static String removeConsecutiveDuplicates(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String smallOutput = removeConsecutiveDuplicates(s.substring(1));
        if (s.charAt(0) == s.charAt(1)) {
            return smallOutput;
        } else {
            return s.charAt(0) + smallOutput;
        }

    }

    public static int binarySearch(int a[], int si, int ei, int x) {
        if(si > ei){
            return -1;
        }
        int midIndex = (si + ei)/2;
        if(a[midIndex] == x){
            return midIndex;
        }
        else if (a[midIndex] < x) {
            return binarySearch(a,midIndex+1,ei,x);
        }
        else {
            return binarySearch(a, midIndex-1,ei,x);
        }

    }




    public static void main(String[] args) {
        System.out.println(replaceChar("abcxdxedxe", 'x', 'y'));
        System.out.println(replacePi("abcpicdpi"));
        System.out.println(removeConsecutiveDuplicates("xxxyyyzwwzzz"));
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binarySearch(a, 0, a.length - 1, 8));
        }
    }

