package jdk8Test;

import java.util.*;

/**
 * Created by dupang on 2016/4/4.
 */
public class Jdk8NewFeatureTest {



    public static void main(String[] args) {
        /**
         * map的新特性
         * getOrDefault(Object, V)
         */
        Map<String,String> map = new HashMap();
        String value = map.get("KEY");
        if(value==null){
            value="Value";
        }
        System.out.println(value);
        String defaultValue = map.getOrDefault("KEY","defaultValue");
        System.out.println(defaultValue);

        /**
         * computeIfAbsent(K,V)
         * computeIfPresent
         */

        //100个长度的List,存储的0--9的数字，分别他们出现的次数，

        Random random =new Random();
        List<Integer> numList = new ArrayList();
        for (int i=0;i<100;i++){
            numList.add(random.nextInt(10));
        }
        final Map<Integer,Integer> numMap = new HashMap();
        for (Integer i : numList){
            if(numMap.get(i)==null){
                numMap.put(i,0);
            }else {
                numMap.put(i,numMap.get(i)+1);
            }
        }
        //
        printMap(numMap);
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        System.out.println("=============================以下的jdk8的输出==============================================");
        //用jdk8的
        Map<Integer,Integer> newMap = new HashMap();
        for (Integer i : numList){
            newMap.computeIfPresent(i,(k,v) -> newMap.get(k)+1);
            //newMap.computeIfAbsent(i,num -> newMap.put(num,0));
            newMap.putIfAbsent(i,0);
        }
        printMap(newMap);
        //remove

        Map<Integer,Integer> removeMap = new HashMap<>();
        removeMap.put(1,1);
        removeMap.put(2,2);

        removeMap.remove(1,2);
        int num = removeMap.get(1);

        removeMap.remove(1,1);
        System.out.println(num);

        /**
         * replace(K,V)
         */
        System.out.println("=============replace(K,V)==================");
        Map<String,String> replaceMap = new HashMap<>();
        replaceMap.put("one","1");
        String ss = replaceMap.replace("one","2");
        String one = replaceMap.get("one");
        System.out.printf(one);
        System.out.printf(ss);

        /**
         * replace(K,V,V)
         */
        System.out.println("=============replace(K,V,V)==================");
        Map<String,String> replaceMap2 = new HashMap<>();
        replaceMap2.put("one","1");
        replaceMap2.replace("one","1","TWO");
        String one2 = replaceMap2.get("one");
        System.out.printf(one2);
        /**
         * replaceALL
         */
        System.out.println("=============replaceALL==================");
        Map<String,String> replaceAllMap = new HashMap<>();
        replaceAllMap.put("one","1");
        replaceAllMap.put("two","2");
        replaceAllMap.put("three","3");
        replaceAllMap.put("four","4");

        replaceAllMap.replaceAll((k,v)-> k+v);

        printMap(replaceAllMap);

        /**
        *
        */

        Map<String,String> wMap = new HashMap<>();
        wMap.

    }
    public static void printMap(Map map){
        Iterator<Map.Entry<Object, Object>> entries = map.entrySet().iterator();

        while (entries.hasNext()) {
            Map.Entry<Object, Object> entry = entries.next();
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }
}
