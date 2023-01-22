function [b] = rechteSeite(xv,yv,v0,vn)
n=length(xv)-1;
%h=zeros(n,1);
for j=1:n
    h(j)=xv(j+1)-xv(j);
end
b(1)=3*((yv(2)-yv(1))/(xv(2)-xv(1))/h(1)+(yv(3)-yv(2))/(xv(3)-xv(2))/h(2))-v0/h(1);
b(n-1)=3*((yv(n)-yv(n-1))/(xv(n)-xv(n-1))/h(n-1)+(yv(n+1)-yv(n))/(xv(n+1)-xv(n))/h(n))-vn/h(n);
if n >= 4
    for i=2:n-2
        b(i)=3*((yv(i+1)-yv(i))/(xv(i+1)-xv(i))/h(i)+(yv(i+2)-yv(i+1))/(xv(i+2)-xv(i+1))/h(i+1));
    end
end