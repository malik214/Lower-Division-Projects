#include <iostream>
#include <stack>
#include <string>
#include <limits>
#include <locale>

using namespace std;

bool isValid(string n);
bool isValidEnhanced(string input, string line);

int main()
{
    int num;
    string line;
    string input;
    string brackets;
    getline(cin, input);

    // cin >> num;

    //  cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n'); // apparently you can't use "cin >>" and then getline() right after without this ignore line

    if (input[0] != '#')
    {
        num = stoi(input);

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

    if (input[0] == '#')
    {
        brackets = input.substr(1);
        cin >> num;
        cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');

        for (int i = 0; i < num; i++)
        {
            getline(cin, line);
            if (isValidEnhanced(brackets, line) == true)
            {
                cout << "1 ";
            }
            else if (isValidEnhanced(brackets, line) == false)
            {
                cout << "0 ";
            }
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

bool isValidEnhanced(string brackets, string line)
{
    stack<char> list;
    char test;
    char close;
    char opens[brackets.length()/2];
    char closes[brackets.length()/2];
    int k = 0;
    int j = 0;

    for (int i = 0; i < brackets.length(); i = i + 2, k++)
    {
        opens[k] = brackets[i];
    }

    for (int i = 1; i < brackets.length(); i = i + 2, j++)
    {
        closes[j] = brackets[i];
    }

    for (int i = 0; i < line.length(); i++)
    {
        for (int k =0; k<sizeof(opens); k++){ // if an opening bracket is found, push it on the stack
            if (line[i] == opens[k]){
                list.push(line[i]);

            }
            if (line[i] == closes[k]){  // if a closing bracket is found, pop it off the stack
                test = list.top();
                close = opens[k];
                list.pop();




            }
        }



    }



    return list.empty();
}
