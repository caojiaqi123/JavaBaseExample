package Generic;

public abstract class Father<T1,T2> {
    T1 age;
    public abstract void test(T2 name);
}
//不保留范型类型
class C1<T1,T2> extends Father<T1,T2>{
    @Override
    public void test(T2 name) {
      //  this.age --> 类型t1
    }
}
//部分保留
class C2<T> extends Father<Integer,T>{
    @Override
    public void test(T name) {
       // this.age --> type is int
    }
}


//不保留范型类型
class C3 extends Father<Integer,String>{
    @Override
    public void test(String name) {
        //age -->type is int
    }
}
//不指定类型 相当于默认 object
class C4 extends Father{
    @Override
    public void test(Object name) {

    }
}
