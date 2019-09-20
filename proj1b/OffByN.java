public class OffByN implements CharacterComparator {
    private int Num;
    public OffByN(int N) {
        Num = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if(Math.abs(x - y) == Num) {
            return true;
        } else {
            return false;
        }
    }
}
