import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:8083/20124fallFP', // Backend base URL
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/api/, ''), // Strip '/api' prefix
      },
    },
  },
});
