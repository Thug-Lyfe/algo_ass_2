import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        node tree = new node();
        Random ran = new Random();
        String[] names = {"Marco Blum","David Blum","Kasper Pagh","Alex Kraunsøe","Lind Lind"};
        for (int i = 0;i<50;i++){
            //tree.putStudent(new ArrayList<Boolean>(Arrays.asList(hand_ins,attend_lectures,read_textbook,make_exerices)),"student name"]);
            tree.putStudent(new ArrayList<Boolean>(Arrays.asList(ran.nextBoolean(),ran.nextBoolean(),ran.nextBoolean(),ran.nextBoolean())),names[ran.nextInt(5)]);
        }
        // print tier
        tree.print(4);
    }
}

