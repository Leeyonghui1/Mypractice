#include<stdio.h>
int main()
{
	int N;
	scanf("%d", &N);
	int arr[101] = { 0 };
	for (int i = 0; i < N; i++)
	{
		scanf("%d", &arr[i]);
	}
	int v;
	scanf("%d", &v);
	int count = 0;
	for (int i = 0; i < N ; i++)
	{
		if (v == arr[i])
			count++;
	}
	printf("%d", count);
	return 0;
}