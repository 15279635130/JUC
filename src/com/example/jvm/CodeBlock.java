package com.example.jvm;

/**
 * @author Administrator
 * @title: CodeBlock
 * @projectName JUC-demo
 * @description: TODO
 * @date 2019/9/29 0029下午 4:52
 */

class Code {
    public Code() {
        System.out.println("code构造方法111");
    }
    {
        System.out.println("code构造块222");
    }
    static {
        System.out.println("code静态代码块333");
    }
}

public class CodeBlock {

    {
        System.out.println("CodeBlack构造块444");
    }
    static {
        System.out.println("CodeBlack静态代码块555");
    }
    public CodeBlock() {
        System.out.println("CodeBlack构造方法666");
    }

    public static void main(String[] args) {

        System.out.println("==================================");
        new Code();
        System.out.println("----------------------------------");
        new Code();
        System.out.println("----------------------------------");
        new CodeBlock();
    }

    /**
     *   CodeBlack静态代码块555
         ==================================
         code静态代码块333
         code构造块222
         code构造方法111
         ----------------------------------
         code构造块222
         code构造方法111
         ----------------------------------
         CodeBlack构造块444
         CodeBlack构造方法666

        静态方法加入方法区，加载一次，所有类的实例变量(静态先行)
        静态块 > 构造块 > 构造方法

     */
}
