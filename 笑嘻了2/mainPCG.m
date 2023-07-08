N = 4;
A = MatrixGenerator(N);
%A = sprandsym(N^2,0.2,0.1) + 2*diag(ones(N^2,1));
b = ones(N^2, 1);
[x, err] = pcg(A, b, zeros(size(b)));