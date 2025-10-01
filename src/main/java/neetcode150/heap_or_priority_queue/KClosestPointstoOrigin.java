package neetcode150.heap_or_priority_queue;

import java.util.PriorityQueue;
import java.util.Queue;

/*
You are given an 2-D array points where points[i] = [xi, yi] represents the coordinates of a point on an X-Y axis plane. You are also given an integer k.

Return the k closest points to the origin (0, 0).

The distance between two points is defined as the Euclidean distance (sqrt((x1 - x2)^2 + (y1 - y2)^2)).

You may return the answer in any order.

Input: points = [[0,2],[2,2]], k = 1

Output: [[0,2]]
Explanation : The distance between (0, 2) and the origin (0, 0) is 2. The distance between (2, 2) and the origin is sqrt(2^2 + 2^2) = 2.82842. So the closest point to the origin is (0, 2).
 */
public class KClosestPointstoOrigin {

    public int[][] kClosest(int[][] points, int k) {

        int[][] output = new int[k][points[0].length];

        if(points == null || k < 0)
            return output;

        Queue<int[]> kClosestPoints = new PriorityQueue<>((a, b) -> Integer.compare(a[0],b[0]));

        for(int i=0;i<points.length;i++) {

            int dist = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
            int[] distance = new int[]{dist,points[i][0],points[i][1]};
            kClosestPoints.add(distance);
        }

        for(int i=0;i<k;i++) {
            int[] pollVal = kClosestPoints.poll();
            output[i] = new int[]{pollVal[1],pollVal[2]};
        }

        return output;


    }
}
