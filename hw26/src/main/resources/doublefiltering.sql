SELECT clients.client_id as client_id, date_of_birth, first_name, last_name FROM clients RIGHT JOIN (
    SELECT COUNT(*) as orders_amount, client_id FROM orders RIGHT JOIN (
        SELECT COUNT(*) as goods_count, orders.order_id
        FROM orders JOIN orders_goods ON orders.order_id = orders_goods.order_id
        GROUP BY orders.order_id HAVING goods_count > ?
    ) AS goods_filtered ON orders.order_id = goods_filtered.order_id GROUP BY client_id HAVING orders_amount > ?
) AS orders_filtered ON clients.client_id = orders_filtered.client_id