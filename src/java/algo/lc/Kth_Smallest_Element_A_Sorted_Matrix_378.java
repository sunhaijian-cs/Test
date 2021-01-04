package algo.lc;

import java.util.PriorityQueue;

/**
 * @Author: sunhaijian
 * @Date: 2020/7/2
 * @Description:
 **/
public class Kth_Smallest_Element_A_Sorted_Matrix_378 {

    public int kthSmallest(int[][] matrix, int k) {
        if(matrix.length==0){
            return 0;
        }
        int rows=matrix.length;
        int cols=matrix[0].length;

        PriorityQueue<Integer> minHeap=new PriorityQueue(rows*cols-k+1);
        for(int i=0;i<rows;i++){
            for(int j=0;j<rows;j++){
                minHeap.add(matrix[i][j]);
                if(minHeap.size()>rows*cols-k+1){
                    minHeap.remove();
                }
            }
        }

        return minHeap.peek();



    }
}
