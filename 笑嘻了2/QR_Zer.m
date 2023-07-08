function [Q,R] = QR_Zer(A)
[n,~] = size(A);
Q = zeros(n,n);
R = zeros(n,n);
V = zeros(2,n);
for i = 1:n
    alpha(i) = sqrt(A(i,i)^2+A(i+1,i)^2);
    v(:,i) = [A(i,i);A(i+1,i)]+sign(A(i,i))*alpha(i)*[1;0];
    