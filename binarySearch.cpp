// ���� Ž��

int a = 0, b = n - 1;
while (a <= b) {
	int k = (a + b) / 2;
	if (array[k] == x) {
		// ��ġ k���� x �� ã��
	}
	if (array[k] < x) a = k + 1;
	else b = k - 1;
}

// Ž�� �˰���
int k = 0;
for (int b = n / 2; b >= 1; b /= 2) {
	while (k + b < n && array[k + b] <= x) k += b;
}
if (array[k] == x) {
	//��ġ k���� x�� ã��
}