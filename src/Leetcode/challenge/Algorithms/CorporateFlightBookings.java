class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];
        
        
        for (int r = 0; r < bookings.length; r++) {
            
            int i = bookings[r][0];
            int j = bookings[r][1];
            
            if (j - i == 0) {
                answer[i-1] += bookings[r][2];
            }
            else if(j - i < 2) {
                answer[i-1] += bookings[r][2];
                answer[j-1] += bookings[r][2];
            }
            else {
                for (int num = i-1; num < j; num++) {
                   answer[num] += bookings[r][2];
                }
            }
            
        }
        
        return answer;
    }
}
