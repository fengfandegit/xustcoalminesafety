/**
 * Created by lenovo on 2018/6/2.
 */
public class Maine {

    public static void main(String[] args){
       // Maine m = new Maine();
        fun1();
        fun2();
    }

    public  static void fun1(){
        String str1 = new String("SEU")+new String("Calvin");
        String str2 = str1.intern();
        System.out.println(str2 == str1);
        System.out.println(str1 == "SEUCalvin");
    }

    public  static void fun2(){
        String str2 = "SEUCalvin";
        String str1 = new String("SEU")+new String("Calvin");
        String str3 = str1.intern();
        System.out.println(str3 == str1);
        System.out.println(str3 == "SEUCalvin");
    }
}
