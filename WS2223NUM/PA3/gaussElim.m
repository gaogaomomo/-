function [v] = gaussElim(A,b)
[n,~]= size(A);%Da die Anzahl der Zeilen und Spalten gleich sind
for k=1:n-1
A(k+1:n,k) = A(k+1:n,k)/A(k,k);%Da k mit 2 anfängt, k ist nämlich i im Skript, 
%hier gilt diese Matrix als die Matrix für l, vielleicht nämlich Matrix L
% Das gilt vor der k-te Spalte 
A(k+1:n,k+1:n) = A(k+1:n,k+1:n)-A(k+1:n,k)*A(k,k+1:n);%Gilt direkt gleich wie im Skript,
%weiter um die Splate der Matrix yu bestimmen.
end
R=triu(A);
L=eye(n,n)+tril(A,-1);


c = vorw_einsetzen(L,b);
v = rueckw_einsetzen(R,c);

function c = vorw_einsetzen(L,b)
n = size(L,1);
c = zeros(1,n);
c(1) = b(1) / L(1,1);
for k = 2: n
    c(k) = (b(k) - L(k,(1:k-1)) * c(1:k-1)) / L(k,k);
end

function v = rueckw_einsetzen(R,c)
n = size(R,1);
v = zeros(n,1);
v(n) = c(n) / R(n,n);
for k = n-1:1
    v(k) = (c(k) - R(k,(1:k+1)) * v(1:k+1)) / R(k,k);
end
