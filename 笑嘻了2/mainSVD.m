A = double(rgb2gray(imread('tuebingen.jpg'))) ;
r = 50;
%r = 100;
%r = 200;
B = SVD(A,r);
