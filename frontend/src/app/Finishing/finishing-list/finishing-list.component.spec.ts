import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FinishingListComponent } from './finishing-list.component';

describe('FinishingListComponent', () => {
  let component: FinishingListComponent;
  let fixture: ComponentFixture<FinishingListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FinishingListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FinishingListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
