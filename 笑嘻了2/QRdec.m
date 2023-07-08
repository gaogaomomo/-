function y = QRdec(A)
A0 = A;
[Q,R] = qr(A0);
n = size(A);
j = 1;
while j <= n
    A = R.*Q;
    [Q,R]=qr(A);
    j = j + 1;
end
y = diag(R);   