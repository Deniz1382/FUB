#include "tut2.hpp"

int main(int argc, char* argv[]){
    int n = 8;
    if (argc > 1) {
        n = std::atoi(argv[1]);
    }
    tut2 vec;
    vec.fill(n);
    vec.print();
}