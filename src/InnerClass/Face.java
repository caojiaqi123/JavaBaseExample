package InnerClass;

/**
 * Created by caojiaqi on 2099/4/8.
 */
public class Face {
    int type;

    static int id = 12;

    class Nose {
        String type;


        void breath() {
            System.out.println(id);
            System.out.println("呼吸");
        }
    }

    static class Ear {
        static String s = "";
        String s2 = "";

        void listien() {

            System.out.println("听");
        }

        static void listien2() {

            System.out.println("听2");
        }
    }

    public static void main(String[] args) {
        Face f = new Face();
        Nose nose = f.new Nose();
        nose.breath();

        Face.Ear ear = new Face.Ear();
        ear.listien();
        Face.Ear.listien2();
        ear.listien2();
    }
}
