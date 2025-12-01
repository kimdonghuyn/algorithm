import java.util.*;

class Q1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num = sc.nextLine();

        countingCard(num);
    }

    private static void countingCard(String num) {
        int[] count = new int[10];
        Arrays.fill(count, 0);

        int[] numbers = Arrays.stream(num.split("")).mapToInt(Integer::parseInt).sorted().toArray();

        for (int i = 0; i < numbers.length; i++) {
            count[numbers[i]]++;
        }

        int sixNine = (int) Math.ceil(((count[6] + count[9]) / 2.0));
        count[6] = sixNine;
        count[9] = sixNine;

        int maxCount = Arrays.stream(count).max().getAsInt();

        System.out.println(maxCount);
    }

}
