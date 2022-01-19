maxiter=100;
tol=10^(-5);
x1=[1,1]';
x2=[-1,-1]';
[z1,iter1,b1] = NewtonV(x1,tol,maxiter);
[z2,iter2,b2] = NewtonV(x2,tol,maxiter);