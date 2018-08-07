/**
 * Created by caojiaqi on 2099/3/27.
 */
public class Student {
    String name;
    int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


//    public Student(String name, int id) {
//        this.name = name;
//        this.id = id;
//    }
//
    public Student() {
        super();
        System.out.println("创建一个学生对象");
    }

//    public Student(String name) {
//        this.name = name;
//    }
}

 class SupStudent extends Student {
        public SupStudent(String name, int id) {
//        super(name, id);
    }

    public SupStudent() {
        super();
        System.out.println("创建一个超级学生对象");
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        SupStudent supStudent = new SupStudent();
        final int c;
        c=1;
        System.out.println(c);

    }
}
