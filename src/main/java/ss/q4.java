package ss;

public class q4 {
    public boolean isPathCrossing(String path) {
        int N = path.length();
        Set<Integer> seen = new HashSet<>();
        int x = 0;
        int y = 0;
        seen.add(x*10000+y);
        for(int i = 0; i < N; i++){
            char ch = path.charAt(i);
            if (ch == 'N'){
                y++;
            } else if (ch == 'S'){
                y--;
            } else if (ch == 'E'){
                x--;

            } else {
                x++;
            }
            if (seen.contains(x*10000+y)){
                return true;
            }
            seen.add(x*10000+y);
        }
        return false;
    }
    public static void main(String[] args) {

    }

}
