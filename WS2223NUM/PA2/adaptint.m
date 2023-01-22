function [y] = adaptint(f,a,b,tol)
n = 2; 
h = (b-a)/n;% Differenz nach Unterteilung
simpson = (b-a)/6*(f(a)+4*f((a+b)/2)+f(b));% die Darstellung von Simpsonregel von Intervall [a,b]
simpson_neu = sum((h/6)*(f(a+(n-1)*h)+4*f(a+(n-1/2)*h)+f(a+n*h)));% die Darstellung von Simpsonregel von unterteilenden Intervallen
mittelpkt = (b-a)*f((a+b)/2);% die Darstellung von Mittelpunktsregel
if abs(simpson-mittelpkt) <= tol
    y = simpson;% akzeptiere die Folge von Simpsonregel
else
    while abs(simpson-mittelpkt) > tol % Unterteile [a,b], wenn Fehler>tol
        n = n+1;
        simpson = simpson_neu;% akzeptiere unterteilendes Simpsonregel und als Ergebnis zurückgeben
    end
    y = simpson_neu;% das Ergebnis nach Fehlerabschätzung
end
