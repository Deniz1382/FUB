#include <limits>
#include <iostream>
using namespace std; // std::cout, std::endl

//char, short, int, long, long long

int a=987654;
short b=100;
char c='c';
long d=1000000000000;
long long e=9999999999999999;

int main()
{
    cout << "int: " << sizeof(a) * CHAR_BIT << endl;
    cout << "char: " << sizeof(c) * CHAR_BIT << endl;
    cout << "short: " << sizeof(b) * CHAR_BIT << endl;
    cout << "long: " << sizeof(d) * CHAR_BIT << endl;
    cout << "long long: " << sizeof(e) * CHAR_BIT << endl;

}