function FN = FFT(x)
N=length(x);
if N==1
    FN=x;
else
    x_even=x(1:2:N);%Index of x starts from 0, in Matlab starts from 1
    x_odd=x(2:2:N);
    rec1=FFT(x_even);
    rec2=FFT(x_odd).*Wn(N);
    V1=rec1+rec2;
    V2=rec1-rec2;
    FN=[V1 V2];
end

function W=Wn(N)
k=N/2;
W=exp(-2*pi*1i.*(0:k-1)/n);
