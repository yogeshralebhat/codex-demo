# Full-Stack Auth Demo

This repository now contains a small full-stack authentication demo:

- `backend/`: Express + Sequelize + SQLite API
- `frontend/`: Next.js app with Sign Up and Login pages

## Backend

```bash
cd backend
npm install
npm run start
```

API routes:

- `POST /signup`
- `POST /login`

### `users` table/model fields

- `id`
- `email` (unique)
- `password_hash`
- `created_at`

## Frontend

```bash
cd frontend
npm install
NEXT_PUBLIC_BACKEND_URL=http://localhost:4000 npm run dev
```

Pages:

- `/signup`
- `/login`
