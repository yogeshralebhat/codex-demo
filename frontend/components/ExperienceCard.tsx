import { Experience } from "@/lib/types";

type ExperienceCardProps = {
  experience: Experience;
};

export function ExperienceCard({ experience }: ExperienceCardProps) {
  return (
    <article className="card">
      <p className="pill">{experience.city}</p>
      <h3>{experience.title}</h3>
      <p className="muted">{experience.summary}</p>
      <p className="meta">Host: {experience.hostName}</p>
      <div className="row">
        <strong>${experience.pricePerSeat}</strong>
        <span>{experience.seatsRemaining} seats left</span>
      </div>
      <button type="button">Reserve seat</button>
    </article>
  );
}
