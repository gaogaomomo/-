function A = MatrixAufstellen(n)
A=zeros(n-1,n-1);%Setzen wir die symm. und tridiago. Matrix A
A(n-1,n-1)=4;
for i=1:n-2
    A(i,i)=4;
    A(i+1,i)=1;
    A(i,i+1)=1;
end
