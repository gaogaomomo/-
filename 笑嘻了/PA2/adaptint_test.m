a = 0;
b = 4;
f = @(x)(x^2*exp(-5*x));
tol = 10^(-3);
[y] = adaptint(f,a,b,tol);