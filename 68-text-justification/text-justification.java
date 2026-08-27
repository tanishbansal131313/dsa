class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < words.length) {

            // -----------------------------
            // 1. Find words that fit
            // -----------------------------
            int j = i;
            int wordsLength = 0;

            while (j < words.length &&
                   wordsLength + words[j].length() + (j - i) <= maxWidth) {

                wordsLength += words[j].length();
                j++;
            }

            int wordCount = j - i;
            int totalSpaces = maxWidth - wordsLength;

            StringBuilder line = new StringBuilder();

            // -----------------------------
            // 2. Last line / single word
            // -----------------------------
            if (j == words.length || wordCount == 1) {

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1) {
                        line.append(" ");
                    }
                }

                // Remaining spaces at the end
                while (line.length() < maxWidth) {
                    line.append(" ");
                }

            }

            // -----------------------------
            // 3. Fully justified line
            // -----------------------------
            else {

                int gaps = wordCount - 1;

                int spacesPerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1) {

                        // Base spaces
                        for (int s = 0; s < spacesPerGap; s++) {
                            line.append(" ");
                        }

                        // Extra spaces go to the left
                        if (extraSpaces > 0) {
                            line.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }

            result.add(line.toString());

            i = j;
        }

        return result;
    }
}