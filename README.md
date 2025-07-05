# UNIS-backend-project

## 개요
- EC2, RDS, Docker, GitHub Actions를 통해 HTTPS 기반으로 배포되는 백엔드 서비스를 구현
- 공통 게시판 CRUD 기능을 먼저 구현한 후 Redis 캐시 적용하여 인기 게시글 캐싱하는 서비스 구현


## 📌 기술 스택
- Language: Java 17
- Framework: Spring Boot 
- DB: Amazon RDS (MySQL)
- Caching: Redis
- Build: Gradle
- Deployment: AWS EC2 + Docker + GitHub Actions (CI/CD)
- Monitoring: ALB Health Check
- API Test: Postman

## 🧪 적용 방식
- **Redis**: 게시글 캐싱 용도로 사용 가능성 고려하여 컨테이너 구성
- **Docker + EC2**: `Dockerfile` 작성 → `docker build` 및 `run`
- **GitHub Actions**: `.github/workflows/deploy.yml` → EC2에 자동 배포
- **ALB + HTTPS**: HTTPS 리스너 + 도메인 연결 → `/health` 체크 기반

## 🌐 배포 주소
- https://giveusserverfee.site/posts
