function y=findiffmeth()
clear all; clc; close all;
h=1/16;
N=(1/h)-1;
A=zeros(N^2,N^2);
b=zeros(N^2,1);

% get matrix A
for i=1:N^2
    A(i,i)=(1/h^2)*4;
    if i<=N^2-1
        A(i,i+1)=(1/h^2)*(-1);
        A(i+1,i)=(1/h^2)*(-1);
        if mod(i,N)==0
            A(i,i+1)=0;
            A(i+1,i)=0;
        end
    end
    if N+i<=N^2
        A(i,N+i)=(1/h^2)*(-1);
        A(N+i,i)=(1/h^2)*(-1);
    end 
    b(i,:)=1; % because fh=1, g=0
end
u=A\b;
disp(u)% solution u

% plot the graph
% convert u to matrix
P = zeros(N);
for i = 1:N
    for j = 1:N
        P(i,j) = u(i+(j-1)*N);
    end
end

wrappedP = zeros(N+2);
wrappedP(2:N+1,2:N+1) = P(1:N,1:N);

x = linspace(0,1,N+2);
y = linspace(0,1,N+2);

surf(x,y,wrappedP)

end
