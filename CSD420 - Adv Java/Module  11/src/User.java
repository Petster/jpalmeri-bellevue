public class User {
    public String name;
    public String email;
    public int age;

    public User() {

    }
    
    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public void setName(String newS) {
        name = newS;
    }

    public void setEmail(String newS) {
        email = newS;
    }

    public void setAge(int newI) {
        age = newI;
    }

}
