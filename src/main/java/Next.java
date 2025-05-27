import java.util.Arrays;

public class Next {

    public int[] nextPermuation(int[] arr) {
        // 1234
        int n = arr.length;
        for(int i = n-1; i >=0; i--) {
            boolean found = false;
            for(int j = i + i; j < n; j++) {
                if (arr[i] < arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    return arr;
                }
            }
        }
        // just reverse
        int i = 0;
        int j = n-1;
        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return arr;
    }
//    public List<List<String>> accountsMerge(List<List<String>> acts) {
//        Map<String, String> owner = new HashMap<>();
//        Map<String, String> parents = new HashMap<>();
//        Map<String, TreeSet<String>> unions = new HashMap<>();
//        for (List<String> a : acts) {
//            for (int i = 1; i < a.size(); i++) {
//                parents.put(a.get(i), a.get(i));
//                owner.put(a.get(i), a.get(0));
//            }
//        }
//        for (List<String> a : acts) {
//            String p = find(a.get(1), parents);
//            for (int i = 2; i < a.size(); i++)
//                parents.put(find(a.get(i), parents), p);
//        }
//        for(List<String> a : acts) {
//            String p = find(a.get(1), parents);
//            if (!unions.containsKey(p)) unions.put(p, new TreeSet<>());
//            for (int i = 1; i < a.size(); i++)
//                unions.get(p).add(a.get(i));
//        }
//        List<List<String>> res = new ArrayList<>();
//        for (String p : unions.keySet()) {
//            List<String> emails = new ArrayList(unions.get(p));
//            emails.add(0, owner.get(p));
//            res.add(emails);
//        }
//
//        return res;
//    }
//    private String find(String s, Map<String, String> p) {
//        return p.get(s) == s ? s : find(p.get(s), p);
//    }


}
