export const metadata = {
  title: 'Auth Demo',
  description: 'Simple signup/login demo'
};

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body style={{ fontFamily: 'Arial, sans-serif', margin: 0, padding: '2rem', background: '#f8fafc' }}>
        {children}
      </body>
    </html>
  );
}
