'use client';

import Link from 'next/link';
import { useState } from 'react';

const backendBaseUrl = process.env.NEXT_PUBLIC_BACKEND_URL || 'http://localhost:4000';

export default function SignupPage() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [message, setMessage] = useState('');
  const [error, setError] = useState('');
  const [loading, setLoading] = useState(false);

  const onSubmit = async (event) => {
    event.preventDefault();
    setMessage('');
    setError('');
    setLoading(true);

    try {
      const response = await fetch(`${backendBaseUrl}/signup`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ email, password })
      });

      const data = await response.json();

      if (!response.ok) {
        setError(data.error || 'Signup failed.');
      } else {
        setMessage(`Account created for ${data.user.email}. You can now log in.`);
        setEmail('');
        setPassword('');
      }
    } catch (networkError) {
      setError('Unable to connect to backend server.');
    } finally {
      setLoading(false);
    }
  };

  return (
    <main style={{ maxWidth: 480, margin: '0 auto', background: '#fff', padding: '1.5rem', borderRadius: 8 }}>
      <h1>Sign Up</h1>
      <form onSubmit={onSubmit} style={{ display: 'grid', gap: '0.75rem' }}>
        <label htmlFor="email">Email</label>
        <input
          id="email"
          type="email"
          value={email}
          onChange={(event) => setEmail(event.target.value)}
          required
          style={{ padding: '0.5rem' }}
        />

        <label htmlFor="password">Password</label>
        <input
          id="password"
          type="password"
          value={password}
          onChange={(event) => setPassword(event.target.value)}
          required
          style={{ padding: '0.5rem' }}
        />

        <button type="submit" disabled={loading} style={{ padding: '0.6rem' }}>
          {loading ? 'Submitting...' : 'Create Account'}
        </button>
      </form>

      {error ? <p style={{ color: '#b91c1c' }}>{error}</p> : null}
      {message ? <p style={{ color: '#166534' }}>{message}</p> : null}

      <p>
        Already have an account? <Link href="/login">Go to Login</Link>
      </p>
    </main>
  );
}
