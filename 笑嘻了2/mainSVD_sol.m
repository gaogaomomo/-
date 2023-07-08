A = [1 0 1; 1 1 -1; 0 0 1; 0 1 0];
b = [1; 1; 0; 1];
x = svd_sol(A,b);
y = norm(A*x-b);