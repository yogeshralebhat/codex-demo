import Link from 'next/link';

export default function Home() {
  return (
    <main style={{ maxWidth: 480, margin: '0 auto' }}>
      <h1>Auth Demo</h1>
      <p>Use the links below to sign up or log in.</p>
      <ul>
        <li>
          <Link href="/signup">Sign Up</Link>
        </li>
        <li>
          <Link href="/login">Login</Link>
        </li>
      </ul>
    </main>
  );
}
