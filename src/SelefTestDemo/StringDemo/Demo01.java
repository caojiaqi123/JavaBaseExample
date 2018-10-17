package SelefTestDemo.StringDemo;

/**
 * @param
 * @description intern方法 调用时查看常量迟中是否有该常量
 * 如果有 则返回常量池中的引用，如果没有 则在常量池中生成一个对原字符对引用
 * 另外1。7以后 常量池被移到堆当中
 * 注意下对象生成的过程
 * 具体可以看下文章 https://blog.csdn.net/seu_calvin/article/details/52291082
 */
public class Demo01 {
    public static void main(String[] args) {
        // test1();

        //test2();

        test4();
        test5();
        test6();
    }

    private static void test1() {
        String s1 = "abc";
        String s2 = "a";
        String s3 = "bc";
        String s4 = s2 + s3;
        System.out.println(s1 == s4);
    }


    private static void test2() {
        String s1 = "abc";
        final String s2 = "a";
        final String s3 = "bc";
        String s4 = s2 + s3;
        System.out.println(s1 == s4);
    }

    private static void test3() {
        String s1 = new String("abc");
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println(s1.intern() == s2);
        System.out.println(s1.intern() == s3.intern());
        System.out.println(s2 == s3.intern());
    }

    private static void test4() {
        String str2 = new String("a") + new String("b");
        String str1 = "ab";
        str2.intern();//生成原字符串对引用 指向堆
        System.out.println(str2 == str1);//false
    }

    private static void test5() {
        String str2 = new String("1") + new String("2");
        str2.intern();
        String str1 = "12";//常量池中已有对 12的引用
        System.out.println(str2 == str1);//true
    }

    private static void test6() {
        String str2 = new String("9");
        str2.intern();
        String str1 = "9";
        System.out.println(str2 == str1);//false
    }
}

