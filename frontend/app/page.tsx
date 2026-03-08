import { ExperienceCard } from "@/components/ExperienceCard";
import { mockExperiences } from "@/lib/mock-data";

export default function HomePage() {
  return (
    <main className="container">
      <header className="hero">
        <p className="eyebrow">Experience Planner</p>
        <h1>Find unforgettable local experiences</h1>
        <p>
          A demo marketplace UX designed for fast browsing, transparent pricing,
          and frictionless booking.
        </p>
      </header>

      <section className="grid">
        {mockExperiences.map((experience) => (
          <ExperienceCard key={experience.id} experience={experience} />
        ))}
      </section>
    </main>
  );
}
