package Coding.UnitiCurrrentLock;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ConcurrencyCollections {

    public static void main(String[] args) {

        Map unsafeMap = new HashMap();
       unsafeMap = Collections.synchronizedMap(unsafeMap);



    }



}
