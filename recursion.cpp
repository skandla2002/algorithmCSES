vertor<int> subset;
void search(int k) {
	if (k == n + 1) {
		//�κ������� ó���Ѵ�.
	} else	{
		//k�� �κ����տ� ���Խ�Ų��.
		subset.push_back(k);
		search(k + 1);
		subset.pop_back();
		//k�� �κ����տ� ���Խ�Ű�� �ʴ´�.
		search(k + 1);
	}
}