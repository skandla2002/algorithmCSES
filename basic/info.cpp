#include <algorithm>
// #include <iostream>
// #include <array>
#include <map>

using namespace std;

int main() {
	
    // 1 정렬
    sort(array);

    // 2 문자열 처리
    string s = 'abc';
    // 동일 판정
    if(s == "abc") cout << "equal" << endl;
    // 문자 하나 추출
    char c = s[1]; // 'b'
    // 문자열 연결
    s = "def" + s + "ghi"; // "defabcghi"
    // 문자열 잘라내기
    s = s.substr(3,3); // "abc"

    // 3 연관 배열
    void countStrings(vector<string> s)
    {
        map<string, int> m;
        for(int i = 0 ; i < s.size() ; i++)
        {
            m[s[i]]++;
        }
        map<string, int>::iterator it = m.begin();
        while( it != m.end() )
        {
            cout << (*it).first << " " << (*it).second << endl;
            ++it;
        }
    }
}

