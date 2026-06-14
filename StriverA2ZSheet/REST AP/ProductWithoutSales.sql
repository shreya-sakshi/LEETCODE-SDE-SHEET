SELECT p.sku , p.product_name FROM PRODUCT p LEFT JOIN INVOICE_ITEM i ON p.id = i.product_id
WHERE i.product_id IS NULL ORDER BY p.sku ASC;

SELECT c.country_name, COUNT(i.id) AS total_invoices,
ROUND(AVG(i.total_price),6) AS avg_invoice_amount FROM country c
JOIN city ci ON c.id = ci.country_id
JOIN customer cu ON ci.id = cu.city_id
JOIN invoice i ON cu.id = i.customer_id
GROUP BY c.country_name
HAVING AVG(i.total_price) > (SELECT (AVG(total_price)) FROM invoice);

