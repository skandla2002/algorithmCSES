vector<int> laze;

void update_lazy(int node, int begin, int end){
    if(lazy[node] != 0){
        tree[node] += (end-begin + 1) * lazy[node];
        if(begin != end){
            lazy[node * 2] += lazy[node];
            lazy[node * 2 + 1] += lazy[node];
        }
        lazy[node] = 0;
    }
}

int sum(int node, int begin, int end, int lefy, int right){
    update_lazy(node, begin, end);
    if(end < left || right < begind) return 0;
    if(left <= begin && end <= right) return tree[node];
    int mid = (begin + end) /2;
    return sum(node * 2, begin, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
}

void update_range(int node, int begin, int end, int left, int right, int diff) {
    update_lazy(node, begin, end);
    if (end < left || right < begin) return;
    if (left <= begin && begin <= right) {
        tree[node] += (end - begin + 1) * diff;
        if (begin != end) {
            lazy[node * 2] += diff;
            lazy[node * 2 + 1] += diff;
        }
        return;
    }
    int mid = (begin + end) / 2;
    update_range(node * 2, begin, mid, left, right, diff);
    update_range(node * 2 + 1, mid + 1, end, left, right, diff);
    tree[node] = tree[node * 2] + tree[node * 2 + 1];
}

int init(int node, int begin, int end) {
    if (begin == end) return tree[node] = data[begin];
    int mid = (begin + end) / 2;
    return tree[node] = init(node * 2, begin, mid) + init(node * 2 + 1, mid + 1, end);
}
 
void update_lazy(int node, int begin, int end) {
    if (lazy[node] != 0) {
        tree[node] += (end - begin + 1) * lazy[node];
        if (begin != end) {
            lazy[node * 2] += lazy[node];
            lazy[node * 2 + 1] += lazy[node];
        }
        lazy[node] = 0;
    }
}
 
void update_range(int node, int begin, int end, int left, int right, int diff) {
    update_lazy(node, begin, end);
    if (end < left || right < begin) return;
    if (left <= begin && begin <= right) {
        tree[node] += (end - begin + 1) * diff;
        if (begin != end) {
            lazy[node * 2] += diff;
            lazy[node * 2 + 1] += diff;
        }
        return;
    }
    int mid = (begin + end) / 2;
    update_range(node * 2, begin, mid, left, right, diff);
    update_range(node * 2 + 1, mid + 1, end, left, right, diff);
    tree[node] = tree[node * 2] + tree[node * 2 + 1];
}
 
int sum(int node, int begin, int end, int left, int right) {
    update_lazy(node, begin, end);
    if (end < left || right < begin) return 0;
    if (left <= begin && end <= right) return tree[node];
    int mid = (begin + end) / 2;
    return sum(node * 2, begin, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
}


