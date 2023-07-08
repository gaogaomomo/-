function [lambda,y] = power_method(A,y0,n)
% A matrix, y0 start vector, n times of iteration
i = 1;
v = y0;
while i <= n
    y = A * v;
    lambda = max(y);
    v = y ./ lambda;
    i = i + 1;
end
epsilon = eig(A) - lambda;
plot(epsilon)
