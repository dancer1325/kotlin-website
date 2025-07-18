#ifndef LIB2_H_INCLUDED
#define LIB2_H_INCLUDED

void ints(char c, short d, int e, long f);
void uints(unsigned char c, unsigned short d, unsigned int e, unsigned long f);
void doubles(float a, double b);

#endif

// if you use C++ and overloaded functions -> `extern "C"` block is missing -- https://stackoverflow.com/questions/1041866/what-is-the-effect-of-extern-c-in-c --