import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddQcCheckComponent } from './add-qc-check.component';

describe('AddQcCheckComponent', () => {
  let component: AddQcCheckComponent;
  let fixture: ComponentFixture<AddQcCheckComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddQcCheckComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddQcCheckComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
