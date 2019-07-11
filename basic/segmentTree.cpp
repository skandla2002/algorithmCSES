int *tree;
int A[10] = {1,4,2,3,5,1,2,4,5,3};

long long init(int index, int start, int end)
{
    if(start == end)
        tree[index] = A[start];
    else
    {
        tree[index] = init(index*2+1, start, (start+end)/2)*init(index*2+2, (start+end)/2 + 1, end );
    }
    return trr[index];
}

void main()
{
    int N = 10;
    int h = ceil(log2(N));
    int tree_size = 1 << (h + 1);

    tree = new long long[tree_size];
    init(0, 0, N-1);

    delete[] tree;
}