class UnionFind {
    int [] parent;

    public UnionFind(int n) {
        parent = new int[n]; //n���� �������� ����
        for (int i = 0; i < n; i++) 
            parent[i] = i;        
    }

    private int root(int i) { //�θ� ��带 ã�� �Լ�
        while (i != parent[i]) {
            parent[i] = parent[parent[i]]; // ��� �ǳ� ���� �ӵ� ���Ͽ�
            i = parent[i];
        }
        return i; 
    }

    public boolean find(int p, int q) { //���� �׷���(�θ�)�� �����ִ���
        return root(p) == root(q); //���� �����̸� true �ƴϸ� false
    }

    public void union(int p, int q) { //�׷��պ�
        int i = root(p); 
        int j = root(q);
        parent[i] = j; //i�� �θ����� j�� �־���
    }
}