#include <cstdio>
#include <string>

using namespace std;

class expression
{
public:
    virtual int eval() = 0;
    virtual char *infix() = 0;
    virtual char *postfix() = 0;
};

class constant : public expression
{
private:
    int n;

public:
    constant(int n)
    {
        this->n = n;
    }
    virtual int eval()
    {
        return n;
    }
    virtual char *infix()
    {
        char *pos = new char[100];
        sprintf(pos, "%d", n);

        return pos;
    }

    virtual char *postfix()
    {
        char *pos = new char[100];
        sprintf(pos, "%d", n);

        return pos;
    }
};

class unop : public expression
{
private:
    char op;
    expression *e;

public:
    unop(char op, expression *exp)
    {
        this->op = op;
        e = exp;
    }

    virtual int eval()
    {
        return e->eval() * -1;
    }

    virtual char *infix()
    {
        char *inf = new char[100];

        sprintf(inf, "(%c %s )", op, e->infix());

        return inf;
    }

    virtual char *postfix()
    {
        char *pos = new char[100];
        sprintf(pos, "%s u%c", e->postfix(), op);

        return pos;
    }
};

class binop : public expression
{
private:
    char op;
    expression *e1;
    expression *e2;

public:
    binop(char op, expression *exp1, expression *exp2)
    {
        this->op = op;
        e1 = exp1;
        e2 = exp2;
    }
    virtual int eval()
    {
        int result;
        switch (op)
        {
        case '/':
            result = e1->eval() / e2->eval();
            break;

        case '*':
            result = e1->eval() * e2->eval();
            break;

        case '-':
            result = e1->eval() - e2->eval();
            break;

        case '+':
            result = e1->eval() + e2->eval();
            break;
        }
        return result;
    }

    virtual char *infix()
    {
        char *inf = new char[100];

        sprintf(inf, "(%s %c %s)", e1->infix(), op, e2->infix());

        return inf;
    }

    virtual char *postfix()
    {
        char *pos = new char[100];
        sprintf(pos, "%s %s %c", e1->postfix(), e2->postfix(), op);

        return pos;
    }
};
