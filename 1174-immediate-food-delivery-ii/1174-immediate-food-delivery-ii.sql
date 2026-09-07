# Write your MySQL query statement be
select 
round(sum(order_date=customer_pref_delivery_date)*100/(select count(distinct customer_id) from Delivery),2)as immediate_percentage from(
    select order_date,customer_pref_delivery_date,ROW_NUMBER() OVER (PARTITION BY customer_id ORDER BY order_date)as rn from Delivery
    )t
where  rn = 1;
#from Delivery group by customer_id order by order_date limit 1;