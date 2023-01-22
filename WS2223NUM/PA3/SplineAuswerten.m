function [i] = SplineAuswerten(x,xv,yv,vv)
n=length(xv)-1;
for j=2:n-1
    if xv(j)<x && x<xv(j+1)
        h(j)=xv(j+1)-xv(j);
        s(j)=yv(j)+(x-xv(j))*((yv(j+1)-yv(j))/(xv(j+1)-xv(j)))...
            +(x-xv(j))*(x-xv(j+1))/((h(j))^2)*...
            ((vv(j)-(yv(j+1)-yv(j))/(xv(j+1)-xv(j)))*(x-xv(j))+...
            (vv(j-1)-(yv(j+1)-yv(j))/(xv(j+1)-xv(j)))*(x-xv(j+1)));    
    end
    i=j-1;
end


