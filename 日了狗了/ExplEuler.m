function[y] = ExplEuler(a,b,N,start,mu)
h=(b-a)/N;%t=zeros(1,h+1) und t=a:N:b nämlich i-te (z1,z2)
z=zeros(2,N+1);
z(:,1)=start;
for i=1:N
    z(1,i+1)=z(1,i)+h*z(2,i);
    z(2,i+1)=z(2,i)+h*(mu*(1-(z(1,i)^2))*z(2,i)-z(1,i));
end
y=z;