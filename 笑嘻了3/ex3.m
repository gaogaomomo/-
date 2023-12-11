% pr_ex3 Lukas Ringel
clear all; clc; close all;

% set mesh step size h
h = 1/16;

N = 1/h - 1;    % h = 1/(N+1)

% compute vector b for linear system Au=b (cf. script):
%   f = 1 
%   g = 0 
%   => Since g is 0, even points with neighbors on the boundary, only
%   depend on f

b = ones(N^2,1);

% get A:
A = getA(h);

% compute linear system
u = A\b;

%%%PLOTTING%%%

% convert u to matrix
P = zeros(N);
for i = 1:N
    for j = 1:N
        P(i,j) = u(i+(j-1)*N);
    end
end

% wrap P with boundary (all points 0)
wrappedP = zeros(N+2);
wrappedP(2:N+1,2:N+1) = P(1:N,1:N);

x = linspace(0,1,N+2);
y = linspace(0,1,N+2);

surf(x,y,wrappedP)