package Problem6;

public class TestRoom {
    public static void main(String[] args) {
        Room test = new Room(100, 200);
        System.out.println("Initial Constructor Class");
        System.out.println(test);
        System.out.println("Adding Containers of type String");
        test.setContents("Orange", "Pink");
        System.out.println(test);
    }
}
