public class OffByN implements CharacterComparator {

    private int length;

    public OffByN(int N) {
        length = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (x - y == length || y - x == length) {
            return true;
        }
        return false;
    }
}
