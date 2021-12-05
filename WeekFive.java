import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class WeekFive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("第一题");
        System.out.print("x = ");
        int a = in.nextInt();
        System.out.println(Reverse(a));
        System.out.println("第二题");
        int b = in.nextInt();
        System.out.println(ClimbStairs(b));
        System.out.println("第三题");
        //输入形式为1,2,3
        String string = in.next();
        String[] arr = string.split(",");
        int[] nums = new int[arr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        List<List<Integer>> sets = subsets(nums);
        System.out.println(sets);
    }
    public static int Reverse(int x){
        if(x==0) return 0;
        long res = 0;
        while (x != 0){
            res = res * 10 + x % 10;
            x /= 10;
        }
        if (res>Math.pow(2,31)-1 || res<Math.pow(-2,31)) res=0;
        return (int)res;
    }
    public static int ClimbStairs(int n) {
        int[] res = new int[n+1];
        res[0] = res[1] = 1;
        for(int i=2 ; i <= n ; i++){
            res[i] = res[i-1] + res[i-2];
        }
        return res[n];
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = (int)Math.pow(2, nums.length);
        for (int i = 0; i<n; i++) {
            String s = Integer.toBinaryString(i);
            List<Integer> temp = new ArrayList<>();
            for (int j = s.length() - 1; j >= 0; j--) {
                if (s.charAt(j) == '1') {
                    temp.add(nums[s.length()-1-j]);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
