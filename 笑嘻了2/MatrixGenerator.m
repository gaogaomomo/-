function A = MatrixGenerator(N)
A = -4*diag(ones(N^2,1)) - diag(ones(N*(N-1),1),N) - diag(ones(N*(N-1),1),-N);
for i=0:N-1
    for j=1:N-1
        A(j+i*N,j+1+i*N) = -1;
        A(j+1+i*N,j+i*N) = -1;
    end
end