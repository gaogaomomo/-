function L = cholesky(A)
n=length(A);
L=zeros(n,n);
for i=1:n
    L(i,1)=A(i,1)/L(1,1);
    L(i,i)=sqrt(A(i,i)-L(i,1:i-1)*L(i,1:i-1)');
    for k=(i+1):n
        L(k,i)=(A(k,i)-L(k,1:i-1)*L(i,1:i-1)')/L(i,i);
    end
end


