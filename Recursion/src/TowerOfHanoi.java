public class TowerOfHanoi {
    public static void towerOfHanoi(int n, char s, char h, char d){
        //Base Case
        if(n == 1){
            System.out.println("Move 1st disk from "+ s +" to "+ d);
        }
        else if(n == 0){
            System.out.println("");
        }
        else{
            //Move (n-1) disks from source(s) to helper(h) through destination(d)
            towerOfHanoi(n-1,s,d,h);

            //Move nth disk from source(s) to destination(d)
            System.out.println("move "+ n + "th disk from " + s + " to " + d);

            //Move (n-1) disks from helper(h) to destination(d)
            towerOfHanoi(n-1,h,s,d);
        }
    }
    public static void main(String[] args) {
        towerOfHanoi(10,'a','b','c');
    }
}
