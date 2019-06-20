import java.util.*;
public class MyClass {
    public static Dictionary pred = new Hashtable();
    public static void predicate(String name, String ptype, String ctype){
        List<String> funForm = new ArrayList<String>();
        String fun = "";
        fun += name + ":<" + symb.get(ptype) + ",t>";
        System.out.println(fun);
        funForm.add(fun);
        fun = "";
        fun += name + ":<" + symb.get(ptype) + "," + symb.get(ctype) + ">";
        System.out.println(fun);
        funForm.add(fun);
        fun = "";
        fun += name + ":<" + symb.get(ptype) + ",<" + symb.get(ptype) + ",t>>";
        System.out.println(fun);
        funForm.add(fun);
        fun = "";
        fun += name + ":<t,<" + symb.get(ptype) + "," + symb.get(ctype) + ">>";
        System.out.println(fun);
        funForm.add(fun);
        pred.put(name,funForm);
        
    }
    public static void main(String args[]) {
        int x=10;
        int y=25;
        int z=x+y;

        System.out.println("Sum of x+y = " + z);
    }
}
