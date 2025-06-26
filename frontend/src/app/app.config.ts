// src/main.ts (or wherever you define appConfig)
import {
  ApplicationConfig,
  importProvidersFrom,
  provideZoneChangeDetection
} from '@angular/core';
import { provideRouter }           from '@angular/router';
import { provideHttpClient }       from '@angular/common/http';
import { FormsModule }             from '@angular/forms';   // ← import FormsModule

import { routes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideHttpClient(),
    importProvidersFrom(FormsModule),                   // ← register FormsModule
  ]
};
