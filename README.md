# User CRUD API

A simple REST API to manage users with basic **CRUD operations** using an in-memory data store.

## User Model
- `id` (UUID)
- `name` (string)
- `email` (string, must be valid)
- `age` (number)

## Endpoints

| Method | Endpoint       | Description               |
|--------|----------------|---------------------------|
| POST   | `/users`       | Create a new user         |
| GET    | `/users`       | Get all users             |
| GET    | `/users/:id`   | Get user by ID            |
| PUT    | `/users/:id`   | Update user               |
| DELETE | `/users/:id`   | Delete user               |

## Features
- Input validation for `name`, `email`, `age`
- Proper HTTP status codes (`201`, `200`, `400`, `404`)
- Error handling for invalid requests or missing users

## Installation

```bash
git clone <repo-url>
cd <repo-folder>
npm install
npm start
