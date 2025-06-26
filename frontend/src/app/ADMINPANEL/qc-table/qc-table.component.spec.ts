import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QcTableComponent } from './qc-table.component';

describe('QcTableComponent', () => {
  let component: QcTableComponent;
  let fixture: ComponentFixture<QcTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [QcTableComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(QcTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
