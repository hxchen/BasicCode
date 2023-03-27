package binarySearch.firstBadVersion;

import org.junit.Test;

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while(start <= end){
            // start + end 可能会溢出
            int mid = start + (end - start)/2;
            if(isBadVersion(mid)){
                end = mid - 1;
                System.out.println(start + " - " + end);
            }else{
                start = mid + 1;
                System.out.println(start + " - " + end);
            }
        }
        return start;
    }

    @Test
    public void Test1(){
        System.out.println(firstBadVersion(2126753390)); // 214 748 364 7
    }
}
