CREATE TABLE IF NOT EXISTS user_account (
  id BIGSERIAL PRIMARY KEY,
  email VARCHAR(120) NOT NULL UNIQUE,
  full_name VARCHAR(80) NOT NULL,
  created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS experience (
  id BIGSERIAL PRIMARY KEY,
  host_user_id BIGINT NOT NULL REFERENCES user_account(id),
  title VARCHAR(120) NOT NULL,
  summary VARCHAR(600) NOT NULL,
  city VARCHAR(120) NOT NULL,
  price_per_seat NUMERIC(10, 2) NOT NULL CHECK (price_per_seat > 0),
  seat_capacity INTEGER NOT NULL CHECK (seat_capacity > 0),
  seats_remaining INTEGER NOT NULL CHECK (seats_remaining >= 0),
  status VARCHAR(20) NOT NULL CHECK (status IN ('DRAFT', 'PUBLISHED', 'SOLD_OUT', 'ARCHIVED')),
  created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS booking (
  id BIGSERIAL PRIMARY KEY,
  experience_id BIGINT NOT NULL REFERENCES experience(id),
  guest_user_id BIGINT NOT NULL REFERENCES user_account(id),
  seats_booked INTEGER NOT NULL CHECK (seats_booked > 0),
  status VARCHAR(20) NOT NULL CHECK (status IN ('RESERVED', 'CONFIRMED', 'CANCELLED', 'COMPLETED')),
  booked_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE INDEX IF NOT EXISTS idx_experience_status_created ON experience(status, created_at DESC);
CREATE INDEX IF NOT EXISTS idx_booking_guest_booked_at ON booking(guest_user_id, booked_at DESC);
