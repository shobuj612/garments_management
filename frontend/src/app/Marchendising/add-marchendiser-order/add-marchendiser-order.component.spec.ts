import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMarchendiserOrderComponent } from './add-marchendiser-order.component';

describe('AddMarchendiserOrderComponent', () => {
  let component: AddMarchendiserOrderComponent;
  let fixture: ComponentFixture<AddMarchendiserOrderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddMarchendiserOrderComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddMarchendiserOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
