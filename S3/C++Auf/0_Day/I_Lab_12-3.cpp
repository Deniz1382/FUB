#include <limits>
#include <iostream>
using namespace std; // std::cout, std::endl

//char, short, int, long, long long

int main()
{
    cout << "int max:" << numeric_limits<int>::max() << endl;
    cout << "int min:" << numeric_limits<int>::min() << endl;
    cout << "unsignedint max:" << numeric_limits<unsigned int>::max() << endl;
    cout << "unsignedint min:" << numeric_limits<unsigned int>::min() << endl;
    cout << "short max:" << numeric_limits<short>::max() << endl;
    cout << "short min:" << numeric_limits<short>::min() << endl;
    cout << "char max:" << numeric_limits<char>::max() << endl;
    cout << "char min:" << numeric_limits<char>::min() << endl;
    cout << "long max:" << numeric_limits<long>::max() << endl;
    cout << "long min:" << numeric_limits<long>::min() << endl;
    cout << "long long max:" << numeric_limits<long>::max() << endl;
    cout << "long long min:" << numeric_limits<long>::min() << endl;
}