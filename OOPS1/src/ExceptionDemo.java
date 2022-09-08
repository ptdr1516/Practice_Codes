public class ExceptionDemo {

    public static int fact(int n) throws NegativeNumberException{
        if(n < 0){
            throw new NegativeNumberException();
        }
        int ans = 1;
        for (int i = 2; i <= n; i++){
            ans = ans * i;
        }
        return ans;
    }
    public static int Divide(int a,int b) throws DivideByZeroException{
        if(b == 0){
            throw new DivideByZeroException();
        }
        return a / b;
    }

    public static void main(String[] args){
        try {
            Divide(10, 0);
            System.out.println(fact(1));
            System.out.println("Within try");
        } catch (DivideByZeroException e) {
            System.out.println("Divide by Zero exception is raised");
//            throw new RuntimeException(e);
        }catch (NegativeNumberException e) {
            System.out.println("Negative Number Exception");
//            throw new RuntimeException(e);
        }catch (Exception e){
            System.out.println("Generic Exception");
        }
        finally {
            System.out.println("Finally");
        }
        System.out.println("Main");

    }
}
