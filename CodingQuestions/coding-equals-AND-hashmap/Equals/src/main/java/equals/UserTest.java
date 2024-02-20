package equals;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.util.Objects;

/**
 * @author Alex D.
 */
public class UserTest {
    public static void main(String[] args){
        User u1 = new User("Tom",12);
        User u2 = new User("Tom",12);

        System.out.println(u1.equals(u2)); //false 相当于"=="

        String str3 = "hello";
        String str4 = "hello";

        System.out.println(str3 == str4);  // Output: true

        String str1 = new String("Tom");
        String str2 = new String("Tom");

        System.out.println(str1==str2); //false
        System.out.println(str1.equals(str2)); //true

        File file1 = new File("d://text");
        File file2 = new File("d://text");

        System.out.println(file1.equals(file2)); //true

        char charA = 'A';
        int int65 = 65;

        System.out.println(charA == int65);

    }
}

@NoArgsConstructor
@AllArgsConstructor
class User{
    String name;
    int age;

    //override

//    @Override
//    public boolean equals(Object obj) {
//        // 如果地址一样，快速判断，可以不写
//        if(this ==obj){
//            return true;
//        }
//        if (obj instanceof User){
//            User user = (User)obj;
//            return this.age==user.age && this.name.equals(user.name);
//        }
//        return false;
//    }

    //IDEA 实现
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }
}
