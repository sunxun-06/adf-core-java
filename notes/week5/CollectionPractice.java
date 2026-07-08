import java.util.*;
public class CollectionPractice{
    public static void main(String[] args) {
        List<String> citylist= new Arraylist<>();
        Set<Integer> numberset=new HashSet<>();
        Map<String,Integer> human=new HashMap<>();
        citylist.add("北京");
        citylist.add("上海");
        citylist.add("南京");
        citylist.add("深圳");
        citylist.add("广州");
        int[] nums={1,2,1,4,5,6,7,5,9,10};
        for(int n:nums){
            numberset.add(n);
        }
        for(int m:numberset){
            System.out.print(m+" ");
        }
        System.out.println();
        human.put("张三",20);
        human.put("李四",25);
        human.put("王五",23);
        human.put("赵六",30);
        for(Map.Entry<String,Integer> entry:human.entrySet()){
            System.out.println("姓名"+entry.getKey()+",年龄"+entry.getValue());
        }
    }
}