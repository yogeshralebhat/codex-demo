import type { Metadata } from "next";
import "./globals.css";

export const metadata: Metadata = {
  title: "Experience Planner",
  description: "Sample UX and architecture demo by Codex"
};

export default function RootLayout({ children }: { children: React.ReactNode }) {
  return (
    <html lang="en">
      <body>{children}</body>
    </html>
  );
}
