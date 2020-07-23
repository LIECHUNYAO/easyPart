public class Son extends Father {

    int fa = 1;
    public Son(){
        System.out.println("dd");
    }
//
//    //@Override
//    public int getFa() {
//        return fa;
//    }
    //
    @Override
    public void setFa(int fa) {
        this.fa = fa;
        System.out.println("zilei");
    }

    public void sonM(){
        System.out.println("sonm");
    }

    public void show(){
        super.show();
        System.out.println("sssshow");
    }



}
