package sk.kosickaakademia.rodne.cislo;

public class Testy {
    public int sucet(int a, int b){
        return a+b;
    }

    public boolean isPrimeNumber(int m){
        if(m<=1)
            return false;
        for(int i=2;i<Math.sqrt(m);i++){
            if(m%i==0)
                return false;
        }
        return true;
    }

    public boolean isRectangularTriangle(int a, int b, int c){
        if(a*a+b*b==c*c || a*a+c*c==b*b ||b*b+c*c==a*a)
            return true;
        else return false;
    }


    public String reverse(String text){
        String word= "Ahoj";
        char[] slovo=word.toCharArray();
        for(int i= slovo.length-1;i>=0;i--){
            System.out.print(slovo[i]);
        }
       return String.valueOf(slovo);
    }
}
