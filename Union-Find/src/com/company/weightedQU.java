package com.company;

public class weightedQU {

    private int[] parentid;
    private int [] size;

    public weightedQU(int n){
        parentid = new int[n];
        size = new int[n];

        for(int i = 0; i< n; i++){
            parentid[i] = i;
            size[i] = 1;
        }
    }
//this is basically how we find p in the tree by locating its root ie we get which
    //tree it is a part of
    private int root(int p){
        while(p != parentid[p]){
           /* id[i] = id[id[i]]; this step is done for path compression
            in this way we partially flatten the tree without changing the tree to which
            the node belongs to
            */
            p = parentid[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q){
        return root(p) == root(q);
    }

    public void weightedQUnion(int p, int q){
        int rootp = root(p);
        int rootq = root(q);

        if(size[p] >= size[q]){
            parentid[rootq] = rootp;
            size[p] += size[q];
        }else {
            parentid[rootp] = rootq;
            size[q] += size[p];
        }
    }
}
