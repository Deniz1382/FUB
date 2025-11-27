#include <iostream>
#include<string>

enum class gender
{
    Female, Male, Divers
};
std::string to_string(gender g)
{
    switch(g)
    {
        case gender::Female: return "Female";
        case gender::Male: return "Male";
        case gender::Divers: return "Divers";
    }
}
struct person 
{
    std::string name;
    size_t age;
    gender gen;
    void print () const
    {
        std::cout << name << " identified as " << to_string(gen) << " is " << age << " years old.\n";
    }
};

int main()
{
    person test{"Deniz", 22, gender::Female};
    test.print();
}