public class Test {

    public static void main(String[] args) {
        Father s =new Son();
        System.out.println(s.getClass());
        //int a  = ((Son) s).fa;
        s.setFa(0);

//        System.out.println(((Father)s).sonM);

    }
}

//父类 Animal
//        String name = animal;
//        Stename() {}
//子类 Cat
//        String name = cat;
//
//测试
//    Animal an = new Cat();
//    an.setName("cat")
//        如果cat没写Set方法
//    sout(an.name） ==> cat
//    如果cat中有setName方法
//        sout(an.name） ==> animal
