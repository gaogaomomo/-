function x = newton(f, x0, TOL)
h=10^(-6);
n=length(x0);
J=zeros(n,n);
e=eye(n);
x=x0;

while true
    xAlt=x;
    for i=1:n
        J(:,i)=(f(xAlt+h*e(:,i))-f(xAlt-h*e(:,i)))/(2*h);%Approximation der Jacobi-matrix
    end
    [L,R]=LRzer(J);%  J*(x-xAlt)=-f
    b = -f(xAlt);
    c = vorw_einsetzen(L,b);
    delta_x = rueckw_einsetzen(R,c);
    x = xAlt+delta_x;
    if norm(delta_x)<=TOL
        break  
    end
end

function [L,R] = LRzer(A)%LR Zerlegung
[n,~]= size(A);
for k=1:n-1
A(k+1:n,k) = A(k+1:n,k)/A(k,k);
A(k+1:n,k+1:n) = A(k+1:n,k+1:n)-A(k+1:n,k)*A(k,k+1:n);
end
R = triu(A); 
L = eye(n,n) + tril(A,-1);

function c = vorw_einsetzen(L,b)%Vor- und Rückwärts
n = size(L,1);
c = zeros(n,1);
for k = 1: n
    c(k) = (b(k) - L(k,(1:k-1)) * c(1:k-1)) / L(k,k);
end

function delta_x = rueckw_einsetzen(R,c)
n = size(R,1);
delta_x = zeros(n,1);
for k = n:-1:1
    delta_x(k) = (c(k) - R(k,(k+1:n)) * delta_x(k+1:n)) / R(k,k);
end
