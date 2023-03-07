# Minimum Time to Complete Trips

You are given an array time where time[i] denotes the time taken by the ith bus to complete one trip.

Each bus can make multiple trips successively; that is, the next trip can start immediately after completing the current trip. Also, each bus operates independently; that is, the trips of one bus do not influence the trips of any other bus.

You are also given an integer totalTrips, which denotes the number of trips all buses should make in total. Return the minimum time required for all buses to complete at least totalTrips trips.

 

Example 1:

Input: time = [1,2,3], totalTrips = 5
Output: 3
Explanation:
- At time t = 1, the number of trips completed by each bus are [1,0,0]. 
  The total number of trips completed is 1 + 0 + 0 = 1.
- At time t = 2, the number of trips completed by each bus are [2,1,0]. 
  The total number of trips completed is 2 + 1 + 0 = 3.
- At time t = 3, the number of trips completed by each bus are [3,1,1]. 
  The total number of trips completed is 3 + 1 + 1 = 5.
So the minimum time needed for all buses to complete at least 5 trips is 3.
Example 2:

Input: time = [2], totalTrips = 1
Output: 2
Explanation:
There is only one bus, and it will complete its first trip at t = 2.
So the minimum time needed to complete 1 trip is 2.

# Explanation & Solution

To solve this problem, we can use binary search to find the minimum time required to complete at least totalTrips trips. We can start the binary search with a lower bound of min(time) * totalTrips / n, where n is the length of the time array. This lower bound is obtained by assuming that all buses are used equally and minimizing the time required for each bus to complete totalTrips / n trips.

We can then use binary search to find the minimum time required to complete at least totalTrips trips. In each iteration of the binary search, we calculate the number of trips that can be completed within the mid time, and compare it with totalTrips. If the number of trips is less than totalTrips, we update the left boundary of the search range. Otherwise, we update the right boundary.

Once the binary search converges, the left boundary is the minimum time required to complete at least totalTrips trips.

## Time and Space Complexity

The time complexity of the solution is O(n log k), where n is the length of the time array and k is the range of possible times, which is bounded by the sum of the time array. The space complexity of the solution is O(1).
 
