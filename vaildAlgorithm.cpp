int x = -1;
for (int b = z; b >= 1; b /= 2) {
	while (!valid(x + b)) x += b;
}
int k = x + 1;