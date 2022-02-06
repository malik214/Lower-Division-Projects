#include <iostream>
#include <stack>
#include <string>
#include <limits>

using namespace std;

bool isValid(string n);

int main()
{
    int num;
    string line;

    cin >> num;

    cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n'); // apparently you can't use "cin >>" and then getline() right after without this ignore line

    for (int i = 0; i < num; i++)
    {

        getline(cin, line);

        if (isValid(line) == true)
        {
            cout << "1 ";
        }
        else if (isValid(line) == false)
        {
            cout << "0 ";
        }
    }
}

bool isValid(string n)
{
    stack<char> list;
    char test;

    for (int i = 0; i < n.length(); i++)
    {
        if (n[i] == '(' || n[i] == '[' || n[i] == '<' || n[i] == '{') // if an opening bracket is found, place it on the stack
        {
            list.push(n[i]);
        }

        // if a closing bracket is found, check to see if it matches with the top of stack, and pop off the top
        switch (n[i])
        {
        case ')':
            test = list.top();
            list.pop();
            if (test == '<' || test == '[' || test == '{')
            {
                return false;
            }
            break;

        case ']':
            test = list.top();
            list.pop();
            if (test == '<' || test == '(' || test == '{')
            {
                return false;
            }
            break;

        case '>':
            test = list.top();
            list.pop();
            if (test == '(' || test == '[' || test == '{')
            {
                return false;
            }
            break;

        case '}':
            test = list.top();
            list.pop();
            if (test == '(' || test == '[' || test == '<')
            {
                return false;
            }
            break;
        }
    }

    return list.empty();
}
