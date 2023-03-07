package Lock接口.lock;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ThreadDemo4 {
    //创建ArrayList
    public static void main(String[] args) {
        //ArrayList<String> list = new ArrayList<>();

        //Vector解决
        //List<String> list = new Vector<>();

        //Collections解决
       // List<String> list = Collections.synchronizedList(new ArrayList<>());

//        List<String> list = new CopyOnWriteArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            new Thread(()->{
//                //向集合中添加内容
//                list.add(UUID.randomUUID().toString().substring(0,8));
//                //从集合中获取内容
//                System.out.println(list);
//            },String.valueOf(i)).start();
//        }


//        Set<String> list = new CopyOnWriteArraySet<>();
//        for (int i = 0; i < 30; i++) {
//            new Thread(()->{
//                //向集合中添加内容
//                list.add(UUID.randomUUID().toString().substring(0,8));
//                //从集合中获取内容
//                System.out.println(list);
//            },String.valueOf(i)).start();
//        }

        Map<String,String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            String key = String.valueOf(i);
            new Thread(()->{
                //向集合中添加内容
                map.put(key,UUID.randomUUID().toString().substring(0,8));
                //从集合中获取内容
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }
}
