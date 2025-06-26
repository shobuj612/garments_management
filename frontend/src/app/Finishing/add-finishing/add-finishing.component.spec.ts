import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddFinishingComponent } from './add-finishing.component';

describe('AddFinishingComponent', () => {
  let component: AddFinishingComponent;
  let fixture: ComponentFixture<AddFinishingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddFinishingComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddFinishingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
