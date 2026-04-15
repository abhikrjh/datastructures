package java8;

public class MyFunctionalInterfaceImpl {

    public static void main(String[] args) {

        MyFunctionalInterface myFunc = message -> System.out.println(message);

        myFunc.showMessage("Hello!!! How are you?");

        myFunc.printHello();
    }
}
