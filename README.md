# Spring Boot with Redis POC

## Overview

This project demonstrates a Proof of Concept (POC) for using Spring Boot with Redis to implement distributed locking for scheduled jobs across multiple Kubernetes clusters using KIND (Kubernetes in Docker).

### Technologies Used

- **Spring Boot:** Java-based framework for building microservices.
- **Redis:** In-memory data structure store used as a distributed cache and for distributed locking.
- **Kubernetes:** Container orchestration platform for managing containerized applications.
- **KIND (Kubernetes in Docker):** Tool for running Kubernetes clusters locally using Docker containers.

## Setup Instructions

### Prerequisites

1. **Install Docker:** Ensure Docker is installed and running on your local machine. Download Docker Desktop from [here](https://www.docker.com/products/docker-desktop).

2. **Install KIND:** Install KIND according to the instructions provided [here](https://kind.sigs.k8s.io/docs/user/quick-start/).

3. **Clone Repository:**

   ```bash
   git clone https://github.com/your/repository.git
   cd repository
