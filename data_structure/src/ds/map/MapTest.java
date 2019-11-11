package ds.map;

import ds.bst.AVLTree;

public class MapTest {

    public static void main(String[] args) {
        Map<String, String> map = new AVLMap<String, String>();
        map.put("Rem", "Collier");
        map.put("Arthur", "Cater");
        map.put("John", "Dunnion");
        System.out.println(map);

        map = new BSTMap<String, String>();
        map.put("Rem", "Collier");
        map.put("Arthur", "Cater");
        map.put("John", "Dunnion");
        System.out.println(map);
    }
}
