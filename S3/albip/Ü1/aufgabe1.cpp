#include <iostream>
#include <utility>
#include <string>
#include <fstream> //for file input
#include "aufgabe1.hpp"

/// compute the complement for input @p x from alphabet {ACGT}
char complement(char const x){
    switch(x){
        case 'A': return 'T';
        case 'T': return 'A';
        case 'G': return 'C';
        case 'C': return 'G';
        default : return x; //returns the same letter, just in case 
    }
}

/// read a FASTA entry from a file, returning a pair containing meta data and sequence (without linebreaks or whitespace)
/// Returns a pair with empty strings if @p in_file is not readable 
std::pair<std::string, std::string> readFasta(std::string const& in_file){
    std::ifstream file(in_file);
    if (!file.is_open()) {
        return {"", ""}; //return pair if file not readable
    }
    std::string meta; 
    std::string sequence;
    std::string line; 
    //separate meta and sequence
    while (std::getline(file,line)){
        if (line.size() == 0) continue;
        if(line[0]== '>'){ meta=line;}
        else {sequence.append(line);}
    }
    //delete whitespace or linebreaks 
    std::string clean_sequence;
    for (size_t i = 0; i < sequence.size(); i++)
    {
        switch (sequence[i]){
            case 'A' : clean_sequence+='A'; break;
            case 'T' : clean_sequence+='T'; break;
            case 'G' : clean_sequence+='G'; break;
            case 'C' : clean_sequence+='C'; break;
            default : break;
        }
    }
    sequence=clean_sequence;
    file.close();
    return {meta,sequence};
}

/// write a FASTA entry to file
/// Upon writing, sequence is split such that each line is 80 characters long (the last line can be shorter of course)
/// Return true on success, false otherwise (e.g. @p out_file not writable)
bool writeFasta(std::string const& out_file,std::string const& meta,std::string const& seq){
    std::ofstream output(out_file);
    if(!output.is_open()){
        return false;
    }

    output << meta << "\n";
    for(size_t i=0; i < seq.size(); i+=80){
        //last line if
        if ((seq.size()-i)<80){
            std::string substring = seq.substr(i,seq.size());
            output << substring << "\n";
        }
        std::string substring = seq.substr(i,80);
        output << substring << "\n";
    }
    output.close();
    return true;
}

/// read a FASTA file with a single sequence, and store the sequence's reverse complement in @p output_file
/// Uses @p readFasta() and @p writeFasta() internally.
/// Returns true on success, false otherwise (in_file not readable, or out_file not writable)
bool reverseComplementFASTA(std::string const& input_file,std::string const& output_file){
    auto [meta,sequence] =readFasta(input_file); 
    if (meta.empty() && sequence.empty()) return false; //check if it's not empty

    size_t i=sequence.size();
    std::string out;
    out.reserve(sequence.size()); //faster outcome

    while (i>0){ //reverse complement loop
        --i;
        char temp=complement(sequence[i]);
        out.push_back(temp);
    }
    bool result=writeFasta(output_file, meta, out);
    return result;
}




