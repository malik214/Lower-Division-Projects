
l-and(1,1,1).
l-and(1,0,0).
l-and(0,1,0).
l-and(0,0,0).

l-or(0,1,1).
l-or(0,0,0).
l-or(1,0,1).
l-or(1,1,1).

l-not(0,1).
l-not(1,0).

l-xor(0,0,0).
l-xor(0,1,1).
l-xor(1,0,1).
l-xor(1,1,0).

fulladdr(A,B,Cin,Sum,Cout) :-
    l-xor(A,B,X), l-xor(X,Cin,Sum), l-and(A,B,Y), l-and(X,Cin,Z), l-or(Y,Z,Cout).

fulladdrtest :-
write('A  B  Cin  Cout  Sum'), nl,
    member(A,[0,1]),
    member(B,[0,1]),
    member(Cin,[0,1]),
    fulladdr(A,B,Cin,Sum,Cout),
    write(A), write('  '),
    write(B),  write('   '),
    write(Cin), write('    '),
    write(Cout), write('     '),
    write(Sum), nl,
    fail.

    fulladdrtest.

 n-bit-addr({},{},C,{},C).

    n-bit-addr([AH|AT], [BH|BT], Cin, [SH|ST], Cout):-
    n-bit-addr(AT,BT,Cin,ST,X),
    fulladdr(AH,BH,X,SH,Cout).





