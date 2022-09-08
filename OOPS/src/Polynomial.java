public class Polynomial {
    private int[] poly;
    private int maxDegree; //Keeps track of maximum degree in a polynomial

    public Polynomial(){
        poly = new int[10];
        maxDegree = 0;
    }
    public Polynomial(int degree){
        poly = new int[degree];
        maxDegree = degree - 1;
    }

    public void setCoefficient(int degree, int coeff) {
        if(degree > poly.length -1){
            doubleCapacity();
        }
        if(maxDegree < degree){
            maxDegree = degree;
        }
        poly[degree] = coeff;
    }

    private void doubleCapacity() {
        int[] temp = poly;
        poly = new int[2 * poly.length];
        for (int i = 0; i < poly.length; i++){
            poly[i] = temp[i];
        }
    }

    public void print() {
        for (int i = 0; i <= maxDegree; i++){
            if(poly[i] != 0){
                System.out.println(poly[i] + "x" + i + " ");
            }
        }
    }
    public Polynomial add(Polynomial second) {
        int degree1 = this.maxDegree;
        int degree2 = second.maxDegree;
        int limit;

        if(degree1 > degree2){
            limit = degree1;
        }
        else {
            limit = degree2;
        }

        Polynomial polysum = new Polynomial(limit + 1);

        for (int i = 0; i <= limit; i++){
            int sum = 0;
            if (i <= degree1){
                sum = sum + (this.poly[i]);
            }
            if(i <= degree2){
                sum = sum + (second.poly[i]);
            }
            polysum.setCoefficient(i, sum);
        }
        return polysum;
    }
    public Polynomial subtract(Polynomial second) {
        int degree1 = this.maxDegree;
        int degree2 = second.maxDegree;
        int limit;

        if(degree1 > degree2){
            limit = degree1;
        }
        else {
            limit = degree2;
        }

        Polynomial polydiff = new Polynomial(limit + 1);

        for (int i = 0; i <= limit; i++){
            int diff = 0;
            if (i <= degree1){
                diff = diff + (this.poly[i]);
            }
            if(i <= degree2){
                diff = diff - (second.poly[i]);
            }
            polydiff.setCoefficient(i, diff);
        }
        return polydiff;
    }

    public Polynomial multiply(Polynomial second) {
        int limit = this.maxDegree + second.maxDegree;
        Polynomial polymul = new Polynomial(limit + 1);

        for (int i = 0; i <= this.maxDegree; i++){
            int product = 0;
            for (int j = 0; j <= second.maxDegree; j++){
                product = polymul.poly[i + j];
                product=product+(this.poly[i] * second.poly[j]);
                polymul.setCoefficient(i + j,product);
            }
        }
        return polymul;
    }
}
