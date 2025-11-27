#include <iostream>
#include <string>
#include <fstream>

std::string A;
int main(int argc, char* argv[])
{
    std::ofstream file("result.txt"); 
    for (int i=0; i< argc; i++)
    {
        file << "Argument " << i << ":" << argv[i] << "\n";

    }

    if (std::string(argv[1])== "q")
    {
        int num = std::stoi(argv[2]);
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        file << "digit Sum: " << sum << "\n";
        file.close();
        std::cout << "Result saved in output.txt " << "\n";
    }
}