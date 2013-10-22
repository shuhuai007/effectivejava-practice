package chapter5.section23;

import java.util.ArrayList;
import java.util.List;

public class RawTypeTest {


    public static void main(String[] args) {
//        List<String> strings = new ArrayList<String>();
//        unsafeAdd(strings, new Integer(42));
//        String s = strings.get(0);

        List<Object> objectList = new ArrayList<Object>();
        objectList.add(new Integer(10));
        objectList.add(new Double(20));
        System.out.println(objectList);
    }

    private static void unsafeAdd(List strings, Object o) {
        strings.add(o);
    }

}
