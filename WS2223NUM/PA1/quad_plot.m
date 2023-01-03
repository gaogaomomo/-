a = 0;
b = pi/2;
syms x
f(x) = cos(x)*exp(sin(x));
S = int(f(x),a,b);
N = [2,4,8,16,32,64];
regel = ["rechteck","trapez","simpson"];
for i = 1:6
    for j = 1:3
        Ih(i,j) = quadratur(f,a,b,N(i),regel(j));        
    end
end
Fehler = Ih-S;
loglog(Fehler)

