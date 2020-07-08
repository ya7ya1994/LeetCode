class SnapshotArray {
    private TreeMap<Integer,Integer>[] data;
    private int snapId;

    public SnapshotArray(int length) {
        data = new TreeMap[length];
        for(int i = 0; i < length; i++) {
            data[i] = new TreeMap<>();
            data[i].put(0,0);
        }
    }
    
    public void set(int index, int val) {
        data[index].put(snapId,val);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        return data[index].get(data[index].floorKey(snap_id));
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
