// AP Java: Alphabet Soup
// Dean Mosli

public class Soup {
    private String letters;
    private String company;

    // constructor
    public Soup() {
        letters = "";
        company = "none";
    }

    public void setCompany(String name) {
        company = name;
    }

    public String getCompany() {
        return company;
    }

    public String getLetters() {
        return letters;
    }

    // adds a word to the soup string
    public void add(String word) {
        letters += word;
    }

    // returns a random letter from the pool
    public char randomLetter() {
        if (letters.length() == 0) {
            return ' ';
        }
        int index = (int) (Math.random() * letters.length());
        return letters.charAt(index);
    }

    // puts the company name right in the middle
    public String companyCentered() {
        if (letters.length() == 0) {
            return company;
        }
        int mid = letters.length() / 2;
        String firstPart = letters.substring(0, mid);
        String secondPart = letters.substring(mid);
        return firstPart + company + secondPart;
    }

    // takes out the first vowel it finds
    public void removeFirstVowel() {
        for (int i = 0; i < letters.length(); i++) {
            char c = letters.charAt(i);
            // check for both lowercase and uppercase vowels
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                letters = letters.substring(0, i) + letters.substring(i + 1);
                break;
            }
        }
    }

    // removes some random chunk of letters
    public void removeSome(int num) {
        if (num > 0 && num <= letters.length()) {
            int maxStart = letters.length() - num;
            int start = (int) (Math.random() * (maxStart + 1));
            letters = letters.substring(0, start) + letters.substring(start + num);
        }
    }

    // removes a specific word if it's there
    public void removeWord(String word) {
        int loc = letters.indexOf(word);
        if (loc != -1) {
            letters = letters.substring(0, loc) + letters.substring(loc + word.length());
        }
    }
}
