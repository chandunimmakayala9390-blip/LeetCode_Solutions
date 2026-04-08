#include<limits.h>
bool isPalindrome(int x) {
    long long reverse=0;
    int n=x;
    if(x<0)
    {
        return false;
    }
    while(x!=0)
    {
        int y=x%10;
        reverse=reverse*10+y;
        if(reverse>INT_MAX)
        return false;
        x=x/10;
    }
    if(n==reverse)
    return true;
    else return false;
}