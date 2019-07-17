int read(int idx)
{
    int sum = 0;
    while(idx > 0){
        sum += tree[idx];
        idx -= (idx & -idx);
    }
    return sum;
}

// update

int tree[20];
#define MaxVal 16
void update(int idx, int val)
{
    while(idx <= MaxVal){
        tree[idx] += val;
        idx += (idx & -idx);
    }
}

// 확장

#define max_x 8
#define max_y 8

int tree[10][10];

int read(int x, int y)
{
    int sum;
    int y1;

    sum = 0;
    while (x > 0){
        y1 = y;
        while(y1 > 0 ){
            sum += tree[x][y1];
            y1 -=(y1 & -y1)
        }
    }
    return sum;
}

void update(int x, int y, int val)
{
    int y1;
    while(x <= max_x){
        y1 = y;
        while ( y1 <= max_y){
            tree[x][y1] +=val;
            y1 += (y1 & -y1)
        }
        x += (x & -x);
    }
}

int main()
{
    update(1,1,10);
    update(1,2,5);
    update(2,1,4);
    update(2,2,3);
    update(1,1,10);

    printf("%d\n", read(2,2));
}

