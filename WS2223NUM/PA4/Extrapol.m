function T=Extrapol(f,x0,H,n)
N=length(n);
T=zeros(N,N);
h=H./n;
for j=1:N
    for i=1:j
        intervall(i)=(h(j)/2)*(f(x0+(i-1)*h(j))+f(x0+i*h(j)));
        T(j,1) = sum(intervall);%Trapezregel
    end
    Fehler1(j)=T(j,1)-2;
end
for j=2:N
    for k=2:j
        T(j,k)=T(j,k-1)+((T(j,k-1)-T(j-1,k-1))/((h(j-k+1))^2/(h(j))^2-1));
    end
    Fehler2(j)=T(j,j)-2;
    Fehlerstz(j)=T(j,j)-T(j,j-1);
end
disp(Fehler1);
disp(Fehler2);
disp(Fehlerstz);

