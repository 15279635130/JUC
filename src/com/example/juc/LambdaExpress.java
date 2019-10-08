package com.example.juc;

@FunctionalInterface
interface Foo {
    //public void sayHello();
    public int add(int x, int y);

    public default int mul(int x, int y) {
        return x * y;
    }

    public static int div(int x, int y) {
        return x / y;
    }
}

public class LambdaExpress {

    public static void main(String[] args) {
        /*
        Foo foo = new Foo() {
            @Override
            public void sayHello() {
                System.out.println("Hello World...");
            }
        };

        // lambda: 拷贝中括号，写死右箭头，落地大括号
        Foo foo1 = () -> { System.out.println("Hello Lambda..."); };

        foo.sayHello();
        foo1.sayHello();
        */
        Foo foo = (int x, int y) -> {
            System.out.println("实现加法运行...");
            return x + y;
        };
        System.out.println(foo.add(1, 2));
        System.out.println(foo.mul(2, 3));
        System.out.println(Foo.div(4, 2));
    }
}
