#include "tut2.hpp"



void tut2::fill(int n){
    for (size_t i=0;i<n;i++){
        var.push_back(i);
    }
}

void tut2::print() const{
    for (int val : var){
        std::cout << val << " ";
    }
    std::cout << "\n";

}
