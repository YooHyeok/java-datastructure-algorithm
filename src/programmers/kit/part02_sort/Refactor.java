package programmers.kit.part02_sort;


import java.util.Arrays;
import java.util.Comparator;

public class Refactor {


    public String solution(int[] numbers) {
        String[] strNums = new String[numbers.length];
        int index = 0;
        while (index < numbers.length) strNums[index] = String.valueOf(numbers[index++]);

        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        index = 0;
        StringBuffer sb = new StringBuffer();
        while (index < strNums.length) sb.append(strNums[index++]);
        if(sb.toString().charAt(0) == '0') return "0";
        return sb.toString();
    }

}
