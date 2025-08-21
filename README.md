# Users API

Base URL: `/api/v1/users`

## 회원가입

### **POST** `/api/v1/users/signup`
### **Request Body**
```json
{
  "loginId": "user1",
  "password": "user1"
}
```
### Responses

#### 201 Created
```json

{
  "id": 1,
  "loginId": "user1",
  "password": "user1"
}
```
#### 409 Conflict (이미 사용 중인 아이디)
```json
{
  "status": 409,
  "message": "이미 사용 중인 아이디입니다.",
  "path": "/api/v1/users/signup"
}
```

## 로그인
### POST /api/v1/users/login

### Request Body
```json
{
  "loginId": "user1",
  "password": "user1"
}
```
### Responses

#### 200 OK

```json
{
  "id": 1,
  "loginId": "user1",
  "password": "user1"
}
```
#### 401 Unauthorized (아이디/비밀번호 불일치)

```json
{
  "status": 401,
  "message": "아이디 또는 비밀번호가 일치하지 않습니다.",
  "path": "/api/v1/users/login"
}
```

## 헬스체크
### GET /api/v1/health

### Responses

#### 200 OK

```json
{
  "timestamp": "2025-08-21T10:42:52.990913+09:00",
  "service": "user-service",
  "status": "ok"
}
```
