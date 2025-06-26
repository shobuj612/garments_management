import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCuttingComponent } from './add-cutting.component';

describe('AddCuttingComponent', () => {
  let component: AddCuttingComponent;
  let fixture: ComponentFixture<AddCuttingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddCuttingComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddCuttingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
