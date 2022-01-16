function[z,iter,b] = NewtonV(x0,tol,maxiter)
h=10^(-6);
n=length(x0);
J=zeros(n);
e=eye(n);
for j=1:n
    x=x0-f(x0)/(round(f(x0+h*e(:,j))-f(x0-h*e(:,j))/(2*h)));
    J(:,j)=round(f(x+h*e(:,j))-f(x-h*e(:,j))/(2*h));    
    while norm(x(j+1)-x(j))>tol && j<=maxiter+1
          x=x-f(x)/J(:,j);
    end
    iter=j;
    z=x;
    if iter == maxiter+1
        b=0;
    else 
        b=1;
    end
end

function[y] = f(x)
y(1)=x(1)^2+x(2)^2+(3/5)*x(2)-(4/25);
y(2)=x(1)^2-x(2)^2+x(1)-(8/5)*x(2)-(7/50);
y = [y(1);y(2)];
