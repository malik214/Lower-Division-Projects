instructor(eckert,[csc120,csc205,csc220,csc230,csc240]).
instructor(smith,[csc120,csc220,csc230]).
instructor(jones,[csc220,csc240]).
instructor(brown,[csc120]).



teaches(N,C) :-
instructor(N,L),
member(C,L).

share_class(A,B,X) :-
teaches(A,X), teaches(B,X).

share_class(A,B,C,X) :-
teaches(A,X) , teaches(B,X) , teaches(C,X).

