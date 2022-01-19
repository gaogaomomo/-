function[z,iter,b] = NewtonV(x0,tol,maxiter)
h=10^(-6);
n=length(x0);
e=eye(n);
x=x0;
J=zeros(n,n);

iter=1;%iter fängt mit 1 an
while true %Die Iteration soll immer weitergehen, bevor die abgebrochen wird.
    xAlt=x;
    for i=1:n
        J(:,i)=(f(x+h*e(:,i))-f(x-h*e(:,i)))/(2*h);%Approximation der Jacobi-matrix
    end
    x=x-J\f(x);
    iter=iter+1;
    if norm(x-xAlt)<=tol || iter>=maxiter+1
        if iter == maxiter
            b=0;
        else
            b=1;
        end
        z=x;
        break
    end

end
function[y] = f(x)
y(1)=x(1)^2+x(2)^2+(3/5)*x(2)-4/25;
y(2)=x(1)^2-x(2)^2+x(1)-(8/5)*x(2)-7/50;
y = [y(1);y(2)];