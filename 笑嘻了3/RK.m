function u = RK(a, b, lambda, ua, ub, TOL, uprime)
N = 10;
h = (b - a)/N;%Sei h der Schrittweit mit N Schritte
t(1) = a;
g = @(t, v) v / lambda;
f = @(t, u) (lambda * u)^2;%Wir sind unsicher, wie die Funktionen bezüglich t gesetzt werden können.
diffu(1) = uprime;
    for i = 2 : N
        Y1 = f(t(i-1), diffu(i-1));
        Y2 = f(t(i-1) + 0.5*h, diffu(i-1) + 0.5*h*Y1);
        Y3 = f(t(i-1) + 0.5*h, diffu(i-1) + 0.5*h*Y2);
        Y4 = f(t(i-1) + h, diffu(i-1) + h*Y3);
        u(i) = u(i-1) + (1/6)*h*(Y1 + 2*Y2 + 2*Y3 + Y4);%RK4 fängt mit u' an
        K1 = g(t(i-1), u(i-1));
        K2 = g(t(i-1) + 0.5*h, u(i-1) + 0.5*h*K1);
        K3 = g(t(i-1) + 0.5*h, u(i-1) + 0.5*h*K2);
        K4 = g(t(i-1) + h, u(i-1) + h*K3);
        u(i) = u(i-1) + (1/6)*h*(K1 + 2*K2 + 2*K3 + K4);%RK4 berechnet u
        t(i) = t(i-1) + h;
        if norm(u(i) - ub) < TOL
            u = u(i);
            break
        end%Bis zum Error < TOL
    end
%Berechnen Randwert A*ua+B*ub-r=0
%A = [1, 0; 0, 0], B = [0, 0; 1, 0], C = [z, lambda*u^2]
plot(u)