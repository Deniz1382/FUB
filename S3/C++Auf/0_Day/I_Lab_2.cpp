#include <limits>
#include <iostream>
using namespace std; 

int main()
{
    unsigned int x = numeric_limits<unsigned int>::max();
    x++;
    cout << "unsigned int max + 1:" << x << endl;
    int y = numeric_limits<int>::max();
    y++;
    cout << "int max + 1:" << y << endl;
}