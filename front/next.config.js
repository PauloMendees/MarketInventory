/** @type {import('next').NextConfig} */
const nextConfig = {
  reactStrictMode: true,
  generateBuildId: async () => {
      if (process.env.BUILD_ID) {
          return process.env.BUILD_ID;
      } else {
          return `${new Date().getTime()}`;
      }
  }
};

module.exports = nextConfig;