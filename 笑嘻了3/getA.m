% getA:
%   Input: mesh step size h
%   Output: matrix A (cf. script)
function [A] = getA(h)
    N = 1/h - 1;    % h = 1/(N+1)
    
    % construct diagonals:
    a = 4*ones(N^2,1);
    b = -ones(N^2-1,1);
    b(N:N:end) = 0;    % delete -1 in every N-th entry
    c = -ones(N^2-N,1);
    
    % construct A from diagonals
    A = 1/(h^2) * (diag(a) + diag(b,1) + diag(b,-1) + diag(c,N) + diag(c,-N));
    
end