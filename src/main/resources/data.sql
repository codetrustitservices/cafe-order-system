CREATE TABLE IF NOT EXISTS menu_item (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    category VARCHAR(50),
    price DECIMAL(10,2),
    description TEXT,
    image_url TEXT,
    available BOOLEAN
);

DELETE FROM menu_item;

INSERT INTO menu_item (name, category, price, description, image_url, available) VALUES
('Cappuccino', 'Coffee', 120.00, 'Classic Italian coffee with steamed milk foam', 'https://images.unsplash.com/photo-1572442388796-11668a67e53d?w=400', true),
('Latte', 'Coffee', 130.00, 'Smooth espresso with steamed milk', 'https://images.unsplash.com/photo-1561882468-9110e03e0f78?w=400', true),
('Espresso', 'Coffee', 100.00, 'Strong Italian coffee shot', 'https://images.unsplash.com/photo-1510591509098-f4fdc6d0ff04?w=400', true),
('Americano', 'Coffee', 110.00, 'Espresso with hot water', 'https://images.unsplash.com/photo-1534778101976-62847782c213?w=400', true),
('Cold Coffee', 'Coffee', 140.00, 'Iced coffee with cream', 'https://images.unsplash.com/photo-1517487881594-2787fef5ebf7?w=400', true),

('Veg Sandwich', 'Snacks', 80.00, 'Fresh vegetable sandwich with cheese', 'https://images.unsplash.com/photo-1528735602780-2552fd46c7af?w=400', true),
('Cheese Burger', 'Snacks', 120.00, 'Juicy burger with cheese and veggies', 'https://images.unsplash.com/photo-1568901346375-23c9450c58cd?w=400', true),
('French Fries', 'Snacks', 60.00, 'Crispy golden fries', 'https://images.unsplash.com/photo-1576107232684-1279f390859f?w=400', true),
('Samosa', 'Snacks', 40.00, 'Traditional Indian snack', 'https://images.unsplash.com/photo-1601050690597-df0568f70950?w=400', true),
('Spring Roll', 'Snacks', 70.00, 'Crispy vegetable spring rolls', 'https://images.unsplash.com/photo-1625813506062-0aeb1d7a094b?w=400', true),

('Veg Thali', 'Meals', 180.00, 'Complete Indian vegetarian meal', 'https://images.unsplash.com/photo-1585937421612-70a008356fbe?w=400', true),
('Pasta', 'Meals', 150.00, 'Creamy white sauce pasta', 'https://images.unsplash.com/photo-1621996346565-e3dbc646d9a9?w=400', true),
('Pizza', 'Meals', 200.00, 'Cheesy vegetable pizza', 'https://images.unsplash.com/photo-1513104890138-7c749659a591?w=400', true),
('Biryani', 'Meals', 160.00, 'Aromatic vegetable biryani', 'https://images.unsplash.com/photo-1563379091339-03b21ab4a4f8?w=400', true),
('Fried Rice', 'Meals', 140.00, 'Veg fried rice with sauces', 'https://images.unsplash.com/photo-1512058564366-18510be2db19?w=400', true);
