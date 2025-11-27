#include <iostream>
#include <limits>

std::vector <size_t> test={3,7,2,8,0,11,8,53,0,16};

template <typename TLambda>
std::vector<size_t> filter(std::vector<size_t> const & input,TLambda const & l)
{
    std::vector <size_t> result;
    for (size_t i=0;i<input.size();++i)
    {
        if (l(input[i]))
        {
            result.push_back(input[i]);
        }
    }
    return result;
}

void print_vector(std::vector<size_t> vector)
{
    for(size_t i=0;i<vector.size();++i)
    {
        std::cout << vector[i] << " ";
    }
}

int main()
{
    auto even = [] (auto const & input) {return (input+1)%2; };
    auto odd = [] (auto const & input) {return input%2; };
    auto non_zero = [] (auto const & input) {return input; };

    std::vector<size_t> res_even = filter(test,even);
    std::cout << "Even Numbers: ";
    print_vector(res_even);

    std::vector<size_t> res_odd = filter(test,odd);
    std::cout << "\nOdd Numbers: ";
    print_vector(res_odd);

    std::vector<size_t> res_non_zero = filter(test,non_zero);
    std::cout << "\nNon-Zero Numbers: ";
    print_vector(res_non_zero);
}