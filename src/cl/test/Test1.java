package cl.test;

import java.util.Arrays;

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

    private static int sequenceGap(int[] A) {
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
}
