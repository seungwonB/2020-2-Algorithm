class UnionFind {
    int [] parent;

    public UnionFind(int n) {
        parent = new int[n]; //n개의 독립적인 집합
        for (int i = 0; i < n; i++) 
            parent[i] = i;        
    }

    private int root(int i) { //부모 노드를 찾는 함수
        while (i != parent[i]) {
            parent[i] = parent[parent[i]]; // 없어도 되나 빠른 속도 위하여
            i = parent[i];
        }
        return i; 
    }

    public boolean find(int p, int q) { //같은 그래프(부모)에 속해있는지
        return root(p) == root(q); //같은 집합이면 true 아니면 false
    }

    public void union(int p, int q) { //그룹합병
        int i = root(p); 
        int j = root(q);
        parent[i] = j; //i의 부모값으로 j를 넣어줌
    }
}