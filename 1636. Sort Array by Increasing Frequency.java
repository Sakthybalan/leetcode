class Solution {
    private static final byte MINV = -100, MAXV = 100;
    private static final short FSIZE = MAXV - MINV + 1;
    private static final short[] freqsv = new short[FSIZE];
    
    public static int[] frequencySort(final int[] nums) {
        for (int i = 0; i < FSIZE; i++)
            freqsv[i] = (short)(FSIZE - i);
        for (final int v : nums)
            freqsv[v-MINV] += 1 << 8;
        Arrays.sort(freqsv);
        int i = 0;
        final int VCOMP = FSIZE - MAXV;
        for (final short fv : freqsv)
            Arrays.fill(nums, i, i += (fv >> 8), VCOMP - (fv & 0xFF));
        return nums;
    }
}
