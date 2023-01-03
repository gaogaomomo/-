function Ih = quadratur(f,a,b,N,regel)
h = (b-a)/N;
for i = 1:N
    if regel == 'rechteck'
        Ih = h*f(a)+sum(h*f(a+i*h));
    elseif regel == 'trapez'
        Ih = sum((h/2)*(f(a+(i-1)*h)+f(a+i*h)));
    elseif regel == 'simpson'
        Ih = sum((h/6)*(f(a+(i-1)*h)+4*f(a+(i-1/2)*h)+f(a+i*h)));
    end
end