import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddBuyerComponent } from './add-buyer.component';

describe('AddBuyerComponent', () => {
  let component: AddBuyerComponent;
  let fixture: ComponentFixture<AddBuyerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddBuyerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddBuyerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
