function [x, err] = pcg(A, b, x0)
n=length(A);
L=zeros(n,n);
for i=1:n
    L(i,1)=A(i,1)/L(1,1);
    L(i,i)=sqrt(A(i,i)-L(i,1:i-1)*L(i,1:i-1)');
    for k=(i+1):n
        L(k,i)=(A(k,i)-L(k,1:i-1)*L(i,1:i-1)')/L(i,i);
    end
end

x = x0;
g = b - A * x;
z = L \ (L' \ g);%Bg
d = z;
err = norm(A * x - b);

while err > 1e-3 * norm(b)
    Ad = A * d;
    alpha = (g' * z) / (d' * Ad);
    x = x + alpha * d;
    g_new = g - alpha * Ad;
    z_new = L \ (L' \ g_new);
    beta = (g_new' * z_new) / (g' * z);
    d = z_new + beta * d;

    g = g_new;
    z = z_new;
    err = [err, norm(A * x - b)];
end
figure;
semilogy(err);