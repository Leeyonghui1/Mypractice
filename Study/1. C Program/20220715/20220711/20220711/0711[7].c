#include<stdio.h>
int g = 0;  //전역변수
// 지역변수를 매개
void up1(int l)
{
	l++;
}
// 지역변수의 위치(포인터)를 매개
void up2(int* l)
{
	(*l)++;
}
// 전역변수에 접근하고 있음
void up3()
{
	g++;
}
int main()
{
	int local = 10;
	up1(local); //'local'의 값을 넘김
	printf("local=%d\n", local); // 10
	up2(&local); //'local'의 주소를 넘김
	printf("local=%d\n", local); //11
	up3(g);
	printf("g=%d\n", g); //1
	return 0;
}