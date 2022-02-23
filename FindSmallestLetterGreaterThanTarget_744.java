public class FindSmallestLetterGreaterThanTarget_744 {

    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1;
        while (low < high) {
            int middle = low + (high - low) / 2;
            if(letters[middle] <= target) low = middle + 1;
            else high = middle;
        }
        return  letters[low % letters.length];
    }
}
