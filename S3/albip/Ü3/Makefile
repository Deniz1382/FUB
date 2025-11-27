CXX=/usr/bin/g++
LDFLAGS =
CPPFLAGS = 
INC =
CXXFLAGS = -std=c++17 -Wall -pedantic -O3 -D_GLIBCXX_ASSERTIONS -g -fsanitize=address

%.o: %.cpp
	${CXX} ${CXXFLAGS} -I . -c $*.cpp
	

aufgabe3_main: aufgabe3.o aufgabe3_main.o
	${CXX} ${CXXFLAGS} -I . $^ -o aufgabe3_main

aufgabe3_test: aufgabe3.o aufgabe3_test.o
	${CXX} ${CXXFLAGS} -I . $^ -o aufgabe3_test
  
aufgabe3_bench: aufgabe3.o aufgabe3_bench.o
	${CXX} ${CXXFLAGS} -I . $^ -o aufgabe3_bench
