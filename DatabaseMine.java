public class DatabaseMine implements DatabaseInterface {

    private MyHashMap hashMap;

    public DatabaseMine(){
        hashMap = new MyHashMap();
    }

    public DatabaseMine(int N){
        hashMap = new MyHashMap(N);
    }

    @Override
    public String save(String plainPassword, String encryptedPassword) {
        hashMap.put(encryptedPassword, plainPassword);
        return encryptedPassword;
    }

    @Override
    public String decrypt(String encryptedPassword) {
        String decryptedPassword = hashMap.get(encryptedPassword);
        //System.out.println(decryptedPassword);
        if(decryptedPassword == null){
            return "";
        }
        else{
            return decryptedPassword;
        }
    }

    @Override
    public int size() {
      return hashMap.size();
    }

    @Override
    public void printStatistics() {
        System.out.println("*** DatabaseMine Statistics ***");
        System.out.println("Size is " + size() + " passwords.");
        System.out.println("Number of indexes is " + hashMap.getCapacity());
        System.out.println("Load factor is " + hashMap.getLoadFactor() );
        System.out.println("Average number of probes is " + hashMap.getAvgProbes());
        System.out.println("Number of displacements is " + hashMap.getDisplacements());
        System.out.println("*** End DatabaseMine Statistics ***");
    }
}
