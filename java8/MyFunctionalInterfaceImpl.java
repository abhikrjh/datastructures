package java8;

public class MyFunctionalInterfaceImpl {

    public static void main(String[] args) {

        MyFunctionalInterface myFunc = System.out::println;

        myFunc.showMessage("Hello!!! How are you?");

        myFunc.printHello();
    }
}
