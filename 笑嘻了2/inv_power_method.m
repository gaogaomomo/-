function [lambda,y] = inv_power_method(A,mu,y0,n)
% A matrix, y0 start vector, n times of iteration
% mu approximation of lambda
i = 1;
v = y0;
I = eye(length(y0));
H = A-mu.*I;
[L,R] = lu(H);
while i <= n
    y = L \ (R \ v);% LR Zerlegung für yk+1 = inv(H)yk
    lambda_inv = max(v);
    v = y ./ lambda_inv;
    lambda = mu + 1/lambda_inv;
    i = i + 1;
end
epsilon = 1/lambda - 1/eig(A);
plot(epsilon)