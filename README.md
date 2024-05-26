# E-Majstori

Welcome to the E-Majstori project! This repository houses the backend source code for our web application. Our platform offers workers a seamless and efficient means to connect with clients, ensuring a fast and easy experience.

## Table of Contents

- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Technologies](#technologies)

## Getting Started

To get a local copy up and running, follow these steps.

### Prerequisites

- [Docker](https://www.docker.com/get-started)
- [Dockerfile](https://docs.docker.com/reference/dockerfile/)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [Java Development Kit (JDK) 17](https://adoptopenjdk.net/)
- [Node.js](https://nodejs.org/)

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/Fazlibeqir/E-Majstori.git
    cd E-Majstori/backend
    ```

2. Build and start the Docker containers:
    ```sh
    cd local
    docker compose up -d
    ```

3. Install frontend dependencies:
 [Frontend](https://github.com/andreevskaivana/EMajstor_FE)
    ```sh
    cd EMajstor_FE
    npm install
    ```

4. Start the frontend development server:
    ```sh
    npm run dev or vite
    ```

## Usage

To use the application, navigate to `http://localhost:5173` in your web browser.
Or already hosted Frontend [`https://e-majstor-fe.vercel.app`](https://e-majstor-fe.vercel.app)

## Technologies

- **Frontend:** React+Vite
- **Backend:** Java Spring Boot
- **Database:** PostgreSQL
- **Hosting For Backend & Database:** [Render](Render.com)
- **Hosting For Frontend:** [Vercel](vercel.com)
- **Tools:** Docker, Dockerfile, Docker Compose

---

Thank you for checking out our project!

