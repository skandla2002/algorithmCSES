// 비트 병렬 알고리즘
// 해밍거리 : 길이가 같은 두 문자열 a, b 사이의 해밍거리는 두문자열이 일치하지 않는 위치의 개수이다.
hamming(01101, 11001) = 2;
hamming(00111, 11110) = 3;
hamming(01101, 11110) = 2;
//O(n^2k) 시간
int hamming(string a, string b){
    int d = 0;
    for(int i = 0; i < k ; i++){
        if(a[i] != b[i]) d++;
    }
    return d;
}

// 비트로 구성함을 최적화(기존 알고리즘보다 20배 빠름)
int hamming(int a, int b){
    return __builtin_popcount(a^b);
}

// 신규 알고리즘

// 그래프(깊이 우선, 너비우선), 비트,