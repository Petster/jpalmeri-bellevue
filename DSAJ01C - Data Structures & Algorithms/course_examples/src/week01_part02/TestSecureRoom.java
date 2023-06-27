package week01_part02;

public class TestSecureRoom
{
    public static void main(String [] args)
    {
        SecureRoom safe = new SecureRoom("My Safe");
        //safe.setLock("agimagi"); // Note: demonstrates advantage of bounded generics
        System.out.println(safe);

        SecureRoom anotherSafe = new SecureRoom("Your Safe");
        anotherSafe.setLock(1234);
        System.out.println(anotherSafe);
    }
}
