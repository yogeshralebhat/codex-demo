# Experience Planner (Sample Full-Stack Design)

This repository demonstrates a production-style sample web app design across architecture, database, UX, and implementation planning.

## 1) System Architecture (Spring Boot backend)

### Core capabilities
- Browse published local experiences.
- Book seats for an experience.
- Track booking status lifecycle.

### Backend components
- `ExperienceController`: REST API endpoints under `/api/experiences`.
- `ExperienceService`: business rules (availability checks, status transitions).
- JPA repositories for persistence.
- Global API exception handling for consistent errors.

### API surface (v1)
- `GET /api/experiences`: list published experiences.
- `POST /api/experiences/{id}/bookings`: reserve seats.

### Non-functional architecture notes
- Stateless API, horizontally scalable.
- PostgreSQL as source of truth.
- CORS configured for Next.js local frontend (`localhost:3000`).

## 2) Database architecture

Schema is in [`db/schema.sql`](db/schema.sql).

### Tables
- `user_account`: host/guest identities.
- `experience`: listings created by hosts.
- `booking`: transaction records between guests and experiences.

### Design highlights
- Enumerated status fields constrained via SQL CHECK constraints.
- Data integrity enforced with FK constraints.
- Query-focused indexes for listing and booking-history use-cases.

## 3) UX architecture (Next.js)

### UX goals
- Fast scanability of available experiences.
- Immediate trust signals (host, city, seats left, price).
- Clear one-click primary action.

### Frontend structure
- App Router (`frontend/app`).
- Reusable card component (`frontend/components/ExperienceCard.tsx`).
- Typed models in `frontend/lib/types.ts`.
- Mock data in `frontend/lib/mock-data.ts` as API-integration placeholder.

## 4) Technical implementation plan

Detailed rollout plan is documented in [`docs/implementation-plan.md`](docs/implementation-plan.md).

## 5) Code included

- Spring Boot backend in `backend/`.
- PostgreSQL schema in `db/`.
- Next.js frontend in `frontend/`.

## Run locally

### Backend
```bash
cd backend
mvn spring-boot:run
```

### Frontend
```bash
cd frontend
npm install
npm run dev
```

Open `http://localhost:3000`.
