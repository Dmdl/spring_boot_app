package cl.test;

import java.util.*;

public class Test1 {

    //format phone number

    public static String phoneNumber(String S) {
        String replaaceAll = S.replaceAll("\\s+", "").replaceAll("-", "");
        int temp = 3;
        int times = replaaceAll.length() / 3;
        int remains = replaaceAll.length() % 3;
        if (remains < 2) times = times - 1;
        for (int i = 0; i < times; i++) {
            replaaceAll = replaaceAll.substring(0, temp) + "-" + replaaceAll.substring(temp, replaaceAll.length());
            temp += 4;
        }
        if (remains == 1) {
            temp -= 1;
            replaaceAll = replaaceAll.substring(0, temp) + "-" + replaaceAll.substring(temp, replaaceAll.length());
        }
        return replaaceAll;
    }

    public static int bugFixBinaryPeriod(int n) {
        int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        for (p = 1; p < l; p++) {
            if (p <= l / 2) {
                int i;
                boolean ok = true;
                for (i = 0; i < l - p; i++) {
                    if (d[i] != d[i + p]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    return p;
                }
            }
        }
        return -1;
    }

    public static int siblings(int A) {
        char[] chars = String.valueOf(A).toCharArray();
        Arrays.sort(chars);
        String s = new String(chars);
        StringBuilder builder = new StringBuilder(s);
        builder = builder.reverse();
        return Integer.parseInt(builder.toString());
    }

    public static int lightBulbs(int[] A) {
        int result = 0;
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            max = A[i] > max ? A[i] : max;
            if (max == i + 1)
                result++;
        }
        return result;
    }

    public static int lightBulbs1(int[] A) {
        int turn = 0;
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (max < A[i]) {
                max = A[i];
            }
            if (max == i + 1)
                turn += 1;
        }
        return turn;
    }

    public static int binaryGap(int number) {
        String binary = Integer.toBinaryString(number);
        String[] gaps = binary.split("1");

        String biggestGap = "";
        for (int i = 0; i < (binary.endsWith("1") ? gaps.length : gaps.length - 1); i++) {

            if (gaps[i].contains("0") && gaps[i].length() > biggestGap.length())
                biggestGap = gaps[i];
        }
        return biggestGap.length();
    }

    private static int largestSequenceGap(int[] A) {
        int max = 0;
        int distence = 0;
        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i++) {
            distence = A[i + 1] - A[i];
            if (Math.abs(distence) > max) {
                max = Math.abs(distence);
            }
        }
        return max / 2;
    }

    private static int bugFixMaxOnesSpan(int[] A) {
        int n = A.length;
        int i = n - 1;
        int result = -1;
        int k = 0, maximal = 0;
        while (i > 0) {
            if (A[i] == 1) {
                k = k + 1;
                if (k >= maximal) {
                    maximal = k;
                    result = i;
                }
            } else {
                k = 0;
            }
            i = i - 1;
        }
        //if (A[i] == 1 && k + 1 > maximal) result = 0;
        if (A[i] == 1 && k + 1 >= maximal) result = 0;
        return result;
    }

    public static int arrayListLength(int[] A) {
        List<Integer> list = new ArrayList<>();
        int value = 0;
        for (int i = 0; i < A.length; i++) {
            value = (i == 0) ? A[0] : A[value];
            list.add(value);
            if (value == -1)
                break;
            ;
        }
        return list.size();
    }

    private static int arrayListLength1(int[] A) {
        int length = 1;
        int next = A[0];
        while (next != -1) {
            next = A[next];
            length += 1;
        }
        return length;
    }

    private static int cardsWar(String A, String B) {
        int solution = 0;
        char[] aChars = A.toCharArray();
        char[] bChars = B.toCharArray();
        for (int i = 0; i < aChars.length; i++) {

            int aChar = getValue(aChars[i]);
            int bChar = getValue(bChars[i]);

            if (aChar > bChar)
                solution += 1;
        }

        return solution;
    }

    private static int getValue(char charcter) {
        switch (charcter) {
            case 'A':
                return 13;
            case 'K':
                return 12;
            case 'Q':
                return 11;
            case 'J':
                return 10;
            case 'T':
                return 9;
            case '9':
                return 8;
            case '8':
                return 7;
            case '7':
                return 6;
            case '6':
                return 5;
            case '5':
                return 4;
            case '4':
                return 3;
            case '3':
                return 2;
            case '2':
                return 1;
        }

        return 0;
    }

    private static int bugFixCoins(int[] A) {
        int n = A.length;
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] == A[i + 1]) {
                result = result + 1;
            }
        }

        int reverce = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;

            if (i > 0) {
                if (A[i - 1] != A[i]) {
                    count = count + 1;
                } else {
                    count = count - 1;
                }
            }
            if (i < n - 1) {
                if (A[i] != A[i + 1]) {
                    count = count + 1;
                } else {
                    count = count - 1;
                }
            }
            reverce = Math.max(reverce, count);
        }
        return result + reverce;
    }

    private static int minDistance(int[] A) {
        Arrays.sort(A);
        int distance = A[1] - A[0];
        for (int i = 0; i < A.length - 1; i++) {

            int i1 = A[i + 1] - A[i];
            if (i1 < distance) {
                distance = i1;
            }
        }
        return distance;
    }

    private static int broCandy(int[] T) {

        int allCandy = T.length;

        Set<Integer> types = new HashSet<>();

        for (int i = 0; i < allCandy; i++) {
            types.add(T[i]);
        }

        if (types.size() < allCandy / 2)
            return types.size();
        else return allCandy / 2;

    }

    private static int broCandy1(int[] T) {
        int bro = 0;
        int half = T.length / 2;
        Set<Integer> set = new HashSet<>();
        for (int i : T) {
            set.add(i);
        }
        if (set.size() > half) {
            bro = half;
        } else {
            bro = set.size();
        }
        return bro;
    }

    private static int bugFixFindCommonMin(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;

        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0;
        for (int k = 0; k < A.length; k++) {
            if (i < m - 1 && B[i] < A[k]) {
                while (i < m - 1 && B[i] < A[k]) {
                    i += 1;
                }
            }
            if (A[k] == B[i]) {
                return A[k];
            }
        }

        return -1;
    }

    public static int prefixPermutation(int[] A) {

        int realCount = 0;
        int tempTotal = 0;

        int prefix = 0;

        for (int i = 0; i < A.length; i++) {
            realCount += i + 1;
            tempTotal += A[i];
            if (realCount == tempTotal) {
                prefix++;
            }
        }
        return prefix;
    }

    private static int prefixPermutation1(int[] A) {
        int left = 0;
        int right = 0;
        int prefix = 0;
        for (int x = 0; x < A.length; x++) {
            left += x + 1;
            right += A[x];
            if (left == right) {
                prefix++;
            }
        }
        return prefix;
    }

    public static int longestSentences(String S) {

        String[] sentencesplits = S.trim().split("[.?!]");

        int maxwords = 0;
        for (int i = 0; i < sentencesplits.length; i++) {

            String[] wordssplits = sentencesplits[i].trim().replaceAll(" +", ".").split("[.]");
            if (maxwords < wordssplits.length) {
                maxwords = wordssplits.length;
            }
        }
        return maxwords;
    }

    public static int longestSentences1(String S) {
        int maxNoOfWords = 0;
        for (String sentence : Arrays.asList(S.split("\\.|\\?|\\!"))) {
            int wordCount = 0;
            List<String> words = Arrays.asList(sentence.split("\\s+"));
            for (int i = 0; i < words.size(); i++) {
                final String word = words.get(i);
                if (!word.isEmpty())
                    wordCount++;
            }
            if (maxNoOfWords < wordCount)
                maxNoOfWords = wordCount;


        }
        return maxNoOfWords;
    }
}
