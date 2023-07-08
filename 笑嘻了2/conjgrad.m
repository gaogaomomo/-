function [x, err] = conjgrad(A, b, x0)
x = x0;
g = A * x - b;
d = g;
err = norm(A * x - b);

while err > 1e-3 * norm(b)
    Ad = A * d;
    alpha = (g' * g) / (d' * Ad);
    x = x - alpha * d;
    g_new = g - alpha * Ad;
    beta = -(g_new' * g_new)/(g' * g);
    d = g_new - beta * d;

    g = g_new;
    err = [err, norm(A*x-b)];
end
% Plot the error
    figure;
    semilogy(err);
    xlabel('Iteration');
    ylabel('Error');
    title('Convergence of CG Method');