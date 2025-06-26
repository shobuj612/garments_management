import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ETenderComponent } from './e-tender.component';

describe('ETenderComponent', () => {
  let component: ETenderComponent;
  let fixture: ComponentFixture<ETenderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ETenderComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ETenderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
