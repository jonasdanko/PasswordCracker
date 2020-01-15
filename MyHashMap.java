import java.util.ArrayList;
import java.util.List;

public class MyHashMap {

    private Entry[] arrayForMap;
    private int capacity;
    private int size;
    private int numDisplacements;
    private ArrayList<Integer> probes;
    private int[] numProbes;


    public MyHashMap(){
        capacity = 112687;
        arrayForMap = new Entry[capacity];
        size = 0;
        numDisplacements = 0;
        numProbes = new int[capacity];
        probes = new ArrayList<>();
        for(int i=0 ; i<arrayForMap.length-1 ; ++i){
            arrayForMap[i] = null;
        }
    }

    public MyHashMap(int capacity){
        arrayForMap = new Entry[capacity];
        size = 0;
        numDisplacements = 0;
        probes = new ArrayList<>();
        for(int i=0 ; i<arrayForMap.length-1 ; ++i){
            arrayForMap[i] = null;
        }
    }

    public void put(String key, String value) {
        int keyHash = hashFunction(key);
        Integer numProbes = 0;


        while(arrayForMap[keyHash] != null && arrayForMap[keyHash].getKey().equals(key) == false){
            ++keyHash;
            keyHash %= capacity;
            ++numDisplacements;
            ++numProbes;
        }
        arrayForMap[keyHash] = new Entry(key, value);
        ++size;
        probes.add(numProbes);
    }

    public String get(String key){
        int keyHash = hashFunction(key);

        while (arrayForMap[keyHash] != null){

            if(arrayForMap[keyHash].getKey().equals(key)){
                return arrayForMap[keyHash].getValue();
            }
            ++keyHash;
            keyHash %= capacity;

        }

        return null;

    }

    public int size(){
        return size;
    }

    private int hashFunction(String key){
        int address = key.hashCode()  % capacity;
        return (address>=0)?address:(address+capacity);
    }

    private Integer findAvailableIndex(int index){

        for(int i = index+1 ; i<capacity ; ++i){
            int modI = i%capacity;
            if (arrayForMap[modI] == null){
                return modI;
            }
        }
        return null;
    }

    public int getCapacity(){
        return capacity;
    }

    public double getLoadFactor(){
        double lf = (double)size/(double)capacity;
        return lf;
    }

    public double getDisplacements(){
        return numDisplacements;
    }

    public double getAvgProbes(){
        int sum = 0;
        for(Integer i : probes){
            sum = sum + i;
        }
        double avgProbes = (double)sum/(double)size;
        return avgProbes;
    }


}
