import com.peterholub.Map;
import com.peterholub.hashmap.HashMap;

public class Client {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(99, 11);
        hashMap.put(67667, 1676767671);
        hashMap.put(679967, 1676767671);
        hashMap.put(67667677, 1676767671);
        hashMap.put(6769907, 1676767671);
        hashMap.put(676000097, 1676767671);
       hashMap.put(98080807, 1676767671);
        hashMap.put(767767, 1676767671);
        hashMap.put(668686867, 1676767671);
        System.out.println(hashMap);
        System.out.println(hashMap.get(668686867));
    }
}
