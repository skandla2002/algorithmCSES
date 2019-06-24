#include <iostream>
#include <array>

using namespace std;

int main() {
	long int n;
	cin >> n;
	std:array<int, n> myArray;
	int max = myArray.max_size();
	for(int i = 0; i < max ; ++i)
		cout << n << " ";
		myArray[n] = 1
	}
	for (int i = 0; i < max; ++i) {
		if (myArray[i] != 1) {
			cout << i << " ";
		}
	}
	cout << "\n";
}
