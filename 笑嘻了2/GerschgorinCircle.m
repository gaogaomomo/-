clear;
clc;
%利用矩阵绘制Gerschgorin circle
%圆盘中心是对角线元素
%圆盘半径是每行元素总和

%Matrix A
A=[3, 1, 1;
   0, 6, 4;
   1, 2, 10;];
n=size(A);
nRow=n(1);
nCol=n(2);
i=1;
while (i<=nRow)
    CircleCenter(i,:)=A(i,i);
    i=i+1;
end

RowSum=sum(A,2);
R=RowSum-CircleCenter;
RealX=real(CircleCenter);
ImagY=imag(CircleCenter);

j=1;
while (j<=nRow)
    x=RealX(j,:);
    y=ImagY(j,:);
    r=R(j,:);
    scatter(x,y);
    hold on
    rectangle('Position',[x-r,y-r,2*r,2*r],'Curvature',[1,1]),axis equal
    j=j+1;
end

grid on
