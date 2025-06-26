import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CuttingTableComponent } from './cutting-table.component';

describe('CuttingTableComponent', () => {
  let component: CuttingTableComponent;
  let fixture: ComponentFixture<CuttingTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CuttingTableComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CuttingTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
