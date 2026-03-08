# Implementation Plan (Tech Lead View)

## Phase 1 — Foundations (Week 1)
1. Establish monorepo conventions and CI pipeline.
2. Stand up PostgreSQL with migration tooling (Flyway/Liquibase).
3. Implement baseline Spring Boot API and Next.js shell.

## Phase 2 — Core user flows (Week 2)
1. Implement experience listing with server-side pagination.
2. Implement booking with transactional seat decrement logic.
3. Add optimistic UI states for reserve action in Next.js.

## Phase 3 — Quality and reliability (Week 3)
1. Add integration tests (Testcontainers + PostgreSQL).
2. Add contract tests between frontend and backend DTOs.
3. Add observability: structured logging, traces, error budgets.

## Phase 4 — Production readiness (Week 4)
1. Add authentication (JWT + refresh token strategy).
2. Add idempotency keys for booking endpoints.
3. Introduce rate limiting and WAF rules.
4. Define SLOs and incident runbooks.

## Key risks and mitigation
- **Race conditions while booking seats** → enforce transactional boundaries and row-level locking.
- **Schema drift across environments** → enforce migrations in CI and deployment gates.
- **UX/API mismatch** → shared OpenAPI-driven code generation.

## Team ownership model
- **Backend squad**: domain logic, APIs, performance.
- **Frontend squad**: UX, accessibility, interaction design.
- **Platform squad**: CI/CD, observability, security controls.
