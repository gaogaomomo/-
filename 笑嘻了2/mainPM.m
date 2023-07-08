d1 = (1:10)';
d2 = [ones(9,1); 2];
d3 = 1-2.^(-(1:0.5:5));

n1 = length(d1);
S1 = triu(diag(n1:-1:1,0) + ones(n1,n1));
A1 = S1*diag(d1,0)*inv(S1);
[lambda1,y1] = power_method(A1,S1,n1);

n2 = length(d2);
S2 = triu(diag(n2:-1:1,0) + ones(n2,n2));
A2 = S2*diag(d2,0)*inv(S2);
[lambda2,y2] = power_method(A2,S2,n2);

n3 = length(d3);
S3 = triu(diag(n3:-1:1,0) + ones(n3,n3));
A3 = S3*diag(d3,0)*inv(S3);
[lambda3,y3] = power_method(A3,S3,n3);

z1 = diag(sqrt(1:n1),0) + ones(n1,n1);
[Q1,R1] = qr(z1);
B1 = Q1*diag(d1,0)*Q1';
[mu1,x1] = power_method(B1,z1,n1);

z2 = diag(sqrt(1:n2),0) + ones(n2,n2);
[Q2,R2] = qr(z2);
B2 = Q2*diag(d2,0)*Q2';
[mu2,x2] = power_method(B2,z2,n2);

z3 = diag(sqrt(1:n3),0) + ones(n3,n3);
[Q3,R3] = qr(z3);
B3 = Q3*diag(d3,0)*Q3';
[mu3,x3] = power_method(B3,z3,n3);