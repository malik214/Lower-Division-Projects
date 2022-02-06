#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

struct node
{
    struct contact *element;
    struct node *next;
};

struct contact
{
    char name[30];
    int phone;
    char email[30];
    float salary;
};

struct node *front = NULL;
int count = 0;

void branching(char c);
int insertion();
void search();
void delete ();
void printall();
int totalMembers();
float totalSalary();

int main()
{
    char ch = 'i';

    while (ch != 'q')
    {
        printf("Enter your selection\n");
        printf("	i: insert a new entry\n");
        printf("	d: delete an entry\n");
        printf("	s: search an entry\n");
        printf("	p: print all entries\n");
        printf("	q: quit \n");

        scanf(" %c", &ch);
        branching(ch);
    }

    return 0;
}

void branching(char c)
{ // branch to different tasks
    switch (c)
    {
    case 'i':
        insertion();
        break;
    case 's':
        search();
        break;
    case 'd':
        delete ();
        break;
    case 'p':
        printall();
        break;
    case 'q':
        break;
    default:
        printf("Invalid input %d\n", c);
        break;
    }
}

int insertion()
{ // insert a new entry at the front
    struct contact *c = (struct contact *)malloc(sizeof(struct contact));

    printf("Enter name, phone, email, salary:\n");
    scanf("%s", c->name);
    scanf("%d", &(c->phone));
    scanf("%s", c->email);
    scanf("%f", &(c->salary));

    struct node *n = (struct node *)malloc(sizeof(struct node));

    n->element = c;
    n->next = front;
    front = n;

    count++;

    printf("The number of entries = %d\n", count);

    return 0;
}

void search()
{ // print phone and email via name
    char sname[30];
    struct node *retval;

    printf("please enter the name to be searched for:\n");
    scanf("%s", sname); //sname is an array, no &

    struct node *n;

    for (n = front, retval = NULL; n != NULL; retval = n, n = n->next)
    {
        if (strcmp(sname, n->element->name) == 0)
        {
            printf("phone = %d\n", n->element->phone);
            printf("email = %s\n", n->element->email);
            printf("salary = $%.2f", n->element->salary);
            return;
        }
    }

    printf("The name does not exist.\n");
}

void delete ()
{
    struct node *prev;
    struct node *n;
    int found = 0;

    char sname[30];

    printf("Enter the name to be searched for:\n");
    scanf("%s", sname); //sname is an array, no &

    for (n = front, prev = NULL; n != NULL; prev = n, n = n->next)
    {
        if (strcmp(sname, n->element->name) == 0)
        {
            found = 1;
            printf("phone = %d\n", n->element->phone);
            printf("email = %s\n", n->element->email);
            printf("salary = $%.2f\n", n->element->salary);
            break;
        }
    }

    if (!found)
    {
        printf("The name does not exist.\n");
    }
    else
    {
        if (prev == NULL)
            front = front->next;
        else
            prev->next = prev->next->next;
        count--;
    }
}

void printall()
{
    struct node *n;
    int i;
    int size;
    float total;
    float average;
    size = length(front);
    total = totalSalary(front);
    average = total / (float)size;

    printf("Members: total is %d,average salary is $%.2f\n", size, average);

    for (n = front, i = 1; n != NULL; n = n->next, i++)
    {
        printf("%2d) Name : %s\n", i, n->element->name);
        printf("    Phone: %d\n", n->element->phone);
        printf("    Email: %s\n", n->element->email);
        if (n->element->salary - average >= 1000)
        {
            printf("    Salary: [+] $%.2f\n", n->element->salary);
        }
        else if (n->element->salary - average <= -1000)
        {
            printf("    Salary: [-] $%.2f\n", n->element->salary);
        }
        else
        {
            printf("    Salary: [*] $%.2f\n", n->element->salary);
        }
    }
}

int length(struct node *front)
{
    struct node *current = front;
    if (front == NULL)
    {
        return 0;
    }
    else
    {
        return 1 + length(front->next);
    }
}

float totalSalary(struct node *front)
{
    struct node *current = front;
    float total;
    total = 0;

    if (front == NULL)
    {
        return 0;
    }
    else
    {
        total = current->element->salary;
        total = total + totalSalary(front->next);
    }
    return total;
}
