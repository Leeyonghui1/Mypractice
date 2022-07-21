#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <windows.h>
#define MAX 45 //�ζ� ���� ����
#define SIZE 6 //�ζ� ����

//void setting();

int main(void)
{
	//setting();

	int i;
	int lotto[SIZE];

	srand(time(NULL));

	//�ζ� ���� ����
	for (i = 0; i < SIZE; i++) {
		lotto[i] = (rand() % MAX) + 1; //1~45 �� ����
		//�ζ� �ߺ� ����
		for (int j = 0; j < i - 1; j++) {
			if (lotto[i] == lotto[j]) {
				i--; //�ߺ� �߻� �� i��° ���� �����
				break;
			}
		}
	}


	//�������� ���� (���� ����)
	for (int k = 0; k < SIZE; k++) {
		for (i = 0; i < SIZE - 1; i++) {
			if (lotto[i] > lotto[i + 1]) {
				int tmp = lotto[i];
				lotto[i] = lotto[i + 1];
				lotto[i + 1] = tmp;
			}
		}
	}

	//�ζ� ��ȣ ���
	printf("\n\n		������ �ζ� ��ȣ�� [");
	for (i = 0; i < SIZE; i++)
		printf("%d ", lotto[i]);
	printf("] �Դϴ�");

	system("pause");
	return 0;
}

/*
void setting() {
	//�ܼ�â ����
	system("title �ζ� ��ȣ ������");
	system("mode con cols=80 lines=5");

	//Ŀ�� ����
	HANDLE consoleHandle = GetStdHandle(STD_OUTPUT_HANDLE);
	CONSOLE_CURSOR_INFO ConsoleCursor;
	ConsoleCursor.dwSize = 1;
	ConsoleCursor.bVisible = 0; //Ŀ�� �����
	SetConsoleCursorInfo(consoleHandle, &ConsoleCursor);
}
*/