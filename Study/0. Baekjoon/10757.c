#include<stdio.h>
#include<string.h>

void reverse(char* arr)
{
	int len = strlen(arr);
	for (int i = 0; i < len/2; i++)
	{
		char temp = arr[i];
		arr[i] = arr[len - i - 1];
		arr[len - i - 1] = temp;
	}

}
int main()
{
	static char A[10002] = { 0 };
	static char B[10002] = { 0 };
	scanf("%s %s", A, B);
	reverse(A);
	reverse(B);
	static char C[10003] = { 0 };
	int len = strlen(A) > strlen(B) ? strlen(A) : strlen(B);
	int carry = 0;
	for (int i = 0; i < len; i++)
	{
		int sum = A[i] - '0' + B[i] - '0' + carry;
		if (sum < 0)
			sum += '0';
		if (sum > 9)
			carry = 1;
		else
			carry = 0;
		C[i] = sum % 10 + '0';
	}
	if (carry == 1)
		C[len] = '1';
	reverse(C);
	printf("%s", C);
	return 0;
}