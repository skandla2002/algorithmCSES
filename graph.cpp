#include <stdio.h>

int main(){
    // 그래프, 노드, 간선 으로 구성
    // 경로는 길의 경로, 사이클은 처음과 마지막 노드가 같은경로
    // 노드간 경로가 있는 경우 연결그래프
    // 그래프의 연결된 부분 -> 컴포넌트
    // 트리는 사이클 없는 연결 그래프
    // 방향 그래프에서는 간선의 한방향으로만 이동할 수 있음
    // 가중 그래프(간선의 가중치 합)
    // 두노드를 이웃이라고 함


    //     - 4 <-
    //   <-| ^  |
    // 1  -> 2 -> 3  
    // 인접 리스트 저장
    vector<int> adj[N];
    adj[1].push_back(2);
    adj[2].push_back(3);
    adj[2].push_back(4);
    adj[3].push_back(4);
    adj[4].push_back(1);

    // 가중 그래프에 대한 확장
    vector<pair<int,int>> adj[N];
    adj[1].push_back({2,5});
    adj[2].push_back({3,7});
    adj[2].push_back({4,6});
    adj[3].push_back({4,5});
    adj[4].push_back({1,2});

    // 노드에서 갈수 있는 모든 노드

}