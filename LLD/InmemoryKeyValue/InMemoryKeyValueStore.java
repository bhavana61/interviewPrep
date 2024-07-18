package LLD.InmemoryKeyValue;

import java.util.*;
import java.util.concurrent.locks.*;

public class InMemoryKeyValueStore {
    private final HashMap<String,Map<String,Object>> store=new HashMap<>();
    private final HashMap<String,Class<?>> attributeTypes=new HashMap<>();
    private final ReentrantReadWriteLock lock=new ReentrantReadWriteLock();


    public Map<String,Object> get(String key){
        lock.readLock().lock();
        try {
            return store.getOrDefault(key, null);
        }
        finally{
            lock.readLock().unlock();
        }
       // return store.getOrDefault(key,null);
    }

    public void put(String key,List<Map.Entry<String,Object>> list){
        lock.writeLock().lock();
        try{
            HashMap<String,Object> attributes=new HashMap<>();
            for(Map.Entry<String,Object> entry:list){
                String attributeKey=entry.getKey();
                Object attributeValue=entry.getValue();

                if(attributeTypes.containsKey(attributeKey)){
                    Class<?> expectedType=attributeTypes.get(attributeKey);
                    if(!expectedType.isInstance(attributeValue)){
                        throw new IllegalArgumentException("type mismatch");
                    }
                }
                else{
                    attributeTypes.put(attributeKey,attributeValue.getClass());
                }
                attributes.put(entry.getKey(),entry.getValue());
            }
            store.put(key,attributes);
        }
        finally {
            lock.writeLock().unlock();
        }
    }

    public void delete(String key){
        lock.writeLock().lock();
        try {
            store.remove(key);
        }
        finally {
            lock.writeLock().unlock();
        }
    }

    public List<String> search(String attributeKey,Object attributeValue)
    {
        lock.readLock().lock();
        try {
            ArrayList<String> result = new ArrayList<>();
            for(Map.Entry<String,Map<String,Object>> entry:store.entrySet()){
                Map<String,Object> attributes=entry.getValue();
                if(attributes.containsKey(attributeKey)&&attributes.get(attributeKey).equals(attributeValue)){
                    result.add(entry.getKey());
                }
            }
            return result;
        } finally {
            lock.readLock().unlock();
        }

        //key:attributeKey_attributeValue;
        //value:key
    }

}
