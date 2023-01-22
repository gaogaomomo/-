function x = vor_rueckSub(L,b)
y = vorSub(L,b);
x = rueckSub(L,y);

function y = vorSub(L,b)
n = size(L,1);
y = zeros(n,1);
for k = 1:n
    y(k) = (b(k) - L(k,(1:k-1)) * y(1:k-1)) / L(k,k);
end


function x = rueckSub(L,y)
R=L.';
n = size(R,1);
x = zeros(n,1);
for k = n:-1:1
    x(k) = (y(k) - R(k,(k+1:n)) * x(k+1:n)) / R(k,k);
end
