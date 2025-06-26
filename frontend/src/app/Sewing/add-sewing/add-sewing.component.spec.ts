import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddSewingComponent } from './add-sewing.component';

describe('AddSewingComponent', () => {
  let component: AddSewingComponent;
  let fixture: ComponentFixture<AddSewingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddSewingComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddSewingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
