package algo.lc.datastructure.binaryheap;

/**
 * @Author: sunhaijian
 * @Date: 2020/5/13
 * @Description:
https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/er-cha-dui-xiang-jie-shi-xian-you-xian-ji-dui-lie
二叉堆其实就是一种特殊的二叉树（完全二叉树）


 二叉堆有两个应用（1，堆排序。2，优先级队列）
 二叉堆的一种应用--优先级队列
 **/
public class Max_Priority_Queue
        <Key extends Comparable<Key>> {

    // 存储元素的数组
    private Key[] pq;

    private int N=0;

    public Max_Priority_Queue(int cap){
        pq=(Key[])new Comparable[cap+1];
    }

    public Key max(){
        return pq[1];
    }

    public void inset(Key e){
        N++;
        // 先把新元素加到最后
        pq[N]=e;
        // 然后让它上浮到正确的位置
        swim(N);
    }


    public Key delMax(){
        // 最大堆的堆顶就是最大元素
        Key max=pq[1];
        // 把这个最大元素换到最后，删除之
        exch(1,N);
        pq[N]=null;
        N--;
        // 让 pq[1] 下沉到正确位置
        sink(1);
        return max;
    }

    // 如果浮到堆顶，就不能再上浮了
    private void swim (int k){
        while (k>1&&less(parent(k),k)){
            // 如果第 k 个元素比上层大
            // 将 k 换上去
            exch(parent(k),k);
            k=parent(k);
        }
    }

    private void sink(int k ){
        // 如果沉到堆底，就沉不下去了
        while(left(k)<=N){
            // 先假设左边节点较大
            int older=left(k);
            // 如果右边节点存在，比一下大小
            if(right(k)<=N && less(older,right(k))){
                older=right(k);
            }
            // 结点 k 比俩孩子都大，就不必下沉了
            if(less(older,k)) {
                break;
            }

            exch(k,older);
            k=older;

        }
    }

    private void exch(int i,int j){
        Key temp=pq[i];
        pq[i]=pq[j];
        pq[j]=temp;
    }


    private boolean less(int i,int j){
        return pq[i].compareTo(pq[j])<0;
    }

    // 父节点的索引
    int parent(int root){
        return root/2;
    }

    // 左孩子的索引
    int left(int root){
        return root*2;
    }

    // 右孩子的索引
    int right(int root){
        return root*2+1;
    }

}
