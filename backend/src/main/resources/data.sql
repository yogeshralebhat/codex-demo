INSERT INTO user_account (id, email, full_name, created_at)
VALUES
  (1, 'host@demo.com', 'Maya Chen', NOW()),
  (2, 'guest@demo.com', 'Jordan Miles', NOW())
ON CONFLICT (id) DO NOTHING;

INSERT INTO experience (id, title, summary, city, price_per_seat, seat_capacity, seats_remaining, status, host_user_id, created_at)
VALUES
  (100, 'Neon Night Photo Walk', 'Capture the city after dark with a pro photographer.', 'Tokyo', 89.00, 12, 8, 'PUBLISHED', 1, NOW()),
  (101, 'Secret Bakery Crawl', 'Taste hidden artisan bakeries and hear their stories.', 'Lisbon', 55.00, 10, 6, 'PUBLISHED', 1, NOW())
ON CONFLICT (id) DO NOTHING;
