// src/app/models/user.model.ts

export interface User {
    id?: number;            // optional when creating a new user
    username: string;
    email: string;
    password?: string;      // optional if you’re not sending it back from the server
    roles: string[];        // e.g. ['ROLE_MARCH', 'ROLE_DESIGN']
  }
  