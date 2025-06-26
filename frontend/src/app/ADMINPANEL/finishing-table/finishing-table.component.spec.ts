import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FinishingTableComponent } from './finishing-table.component';

describe('FinishingTableComponent', () => {
  let component: FinishingTableComponent;
  let fixture: ComponentFixture<FinishingTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FinishingTableComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FinishingTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
