vector<int> permutation;
bool chosen[n + 1];
void search() {
	if (permutation.size() == n) {
		// ������ ó���Ѵ�.
	}
	else {
		for (int i = 1; i <= n; i++) {
			if (chosen[i]) continue;
			chosen[i] = true;
			permutationn.push_back(i);
			search();
			chosen[i] = false;
			permutation.pop_back();
		}
	}
}