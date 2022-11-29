package hash.leet146;

import java.util.LinkedHashMap;

/**
* Runtime : 65 ms
* Memory : 119 MB
*/
class LRUCache {
   
    LinkedHashMap<Integer, Integer> hashMap;
    int size;
    
    public LRUCache(int capacity) {
        // 순서대로 저장하기 위해 LinkedHashMap 선언 
        hashMap = new LinkedHashMap<>(capacity);
         // LinkedHashMap의 size 저장
        size = capacity;
    }
    
    public int get(int key) {
        // HashMap에 key가 없으면 -1 반환
        if(!hashMap.containsKey(key)) return -1;
        
        // key 값을 참조했으니, 참조한 key 값을 삭제 후 다시 삽입
        int value = hashMap.remove(key);
        
        hashMap.put(key, value);
        
        // value 값 반환
        return value;
    }
    
    public void put(int key, int value) {
        // 저장하려는데, HashMap에 같은 key값이 있다면 일단 삭제
        if(hashMap.containsKey(key)){
            hashMap.remove(key);
        // HashMap의 용량이 다 찼으면     
        } else if(hashMap.size() == size){
            // 가장 앞에 있는 데이터(가장 오랫동안 참조하지 않은 데이터)를 삭제
            hashMap.remove(hashMap.keySet().iterator().next());
        }
        
        // 새로운 데이터 삽입
        hashMap.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class leet146_moon{

}