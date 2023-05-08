N=256;
x=(2*pi/N)*[0:N-1]'; % grid
f=sin(x)+0.2*sin(3*x)-0.2*cos(6*x); % undefined function
e=0.1*randn(N,1); % pertubation normally distributed
% with scatter 0.1
b=f+e; % perturbed values in b
bb=fft(b); % inverse FFT
n=[0:N/2-1 -N/2:-1]';
alpha=0.0001; % regularization parameter
uu=bb./(1+alpha*n.^4); % filter
u=ifft(uu); % FFT, smoothed data in u
duu=n.*bb./(1+alpha*n.^6);
du=ifft(duu);
plot(x,[real(u),f,b]); % plot f,u,b as functions of x
plot(x,[real(duu)]);
delta=norm(e)/sqrt(N);
d=norm(u-b)/sqrt(N);
