package recursion;

public class RecursionExample {

    public static void main(String[] args) {
        message(5);
    }


    static void message(int n){
        if(n == 0)
            return;
        System.out.println(n);
        message(n-1);
    }
}
