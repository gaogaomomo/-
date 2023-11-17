function y = collocation()
a = 1;
b = 2;
tol = 1e-3;
m = 2^1;
h = (b - a)/m;
C = @(t)[0, 1; 4/t^2, -1/t]; % umschreiben Randwertproblem von 2.Ordnung in 1. Ordnung in der linearen Form y´(t)=C(t)y(t)
I = eye(2);
y0 = [2; 0];
y1 = [17/4;0];
y_exact = @(t)(t^2 + t^(-2));
delta_y = (y1 - y0)/m;
F_prime = zeros(2*m+2,2*m+2);
A = [1,0;0,0];
B = [0,0;1,0];
delta_x = 1;
while norm(delta_x) > tol
t0 = a;
for j = 1:2:2*m
    Mj = (I - h/2 * C(t0 + h/2))^(-1)*(I + h/2 * C(t0 + h/2));
    y_tilde = Mj * y0;
    F(j:j+1,1) = y_tilde - y0;
    yj(j:j+1,1) = [y_exact(t0);0]; %exakte Lsg. von y(t)
    t0 = t0 + h; % Iteration im neuen Intervall
    F_prime(j:j+1,j:j+1) = Mj;
    F_prime(j:j+1,j+1:j+2) = -I;
    y(j:j+1,1) = y0;
    y0 = y0 + delta_y; %aktualisiere den Anfangswert
end
F(2*m+1:2*m+2,1) = [2; 17/4];
F_prime(2*m+1:2*m+2,1:2) = A;
F_prime(2*m+1:2*m+2,2*m+1:2*m+2) = B;
delta_x = -F\F_prime; %Newton Verfahren
y(2*m+1:2*m+2,1) = y1;
y = y + delta_x';%Newton Schritt
end
y_end = y(2*m+1,1);%Approximationslsg. für y(t)
max0 = 0;
for j=1:2:2*m
    max = abs(y(j) - yj(j));
    if max > max0
        max0 = max;  %Maximum vom Error suchen
    end
end
disp(max0)