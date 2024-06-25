# Spring Boot with Redis POC

## Overview

This project demonstrates a Proof of Concept (POC) for using Spring Boot with Redis to implement distributed locking for scheduled jobs across multiple Kubernetes clusters using KIND (Kubernetes in Docker).

<img src="(https://github.com/Amaljeevs/springboot-redis-k8-poc/assets/85802462/16240c04-30a4-4772-a3eb-76023cfab1aa)" style="width:400px;">



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
   git clone https://github.com/Amaljeevs/springboot-redis-k8-poc.git
   cd repository

## Deployment

1. **Deploy Redis Server :** Create a Kubernetes cluster using KIND to host the Redis server

   ```bash
   kind create cluster --name redis-cluster

Deploy Redis using a YAML manifest (redis-deployment.yaml)

   ```bash
   kubectl apply -f redis-deployment.yaml --context kind-redis-cluster
   ```
2. **Deploy Spring Boot Application :** Create two Kubernetes clusters using KIND for deploying the Spring Boot application (cluster1 and cluster2)

   ```bash
   kind create cluster --name cluster1
   kind create cluster --name cluster2
Build and deploy the Spring Boot application to both clusters (cluster1 and cluster2):
   ```bash
   mvn clean package
   docker build -t springboot-redis-k8-poc .
   docker tag springboot-redis-k8-poc your-docker-hub-username/springboot-redis-k8-poc:latest
   docker push your-docker-hub-username/springboot-redis-k8-poc:latest
   kubectl apply -f application-deployment.yaml --context kind-cluster1
   kubectl apply -f application-deployment.yaml --context kind-cluster2
   ```

## Conclusion
This POC demonstrates how to leverage Redis for distributed locking in a Spring Boot application deployed across multiple Kubernetes clusters using KIND. It ensures that scheduled jobs are effectively coordinated and executed in a distributed environment.
