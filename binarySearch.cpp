// 이진 탐색

int a = 0, b = n - 1;
while (a <= b) {
	int k = (a + b) / 2;
	if (array[k] == x) {
		// 위치 k에서 x 를 찾음
	}
	if (array[k] < x) a = k + 1;
	else b = k - 1;
}

// 탐색 알고리즘
int k = 0;
for (int b = n / 2; b >= 1; b /= 2) {
	while (k + b < n && array[k + b] <= x) k += b;
}
if (array[k] == x) {
	//위치 k에서 x를 찾음
}