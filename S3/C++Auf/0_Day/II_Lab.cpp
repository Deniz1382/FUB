#include <iostream>
#include <string>
#include <cmath>
#include <iomanip> // set precision 
using namespace std;

int main()
{
    std::string s="foo";
    cout << "Welcome to the " << s << " program!\n";
    cout << "Enter one floating point number followed by [RETURN]\n";
    double d1;
    cin >> d1;
    cout << "round down:" << static_cast<int>(d1) << "\n";
    if (d1 >= 0)
    {
        cout << "round up:" << static_cast<int>(d1 + 0.5) << "\n";
        cout << "square root(precision 6):" << setprecision(6) << sqrt(d1) << "\n";
        cout << "square root(scientific):" << scientific << setprecision(3) << sqrt(d1) << "\n";
    }
    else 
    {
        cout << "round up:" << static_cast<int>(d1 - 0.5) << "\n";
        cout << "square root: not defined for negative numbers\n";
    }
    
}