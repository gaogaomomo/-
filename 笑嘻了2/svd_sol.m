function x = svd_sol(A,b)
r = rank(A);
[ U, S , V ] = svd(A);
[m,n] = size(S);
Sr = zeros(r,r);
S_plus = zeros(n,m);
for i = 1:r
     Sr(i,i) = S(i,i);
end
Sr_inv = inv(Sr);
S_plus(1:r,1:r) = Sr_inv(1:r,1:r);
A_plus = V*S_plus*U';
x = A_plus*b;
