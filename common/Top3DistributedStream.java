package common;

import java.util.*;


/*
we have given a stream of integers which is on the multiple nodes,
need to calculate the top 3 elements how to do that?
*/


public class Top3DistributedStream {

    // Step 1: Function to find local top 3 on a node

    private static List<Integer> findLocalTop3(int[] nums) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {

            if (minHeap.size() < 3) {

                minHeap.offer(num);
            } else if (num > minHeap.peek()) {

                minHeap.poll();
                minHeap.offer(num);
            }
        }
        return new ArrayList<>(minHeap);
    }

    // Step 2: Coordinator combines and all and find top3 amongst them

    private static List<Integer> findGlobalTop3(List<List<Integer>> allLocalTops) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (List<Integer> localTop : allLocalTops) {

            for (int num : localTop) {

                if (minHeap.size() < 3) {

                    minHeap.offer(num);
                } else if (minHeap.peek() < num) {

                    minHeap.poll();
                    minHeap.offer(num);
                }
            }
        }

        // Convert to descending order list

        List<Integer> result = new ArrayList<>(minHeap);

        result.sort(Collections.reverseOrder());

        return result;
    }

    public static void main(String[] args) {

        // Simulating data on 3 nodes
        int[] node1 = {5, 9, 1, 3, 7};
        int[] node2 = {10, 2, 11, 6};
        int[] node3 = {15, 8, 4, 12};

        // Step 1: Each node computes its local top 3
        List<Integer> top3Node1 = findLocalTop3(node1);
        List<Integer> top3Node2 = findLocalTop3(node2);
        List<Integer> top3Node3 = findLocalTop3(node3);

        // Print local top 3s
        System.out.println("Node 1 top 3: " + top3Node1);
        System.out.println("Node 2 top 3: " + top3Node2);
        System.out.println("Node 3 top 3: " + top3Node3);


        // Coordinator to combines all local top 3s to get Global top 3

        List<List<Integer>> allLocalTop3s = List.of(top3Node1, top3Node2, top3Node3);

        List<Integer> globalTop3 = findGlobalTop3(allLocalTop3s);

        System.out.println(globalTop3);
    }
}
