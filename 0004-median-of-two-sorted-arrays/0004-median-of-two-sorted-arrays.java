class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int n = (n1+n2);
        int ind1 = (n1+n2)/2, ind2 = ((n1+n2)/2)-1, cnt=0;
        double cnt1Ele=0, cnt2Ele=0;
        int i=0, j=0;
        while(i < n1 && j < n2) {
            if(nums1[i] < nums2[j]) {
                if(cnt == ind1) cnt1Ele = nums1[i];
                if(cnt == ind2) cnt2Ele = nums1[i];
                cnt++; i++;
            } else {
                if(cnt == ind1) cnt1Ele = nums2[j];
                if(cnt == ind2) cnt2Ele = nums2[j];
                cnt++; j++;
            }
        }
        while(i<n1) {
            if(cnt == ind1) cnt1Ele = nums1[i];
            if(cnt == ind2) cnt2Ele = nums1[i];
            cnt++; i++;
        }
        while(j<n2) {
            if(cnt == ind1) cnt1Ele = nums2[j];
            if(cnt == ind2) cnt2Ele = nums2[j];
            cnt++; j++;
        }
        if(n%2==1) return cnt1Ele;
        else return ((cnt1Ele + cnt2Ele)/2.0);
    }
}