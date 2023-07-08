function B = SVD(A,r)
[U,S,V] = svd(A);
B = U(:,1:r)*S(1:r,1:r)*V(:,1:r)';
imshow(cast(B,'uint8'));