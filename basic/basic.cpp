#include <algorithm>
#include <vector>

using namespace std;

int getMaxNum(vector<int> array)
{
    int ret = array[0];
    for(int i = 1 ; i < array.size() ; i++)
    {
        if(ret < array[i]) ret = array[i];
    }
    return ret;
}