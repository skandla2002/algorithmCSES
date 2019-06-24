vertor<int> subset;
void search(int k) {
	if (k == n + 1) {
		//부분집합을 처리한다.
	} else	{
		//k를 부분집합에 포함시킨다.
		subset.push_back(k);
		search(k + 1);
		subset.pop_back();
		//k를 부분집합에 포함시키지 않는다.
		search(k + 1);
	}
}