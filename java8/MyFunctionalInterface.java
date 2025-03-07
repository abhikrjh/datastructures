package java8;

@FunctionalInterface
public interface MyFunctionalInterface {

    void showMessage(String message);

    default void printHello(){
        System.out.println("Hello");
    }
}
