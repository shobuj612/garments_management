import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CirculerComponent } from './circuler.component';

describe('CirculerComponent', () => {
  let component: CirculerComponent;
  let fixture: ComponentFixture<CirculerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CirculerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CirculerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
